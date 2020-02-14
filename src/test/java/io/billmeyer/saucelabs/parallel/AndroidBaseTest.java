package io.billmeyer.saucelabs.parallel;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class AndroidBaseTest extends BaseTest
{
    protected TestResults calculateCarLoan(String platformName, String deviceName, String platformVersion, boolean useUnifiedPlatform, String testName)
    {
        return calculateCarLoan(platformName, deviceName, platformVersion, useUnifiedPlatform, false, testName);
    }

    /**
     * Runs a simple test verifying if the comment input is functional.
     *
     * @throws InvalidElementStateException
     */
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

        WebElement etLoanAmount = driver.findElement(By.id("io.billmeyer.loancalc:id/etLoanAmount"));
        WebElement etEditInterest = driver.findElement(By.id("io.billmeyer.loancalc:id/etEditInterest"));
        WebElement etSalesTax = driver.findElement(By.id("io.billmeyer.loancalc:id/etSalesTax"));
        WebElement etTerm = driver.findElement(By.id("io.billmeyer.loancalc:id/etTerm"));
        WebElement etDownPayment = driver.findElement(By.id("io.billmeyer.loancalc:id/etDownPayment"));
        WebElement etTradeIn = driver.findElement(By.id("io.billmeyer.loancalc:id/etTradeIn"));
        WebElement etFees = driver.findElement(By.id("io.billmeyer.loancalc:id/etFees"));
        WebElement btnCalculate = driver.findElement(By.id("io.billmeyer.loancalc:id/btnCalculate"));
        WebElement tvLoanTotal = driver.findElement(By.id("io.billmeyer.loancalc:id/tvLoanTotal"));
        WebElement tvMonthlyPaymentVal = driver.findElement(By.id("io.billmeyer.loancalc:id/tvMonthlyPaymentVal"));
        WebElement tvLoanInterestVal = driver.findElement(By.id("io.billmeyer.loancalc:id/tvLoanInterestVal"));
        WebElement tvLoanTotalCostVal = driver.findElement(By.id("io.billmeyer.loancalc:id/tvLoanTotalCostVal"));

        time2 = System.currentTimeMillis();

        // Set the input values for our loan calculation...
        etLoanAmount.sendKeys("25000");
        etEditInterest.sendKeys("3.42");
        etSalesTax.sendKeys("8");
        etTerm.sendKeys("60");
        etDownPayment.sendKeys("500");
        etTradeIn.sendKeys("7500");
        etFees.sendKeys("300");
        driver.getScreenshotAs(OutputType.FILE);

        btnCalculate.click();

        time3 = System.currentTimeMillis();

        // Check if within given time the correct result appears in the designated field.
        tr.testPassed = true;

        if (!tvLoanTotal.getText().contains("20,370.97"))
        {
            tr.testPassed = false;
        }
        if (!tvMonthlyPaymentVal.getText().contains("339.52"))
        {
            tr.testPassed = false;
        }
        if (!tvLoanInterestVal.getText().contains("1,670.97"))
        {
            tr.testPassed = false;
        }
        if (!tvLoanTotalCostVal.getText().contains("28,370.97"))
        {
            tr.testPassed = false;
        }

        time4 = System.currentTimeMillis();

        if (runLocal == false)
        {
            if (useUnifiedPlatform == true || deviceName.endsWith("Emulator"))
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