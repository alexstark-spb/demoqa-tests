package com.alexstark.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">

        $("[data-testid=email]");
        $(by("data-testid", "email"));

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">

        $("#email");
        $(byId("email"));
        $(By.id("email"));
        $("[id=email]");
        $("[id='email']");
        $("[id=\"email\"]");
        $(by("id", "email"));
        $x("//*[@id='email']");
        $(byXpath("//*[@id='email']"));

        $("input#email");
        $("input[id=email]");


        // <input type="email" class="inputtext login_form_input_box" name="email">

        $("[name=email]");
        $(byName("email"));

        // <input type="email" class="inputtext login_form_input_box">
        $(byClassName("login_form_input_box"));
        $(".login_form_input_box");
        $(".inputtext.login_form_input_box");
        $x("//*[@class='login_form_input_box']");

        // <div type="email" class="inputtext">
        //      <input class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box");


        // <div>Hello qa.guru</div>
        $(byText("Hello qa.guru"));
        $(withText("lo qa.guru"));

        // #dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(1) > div.react-datepicker__day.react-datepicker__day--003.react-datepicker__day--selected

        $("[aria-label=\"Choose Tuesday, May 3rd, 2022\"]").click();
        $("[aria-label='Choose Tuesday, May 3rd, 2022']").click();
        $x("//*[@aria-label = 'Choose Tuesday, May 3rd, 2022']").click();
//        $$("label.blabla").filter(text("blabla")).get(0).click();
    }
}