package com.alexstark.tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {

    private String
            firstName = "Alexander",
            lastName = "Derevyanko",
            email = "alexstark@mail.ru",
            gender = "Male",
            mobile = "9995551122",
            day = "20",
            month = "June",
            year = "1992",
            subjects = "Computer science",
            hobbies1 = "Sports",
            hobbies2 = "Reading",
            address = "S.Petersburg,Nevskiy st. house 40",
            state = "Rajasthan",
            city = "Jaipur",
            nameOfPicture = "test.jpg",
            exampleModalTitle = "Thanks for submitting the form";

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+day).click();
        $("#subjectsWrapper").$("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies1)).click();
        $("#hobbiesWrapper").$(byText(hobbies2)).click();
        $("#uploadPicture").uploadFromClasspath("image/" + nameOfPicture);
        $("#currentAddress").setValue(address);
        $("#submit").scrollIntoView(true);
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText(state)).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text(exampleModalTitle));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobile));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies1 + ", " + hobbies2));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(nameOfPicture));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));

    }
}