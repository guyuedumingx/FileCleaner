package com.yohoyes.utils;

import java.io.File;

/**
 * 处理文件名
 * @author yohoyes
 */
public class NameUtil {

    public static String getFileType(File file) {
        String name = file.getName();
        String[] split = name.split("\\.");
        return split[split.length-1];
    }
}
