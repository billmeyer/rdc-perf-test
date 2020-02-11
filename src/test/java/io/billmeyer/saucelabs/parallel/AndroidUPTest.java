package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidUPTest extends AndroidBaseTest
{
    //    private final static String deviceName = "Samsung_Galaxy_S6_POC116";
//    private static final String platformVersion = "7";
    private final static String deviceName = "Google_Pixel_3_POC150";
    private static final String platformVersion = "9";

    @Test(groups = {"sequential-test"})
    public void androidUPTest0()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[0] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest1()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[1] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest2()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[2] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest3()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[3] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest4()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[4] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest5()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[5] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest6()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[6] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest7()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[7] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest8()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[8] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidUPTest9()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidUPTestResults[9] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }
}