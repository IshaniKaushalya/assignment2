package com.sysco.assignment2.tests;

import com.sysco.assignment2.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import data.ErrorValidationsData;
import data.LoginData;
import functions.ItemCart;
import functions.Login;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class MyAccountPageValidation extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    Login login = new Login();

    @BeforeClass
    public void initClass(ITestContext iTestContext){
        iTestContext.setAttribute("feature","AssignmentTwo - MyAccount");
    }

    @Test(description = "Verify My Account Login Page")
    public void testMyAccountNavigation(){

        softAssert.assertTrue(login.isLoginButtonAvailable(),"Login button is not available");
        Login.navigateToLogin();

        Login.clickLoginButton();
        softAssert.assertEquals(ErrorValidationsData.INVALID_EMAIL,"empty email filed validation");
        softAssert.assertEquals(ErrorValidationsData.EMPTY_PASSWORD,"empty password field validation");

        Login.enterEmail(LoginData.incorrectEmail);
        Login.clickLoginButton();
        softAssert.assertEquals(ErrorValidationsData.INVALID_EMAIL,"invalid email validation");
        softAssert.assertEquals(ErrorValidationsData.EMPTY_PASSWORD,"empty password field validation");

        Login.enterEmail(LoginData.email);
        Login.enterPassword(LoginData.password);
        Login.clickLoginButton();

        softAssert.assertEquals(login.getUserName(),"william  jacob","user name does not appear as william  jacob");
    }
}
