import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchWithNoResultTest extends BaseTest{

    @Test
    public void searchWithNoResult() {

        driver.findElement(By.cssSelector("input[name='checkin']")).sendKeys("17/08/2021");
        driver.findElement(By.name("checkout")).sendKeys("24/08/2021");
        driver.findElement(By.id("travellersInput")).click();
        WebElement adult = driver.findElement(By.name("adults"));
        adult.clear();
        adult.sendKeys("3");
        WebElement child = driver.findElement(By.name("child"));
        child.clear();
        child.sendKeys("2");
        driver.findElement(By.xpath("//button[text()=' Search']")).click();
        WebElement noResultHeading = driver.findElement(By.xpath("//h2[@class='text-center']"));
        Assert.assertTrue(noResultHeading.isDisplayed());
        Assert.assertEquals(noResultHeading.getText(), "No Results Found");

    }
}
