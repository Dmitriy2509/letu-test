package cloud.autotests.helpers;

import cloud.autotests.config.App;
import cloud.autotests.config.Project;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = App.config.webUrl();
        Configuration.timeout = 80000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (Project.isWebMobile()) { // for chrome only
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", Project.config.browserMobileView());
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
        }

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.remote = Project.config.remoteDriverUrl();

//            String url = System.getProperty("remoteDriverUrl", "selenoid.autotests.cloud/wd/hub/");
//            Configuration.remote = format("https://%s:%s@%s", Project.config.login(), Project.config.password(), url);

//            String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
//            Configuration.remote = format("https://%s:%s@%s", credentialConfig.login(), credentialConfig.password(), url);

//            String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
//            Configuration.remote = format("https://%s:%s@%s", credentialConfig.login(), credentialConfig.password(), url);
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
