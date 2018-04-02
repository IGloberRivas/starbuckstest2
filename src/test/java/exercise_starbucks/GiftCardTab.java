package exercise_starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GiftCardTab {

    private FirefoxDriver firefoxDriver;

    public GiftCardTab(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    //Realizamos una espera para que el GiftCardTav despliegue sus elementos y retornamos una lista de esos elementos
    public List<WebElement> getLiElementsFromGiftCardTab(){
        return Utils.getElementExplicit(firefoxDriver, By.tagName("ol")).findElements(By.tagName("li"));
    }

}
