package ru.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase
{
    @BeforeAll
    static void setUp()
    {
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void tearDown()
    {
        Selenide.closeWebDriver();
    }
}
