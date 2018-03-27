package test.page;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import test.Untils.ConstantEnum;
import test.Untils.StringUtils;
import test.Untils.Utils;

import java.util.*;


/**
 * Created by HASEE on 2017/4/10.
 */
@Page
public class ConfirmSelectPage extends AbstractPage {

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.huored.android.DongFangHong:id/passBtnsLl']/android.widget.ToggleButton")
    private List<WebElement> playWays;//串关方式集合
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/nameTb")
    private List<WebElement> morePlayWays;//更多中的串关方式集合
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/okBtn")
    private WebElement okBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/totalPriceTv")
    private WebElement totalPriceTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/numEt")
    private WebElement multiple;//倍数
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/buyBtn")
    WebElement buyBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/submitBtn")
    private WebElement submitBtn;


    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/deleteIv")
    List<WebElement> deleteIv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/numbersTv")
    List<WebElement> numbersTv;


    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/superAddTb")
    WebElement superAddTb;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/addRandomBtn")
    WebElement addRandomBtn;//添加机选一注
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/addSelfBtn")
    WebElement addSelfBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/tipTv")
    List<WebElement> tipTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/zhuShuTipTv")
    WebElement zhuShuTipTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/passTypeTv")
    WebElement passTypeTv;


    String totalPrice;
    @Autowired
    SuperLottoPage superLottoPage;

    //supperLotto
    public void zcSetPlayWays(String multiples, Map<String, String> dataMap) {


        multiple.sendKeys(multiples);
        totalPrice = totalPriceTv.getText();
        List<String> list = new ArrayList<>();
        list.addAll(StringUtils.transformSplit(zhuShuTipTv.getText(), "注", 2));
        String multiple = list.get(1).substring(0, list.get(1).length() - 2);
        dataMap.put("totalfee", totalPrice);
        dataMap.put("multiple", multiple);
        logger.info(dataMap);
        buyBtn.click();
    }

    /**
     * @param playWay
     * @param multiples
     */
    public void setPlayWays(String playWay, int multiples) {


        int index2 = 0;
        int index = 0;
        List<String> list = new ArrayList<>();
        //遍历寻找串关方式中是否有符合的选项
        for (int i = 0; i < playWays.size(); i++) {
            if (playWays.get(i).getText().equals(playWay)) {
                index = i + 1;
            }
        }
        if (index != 0) {
            playWays.get(index - 1).click();
        } else {
            playWays.get(playWays.size() - 1).click();
            //遍历寻找“更多”中的串关方式是否有符合条件的
            for (int i = 0; i < morePlayWays.size(); i++) {
                if (morePlayWays.get(i).getText().equals(playWay)) {
                    index2 = i + 1;
                }
            }
            if (index2 != 0) {
                morePlayWays.get(index2).click();
                okBtn.click();
            } else {
                logger.info("找不到串关方式：" + playWay);
                getDriver().quit();
            }
        }
        multiple.sendKeys(String.valueOf(multiples));
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

    public void superLottoSetPlayWays(int mul, ConstantEnum playWay) {


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
            multiple.sendKeys(Integer.toString(mul));

            list.addAll(StringUtils.transformSplit(tipTv.get(n).getText().replace("注", "注，"), "，", 2));

            tipMap.put(n, list);

        }
        List<String> list2 = StringUtils.transformSplit(zhuShuTipTv.getText().replace("注", "注，").trim(), "，", 2);
        superLottoPage.getSuperLottoMap().put("confirmSelect", list2);

        buyBtn.click();

    }


}
