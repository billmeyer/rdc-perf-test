package io.billmeyer.saucelabs.parallel;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;

/**
 * Simple TestNG test which demonstrates being instantiated via a DataProvider in order to supply multiple browser combinations.
 *
 * @author Bill Meyer
 */
public class BaseTest
{
    protected static final String toLoanCalcAndroid = System.getenv("LOANCALC_ANDROID_APIKEY");
    protected static final String toLoanCalcIOS = System.getenv("LOANCALC_IOS_APIKEY");
    protected static final String userName = System.getenv("SAUCE_USERNAME");
    protected static final String accessKey = System.getenv("SAUCE_ACCESS_KEY");

    protected long suiteStartTime, suiteEndTime;

    /**
     * ThreadLocal variable which contains the  {@link WebDriver} instance which is used to perform browser interactions with.
     */
    private ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();

    protected AppiumDriver createDriver(String platformName, String platformVersion, String deviceName, boolean unifiedPlatformTesting, String methodName)
    throws MalformedURLException
    {
        return createDriver(platformName, platformVersion, deviceName, unifiedPlatformTesting, false, methodName);
    }

    /**
     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the platformName,
     * platformVersion and deviceName parameters, and which is configured to run against ondemand.saucelabs.com, using
     * the userName and access key populated by the authentication instance.
     *
     * @param platformName    Represents the platformName to be used as part of the test run.
     * @param platformVersion Represents the platformVersion of the platformName to be used as part of the test run.
     * @param deviceName      Represents the operating system to be used as part of the test run.
     * @param methodName      Represents the name of the test case that will be used to identify the test on Sauce.
     * @return
     * @throws MalformedURLException if an error occurs parsing the url
     */
    protected AppiumDriver createDriver(String platformName, String platformVersion, String deviceName, boolean unifiedPlatformTesting, boolean runLocal, String methodName)
    {
        URL url = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        boolean realDeviceTesting = true;
        if (platformName.equalsIgnoreCase("android"))
        {
            if (deviceName.endsWith("Emulator"))
            {
                realDeviceTesting = false;
            }
        }
        else if (platformName.equalsIgnoreCase("ios"))
        {
            if (deviceName.endsWith("Simulator"))
            {
                realDeviceTesting = false;
            }
        }
        else
        {
            throw new IllegalArgumentException("Unknown platformName: " + platformName);
        }

        if (runLocal == true)
        {
            try
            {
                url = new URL("http://localhost:4723/wd/hub");
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            if (platformName.equalsIgnoreCase("android"))
            {
                caps.setCapability("app", "http://octocore1/app-release.apk");
            }
            else
            {
                caps.setCapability("app", "http://octocore1/LoanCalc.sim.app.zip");
            }
        }
        // set desired capabilities to launch appropriate platformName on Sauce
        // For real device testing, connect to one URL using a certain set of credentials...
        else if (realDeviceTesting == true && unifiedPlatformTesting == false)
        {
            try
            {
                url = new URL("http://us1.appium.testobject.com/wd/hub");
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            if (platformName.equalsIgnoreCase("ios"))
            {
                caps.setCapability("testobject_api_key", toLoanCalcIOS);
            }
            else
            {
                caps.setCapability("testobject_api_key", toLoanCalcAndroid);
            }
            caps.setCapability("recordDeviceVitals", false);
        }
        // For emulator/simulator testing, connect to a different URL using a different certain set of credentials...
        else
        {
            try
            {
                url = new URL("https://" + userName + ":" + accessKey + "@ondemand.us-west-1.saucelabs.com/wd/hub");
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

            final String githubUrl = "https://github.com/billmeyer/rdc-perf-test/raw/master/";
            final boolean useSauceStorage = true;
            String baseUrl = "sauce-storage:";
            if (useSauceStorage == false)
            {
                baseUrl = githubUrl;
            }

            if (realDeviceTesting == true)
            {
                if (platformName.equalsIgnoreCase("android"))
                {
                    caps.setCapability("app", baseUrl + "app-release.apk");
                }
                else
                {
                    caps.setCapability("app", baseUrl + "LoanCalc.ipa");
                }
            }
            else
            {
                if (platformName.equalsIgnoreCase("android"))
                {
                    caps.setCapability("app", baseUrl + "app-release.apk");
                }
                else
                {
                    caps.setCapability("app", baseUrl + "LoanCalc.sim.app.zip");
                }
            }
        }

//        caps.setCapability("appiumVersion", "1.16.0");
//        caps.setCapability("appiumVersion", "1.15.1");
        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("name", methodName);

        // Use the suite start time as a unique cacheId for this series of tests
//        if (useCacheId)
//        {
//            caps.setCapability("cacheId", suiteStartTime);
////            caps.setCapability("noReset", "true");
//        }

//        if (unifiedPlatformTesting == true)
//        {
//            addBuildInfo(caps);
//        }

        // Launch the remote platformName and set it as the current thread
        AppiumDriver driver = null;

        while (driver == null)
        {
            try
            {
                if (platformName.equalsIgnoreCase("ios"))
                {
                    driver = new IOSDriver(url, caps);
                }
                else
                {
                    driver = new AndroidDriver(url, caps);
                }
            }
            catch (org.openqa.selenium.SessionNotCreatedException e)
            {
                System.err.printf("Timed out waiting for driver session, retrying. (%s)\n", e.getMessage());
            }
        }

        appiumDriverThreadLocal.set(driver);

        if (realDeviceTesting == true)
        {
            if (unifiedPlatformTesting == false)
            {
                String reportUrl = (String) driver.getCapabilities().getCapability("testobject_test_report_url");
                System.out.printf("Test Results: %s\n", reportUrl);
            }
            else
            {
                String sessionId = (String) driver.getSessionId().toString();
                System.out.printf("Test Results: https://app.saucelabs.com/tests/%s\n", sessionId);
            }
        }

        return appiumDriverThreadLocal.get();
    }

    @BeforeSuite
    public void startUpSuite()
    {
        suiteStartTime = System.currentTimeMillis();
    }

    @AfterSuite
    public void tearDownSuite()
    {
        suiteEndTime = System.currentTimeMillis();

        TestResults.dumpResults();

        System.out.println();
        System.out.printf("Total Suite Execution Time: %.2f secs\n", (suiteEndTime - suiteStartTime) / 1000f);
    }

    private MutableCapabilities addBuildInfo(MutableCapabilities sauceOpts)
    {
        // Pull the Job Name and Build Number from Jenkins if available...
        String jenkinsBuildNumber = System.getenv("JENKINS_BUILD_NUMBER");
        if (jenkinsBuildNumber != null)
        {
            sauceOpts.setCapability("build", jenkinsBuildNumber);
        }
        else
        {
            String jobName = System.getenv("JOB_NAME");
            String buildNumber = System.getenv("BUILD_NUMBER");

            if (jobName != null && buildNumber != null)
            {
                sauceOpts.setCapability("build", String.format("%s__%s", jobName, buildNumber));
            }
            else
            {
                sauceOpts.setCapability("build", "Build " + new Date());
            }
        }

        return sauceOpts;
    }


    public static void pushToSauceStorage(String localFileName, String remoteFileName)
    {
        File file = new File("/Users/bmeyer/github/billmeyer/LoanCalcAppiumTest/app-release.apk");

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(userName, accessKey);
        credsProvider.setCredentials(AuthScope.ANY, credentials);

        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credsProvider).build();

        HttpPost postRequest = new HttpPost("https://api.us-west-1.saucelabs.com/v1/rdc/apps/upload");
        String fileName = file.getName();
        FileBody fileBody = new FileBody(file);

        HttpEntity httpEntity = MultipartEntityBuilder.create().addPart("fileName", new StringBody(fileName, ContentType.APPLICATION_OCTET_STREAM)).addPart("attachment", fileBody).build();

        postRequest.setEntity(httpEntity);
        try
        {
            HttpResponse response = client.execute(postRequest);
            StatusLine sl = response.getStatusLine();
            System.out.printf("HTTP Response: %d, %s\n", sl.getStatusCode(), sl.getReasonPhrase());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Logs the given line in the job’s commands list. No spaces can be between sauce: and context.
     */
    public static void info(RemoteWebDriver driver, String format, Object... args)
    {
        System.out.printf(format, args);
        return; // Not currently implemented
//        String msg = String.format(format, args);
//        ((JavascriptExecutor) driver).executeScript("sauce:context=" + msg);
    }

    public static void reportSauceLabsMobileResult(RemoteWebDriver driver, boolean status)
    {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (status ? "passed" : "false"));
    }

    /**
     * Uses the Appium V2 RESTful API to report test result status to the Sauce Labs dashboard.
     *
     * @param driver The WebDriver instance we'll use to get the session ID we want to set the status for
     * @param status TRUE if the test was successful, FALSE otherwise
     * @see https://api.testobject.com/#!/Appium_Watcher_API/updateTest
     */
    public void reportTestObjectResult(RemoteWebDriver driver, boolean status)
    {
        String sessionId = driver.getSessionId().toString();

        // The Appium REST Api expects JSON payloads...
        MediaType[] mediaType = new MediaType[]{MediaType.APPLICATION_JSON_TYPE};

        // Construct the new REST client...
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target("https://app.testobject.com/api/rest/v2/appium");

        // Construct the REST body payload...
        Entity entity = Entity.json(Collections.singletonMap("passed", status));

        // Build a PUT request to /v2/appium/session/{:sessionId}/test
        Invocation.Builder request = resource.path("session").path(sessionId).path("test").request(mediaType);

        // Execute the PUT request...
        request.put(entity);
    }
}
