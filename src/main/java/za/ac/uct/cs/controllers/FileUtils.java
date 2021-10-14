package za.ac.uct.cs.controllers;

import java.io.File;
import java.io.InputStream;

/**
 * Static class with methods for handling Files.
 * @author Chiadika Emeruem
 * @author Steve Wang
 */
public class FileUtils {
    /**
     * This method loads files from the resources directory of a project to an 
     * InputStream.
     * @param rel_path  relative path to the file from the resources directory.
     * @return  an InputStream of the file's contents.
     */
    public static InputStream getFileFromResourcePackage(String rel_path){
        FileUtils util = new FileUtils();
        InputStream xml_file = util.getClass().getClassLoader().getResourceAsStream(rel_path);
        return xml_file;
    }
    /**
     * This method gets the filename from a relative or absolute file path.
     * @param filepath  path to the file.
     * @return  the name of the file at the provided file path.
     */
    public static String getFilename(String filepath){
        if (filepath == null) { return ""; }
        File the_file = new File(filepath);
        return the_file.getName();
    }
}
