package exercise_starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static WebElement getElementExplicit(WebDriver firefoxDriver, By mFilter){
        return new WebDriverWait(firefoxDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mFilter));
    }
}
