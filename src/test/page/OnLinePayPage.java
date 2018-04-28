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
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'totalPayMoneyTv')]")
    WebElement totalPayMoneyTv;

    @AndroidFindBy(xpath= "//*[contains(@resource-id,'purchaseNoTv')]")
    WebElement purchaseNoTv;

    @AndroidFindBy(xpath= "//*[contains(@resource-id,'restTimeTv')]")
    WebElement restTimeTv;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'toPayBtn')]")
    WebElement toPayBtn;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'payLayout')]")
    private List<WebElement> payLayouts;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'selectIv')]")
    private List<WebElement> selectIv;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'passwordInputView')]")
    private WebElement passwordInputView;

    public void choseBalancePay(String payWay) {
        WebElement select = null;
        WebElement payLayout = null;
        switch (payWay) {
            case "余额支付":
                try {
                    payLayout = payLayouts.get(0);
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }

                break;
            case "银行卡支付":
                payLayout = payLayouts.get(1);
                break;
            case "大额支付":
                payLayout = payLayouts.get(2);
                break;

        }

        if (payLayout != null) {
            select=payLayout.findElement(By.xpath("//*[contains(@resource-id,'selectIv')]"));
        }else{
            logger.info("无可用支付方式");
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