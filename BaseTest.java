package org.tw.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestResult;
import org.tw.context.WebDriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    protected void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        String extension="/Users/cemgurbuz/IdeaProjects";
        options.addArguments("load-extension=extension");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverContext.setDriver(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(2000));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to the extension window");
                break;
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult result) {
        driver.quit();
    }

}