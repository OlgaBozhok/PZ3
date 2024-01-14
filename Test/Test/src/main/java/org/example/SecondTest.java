package org.example;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    @Test
    public void secondTest(){
        File file = new File("C:/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeDriver driver = new ChromeDriver();

        // Открываем страницу
        driver.get("http://localhost:8080/food");

        // Убедимся, что страница верная
        String h5 = driver.findElement(By.xpath("//div[@class='container-fluid']/h5")).getText();
        Assert.assertTrue(h5.equals("Список товаров"));

        // Нажмем кнопку "Добавить"
        driver.findElement(By.xpath("//div[@class='btn-grou mt-2 mb-2']/button")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Ввести в поля значения: "Батат_2 (purp.); Овощ; True"
        WebElement input = driver.findElement(By.xpath("//div[@class='form-group']/input"));
        input.sendKeys("Батат_2 (purp.)");

        WebElement drop = driver.findElement(By.name("type"));
        drop.click();

        Select typeProduct = new Select(drop);
        typeProduct.selectByVisibleText("Овощ");

        //Отметим чекбокс
        driver.findElement(By.name("exotic")).click();

        // Нажать кнопку "Сохранить"

        driver.findElement(By.id("save")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }
}
