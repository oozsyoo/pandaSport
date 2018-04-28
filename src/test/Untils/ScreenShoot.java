package test.Untils;

import com.qa.framework.config.PropConfig;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static jxl.biff.FormatRecord.logger;

/**
 * Created by Administrator on 2018/4/25.
 */
public class ScreenShoot {
    /**
     * The constant time.
     */
    public static String time = new SimpleDateFormat("MM-dd-HH-mm-ss").format(new Date());
    /**
     * The constant dir.
     */
    public static String dir = "screenshots";
    private WebDriver driver;

    public static void screenShot(AndroidDriver driver, String sFilePath) {
        File file = new File(sFilePath);
        // 如果截图存在先删除
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 截图
        File newFile = driver.getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(newFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String captureAction(WebDriver driver, String fileName) {
        String t = new SimpleDateFormat("MM-dd-HH-mm-ss").format(new Date());
        String allActions = dir + File.separator + "CheckImage" + File.separator + time;
        String screenShotPath = "";
        File f = new File(allActions);
        if (f.exists() && f.isDirectory()) {
            screenShotPath = allActions + File.separator + t + "-" + fileName + ".jpg";
            try {
                File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File(screenShotPath));
            } catch (Exception e) {
                logger.error("captureAction exception:" + e.toString());
            }
            return screenShotPath;
        }
        return screenShotPath;
    }

    public static void contrastImage(String modleName, WebDriver driver, WebElement element) {
//        拼接截屏图片存放地址
        String checkImageUrl = "screenshots" + File.separator + "CheckImage" + File.separator + PropConfig.getAppBin() + File.separator + modleName + ".jpg";
        String testImageUrl = "screenshots" + File.separator + "TestImage" + File.separator + PropConfig.getAppBin() + File.separator + modleName + ".jpg";

//        截屏并保存到相应位置
        ScreenShoot.screenShot((AndroidDriver) driver, checkImageUrl);
//        截取相应图标
        cutBufferedImage(new File(checkImageUrl), element, checkImageUrl);
//        将两张图片缩放至相同大小
//        ImageUtils.adjustImage(checkImageUrl, testImageUrl);
        //对比两张图片
        float percent = CheckImage.checkImage(checkImageUrl, testImageUrl);

        if (percent <= 80) {
            logger.info("相似度不足80%，请核对图片:" + modleName + ".jpg");
        } else {
            logger.info("图标正确：" + modleName + ".jpg");
        }
    }



    /**
     * BufferedImage图片剪裁
     *
     * @param imageUrl - 被剪裁的BufferedImage的文件地址
     * @return 剪裁得到的BufferedImage
     */
    public static BufferedImage cutBufferedImage(File imageFile, WebElement element, String imageUrl) {
        InputStream is = null;
        try {
            is = new FileInputStream(imageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int height = element.getSize().getHeight();
        int width = element.getSize().getWidth();
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        BufferedImage cutedImage = null;


        try {
            BufferedImage srcBfImg = ImageIO.read(is);

            CropImageFilter cropFilter = new CropImageFilter(x, y, width, height);
            Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(srcBfImg.getSource(), cropFilter));
            cutedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = cutedImage.getGraphics();
            g.drawImage(img, 0, 0, null);
            g.dispose();
            ImageIO.write(cutedImage, "jpg", new File(imageUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cutedImage;

    }

}

