package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Test;

public class IOSLocalTest extends IOSBaseTest
{
    private final static String deviceName = "iPhone 11 Pro Max";
    private static final String platformVersion = "13.3";

    @Test
    public void iosLocalTest0()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[0] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest1()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[1] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest2()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[2] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest3()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[3] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest4()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[4] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest5()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[5] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest6()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[6] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest7()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[7] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest8()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[8] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }

    @Test
    public void iosLocalTest9()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosLocalTestResults[9] = calculateCarLoan("iOS", deviceName, platformVersion, false, true, testName);
    }
}