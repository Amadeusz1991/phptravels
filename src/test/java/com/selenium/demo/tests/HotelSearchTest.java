package com.selenium.demo.tests;

import com.selenium.demo.pages.HotelSearchPage;
import com.selenium.demo.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotel() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Warsaw");
        hotelSearchPage.setDates("29/07/2021", "30/07/2021");
        hotelSearchPage.setTravellers(1, 2);
        hotelSearchPage.performSearch();

        // Odwołanie się do klasy ResultPage
        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();
        System.out.println(hotelNames.size());
        hotelNames.forEach(el -> System.out.println(el));

        //Asercje sprawdzające przwdziwość pobranych nazw hotelów
        /*Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));*/
    }
}
