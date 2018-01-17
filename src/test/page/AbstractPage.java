package test.page;

import com.qa.framework.common.Sleeper;
import com.qa.framework.ioc.annotation.Autowired;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by zsy on 2017/9/22.
 */
public abstract class AbstractPage {
    public  Logger logger = Logger.getLogger(this.getClass());
    private Sleeper sleeper = new Sleeper();
    public Sleeper getSleeper(){return  sleeper;}
    @Autowired
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
}