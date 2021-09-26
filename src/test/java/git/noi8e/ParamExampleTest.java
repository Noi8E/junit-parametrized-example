package git.noi8e;

import git.noi8e.domain.ItemsForSearch;
import git.noi8e.page.YaMarketPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static git.noi8e.page.YaMarketPage.URL;

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
        yaMarketPage.openYaMarketPage(URL)
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
        yaMarketPage.openYaMarketPage(URL)
                .putValueInSearhInput(type + " " + manufacturer)
                .submitSearchForm()
                .checkResult(type);
    }

    @EnumSource(ItemsForSearch.class)
    @ParameterizedTest(name = "search with EnumClass: {0}")
    void searchWithEnumExample(ItemsForSearch items) {
        yaMarketPage.openYaMarketPage(URL)
                .putValueInSearhInput(items.getDescription())
                .submitSearchForm()
                .checkResult(items.getDescription());
    }


    @MethodSource("stringProvider")
    @ParameterizedTest()
    void searchWithMethodSource(String s) {
        yaMarketPage.openYaMarketPage(URL)
                .putValueInSearhInput(s)
                .submitSearchForm()
                .checkResult(s);

    }

    static Stream<String> stringProvider() {
        return Stream.of("мониторы DELL", "телефон SAMSUNG", "макароны BARILLA", "ноутбук LENOVO");
    }

}
