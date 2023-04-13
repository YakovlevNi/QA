package Api;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Tests {
    private final static String URL = "https://reqres.in/";

    /**
     * Проверка GET запроса json
     */
    @Test
    public void checkAvatarsAndIdTest() {
        Spec.installSpec(Spec.requestSpecification(URL), Spec.responseSpecification200());
        List<UserData> users = given().when()
                .get("api/users?page=2").then()
                .log().all().extract().body().jsonPath()
                .getList("data", UserData.class);
        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assert.assertTrue(users.stream().allMatch(userData -> userData.getFirst_name().matches("\\D+")));
    }

    /**
     * Проверка регистрации при Post запросе
     */
    @Test
    public void registry() {
        Spec.installSpec(Spec.requestSpecification(URL), Spec.responseSpecification200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Registr user = new Registr("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given().body(user).when().post("api/register").then().log().all().extract().as(SuccessReg.class);
        Assert.assertEquals(id,successReg.getId());
        Assert.assertEquals(token,successReg.getToken());
    }
}
