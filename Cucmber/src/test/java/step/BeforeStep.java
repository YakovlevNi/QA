package step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {


    @Given("Открываем сайт {string}")
    public void открываемСайт(String url) {
        Selenide.open(url);
    }


}



