package test.page;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import com.qa.framework.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.Untils.ConstantEnum;
import test.Untils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * @date 2017/3/23
 */
@Page
public class HomePage extends AbstractPage {


    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/ltLogoIv")
    private List<WebElement> imgView;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/chongzhiBtn")
    private WebElement chongzhiBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/backBtn")
    private WebElement backBtn;
    @WithTimeout(3000)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"首页\"]")
    WebElement home;
    @WithTimeout(3000)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"我要跟单\"]")
    WebElement fllow;
    @WithTimeout(3000)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"会员中心\"]")
    WebElement userCenter;
    @WithTimeout(3000)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"购彩记录\"]")
    WebElement buyData;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/copyBtn")
    List<WebElement> copyBtns;
    @AndroidFindBy(id = "android:id/tabs")
    WebElement tabs;
    @Autowired
    Utils untils;


    Random random = new Random();


    public void chosePlayWay(ConstantEnum way) {
//        HttpMethod.useGetMethod(urlStr, null, false, true, 3)
        getSleeper().sleep(1000);


        switch (way) {
            case JCZQ:
                imgView.get(0).click();
//                switch (way) {
//                    case "混合投注":
//
//                    case "单关配":
//
//                    case "2选1":
//
//                }

                break;
            case JCLQ:
                imgView.get(1).click();
                break;
            case ZC:
                imgView.get(2).click();

                break;
            case DLT:
                imgView.get(3).click();
                break;
            case YYFD:
                imgView.get(4).click();
                break;
            case BFZB:
                imgView.get(5).click();
                break;

            default:
        }
    }

    public void choseFragment(ConstantEnum key) {

        switch (key) {
            case HOME:
                home.click();

                break;
            case FLLOW:
                fllow.click();

                break;
            case BUYDATA:
                buyData.click();

                break;
            case USERCENTER:
                userCenter.click();

                break;
            default:
        }

    }


}
