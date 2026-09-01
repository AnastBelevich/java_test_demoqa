package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anastasiia");
        $("#lastName").setValue("Belevich");
        $("#userEmail").setValue("nasti@mail.ru");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("1234567895");



        $("#submit").click();

        $$("tbody tr").findBy(text("Student Name")).shouldHave(text("Anastasiia Belevich"));
        $$("tbody tr").findBy(text("Student Email")).shouldHave(text("nasti@mail.ru"));
        $$("tbody tr").findBy(text("Gender")).shouldHave(text("Female"));
        $$("tbody tr").findBy(text("Mobile")).shouldHave(text("1234567895"));
        //  $("#output #name").shouldHave(text("Alex"));
        //  $("#output #email").shouldHave(text("alex@egorov.com"));
        //  $("#output #currentAddress").shouldHave(text("Some street 1"));
        // $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
