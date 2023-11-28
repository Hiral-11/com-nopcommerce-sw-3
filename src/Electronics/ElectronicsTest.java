package Electronics;

import Utilities.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.UUID;

/**
 * 1. Create the class ElectronicsTest
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 * 1.1 Mouse Hover on “Electronics” Tab
 * 1.2 Mouse Hover on “Cell phones” and click
 * 1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 * 2.1 Mouse Hover on “Electronics” Tab
 * 2.2 Mouse Hover on “Cell phones” and click
 * 2.3 Verify the text “Cell phones”
 * 2.4 Click on List View Tab
 * 2.5 Click on product name “Nokia Lumia 1020” link
 * 2.6 Verify the text “Nokia Lumia 1020”
 * 2.7 Verify the price “$349.00”
 * 2.8 Change quantity to 2
 * 2.9 Click on “ADD TO CART” tab
 * 2.10 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.12 Verify the message "Shopping cart"
 * 2.13 Verify the quantity is 2
 * 2.14 Verify the Total $698.00
 * 2.15 click on checkbox “I agree with the terms of service”
 * 2.16 Click on “CHECKOUT”
 * 2.17 Verify the Text “Welcome, Please Sign In!”
 * 2.18 Click on “REGISTER” tab
 * 2.19 Verify the text “Register”
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “REGISTER” Button
 * 2.22 Verify the message “Your registration completed”
 * 2.23 Click on “CONTINUE” tab
 * 2.24 Verify the text “Shopping card”
 * 2.25 click on checkbox “I agree with the terms of service”
 * 2.26 Click on “CHECKOUT”
 * 2.27 Fill the Mandatory fields
 * 2.28 Click on “CONTINUE”
 * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 * 2.30 Click on “CONTINUE”
 * 2.31 Select Radio Button “Credit Card”
 * 2.32 Select “Visa” From Select credit card dropdown
 * 2.33 Fill all the details
 * 2.34 Click on “CONTINUE”
 * 2.35 Verify “Payment Method” is “Credit Card”
 * 2.36 Verify “Shipping Method” is “2nd Day Air”
 * 2.37 Verify Total is “$698.00”
 * 2.38 Click on “CONFIRM”
 * 2.39 Verify the Text “Thank You”
 * 2.40 Verify the message “Your order has been successfully processed!”
 * 2.41 Click on “CONTINUE”
 * 2.42 Verify the text “Welcome to our store”
 * 2.43 Click on “Logout” link
 * 2.44 Verify the URL is “https://demo.nopcommerce.com
 */

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public  void openBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.linkText("Electronics"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.linkText("Cell phones"));
        //2.3 Verify the text “Cell phones”
        verifyThis("Cell phones",By.xpath("//h1[normalize-space()='Cell phones']"));
        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[@title='List']"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyThis("Nokia Lumia 1020",By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        // 2.7 Verify the price “$349.00”
        verifyThis("$349.00",By.id("price-value-20"));
        //2.8 Change quantity to 2
        driver.findElement(By.id("product_enteredQuantity_20")).sendKeys(Keys.BACK_SPACE);
        sendTextToElement(By.id("product_enteredQuantity_20"),"2");
        //2.9 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.
        verifyThis("The product has been added to your shopping cart",By.xpath("//body/div[@id='bar-notification']/div[1]"));
        clickOnElement(By.xpath("//span[@class='close']"));
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickOnElement(By.xpath("//span[@title='Close']"));// x for green tab
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("(//button[normalize-space()='Go to cart'])[1]"));
        //2.12 Verify the message "Shopping cart"
        Thread.sleep(1000);
        verifyThis("Shopping cart",By.xpath("//h1[normalize-space()='Shopping cart']"));
        //2.13 Verify the quantity is 2
        Thread.sleep(2000);
        String expected="2";
        String actual=driver.findElement(By.xpath("(//input[@value])[2]")).getAttribute("value");
        Assert.assertEquals("Not displayed correctly",expected,actual);
        //2.14 Verify the Total $698.00
        verifyThis("$698.00",By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyThis("Welcome, Please Sign In!",By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[starts-with(text(),'Reg')]"));
        //2.19 Verify the text “Register”
        verifyThis("Register",By.xpath("//h1[text()='Register']"));
        //2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@name='Gender' and @value='F']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Sun");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Moon");
        String email= "random-" + UUID.randomUUID().toString() + "@example.com";
        sendTextToElement(By.xpath("//input[contains(@id,'E')]"),email);
        sendTextToElement(By.xpath("//input[@name='Password']"),"MoonSun@123");
        sendTextToElement(By.xpath("//input[@name='ConfirmPassword']"),"MoonSun@123");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.22 Verify the message “Your registration completed”
        verifyThis("Your registration completed",By.xpath("//div[text()='Your registration completed']"));
        // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping card”
        verifyThis("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //click on the ‘Login’ link
        clickOnElement(By.xpath("//a[text()='Log in']"));
        //Enter valid username
        sendTextToElement(By.xpath("//input[@id='Email']"),email);
        // Enter valid password
        sendTextToElement(By.xpath("//input[@id='Password']"),"MoonSun@123");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[@type='submit' and text()='Log in']"));
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "23 green road ");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "UB7 7JP");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07889564123");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 0);
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Prime Testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5105105105105100");
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"), 1);
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"), 2);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "769");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyThis("Payment Method: Credit Card",By.xpath("//li[@class='payment-method']"));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyThis("Shipping Method: 2nd Day Air",By.xpath("//li[@class='shipping-method']"));
        //2.37 Verify Total is “$698.00”
        verifyThis("$698.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyThis("Thank you",By.xpath("//div[@class='page-title']//h1[text()='Thank you']"));
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyThis("Your order has been successfully processed!",By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        //2.42 Verify the text “Welcome to our store”
        verifyThis("Welcome to our store",By.xpath("//h2[normalize-space()='Welcome to our store']"));
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals("Log out not successfully","https://demo.nopcommerce.com/",actualUrl);
    }
}

