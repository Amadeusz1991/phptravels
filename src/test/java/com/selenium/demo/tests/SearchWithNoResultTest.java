package com.selenium.demo.tests;

import com.selenium.demo.pages.HotelSearchPage;
import com.selenium.demo.pages.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithNoResultTest extends BaseTest {

    @Test
    public void searchWithNoResult() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDates("17/08/2021", "24/08/2021");
        hotelSearchPage.setTravellers(0, 1);
        hotelSearchPage.performSearch();


        //WebElement noResultHeading = driver.findElement(By.xpath("//h2[@class='text-center']"));
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertTrue(resultsPage.resultHeading.isDisplayed());
        Assert.assertEquals(resultsPage.getHeadingText(), "No Results Found");

    }
}
