package test.Untils;

import test.page.AbstractPage;

import java.io.File;

/**
 * Created by Administrator on 2018/2/1.
 */
public class MonkeyUtils extends AbstractPage {



    /**
     * 启动应用命令(前提条件是打开的Activity 需要属性 android:exported 被设定为true)
     *
     * @param pkgName      应用包名
     * @param activityName 要启动的Activity类名
     * @return 添加的命令
     */
    public String launchActivity(String pkgName, String activityName) {
        return "LaunchActivity(" + pkgName + ", " + activityName + ");";
    }

    /**
     * 按下键盘上指定键的命令
     *
     * @param keyCode 键对应的code值 ，比如回车键keyCode=66
     * @return 添加的命令
     */
    public String dispatchPress(int keyCode) {
        return "DispatchPress(" + keyCode + ")";
    }

    /**
     * 开启软键盘命令
     *
     * @param open 表示是否打开软键盘
     * @return 添加的命令
     */
    public String dispatchFlip(boolean open) {
        return "DispatchFlip(" + open + ")";
    }

    /**
     * 输入字符串事件命令
     *
     * @param text 参数text不加引号，指输入字符串text到指定的输入框中
     * @return 添加的命令
     */
    public String dispatchString(String text) {
        return "DispatchString(" + text + ")";
    }

    /**
     * 让脚本中断执行一段时间
     *
     * @param waittime 等待时间（单位：毫秒）
     * @return 添加的命令
     */
    public String userWait(int waittime) {
        return "UserWait()";
    }

    /**
     * @param x    点击的横坐标
     * @param y    点击的纵坐标
     * @param time 点击的时间
     * @return 添加的命令
     */
    public String tap(int x, int y, int time) {
        return "Tap(" + x + "," + y + "." + time + ")";
    }


    public void monkeyTest() {
        File file = IoUtils.createTxtFile("d://1212.txt");
        String stringBuffer = ("type=raw events" +
                "\r\ncount=4" +
                "\r\nspeed=2" +
                "\r\nstart data >>    \r\n") +
//                launchActivity("com.huored.android.DongFangHong", "com.huored.android.lt.WelcomeActivity") +
                tap(360, 200, 1000) + "\r\n" +dispatchPress(4);
//        logger.info(stringBuffer);
//        new CmdUtils().runCmd("adb remount");

        IoUtils.writeFile(file, stringBuffer);
        CmdUtils.runMonkeyCmd("adb push d:\\1212.txt system/  & adb shell monkey -f system/1212.txt 1");
        CmdUtils.runMonkeyCmd();
//        new CmdUtils().runCmd("adb shell svc wifi disable");
        getSleeper().sleep(10000);
//        CmdUtils.runMonkeyCmd("adb remount");

//
//        logger.info("start3");
//        CmdUtils.runMonkeyCmd("adb shell monkey -f system/1212.txt 10");
//        logger.info("end");
//        getSleeper().sleep(10000);
//        try {
//            Runtime.getRuntime().exec("adb remount");
//            logger.info("start1");
//            Runtime.getRuntime().exec("adb push " + "d:\\1212.txt system/");
//            logger.info("start2");
//            Runtime.getRuntime().exec("adb shell monkey -f system/1212.txt 1");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
