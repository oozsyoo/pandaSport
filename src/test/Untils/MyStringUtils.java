package test.Untils;

import test.datamodel.TestModel;


import java.util.*;

/**
 * Created by zsy on 2017/7/7.
 */
public class MyStringUtils{
    public static List<String> transformSplit(String str, String replaceStr, int part) {
        String[] strings = str.split(replaceStr, part);
        List<String> list = Arrays.asList(strings);

        return list;
    }

    public static String randomString() {
        Random random = new Random();
        random.nextInt(62);

//    //大写字母
//    char c = (char) (65 + random.nextInt(26));
////       小写字母
//    char a = (char) (97 + random.nextInt(26));
////        数字
//    char b = (char) (48 + random.nextInt(10));
        String sum = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String s = "tester";
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        for (int i = 0; i < 5; i++) {
            sb.append(sum.charAt(random.nextInt(62)));
        }


        return sb.toString();
    }

    public static String createNewUser() {
        String userName;
        do {
            userName =randomString();
        } while (!TestModel.checkUserName(userName, 0));


        return userName;
    }
public String randomNum(){
Random random=new Random();
    int num=random.nextInt(2);
    StringBuilder result = new StringBuilder();
    switch (num){
        case 0:
            result.append("spf");
        break;
        case 1:
            result.append("spf");
        break;
        case 2:
            result.append("spf");
        break;
    }
    return  result.toString();
}



    public  static String transformSinglePass(String playWay) {
        if (playWay.equals(ConstantEnum.SINGLE_WAY.name)) {
            playWay = ConstantEnum.M_1_N_1.name;
        }
        return playWay;
    }
}
