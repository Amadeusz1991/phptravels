package com.selenium.demo.tests;
import com.selenium.demo.pages.HotelSearchPage;
import com.selenium.demo.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class ValidationCheckoutTest extends BaseTest {

    @Test
    public void signUpWithoutCredentials() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signButton();

        List<String> errors = signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();


    }

    @Test
    public void signUpWithWrongEmail() {
        // Zakładanie konta używając randomowego emaila
        String lastName = "Jankowski";
        int randomNumber = (int) (Math.random() * 1000);
        String email = "tester" + randomNumber;

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

        /* pobieranie każdego tekstu z wybranego elementu, potem sprawdzenie asercjami ich poprawności
        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream()
                .map(WebElement::getText)
                .collect(Collectors
                        .toList());*/
        Assert.assertTrue(signUpPage.getErrors().contains("The Email field must contain a valid email address."));
    }
}
