package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidTOTest extends AndroidBaseTest
{
//    private final static String deviceName = "Samsung_Galaxy_S6_POC116";
//    private static final String platformVersion = "7";
    private final static String deviceName = "Google_Pixel_3_POC150";
    private static final String platformVersion = "9";

    @Test(groups = {"sequential-test"})
    public void androidTOTest0()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[0] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest1()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[1] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest2()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[2] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest3()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[3] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest4()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[4] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest5()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[5] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest6()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[6] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest7()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[7] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest8()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[8] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void androidTOTest9()
    {
        String testName = new Object()
        {
        }.getClass().getEnclosingMethod().getName();
        TestResults.androidTOTestResults[9] = calculateCarLoan("Android", deviceName, platformVersion, false, testName);
    }
}