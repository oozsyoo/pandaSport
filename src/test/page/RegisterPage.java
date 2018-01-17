package test.page;

import com.qa.framework.ioc.annotation.Page;
import com.qa.framework.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.Untils.StringUtils;
import test.datamodel.TestModel;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@Page
public class RegisterPage extends  AbstractPage{

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/phoneNumEt")
    WebElement phoneNumEt;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/verifyNumEt")
    WebElement verifyNumEt;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/getVerifyNumTv")
    WebElement getVerifyNumTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/nextBtn")
    WebElement nextBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/registerBtn")
    WebElement registerBtn;


    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/userNameEt")
    private WebElement userNameEt;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/passwordEt")
    private WebElement newPasswordEt;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/confirmPasswordEt")
    private  WebElement confirmPasswordEt;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/selectBtn")
    List<WebElement> selectBtn;


    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/okBtn")
    private WebElement okBtn;

    public void register(String cell, String password) {
//      点击注册按钮
        registerBtn.click();
        getSleeper().sleep(1000);

        phoneNumEt.sendKeys(cell);
        getVerifyNumTv.click();
        getSleeper().sleep(1000);
//      获取验证码
        String Yzm = TestModel.getChangeYzm(cell);

        verifyNumEt.sendKeys(Yzm);
        nextBtn.click();
//      设置密码
        setPassword(password);

        nextBtn.click();
//      创建角色
        userNameEt.sendKeys(StringUtils.createNewUser());
        okBtn.click();
    }




    public void setPassword(String password) {
        newPasswordEt.sendKeys(password);
        getSleeper().sleep(1000);
        confirmPasswordEt.sendKeys(password);

    }
}
