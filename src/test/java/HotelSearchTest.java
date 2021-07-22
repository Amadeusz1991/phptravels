
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;
public class HotelSearchTest extends BaseTest{

    @Test
    public void searchHotel() {

        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
        driver.findElement(By.cssSelector("input[name='checkin']")).sendKeys("17/08/2021");
        driver.findElement(By.name("checkout")).sendKeys("24/08/2021");
        driver.findElement(By.id("travellersInput")).click();
        WebElement adult = driver.findElement(By.name("adults"));
        adult.clear();
        adult.sendKeys("3");
        WebElement child = driver.findElement(By.name("child"));
        child.clear();
        child.sendKeys("2");

        // uzycie Lambdy do uzyskania nazw hoteli widocznych na stronie
        driver.findElement(By.xpath("//button[text()=' Search']")).click();
        List<String> hotelNames = driver.findElements(By.xpath("//h4[contains(@class,'list_title')]//b"))
                .stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
        System.out.println(hotelNames.size());
        hotelNames.forEach(el -> System.out.println(el));
        //Asercje sprawdzające przwdziwość pobranych nazw hotelów
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));
    }
}
