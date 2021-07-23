package com.selenium.demo.tests;

import com.selenium.demo.pages.HotelSearchPage;
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

        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElement(By.name("firstname")).sendKeys("Amadeusz");
        driver.findElement(By.name("lastname")).sendKeys("Jankowski");
        driver.findElement(By.name("phone")).sendKeys("546567890");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("Fasterekq");
        driver.findElement(By.name("confirmpassword")).sendKeys("Fasterekq");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));
        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(), "Hi, Amadeusz Jankowski");
    }
}
