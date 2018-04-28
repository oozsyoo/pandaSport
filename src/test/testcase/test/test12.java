package test.testcase.test;

import com.qa.framework.TestCaseBase;
import com.qa.framework.config.PropConfig;
import com.qa.framework.ioc.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.Untils.FileTools;
import test.datamodel.TestCaseData;
import test.service.LoginService;
import test.service.PurchaseService;
import test.Untils.ConstantEnum;
import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */

public class test12 extends TestCaseBase {
    @Autowired
    LoginService loginService;
    @Autowired
    PurchaseService purchaseService;
    @BeforeClass
    public void loginJjx() {
        PropConfig.setAppBin(FileTools.getFile("res\\",0,11));

    }
    @Test(dataProviderClass = TestCaseData.class, dataProvider = "PlayWays1", description = "玩法")
    public void test(List<String> playWay, List<String> playWays, ConstantEnum privacySettings, String multiples,String  version) {
        if (PropConfig.getAppBin().contains("com")) {
            loginService.login("15355090684", "123456");
        } else {
            loginService.login("15355090684", "123456");
        }
        purchaseService.testLq( playWay,privacySettings, multiples, playWays,version);


    }








}
