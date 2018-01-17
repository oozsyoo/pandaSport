package test.Untils;

import com.qa.framework.common.Sleeper;
import com.qa.framework.ioc.annotation.Autowired;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2017/12/8.
 */
public class WaitUtils {
    public  Logger logger = Logger.getLogger(this.getClass());
    private Sleeper sleeper = new Sleeper();
    private static WebDriver driver;

    public void waitForLoadingElementbyId(WebElement element) {
        int i = 0;
        while (i < 5) {
            try {
                if (element.isDisplayed()) {
                    logger.info( "控件已出现！");
                    break;
                }
            } catch (Exception e) {
                logger.info("控件未出现！Waitting.........");
                i++;
            }
        }
        if (i == 4)
            logger.info("控件尝试五次都没出现");
    }

    public void waitForLoadingActivity(String ActivityName) {
        int i = 0;
        sleeper.sleep(3000);
        while (i < 5) {
            try {
                if (ActivityName.contains(((AndroidDriver) driver).currentActivity())) {
                    logger.info(ActivityName + "出现！");
                    break;
                } else {
                    logger.info(ActivityName + "未出现！Waitting.........1s");
                    sleeper.sleep(1000);
                    i++;
                }
            } catch (Exception e) {
                i++;
                logger.info(ActivityName + ",未出现！Waitting......... 随机时间");
            }
        }
    }

}