package computer;

import Utilities.Utility;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 1. Create class “TestSuite”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu.
 * 1.2 Click on Desktop
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop
 * 2.3 Select Sort By position "Name: A to Z"
 * 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class.
 * 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]"
 * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
 * [+$5.00]"
 * 2.11 Verify the price "$1,475.00"
 * 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.15 Verify the message "Shopping cart"
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service”
 * 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!”
 * 2.21Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field
 * 2.23 Click on “CONTINUE”
 * 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 2.33 Verify Total is “$2,950.00”
 * 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You”
 * 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store
 */

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //click on computer menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = 'Computers']"));
        //click on desktop
        clickOnElement(By.xpath("//div[@class = 'sub-category-item']/h2/a[normalize-space() = 'Desktops']"));
        selectByValueFromDropDown(By.xpath("//select[@id = 'products-orderby']"), "6");
        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'details']//a"));

        //verify descending order
        boolean isDescending = true;
        for (int i = 0; i < items.size() - 1; i++) {
            String currentElement = items.get(i).getText();
            String nextElement = items.get(i + 1).getText();
            if (currentElement.compareTo(nextElement) > 0) {
                isDescending = false;
                break;
            }
        }

        if (isDescending) {
            System.out.println("Elements are in descending order.");
        } else {
            System.out.println("Elements are not in descending order.");
        }
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1click on computer menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = 'Computers']"));
        //2.2click on desktops
        clickOnElement(By.xpath("//div[@class = 'sub-category-item']/h2/a[normalize-space() = 'Desktops']"));
        //2.3 select A to Z
        selectByVisibleTextFromDropDown(By.id("products-orderby"),"Name: A to Z");
        //2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        //2.5Verify the Text"Build your own computer"
        verifyElements("error","Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7 Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(1000);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        clickOnElement(By.id("product_attribute_5_12"));
        //2.11 Verify the price "$1,475.00"
        verifyElements("error","$1,470.00",By.id("price-value-1"));
        //2.12 Click on "ADD TO CARD" Button
        clickOnElement(By.id("add-to-cart-button-1"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.
        verifyElements("error","The product has been added to your shopping cart",By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverOnElements(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.15 Verify the message "Shopping cart"
        verifyElements("error","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).sendKeys(Keys.BACK_SPACE);
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
        clickOnElement(By.id("updatecart"));
//        2.17 Verify the Total"$2,950.00"
        Thread.sleep(2000);
        verifyThis("$2,950.00",By.xpath("//span[@class='product-subtotal']"));
//        2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
//        2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
//        2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyThis("Welcome, Please Sign In!",By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
//        2.21Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
//        2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Sun");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Moon");
        sendTextToElement(By.id("BillingNewAddress_Email"), "Sunmoon@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "23 green road ");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "UB7 7JP");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07889564123");
//        2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
//        2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
//        2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
//        2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
       // clickOnElement(By.xpath());add the continue button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
//        2.27 Select “Master card” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 1);
//        2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Prime Testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5105105105105100");
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"), 1);
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"), 2);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "769");
//        2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
//        2.30 Verify “Payment Method” is “Credit Card”
        verifyThis("Payment Method: Credit Card",By.xpath("//li[@class='payment-method']"));
//        2.32 Verify “Shipping Method” is “Next Day Air”
        verifyThis("Shipping Method: Next Day Air",By.xpath("//li[@class='shipping-method']"));
//        2.33 Verify Total is “$2,950.00”
        verifyThis("$2,950.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
//        2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
//        2.35 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyThis("Thank you",By.xpath("//div[@class='page-title']//h1[text()='Thank you']"));
//        2.36 Verify the message “Your order has been successfully processed!”
        verifyThis("Your order has been successfully processed!",By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
//        2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
//        2.37 Verify the text “Welcome to our store”
        verifyThis("Welcome to our store",By.xpath("//h2[normalize-space()='Welcome to our store']"));
    }
}