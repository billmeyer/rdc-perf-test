package io.billmeyer.saucelabs.parallel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class IOSTOTest extends IOSBaseTest
{
    private final static String deviceName = "iPhone_XS_POC166";
    private static final String platformVersion = "12.1.4";

    @Test(groups = {"sequential-test"})
    public void iosTOTest0()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[0] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest1()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[1] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest2()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[2] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest3()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[3] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest4()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[4] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest5()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[5] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest6()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[6] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest7()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[7] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest8()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[8] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }

    @Test(groups = {"sequential-test"})
    public void iosTOTest9()
    {
        String testName = new Object() {}.getClass().getEnclosingMethod().getName();
        TestResults.iosTOTestResults[9] = calculateCarLoan("ios", deviceName, platformVersion, false, testName);
    }
}