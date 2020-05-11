package com.sysco.assignment2.tests;

import com.sysco.assignment2.utils.TestBase;
import data.ErrorValidationsData;
import data.LoginData;
import data.PaymentData;
import data.ShippingData;
import functions.ItemCart;
import functions.Login;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ItemsCartPage;

public class AddItemToCart extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    ItemsCartPage itemsCartPage = new ItemsCartPage();

    @BeforeClass
    public void initClass(ITestContext iTestContext){
        iTestContext.setAttribute("feature","AssignmentTwo - AddItemToCart");
    }

    @Test(description = "Verify Adding Items to Cart")
    public void testAddItemToCart(){

        Login.navigateToLogin();
        Login.enterEmail(LoginData.email);
        Login.enterPassword(LoginData.password);
        Login.clickLoginButton();

        ItemCart.checkCartStatus();
        ItemCart.navigateToCategory();
        ItemCart.selectRandomItem();
        ItemCart.selectSize();
        ItemCart.clickAddToCart();
        softAssert.assertTrue(ItemCart.isItemNameAvailable(),"item name is incorrect");
        softAssert.assertTrue(ItemCart.isItemPriceAvailable(),"item price is incorrect");
        ItemCart.clickCart();
        ItemCart.clickProceedToCheckOut();
//        ItemCart.clickContinue();
//        softAssert.assertEquals(ItemCart.getStreetAddressError(), ErrorValidationsData.ERROR);
//        softAssert.assertEquals(ItemCart.getSuburbsError(), ErrorValidationsData.ERROR);
//        softAssert.assertEquals(ItemCart.getStateProvinceError(), ErrorValidationsData.ERROR);
//        softAssert.assertEquals(ItemCart.getPostCodeError(), ErrorValidationsData.ERROR);
//        softAssert.assertEquals(ItemCart.getPhoneNumberError(), ErrorValidationsData.ERROR);
        ItemCart.enterPostCode(ShippingData.POSTCODE);
        ItemCart.selectPostCode();
        ItemCart.enterStreetAddress(ShippingData.STREET_ADDRESS);
        ItemCart.enterPhoneNumber(ShippingData.PHONE_NO);
        ItemCart.clickContinue();

        ItemCart.clickCreditCard();
        ItemCart.clickPlaceOrder();
        softAssert.assertEquals(ItemCart.getEmptyCreditCardError(),ErrorValidationsData.EMPTY_CREDIT_CARD);

    }

}
