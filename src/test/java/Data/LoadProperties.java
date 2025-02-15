package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LoadProperties {
    //load the properties file from the folder.

    public static Properties userdata =
            loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");

    private static Properties loadProperties(String path){
        Properties pro = new Properties();
        //stream for reading file.
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred :"+e.getMessage());
        }catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return pro;
    }
}
