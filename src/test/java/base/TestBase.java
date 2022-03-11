package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
   
	public static Properties prop;
	public static WebDriver driver;
	public TestBase() {
		prop = new Properties();
		String path = System.getProperty("user.dir") +
				"//src//test//resources//configFiles//config.properties";
		try {
			FileInputStream fin = new FileInputStream(path);
			prop.load(fin);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
	    e.printStackTrace();		
		}
	}
	public static void initialize() {
		String strBrowser = prop.getProperty("browser");
		if (strBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		
	}
}
