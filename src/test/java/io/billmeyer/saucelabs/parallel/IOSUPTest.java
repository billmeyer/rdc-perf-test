package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class IOSUPTest extends IOSBaseTest
{
    private final static String deviceName = "iPhone_XS_POC166";
    private static final String platformVersion = "12.1.4";
//    private final static String deviceName = "iPhone_XR_POC178";
//    private static final String platformVersion = "12.3.1";

    @Test(groups = {"sequential-test"})
    public void iosUPTest0()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[0] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest1()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[1] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest2()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[2] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest3()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[3] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest4()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[4] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest5()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[5] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest6()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[6] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest7()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[7] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest8()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[8] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosUPTest9()
    throws MalformedURLException
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosUPTestResults[9] = calculateCarLoan("ios", deviceName, platformVersion, true, testName);
    }
}