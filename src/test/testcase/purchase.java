package test.testcase;

import com.qa.framework.TestCaseBase;
import com.qa.framework.config.PropConfig;
import com.qa.framework.ioc.annotation.Autowired;
import org.testng.annotations.BeforeClass;
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
public class purchase extends TestCaseBase {


    @Autowired
    private LoginService loginService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private HomePage homePage;


    @Test(dataProviderClass = TestCaseData.class, dataProvider = "superLotto", description = "选法")
    public void purchaseSuperLotto(int redBall, int buleBall, ConstantEnum playWay, String multiples, ConstantEnum privacySettings, String version) {
        if (PropConfig.getAppBin().contains("com")) {
            loginService.login("15355090684", "123456");
        } else {
            loginService.login("15355090684", "123456");
        }
        purchaseService.purchaseSuperLotto(redBall, buleBall, privacySettings, playWay, multiples, version);


    }



    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays1", description = "玩法")
    public void test(List<String> playWay, List<String> playWays, ConstantEnum privacySettings, String multiples, String verison) {
        if (PropConfig.getAppBin().contains("com")) {
            loginService.login("15355090684", "123456");
        } else {
            loginService.login("15355090684", "123456");
        }
        purchaseService.testZq( playWay,privacySettings, multiples, playWays, verison);


    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays1", description = "玩法")
    public void test2(List<String> playWay, List<String> playWays, ConstantEnum privacySettings, String multiples, String version) {
        if (PropConfig.getAppBin().contains("com")) {
            loginService.login("15355090684", "123456");
        } else {
            loginService.login("15355090684", "123456");
        }

        purchaseService.testLq(playWay, privacySettings, multiples, playWays, version);


    }

    @Test()
    public void copyTest() {
        purchaseService.copyTest();
    }


}
