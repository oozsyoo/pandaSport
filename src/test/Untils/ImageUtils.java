package test.Untils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        int x=element.getLocation().getX();
        int y=element.getLocation().getY();
        int width=element.getSize().width;
        int height=element.getSize().height;
        Robot rb; // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
        rb = new Robot();
        Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包
        Dimension di = tk.getScreenSize(); // 屏幕尺寸规格
//            System.out.println(di.width);
//            System.out.println(di.height);
        Rectangle rec = new Rectangle(0, 0, di.width, di.height);
        BufferedImage bi = rb.createScreenCapture(rec);
        int pixelColor = bi.getRGB(x+width/2, y+height/2);

        return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。
    }

    public List<String> getRandomBalls(WebDriver driver,WebElement redBall, WebElement blueBall, int stepX, int stepY) {
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




    public List<String > getRandomBallNumbers(WebDriver driver, WebElement firstRed,WebElement fristB,List<String> list) {

        List<String> list1 = getRandomBalls(driver,firstRed, fristB, 37, 37);
        for (int k = 0; k < list1.size(); k++) {
            String rbg = list1.get(k);
            if (rbg.equals("(246,63,63)")) {

                list.add(String.valueOf(k + 1));
            } else if (rbg.equals("(1,139,246)")) {
                list.add(String.valueOf(k - 34));
            }
        }

        return  list1;
    }

}
