package exercise_starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class EGift {

    private FirefoxDriver firefoxDriver;

    public EGift(FirefoxDriver firefoxDriver){ this.firefoxDriver = firefoxDriver; }

    public void selectAnyCard(){
        Utils.getElementExplicit(firefoxDriver, By.id("egift-categories"))
                .findElements(By.tagName("li")).get(new Random().nextInt(10)).click();
    }
}
