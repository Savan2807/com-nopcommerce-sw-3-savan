package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
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
 * <p>
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
 * 2.37 Verify the text “Welcome to our store”
 */

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        List<WebElement> beforeFilterProductNames = driver.findElements(By.cssSelector(".product-title"));
        List<String> beforeFilterProductNamesList = new ArrayList<>();
        for (WebElement p : beforeFilterProductNames) {
            beforeFilterProductNamesList.add(p.getText());
        }
        Collections.sort(beforeFilterProductNamesList);
        Collections.reverse(beforeFilterProductNamesList);
        selectByValueFromDropDown(By.id("products-orderby"), "6");
        Thread.sleep(2000);
        List<WebElement> afterFilterProductNames = getMultipleElements(By.className("product-title"));
        List<String> afterFilterProductNamesList = new ArrayList<>();
        for (WebElement s : afterFilterProductNames) {
            afterFilterProductNamesList.add(s.getText());
        }
        Assert.assertEquals("Products are not sorted in descending order", afterFilterProductNamesList, beforeFilterProductNamesList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Desktops"));
        SelectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        //Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[text()='Add to cart']"));
        //Verify the Text "Build your own computer
        String expectedresult = "Build your own computer";
        String actualresult = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(actualresult, expectedresult);
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(200);
        SelectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class
        Thread.sleep(1000);
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_2']"), "8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        //clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //Verify the price "$1,475.00
        String expctedresult1 = "$1,475.00";
        String actualresult1 = getTextFromElement(By.xpath("//span[@class='price-value-1']"));
        //Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expctedresult2 = "The product has been added to your shopping cart";
        String actualresult2 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expctedresult2, actualresult2);
        //click on close button
        clickOnElement(By.xpath("//span[@class='close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[text()='Go to cart']"));
        //Verify the message "Shopping cart"
        Thread.sleep(2000);
        String expectedresult3 = "Shopping cart";
        String actualresult3 = getTextFromElement(By.xpath("//a[text()='Shopping cart']"));
        Assert.assertEquals(actualresult3, expectedresult3);
        //Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='quantity up']"));
        //Verify the Total"$2,950.00"
        Thread.sleep(1000);
        String expectedresult4 = "$2,950.00";
        String actualresult4 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals(expectedresult4, actualresult4);
        //click on checkbox “I agree with the terms of service
        clickOnElement(By.id("termsofservice"));
        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //Verify the Text “Welcome, Please Sign In!”
        String expectedresult5 = "Welcome, Please Sign In!";
        String actualresult5 = getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals(actualresult5, expectedresult5);
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        //Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.FirstName']"),"Savan");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.LastName']"),"Kakadiya");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.Email']"),"xyz@gmail.com");
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='BillingNewAddress.CountryId']"), "United Kingdom");
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='BillingNewAddress.StateProvinceId']"), "Other");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"leicester");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.Address1'] "),"boller road leicester");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']"),"898977");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.PhoneNumber']"),"0909090909");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']"));
        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //Click on “CONTINUE
        clickOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; ShippingMethod.save()']"));
        //Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //Click on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //     clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //Select “Master card” From Select credit card dropdown
        Thread.sleep(1000);
        SelectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //Fill all the details
        sendTextToElement(By.xpath("//input[@name='CardholderName']"),"savan kakadiya");
        sendTextToElement(By.xpath("//input[@name='CardNumber']") ,"5555 5555 5555 4444");
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='ExpireMonth']"), "01");
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='ExpireYear']"), "2028");
        sendTextToElement(By.xpath("//input[@name='CardCode']"),"123");
        //Click on continue
        clickOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; PaymentInfo.save()']"));
        //Verify “Payment Method” is “Credit Card
        String expectedresult6 = "Credit Card";
        String actualresult6 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals(actualresult6, expectedresult6);
        //Verify “Shipping Method” is “Next Day Air”
        String expectedresult7 = "Next Day Air";
        String actualresult7 = getTextFromElement(By.xpath("//li[@class='shipping-method']//span[contains(text(),'Next Day Air')]"));
        Assert.assertEquals(actualresult7, expectedresult7);
        //Verify Total is “$2,950.00”
        String expectedresult8 = "$2,950.00";
        String actualresult8 = getTextFromElement(By.xpath("//span[@class='value-summary' and text()='$2,950.00']"));
        Assert.assertEquals(expectedresult8, actualresult8);
        //Click on “CONFIRM
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //Verify the Text “Thank You”
        String expectedresult9 = "Thank You";
        String actualresult9 = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals(actualresult8, expectedresult8);
        //Verify the message “Your order has been successfully processed!”
        String expectedresult10 = "Your order has been successfully processed!";
        String actualresult10 = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        Assert.assertEquals(actualresult10, expectedresult10);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //Verify the text “Welcome to our store
        String expectedresult11 = "Welcome to our store";
        String actualresult11 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        Assert.assertEquals(actualresult11, expectedresult11);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}





