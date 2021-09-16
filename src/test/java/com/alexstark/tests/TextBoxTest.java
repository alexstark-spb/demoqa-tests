package com.alexstark.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    private String userName = "Alex",
                   userEmail = "alexstark@mail.ru",
                   currentAddress = "S.Petersburg",
                   permanentAddress = "Nevskiy40";
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

    }
    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));

    }
}
