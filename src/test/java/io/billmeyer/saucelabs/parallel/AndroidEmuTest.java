package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidEmuTest extends AndroidBaseTest
{
//    private final static String deviceName = "Google Pixel 3 XL GoogleAPI Emulator";
//    private static final String platformVersion = "10.0";
    private final static String deviceName = "Android GoogleAPI Emulator";
    private static final String platformVersion = "9.0";

    @Test
    public void androidEmuTest0()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[0] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest1()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[1] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest2()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[2] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest3()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[3] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest4()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[4] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest5()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[5] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest6()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[6] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest7()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[7] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest8()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[8] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }

    @Test
    public void androidEmuTest9()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.androidEmuTestResults[9] = calculateCarLoan("Android", deviceName, platformVersion, true, testName);
    }
}