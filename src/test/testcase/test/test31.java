package test.testcase.test;

import com.qa.framework.TestCaseBase;
import com.qa.framework.config.PropConfig;
import com.qa.framework.ioc.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.Untils.ConstantEnum;
import test.Untils.FileTools;
import test.datamodel.TestCaseData;
import test.service.LoginService;
import test.service.PurchaseService;

import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */

public class test31 extends TestCaseBase {
    @Autowired
    LoginService loginService;
    @Autowired
    PurchaseService purchaseService;

    @BeforeClass
    public void loginJjx() {
        PropConfig.setAppBin(FileTools.getFile("res\\",0,30));
    }

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "OnLineTest31", description = "玩法")
    public void test(int redBall, int buleBall, ConstantEnum playWay, String multiples, ConstantEnum privacySettings,String version) {

        if (PropConfig.getAppBin().contains("com")) {
            loginService.login("15355090684", "123456");
        } else {
            loginService.login("15355090684", "123456");
        }
        purchaseService.purchaseSuperLotto(redBall, buleBall, privacySettings, playWay, multiples,version);



    }


}
