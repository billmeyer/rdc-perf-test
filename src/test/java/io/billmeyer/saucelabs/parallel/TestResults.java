package io.billmeyer.saucelabs.parallel;

import java.io.PrintStream;

public class TestResults
{
    public static TestResults[] iosLocalTestResults = new TestResults[10];
    public static TestResults[] iosSimTestResults = new TestResults[10];
    public static TestResults[] iosUPTestResults = new TestResults[10];
    public static TestResults[] iosTOTestResults = new TestResults[10];

    public static TestResults[] androidLocalTestResults = new TestResults[10];
    public static TestResults[] androidEmuTestResults = new TestResults[10];
    public static TestResults[] androidUPTestResults = new TestResults[10];
    public static TestResults[] androidTOTestResults = new TestResults[10];
    
    public float deviceAllocation;
    public float locatingElements;
    public float populatingElements;
    public float assertingElements;
    public float driverQuit;
    public float totalTime;
    public boolean testPassed;
    public String testResultsURL;

    @Override
    public String toString()
    {
        //@formatter:off
        return "TestResults{"
                + "deviceAllocation=" + deviceAllocation
                + ", locatingElements=" + locatingElements
                + ", populatingElements=" + populatingElements
                + ", assertingElements=" + assertingElements
                + ", driverQuit=" + driverQuit
                + ", totalTime=" + totalTime
                + ", testPassed=" + testPassed
                + ", testResultsURL=" + testResultsURL
                + '}';
        //@formatter:on
    }

    public TestResults()
    {

    }

    public TestResults(float deviceAllocation, float locatingElements, float populatingElements, float assertingElements, float driverQuit, float totalTime, boolean testPassed, String testResultsURL)
    {
        this.deviceAllocation = deviceAllocation;
        this.locatingElements = locatingElements;
        this.populatingElements = populatingElements;
        this.assertingElements = assertingElements;
        this.driverQuit = driverQuit;
        this.totalTime = totalTime;
        this.testPassed = testPassed;
        this.testResultsURL = testResultsURL;
    }

    public static void dumpResults()
    {
        System.out.println("Test Results:");

        TestResults.dump("Android Local Emulator Results", androidLocalTestResults, System.out);
        TestResults.dump("Android Emulator Results", androidEmuTestResults, System.out);
        TestResults.dump("Android TestObject Results", androidTOTestResults, System.out);
        TestResults.dump("Android Unified Platform Results", androidUPTestResults, System.out);
        TestResults.dump("iOS Local Simulator Results", iosLocalTestResults, System.out);
        TestResults.dump("iOS Simulator Results", iosSimTestResults, System.out);
        TestResults.dump("iOS TestObject Results", iosTOTestResults, System.out);
        TestResults.dump("iOS Unified Platform Results", iosUPTestResults, System.out);
    }

    public static void dump(String title, TestResults[] testResults, PrintStream out)
    {
        out.printf("%s\n", title);
        out.print("Run #|Device Allocation|Locating Elements|Populating Elements|Asserting Elements|Driver Quit|Total Time|Total Time + Device Allocation|Test Results\n");
        for (int run = 0; run < testResults.length; run++)
        {
            out.printf("Run %d|", run);

            if (testResults[run] == null)
            {
                out.printf("-|-|-|-|-|-|-|-\n");
            }
            else
            {
                dumpAsCSV(testResults[run], out);
            }
        }
        out.printf("Avg\n");
    }

    public static void dumpAsCSV(TestResults testResult, PrintStream out)
    {
        out.printf("%.2f|", testResult.deviceAllocation);
        out.printf("%.2f|", testResult.locatingElements);
        out.printf("%.2f|", testResult.populatingElements);
        out.printf("%.2f|", testResult.assertingElements);
        out.printf("%.2f|", testResult.driverQuit);
        out.printf("%.2f|", testResult.totalTime);
        out.printf("%.2f|", testResult.totalTime + testResult.deviceAllocation);
        out.printf("%s", testResult.testResultsURL);
        out.println();
    }
}
