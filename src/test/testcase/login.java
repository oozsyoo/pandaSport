package test.testcase;

import com.qa.framework.TestCaseBase;
import com.qa.framework.ioc.annotation.Autowired;
import org.testng.annotations.Test;
import test.datamodel.TestCaseData;
import test.service.LoginService;

/**
 * Created by Administrator on 2017/3/10.
 */
public class login extends TestCaseBase {

    @Autowired
    private LoginService loginService;

    @Test(dataProviderClass = TestCaseData.class, dataProvider = "login", description = "登陆")
    public void loginJjx(String cell, String password) {
        loginService.loginTest(cell, password);

    }
    @Test(dataProviderClass = TestCaseData.class, dataProvider = "reg", description = "注册")
    public void reg(String cell, String password) {
        loginService.reg(cell, password);

    }

}
