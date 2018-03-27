package test.Untils;


import java.io.*;

/**
 * Created by zsy on 2017/7/4.
 */
class CmdUtils {

    static void runMonkeyCmd(String cmd) {


        try {

            Process process = Runtime.getRuntime().exec(cmd);  //adb shell

            final BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            final BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

            //这里一定要注意错误流的读取，不然很容易阻塞，得不到你想要的结果，

            final BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            new Thread(new Runnable() {

                String line;

                public void run() {

                    System.out.println("listener started");

                    try {

                        while ((line = inputStream.readLine()) != null) {

                            System.out.println(line);

                        }

                    } catch (IOException e) {

                        //e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {

                final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


                public void run() {

                    System.out.println("writer started");

                    String line;

                    try {

                        while ((line = br.readLine()) != null) {

                            outputStream.write(line + "\r\n");

                            outputStream.flush();

                        }

                    } catch (IOException e) {

                        //e.printStackTrace();

                    }

                }

            }).start();


            int i = process.waitFor();

            System.out.println("i=" + i);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }




    public static void runMonkeyCmd() {


        try {

            Process process = Runtime.getRuntime().exec("adb shell monkey -f d:/1212.txt 10");  //adb shell

            final BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            final BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

            //这里一定要注意错误流的读取，不然很容易阻塞，得不到你想要的结果，

            final BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            new Thread(new Runnable() {

                String line;


                public void run() {

                    System.out.println("listener started");

                    try {

                        while ((line = inputStream.readLine()) != null) {

                            System.out.println(line);

                        }

                    } catch (IOException e) {

                        //e.printStackTrace();

                    }

                }

            }).start();

            new Thread(new Runnable() {

                final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


                public void run() {

                    System.out.println("writer started");

                    String line;

                    try {

                        while ((line = br.readLine()) != null) {

                            outputStream.write(line + "\r\n");

                            outputStream.flush();

                        }

                    } catch (IOException e) {

                        //e.printStackTrace();

                    }

                }

            }).start();

            int i = process.waitFor();

            System.out.println("i=" + i);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
