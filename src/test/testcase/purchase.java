package test.testcase;

import com.qa.framework.TestCaseBase;
import com.qa.framework.config.PropConfig;
import com.qa.framework.ioc.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.Untils.ConstantEnum;
import test.datamodel.TestCaseData;
import test.page.HomePage;
import test.service.LoginService;
import test.service.PurchaseService;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public class purchase extends TestCaseBase  {


    @Autowired
    private LoginService loginService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private HomePage homePage;

    @BeforeMethod
    public void loginJjx() {
//        Test1 test1=new Test1();
//       test1.readAPK("res\\" + PropConfig.getAppBin()).get("packageName").toString();

        if (PropConfig.getAppBin().contains("com")) {
            loginService.login("15355090684", "123456");
        } else {
            loginService.login("18368090404", "123456");
        }

    }


    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays", description = "玩法")
    public void playWays(int field, String playWay, ConstantEnum privacySettings, int multiples) {

        purchaseService.purchase(field, playWay, privacySettings, multiples);


    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays", description = "玩法", invocationCount = 2)
    public void BuyInBulk(int field, String playWay, String privacySettings, int multiples) {

        purchaseService.BuyInBulk(field, playWay, privacySettings, multiples, 100);


    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "superLotto", description = "选法")
    public void purchaseSuperLotto(int redBall, int buleBall, ConstantEnum playWay, int multiples, ConstantEnum privacySettings) {

        purchaseService.purchaseSuperLotto(redBall, buleBall, privacySettings, playWay, multiples);


    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays1", description = "玩法")
    public void test(int field, String playWay, List<String> playWays, String privacySettings, int multiples, String password, String payWay) {

        purchaseService.test(field, playWay, multiples, playWays, password, payWay);


    }

    @Test()
    public void copyTest() {
        purchaseService.copyTest();
    }


}
