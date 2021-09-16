package com.alexstark.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    private String firstName = "Alex",
                   lastName = "Derevyanko",
                   email = "alexstark@mail.ru",
                   gender = "Male",
                   mobile = "9995551122",
                   month = "May",
                   year = "2022",
                   subjects = "Computer science",
                   hobbies1 = "Sports",
                   hobbies2 = "Reading",
                   address = "S.Petersburg,Nevskiy st. house 40",
                   state = "Rajasthan",
                   city = "Jaipur";

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
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
        $("#currentAddress").setValue(address);
        $("#submit").scrollIntoView(true);
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText(state)).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName+" "+lastName));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(mobile));
        $(".table-responsive").shouldHave(text("03 "+month+","+year));
        $(".table-responsive").shouldHave(text(subjects ));
        $(".table-responsive").shouldHave(text(hobbies1+", "+hobbies2));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text(address));
        $(".table-responsive").shouldHave(text(state+" "+city));
    }
}