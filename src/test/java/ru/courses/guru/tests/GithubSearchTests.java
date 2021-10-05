package ru.courses.guru.tests;

import ru.config.TestBase;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubSearchTests extends TestBase
{
    @Test
    void searchSoftAssertionsInSelenide()
    {
        String selenide = "selenide";
        String softAssertions = "SoftAssertions";
        open("https://github.com/selenide/selenide");
        $("[itemprop=name]").shouldHave(text(selenide));
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue(softAssertions);
        $$("[data-filterable-for=wiki-pages-filter] .text-bold").findBy(text(softAssertions)).click();
        $("#wiki-wrapper h1").shouldHave(text(softAssertions));
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"), text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
