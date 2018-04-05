package exercise_starbucks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FireFoxConfigurationTest {

    protected static WebDriver webDriver;

    @DataProvider(name = "answers")
    public static Object[][] answers() {
        return new Object[][] { {0,0,0,0}, {0,1,1,0}, {0,2,2,0}};
    }

    @BeforeClass
    public static void setWebDriver(){
        Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver-v0.19.1-win64/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", path.toString());
        webDriver = new FirefoxDriver();
    }

    /*@AfterClass
    public void cleanUp(){
        webDriver.manage().deleteAllCookies();
        webDriver.close();
    }*/
}
