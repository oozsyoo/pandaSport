package test.page;

import com.qa.framework.common.ScreenShot;
import com.qa.framework.ioc.annotation.Page;
import com.qa.framework.pagefactory.WithTimeout;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.Untils.CheckImage;
import test.Untils.ImageUtils;
import test.Untils.ScreenShoot;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/10.
 */
@Page
public class LoginPage extends AbstractPage {
    @WithTimeout(2000)
    @AndroidFindBy(xpath = "//*[contains(@id,'start')]")
    private WebElement startUpLoad;
    @WithTimeout(2000)
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'cancel')]")
    private WebElement notUpLoad;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'countDownTv')]")
    WebElement countDownTv;

    @WithTimeout(2000)
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'button')]")
    private WebElement clickToLogin;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'versionTv')]")
    private WebElement version;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'checkUpdateTv')]")
    private WebElement checkUpdateTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'testInterfaceTv')]")
    private WebElement testInterfaceTv;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'backIv')]")
    private WebElement backIv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'titleTv')]")
    private WebElement titleTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/logoIv')]")
    private WebElement logoIv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'authorizedTitle')]")
    private WebElement authorizedTitle;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'userNameEt')]")
    private WebElement userNameEt;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'passwordEt')]")
    private WebElement passwordEt;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'forgetPwdTv')]")
    private WebElement forgetPwdTv;
    @WithTimeout(2000)
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'loginBtn')]")
    private WebElement loginBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'registerBtn')]")
    private WebElement RegisterBtn;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'gestureView')]")
    @WithTimeout(2000)
    WebElement gestureView;
    @WithTimeout(2000)
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'skipTv')]")
    private WebElement skipTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'cancelBtn')]")
    private WebElement cancelBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'okBtn')]")
    private WebElement okBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'jjxIconIv')]")
    private WebElement iconIv;
    @AndroidFindBy(className = "android.widget.ImageView")
    private WebElement guestIcon;


    public WebElement getClickToLogin() {
        getSleeper().sleep(2000);

        return clickToLogin;
    }

    public WebElement getCountDownTv() {
        return countDownTv;
    }


    public void login(String cell, String password) {

        ScreenShoot.contrastImage("logo", getDriver(), logoIv);
        clickToLogin.click();
        getSleeper().sleep(5000);
        ScreenShoot.contrastImage("login", getDriver(), iconIv);
//          untils.clickTest();

        getSleeper().sleep(1000);
//          输入用户名密码
        userNameEt.sendKeys(cell);

        passwordEt.sendKeys(password);

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
//        ScreenShoot.contrastImage("test", getDriver());
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
//            ScreenShoot.contrastImage("guest", getDriver(), guestIcon);
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
