package exercise_starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cart {

    private FirefoxDriver firefoxDriver;

    public Cart(FirefoxDriver firefoxDriver){ this.firefoxDriver = firefoxDriver; }

    public void assertCart(String dateStr1, String nameStr, String priceStr) throws ParseException {

        String[] partsDate = Utils.getElementExplicit(firefoxDriver, By.className("delivery")).getText().split("/");

        if(partsDate[0].length() == 1){ partsDate[0] = "0"+partsDate[0]; }
        if(partsDate[1].length() == 1){ partsDate[1] = "0"+partsDate[1]; }

        String dateStr2 = partsDate[0]+"/"+partsDate[1]+"/"+partsDate[2];

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date(sdf.parse(dateStr1).getTime());
        Date date2 = new Date(sdf.parse(dateStr2).getTime());

        Assert.assertEquals(date1, date2);
    }

}