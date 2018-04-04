package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import test.Untils.DataUtils;
import test.Untils.ImageUtils;
import test.Untils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/7.
 */
@Page
public class SuperLottoPage extends AbstractPage{

    @AndroidFindBy(xpath= "//*[contains(@resource-id,'ballTv')]")
    private List<WebElement> ballTv;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'shakeLayout')]")
    private WebElement shakeTv;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'submitBtn')]")
    private WebElement submitBtn;
    @AndroidFindBy(xpath= "//*[contains(@resource-id,'totalTipTv')]")
    private WebElement totalTipTv;

    Utils utils = new Utils();
    List<Integer> numList = new ArrayList<>();


    private Map<String, List<String>> superLottoMap = new HashMap<>();

    public SuperLottoPage() {
    }

    Map<String, List<String>> getSuperLottoMap() {
        return superLottoMap;
    }

    public void shake() {
        List<String> list = new ArrayList<>();

        shakeTv.click();

        list = new ImageUtils().getRandomBallNumbers( getDriver(), ballTv.get(0), ballTv.get(35), list);
        logger.info(list);

        submitBtn.click();

    }


    public void choseBall(int redNum, int buleNum) {
        int r1=0;
        //点击红球
        for (int i = 0; i < redNum; i++) {
            r1 = utils.getNotRepeatNum(true, 34);
            WebElement element = ballTv.get(r1);
            element.click();
           DataUtils.getRedNumList().add(r1);

        }
        //点击蓝球
        for (int i = 0; i < buleNum; i++) {
            r1 = utils.getNotRepeatNum(false, 12);
            WebElement element = ballTv.get(r1);
            element.click();

           DataUtils.getBuleNumList().add(r1 - 35);
        }

        DataUtils.putSuperLottoData( "redBall");
        DataUtils.putSuperLottoData( "buleBall");
        DataUtils.putSuperLottoData(totalTipTv);

        submitBtn.click();

    }

    public List<Integer> getBall() {

        return new ArrayList<>();
    }


}
