package exercise_starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

public class Encouragement {

    private FirefoxDriver firefoxDriver;

    public Encouragement(FirefoxDriver firefoxDriver){ this.firefoxDriver = firefoxDriver; }

    public void fillFieldsForm(){
        Utils.getElementExplicit(firefoxDriver, By.id("recipient_name")).sendKeys("Lorem Ipsum");
        Utils.getElementExplicit(firefoxDriver, By.id("message")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        Utils.getElementExplicit(firefoxDriver, By.id("pre_range")).findElements(By.tagName("li")).get(new Random().nextInt(4)).click();

        Utils.getElementExplicit(firefoxDriver, By.id("sender_name")).sendKeys("Lorem");
        Utils.getElementExplicit(firefoxDriver, By.id("recipient_email")).sendKeys("ipsum@dolor.amet");
        Utils.getElementExplicit(firefoxDriver, By.id("sender_email")).sendKeys("ipsum@dolor.sit");

        Utils.getElementExplicit(firefoxDriver, By.className("ui-datepicker-trigger")).click();

        List<WebElement> tds = Utils.getElementExplicit(firefoxDriver, By.className("ui-datepicker-calendar")).findElements(By.tagName("td"));
        WebElement tdToday = Utils.getElementExplicit(firefoxDriver, By.className("ui-datepicker-today"));

        selectNextDay(false, tds, tdToday);

        String dateCart = Utils.getElementExplicit(firefoxDriver, By.id("delivery_date")).getAttribute("value");
        String nameCart = Utils.getElementExplicit(firefoxDriver, By.className("hero")).getAttribute("alt");
        String priceCart = Utils.getElementExplicit(firefoxDriver, By.id("pre_range")).findElement(By.tagName("label")).getText();
        Utils.getElementExplicit(firefoxDriver, By.className("action")).click();

        System.out.println(dateCart+" "+ nameCart +" "+ priceCart +" Hi Wrl");

        try {
            new Cart(firefoxDriver).assertCart(dateCart, nameCart, priceCart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void selectNextDay(boolean todayIsFound, List<WebElement> tds, WebElement tdToday) {
        for (WebElement td : tds) {
            if (todayIsFound == true && td.getAttribute("class").equals(" ")) {
                td.click();
                break;

            } else if (todayIsFound == true && td.getAttribute("class").equals("ui-datepicker-other-month")) {

                Utils.getElementExplicit(firefoxDriver, By.className("ui-datepicker-next")).click();
                List<WebElement> tds2 = Utils.getElementExplicit(firefoxDriver, By.className("ui-datepicker-calendar")).findElements(By.tagName("td"));

                for (WebElement td2 : tds2) {
                    if (td2.getAttribute("class").equals(" ")) {
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
