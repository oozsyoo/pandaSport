package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2018/4/8.
 */
@Page
public class ResultPage extends AbstractPage {
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/operateTipTv')]")
    WebElement operateTipTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/leftBtn')]")
    WebElement continueBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/rightBtn')]")
    WebElement checkDetailBtn;

    public void choseNextStep(String step) {
        switch (step) {
            case "继续购买":
                continueBtn.click();
                break;
            case "查看方案详情":
                checkDetailBtn.click();
                break;

        }

    }


}
