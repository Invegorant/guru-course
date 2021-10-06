package ru.guru.tests;

import ru.config.TestBase;
import ru.guru.data.PracticeFormData;
import ru.guru.pages.PracticeFormPage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
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
