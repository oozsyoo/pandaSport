package test.Untils;



/**
 * Created by Administrator on 2018/1/9.
 */

public  class Test1 {
    public static void main(String[] args) {
       String t= Utils.readAPK("d:\\2.apk").get("packageName").toString();
        System.out.print(t);
    }

    }

