import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта Сервионика
 */
public class MainPage {
    private final SelenideElement button = $x("//*[@id=\"rec264617959\"]/div[1]/div/div[3]/div[1]/div/div/div[2]/a[1]");
    public final SelenideElement nameInput = $x("//input[@placeholder=\"Ваше имя\"]");
    public final SelenideElement eMailInput = $x("//input[@placeholder=\"Ваш имейл\"]");
    public final SelenideElement number = $x("//input[@placeholder=\"(999) 999-99-99\"]");


    public MainPage(String url) {
        Selenide.open(url);
    }

    /**
     * Проверка на нажатие кнопки "Запросить услугу" в ячейке Обслуживание ИТ-инфраструктуры
     */
    public void clickOnButton() {
        button.scrollIntoView(false);
        button.click();
        Selenide.sleep(500);
        Selenide.screenshot("click");
    }

    /**
     * Проверка возможности ввода данных во всплывающем окне заявки
     */

    public void formType(String name, String email, String phone) {
        clickOnButton();
        nameInput.setValue(name);
        Selenide.screenshot("Name");
        eMailInput.setValue(email);
        Selenide.screenshot("Email");
        number.setValue(phone);
        Selenide.screenshot("Phone");
    }


}


