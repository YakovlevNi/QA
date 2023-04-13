package Api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Спецификация для запросов
 */
public class Spec {
    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder().setBaseUri(url).setContentType(ContentType.JSON).build();
    }

    public static ResponseSpecification responseSpecification200() {
        return new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    public static void installSpec(RequestSpecification requestSpecification,ResponseSpecification responseSpecification){
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;

    }
}
