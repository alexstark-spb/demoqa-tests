package com.alexstark.tests;

import com.alexstark.pages.PracticFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class PracticeFormWithFakerTest extends TestBase {

    PracticFormPage practicFormPage = new PracticFormPage();
    Faker faker = new Faker();

    private String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.phoneNumber().subscriberNumber(10),
            day = "20",
            month = "June",
            year = "1992",
            subjects = "Computer science",
            hobbies1 = "Sports",
            hobbies2 = "Reading",
            address = faker.address().streetAddress(),
            state = "Rajasthan",
            city = "Jaipur",
            nameOfPicture = "test.jpg",
            exampleModalTitle = "Thanks for submitting the form";

    @Test
    void fillFormTest() {
        practicFormPage.openPage();
        practicFormPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeGender(gender)
                .typeMobile(mobile)
                .typeCalendar(day, month, year)
                .typeSubjects(subjects)
                .typeHobbies(hobbies1, hobbies2)
                .typePicture(nameOfPicture)
                .typeAddress(address)
                .typeState(state)
                .typeCity(city)
                .typeSubmit();

        practicFormPage.checkResultHeader(exampleModalTitle);
        practicFormPage.checkResultBody("Student Name", firstName + " " + lastName)
                .checkResultBody("Student Email", email)
                .checkResultBody("Mobile", mobile)
                .checkResultBody("Date of Birth", day + " " + month + "," + year)
                .checkResultBody("Subjects", subjects)
                .checkResultBody("Hobbies", hobbies1 + ", " + hobbies2)
                .checkResultBody("Picture", nameOfPicture)
                .checkResultBody("Address", address)
                .checkResultBody("State and City", state + " " + city);

    }
}