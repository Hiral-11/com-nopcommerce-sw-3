package Utilities;

import brosefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
     /*
    This method will click on element
    */

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    /*
    This method will return text from element
    */
    public String getTextFromElement(By by){

        return driver.findElement(by).getText();
    }

    /*
    This method will send text to element
    */
    public void sendTextToElement(By by, String text){

        driver.findElement(by).sendKeys(text);
    }

    /*
    This method will select the option by visible text
    */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);

        //Select by visible text
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String value){

        new Select(driver.findElement(by)).selectByValue(value);

    }

    public void selectByIndexFromDropDown(By by, int index){

        new Select(driver.findElement(by)).selectByIndex(index);

    }
    /**
     * this is to verify
     */
    public void verifyThis(String expectedResult,By by){
        String actualResult=driver.findElement(by).getText();
        Assert.assertEquals("is not displayed correctly",expectedResult,actualResult);
    }

    /**
     * This method will get text from element
     */
    public String getTextElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will verify the text
     */
    public void verifyText(String displayMessage, String expectedText, String actualText) {
        Assert.assertEquals(displayMessage, expectedText, actualText);
    }

    public void mouseHover(By by){
        //Computer -------> Software and Click
        WebElement from = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(from).click().build().perform();
    }
    public void mouseHoverFromTo(By byFrom,By byTo){
        //Computer -------> Software and Click
        WebElement from = driver.findElement(byFrom);
        WebElement to = driver.findElement(byTo);
        Actions actions = new Actions(driver);
        actions.moveToElement(from).moveToElement(to).click().build().perform();
    }

    /**
     * This method will have actions on mouseHover
     */
    public void mouseHoverOnElements(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }

    /**
     * This method will have click action on mousehover element
     */
    public void clickMouseHoverOnElements(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    /**
     * This method will verify the element
     */
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
}
