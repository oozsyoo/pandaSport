package test.page;

import com.qa.framework.common.Sleeper;
import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'okBtn')]")
    private WebElement okBtn;
    @AndroidFindBy(xpath = "//android.widget.ToggleButton')]")
    private List<WebElement> toggleBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'submitBtn')]")
    public WebElement submitBtn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'groupArrowIv')]")
    private List<WebElement> groupArrowIv;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'groupTitleTv')]")
    private WebElement issueNo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='让球']")
    private List<WebElement> tag;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/midTitleTv')]")
    private WebElement midTitleTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/ltTypeName')]")
    private List<WebElement> ltTypeNameList;
    //ft
    @AndroidFindBy(xpath = "//android.widget.ExpandableListView//android.widget.FrameLayout")
    List<WebElement> zqgGameList;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/spfLayout')]")
    List<WebElement> spfLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/rqspfLayout')]")
    List<WebElement> rqSpfLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/moreLayout')]")
    List<WebElement> moreLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/jqsLayout')]")
    WebElement jqsLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/bfLayout')]")
    WebElement bfLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/bqcLayout')]")
    WebElement bqcLayout;


    //bt
    @AndroidFindBy(xpath = "//android.widget.ExpandableListView/android.widget.LinearLayout")
    List<WebElement> gameList;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/sfLayout')]")
    List<WebElement> sfLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/rfLayout')]")
    List<WebElement> rfLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'dxLayout')]")
    List<WebElement> dxLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/guestWinLayout')]")
    private WebElement guestWinLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/homeWinLayout')]")
    private WebElement homeWinLayout;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'letGuestWinTv')]")
    private List<WebElement> letGuestWinTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'letHomeWinTv')]")
    private List<WebElement> letHomeWinTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'moreThanTv')]")
    private List<WebElement> moreThanTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'lessThanTv')]")
    private List<WebElement> lessThanTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'shengFenSelectLayout')]")
    private List<WebElement> shengFenSelectList;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'gridTbMore')]")
    private List<WebElement> gridTbMore;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'gameNoTv')]")
    private List<WebElement> gameNos;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'leagueNameTv')]")

    private List<WebElement> leagueNameTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'stopDateTv')]")
    private List<WebElement> stopDateTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'stopTimeTv')]")
    private List<WebElement> stopTimeTv;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'concedeTv')]")
    List<WebElement> concedeTv;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'backBtn')]")
    WebElement backBtn;

    @AndroidFindBy(className = "android.widget.ScrollView")
    private WebElement morePlays;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'hhggCheckBoxLayout')]")
    WebElement hhggCheckBoxLayout;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/selectTitle')]")
    private WebElement selectTitle;
    @AndroidFindBy(xpath = "//android.widget.ListView[contains(@resource-id,'id/roomElv')]/android.widget.LinearLayout")
    List<WebElement> listViewItem;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/content')]")
    List<WebElement> playWays;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb0')]")
    List<WebElement> home0;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb1')]")
    List<WebElement> home1;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb2')]")
    List<WebElement> home2;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb3')]")
    List<WebElement> home3;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb4')]")
    List<WebElement> guest0;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb5')]")
    List<WebElement> guest1;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb6')]")
    List<WebElement> guest2;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb7')]")
    List<WebElement> guest3;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb0')]")
    List<WebElement> winList;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb1')]")
    List<WebElement> drawList;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/gridTb2')]")
    List<WebElement> lostList;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/buyBtn')]")
    WebElement buyBtn;
    @AndroidFindBy(className = "android.view.View")
    List<WebElement> lineS;

    public WebElement getBuyBtn() {
        return buyBtn;
    }


    private Utils utils = new Utils();
    private Random random = new Random();

    public WebElement getBackBtn() {
        return backBtn;
    }

    public void choseWay(ConstantEnum way, String playWay, String playItem) {
        switch (way) {
            case JCZQ:
                if (playWay.contains("单关配")) {
                    midTitleTv.click();
                    ltTypeNameList.get(1).click();

                } else if (playWay.contains("二选一")) {
                    midTitleTv.click();
                    ltTypeNameList.get(2).click();

                } else {
                    jczq(playWay, playItem);
                }

                break;
            case JCLQ:
                jclq(playWay, playItem);
                break;
            case ZC:
                choseZc(playWay);
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

    public void choseFtBallWay(String playWay) {


    }

    public void singleMatch(String playItems) {
        List<String> playItem = Arrays.asList(playItems.split(","));

    }

    public List<WebElement> exclude(List<WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).findElement(By.xpath("//*[contains(@resource-id,'groupArrowIv')]")) != null) {
                list.remove(i);
            }
        }
        return list;
    }

    public void choseMorePlays() {

        List<WebElement> items = Utils.findElementsByClassName(morePlays, "android.widget.LinearLayout")
                .get(random.nextInt(2) + 1)
                .findElements(By.className("android.widget.ToggleButton"));
        WebElement moreElement = items.get(random.nextInt(items.size()));
        moreElement.click();

        //点击确认，退出“更多”页面
        okBtn.click();
    }

    public void jczq(String playWay, String playItems) {
        List<String> playItem = Arrays.asList(playItems.split(","));
//        WebElement element = Utils.findElementsByClassName(gameList, "android.widget.FrameLayout").get(0);
        select(playWay, playItem);
        submitBtn.click();


    }


    public void jclq(String playWay, String playItems) {
        List<String> playItem = Arrays.asList(playItems.split(","));
//        WebElement element = Utils.findElementsByClassName(gameList, "android.widget.FrameLayout").get(0);
        selectLq(playWay, playItem);
        submitBtn.click();
    }


    private void selectLq(String playWay, List<String> playItem) {
        int count;

        WebElement game = null;
        List<WebElement> item = null;
        gameList.remove(0);
        int endY = gameList.get(0).getLocation().getY();
        int stepY = gameList.get(1).getSize().getHeight();
        int y = stepY;
        int bottomY = hhggCheckBoxLayout.getLocation().getY();
        if (playWay.equals("1串1")) {

            game = gameList.get(random.nextInt(gameList.size() - 1));
            count = playItem.size();
        } else {
            count = playItem.size();
        }

        boolean bound = false;
        int a = 0;
        for (int i = 0; i < count; i++) {
            if (!playWay.equals("1串1")) {
                if (a < i) {
                    game = gameList.get(gameList.size() - 1);
                } else {
                    game = gameList.get(i);
                }
            }

            //默认初始位置
            int startY = 141;
            int startX = 0;

            if (game != null) {
                startY = game.getLocation().getY();
                startX = game.getLocation().getX();

            }

            String items = playItem.get(i);
            int ss = (bottomY - startY - stepY);
            if (ss < stepY || bound) {
                a = 0;
                if (ss < stepY) {
                    ((AppiumDriver) getDriver()).swipe(startX, startY, startX, bottomY - stepY - stepY, 3000);
                }

                bound = true;
                game = gameList.get(gameList.size() - 1);


                switch (items) {
                    case "胜负":

                        item = choseLayoutItem(sfLayout.get(sfLayout.size() - 1));
                        break;
                    case "让分胜负":

                        item = choseLayoutItem(rfLayout.get(rfLayout.size() - 1));
                        break;
                    case "大小分":
                        item = choseLayoutItem(dxLayout.get(dxLayout.size() - 1));
                        break;
                    case "客胜":
                        shengFenSelectList.get(shengFenSelectList.size() - 1).click();
                        item = choseLayoutItem(guestWinLayout);
                        break;
                    case "主胜":
                        shengFenSelectList.get(shengFenSelectList.size() - 1).click();
                        item = choseLayoutItem(homeWinLayout);
                        break;
                }
                checkElementClick(item, items);

                if (items.equals("客胜") || items.equals("主胜")) {
                    okBtn.click();
                }
                ((AppiumDriver) getDriver()).swipe(startX, startY, startX, bottomY - stepY - stepY, 3000);

            } else {


                try {
                    switch (items) {
                        case "胜负":

                            item = choseLayoutItem(sfLayout.get(i));
                            break;
                        case "让分胜负":
                            item = choseLayoutItem(rfLayout.get(i));
                            break;
                        case "大小分":
                            item = choseLayoutItem(dxLayout.get(i));
                            break;
                        case "客胜":
                            shengFenSelectList.get(i).click();
                            item = choseLayoutItem(guestWinLayout);
                            break;
                        case "主胜":
                            //点击胜分差按钮
                            shengFenSelectList.get(i).click();
                            item = choseLayoutItem(homeWinLayout);
                            break;
                    }
                    //点击相应选项
                    checkElementClick(item, items);

                    if (items.equals("客胜") || items.equals("主胜")) {
                        okBtn.click();
                    }

                } catch (Exception e) {
                    e.printStackTrace();


                }

            }
            a++;
        }
    }


    private void select(String playWay, List<String> playItem) {
        int count;
        WebElement game = null;
        List<WebElement> item = null;

        int endY = zqgGameList.get(0).getLocation().getY();
        int stepY = zqgGameList.get(0).getSize().getHeight();

        //  int endY = gameList.getLocation().getY();
//        int stepY = games.get(0).getSize().getHeight();

//            for (int a = 0; a < games.size(); a++) {
//                if (item == null) {
//                    WebElement game = games.get(0);
//                    //剔除不能点击的元素
//                    item = Utils.removeUnableElement(Utils.findElementsByClassName(game, "android.widget.ToggleButton"));
//
//                    if (utils.checkIsClicked(item)) {
//                        groupArrowIv.get(0).click();
//                        ((AppiumDriver) getDriver()).swipe(startX, startY + stepY, startX, startY + stepY / 2, 1000);
//                    }
//                } else {
//                    break;
//                }
//            }
//            if (item == null) {
//                groupArrowIv.get(0).click();
//                ((AppiumDriver) getDriver()).swipe(startX, startY + stepY, startX, startY + stepY / 2, 1000);
//            }
//            //随机选取元素
//            WebElement element1 = item.get(random.nextInt(item.size()));
//            //获取选中元素的文本
//            String itemTv = element1.getText();
//            //点击元素
//            element1.click();
//            //如果点击了‘更多’则从更多中随机选取一个选项
//            String more = "更多";
//            if (itemTv.equals(more)) {
//                choseMorePlays();
//            }
//            ((AppiumDriver) getDriver()).swipe(startX, startY + stepY, startX, endY, 1000);
//        }
//        //提交所选选项
//        submitBtn.click();
        if (playWay.equals("1串1")) {

            game = zqgGameList.get(random.nextInt(zqgGameList.size() - 1));
            count = playItem.size();
        } else {
            count = playItem.size();
        }
        int a = 0;

        for (int i = 0; i < count; i++) {
            if (!playWay.equals("1串1")) {
                if (a < i) {
                    game = zqgGameList.get(i);
                } else {
                    game = zqgGameList.get(i);
                }
            }
            //默认初始位置
            int startY = 141;
            int startX = 0;

            if (game != null) {
                startY = game.getLocation().getY();
                startX = game.getLocation().getX();
            }


            if ((hhggCheckBoxLayout.getLocation().getY() - startY) < stepY) {
                ((AppiumDriver) getDriver()).swipe(startX, startY, startX, endY, 1500);
                game = zqgGameList.get(0);
                a = 0;
            }
            String items = playItem.get(i);
            WebElement more = gridTbMore.get(a);

            try {
                if (game != null) {
                    switch (items) {
                        case "胜平负":
                            item = choseZqItem(game.findElement(By.xpath("//*[contains(@resource-id,'id/spfLayout')]")));
                            logger.info("胜平负:" + item.size());
                            break;
                        case "让分胜平负":
                            item = choseZqItem(game.findElement(By.xpath("//*[contains(@resource-id,'id/rqspfLayout')]")));
                            logger.info("让分胜平负:" + item.size());
                            break;
                        case "比分":
                            more.click();
                            item = choseZqItem(bfLayout);
                            logger.info("比分:" + item.size());
                            break;
                        case "进球数":
                            more.click();
                            item = choseZqItem(jqsLayout);
                            logger.info("进球数:" + item.size());
                            break;
                        case "半全场":
                            more.click();
                            item = choseZqItem(bqcLayout);
                            logger.info("半全场:" + item.size());
                            break;
                    }
                } else {
                    logger.info("抓取的比赛为空");
                }
                checkZqElementClick(item, items);

                if (items.equals("半全场") || items.equals("进球数") || items.equals("比分")) {
                    okBtn.click();
                }

            } catch (Exception e) {
                e.printStackTrace();


            }

            a++;
        }

    }

    private void selectDgp(List<String> playItem) {


        List<WebElement> item = null;


        //  int endY = gameList.getLocation().getY();
//        int stepY = games.get(0).getSize().getHeight();

//            for (int a = 0; a < games.size(); a++) {
//                if (item == null) {
//                    WebElement game = games.get(0);
//                    //剔除不能点击的元素
//                    item = Utils.removeUnableElement(Utils.findElementsByClassName(game, "android.widget.ToggleButton"));
//
//                    if (utils.checkIsClicked(item)) {
//                        groupArrowIv.get(0).click();
//                        ((AppiumDriver) getDriver()).swipe(startX, startY + stepY, startX, startY + stepY / 2, 1000);
//                    }
//                } else {
//                    break;
//                }
//            }
//            if (item == null) {
//                groupArrowIv.get(0).click();
//                ((AppiumDriver) getDriver()).swipe(startX, startY + stepY, startX, startY + stepY / 2, 1000);
//            }
//            //随机选取元素
//            WebElement element1 = item.get(random.nextInt(item.size()));
//            //获取选中元素的文本
//            String itemTv = element1.getText();
//            //点击元素
//            element1.click();
//            //如果点击了‘更多’则从更多中随机选取一个选项
//            String more = "更多";
//            if (itemTv.equals(more)) {
//                choseMorePlays();
//            }
//            ((AppiumDriver) getDriver()).swipe(startX, startY + stepY, startX, endY, 1000);
//        }
//        //提交所选选项
//        submitBtn.clic

//
//        //默认初始位置
//        int startY = 141;
//        int startX = 0;
//
//        if (game != null) {
//            startY = game.getLocation().getY();
//            startX = game.getLocation().getX();
//        }
//
//
//            if ((hhggCheckBoxLayout.getLocation().getY() - startY) < stepY) {
//                ((AppiumDriver) getDriver()).swipe(startX, startY, startX, endY, 1500);
//                game = Utils.findElementsByClassName(gameList, "android.widget.FrameLayout").get(0);
//
//            }
        String items = playItem.get(0);
        int i = random.nextInt(gameList.size());
        try {
            switch (items) {
                case "胜平负":
                    item = choseLayoutItem(spfLayout.get(i));
                    break;
                case "让分胜平负":
                    item = choseLayoutItem(rqSpfLayout.get(i));
                    break;
            }

            checkElementClick(item, items);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void checkElementClick(List<WebElement> item, String playway) {
        WebElement element;
        if (item != null) {
            if (playway.equals("客胜") || playway.equals("主胜")) {
                element = item.get(random.nextInt(6));
                if (Utils.checkEnable(element)) {
                    element.click();
                } else {
                    logger.info("所选选项不可点击");
                }
            } else {
                element = item.get(random.nextInt(2));
                if (Utils.checkEnable(element)) {
                    element.click();
                } else {
                    logger.info("所选选项不可点击");
                }
            }


        } else {
            logger.info("选项为空，无选项可选");
        }
    }

    public void checkZqElementClick(List<WebElement> item, String playway) {
        logger.info("进入选项选择-----------------------------------------------------");
        WebElement element;
        if (item != null) {
            if (playway.equals("比分")) {
                element = item.get(random.nextInt(30));
                if (Utils.checkEnable(element)) {
                    element.click();
                } else {
                    logger.info("所选选项不可点击");
                }
            } else if (playway.equals("进球数")) {
                element = item.get(random.nextInt(7));
                if (Utils.checkEnable(element)) {
                    element.click();
                } else {
                    logger.info("所选选项不可点击");
                }
            } else if (playway.equals("半全场")) {
                element = item.get(random.nextInt(8));
                if (Utils.checkEnable(element)) {
                    element.click();
                } else {
                    logger.info("所选选项不可点击");
                }
            } else {
                element = item.get(random.nextInt(2));
                if (Utils.checkEnable(element)) {
                    element.click();
                } else {
                    logger.info("所选选项不可点击");
                }
            }


        } else {
            logger.info("选项为空，无选项可选");
        }
    }


    private List<WebElement> choseLayoutItem(WebElement layout) {
        return Utils.findElementsByClassName(layout, "android.widget.LinearLayout");
    }

    private List<WebElement> choseZqItem(WebElement layout) {

        return Utils.findElementsByClassName(layout, "android.widget.ToggleButton");
    }

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

    public void choseZc(String playWay) {
        switch (playWay) {
            case "JQ":
                selectTitle.click();
                playWays.get(1).click();
                Map<Integer, Map<Integer, List<WebElement>>> map = getJqcElement(true);

                for (int i = 0; i < map.size(); i++) {

                    Map<Integer, List<WebElement>> webelementMap = map.get(i);
                    for (int j = 0; j < webelementMap.size(); j++) {
                        webelementMap.get(j).get(new Random().nextInt(4)).click();
                    }
                }
                break;

            case "NINE":
                selectTitle.click();
                playWays.get(2).click();


                nineClick();
                break;

            case "SIX":
                selectTitle.click();
                playWays.get(3).click();
                Map<Integer, Map<Integer, List<WebElement>>> map2 = getJqcElement(false);
                int endY2 = listViewItem.get(0).getLocation().getY();
                int x2 = listViewItem.get(0).getLocation().getX();
                int starty2 = listViewItem.get(listViewItem.size() - 1).getLocation().getY();

                for (int j = 0; j < 2; j++) {
                    selectZcBqc(map2);
                    ((AppiumDriver) getDriver()).swipe(x2, starty2, x2, endY2, 0);
                }
                break;

            case "SF":
                int endY3 = listViewItem.get(0).getLocation().getY();
                int x3 = listViewItem.get(0).getLocation().getX();
                int starty3 = listViewItem.get(listViewItem.size() - 1).getLocation().getY();
                for (int i = 0; i < 3; i++) zcClick(x3, starty3, endY3);
                break;
        }


        submitBtn.click();
    }

    /**
     * 選擇足彩6場半全場的比賽
     *
     * @param map 6場半全場的比賽選項Map
     */
    public void selectZcBqc(Map<Integer, Map<Integer, List<WebElement>>> map) {
        for (int i = 0; i < map.size(); i++) {

            Map<Integer, List<WebElement>> webelementMap = map.get(i);
            for (int f = 0; f < webelementMap.size(); f++) {//半全場各隨機選一個選項
                List<WebElement> list = webelementMap.get(f);
                if (!checkChecked(list)) {

                    WebElement element = list.get(new Random().nextInt(3));
                    if (element.getAttribute("checked").equals("false")) {
                        element.click();
                    }
                }
            }
        }
    }

    public Map<Integer, Map<Integer, List<WebElement>>> getJqcElement(boolean chose) {
        Map<Integer, Map<Integer, List<WebElement>>> jqcWebelement = new HashMap<>();

        if (chose) {
            for (int i = 0; i < home0.size(); i++) {
                Map<Integer, List<WebElement>> map = new HashMap<>();
                List<WebElement> list = new ArrayList<>();
                List<WebElement> list2 = new ArrayList<>();
                list.add(home0.get(i));
                list.add(home1.get(i));
                list.add(home2.get(i));
                list.add(home3.get(i));
                list2.add(guest0.get(i));
                list2.add(guest1.get(i));
                list2.add(guest2.get(i));
                list2.add(guest3.get(i));
                map.put(0, list);
                map.put(1, list2);
                jqcWebelement.put(i, map);


            }
        } else {
            for (int i = 0; i < home0.size(); i++) {
                Map<Integer, List<WebElement>> map = new HashMap<>();
                List<WebElement> list = new ArrayList<>();
                List<WebElement> list2 = new ArrayList<>();
                list.add(home0.get(i));
                list.add(home1.get(i));
                list.add(home2.get(i));
                list2.add(home3.get(i));
                list2.add(guest0.get(i));
                list2.add(guest1.get(i));
                map.put(0, list);
                map.put(1, list2);
                jqcWebelement.put(i, map);


            }
        }
        return jqcWebelement;
    }

    public void zcClick(int x, int starty, int endY) {

        for (int i = 0; i < listViewItem.size(); i++) {
            List<WebElement> playList = listViewItem.get(i).findElements(By.xpath("//*[contains(@class,'ToggleButton')]"));
            if (!checkChecked(playList)) {
                for (int j = 0; j < playList.size(); j++) {
                    WebElement element = playList.get(j);
                    if (element.getAttribute("checked").equals("false")) {
                        element.click();
                    }
                }
            }

        }

        ((AppiumDriver) getDriver()).swipe(x, starty, x, endY, 0);

    }

    public Map<String, Integer> getElementLocation(WebElement element) {
        Map<String, Integer> map = new HashedMap();
        Point location = element.getLocation();
        int x = location.getX();
        int y = location.getY();
        Dimension size = element.getSize();
        int stepX = size.getWidth();
        int stepY = size.getHeight();
        map.put("x", x);
        map.put("y", y);
        map.put("stepX", stepX);
        map.put("stepY", stepY);

        return map;
    }

    public void nineClick() {
        boolean bound = false;
        WebElement element = null;
        WebElement game;
        int stepY = listViewItem.get(1).getSize().getHeight();
        int endY = lineS.get(lineS.size() - 1).getLocation().getY();
        for (int i = 0; i < 9; i++) {
            if (bound) {
                game = listViewItem.get(listViewItem.size() - 1);
            } else {
                game = listViewItem.get(i);
            }

            Map<String, Integer> elementLoca = getElementLocation(game);
            int startY = elementLoca.get("y");
            int startX = elementLoca.get("x");
            if (endY - startY < stepY || bound) {
                logger.info(i);

                if (bound) {
                    ((AppiumDriver) getDriver()).swipe(startX, startY, 0, endY - stepY - stepY, 3000);
                } else {
                    ((AppiumDriver) getDriver()).swipe(startX, startY, 0, endY - stepY, 3000);
                }
                getSleeper().sleep(1000);
                List<WebElement> itemsList = listViewItem.get(listViewItem.size() - 1)
                        .findElements(By.xpath("//*[contains(@class,'ToggleButton')]"));
                element = itemsList
                        .get(new Random().nextInt(2));
                bound = true;
            } else {
                List<WebElement> itemList = game.findElements(By.xpath("//*[contains(@class,'ToggleButton')]"));
                element = itemList.get(new Random().nextInt(2));
            }
            element.click();
        }
    }


    //判斷是否有點擊過的選項，有返回true，沒有返回false
    public boolean checkChecked(List<WebElement> list) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            WebElement element = list.get(i);
            if (element.getAttribute("checked").equals("true")) {
                flag = true;
            }
        }

        return flag;
    }


}
