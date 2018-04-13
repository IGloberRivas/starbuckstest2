package exercise_starbucks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class FireFoxConfigurationTest {

    protected static WebDriver webDriver;

    @DataProvider(name = "answers")
    public static Object[][] answers() {
        return new Object[][] { {0,0,0,0}, {0,1,1,0}, {0,2,2,0}};
    }

    @BeforeClass
    public static void setWebDriver(){

        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "consoleLogs_Firefox.txt");

        FirefoxOptions firefoxOptions = new FirefoxOptions(DesiredCapabilities.firefox());

        firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        firefoxOptions.addPreference("--log", "trace");
        firefoxOptions.addPreference("browser.popups.showPopupBlocker", false);
        firefoxOptions.addPreference("security.sandbox.content.level", 5);
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setProfile(new FirefoxProfile());

        webDriver = new FirefoxDriver(firefoxOptions);
    }

    /*@AfterClass
    public void cleanUp(){
        webDriver.manage().deleteAllCookies();
        webDriver.close();
    }*/
}
