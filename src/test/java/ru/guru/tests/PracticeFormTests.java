package ru.guru.tests;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests
{

    @BeforeAll
    static void beforeAll()
    {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void fillPracticeFormTest()
    {
        //Fill the form
        $("#firstName").setValue("First Name");
        $("#lastName").setValue("Last Name");
        $("#userEmail").setValue("email@yandex.ru");
        $("input[value='Male']").click(usingJavaScript());
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(3);
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $$(".react-datepicker__month .react-datepicker__day").findBy(text("26")).click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $$("#hobbiesWrapper .custom-control-label").findBy(text("Sports")).click();
        $$("#hobbiesWrapper .custom-control-label").findBy(text("Reading")).click();
        $$("#hobbiesWrapper .custom-control-label").findBy(text("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/n7_pictures.png"));
        $("#currentAddress").setValue("Some Address");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();
        //verify form has been submitted with right parameters
        $$(".table-striped td").findBy(text("First Name")).shouldBe(visible);
        $$(".table-striped td").findBy(text("Last Name")).shouldBe(visible);
        $$(".table-striped td").findBy(text("Male")).shouldBe(visible);
        $$(".table-striped td").findBy(text("1234567890")).shouldBe(visible);
        $$(".table-striped td").findBy(text("26 April,1998")).shouldBe(visible);
        $$(".table-striped td").findBy(text("Computer Science")).shouldBe(visible);
        $$(".table-striped td").findBy(text("Sports, Reading, Music")).shouldBe(visible);
        $$(".table-striped td").findBy(text("n7_pictures.png")).shouldBe(visible);
        $$(".table-striped td").findBy(text("Some Address")).shouldBe(visible);
        $$(".table-striped td").findBy(text("NCR Delhi")).shouldBe(visible);
    }
}
