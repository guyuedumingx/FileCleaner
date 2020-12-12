package com.yohoyes.utils;

/**
 * some settings
 * @author yohoyes
 */
public class Settings {

    private String fromPath = "/home/harden/Downloads";
    private String toPath = "/home/harden/Downloads" ;
    private static Settings settings = new Settings();

    private Settings(){
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
