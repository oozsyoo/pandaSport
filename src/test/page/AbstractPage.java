package test.page;

import com.qa.framework.common.Sleeper;
import com.qa.framework.ioc.annotation.Autowired;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import test.Untils.Test1;

/**
 * Created by zsy on 2017/9/22.
 */
public abstract class AbstractPage {
    public Logger logger = Logger.getLogger(this.getClass());
    private Sleeper sleeper = new Sleeper();
    private Test1 test1 = new Test1();

    protected Sleeper getSleeper() {
        return sleeper;
    }


    private WebDriver driver;

    WebDriver getDriver() {
        return driver;
    }


    AndroidDriver getAndroidDriver(){
        return (AndroidDriver) driver;
    }

    private String packagePath = test1.getPath();

    String getPackagePath() {
        return packagePath;
    }


}