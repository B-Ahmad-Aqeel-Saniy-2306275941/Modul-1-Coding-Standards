package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int port;

    @Test
    void userCanCreateProductAndSeeItInProductList() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        String productName = "Sampo Cap Bambang";
        String productQuantity = "100";

        driver.get("http://localhost:" + port + "/product/create");

        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.clear();
        nameInput.sendKeys(productName);

        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.clear();
        quantityInput.sendKeys(productQuantity);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains(productName));
        assertTrue(pageSource.contains(productQuantity));
        

    }
}