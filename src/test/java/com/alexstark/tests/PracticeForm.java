package com.alexstark.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    String firstName = "Alex";
    String lastName = "Derevyanko";
    String email = "alexstark@mail.ru";
    String gender = "Male";
    String mobile = "9995551122";
    String month = "May";
    String year = "2022";
    String subjects = "Computer science";
    String hobbies1 = "Sports", hobbies2 = "Reading" ;
    String Address = "S.Petersburg,Nevskiy st. house 40";
    String state = "Rajasthan";
    String city = "Jaipur";

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirth").$("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label='Choose Tuesday, May 3rd, 2022']").click();
        $("#subjectsWrapper").$("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies1)).click();
        $("#hobbiesWrapper").$(byText(hobbies2)).click();
        $("#uploadPicture").uploadFromClasspath("image/test.jpg");
        $("#currentAddress").setValue(Address );
        $("#submit").scrollIntoView(true);
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText(state)).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();



        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Derevyanko"));
        $(".table-responsive").shouldHave(text("alexstark@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9995551122"));
        $(".table-responsive").shouldHave(text("03 May,2022"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports, Reading"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("S.Petersburg,Nevskiy st. house 40"));
        $(".table-responsive").shouldHave(text("Rajasthan Jaipur"));





    }
}