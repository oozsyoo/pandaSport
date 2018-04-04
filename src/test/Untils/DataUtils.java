package test.Untils;

import com.qa.framework.common.Sleeper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import test.datamodel.TestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zsy on 2017/7/4.
 */
public class DataUtils {

    private final Logger logger = Logger.getLogger(this.getClass());
    private Sleeper sleeper = new Sleeper();

    private static Map<Object, List<Object>> map = new HashMap<>();
    private static Map<String, List<String>> superLottoMap = new HashMap<>();
    static Map<String, List<Integer>> ballMap = new HashMap<>();
    static List<Integer> buleNumList = new ArrayList<>();
    static List<Integer> redNumList = new ArrayList<>();
    static List<String> gameInfoList = new ArrayList<>();

    public static List<Integer> getBuleNumList() {
        return buleNumList;
    }

    public static List<Integer> getRedNumList() {
        return redNumList;
    }

    public static  void putJclqGameInfoDate(List<WebElement> gameNos, List<WebElement> leagueNameTv, List<WebElement> stopDateTv, List<WebElement> stopTimeTv, int i) {
        List<WebElement> list = new ArrayList<>();
        StringBuffer gameInfo = new StringBuffer();
        gameInfo.append(gameNos.get(i).getText());
        gameInfo.append("," + leagueNameTv.get(i).getText());
        gameInfo.append("," + stopDateTv.get(i).getText());
        gameInfo.append("," + stopTimeTv.get(i).getText());

        gameInfoList.add(gameInfo.toString());

    }

    public void getData(String cell, ConstantEnum cellEnum, Map<String, String> detail, Map<String, Object> trueDetail) {
        String detail_old;
        String detail_new;
        List<Object> list = new ArrayList<>();
        if (cell.equals(ConstantEnum.TOTAL_FEE.name)) {
            detail_old = String.valueOf(Integer.parseInt(trueDetail.get(ConstantEnum.TOTAL_FEE.name).toString()) / 100);
            detail_new = detail.get(ConstantEnum.TOTALFEE);
            checkData(String.valueOf(detail_new), String.valueOf(detail_old), cellEnum.name);
        } else if (cell.equals("gmt_create")) {
            String str_gmt_create = trueDetail.get(cell).toString();
            detail_old = str_gmt_create.substring(0, str_gmt_create.length() - 2);
            detail_new = detail.get(cellEnum);
        } else if (cell.equals("mix_types")) {
            detail_new = detail.get(cellEnum).trim();
            detail_old = trueDetail.get(cell).toString().substring(2).replace("_", "串");
        } else if (cell.equals("plan_fee")) {
            detail_old = map.get(ConstantEnum.TOTAL_FEE.name).get(1).toString() + "元" + map.get("multiple").get(1).toString() + "倍";
            detail_new = detail.get(cellEnum);
        } else {
            detail_old = trueDetail.get(cell).toString();
            detail_new = detail.get(cellEnum);
            checkData(detail_new, detail_old, cellEnum.name);
        }
        list.add(0, detail_new);
        list.add(1, detail_old);

        map.put(cell, list);
    }

    public void getData(String cell, String cell2, ConstantEnum cellEnum, Map<String, String> detail, Map<String, Object> trueDetail) {
        String detail_old;
        String detail_new;
        List<Object> list = new ArrayList<>();

        String user_id = trueDetail.get(cell).toString();
        detail_old = TestModel.getUserName(1, user_id).get(cell2).toString();
        detail_new = detail.get(cellEnum).trim();
        checkData(detail_new, detail_old, cellEnum.name);

        list.add(0, detail_new);
        list.add(1, detail_old);

        map.put(cell, list);
    }

    public static void putSuperLottoData(WebElement element) {

        List<String> list = MyStringUtils.transformSplit(element.getText().replace("注", "注,").trim(), ",", 2);
        superLottoMap.put("gameSelect", list);
    }


    public static void putSuperLottoData(String key) {
        switch (key) {
            case "redBall":
                ballMap.put(key, redNumList);
                break;
            case "buleBall":
                ballMap.put(key, buleNumList);
                break;
        }


    }


    public void checkData(String item, String item2, String title) {

        if (item2 == null || item == null) {
            logger.info("无" + title);
        } else {
            if (item2.equals("USER_COPY") || item2.equals("USER_CREATE")) {
                if (item2.equals("USER_CREATE")) {
                    if (item.equals("代购")) {
                        logger.info(title + "为代购 正确");
                    } else {
                        logger.info(title + "为代购 错误");

                    }
                } else if (item2.equals("USER_COPY")) {
                    if (item.equals("复制")) {
                        logger.info(title + "为复制 正确");
                    } else {
                        logger.info(title + "为复制 错误");

                    }
                }

            } else {

                if (item2.equals(item)) {
                    logger.info(title + " 正确");
                } else {
                    logger.info(title + " 错误");
                }

            }
        }
    }
}
