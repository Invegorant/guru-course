package ru.guru.pages;

import io.qameta.allure.Step;
import ru.config.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSteps extends TestBase {

    @Step
    public void openAllureExamplesPage() {
        open("https://github.com/eroshenkoam/allure-example");
    }

    @Step
    public void openIssueTab() {
        $("#issues-tab").click();
        $("[aria-label=Issues]").shouldBe(visible);
    }

    @Step("Find 'Issue' by id '{id}'")
    public void findIssueById(int id) {
        $("#issue_" + id).shouldBe(visible);
    }
}
