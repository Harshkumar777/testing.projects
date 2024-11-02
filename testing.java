import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Set;

public class testing {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");

        driver.manage().window().maximize();
        WebElement searchBox =  driver.findElement(By.name("q"));
        searchBox.sendKeys("OnePlus Nord CE4 Lite 5G");

        searchBox.submit();

        String mainPage = driver.getWindowHandle();

        System.out.println("main page=" + mainPage);

        driver.findElement(By.xpath("//div[normalize-space()='OnePlus Nord CE4 lite 5G (MEGA BLUE, 256 GB)']")).click();

        Set<String> allPages= driver.getWindowHandles();

        for(String page:allPages){
            if(!page.equals(mainPage)){
                driver.switchTo().window(page);
                break;
            }


        }
        System.out.println(driver.getCurrentUrl());
        List<WebElement>Products= driver.findElements(By.className("_7eSDEz"));

        System.out.println(Products.size());
        for (WebElement product:Products){

            System.out.println(product.getText());

        }

        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();

       driver.quit();











    }

}