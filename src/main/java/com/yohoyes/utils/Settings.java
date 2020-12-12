package com.yohoyes.utils;

import java.io.File;

/**
 * some settings
 * @author yohoyes
 */
public class Settings {

    private String fromPath = null;
    private String toPath = null ;
    private static Settings settings = new Settings();

    private Settings(){
        File f = new File("");
        String absolutePath = f.getAbsolutePath();
        fromPath = absolutePath;
        toPath = absolutePath;
    }

    public static Settings getSettings() {
        return settings;
    }

    public String getFromPath() {
        return fromPath;
    }

    public void setFromPath(String fromPath) {
        this.fromPath = fromPath;
    }

    public String getToPath() {
        return toPath;
    }

    public void setToPath(String toPath) {
        this.toPath = toPath;
    }
}
