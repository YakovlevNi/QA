import org.junit.Test;

public class SiteTest extends BaseTest {
    private final static String LINK = "https://servionica.ru/";
    MainPage mainPage = new MainPage(LINK);

    @Test
    public void checkOrderButton() {
        mainPage.clickOnButton();

    }
    @Test
    public void checkOrderForm() {
        mainPage.formType("Nikita", "yakovlev_ni@mail.ru", "\"9250266607\"");

    }
}
