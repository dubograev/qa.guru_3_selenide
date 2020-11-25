package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    String testURL = "https://alfabank.ru";

    @Test
    void checkNumberOfArchivedDeposits() {
        Configuration.startMaximized = true;
        int expectedNumber = 5;

        open(testURL);
        $$(byText("Вклады")).find(visible).click();
        $("#breadcrumbs").$(byText("Счета и депозиты")).shouldBe(visible);
        $$(byText("Депозиты")).find(visible).parent().click();
        $(byText("Архивные счета и депозиты")).click();
        $$(byText("Депозиты")).find(visible).click();
        $("#filter").findAll("[data-widget-name=CatalogCard]").shouldHaveSize(expectedNumber);
    }

    @Test
    void vkladyiStrahovanieSiblingPreceding() {
        open(testURL);
        $$(byText("Вклады")).find(visible).click();
        SelenideElement element = $("[data-test-id=tabs-list-tabTitle-0]").sibling(1).preceding(0);
        element.click();
        element.shouldHave(cssValue("background-color", "rgba(11, 31, 53, 1)"));
    }

    @Test
    void vkladyiStrahovanieClosest() {
        open(testURL);
        $$(byText("Вклады")).find(visible).click();
        SelenideElement element = $("[data-test-id=tabs-list-tabTitle-1]");
        element.click();
        element.closest("div").shouldHave(attribute("data-test-id", "tabs-list"));
    }

    @Test
    void vkladyiStrahovanieParent() {
        open(testURL);
        $$(byText("Вклады")).find(visible).click();
        SelenideElement element = $("[data-test-id=tabs-list-tabTitle-1]");
        element.click();
        element.parent().shouldHave(attribute("data-test-id", "tabs-list"));
    }

    @Test
    void TEST() {
        open("https://alfabank.ru/make-money/");
        $(byText("Страхование вкладов")).click();
        $(".aw_H28R.Jw_H28R.kw_H28R.f3jS9CT").closest("button").click();
        $(".aw_H28R.Jw_H28R.kw_H28R.f3jS9CT").closest(".b3jS9CT").click();
    }
}
