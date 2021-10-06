package ru.guru.tests;

import ru.config.Attach;
import ru.config.TestBase;
import ru.guru.data.PracticeFormData;
import ru.guru.pages.PracticeFormPage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static io.qameta.allure.Allure.step;

@Tag("PFT")
public class PracticeFormTests extends TestBase
{

    PracticeFormPage formPage = page(PracticeFormPage.class);

    @BeforeAll
    public static void beforeAll()
    {
        step("Open Practice Form page", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
    }

    @AfterAll
    public static void afterAll()
    {
        step("Get all attachments after test", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        });
    }

    @Test
    void fillPracticeFormTest()
    {
        step("Fill form page with data", () -> {
            formPage.typeFirstName(PracticeFormData.firstName)
                    .typeLastName(PracticeFormData.lastName)
                    .typeEmail(PracticeFormData.userEmail)
                    .chooseMaleGender()
                    .typeUserNumber(PracticeFormData.userNumber)
                    .typeSubject(PracticeFormData.subject)
                    .typeHobby(PracticeFormData.sportHobby)
                    .typeHobby(PracticeFormData.readingHobby)
                    .typeHobby(PracticeFormData.musicHobby);
            formPage.calendar.setDate(26, 4, 1998);
            formPage.uploadFile()
                    .typeCurrentAddress(PracticeFormData.currentAddress)
                    .chooseState(PracticeFormData.state)
                    .chooseCity(PracticeFormData.city)
                    .submitForm();
        });
        step("Verify form has been filled with data", () -> {
            formPage.verifyFormIsCompleted();
        });
    }
}
