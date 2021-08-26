package za.ac.uct.cs.controllers;

import java.io.File;
import java.io.InputStream;

public class FileUtils {
    public static InputStream getFileFromResourcePackage(String rel_path){
        FileUtils util = new FileUtils();
        InputStream xml_file = util.getClass().getClassLoader().getResourceAsStream(rel_path);
        return xml_file;
    }
    public static String getFilename(String filepath){
        if (filepath == null) { return ""; }
        File the_file = new File(filepath);
        return the_file.getName();
    }
}
