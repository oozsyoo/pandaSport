package test.Untils;

/**
 * Created by Administrator on 2018/4/25.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 屏幕上查找指定图片
 *
 * @author Jeby Sun
 * @date 2014-09-13
 * @website http://www.jebysun.com
 */
public class CheckImage {


        public static void main(String[] args)throws Exception{
            float percent = compare(getData("d:/a.jpg"),getData("d:/key.jpg"));
            System.out.println("两张图片的相似度为："+percent+"%");
        }



    public static float checkImage(String image1,String image2){
        float percent = 0;
        try {
            int[] s=getData(image1);
            int[] c=getData(image2);
            percent = compare(s,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return percent;
    }

        public static int[] getData(String name)throws Exception{
            BufferedImage img = ImageIO.read(new File(name));
            BufferedImage slt = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
            slt.getGraphics().drawImage(img,0,0,100,100,null);
            //ImageIO.write(slt,"jpeg",new File("slt.jpg"));
            int[] data = new int[256];
            for(int x = 0;x<slt.getWidth();x++){
                for(int y = 0;y<slt.getHeight();y++){
                    int rgb = slt.getRGB(x,y);
                    Color myColor = new Color(rgb);
                    int r = myColor.getRed();
                    int g = myColor.getGreen();
                    int b = myColor.getBlue();
                    data[(r+g+b)/3]++;
                }
            }
            //data 就是所谓图形学当中的直方图的概念
            return data;
        }
        public static float compare(int[] s, int[] t){
            float result = 0F;
            for(int i = 0;i<256;i++){
                int abs = Math.abs(s[i]-t[i]);
                int max = Math.max(s[i],t[i]);
                result += (1-((float)abs/(max==0?1:max)));
            }
            return (result/256)*100;
        }

}
