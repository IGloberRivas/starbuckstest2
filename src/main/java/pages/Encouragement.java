package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Encouragement extends PageObject{

    private By recipientName = By.id("recipient_name");
    private By message = By.id("message");
    private By preRange = By.id("pre_range");
    private By senderName = By.id("sender_name");
    private By recipientEmail = By.id("recipient_email");
    private By senderEmail = By.id("sender_email");
    private By dateTrigger = By.className("ui-datepicker-trigger");
    private By dateCalendar = By.className("ui-datepicker-calendar");
    private By td = By.tagName("td");
    private By dateToday = By.className("ui-datepicker-today");
    private By deliveryDate = By.id("delivery_date");
    private By hero = By.className("hero");
    private By label = By.tagName("label");
    private By action = By.className("action");
    private By dateNext = By.className("ui-datepicker-next");

    private String value = "value";
    private String alt = "alt";
    private String mClass = "class";
    private String dateOtherMonth = "ui-datepicker-other-month";

    public Encouragement(WebDriver webDriver){
        super(webDriver);
    }

    public String fillFieldsFormAndReturnDate(){
        getElementExplicit(recipientName).sendKeys("Lorem Ipsum");
        getElementExplicit(message).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        getElementExplicit(preRange).findElements(li).get(new Random().nextInt(4)).click();

        getElementExplicit(senderName).sendKeys("Lorem");
        getElementExplicit(recipientEmail).sendKeys("ipsum@dolor.amet");
        getElementExplicit(senderEmail).sendKeys("ipsum@dolor.sit");

        getElementExplicit(dateTrigger).click();

        List<WebElement> tds = getElementExplicit(dateCalendar).findElements(td);
        WebElement tdToday = getElementExplicit(dateToday);

        selectNextDay(false, tds, tdToday);

        String dateCart = getElementExplicit(deliveryDate).getAttribute(value);
        String nameCart = getElementExplicit(hero).getAttribute(alt);
        String priceCart = getElementExplicit(preRange).findElement(label).getText();
        getElementExplicit(action).click();

        System.out.println(dateCart+" "+ nameCart +" "+ priceCart);

        return dateCart;
    }

    private void selectNextDay(boolean todayIsFound, List<WebElement> tds, WebElement tdToday) {
        for (WebElement td : tds) {
            if (todayIsFound  && td.getAttribute(mClass).equals(" ")) {
                td.click();
                break;

            } else if (todayIsFound  && td.getAttribute(mClass).equals(dateOtherMonth)) {

                getElementExplicit(dateNext).click();
                List<WebElement> tds2 = getElementExplicit(dateCalendar).findElements(this.td);

                for (WebElement td2 : tds2) {
                    if (td2.getAttribute(mClass).equals(" ")) {
                        td2.click();
                        break;
                    }
                }

                break;
            }

            if (td.equals(tdToday)) {
                todayIsFound = true;
            }
        }
    }
}
