package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class SmokeTest3 {

    @Test
    public void smokeTest1() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement lengthRoom = driver.findElement(By.name("calc_roomwidth"));
        JavascriptExecutor jselenghtRoom = (JavascriptExecutor) driver;
        jselenghtRoom.executeScript("arguments[0].value='6';", lengthRoom);


        WebElement widthRoom = driver.findElement(By.name("calc_roomheight"));
        JavascriptExecutor jsewidthRoom = (JavascriptExecutor) driver;
        jsewidthRoom.executeScript("arguments[0].value='4';", widthRoom);

        WebElement lengthLaminate = driver.findElement(By.name("calc_lamwidth"));
        JavascriptExecutor jsell = (JavascriptExecutor) driver;
        jsell.executeScript("arguments[0].value='2000';", lengthLaminate);

        WebElement widthLaminate = driver.findElement(By.name("calc_lamheight"));
        JavascriptExecutor jsewl = (JavascriptExecutor) driver;
        jsewl.executeScript("arguments[0].value='200';", widthLaminate);

        WebElement packing = driver.findElement(By.name("calc_inpack"));
        JavascriptExecutor jsePacking = (JavascriptExecutor) driver;
        jsePacking.executeScript("arguments[0].value='8';", packing);

        WebElement price = driver.findElement(By.name("calc_price"));
        JavascriptExecutor jsePrice = (JavascriptExecutor) driver;
        jsePrice.executeScript("arguments[0].value='10';", price);

        WebElement layingDirectionOfLaminate = driver.findElement(By.name("calc_direct"));
        Select select = new Select(layingDirectionOfLaminate);
        select.selectByValue("toh");

        WebElement offsetRows = driver.findElement(By.name("calc_bias"));
        JavascriptExecutor jseoffsetRows = (JavascriptExecutor) driver;
        jseoffsetRows.executeScript("arguments[0].value= '400';", offsetRows);

        WebElement indentFromTheWall = driver.findElement(By.name("calc_walldist"));
        JavascriptExecutor jseindentFromTheWall = (JavascriptExecutor) driver;
        jseindentFromTheWall.executeScript("arguments[0].value = '8';", indentFromTheWall);

        WebElement btn = driver.findElement(By.className("tocalc"));
        btn.click();

        WebElement square = driver.findElement(By.id("s_lam"));
        Assert.assertEquals(square.getText(), "23.84 м2.", "Площадь укладки отображается не верно.");

        WebElement countLaminate = driver.findElement(By.id("l_count"));
        Assert.assertEquals(countLaminate.getText(), "62 шт.", "Количество панелей отображается не верно.");

        WebElement countPack = driver.findElement(By.id("l_packs"));
        Assert.assertEquals(countPack.getText(), "8 шт.", "Количество упаковок отображается не верно.");

        WebElement priceLaminate = driver.findElement(By.id("l_price"));
        Assert.assertEquals(priceLaminate.getText(), "256 руб.", "Стоимость отображается не верно.");

        WebElement remains = driver.findElement(By.id("l_over"));
        Assert.assertEquals(remains.getText(), "2 шт.", "Остатки отображаются не верно.");

        WebElement segment = driver.findElement(By.id("l_trash"));
        Assert.assertEquals(segment.getText(), "10 шт.", "Отрезки отображаются не верно.");

        driver.quit();
    }

    @Test
    public void smokeTest2() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement lengthRoom = driver.findElement(By.name("calc_roomwidth"));
        JavascriptExecutor jselenghtRoom = (JavascriptExecutor) driver;
        jselenghtRoom.executeScript("arguments[0].value='1.421';", lengthRoom);


        WebElement widthRoom = driver.findElement(By.name("calc_roomheight"));
        JavascriptExecutor jsewidthRoom = (JavascriptExecutor) driver;
        jsewidthRoom.executeScript("arguments[0].value='1.111';", widthRoom);

        WebElement lengthLaminate = driver.findElement(By.name("calc_lamwidth"));
        JavascriptExecutor jsell = (JavascriptExecutor) driver;
        jsell.executeScript("arguments[0].value='500';", lengthLaminate);

        WebElement widthLaminate = driver.findElement(By.name("calc_lamheight"));
        JavascriptExecutor jsewl = (JavascriptExecutor) driver;
        jsewl.executeScript("arguments[0].value='150';", widthLaminate);

        WebElement packing = driver.findElement(By.name("calc_inpack"));
        JavascriptExecutor jsePacking = (JavascriptExecutor) driver;
        jsePacking.executeScript("arguments[0].value='6';", packing);

        WebElement price = driver.findElement(By.name("calc_price"));
        JavascriptExecutor jsePrice = (JavascriptExecutor) driver;
        jsePrice.executeScript("arguments[0].value='11';", price);

        WebElement layingDirectionOfLaminate = driver.findElement(By.name("calc_direct"));
        Select select = new Select(layingDirectionOfLaminate);
        select.selectByIndex(0);

        WebElement offsetRows = driver.findElement(By.name("calc_bias"));
        JavascriptExecutor jseoffsetRows = (JavascriptExecutor) driver;
        jseoffsetRows.executeScript("arguments[0].value= '250';", offsetRows);

        WebElement indentFromTheWall = driver.findElement(By.name("calc_walldist"));
        JavascriptExecutor jseindentFromTheWall = (JavascriptExecutor) driver;
        jseindentFromTheWall.executeScript("arguments[0].value = '8';", indentFromTheWall);

        WebElement btn = driver.findElement(By.className("tocalc"));
        btn.click();

        WebElement square = driver.findElement(By.id("s_lam"));
        Assert.assertEquals(square.getText(), "1.54 м2.", "Площадь укладки отображается не верно.");

        WebElement countLaminate = driver.findElement(By.id("l_count"));
        Assert.assertEquals(countLaminate.getText(), "24 шт.", "Количество панелей отображается не верно.");

        WebElement countPack = driver.findElement(By.id("l_packs"));
        Assert.assertEquals(countPack.getText(), "4 шт.", "Количество упаковок отображается не верно.");

        WebElement priceLaminate = driver.findElement(By.id("l_price"));
        Assert.assertEquals(priceLaminate.getText(), "19 руб.", "Стоимость отображается не верно.");

        WebElement remains = driver.findElement(By.id("l_over"));
        Assert.assertEquals(remains.getText(), "0 шт.", "Остатки отображаются не верно.");

        WebElement segment = driver.findElement(By.id("l_trash"));
        Assert.assertEquals(segment.getText(), "4 шт.");

        driver.quit();
    }

    @Test
    public void smokeTest3() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement lengthRoom = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[1]/div[2]/div/span[2]/input"));
        JavascriptExecutor jselenghtRoom = (JavascriptExecutor) driver;
        jselenghtRoom.executeScript("arguments[0].value='6.12';", lengthRoom);


        WebElement widthRoom = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[1]/div[3]/div/span[2]/input"));
        JavascriptExecutor jsewidthRoom = (JavascriptExecutor) driver;
        jsewidthRoom.executeScript("arguments[0].value='4.523';", widthRoom);

        WebElement lengthLaminate = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[2]/div[2]/div/span[2]/input"));
        JavascriptExecutor jsell = (JavascriptExecutor) driver;
        jsell.executeScript("arguments[0].value='5000';", lengthLaminate);

        WebElement widthLaminate = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[2]/div[3]/div/span[2]/input"));
        JavascriptExecutor jsewl = (JavascriptExecutor) driver;
        jsewl.executeScript("arguments[0].value='400';", widthLaminate);

        WebElement packing = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[2]/div[4]/div/span[2]/input"));
        JavascriptExecutor jsePacking = (JavascriptExecutor) driver;
        jsePacking.executeScript("arguments[0].value='12';", packing);

        WebElement price = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[2]/div[5]/div/span[2]/input"));
        JavascriptExecutor jsePrice = (JavascriptExecutor) driver;
        jsePrice.executeScript("arguments[0].value='156';", price);

        WebElement layingDirectionOfLaminate = driver.findElement(By.name("calc_direct"));
        Select select = new Select(layingDirectionOfLaminate);
        select.selectByValue("tow");

        WebElement offsetRows = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[3]/div[3]/div/span[2]/input"));
        JavascriptExecutor jseoffsetRows = (JavascriptExecutor) driver;
        jseoffsetRows.executeScript("arguments[0].value= '400';", offsetRows);

        WebElement indentFromTheWall = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[3]/div[4]/div/span[2]/input"));
        JavascriptExecutor jseindentFromTheWall = (JavascriptExecutor) driver;
        jseindentFromTheWall.executeScript("arguments[0].value = '12';", indentFromTheWall);

        WebElement btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[3]/div[7]/div/input"));
        btn.click();

        WebElement square = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[4]/div[2]/div/span[3]/b"));
        Assert.assertEquals(square.getText(), "27.43", "Площадь укладки отображается не верно.");

        WebElement countLaminate = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[4]/div[3]/div/span[3]/b"));
        Assert.assertEquals(countLaminate.getText(), "15", "Количество панелей отображается не верно.");

        WebElement countPack = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[4]/div[4]/div/span[3]/b"));
        Assert.assertEquals(countPack.getText(), "2", "Количество упаковок отображается не верно.");

        WebElement priceLaminate = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[4]/div[5]/div/span[3]/b"));
        Assert.assertEquals(priceLaminate.getText(), "7488", "Стоимость отображается не верно.");

        WebElement remains = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[4]/div[6]/div/span[3]/b"));
        Assert.assertEquals(remains.getText(), "9", "Остатки отображаются не верно.");

        WebElement segment = driver.findElement(By.xpath("/html/body/div[1]/div/div/article/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/form/div/div[4]/div[7]/div/span[3]/b"));
        Assert.assertEquals(segment.getText(), "1", "Отрезки отображаются не верно.");

        driver.quit();
    }
}
