package test.page;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import com.qa.framework.pagefactory.WithTimeout;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.Untils.ImageUtils;
import test.Untils.StringUtils;
import test.Untils.Utils;
import test.datamodel.TestModel;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/10.
 */
@Page
public class LoginPage extends AbstractPage {
    @WithTimeout(2000)
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/start")
    private WebElement startUpLoad;
    @WithTimeout(2000)
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/cancel")
    private WebElement notUpLoad;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/countDownTv")
    WebElement countDownTv;

    @WithTimeout(2000)
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/button")
    private WebElement clickToLogin;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/versionTv")
    private WebElement version;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/checkUpdateTv")
    private WebElement checkUpdateTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/testInterfaceTv")
    private WebElement testInterfaceTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/backIv")
    private WebElement backIv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/titleTv")
    private WebElement titleTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/jjxIconIv")
    private WebElement logoIv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/authorizedTitle")
    private WebElement authorizedTitle;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/userNameEt")
    private WebElement userNameEt;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/passwordEt")
    private WebElement passwordEt;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/forgetPwdTv")
    private WebElement forgetPwdTv;
    @WithTimeout(2000)
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/loginBtn")
    private WebElement loginBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/registerBtn")
    private WebElement RegisterBtn;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/gestureView")
    @WithTimeout(2000)
    WebElement gestureView;
    @WithTimeout(2000)
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/skipTv")
    private WebElement skipTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/cancelBtn")
    private WebElement cancelBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/okBtn")
    private WebElement okBtn;

    public WebElement getClickToLogin() {
        return clickToLogin;
    }

    @Autowired
    Utils utils;

    public void login(String cell, String password) {
//          untils.clickTest();
        getSleeper().sleep(3000);
//          输入用户名密码
        userNameEt.sendKeys(cell);

        passwordEt.sendKeys(password);
        try {
          int i=  ImageUtils.getElementPixel(loginBtn);
            logger.info(i);
        } catch (AWTException e) {
            e.printStackTrace();
        }
//          点击登录
        loginBtn.click();

        getSleeper().sleep(2000);


    }

    /**
     * 进入手势页面
     * exist:true 设置手势密码
     * false 输入手势密码
     */
    public void gesture(boolean exist) {

        getSleeper().sleep(2000);
        int height = gestureView.getSize().getHeight();
        int width = gestureView.getSize().getWidth();
        int yStep = height / 4;
        int yStep2 = height / 6;
        int xStep = width / 4;
        int startX = gestureView.getLocation().getX();
        int startY = gestureView.getLocation().getY();
        if (exist) {
            getSleeper().sleep(500);
            gestureMove(startX + xStep, startY + yStep + yStep2, xStep, yStep2);
            getSleeper().sleep(1000);
            gestureMove(startX + xStep, startY + yStep + yStep2, xStep, yStep2);

        } else {
            gestureMove(startX + xStep, startY + yStep, xStep, yStep);
        }
    }

    private void gestureMove(int startX, int startY, int xStep, int yStep) {

        TouchAction TA = new TouchAction((AndroidDriver) getDriver())
                .press(startX, startY).waitAction(500)
                .moveTo(xStep, 0).waitAction(500)
                .moveTo(xStep, 0).waitAction(500)
                .moveTo(0, yStep).waitAction(500)
                .release();
        TA.perform();


    }

    public void checkUpdate(boolean update) {
        //      出现更新弹窗
        try {
            getSleeper().sleep(2000);

            if (update) {
                // 点击更新
                startUpLoad.click();
            } else {
                //跳过更新
                notUpLoad.click();
            }


        } catch (Exception e) {

        }

    }

    //点击跳过，跳过手势密码
    public void skipGesture() {
        skipTv.click();

        try {
            if (okBtn.isDisplayed()) {
                okBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
