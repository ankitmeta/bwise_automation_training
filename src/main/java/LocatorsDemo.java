import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class LocatorsDemo {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 6000);

        LocatorsDemo locatorsDemo = new LocatorsDemo();

        locatorsDemo.alertTest();

        driver.close();
        driver.quit();
    }

    public void locatorsTest() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(3000);

        String title = driver.getTitle();
        WebElement email = driver.findElement(By.xpath("//label[.='Email address*']"));

        String lblValue = email.getText();


        if(email.isDisplayed()){
            WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
            firstName.sendKeys("Ankit");

            WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
            lastName.sendKeys("Nigam");

            driver.findElement(By.xpath("//input[@value='Male']")).click();

            driver.findElement(By.id("firstpassword")).sendKeys("BlaBla");
        }

        Thread.sleep(5000);
    }

    public void waitTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Register.html");

        WebElement button = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("xxyz")));
        button.click();

        Thread.sleep(5000);
    }

    public void actionTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        WebElement searchText = webDriverWait.until(
                ExpectedConditions.visibilityOf(driver.findElement((By.id("search_query_top")))));

        Actions builder = new Actions(driver);

        Action seriesOfActions = builder
                .moveToElement(searchText)
                .click()
                .keyDown(searchText, Keys.SHIFT)
                .sendKeys(searchText, "summer")
                .keyUp(searchText, Keys.SHIFT)
                .sendKeys(Keys.ENTER)
                .build();

        seriesOfActions.perform();

        Thread.sleep(5000);

    }

    public void doubleClick() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://yari-demos.prod.mdn.mozit.cloud/en-US/docs/Web/API/Element/dblclick_event/_sample_.Examples.html");

        WebElement clickButton = driver.findElement(By.xpath("//body//aside"));

        Actions actions = new Actions(driver);
        actions.doubleClick(clickButton).build().perform();
        Thread.sleep(1000);
        actions.doubleClick(clickButton).build().perform();
        Thread.sleep(1000);
        actions.doubleClick(clickButton).build().perform();
        Thread.sleep(1000);
        actions.doubleClick(clickButton).build().perform();
        Thread.sleep(1000);
        actions.doubleClick(clickButton).build().perform();

        Thread.sleep(3000);
    }

    public void alertTest() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        //WebElement clickButton = driver.findElement(By.id("button1"));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(clickButton)).click();

        WebElement clickButton4 = driver.findElement(By.id("button4"));
        clickButton4.click();
        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();


        Thread.sleep(5000);
    }



}
