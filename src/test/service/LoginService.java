package test.service;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import test.Untils.ConstantEnum;
import test.Untils.WaitUtils;
import test.datamodel.TestModel;
import test.page.HomePage;
import test.page.LoginPage;
import test.page.RegisterPage;

import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/3/10.
 */
@Page
public class LoginService {
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private HomePage homePage;
    @Autowired
    private RegisterPage registerPage;
    @Autowired
    private WaitUtils waitUtils;

    public void login(String cell, String password) {



        if(loginPage.getClickToLogin().isDisplayed()){
            loginPage.getClickToLogin().click();
            loginPage.checkUpdate(false);
            loginPage.login(cell, password);
            loginPage.gesture(true);
        }else {
            loginPage.gesture(false);
        }



//     homePage.choseFragmentPage("会员中心");
//     homePage.clickUser();
    }

    public void loginTest(String cell, String password) {
        login(cell, password);

        homePage.choseFragment(ConstantEnum.HOME);
//     homePage.clickUser();
    }

    public void reg(String cell, String password) {

        loginPage.checkUpdate(false);
        try {
            waitUtils.waitForLoadingElementbyId(loginPage.getClickToLogin());
            loginPage.getClickToLogin().click();

        } catch (RuntimeException  e) {
            e.printStackTrace();
            loginPage.gesture(false);
        }
        try{
            registerPage.register(cell, password);
            loginPage.gesture(true);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
