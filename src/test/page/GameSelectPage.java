package test.page;

import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.Untils.ConstantEnum;
import test.Untils.Utils;
import test.datamodel.TestModel;

import java.util.*;

/**
 * @author Administrator
 * @date 2017/4/1
 */
@Page
public class GameSelectPage extends AbstractPage {


    @AndroidFindBy(xpath = "//android.widget.ExpandableListView[@resource-id=\"com.huored.android.DongFangHong:id/roomElv\"]//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.ToggleButton")
    List<WebElement> list;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/okBtn")
    private WebElement okBtn;
    @AndroidFindBy(xpath = "//android.widget.ToggleButton")
    private List<WebElement> toggleBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/submitBtn")
    public WebElement submitBtn;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/groupArrowIv")
    private List<WebElement> groupArrowIv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/groupTitleTv")
    private WebElement issueNo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='让球']")
    private List<WebElement> tag;

    //ft
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/spfLayout")
    List<WebElement> spfLayout;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/rqspfLayout")
    List<WebElement> rqSpfLayout;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/moreLayout")
    List<WebElement> moreLayout;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/jqsLayout")
    WebElement jqsLayout;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/bfLayout")
    WebElement bfLayout;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/bqcLayout")
    WebElement bqcLayout;


    //bt
    @AndroidFindBy(id = "com.huored.android.LanTing:id/sfLayout")
    List<WebElement> sfLayout;
    @AndroidFindBy(id = "com.huored.android.LanTing:id/rfLayout")
    List<WebElement> rfLayout;
    @AndroidFindBy(id = "com.huored.android.LanTing:id/dxLayout")
    List<WebElement> dxLayout;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/guestWinTv")
    private List<WebElement> guestWinTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/homeWinTv")
    private List<WebElement> homeWinTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/letGuestWinTv")
    private List<WebElement> letGuestWinTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/letHomeWinTv")
    private List<WebElement> letHomeWinTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/moreThanTv")
    private List<WebElement> moreThanTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/lessThanTv")
    private List<WebElement> lessThanTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/shengFenSelectTv")
    private List<WebElement> shengFenSelectTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/gridTbMore")
    private List<WebElement> gridTbMore;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.huored.android.DongFangHong:id/jqsLayout\"]//android.widget.ToggleButton")
    private List<WebElement> playwayJqs;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.huored.android.DongFangHong:id/bfLayout\"]//android.widget.ToggleButton")
    private List<WebElement> playwayBf;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.huored.android.DongFangHong:id/bqcLayout\"]//android.widget.ToggleButton")
    private List<WebElement> playwayBqc;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/gameNoTv")
    private List<WebElement> gameNos;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/leagueNameTv")

    private List<WebElement> leagueNameTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/stopDateTv")
    private List<WebElement> stopDateTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/stopTimeTv")
    private List<WebElement> stopTimeTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/concedeTv")
    List<WebElement> concedeTv;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/roomElv")
    private WebElement gameList;
    @AndroidFindBy(className = "android.widget.ScrollView")
    private WebElement morePlays;


    @AndroidFindBy(xpath = "//android.widget.ExpandableListView[@resource-id=\"com.huored.android.DongFangHong:id/roomElv\"]//android.widget.FrameLayout")
    List<WebElement> infoList;


    String et = " ";
    Utils utils = new Utils();
    private Random random = new Random();
    private ConstantEnum ContantsEnum;

    public void choseWay(ConstantEnum way, int field, String playWay, List<String> playItem) {
        switch (way) {
            case JCZQ:
                jczq(playWay, field, playItem);
                break;
            case JCLQ:
//                chosegamesJclq(field, playWay);
                break;
            case ZC:

                break;
            case DLT:

                break;
            case YYFD:

                break;
            case BFZB:

                break;
            default:
        }
    }

    public void choseWay(ConstantEnum way, int field, String playWay) {
        switch (way) {
            case JCZQ:
                jczq(playWay, field);
                break;
            case JCLQ:
//                jclq(field, playWay);
                break;
            case ZC:

                break;
            case DLT:

                break;
            case YYFD:

                break;
            case BFZB:

                break;
            default:
        }
    }

    public void jczq(String playWay, int field) {

        //获取所有比赛
        List<WebElement> games = gameList.findElements(By.className("android.widget.FrameLayout"));

        try {
            for (int i = 0; i < field; i++) {
                String more = "更多";
                //按照顺序提取比赛
                WebElement game = games.get(i);
                //剔除不能点击的元素
                List<WebElement> item = new Utils().removeUnableElement(game.findElements(By.className("android.widget.ToggleButton")));
                //随机选取元素
                WebElement element = item.get(random.nextInt(item.size()));
                //获取选中元素的文本
                String itemTv = element.getText();
                //点击元素
                element.click();
                //如果点击了‘更多’则从更多中随机选取一个选项
                if (itemTv.equals(more)) {

                    List<WebElement> items = morePlays.findElements(By.className("android.widget.LinearLayout"))
                            .get(random.nextInt(2) + 1)
                            .findElements(By.className("android.widget.ToggleButton"));
                    WebElement moreElement = items.get(random.nextInt(items.size()));
                    moreElement.click();
                    //点击确认，退出“更多”页面
                    okBtn.click();
                }


            }
        } catch (IndexOutOfBoundsException e) {

            logger.info("比赛场数不足");

            e.printStackTrace();
        }


        //                int chosePlayway = random.nextInt(5);
//                String r1 = switchPlayWay(chosePlayway, "common");//获取彩种
//                List<WebElement> list = webelementMap.get(r1);
//                Map<Integer, WebElement> webElementMap = untils.removeUnableElement(list);
//                List<Integer> keyList = untils.getKeyValue(webElementMap);
//                int r2 = untils.getNotRepeatNum(keyList);
//
//                WebElement webElement = webElementMap.get(keyList.get(r2));
//                StringBuilder stringBuilder = new StringBuilder(webElement.getText());
//                String str = "[" + stringBuilder.insert(1, "]");
//
//                et = et + playWayToChinese(r1, keyList.get(r2)) + " " + str;
//            dataMap.put("et", et.trim());
        //提交所选选项
        submitBtn.click();


    }


    public void jczq(String playWay, int field, List<String> playItem) {

        List<WebElement> games = gameList.findElements(By.className("android.widget.FrameLayout"));
        if (playWay.equals("1串1")) {

            WebElement game = games.get(random.nextInt(games.size() - 1));
            for (int i = 0; i < playItem.size(); i++) {
                String items = playItem.get(i);
                select(items, i, game);
            }
        }
        for (int i = 0; i < field; i++) {
            WebElement game = games.get(i);
            String items = playItem.get(i);
            select(items, i, game);
        }
        submitBtn.click();
    }


    private void select(String items, int i, WebElement game) {
        WebElement more = game.findElement(By.id("com.huored.android.DongFangHong:id/gridTbMore"));
        List<WebElement> item = new ArrayList<>();
        WebElement element;
        try {
            switch (items) {
                case "胜平负":
                    item = choseLayoutItem(spfLayout.get(i));
                    break;
                case "让分胜平负":
                    item = choseLayoutItem(rqSpfLayout.get(i));
                    break;
                case "比分":
                    more.click();
                    item = choseLayoutItem(bfLayout);
                    break;
                case "进球数":
                    more.click();
                    item = choseLayoutItem(jqsLayout);
                    break;
                case "半全场":
                    more.click();
                    item = choseLayoutItem(bqcLayout);
                    break;
            }
            if (item != null) {
                element = item.get(random.nextInt(item.size()));
                element.click();
            } else {
                logger.info("选项为空，无选项可选");
            }

            if (items.equals("半全场") || items.equals("进球数") || items.equals("比分")) {
                okBtn.click();
            }

        } catch (Exception e) {
            e.printStackTrace();


        }
    }


    private List<WebElement> choseLayoutItem(WebElement layout) {
        return layout.findElements(By.className("android.widget.ToggleButton"));
    }


    private Map<String, List<WebElement>> collectMorePlayWay(String gameNo) {
        Map<String, List<WebElement>> morePlayWayList = new HashMap<>();
        if (checkSupport(Utils.getdate(), "SUPPORT_JQS_DG", gameNo)) {
            morePlayWayList.put(Utils.getdate(), playwayJqs);
        }
        if (checkSupport(Utils.getdate(), "SUPPORT_BF_DG", gameNo)) {
            morePlayWayList.put("比分", playwayBf);
        }
        if (checkSupport(Utils.getdate(), "SUPPORT_BQC_DG", gameNo)) {
            morePlayWayList.put("半全场", playwayBqc);
        }


        return morePlayWayList;
    }

    private String switchPlayWay(int key, String type) {


        String value = null;
        String moreOption = "moreOption";
        if (moreOption.equals(type)) {
            switch (key) {

                case 0:
                    value = ConstantEnum.JQS.name;
                    break;
                case 1:
                    value = ConstantEnum.BF.name;
                    break;
                case 2:
                    value = ConstantEnum.BQC.name;
                    break;
                default:

            }
        } else {
            switch (key) {

                case 0:
                    value = ConstantEnum.WIN.name;
                    break;
                case 1:
                    value = ConstantEnum.DRAW.name;
                    break;
                case 2:
                    value = ConstantEnum.LOST.name;
                    break;
                case 3:
                    value = ConstantEnum.RQ_WIN.name;
                    break;
                case 4:
                    value = ConstantEnum.RQ_DRAW.name;
                    break;
                case 5:
                    value = ConstantEnum.RQ_LOST.name;
                    break;
                default:
            }

        }
        return value;
    }

    private String playWayToChinese(String key, int r1) {
        String value = null;
        switch (key) {

            case "win":
                value = "胜";
                break;
            case "drawn":
                value = "平";
                break;
            case "lost":
                value = "负";
                break;
            case "rWin":
                value = "让(" + concedeTv.get(r1).getText() + ")";
                break;
            case "rDrawn":
                value = "让(" + concedeTv.get(r1).getText() + ")";
                break;
            case "rLost":
                value = "让(" + concedeTv.get(r1).getText() + ")";
                break;
            default:

        }
        return value;
    }

