package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TabMenuFragment extends PageObject{

    private By nav_menu = By.className("nav_menu");
    private By li = By.tagName("li");
    private By ol = By.tagName("ol");

    public TabMenuFragment(WebDriver webDriver){
        super(webDriver);
    }

    //Obtiene todos elementos principales del menu ("COFFEE","TEA","MENU","COFFEEHOUSE","SOCIAL IMPACT","STARBUCKS REWARDS","BLOG","GIFT CARDS")
    public List<WebElement> getOptionsMenu(){
        return getElementExplicit(nav_menu).findElements(li);
    }

    //Obtiene todos elementos hijos de un elemento principal del menu
    public List<WebElement> getLiElementsFromTab(){
        return getElementExplicit(ol).findElements(li);
    }

    //Busca que un elemento li contenga el texto indicado, si lo contiene le da click.
    public void seekAndGo(List<WebElement> listElements, String optionToGo){
        for(WebElement li : listElements){
            if(li.getText().equals(optionToGo)){
                li.findElement(By.tagName("a")).click();
                break;
            }
        }
    }
}