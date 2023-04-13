import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.devtools.SeleniumCdpConnection;
import org.openqa.selenium.manager.SeleniumManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CustomerPage {
    private final SelenideElement smartphoneTitle = $x("//a[@class=\"footer-nav__link\"][@href=\"/about/\"]");
    private final SelenideElement news = $x("//a[@class=\"footer-nav__link\"][@href=\"/news/\"]");
    private final SelenideElement activated = $x("//a[@class=\"footer-nav__link\"][@href=\"/events/\"]");
    private final SelenideElement pressCentre = $x("//a[@class=\"footer-nav__link\"][@href=\"/press-center/\"]");
    private final SelenideElement hr = $x("//a[@class=\"footer-nav__link\"][@href=\"/hr/\"]");
    private final ElementsCollection hrefList = $$x("//a[@class=\"footer-nav__link\"][@href]");

    public CustomerPage(String url) {
        Selenide.open(url);
    }

    public List<String> getTitles() {
        List<String> titlesList = new ArrayList<>();
        for (SelenideElement selenideElement : Arrays.asList(news, smartphoneTitle, activated, pressCentre, hr)) {
            titlesList.add(selenideElement.getText());
        }
        return titlesList;
    }

    public void checkLinks() {
        List<String> links = new ArrayList<>();
        for (SelenideElement selenideElement : hrefList) {
            links.add(selenideElement.getAttribute("href"));
        }
        links.remove(5);
        links.forEach(Selenide::open);
    }

}
