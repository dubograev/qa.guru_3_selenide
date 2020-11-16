package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @Test
    void openVkladiTab() {
        open("https://alfabank.ru");
        $$(byText("Вклады")).find(visible).click();
        $("#breadcrumbs").$(byText("Счета и депозиты")).shouldBe(visible);
        $(byText("Архивные счета и депозиты")).click();
        $$(byText("Депозиты")).find(visible).click();
        int a = $("#filter").findAll(".m23QzrO").size();
        System.out.println("Количество элементов: " + a);
//        $("#filter").find(".m23QzrO").getValue();
    }

}
