package ru.guru.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests
{

    @BeforeAll
    static void beforeAll()
    {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest()
    {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@qaguru.com");
        $("#currentAddress").setValue("street 1");
        $("#permanentAddress").setValue("street 2");
        $("#submit").click();
        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@qaguru.com"));
        $("#output #currentAddress").shouldHave(text("street 1"));
        $("#output #permanentAddress").shouldHave(text("street 2"));
    }
}
