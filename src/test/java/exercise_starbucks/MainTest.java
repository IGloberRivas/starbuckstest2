package exercise_starbucks;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {

    private FirefoxDriver firefoxDriver;

    @DataProvider(name = "answers")
    public static Object[][] answers() {
        return new Object[][] { {0,0}, {1,1}, {2,2}};
    }

    @BeforeTest
    public void initGeckoDriverAndGoHome(){
        System.setProperty("webdriver.gecko.driver", "src/test/gecko/geckodriver-v0.19.1-win64/geckodriver.exe");
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void doTestAssertMenu() throws Exception{
        new Home(firefoxDriver).testAssertMenu();
    }

    @Test(dataProvider = "answers")
    public void doTestAssertAnswers(int ans2, int ans3) throws Exception{
        new Home(firefoxDriver).testAssertAnswers(ans2, ans3);
    }

    @Test
    public void doTestAssertGift() throws Exception{
        new Home(firefoxDriver).testAssertGift();
    }
}
