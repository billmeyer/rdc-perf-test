package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidLocalTest extends AndroidBaseTest
{
    private final static String deviceName = "Google Pixel 3 XL GoogleAPI Emulator";
    private static final String platformVersion = "10";

    @Test
    public void androidLocalTest0()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[0] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest1()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[1] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest2()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[2] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest3()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[3] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest4()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[4] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest5()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[5] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest6()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[6] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest7()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[7] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest8()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[8] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void androidLocalTest9()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidLocalTestResults[9] = calculateCarLoan("Android", deviceName, platformVersion, false, true, testName);
    }
}