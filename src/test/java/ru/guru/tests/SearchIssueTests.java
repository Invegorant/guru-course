package ru.guru.tests;

import org.junit.jupiter.api.Test;
import ru.config.TestBase;
import ru.guru.pages.GithubSteps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchIssueTests extends TestBase {

    @Test
    public void selenideIssueTest() {
        open("https://github.com/eroshenkoam/allure-example");
        $("#issues-tab").click();
        $("[aria-label=Issues]").shouldBe(visible);
        $("#issue_59").shouldBe(visible);
    }

    @Test
    public void lambdaStepTest() {
        step("Open 'allure examples'", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Open 'Issue' tab and check it", () -> {
            $("#issues-tab").click();
            $("[aria-label=Issues]").shouldBe(visible);
        });
        step("Find 'Issue' with number '#59'", () -> {
            $("#issue_59").shouldBe(visible);
        });
    }

    @Test
    public void annotationStepTest() {
        GithubSteps steps = new GithubSteps();
        steps.openAllureExamplesPage();
        steps.openIssueTab();
        steps.findIssueById(59);
    }
}
