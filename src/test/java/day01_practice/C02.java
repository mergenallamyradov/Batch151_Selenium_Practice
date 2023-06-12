package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        //Arama motoruna nutella yazip aratiniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        //Costumer service ve registry butonlarina sirasiyla tiklayiniz  ve titlin amazon icerdigini test ediniz

        for (int i=0; i<2; i++){
            List<WebElement> butonlar = driver.findElements(By.xpath("(//a[@tabindex='0'])[6] | (//a[@tabindex='0'])[7]"));
           butonlar.get(i).click();
           if (driver.getTitle().contains("Amazon")){
               System.out.println("Title Amazon iceriyor");
           }

           driver.navigate().back();
        }

        driver.close();


    }
}
