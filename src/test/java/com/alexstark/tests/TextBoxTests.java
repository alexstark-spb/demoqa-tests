package com.alexstark.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alexstark@mail.ru");
        $("#currentAddress").setValue("S.Petersburg");
        $("#permanentAddress").setValue("Nevskiy40");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alexstark@mail.ru"));
        $("#output #currentAddress").shouldHave(text("S.Petersburg"));
        $("#output #permanentAddress").shouldHave(text("yuj"));


    }
}
