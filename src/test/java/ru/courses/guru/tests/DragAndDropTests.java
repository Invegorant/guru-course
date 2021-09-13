package ru.courses.guru.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests
{
    @BeforeAll
    static void beforeAll()
    {
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropSquares()
    {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $$("#content .column").first().shouldHave(text("B"));
        $$("#content .column").last().shouldHave(text("A"));
    }
}
