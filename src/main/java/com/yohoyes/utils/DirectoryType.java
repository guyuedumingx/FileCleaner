package com.yohoyes.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author yohoyes
 */
public class DirectoryType {
    private static String pictureDir = "picture";
    private static String documentDir = "document";
    private static String compassDir = "compass";
    private static String videoDir = "video";
    private static HashMap<String,String> nameList = new HashMap<>();

    static {
        loadTypes("document.txt", documentDir);
        loadTypes("picture.txt", pictureDir);
        loadTypes("compass.txt", compassDir);
        loadTypes("video.txt", videoDir);
    }

    private static void loadTypes(String fileName, String type) {
        try {
            String picTypes = DirectoryType.class.getClassLoader().getResource(fileName).getFile();
            Scanner in = new Scanner(new File(picTypes));
            while(in.hasNextLine()) {
                nameList.put(in.nextLine(),type);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("配置文件: "+fileName+" 没找到!");
        }
    }


    public static String getPictureDir() {
        return pictureDir;
    }

    public static void setPictureDir(String pictureDir) {
        DirectoryType.pictureDir = pictureDir;
    }

    public static String getDocumentDir() {
        return documentDir;
    }

    public static void setDocumentDir(String documentDir) {
        DirectoryType.documentDir = documentDir;
    }

    public static String getCompassDir() {
        return compassDir;
    }

    public static void setCompassDir(String compassDir) {
        DirectoryType.compassDir = compassDir;
    }

    public static String getVideoDir() {
        return videoDir;
    }

    public static void setVideoDir(String videoDir) {
        DirectoryType.videoDir = videoDir;
    }

    /**
     * 识别文件所属类型
     * @return
     */
    public static String recognitionType(String type) {
        return nameList.get(type);
    }
}
