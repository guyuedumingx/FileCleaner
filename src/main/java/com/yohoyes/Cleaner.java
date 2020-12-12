package com.yohoyes;

import com.yohoyes.utils.IOUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Cleaner {

    public static void main(String[] args) {
        ArrayList<File> files = IOUtil.getFiles();
        Iterator<File> iterator = files.iterator();
        while (iterator.hasNext()) {
            IOUtil.move(iterator.next());
        }
    }
}
