package exercise_starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CoffeeFinder {

    private FirefoxDriver firefoxDriver;

    public CoffeeFinder(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    /*
     * Método que se encarga de contestar las preguntas del Coffee Finder
     */
    public void testAssertAnswerQuestions(int ans2, int ans3) {
        firefoxDriver.findElement(By.id("question1")).findElements(By.tagName("button")).get(0).click();

        Utils.getElementExplicit(firefoxDriver, By.id("question2")).findElements(By.tagName("button")).get(ans2).click();
        Utils.getElementExplicit(firefoxDriver, By.id("question3")).findElements(By.tagName("button")).get(ans3).click();
        Utils.getElementExplicit(firefoxDriver, By.id("question4")).findElements(By.tagName("button")).get(0).click();
        Utils.getElementExplicit(firefoxDriver, By.id("find-my-coffee")).click();

        Assert.assertEquals(true, Utils.getElementExplicit(firefoxDriver, By.id("results-headline")).isDisplayed());
    }
}
