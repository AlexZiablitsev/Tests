package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TestSelector {

    @Test
    public void cssSelectorTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jobs.tut.by");

        //.class
        WebElement class1 = driver.findElement(By.cssSelector(".supernova-overlay"));
        Assert.assertTrue(class1.isEnabled());

        WebElement class2 = driver.findElement(By.cssSelector(".supernova-overlay__content"));
        Assert.assertFalse(class2.isSelected());

        //.class1.class2

        WebElement class3 = driver.findElement(By.cssSelector(".bloko-input-wrapper.HH-SearchVacancyDropClusters-SearchInput"));
        Assert.assertTrue(class3.isDisplayed());

        WebElement class4 = driver.findElement(By.cssSelector(".supernova-footer.HH-Supernova-Footer"));
        Assert.assertTrue(class4.isDisplayed());

        //.class1 .class2

        WebElement class5 = driver.findElement(By.cssSelector(".mobile-work-in-company-banner .work-in-company-banner"));
        Assert.assertFalse(class5.isDisplayed());

        WebElement class6 = driver.findElement(By.cssSelector(".bloko-columns-wrapper .grid__columns-wrapper"));
        Assert.assertTrue(class6.isEnabled());

        //#id

        WebElement id1 = driver.findElement(By.cssSelector("#top100Counter"));
        Assert.assertFalse(id1.isDisplayed());

        //element
        WebElement element1 = driver.findElement(By.cssSelector("script"));
        Assert.assertTrue(element1.isEnabled());

        WebElement element2 = driver.findElement(By.cssSelector("iframe"));
        Assert.assertFalse(element2.isDisplayed());

        //element.class
        WebElement elementClass1 = driver.findElement(By.cssSelector("h1.supernova-dashboard-header"));
        Assert.assertTrue(elementClass1.isDisplayed());

        WebElement elementClass2 = driver.findElement(By.cssSelector("div.supernova-dashboard-footer-fill"));
        Assert.assertTrue(elementClass2.isDisplayed());


        //element,element
        List<WebElement> elementElement1 = driver.findElements(By.cssSelector("fieldset,label"));
        Assert.assertEquals(3, elementElement1.size());

        List<WebElement> elementElement2 = driver.findElements(By.cssSelector("button,label"));
        Assert.assertEquals(9, elementElement2.size());


        // element element
        WebElement elementElement3 = driver.findElement(By.cssSelector("button div"));
        Assert.assertTrue(elementElement3.isDisplayed());

        WebElement elementElement4 = driver.findElement(By.cssSelector("button span span"));
        Assert.assertFalse(elementElement4.isDisplayed());

        //element>element
        WebElement elementElement5 = driver.findElement(By.cssSelector("button>span+span"));
        Assert.assertTrue(elementElement5.isDisplayed());

        WebElement elementElement6 = driver.findElement(By.cssSelector("button>div"));
        Assert.assertTrue(elementElement6.isDisplayed());

        //element+element
        WebElement elementElement7 = driver.findElement(By.cssSelector("fieldset+label"));
        Assert.assertFalse(elementElement7.isDisplayed());

        WebElement elementElement8 = driver.findElement(By.cssSelector("div+script+script"));
        Assert.assertFalse(elementElement8.isDisplayed());

        //element1~element2
        WebElement elementElement9 = driver.findElement(By.cssSelector("div~a"));
        Assert.assertFalse(elementElement9.isDisplayed());

        List<WebElement> elementElement10 = driver.findElements(By.cssSelector("ul~ul"));
        Assert.assertEquals(4, elementElement10.size());

        //[attribute]
        WebElement attribute1 = driver.findElement(By.cssSelector("title"));
        Assert.assertFalse(attribute1.isDisplayed());

        WebElement attribute2 = driver.findElement(By.cssSelector("[data-hh-tab-id]"));
        Assert.assertTrue(attribute2.isDisplayed());

        //[attribute=value]
        WebElement attribute3 = driver.findElement(By.cssSelector("[data-hh-tab-id='searchVacancy']"));
        WebElement attribute4 = driver.findElement(By.cssSelector("[data-qa='search-button']"));

        //[attribute~=value]
//        WebElement attribute5 = driver.findElement(By.cssSelector("[data-search-type~=search]"));
//        WebElement attribute6 = driver.findElement(By.cssSelector(""));

        //[attribute|=value]
        List<WebElement> attribute7 = driver.findElements(By.cssSelector("[data-qa|='search']"));
        Assert.assertEquals(2, attribute7.size());

        List<WebElement> attribute8 = driver.findElements(By.cssSelector("[sandbox|=allow]"));
        Assert.assertEquals(1, attribute8.size());

        //[attribute^=value]
        List<WebElement> attribute9 = driver.findElements(By.cssSelector("[name^='st']"));
        Assert.assertEquals(2, attribute9.size());

        List<WebElement> attribute10 = driver.findElements(By.cssSelector("[value^='1']"));
        Assert.assertEquals(2, attribute10.size());

        //[attribute$=value]
        WebElement attribute11 = driver.findElement(By.cssSelector("input[placeholder$='компания']"));
        Assert.assertTrue(attribute11.isDisplayed());

        WebElement attribute12 = driver.findElement(By.cssSelector("button[data-qa$='button']"));
        Assert.assertTrue(attribute12.isDisplayed());

        //[attribute*=value]
        WebElement attribute13 = driver.findElement(By.cssSelector("input[data-qa*='input']"));
        Assert.assertTrue(attribute13.isDisplayed());

        WebElement attribute14 = driver.findElement(By.cssSelector("span[class*='default']"));
        Assert.assertTrue(attribute14.isDisplayed());


        driver.quit();
    }

    @Test
    public void xpathTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jobs.tut.by");

        //ancestor
        WebElement ancestorElement1 = driver.findElement(By.xpath("//button[@data-qa='search-button']/ancestor::form"));
        Assert.assertTrue(ancestorElement1.isDisplayed());

        WebElement ancestorElement2 = driver.findElement(By.xpath("//button[@data-qa='search-button']/ancestor::div[@class='bloko-gap bloko-gap_top']"));
        Assert.assertTrue(ancestorElement2.isDisplayed());

        //ancestor-or-self
        WebElement ancestorElement3 = driver.findElement(By.xpath("//button[@data-qa='search-button']/ancestor-or-self::form"));
        Assert.assertTrue(ancestorElement3.isDisplayed());

        WebElement ancestorElement4 = driver.findElement(By.xpath("//button[@data-qa='search-button']/ancestor-or-self::div[@class='supernova-search-group__submit ']"));
        Assert.assertTrue(ancestorElement4.isDisplayed());

        //attribute
        WebElement attribute1 = driver.findElement(By.xpath("//button[attribute::data-qa='search-button']"));
        Assert.assertTrue(attribute1.isDisplayed());

        WebElement attribute2 = driver.findElement(By.xpath("//a[attribute::data-qa='supernova-help-feedback-link']"));
        Assert.assertTrue(attribute2.isDisplayed());


        //child
        List<WebElement> childelements1 = driver.findElements(By.xpath("//ul/child::*/a[@data-page-analytics-event='article' and @class='news-box-item__link']"));
        Assert.assertEquals(8, childelements1.size());

        WebElement childelements2 = driver.findElement(By.xpath("//*[@class='supernova-dashboard-stats']/child::div[text()='резюме']"));
        Assert.assertTrue(childelements2.isDisplayed());

        //descendant
        List<WebElement> descendant1 = driver.findElements(By.xpath("//ul/descendant::a"));
        Assert.assertEquals(159, descendant1.size());

        List<WebElement> descendant2 = driver.findElements(By.xpath("//*[@class='supernova-navi']/descendant::a"));
        Assert.assertEquals(1, descendant2.size());

        //descendant-or-self
        List<WebElement> descendant3 = driver.findElements(By.xpath("//li/descendant-or-self::span"));
        Assert.assertEquals(188, descendant3.size());

        List<WebElement> descendant4 = driver.findElements(By.xpath("//div/descendant-or-self::a[@data-qa='professions-item-mobile']"));
        Assert.assertEquals(1, descendant4.size());

        //following
        List<WebElement> following1 = driver.findElements(By.xpath("//div[@class='work-in-other-cities']/following::li"));
        Assert.assertEquals(23, following1.size());

        List<WebElement> following2 = driver.findElements(By.xpath("//div/following::h3"));
        Assert.assertEquals(5, following2.size());

        //following-sibling - непонятный, уточнить!!!!
        List<WebElement> followingElement1 = driver.findElements(By.xpath("//div[@class='index-news-box ']//ul//following-sibling::li"));
        Assert.assertEquals(3, followingElement1.size());

        //namespace - вообще не понял

        //parent
        WebElement parent1 = driver.findElement(By.xpath("//*[@data-qa='supernova-help-feedback-link']//parent::div"));
        Assert.assertTrue(parent1.isDisplayed());

        WebElement parent2 = driver.findElement(By.xpath("//*[@data-qa='mainmenu_expertresume']//parent::div"));
        Assert.assertTrue(parent2.isDisplayed());

        //preceding
        WebElement preceding1 = driver.findElement(By.xpath("//*[text()='Соискателям']//preceding::button"));
        Assert.assertTrue(preceding1.isDisplayed());

        WebElement preceding2 = driver.findElement(By.xpath("//*[text()='Соискателям']//preceding::a[text()='Магазины']"));
        Assert.assertTrue(preceding2.isDisplayed());

        //preceding-sibling
        List<WebElement> preceding_sibling1 = driver.findElements(By.xpath("//*[@class='supernova-dashboard-footer']//*[@class='supernova-app-button supernova-app-button_android ']//preceding-sibling::a"));
        Assert.assertEquals(1, preceding_sibling1.size());

        List<WebElement> preceding_sibling2 = driver.findElements(By.xpath("//*[text()='вакансий']//preceding-sibling::div"));
        Assert.assertEquals(1,preceding_sibling2.size());

        //self
        List<WebElement> self1 = driver.findElements(By.xpath("//*[text()='резюме']//self :: *"));
        Assert.assertEquals(1,self1.size());

        List<WebElement> self2 = driver.findElements(By.xpath("//*[@href='/article/27952']/ self :: *"));
        Assert.assertEquals(1,self2.size());



        driver.quit();
    }
}
