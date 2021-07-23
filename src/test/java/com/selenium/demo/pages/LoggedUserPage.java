package com.selenium.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    @FindBy(xpath = "//h3[@class='RTL']")
    private WebElement heading;

    public LoggedUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    // zwracamy heading zawarty w nagłówku
    public String getHeadingText(){
        return heading.getText();
    }
}