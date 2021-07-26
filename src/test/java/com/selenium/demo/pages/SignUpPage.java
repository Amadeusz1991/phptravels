package com.selenium.demo.pages;

import com.selenium.demo.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ListResourceBundle;
import java.util.stream.Collectors;

public class SignUpPage {

    @FindBy(name = "firstname")
    private WebElement firstnameInput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()=' Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private List<WebElement> errors;

    public SignUpPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void setFirstName(String firstName) {
        firstnameInput.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }
    public void setPhone(String phone) {
        phoneInput.sendKeys(phone);
    }
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }
    public void signButton() {
        signUpButton.click();
    }
    public List<String> getErrors(){
       return errors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    // alternatywne podejście do wypełniania formularza rejerstracji, lecz jest to mniej elastyczne
    public void fillSignUpForm(String firstName, String lastName, String phone, String email, String password, String confirmPassword){
        firstnameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        signUpButton.click();
    }
    // Metoda, która używa innej klasy z której pobierane są dane
    public void fillSignUpForm(User user){
        firstnameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        phoneInput.sendKeys(user.getPhone());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        confirmPasswordInput.sendKeys(user.getConfirmPassword());
        signUpButton.click();
    }
}
