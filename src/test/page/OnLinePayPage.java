package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 */
@Page
public class OnLinePayPage extends AbstractPage {
@AndroidFindBy(id = "com.huored.android.DongFangHong:id/totalPayMoneyTv")
    WebElement totalPayMoneyTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/purchaseNoTv")
    WebElement purchaseNoTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/payLayout")
    List<WebElement> payLayouts;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/restTimeTv")
    WebElement restTimeTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/toPayBtn")
    WebElement toPayBtn;










}
