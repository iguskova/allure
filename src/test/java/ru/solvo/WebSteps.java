package ru.solvo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepo(String repository){
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository){
        $(linkText(repository)).click();
    }

    @Step("Переходим в раздел Issue")
    public void goToIssue(){
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что существует Issue с номером {number}")
            public void checkIssueWithNumber(int number){
        $(byText("#" + number)).should(Condition.visible);
    }
}
