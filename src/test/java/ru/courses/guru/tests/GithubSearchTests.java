package ru.courses.guru.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubSearchTests
{

    @BeforeAll
    static void beforeAll()
    {
        Configuration.startMaximized = true;
    }

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
