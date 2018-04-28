package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 */
@Page
public class CashierDeskPage extends AbstractPage {

    @AndroidFindBy(xpath = "//*[@resource-id,'id/backBtn']")
    private WebElement backBtn;
    @AndroidFindBy(xpath = "//*[@resource-id,'id/chargeInfoIv']")
    private WebElement chargeInfoIv;
    //充值通道列表
    @AndroidFindBy(xpath = "//*[@resource-id,'id/allChannelListView']//android.widget.RelativeLayout")
    private List<WebElement> ChannelList;
    //用户名
    @AndroidFindBy(xpath = "//*[@resource-id,'id/userAccountTv']")
    private WebElement userAccountTv;
    //充值金额
    @AndroidFindBy(xpath = "//*[@resource-id,'id/realMoneyTv']")
    private WebElement realMoneyTv;
    @AndroidFindBy(xpath = "//*[@resource-id,'id/submitBtn']")
    private WebElement submitBtn;







}
