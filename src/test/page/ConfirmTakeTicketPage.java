package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import test.Untils.ConstantEnum;
import test.Untils.DataUtils;
import test.testcase.purchase;

import java.util.List;
import java.util.Map;


/**
 * Created by HASEE on 2017/4/9.
 */

@Page
public class ConfirmTakeTicketPage extends AbstractPage {

    //保密设置
    @AndroidFindBy(xpath = "//android.widget.RadioButton")
    private List<WebElement> privacySetting;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/payMoneyTv")
    private WebElement payMoneyTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/totalMoneyTv")
    private WebElement totalMoneyTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/fanganDescEt")
    private WebElement titleEt;

    public WebElement getOkBtn() {
        return okBtn;
    }

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/okBtn")
    private WebElement okBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/ltTypeTv")
    private WebElement ltTypeTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/messageTv")
    private WebElement balanceTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/leftBtn")
    private WebElement continueToBuyBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/rightBtn")
    private WebElement checkDetailBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/xieyiTv")
    WebElement xieyiTv;


    public void setPrivacy(ConstantEnum privacySettings) {


//        untils.clickTest();
        switch (privacySettings) {
            case PUBLIC:
                privacySetting.get(0).click();
                break;
            case AFTERGAME:
                privacySetting.get(1).click();
                break;
            case SECRET:
                privacySetting.get(2).click();
                break;
                default:
        }
    }

    public void getPageData(Map<String, String> dataMap) {
        //获取支付金额
        String payMoneys = payMoneyTv.getText();
        String payMoney = payMoneys.substring(3, payMoneys.length() - 1);
        //获取方案金额
        String totalMoneys = totalMoneyTv.getText();
        String totalMoney = totalMoneys.substring(5, totalMoneys.length() - 1);
        int fee = Integer.parseInt(payMoney);
        //获取页面上显示的投注彩种
        String ltTypes = ltTypeTv.getText();
        String ltType = ltTypes.substring(5, ltTypes.length());
        //打印相应参数
        logger.info(payMoney + "      " + totalMoney + "    " + ltType);

        dataMap.put("confirmTakeTicket_totalfee", totalMoney);
        dataMap.put("confirmTakeTicket_payfee", payMoney);
        new DataUtils().checkData(dataMap.get("totalfee"), totalMoney, "方案金额");
        new DataUtils().checkData(dataMap.get("totalfee"), payMoney, "支付金额");
        //输入方案宣言
        titleEt.sendKeys("11223344");

    }


//    public void buySucceedChose(Boolean chose) {
//        if (chose) {
//            continueToBuyBtn.click();
//            purchase p = new purchase();
//            p.count();
//        } else {
//            checkDetailBtn.click();
//        }
//    }

}
