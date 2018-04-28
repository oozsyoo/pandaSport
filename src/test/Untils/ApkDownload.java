package test.Untils;

import com.qa.framework.common.Sleeper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by zhouyi on 2017/11/15.
 */
public class ApkDownload {

    public static void main(String[] args) {
        Sleeper sleeper=new Sleeper();
        String list[] = new String[]{
                "ZeDeReleaseOld.apk",
                "HaoYinXiangReleaseOld.apk",
                "JiaGuWenReleaseOld.apk",
                "DongFangHongReleaseOld.apk",
                "LuoShenReleaseOld.apk",
                "HongTongTongReleaseOld.apk",
                "ZhuYuanReleaseOld.apk",
                "XinMaReleaseOld.apk",
                "HongYuReleaseOld.apk",
                "BaiLuXiangReleaseOld.apk",
                "BiShengReleaseOld.apk",
                "JuHuaReleaseOld.apk",
                "JiLiReleaseOld.apk",
                "WanShuiReleaseOld.apk",
                "YueXiReleaseOld.apk",
                "HuaiChengReleaseOld.apk",
                "NingHaiReleaseOld.apk",
                "RuYiReleaseOld.apk",
                "SiFangReleaseOld.apk",
                "HuaShengReleaseOld.apk",
                "SongShuTangReleaseOld.apk",
                "FuManTianReleaseOld.apk",
                "HongFuReleaseOld.apk",
                "FuYingReleaseOld.apk",
                "WangHongReleaseOld.apk",
                "HongXingReleaseOld.apk",
                "HuoShanReleaseOld.apk",
                "LeYingReleaseOld.apk",
                "YueHongReleaseOld.apk",
                "JiangNanReleaseOld.apk",
                "ShangShenReleaseOld.apk"
        };

       /* String list[] = new String[]{

                "HongXingReleaseOld.apk",
                "HuoShanReleaseOld.apk",
                "JiangNanReleaseOld.apk",
                "LeYingReleaseOld.apk",
                "WangHongReleaseOld.apk",
                "YueHongReleaseOld.apk"


        };*/


        /*String list[] = new String[]{

                "RuYiReleaseOld.apk"

        };*/


        for (int i = 0; i < list.length; i++) {
            try {
                String pathUrl = "http://10.4.230.110:8080/pandasport/" + list[i];

                // 建立连接
                URL url = new URL(pathUrl);
                HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();


                // //设置连接属性
                httpConn.setDoOutput(true);// 使用 URL 连接进行输出
                httpConn.setDoInput(true);// 使用 URL 连接进行输入
                httpConn.setUseCaches(false);// 忽略缓存
                httpConn.setRequestMethod("POST");// 设置URL请求方法
                String requestString = "客服端要以以流方式发送到服务端的数据...";
                System.out.println(requestString);


                // 设置请求属性
                // 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
                byte[] requestStringBytes = requestString.getBytes(Charset.forName("utf-8"));
                httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);
                httpConn.setRequestProperty("Content-Type", "application/octet-stream");
                httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
                httpConn.setRequestProperty("Charset", "UTF-8");
//

                // 建立输出流，并写入数据
                OutputStream outputStream = httpConn.getOutputStream();
                outputStream.write(requestStringBytes);
                outputStream.close();
                // 获得响应状态
                int responseCode = httpConn.getResponseCode();

                if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
                    // 当正确响应时处理数据
                    InputStream inputStream = httpConn.getInputStream();
                    FileOutputStream fos = new FileOutputStream(new File("res\\" + list[i].replace("ReleaseOld.apk","Release.com.apk")));

                    byte[] b = new byte[1024];
                    int n = 0;
                    while ((n = inputStream.read(b)) != -1) {
                        fos.write(b, 0, n);
                    }

                    inputStream.close();
                    fos.close();


                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

//        ZipUtil.pack(new File("D:\\tomcat\\apache-tomcat-8.5.5-windows-x64\\apache-tomcat-8.5.5\\webapps\\ROOT\\pandasport\\packages"), new File("D:\\tomcat\\apache-tomcat-8.5.5-windows-x64\\apache-tomcat-8.5.5\\webapps\\ROOT\\pandasport\\packages.zip"));


    }

}

