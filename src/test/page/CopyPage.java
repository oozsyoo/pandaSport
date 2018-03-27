package test.page;

import com.qa.framework.common.Sleeper;
import com.qa.framework.common.Swipe;
import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.Untils.Utils;

import java.util.List;
import java.util.Random;

/**
 * Created by zsy on 2017/9/8.
 */
@Page
public class CopyPage extends AbstractPage {

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/beiEt")
    WebElement multiples;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/okBtn")
    WebElement okBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/cancelBtn")
    WebElement cancelBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/leftBtn")
    WebElement continueBuy;//继续购买

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/groupBtn")
    WebElement groupBtn;  //方案详情页复制神单按钮
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/copyBtn")
    List<WebElement> copyBtns;
    Random random = new Random();
    Utils utils = new Utils();

    public void copy() {
        utils.monkey(getDriver());
        copyBtns.get(random.nextInt(copyBtns.size())).click();

        int mu = random.nextInt(20);
        String numStr = String.valueOf(mu);
        multiples.sendKeys(numStr);

        okBtn.click();
        okBtn.click();

        continueBuy.click();


        new Swipe(getDriver()).swipeToUp();


    }


}
