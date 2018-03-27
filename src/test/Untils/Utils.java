package test.Untils;

import com.qa.framework.common.Sleeper;
import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import com.qa.framework.pagefactory.WithTimeout;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by zsy on 2017/5/22.
 */
@Page
public class Utils {
    private final Logger logger = Logger.getLogger(this.getClass());
    private Sleeper sleeper = new Sleeper();

    @AndroidFindBy(xpath = "//*[@clickable='true']")
    List<WebElement> clickList;
    @WithTimeout(2000)
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/backIv")
    WebElement backIv;
    @WithTimeout(2000)
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/cancelBtn")
    WebElement cancelBtn;
    @AndroidFindBy(id = "//android.widget.TextView[@resource-id=\"android:id/message\" and @text=\"加载数据中...\"")
    WebElement loading;
    List<WebElement> lists = new ArrayList<>();


    private boolean checkNull = false;
    boolean haveBackIv = false;
    private Random random = new Random();
    private List<Integer> numList = new ArrayList<>();
    private List<Integer> numlist2 = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public void setNumlist2(List<Integer> numlist2) {
        this.numlist2 = numlist2;
    }

    public static String getdate() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        String dayStr = String.valueOf(day);
        String monthStr = String.valueOf(month);
        if (day < 10) {
            dayStr = "0" + day;
        }
        if (month < 10) {
            monthStr = "0" + month;
        }
        StringBuffer date = new StringBuffer();
        date.append(year);
        date.append(monthStr);
        date.append(dayStr);
        return date.toString();
    }

    public List<Integer> getNumlist2() {
        return numlist2;
    }

    public static String takeScreenShot(WebDriver driver, String fileName) {

        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String t = "D:\\A\\" + fileName + ".jpg";
        try {
            FileUtils.copyFile(screenShotFile, new File(t));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 获取不重复的随机数
     *
     * @param numList
     * @return 不重复的随机数
     */
    public int getNotRepeatNum(List<Integer> numList) {
        int r2 = random.nextInt(numList.size());
        while (!checkNum(r2)) {
            r2 = random.nextInt(numList.size());
        }
        return r2;
    }

    boolean ElementExist(String id, WebDriver driver) {
        try {
            driver.findElement(By.id(id));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            return false;
        }
    }

    public int getNotRepeatNum(Integer bound) {
        Random random = new Random();
        int num = random.nextInt(bound);
        if (numlist2 == null) {
            numlist2.add(num);
        } else {
            for (int i = 0; i < numlist2.size(); i++) {
                while (numlist2.get(i).equals(num)) {
                    num = random.nextInt(bound);
                }
                numlist2.add(num);
            }
        }


        return num;


    }


    public int getNotRepeatNum(boolean R_B, Integer bound) {
        if (R_B) {
            int r2 = random.nextInt(bound);
            while (!checkNum(r2)) {
                r2 = random.nextInt(bound);
            }
            return r2;
        } else {
            int r2 = 35 + random.nextInt(bound);
            while (!checkNum(r2)) {
                r2 = 35 + random.nextInt(bound);
            }
            return r2;
        }

    }

    public static WebElement findElementByXpath(WebElement element, String xpath) {
        return element.findElement(By.xpath(xpath));
    }

    public static List<WebElement> findElementsByXpath(WebElement element, String xpath) {
        return element.findElements(By.xpath(xpath));
    }

    public static WebElement findElementByClassName(WebElement element, String className) {
        return element.findElement(By.className(className));
    }

    public static List<WebElement> findElementsByClassName(WebElement element, String className) {
        return element.findElements(By.className(className));
    }

    public static WebElement findElementById(WebElement element, String id) {
        return element.findElement(By.id(id));
    }

    public static List<WebElement> findElementsById(WebElement element, String id) {
        return element.findElements(By.id(id));
        
    }


    /**
     * @param webElementMap
     * @return
     */
    public List<Integer> getKeyValue(Map<Integer, WebElement> webElementMap) {

        Set<Integer> getKeyValue = webElementMap.keySet();
        Iterator<Integer> it = getKeyValue.iterator();
        List<Integer> keyList = new ArrayList<>();
        while (it.hasNext()) {
            int key = it.next();
            keyList.add(key);
        }
        return keyList;
    }

    /**
     * 除去不能点击的选项
     *
     * @param list
     * @return 有效的元素MAP
     */
    public  static  List<WebElement> removeUnableElement(List<WebElement> list) {


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAttribute("enabled").equals("false")) {
                list.remove(i);
            }
        }
        return list;
    }



    public boolean checkIsClicked(List<WebElement> list) {
        boolean clicked = false;

        for (WebElement aList : list) {
            if (aList.getAttribute("checked").equals("true") && aList.getAttribute("enabled").equals("true")) {
                clicked = true;

            }
        }
        return clicked;
    }


    /**
     * 获取方法名
     */
    public void getMethodName() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        logger.info(methodName);


    }

    /**
     * 随机数查重
     *
     * @param r1 随机数
     * @return 是否重复
     */
    private boolean checkNum(int r1) {

        boolean b1 = true;
        for (int i = 0; i < numList.size(); i++) {
            if (r1 == numList.get(i)) {
                b1 = false;
            }
        }
        if (b1) {
            numList.add(r1);
        }

        return b1;
    }


    public void clickTest(WebDriver driver) {
        List<WebElement> list = new ArrayList<>();
        list.addAll(clickList);
        String oldActivity = ((AndroidDriver) driver).currentActivity();
        logger.info(oldActivity);
        int num = 0;
        if (oldActivity.equals(ConstantEnum.MAINACTIVITY_NAME.name)) {
            num = 4;

        } else {
            num = 0;
        }
        for (int i = 0; i < list.size() - num; i++) {

            logger.info(list.size());
            logger.info(i);

            check(i, list.subList(0, list.size() - num + 1), oldActivity, driver);
//            check(i,list,oldActivity);
        }

    }

    public void checkCancelExit() {
        if (elementCheckNull(cancelBtn)) {

            sleeper.sleep(2000);
            cancelBtn.click();
        }
    }


    public boolean getLocation(WebElement element) {
        try {
            element.isDisplayed();
            checkNull = true;

        } catch (Exception e) {

        }
        return checkNull;
    }


    public void check(int i, List<WebElement> list, String oldActivity, WebDriver driver) {

        WebElement webElement = list.get(i);
        logger.info(list.size());
        if (!webElement.getLocation().equals(elementCheckNulls(backIv))) {

            if (elementCheckNull(cancelBtn)) {

                try {
                    sleeper.sleep(2000);
                    cancelBtn.click();
                } catch (Exception e) {
//   logger.info("check():click the element failed");
                    e.printStackTrace();
                }

            } else {

                webElement.click();
                sleeper.sleep(2000);
            }

            String newActivity = ((AndroidDriver) driver).currentActivity();
            logger.info(newActivity);

            if (!newActivity.equals(oldActivity)) {
                ((AndroidDriver) driver).pressKeyCode(4);

            }


            if (elementCheckNull(cancelBtn)) {
                cancelBtn.click();
            }
        }


    }

    public boolean isCheckEnable(WebElement element) {
        boolean flag;
        try {


            flag = element.isSelected();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }


    public boolean elementCheckNull(WebElement elemnt) {
        boolean flag = true;
        try {
            elemnt.getLocation();


        } catch (Exception e) {

            flag = false;


        }
        return flag;
    }

    public Point elementCheckNulls(WebElement elemnt) {
        Point point;
        try {
            point = elemnt.getLocation();


        } catch (Exception e) {

            return point = null;

        }
        return point;
    }

    public void monkey(WebDriver driver) {
        String oldActivity = ((AndroidDriver) driver).currentActivity();
//        CmdUtils.runMonkeyCmd();
        String newActivity = ((AndroidDriver) driver).currentActivity();
        for (int i = 0; i < 1000; i++) {
            checkCancelExit();
            if (oldActivity.equals(newActivity)) {
                break;

            } else {
                ((AndroidDriver) driver).pressKeyCode(4);
                newActivity = ((AndroidDriver) driver).currentActivity();

            }
        }

    }


    public void monkey(WebElement element, WebDriver driver) {
        String oldActivity = ((AndroidDriver) driver).currentActivity();
        CmdUtils.runMonkeyCmd();
        String newActivity = ((AndroidDriver) driver).currentActivity();
        for (int i = 0; i < 1000; i++) {
            checkCancelExit();
            if (oldActivity.equals(newActivity)) {
                if (oldActivity.equals(ConstantEnum.MAINACTIVITY_NAME.name)) {
                    element.click();
                    element.click();
                }
                break;

            } else {
                ((AndroidDriver) driver).pressKeyCode(4);
                newActivity = ((AndroidDriver) driver).currentActivity();

            }
        }

    }

    public boolean num(Integer num) {
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(num)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            list.add(num);
        }
        return flag;
    }


}
