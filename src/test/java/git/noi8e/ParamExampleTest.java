package git.noi8e;

import git.noi8e.page.YaMarketPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;


public class ParamExampleTest {


    YaMarketPage yaMarketPage = new YaMarketPage();

    @ValueSource(strings = {
            "Монитор",
            "Телефон",
            "Макароны",
            "Ноутбук"
    })
    @ParameterizedTest(name = "Search with value: {0}")
    void canSearchByValueSource(String value) {
        yaMarketPage.openYaMarketPage(YaMarketPage.URL)
                .putValueInSearhInput(value)
                .submitSearchForm()
                .checkResult(value);
    }

    @CsvSource(value = {
            "Монитор; DELL",
            "Телефон; SAMSUNG",
            "Макароны; BARILLA",
            "Ноутбуки; LENOVO"
    }, delimiter = ';')
    @ParameterizedTest(name = "Search test with CsvSource: {0}, {1}")
    void searchTestWithCsvSource(String type, String manufacturer) {
        yaMarketPage.openYaMarketPage(YaMarketPage.URL)
                .putValueInSearhInput(type + " " + manufacturer)
                .submitSearchForm()
                .checkResult(type);
    }
    


//    static Stream<Arguments> testWithMethodSource() {
//        return Stream.of(
//                Arguments.of(
//                        0, "Монитор"
//                ),
//                Arguments.of(
//                        1, "Телефон"
//                ),
//                Arguments.of(
//                        2, "Макароны"
//                ),
//                Arguments.of(
//                        3, "Ноутбук"
//                )
//        );
//    }


}
