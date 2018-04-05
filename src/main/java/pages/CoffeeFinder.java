package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoffeeFinder extends PageObject{

    private By question1 = By.id("question1");
    private By question2 = By.id("question2");
    private By question3 = By.id("question3");
    private By question4 = By.id("question4");
    private By button = By.tagName("button");
    private By findMyCoffee =  By.id("find-my-coffee");
    private By resultsHeadLine = By.id("results-headline");

    public CoffeeFinder(WebDriver webDriver) {
        super(webDriver);
    }

    /*
     * Método que se encarga de contestar las preguntas del Coffee Finder
     */
    public boolean answerQuestionsAndGetResult(int ans1, int ans2, int ans3, int ans4) {
        getElementExplicit(question1).findElements(button).get(ans1).click();
        getElementExplicit(question2).findElements(button).get(ans2).click();
        getElementExplicit(question3).findElements(button).get(ans3).click();
        getElementExplicit(question4).findElements(button).get(ans4).click();
        getElementExplicit(findMyCoffee).click();

        return getElementExplicit(resultsHeadLine).isDisplayed();
    }
}
