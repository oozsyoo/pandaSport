package test.Untils;


import com.qa.framework.config.PropConfig;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/9.
 */

public class Test1 {
//    public static void main(String[] args) {
//        String t = "123,ewer,erter";
//        List<String> l = Arrays.asList(t.split(","));
//        System.out.print(l.get(0));
//    }

    /**
     * 按照 宽高 比例压缩
     *

     * @param scale 压缩刻度

     * @return 压缩后图片数据
     * @throws IOException 压缩图片过程中出错
     */
    public static byte[] compress(byte[] srcImgData, double scale) throws IOException {
        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(srcImgData));
        int width = (int) (bi.getWidth() * scale); // 源图宽度
        int height = (int) (bi.getHeight() * scale); // 源图高度

        Image image = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ImageIO.write(tag, "JPEG", bOut);

        return bOut.toByteArray();
    }


    /**
     * 将图片压缩到指定大小以内
     *
     * @param srcImgData 源图片数据
     * @param maxSize    目的图片大小
     * @return 压缩后的图片数据
     */
    public static byte[] compressUnderSize(byte[] srcImgData, long maxSize) {
        double scale = 0.9;
        byte[] imgData = Arrays.copyOf(srcImgData, srcImgData.length);

        if (imgData.length > maxSize) {
            do {
                try {
                    imgData = compress(imgData, scale);

                } catch (IOException e) {
                    throw new IllegalStateException("压缩图片过程中出错，请及时联系管理员！", e);
                }

            } while (imgData.length > maxSize);
        }

        return imgData;
    }


    public static String[][] getPX(String args) {
        int[] rgb = new int[3];

        File file = new File(args);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        String[][] list = new String[width][height];
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = bi.getRGB(i, j);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                list[i][j] = rgb[0] + "," + rgb[1] + "," + rgb[2];

            }
        }
        return list;

    }

    public static void compareImage(String imgPath1, String imgPath2){
        String[] images = {imgPath1, imgPath2};
        if (images.length == 0) {
            System.out.println("Usage >java BMPLoader ImageFile.bmp");
            System.exit(0);
        }

        // 分析图片相似度 begin
        String[][] list1 = getPX(images[0]);
        String[][] list2 = getPX(images[1]);
        int xiangsi = 0;
        int busi = 0;
        int i = 0, j = 0;
        for (String[] strings : list1) {
            if ((i + 1) == list1.length) {
                continue;
            }
            for (int m=0; m<strings.length; m++) {
                try {
                    String[] value1 = list1[i][j].toString().split(",");
                    String[] value2 = list2[i][j].toString().split(",");
                    int k = 0;
                    for (int n=0; n<value2.length; n++) {
                        if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
                            xiangsi++;
                        } else {
                            busi++;
                        }
                    }
                } catch (RuntimeException e) {
                    continue;
                }
                j++;
            }
            i++;
        }

        list1 = getPX(images[1]);
        list2 = getPX(images[0]);
        i = 0;
        j = 0;
        for (String[] strings : list1) {
            if ((i + 1) == list1.length) {
                continue;
            }
            for (int m=0; m<strings.length; m++) {
                try {
                    String[] value1 = list1[i][j].toString().split(",");
                    String[] value2 = list2[i][j].toString().split(",");
                    int k = 0;
                    for (int n=0; n<value2.length; n++) {
                        if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
                            xiangsi++;
                        } else {
                            busi++;
                        }
                    }
                } catch (RuntimeException e) {
                    continue;
                }
                j++;
            }
            i++;
        }
        String baifen = "";
        try {
            baifen = ((Double.parseDouble(xiangsi + "") / Double.parseDouble((busi + xiangsi) + "")) + "");
            baifen = baifen.substring(baifen.indexOf(".") + 1, baifen.indexOf(".") + 3);
        } catch (Exception e) {
            baifen = "0";
        }
        if (baifen.length() <= 0) {
            baifen = "0";
        }
        if(busi == 0){
            baifen="100";
        }

        System.out.println("相似像素数量：" + xiangsi + " 不相似像素数量：" + busi + " 相似率：" + Integer.parseInt(baifen) + "%");

    }

//    public static void main(String[] args) {
//
//        String list[] = new String[]{
//                "ZeDeRelease.com.apk",
//                "HaoYinXiangRelease.com.apk",
//                "JiaGuWenRelease.com.apk",
//                "DongFangHongRelease.com.apk",
//                "LuoShenRelease.com.apk",
//                "HongTongTongRelease.com.apk",
//                "ZhuYuanRelease.com.apk",
//                "XinMaRelease.com.apk",
//                "HongYuRelease.com.apk",
//                "BaiLuXiangRelease.com.apk",
//                "BiShengRelease.com.apk",
//                "JuHuaRelease.com.apk",
//                "JiLiRelease.com.apk",
//                "WanShuiRelease.com.apk",
//                "YueXiRelease.com.apk",
//                "HuaiChengRelease.com.apk",
//                "NingHaiRelease.com.apk",
//                "RuYiRelease.com.apk",
//                "SiFangRelease.com.apk",
//                "HuaShengRelease.com.apk",
//                "SongShuTangRelease.com.apk",
//                "FuManTianRelease.com.apk",
//                "HongFuRelease.com.apk",
//                "FuYingRelease.com.apk",
//                "WangHongRelease.com.apk",
//                "HongXingRelease.com.apk",
//                "HuoShanRelease.com.apk",
//                "LeYingRelease.com.apk",
//                "YueHongRelease.com.apk",
//                "JiangNanRelease.com.apk",
//                "ShangShenRelease.com.apk"
//        };
//        for (int i = 0; i < list.length; i++) {
//
//
//            File f = new File("screenshots" + File.separator + "TestImage" + File.separator + list[i] + File.separator);
//            if (!f.exists()) {
//                f.mkdir();
//            }
//
//        }
//
//
//    }



    public static void main(String[] args) {
        //这是需要获取的文件夹路径
        String path = "res\\";
//        getFile(path,0);
    }
//
//    /*
//     * 函数名：getFile
//     * 作用：使用递归，输出指定文件夹内的所有文件
//     * 参数：path：文件夹路径   deep：表示文件的层次深度，控制前置空格的个数
//     * 前置空格缩进，显示文件层次结构
//     */
//    private static void getFile(String path,int deep){
//        // 获得指定文件对象
//        File file = new File(path);
//        // 获得该文件夹内的所有文件
//        File[] array = file.listFiles();
//
//        for(int i=0;i<array.length;i++)
//        {
//            if(array[i].isFile())//如果是文件
//            {
//                for (int j = 0; j < deep; j++)//输出前置空格
//                    System.out.print(" ");
//                // 只输出文件名字
//                System.out.println( array[i].getName());
//                // 输出当前文件的完整路径
//                // System.out.println("#####" + array[i]);
//                // 同样输出当前文件的完整路径   大家可以去掉注释 测试一下
//                // System.out.println(array[i].getPath());
//            }
//            else if(array[i].isDirectory())//如果是文件夹
//            {
//                for (int j = 0; j < deep; j++)//输出前置空格
//                    System.out.print(" ");
//
//                System.out.println( array[i].getName());
//                //System.out.println(array[i].getPath());
//                //文件夹需要调用递归 ，深度+1
//                getFile(array[i].getPath(),deep+1);
//            }
//        }
//    }
}

