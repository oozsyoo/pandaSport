package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.Untils.ImageUtils;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2018/1/9.
 */
@Page
public class OnLinePayPage extends AbstractPage {
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/totalPayMoneyTv")
    WebElement totalPayMoneyTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/purchaseNoTv")
    WebElement purchaseNoTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/restTimeTv")
    WebElement restTimeTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/toPayBtn")
    WebElement toPayBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/payLayout")
    private List<WebElement> payLayouts;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/selectIv")
    private List<WebElement> selectIv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/passwordInputView")
    private WebElement passwordInputView;

    public void choseBalancePay(String payWay) {
        WebElement select = null;
        switch (payWay) {
            case "余额支付":
                try {
                    select = payLayouts.get(0).findElement(By.id("com.huored.android.DongFangHong:id/selectIv"));
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }

                break;
            case "银行卡支付":
                select = payLayouts.get(1).findElement(By.id("com.huored.android.DongFangHong:id/selectIv"));
                break;
            case "大额支付":
                select = payLayouts.get(1).findElement(By.id("com.huored.android.DongFangHong:id/selectIv"));
                break;

        }
        if (select != null) {
            select.click();
        } else {
            logger.info("余额不足！");
        }


    }

    public void inputPassWord(String passWord) {
        passwordInputView.sendKeys(passWord);
    }

    public WebElement getToPayBtn() {
        return toPayBtn;
    }
}