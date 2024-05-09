package DEALSDRY_ASSIGNMENT;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ASSIGNMENT1_TASK5 {

	public static void main(String[] args)throws InterruptedException, IOException {
		 	WebDriver driver = new ChromeDriver();
		 	driver.manage().window().maximize();
		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 	
		 	driver.get("https://www.getcalley.com/how-calley-auto-dialer-app-works/");		
	        
		 	TakesScreenshot ts = (TakesScreenshot) driver; 
	        
		 	File temp = ts.getScreenshotAs(OutputType.FILE);
		 	File src = new File("./Screenshots/screenshot5.png");
		 	FileHandler.copy(temp, src);
	}

}
