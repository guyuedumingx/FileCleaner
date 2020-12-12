package com.yohoyes.utils;


import java.io.*;
import java.util.ArrayList;

/**
 * @author yohoyes
 */
public class IOUtil {

    private static String from = null;
    private static String to = null;

    static {
        Settings settings = Settings.getSettings();
        from = settings.getFromPath();
        to = settings.getToPath();
    }

    public static ArrayList<File> getFiles() {
        File dir = new File(from);
        ArrayList<File> list = new ArrayList<>();
        if(dir.isDirectory()) {
            for(File f : dir.listFiles()) {
                if(!f.isDirectory()) {
                    list.add(f);
                }
            }
        } else {
            throw new RuntimeException("Wrong path : " + from);
        }
        return list;
    }

    public static void buildDirectory(String dirName) {
        if(dirName==null){
            return;
        }
        File dir = new File(to+"/"+dirName);
        if(dir.exists()){
            if(dir.isDirectory()){
                return;
            }
        }
        boolean mkdir = dir.mkdir();
    }

    public static boolean isDirExists(String dirName) {
        File dir = new File(to+"/"+dirName);
        if(dir.exists()&&dir.isDirectory()){
            return true;
        }
        return false;
    }

    public static void move(File file) {
        String fileType = NameUtil.getFileType(file);
        String dirName = DirectoryType.recognitionType(fileType);
        buildDirectory(dirName);
        tryMove(file, dirName);
    }

    private static void tryMove(File file, String dirName) {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(file));
            OutputStream out = new FileOutputStream(to+"/"+dirName+"/"+file.getName());

            byte[] b = new byte[1024];
            int length = -1;
            while((length = in.read(b))!=-1) {
                out.write(b, 0, length);
            }
            in.close();
            out.close();
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
