package git.noi8e;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase extends TestData {
    @BeforeAll
    static void sayHello() {
        System.out.println("Hi this is simple test for ya.market\n");
    }
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://market.yandex.ru/";
    }

    @AfterAll
    static void sayGoodBye() {
        System.out.println("Bye guys!");
        Selenide.closeWebDriver();
    }

}
