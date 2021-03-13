package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class SmokeTest2 {

    @Test
    public void smokeTest1() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select layingMethodLaminate = new Select(selectWebElement);

        layingMethodLaminate.selectByVisibleText("с использованием отрезанного элемента");

        WebElement lengthRoom = driver.findElement(By.id("ln_room_id"));
        lengthRoom.clear();
        lengthRoom.sendKeys("500");

        WebElement widthRoom = driver.findElement(By.id("wd_room_id"));
        widthRoom.clear();
        widthRoom.sendKeys("400");

        WebElement lengthLaminate = driver.findElement(By.id("ln_lam_id"));
        lengthLaminate.clear();
        lengthLaminate.sendKeys("2000");

        WebElement widthLaminate = driver.findElement(By.id("wd_lam_id"));
        widthLaminate.clear();
        widthLaminate.sendKeys("200");

        List<WebElement> layingDirectionOfLaminate = driver.findElements(By.name("direction-laminate"));
        for (WebElement select : layingDirectionOfLaminate) {
            if (select.getAttribute("value").equals("1")) {
                select.click();
                break;
            }
        }

        WebElement calcBtn = driver.findElement(By.linkText("Рассчитать"));
        calcBtn.click();


        Thread.sleep(5000); // неуспевает страница обновиться выкинул вот "ЭТО"



        WebElement quantityLaminate = driver.findElement(By.xpath("//span [text() = '53']"));
        Assert.assertEquals(quantityLaminate.getText(), "53","Требуемое количество досок ламината отображается не корректно.");

        WebElement countPacks = driver.findElement(By.xpath("//span [text() = '7']"));
        Assert.assertEquals(countPacks.getText(),"7","Количество упаковок ламината отображается не корректно.");


        driver.quit();
    }
}
