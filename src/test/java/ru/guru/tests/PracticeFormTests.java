package ru.guru.tests;

import ru.config.TestBase;
import ru.guru.data.PracticeFormData;
import ru.guru.pages.PracticeFormPage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase
{

    PracticeFormPage formPage = page(PracticeFormPage.class);

    @BeforeAll
    private static void beforeAll()
    {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillPracticeFormTest()
    {
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
        formPage.verifyFormIsCompleted();
    }
}
