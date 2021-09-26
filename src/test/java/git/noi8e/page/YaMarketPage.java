package git.noi8e.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YaMarketPage {

    public static final String URL = "https://market.yandex.ru/";
    public static final String LOGO_TEXT = "Маркет";


    private SelenideElement searchInput = $("#header-search");
    private SelenideElement logo = $("#logoPartMarket");
    private SelenideElement searchSubmitButton = $x("//span[contains(text(),'Найти')]");
    private SelenideElement catalogBtn = $x("//span[contains(text(),'Каталог')]");
    private SelenideElement region = $("[data-zone-name='region-select']");
    private SelenideElement searchResultTitle = $("div").$("h1");

    public YaMarketPage openYaMarketPage(String url) {
        open(url);
        logo.shouldBe(visible);
        return this;
    }

    public YaMarketPage putValueInSearhInput(String value) {
        searchInput.setValue(value);
        return this;
    }

    public YaMarketPage submitSearchForm() {
        searchSubmitButton.click();
        return this;
    }
    public YaMarketPage checkResult(String s) {
        searchResultTitle.shouldBe(visible);
        searchResultTitle.find(byText(s));
        return this;
    }


}
