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

public class test03 extends TestCaseBase {
    @Autowired
    LoginService loginService;
    @Autowired
    PurchaseService purchaseService;
    @BeforeClass
    public void loginJjx() {
//        Test1 test01=new Test1();
//       test01.readAPK("res\\" + PropConfig.getAppBin()).get("packageName").toString();
        PropConfig.setAppBin(FileTools.getFile("res\\",0,2));

    }
    @Test(dataProviderClass = TestCaseData.class, dataProvider = "OnLineTest03", description = "玩法")
    public void test(List<String> playWay, List<String> playWays, ConstantEnum privacySettings, String multiples, String  version) {
        if (PropConfig.getAppBin().contains("com")) {
            loginService.login("15355090684", "123456");
        } else {
            loginService.login("15355090684", "123456");
        }
        purchaseService.testLq( playWay,privacySettings, multiples, playWays,version);


    }








}
