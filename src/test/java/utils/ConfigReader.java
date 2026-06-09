package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	public ConfigReader() {
		try {
			FileInputStream fil = new FileInputStream("src/test/resources/config/properties/config.properties");
					prop = new Properties();
			prop.load(fil);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public String getProperty(String key) {

        return prop.getProperty(key);
  

	}
}