//    public Map<String, List<WebElement>> gameSet() {
//        Map<String, List<WebElement>> itemList = new HashMap<>();
//        for (int i = 0; i < spfLayout.size(); i++) {
//
//            List<WebElement> spf = spfLayout.get(i).findElements(By.className("android.widget.ToggleButton"));
//            List<WebElement> rqSpf = rqSpfLayout.get(i).findElements(By.className("android.widget.ToggleButton"));
//            List<WebElement> more = moreLayout.get(i).findElements(By.className("android.widget.ToggleButton"));
//
//            itemList.put("spf", spf);
//            itemList.put("rqSpf", rqSpf);
//            itemList.put("more", more);
//
//        }
//        return itemList;
//    }
//
//    public void chosegamesJclq(int field, String playWay) {
//        int g = 0;
//        int r1;
//        if (playWay.equals(ConstantEnum.M_1_N_1.getName())) {
//            shengFenSelectTv.get(0).click();
//            getSleeper().sleep(1000);
//
//            for (int i = 0; i < field; i++) {
//                r1 = (int) (g + Math.random() * 2);
//                toggleBtn.get(r1).click();
//                g = (i + 1) * 3;
//            }
//            okBtn.click();
//        } else {
//            for (int i = 0; i < field; i++) {
//                r1 = (int) (g + Math.random() * 6);
//                gameSet().get(i).get(r1).click();
//                g = (i + 1) * 6;
//            }
//        }
//
//        submitBtn.click();
//    }



    public boolean checkSupport(String issue, String item, String gameNo) {
        boolean flag = false;

        Map<String, Object> supportList = TestModel.getCheckPlay(issue, gameNo);
        //是否支持半全场过关
        String supportBqcGg = supportList.get("SUPPORT_BQC_GG").toString();
        //是否支持半全场单关
        String supportBqcDg = supportList.get("SUPPORT_BQC_DG").toString();
        //是否支持比分过关
        String supportBfGg = supportList.get("SUPPORT_BF_GG").toString();
        //是否支持比分单关
        String supportBfDg = supportList.get("SUPPORT_BF_DG").toString();
        //是否支持进球数过关
        String supportJqsGg = supportList.get("SUPPORT_JQS_GG").toString();
        //是否支持进球数单关
        String supportJqsDg = supportList.get("SUPPORT_JQS_DG").toString();
        //是否支持让球胜平负过关
        String supportRqspfGg = supportList.get("SUPPORT_RQSPF_GG").toString();
        //是否支持让球胜平负单关
        String supportRqspfDg = supportList.get("SUPPORT_RQSPF_DG").toString();
        //是否支持胜平负过关
        String supportSpfGg = supportList.get("SUPPORT_SPF_GG").toString();
        //是否支持胜平负单关
        String supportSpfDg = supportList.get("SUPPORT_SPF_DG").toString();

        String eable = "1";

        switch (item) {

            case "SUPPORT_BQC_GG":

                if (eable.equals(supportBqcGg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_BQC_DG":
                if (eable.equals(supportBqcDg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_BF_GG":
                if (eable.equals(supportBfGg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_BF_DG":
                if (eable.equals(supportBfDg)) {
                    flag = true;

                }
                break;

            case "SUPPORT_JQS_GG":
                if (eable.equals(supportJqsGg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_JQS_DG":
                if (eable.equals(supportJqsDg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_RQSPF_GG":
                if (eable.equals(supportRqspfGg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_RQSPF_DG":
                if (eable.equals(supportRqspfDg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_SPF_GG":
                if (eable.equals(supportSpfGg)) {
                    flag = true;

                }
                break;
            case "SUPPORT_SPF_DG":
                if (eable.equals(supportSpfDg)) {
                    flag = true;
                }
                break;
            default:
        }
        return flag;

    }
}
