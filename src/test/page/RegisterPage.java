package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import test.Untils.MyStringUtils;
import test.datamodel.TestModel;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@Page
public class RegisterPage extends  AbstractPage{

    @AndroidFindBy(xpath= "//*[contains(@resource-id,'phoneNumEt')]")
    WebElement phoneNumEt;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'verifyNumEt')]")
    WebElement verifyNumEt;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'getVerifyNumTv')]")
    WebElement getVerifyNumTv;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'nextBtn')]")
    WebElement nextBtn;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'registerBtn')]")
    WebElement registerBtn;


    @AndroidFindBy(xpath= "//*[contains(@resource-id,'userNameEt')]")
    private WebElement userNameEt;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'passwordEt')]")
    private WebElement newPasswordEt;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'confirmPasswordEt')]")
    private  WebElement confirmPasswordEt;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'selectBtn')]")
    List<WebElement> selectBtn;


    @AndroidFindBy(xpath= "//*[contains(@resource-id,'okBtn')]")
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
        userNameEt.sendKeys(MyStringUtils.createNewUser());
        okBtn.click();
    }




    public void setPassword(String password) {
        newPasswordEt.sendKeys(password);
        getSleeper().sleep(1000);
        confirmPasswordEt.sendKeys(password);

    }
}
