package com.sysco.assignment2.utils;

import com.sysco.assignment2.common.Constant;
import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.BasePage;
import utils.DriverSetUpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Listeners(SyscoLabListener.class)
public class TestBase {
    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;
    private SyscoLabWUI syscoLabWUI;

    @BeforeClass
    public void init() {
        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
        DriverSetUpUtil.setToRunLocally();
        syscoLabWUI = new SyscoLabWUI(null);
        try {
            String URL = URLEncoder.encode(Constant.APP_URL, "UTF-8");
            syscoLabWUI.navigateTo(Constant.APP_URL);
            syscoLabWUI.getDriver().manage().window().maximize();
            BasePage.setWebDriver(syscoLabWUI.getDriver());
        } catch (UnsupportedEncodingException e) {
            LoggerUtil.logERROR("Unable to encode URL", e);
        }
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        syscoLabWUI.quit();

//        try {
//            syscoLabQCenter.setProjectName(Constant.TEST_PROJECT);
//            syscoLabQCenter.setEnvironment(Constant.TEST_ENV);
//
//            syscoLabQCenter.setRelease(Constant.TEST_RELEASE);
//            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
//            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
//            syscoLabQCenter.setClassName(iTestContext.getClass().getName());
//
//            if (Constant.UPDATE_DASHBOARD)
//                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
