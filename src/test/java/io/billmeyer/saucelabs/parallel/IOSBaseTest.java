package io.billmeyer.saucelabs.parallel;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class IOSBaseTest extends BaseTest
{
    protected TestResults calculateCarLoan(String platformName, String deviceName, String platformVersion, boolean useUnifiedPlatform, String testName)
    {
        return calculateCarLoan(platformName, deviceName, platformVersion, useUnifiedPlatform, false, testName);
    }

    protected TestResults calculateCarLoan(String platformName, String deviceName, String platformVersion, boolean useUnifiedPlatform, boolean runLocal, String testName)
    {
        System.out.printf(">>> Starting %s...\n", testName);

        long start = System.currentTimeMillis();
        Tuple<AppiumDriver, TestResults> data = createDriver(platformName, platformVersion, deviceName, useUnifiedPlatform, runLocal, testName);
        long stop = System.currentTimeMillis();

        AppiumDriver driver = data.getItem1();
        TestResults tr = data.getItem2();

        tr.deviceAllocation = (stop - start) / 1000f;

        long time1, time2, time3, time4, time5;

        time1 = System.currentTimeMillis();

        WebElement tfLoanAmount = driver.findElementByAccessibilityId("tfLoanAmount");
        WebElement tfInterest = driver.findElementByAccessibilityId("tfInterest");
        WebElement tfSalesTax = driver.findElementByAccessibilityId("tfSalesTax");
        WebElement tfTerm = driver.findElementByAccessibilityId("tfTerm");
        WebElement tfDownPayment = driver.findElementByAccessibilityId("tfDownPayment");
        WebElement tfTradeIn = driver.findElementByAccessibilityId("tfTradeIn");
        WebElement tfFees = driver.findElementByAccessibilityId("tfFees");
        WebElement lblMonthlyPayment = driver.findElementByAccessibilityId("lblMonthlyPayment");
        WebElement lblTotalPayments = driver.findElementByAccessibilityId("lblTotalPayments");
        WebElement lblTotalInterest = driver.findElementByAccessibilityId("lblTotalInterest");
        WebElement lblTotalCost = driver.findElementByAccessibilityId("lblTotalCost");

        time2 = System.currentTimeMillis();

        // Set the input values for our loan calculation...
        tfLoanAmount.sendKeys("25000");
        tfInterest.sendKeys("3.42");
        tfSalesTax.sendKeys("8");
        tfTerm.sendKeys("60");
        tfDownPayment.sendKeys("500");
        tfTradeIn.sendKeys("7500");
        tfFees.sendKeys("300");

        time3 = System.currentTimeMillis();

        // Check if within given time the correct result appears in the designated field.
        tr.testPassed = true;

        if (!lblTotalPayments.getText().contains("20,370.97"))
        {
            tr.testPassed = false;
        }
        if (!lblMonthlyPayment.getText().contains("339.52"))
        {
            tr.testPassed = false;
        }
        if (!lblTotalInterest.getText().contains("1,670.97"))
        {
            tr.testPassed = false;
        }
        if (!lblTotalCost.getText().contains("28,370.97"))
        {
            tr.testPassed = false;
        }

        time4 = System.currentTimeMillis();

        if (runLocal == false)
        {
            if (useUnifiedPlatform == true || deviceName.endsWith("Simulator"))
            {
                reportSauceLabsMobileResult(driver, tr.testPassed);
            }
            else
            {
                reportTestObjectResult(driver, tr.testPassed);
            }
        }

        driver.quit();

        time5 = System.currentTimeMillis();

        tr.locatingElements = (time2 - time1) / 1000f;
        tr.populatingElements = (time3 - time2) / 1000f;
        tr.assertingElements = (time4 - time3) / 1000f;
        tr.driverQuit = (time5 - time4) / 1000f;
        tr.totalTime = (time5 - time1) / 1000f;

        TestResults.dumpAsCSV(tr, System.out);

        return tr;
    }
}