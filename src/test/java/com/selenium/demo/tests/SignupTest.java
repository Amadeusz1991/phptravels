package com.selenium.demo.tests;

import com.selenium.demo.pages.HotelSearchPage;
import com.selenium.demo.pages.LoggedUserPage;
import com.selenium.demo.pages.SignUpPage;
import com.selenium.demo.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test
    public void signUpTest() {

        // Zakładanie konta używając randomowego emaila
        String lastName = "Jankowski";
        int randomNumber = (int) (Math.random()*1000);
        String email = "tester" + randomNumber + "@tester.pl";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Amadeusz");
        signUpPage.setLastName(lastName);
        signUpPage.setPhone("111111111");
        signUpPage.setEmail(email);
        signUpPage.setPassword("Test123");
        signUpPage.setConfirmPassword("Test123");
        signUpPage.signButton();

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Amadeusz Jankowski");
    }
}
