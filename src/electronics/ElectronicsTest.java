package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

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
 * <p>
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
 * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
 */
public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverOnElement(By.xpath("//a[@title='Show products in category Cell phones'][normalize-space()='Cell phones']"));
        //Verify the text “Cell phones
        String expectedresult = "Cell phones";
        String actualresult = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(actualresult, expectedresult);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        // Mouse Hover on “Cell phones” and click
        mouseHoverOnElement(By.xpath("//a[@title='Show products in category Cell phones'][normalize-space()='Cell phones']"));

        // Verify the text “Cell phones”
        String expectedresult = "Cell phones";
        String actualresult = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(actualresult, expectedresult);

        // Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));

        Thread.sleep(2000);

        //Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2/a[contains(text(),'Nokia Lumia 1020')]"));

        // Verify the text “Nokia Lumia 1020”
        String expectedresult1 = "Nokia Lumia 1020";
        String actualresult1 = getTextFromElement(By.xpath("//h1[text()='Nokia Lumia 1020']"));
        Assert.assertEquals(actualresult1, expectedresult1);

        // Verify the price “$349.00”
        String expectedresult2 = "$349.00";
        String actualresult2 = getTextFromElement(By.xpath("//span[text()=' $349.00 ']"));
        Assert.assertEquals(actualresult2, expectedresult2);

        //Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        // Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));

        // Verify the Message "The product has been added to your shopping cart"
        String expectedresult3 = "The product has been added to your shopping cart";
        String actualresult3 = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals(actualresult3, expectedresult3);

        // on Top green Bar After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@title='Close']"));

        // MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[text()='Shopping cart']"));
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

        // Verify the message "Shopping cart"
        String expectedresult4 = "Shopping cart";
        String actualresult4 = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals(actualresult4, expectedresult4);

        // Verify the Total $698.00
        String expectedresult5 = "$698.00";
        String actualresult5 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(actualresult5, expectedresult5);

        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // Verify the Text “Welcome, Please Sign In!”
        String expectedresult6 = "Welcome, Please Sign In!";
        String actualresult6 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(actualresult6, expectedresult6);

        // Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        // Verify the text “Register”
        String expectedresult7 = "Register";
        String actualresult7 = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals(actualresult7, expectedresult7);
        Thread.sleep(2000);
        // Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "savan");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "patel");
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "1");
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "March");
        SelectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "2022");
        sendTextToElement(By.xpath("//input[@id='Email']"), "prime5555@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "prime123");
        sendTextToElement(By.id("ConfirmPassword"), "prime123");

        // Click on “REGISTER”Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        // Verify the message “Your registration completed”

        Assert.assertEquals("User not registered successfully.", "Your registration completed", getTextFromElement(By.xpath("//div[text()='Your registration completed']")));

        // Click on “CONTINUE” tab
        clickOnElement(By.xpath("//div[@class='buttons']//a"));
        // Verify the text “Shopping cart”
        String expectedresult9 = "Shopping cart";
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[text()='Shopping cart']")));
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(2000);
        // Fill the Mandatory fields
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "133");
        sendTextToElement(By.id("BillingNewAddress_City"), "Ahmedabad");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "a 3/4 ");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "380025");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07979087904");

        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']"));

        // Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");
        // Fill all the details
        Thread.sleep(2000);
        sendTextToElement(By.id("CardholderName"), "Savan Kakadiya");
        sendTextToElement(By.id("CardNumber"), "4111111111111111");
        selectByValueFromDropDown(By.id("ExpireYear"), "2028");
        sendTextToElement(By.id("CardCode"), "827");
        // Click on “CONTINUE”
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        // Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Credit Card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        // Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("2nd Day Air", getTextFromElement(By.xpath("//li[@class='shipping-method']//span[contains(text(),'2nd Day Air')]")));
        // Verify Total is “$698.00”
        Assert.assertEquals("$698.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']")));
        // Click on “CONFIRM”
        clickOnElement(By.xpath("//button[text()='Confirm']"));
        // Verify the Text “Thank You”
        Assert.assertEquals("Thank you", getTextFromElement(By.xpath("//h1[text()='Thank you']")));
        // Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']")));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // Verify the text “Welcome to our store!"
        Assert.assertEquals("Welcome to our store", getTextFromElement(By.xpath("//h2[text()='Welcome to our store']")));
        //Click on “Logout” link
        clickOnElement(By.xpath("//a[text()='Log out']"));
        //Verify the URL is “https://demo.nopcommerce.com/
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
