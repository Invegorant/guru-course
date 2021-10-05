package ru.courses.guru.tests;

import ru.config.TestBase;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests extends TestBase
{
    @Test
    void dragAndDropSquares()
    {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $$("#content .column").first().shouldHave(text("B"));
        $$("#content .column").last().shouldHave(text("A"));
    }
}
