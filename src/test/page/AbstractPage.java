package test.page;

import com.qa.framework.common.Sleeper;
import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import test.Untils.Test1;

/**
 * Created by zsy on 2017/9/22.
 */
@Page
public  class AbstractPage {
    public Logger logger = Logger.getLogger(this.getClass());
    private Sleeper sleeper = new Sleeper();


    protected Sleeper getSleeper() {
        return sleeper;
    }

    @Autowired
    private WebDriver driver;

    WebDriver getDriver() {
        return driver;
    }

    AndroidDriver getAndroidDriver(){
        return (AndroidDriver) driver;
    }




}