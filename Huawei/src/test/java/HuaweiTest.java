import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Главная страница сайта Huawei
 */
public class HuaweiTest extends BaseTest {
    private final String URL = "https://www.huawei.ru/";
    CustomerPage customerPage = new CustomerPage(URL);

    /**
     * Проверка отображения информации в графе O Huawei
     */
    @Test
    public void checkInfoOnSite() {

        List<String> expectedAttributes = new ArrayList<>();
        for (String s : Arrays.asList("Новости", "Корпоративная информация", "Мероприятия", "Пресс-центр", "Вакансии")) {
            expectedAttributes.add(s);
        }
        Assert.assertArrayEquals(expectedAttributes.toArray(), customerPage.getTitles().toArray());
    }

    /**
     * Проверка перехода по ссылкам в графе O Huawei
     */
    @Test
    public void openAllLinks() throws InterruptedException {
        customerPage.checkLinks();


    }
}
