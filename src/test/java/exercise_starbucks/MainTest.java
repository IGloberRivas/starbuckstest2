package exercise_starbucks;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainTest extends FireFoxConfigurationTest{

    @Test
    public void doTestAssertMenu(){
        webDriver.get("https://www.starbucks.com/");

        final List<String> liTexts = new ArrayList<String>();
        new TabMenuFragment(webDriver).getOptionsMenu().forEach(li ->{ liTexts.add(li.getText()); });
        List<String> liTextsReq = Arrays.asList("COFFEE","TEA","MENU","COFFEEHOUSE","SOCIAL IMPACT","STARBUCKS REWARDS","BLOG","GIFT CARDS");

        Assert.assertEquals(liTextsReq, liTexts);
    }

    @Test(dataProvider = "answers")
    public void doTestAssertAnswers(int ans1, int ans2, int ans3, int ans4){
        webDriver.get("https://www.starbucks.com/");

        TabMenuFragment tabMenuFragment = new TabMenuFragment(webDriver);
        tabMenuFragment.seekAndGo(tabMenuFragment.getOptionsMenu(), "COFFEE");
        tabMenuFragment.seekAndGo(tabMenuFragment.getLiElementsFromTab(), "Find Your Perfect Coffee");

        Assert.assertEquals(true, new CoffeeFinder(webDriver).answerQuestionsAndGetResult(ans1, ans2, ans3, ans4));
    }

    @Test
    public void doTestAssertGift() throws Exception{
        webDriver.get("https://www.starbucks.com/");

        TabMenuFragment tabMenuFragment = new TabMenuFragment(webDriver);
        tabMenuFragment.seekAndGo(tabMenuFragment.getOptionsMenu(), "GIFT CARDS");
        tabMenuFragment.seekAndGo(tabMenuFragment.getLiElementsFromTab(), "Give a Gift by Email");

        new EGift(webDriver).selectAnyCard();

        String dateCart1 = new Encouragement(webDriver).fillFieldsFormAndReturnDate();
        String dateCart2 = new Cart(webDriver).getDateSelected();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date(sdf.parse(dateCart1).getTime());
        Date date2 = new Date(sdf.parse(dateCart2).getTime());

        Assert.assertEquals(date1, date2);
    }
}
