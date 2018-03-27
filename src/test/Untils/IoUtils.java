package test.Untils;

import java.io.*;

/**
 * Created by Administrator on 2018/2/1.
 */
public class IoUtils {

    public static File createTxtFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    public static void writeFile(File file ,String writeContent) {
        try {
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(writeContent);
            bw.flush();
            bw.close();
            fw.close();
        }catch (IOException ignored){
            ignored.printStackTrace();
        }
    }
    public static void readFile(File file ) throws  IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        System.out.println(str);
    }

}
