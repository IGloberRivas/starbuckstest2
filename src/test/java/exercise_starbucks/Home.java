package exercise_starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home {

    private FirefoxDriver firefoxDriver;

    public Home(FirefoxDriver firefoxDriver){
        this.firefoxDriver = firefoxDriver;
        this.firefoxDriver.get("https://www.starbucks.com/");
    }

    /*  Método que se encarga de obtener el nav_menu, sacar todas las opciones del menú y compararlas contra las esperadas
     *  en un assert
     */
    public void testAssertMenu() {
        final List<String> liTexts = new ArrayList<String>();
        getOptionsMenu().forEach(li ->{ liTexts.add(li.getText()); });
        List<String> liTextsReq = Arrays.asList("COFFEE","TEA","MENU","COFFEEHOUSE","SOCIAL IMPACT","STARBUCKS REWARDS","BLOG","GIFT CARDS");
        Assert.assertEquals(liTextsReq, liTexts);
    }

    /*  Método que se encarga de navergar a la opción de CoffeeTab y posteriormente a la opción de Find Your Perfect Coffee
     */
    public void testAssertAnswers(int ans2, int ans3) {
        seekAndGo(getOptionsMenu(), "COFFEE");
        seekAndGo(new CoffeeTab(firefoxDriver).getLiElementsFromCoffeTab(), "Find Your Perfect Coffee");
        new CoffeeFinder(firefoxDriver).testAssertAnswerQuestions(ans2, ans3);
    }

    /*  Método que se encarga de navergar a la opción de GiftCardTab y posteriormente a la opción de Give a Gift by Email
     */
    public void testAssertGift() {
        seekAndGo(getOptionsMenu(), "GIFT CARDS");
        seekAndGo(new GiftCardTab(firefoxDriver).getLiElementsFromGiftCardTab(), "Give a Gift by Email");
        new EGift(firefoxDriver).selectAnyCard();
        new Encouragement(firefoxDriver).fillFieldsForm();
    }

    /*Método que retorna la lista de li del nav_menu.
    */
    public List<WebElement> getOptionsMenu(){
        return Utils.getElementExplicit(firefoxDriver, By.className("nav_menu")).findElements(By.tagName("li"));
    }

    /*Método que recibe una lista de elementos a recorrer y da click en el elemento indicado por el parámetro optionToGo.
     */
    public void seekAndGo(List<WebElement> listElements, String optionToGo){
        for(WebElement li : listElements){
            if(li.getText().equals(optionToGo)){
                li.findElement(By.tagName("a")).click();
                break;
            }
        }
    }
}