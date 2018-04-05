package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class EGift extends PageObject{

    private By categories = By.id("egift-categories");
    private By li = By.tagName("li");

    public EGift(WebDriver webDriver){
        super(webDriver);
    }

    public void selectAnyCard(){
        getElementExplicit(categories).findElements(li).get(new Random().nextInt(10)).click();
    }
}
