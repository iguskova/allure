package ru.solvo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 68;

    @Test
    public void testRepositoryIssue() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
                });
        step("Ищем репозиторий" + " " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
                });
        step("Переходим в репозиторий" + " " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
                });
        step("Переходим в раздел Issue", () -> {
            $(partialLinkText("Issues")).click();
                });
        step("Проверяем, что существует Issue с номером" + " " + ISSUE_NUMBER, () -> {
            $(byText("68")).should(Condition.visible);
        });
        }
    }

