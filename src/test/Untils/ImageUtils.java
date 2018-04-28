package test.Untils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zsy on 2017/7/18.
 */
public class ImageUtils {


    public static String getRGB(WebElement element, WebDriver driver, int stepX, int stepY) {
        String adress = Utils.takeScreenShot(driver, "1");

        String rbg = getPixel(adress, element, stepX, stepY);
        return rbg;
    }

    public static String getPixel(String adress, WebElement element, int stepX, int stepY) {
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();

        String rbg = getImagePixel(adress, x + stepX, y + stepY);

        return rbg;
    }


    /**
     * 读取一张图片某一个坐标点的RGB值
     *
     * @throws Exception
     */
    public static String getImagePixel(String image, int x, int y) {
        int[] rgb = new int[3];
        File file = new File(image);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int pixel = bi.getRGB(x, y); // 下面三行代码将一个数字转换为RGB数字
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);

        String rbg = "(" + rgb[0] + ","
                + rgb[1] + "," + rgb[2] + ")";
        return rbg;
    }

    /**
     * 返回屏幕色彩值
     *
     * @param x
     * @param y
     * @return
     * @throws AWTException
     */
    public int getScreenPixel(int x, int y) throws AWTException { // 函数返回值为颜色的RGB值。
        Robot rb = null; // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
        rb = new Robot();
        Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包
        Dimension di = tk.getScreenSize(); // 屏幕尺寸规格
//            System.out.println(di.width);
//            System.out.println(di.height);
        Rectangle rec = new Rectangle(0, 0, di.width, di.height);
        BufferedImage bi = rb.createScreenCapture(rec);
        int pixelColor = bi.getRGB(x, y);

        return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。
    }


    public static int getElementPixel(WebElement element) throws AWTException { // 函数返回值为颜色的RGB值。
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        int width = element.getSize().width;
        int height = element.getSize().height;
        Robot rb; // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
        rb = new Robot();
        Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包
        Dimension di = tk.getScreenSize(); // 屏幕尺寸规格
//            System.out.println(di.width);
//            System.out.println(di.height);
        Rectangle rec = new Rectangle(0, 0, di.width, di.height);
        BufferedImage bi = rb.createScreenCapture(rec);
        int pixelColor = bi.getRGB(x + (width / 2), y + (height / 4));

        return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。
    }

    public List<String> getRandomBalls(WebDriver driver, WebElement redBall, WebElement blueBall, int stepX, int stepY) {
        List<String> list = new ArrayList<>();
        String adress = Utils.takeScreenShot(driver, "1");
        int startX = redBall.getLocation().getX();
        int startY = redBall.getLocation().getY();
        int x = redBall.getSize().getWidth();
        int y = redBall.getSize().getHeight();

        int startY2 = blueBall.getLocation().getY();

        for (int j = 0; j < 47; j++) {
            if (j < 35) {
                int X = startX + stepX + ((j) % 7) * (x + 23);
                int Y = startY + stepY;
                String rbg = getImagePixel(adress, X, Y);
                list.add(rbg);
                if ((j + 1) % 7 == 0) {
                    startY = startY + y + 16;
                }

            } else {


                int X = startX + stepX + ((j) % 7) * (x + 23);
                int Y = startY2 + stepY;
                String rbg = "x=" + X + ",y=" + Y + "  " + getImagePixel(adress, X, Y);
                list.add(rbg);
                if ((j + 1) % 7 == 0) {
                    startY2 = startY2 + y + 16;
                }
            }

        }
        return list;
    }


    public List<String> getRandomBallNumbers(WebDriver driver, WebElement firstRed, WebElement fristB, List<String> list) {

        List<String> list1 = getRandomBalls(driver, firstRed, fristB, 37, 37);
        for (int k = 0; k < list1.size(); k++) {
            String rbg = list1.get(k);
            if (rbg.equals("(246,63,63)")) {

                list.add(String.valueOf(k + 1));
            } else if (rbg.equals("(1,139,246)")) {
                list.add(String.valueOf(k - 34));
            }
        }

        return list1;
    }


    public static String test(WebDriver driver, WebElement element) {
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        int width = element.getSize().width;
        int height = element.getSize().height;
        String adress = Utils.takeScreenShot(driver, "1");
        String rbg = getImagePixel(adress, x + (width / 2), y + (height / 4));
        return rbg;

//        Color pixel = new Color(0,0,0);
//        Robot robot;
//        Point mousepoint;
//        int R,G,B;
//        MouseInfo mouseinfo = null;
//        try {
//            robot = new Robot();
//
//        mousepoint = mouseinfo.getPointerInfo().getLocation();
//        pixel = robot.getPixelColor(x,y);
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        R = pixel.getRed();
//        G = pixel.getGreen();
//        B = pixel.getBlue();
    }

    /**
     * @param resizeTimes 倍数,比如0.5就是缩小一半,0.98等等double类型
     * @return 返回处理后的图像
     */
    public static  BufferedImage zoomImage(String src, float resizeTimes) {

        BufferedImage result = null;

        try {
            File srcfile = new File(src);
            if (!srcfile.exists()) {
                System.out.println("文件不存在");

            }
            BufferedImage im = ImageIO.read(srcfile);

            /* 原始图像的宽度和高度 */
            int width = im.getWidth();
            int height = im.getHeight();

            /* 调整后的图片的宽度和高度 */
            int toWidth = (int) (width * resizeTimes);
            int toHeight = (int) (height * resizeTimes);

            /* 新生成结果图片 */
            result = new BufferedImage(toWidth, toHeight,
                    BufferedImage.TYPE_INT_RGB);

            result.getGraphics().drawImage(
                    im.getScaledInstance(toWidth, toHeight,
                            java.awt.Image.SCALE_SMOOTH), 0, 0, null);


        } catch (Exception e) {
            System.out.println("创建缩略图发生异常" + e.getMessage());
        }

        return result;

    }

    public static boolean writeHighQuality(BufferedImage im, String fileFullPath) {
        try {
                /*输出到文件流*/
            FileOutputStream newimage = new FileOutputStream(fileFullPath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
                /* 压缩质量 */
            jep.setQuality(1, true);
            encoder.encode(im, jep);
               /*近JPEG编码*/
            newimage.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static Map<String, Integer> getImageSize(String imageUrl) {
        Map<String, Integer> map = new HashedMap();

        File picture = new File(imageUrl);
        BufferedImage sourceImg = null;
        try {
            sourceImg = ImageIO.read(new FileInputStream(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 源图宽度
        assert sourceImg != null;
        int width = sourceImg.getWidth();
        // 源图高度
        int height = sourceImg.getHeight();
        map.put("width", width);
        map.put("height", height);

        return map;
    }

    public static float getRatio(String imageUrl, String imageUrl2) {
        float a = getImageSize(imageUrl).get("width");
        float b = getImageSize(imageUrl2).get("width");
        return a/b;
    }




    public static void adjustImage(String checkImageUrl,String testImageUrl){
        writeHighQuality(zoomImage(checkImageUrl,getRatio(testImageUrl,checkImageUrl)),checkImageUrl);
    }
}
