package Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private Properties properties = new Properties();

    private void loadProperties() {
        try(FileInputStream fileInput = new FileInputStream("C:\\Users\\SahilSubba\\eclipse-workspace\\PursuitSoftwareEdge\\config.properties")){
            properties.load(fileInput);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setup() {
//        driver = new EdgeDriver();
////        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loadProperties();
//        driver.get(properties.getProperty("URL"));
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
