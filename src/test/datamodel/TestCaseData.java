package test.datamodel;

import com.qa.framework.config.PropConfig;
import org.testng.annotations.DataProvider;
import test.Untils.ConstantEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCaseData {
    private static final List<List<String>> ways = new ArrayList<List<String>>();


    private static List<List<String>> putWayDate() {
        List<String> _1_X_N = new ArrayList<String>();
        _1_X_N.add(0, "1_1");
        ways.add(0, _1_X_N);
        List<String> _2_X_N = new ArrayList<String>();
        _2_X_N.add(0, "2_1");
        ways.add(1, _2_X_N);
        List<String> _3_X_N = new ArrayList<String>();
        _3_X_N.add(0, "3_1");
        _3_X_N.add(1, "3_3");
        _3_X_N.add(2, "3_4");
        ways.add(2, _3_X_N);
        List<String> _4_X_N = new ArrayList<String>();
        _4_X_N.add(0, "4_1");
        _4_X_N.add(1, "4_4");
        _4_X_N.add(2, "4_5");
        _4_X_N.add(3, "4_6");
        _4_X_N.add(4, "4_11");
        ways.add(3, _4_X_N);
        List<String> _5_X_N = new ArrayList<String>();
        _5_X_N.add(0, "5_1");
        _5_X_N.add(1, "5_5");
        _5_X_N.add(2, "5_6");
        _5_X_N.add(3, "5_10");
        _5_X_N.add(4, "5_20");
        _5_X_N.add(5, "5_26");
        ways.add(4, _5_X_N);
        List<String> _6_X_N = new ArrayList<String>();
        _6_X_N.add(0, "6_1");
        _6_X_N.add(1, "6_6");
        _6_X_N.add(2, "6_6");
        _6_X_N.add(3, "6_7");
        _6_X_N.add(4, "6_15");
        _6_X_N.add(5, "6_20");
        _6_X_N.add(6, "6_22");
        _6_X_N.add(7, "6_35");
        _6_X_N.add(8, "6_42");
        _6_X_N.add(9, "6_50");
        _6_X_N.add(10, "6_57");
        ways.add(5, _6_X_N);
        List<String> _7_X_N = new ArrayList<String>();
        _7_X_N.add(0, "7_1");
        _7_X_N.add(1, "7_7");
        _7_X_N.add(2, "7_8");
        _7_X_N.add(3, "7_21");
        _7_X_N.add(4, "7_35");
        _7_X_N.add(5, "7_120");
        ways.add(6, _7_X_N);
        List<String> _8_X_N = new ArrayList<String>();
        _8_X_N.add(0, "8_1");
        _8_X_N.add(1, "8_8");
        _8_X_N.add(2, "8_9");
        _8_X_N.add(3, "8_28");
        _8_X_N.add(4, "8_56");
        _8_X_N.add(5, "8_70");
        _8_X_N.add(6, "8_247");
        ways.add(7, _8_X_N);
        return ways;
    }


    public static List<String> getWays(int filed) {
        List<String> way = new ArrayList<>();
        for (int i = 0; i < filed; i++) {
            way.addAll(putWayDate().get(i));
        }

        return way;
    }


    @DataProvider(name = "login")
    public static Object[][] login() {
        String user;
        String password;
        String appBin = PropConfig.getAppBin();
        if (appBin.contains("com")) {
            user = "15355090684";
            password = "1234567";
        } else {
//            Map<String, Object> map = TestModel.getUser(1);
//            user = map.get("cell").toString();
            user = "15355090684";
            password = "123456";
        }

        return new Object[][]{
                {user, password}
        };
    }

    @DataProvider(name = "reg")
    public static Object[][] reg() {

        Map<String, Object> user = TestModel.getRegUser();
        String call = user.get("cell1").toString();
        String password = "123456";
        return new Object[][]{
                {call, password}
        };

    }

    @DataProvider(name = "checkBalance")
    public static Object[][] checkBalance() {
        Map<String, Object> map = TestModel.getMoney(1);
        String balance = map.get("balance").toString();
        String freeze_amount = map.get("freeze_amount").toString();
        return new Object[][]{
                {balance, freeze_amount}
        };
    }

    @DataProvider(name = "PlayWays")
    public static Object[][] PlayWays() {
        int field = 10;
        String playWay = "更多";
        String multiples = "10";
        return new Object[][]{
                {field, playWay, ConstantEnum.PUBLIC.name, multiples}
        };
    }

    @DataProvider(name = "PlayWays1")
    public static Object[][] PlayWays1() {
        List<String> playWay = new ArrayList<>();
        List<String> playWays = new ArrayList<>();
        playWay.add("2串1");
//        playWay.add("3串1");
//        playWay.add("3串3");
//        playWays.add("胜平负,比分");
//        playWays.add("胜平负,比分,比分");
        playWays.add("让分胜负,大小分");
        String version = "1.0.7";
        String multiples = "2";
        return new Object[][]{
                {playWay, playWays, ConstantEnum.PUBLIC, multiples, version}
        };
    }



    @DataProvider(name = "OnLineTest01")
    public static Object[][] OnLineTest01() {
        List<String> playWay = new ArrayList<>();
        List<String> playWays = new ArrayList<>();
        playWay.add("2串1");
        playWays.add("让分胜负,大小分");
        String version = "1.0.7";
        String multiples = "3";
        return new Object[][]{
                {playWay, playWays, ConstantEnum.PUBLIC, multiples, version}
        };
    }

    @DataProvider(name = "OnLineTest02")
    public static Object[][] OnLineTest02() {
        List<String> playWay = new ArrayList<>();
        List<String> playWays = new ArrayList<>();
        playWay.add("3串1");
        playWays.add("让分胜负,大小分,胜负");
        String version = "1.0.7";
        String multiples = "1";
        return new Object[][]{
                {playWay, playWays, ConstantEnum.PUBLIC, multiples, version}
        };
    }

    @DataProvider(name = "OnLineTest03")
    public static Object[][] OnLineTest03() {
        List<String> playWay = new ArrayList<>();
        List<String> playWays = new ArrayList<>();
        playWay.add("4串1");
        playWays.add("让分胜负,大小分,胜负,客胜");
        String version = "1.0.7";
        String multiples = "1";
        return new Object[][]{
                {playWay, playWays, ConstantEnum.PUBLIC, multiples, version}
        };
    }
    @DataProvider(name = "OnLineTest20")
    public static Object[][] OnLineTest20() {
        List<String> playWay = new ArrayList<>();
        List<String> playWays = new ArrayList<>();
        playWay.add("2串1");
        playWays.add("让分胜平负,比分");
        String version = "1.0.7";
        String multiples = "1";
        return new Object[][]{
                {playWay, playWays, ConstantEnum.PUBLIC, multiples, version}
        };
    }
    @DataProvider(name = "OnLineTest21")
    public static Object[][] OnLineTest21() {
        List<String> playWay = new ArrayList<>();
        List<String> playWays = new ArrayList<>();
        playWay.add("3串1");
        playWays.add("让分胜平负,胜平负，比分");
        String version = "1.0.7";
        String multiples = "1";
        return new Object[][]{
                {playWay, playWays, ConstantEnum.PUBLIC, multiples, version}
        };
    }
    @DataProvider(name = "OnLineTest04")
    public static Object[][] OnLineTest04() {
        List<String> playWay = new ArrayList<>();
        List<String> playWays = new ArrayList<>();
        playWay.add("5串1");
        playWays.add("让分胜负,大小分,胜负,客胜,主胜");
        String version = "1.0.7";
        String multiples = "1";
        return new Object[][]{
                {playWay, playWays, ConstantEnum.PUBLIC, multiples, version}
        };
    }

    @DataProvider(name = "OnLineTest31")
    public static Object[][] OnLineTest31() {
        int redBall = 5;
        int buleBall = 2;
        String multiples = "1";
        String version = "1.0.7";
        return new Object[][]{
                {redBall, buleBall, ConstantEnum.SUPERLOTTO_NORMAL, multiples, ConstantEnum.PUBLIC,version}
        };
    }


    @DataProvider(name = "superLotto")
    public static Object[][] SuperLotto() {
        int redBall = 5;
        int buleBall = 2;
        String multiples = "2";
        String version = "1.0.7";

        return new Object[][]{
                {redBall, buleBall, ConstantEnum.SUPERLOTTO_NORMAL, multiples, ConstantEnum.PUBLIC,version}
        };
    }

}
