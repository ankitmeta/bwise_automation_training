import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class FirstDemo {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(3000);
        driver.close();
        driver.quit();

//        FirstDemo firstDemo = new FirstDemo();
//        firstDemo.browserOptions();




    }

    public void basicTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(3000);
    }

    public void browserOptions() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(3000);
    }
}
