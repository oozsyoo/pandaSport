package test.page;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.Untils.ConstantEnum;
import test.Untils.MyStringUtils;
import test.Untils.Utils;

import java.util.*;


/**
 * Created by HASEE on 2017/4/10.
 */
@Page
public class ConfirmSelectPage extends AbstractPage {


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'nameTb')]")
    private List<WebElement> morePlayWays;//更多中的串关方式集合
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'passBtnsLl')]//android.widget.ToggleButton")
    private List<WebElement> bunchWayList;//串关方式集合
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'okBtn')]")
    private WebElement okBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'totalPriceTv')]")
    private WebElement totalPriceTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'numEt')]")
    private WebElement multipleEt;//倍数
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'buyBtn')]")
    WebElement buyBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'submitBtn')]")
    private WebElement submitBtn;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'deleteIv')]")
    List<WebElement> deleteIv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'numbersTv')]")
    List<WebElement> numbersTv;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'superAddTb')]")
    WebElement superAddTb;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'addRandomBtn')]")
    WebElement addRandomBtn;//添加机选一注
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'addSelfBtn')]")
    WebElement addSelfBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tipTv')]")
    List<WebElement> tipTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'zhuShuTipTv')]")
    WebElement zhuShuTipTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'passTypeTv')]")
    WebElement passTypeTv;


    String totalPrice;
    @Autowired
    SuperLottoPage superLottoPage;

    //supperLotto
    public void zcSetPlayWays(String multiple, Map<String, String> dataMap) {


        multipleEt.sendKeys(multiple);
        totalPrice = totalPriceTv.getText();
        List<String> list = new ArrayList<>();
        list.addAll(MyStringUtils.transformSplit(zhuShuTipTv.getText(), "注", 2));
        String multipleTv = list.get(1).substring(0, list.get(1).length() - 2);
        dataMap.put("totalfee", totalPrice);
        dataMap.put("multiple", multipleTv);
        logger.info(dataMap);
        buyBtn.click();
    }

    /**
     * @param playWay
     * @param multiple
     */
    public void setPlayWays(String playWay, String multiple) {
        findPlayWays(playWay);
        multipleEt.sendKeys(multiple);
//        List<String> strList = new ArrayList<>();
//
//        strList.addAll(StringUntils.transformSplit(totalPriceTv.getText(), "，", 4));
//
//        for (int i = 0; i < strList.size(); i++) {
//            String str = strList.get(i);
//            String num = str.substring(0, str.length() - 1);
//            list.add(num);
//        }
//        logger.info(list);
//        String games = list.get(0);
//        String num = list.get(1);
//        String multiple = list.get(2);
//        totalPrice = list.get(3);
//        dataMap.put("game", games);
//        dataMap.put("note", num);
//        dataMap.put("totalfee", totalPrice);
//        dataMap.put("multiple", multiple);
//随机获取倍数
//        multiple.sendKeys(String.valueOf(new Random().nextInt(100)));
        submitBtn.click();

    }

    public void setPlayWays(String playWay) {
        findPlayWays(playWay);
        submitBtn.click();

    }

    public void findPlayWays(String playWay) {
        List<String> bunchWayList = new ArrayList<>(Arrays.asList(playWay.split(",")));

        boolean index2 = false;
        boolean index;
        List<String> list = new ArrayList<>();
        //遍历寻找串关方式中是否有符合的选项
        for (int i = 0; i < bunchWayList.size(); i++) {
            String bunchWay = bunchWayList.get(i);
            index = chosePlayWay(this.bunchWayList, bunchWay);


            if (!index) {
                //点击更多
                this.bunchWayList.get(this.bunchWayList.size() - 1).click();
                //遍历寻找“更多”中的串关方式是否有符合条件的

                if (!index2) {
                    index2 = chosePlayWay(morePlayWays, bunchWay);
                    okBtn.click();
                } else {
                    logger.info("找不到串关方式：" + playWay);
                    getDriver().quit();
                }
            }
        }
    }


    public boolean chosePlayWay(List<WebElement> playWays, String playWay) {

        boolean index = false;
        for (WebElement element : playWays) {

            String t = element.getText();
            if (t.equals(playWay)) {
                element.click();
                index = true;
            }
        }


        return index;

    }

    public void superLottoSetPlayWays(String multiples, ConstantEnum playWay) {


        Map<Integer, String> ballMap = new HashMap<>();
        Map<Integer, List<String>> tipMap = new HashMap<>();
        switch (playWay) {
            case SUPERLOTTO_ADD:
                superAddTb.click();
                break;
            case SUPERLOTTO_ADDRANDOM:
                addRandomBtn.click();
                break;
            case SUPERLOTTO_ADDSELF:
                addSelfBtn.click();
                break;
            default:
        }

        for (int n = 0; n < numbersTv.size(); n++) {
            List<String> list = new ArrayList<>();
            String balls = numbersTv.get(n).getText().replace(" ", "，").replace("，:，", " | ");
            ballMap.put(n, balls);
            multipleEt.sendKeys(multiples);

            list.addAll(MyStringUtils.transformSplit(tipTv.get(n).getText().replace("注", "注，"), "，", 2));

            tipMap.put(n, list);

        }
        List<String> list2 = MyStringUtils.transformSplit(zhuShuTipTv.getText().replace("注", "注，").trim(), "，", 2);
        superLottoPage.getSuperLottoMap().put("confirmSelect", list2);

        buyBtn.click();

    }


}
