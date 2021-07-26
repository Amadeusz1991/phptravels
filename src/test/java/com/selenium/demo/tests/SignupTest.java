package com.selenium.demo.tests;

import com.selenium.demo.model.User;
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
    @Test
    public void signUpTest2() {

        // Zakładanie konta używając randomowego emaila
        int randomNumber = (int) (Math.random()*1000);
        String email = "tester" + randomNumber + "@tester.pl";

        User user = new User();
        user.setFirstName("Amadeusz");
        user.setLastName("Jankowski");
        user.setPhone("111111111");
        user.setEmail(email);
        user.setPassword("Test123");
        user.setConfirmPassword("Test123");

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        //signUpPage.fillSignUpForm("Amadeusz", lastName, "111111111", email, "Test123", "Test123");
        signUpPage.fillSignUpForm(user);

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertTrue(loggedUserPage.getHeadingText().contains(user.getLastName()));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Amadeusz Jankowski");
    }
}
