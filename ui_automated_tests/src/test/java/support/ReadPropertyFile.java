package support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {



    public static String getResource(String property){

    Properties prop=new Properties();
    FileInputStream ip;
    String res = null;

    {
        try {
            ip = new FileInputStream("src\\test\\java\\support\\config.properties");
            prop.load(ip);
            res = prop.getProperty(property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return res;
}
}
