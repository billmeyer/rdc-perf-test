package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class IOSSimTest extends IOSBaseTest
{
    private final static String deviceName = "iPhone 11 Pro Max Simulator";
    private static final String platformVersion = "13.0";

    @Test
    public void iosSimTest0()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[0] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest1()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[1] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest2()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[2] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest3()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[3] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest4()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[4] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest5()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[5] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest6()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[6] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest7()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[7] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest8()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[8] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }

    @Test
    public void iosSimTest9()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosSimTestResults[9] = calculateCarLoan("iOS", deviceName, platformVersion, true, testName);
    }
}