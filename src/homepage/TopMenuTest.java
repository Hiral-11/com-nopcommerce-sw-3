package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){

        //click on menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = '" + menu + "']"));
        //verify navigation of page
        String expected = menu;
        String actual = driver.findElement(By.xpath("//h1[contains(text(),'" + menu + "')]")).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void verifyPageNavigation(){

        selectMenu("Computers");
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");

    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}