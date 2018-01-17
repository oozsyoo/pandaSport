package test.testcase;

import com.qa.framework.TestCaseBase;
import com.qa.framework.ioc.annotation.Autowired;
import org.testng.annotations.*;
import test.Untils.ConstantEnum;
import test.datamodel.TestCaseData;
import test.page.HomePage;
import test.service.LoginService;
import test.service.PurchaseService;

/**
 * Created by Administrator on 2017/3/15.
 */
public class purchase extends TestCaseBase {

    int num;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private HomePage homePage;

    @BeforeMethod
    public void loginJjx() {
//        if (PropConfig.getAppBin().contains("com")) {
//            loginService.login("15355090684", "123456");
//        } else {
//            loginService.login("18368090404", "123456");
//        }
        loginService.login("18368090103", "123456");
    }

    public void count() {
        num++;
    }


    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays", description = "玩法")
    public void playWays(int field, String playWay, ConstantEnum privacySettings, String multiples) {

        purchaseService.purchase(field, playWay, privacySettings, multiples);


    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays", description = "玩法", invocationCount = 2)
    public void BuyInBulk(int field, String playWay, String privacySettings, String multiples) {

        purchaseService.BuyInBulk(field, playWay, privacySettings, multiples, 100);


    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "superLotto", description = "选法")
    public void purchaseSuperLotto(int redBall, int buleBall, ConstantEnum playWay, int multiples, ConstantEnum privacySettings) {

        purchaseService.purchaseSuperLotto(redBall, buleBall, privacySettings, playWay, multiples);


    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays", description = "玩法")
    public void test(int field, String playWay, String privacySettings, String multiples) {

        purchaseService.test(field, playWay);


    }

    @Test()
    public void copyTest() {
        purchaseService.copyTest();
    }

    @AfterTest
    public void print() {
        logger.info(num);
    }

}
