package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends PageObject{

    private By delivery = By.className("delivery");

    public Cart(WebDriver webDriver){
        super(webDriver);
    }

    public String getDateSelected() {

        String[] partsDate = getElementExplicit(delivery).getText().split("/");

        if(partsDate[0].length() == 1){ partsDate[0] = "0"+partsDate[0]; }
        if(partsDate[1].length() == 1){ partsDate[1] = "0"+partsDate[1]; }

        return  partsDate[0]+"/"+partsDate[1]+"/"+partsDate[2];
    }
}