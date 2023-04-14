package step;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.an.E;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;

public class TestSteps {
    private final SelenideElement infoList = $x("/html/body/div[3]/div[1]/div[1]/div[1]/div/div/a");
    private final SelenideElement docs = $x("/html/body/div[3]/div[1]/div[1]/div[1]/div/div/div/div/ul/li[3]/a");
    private final SelenideElement cookie = $x("//button[@onclick=\"cookieMsg.set('accepted')\"]");
    private final SelenideElement katanaList=$x("/html/body/div[5]/div/div/div[2]/a");
    private final SelenideElement katanaBtn=$x("/html/body/div[5]/div/div/div[2]/div/dl/dd[1]/div[2]/a");


    @When("Нажимаем на выпадающий список")
    public void clickOnDocList() {
        if(cookie.isDisplayed()){
            cookie.click();
        }
        infoList.scrollIntoView(true).click();

    }

    @When("Нажимаем на кнопку документация")
    public void clickOnDocBtnInfo() {
        if(docs.isDisplayed()){
            docs.click();
        } else {
            throw new RuntimeException("Окно документации не отображено");
        }
    }

    @When("Нажимаем на выпадающий список Dr.Web Katana \\(если отображается на странице)")
    public void clickOnKatanaList() {
        katanaList.scrollTo().click();
    }

    @When("Нажимаем на кнопку чтения документации")
    public void clickOnKatanaReadDoc() {
        katanaBtn.click();
    }
}

