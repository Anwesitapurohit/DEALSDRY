package DEALSDRY_ASSIGNMENT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ASSIGNMENT2 {

	public static void main(String[] args) throws IOException, InterruptedException{
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get("https://demo.dealsdray.com/");
		  driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		  driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		  driver.findElement(By.xpath("//button[text()='Login']")).click();
	      driver.findElement(By.xpath("//span[text()='Order']")).click();
	      Thread.sleep(4000);
	      driver.findElement(By.xpath("//span[text()='Orders']")).click();
	      driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		  //FIle Upload
	      driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\ojas\\OneDrive\\Desktop\\demo-data.xlsx");
		  driver.findElement(By.xpath("//button[text()='Import']")).click();
		  driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		  wait.until(ExpectedConditions.alertIsPresent());
		  
		  //Alert PopUP
		  Alert ConfPopup = driver.switchTo().alert();
		  ConfPopup.accept();
		  
		  //Scroll Down
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  WebElement ScrollDown = driver.findElement(By.xpath("//th[text()='S.NO']"));
		  js.executeScript("arguments[0].scrollIntoView(true)",ScrollDown);
		  
		  //Taking ScreenShot
	      TakesScreenshot ts = (TakesScreenshot) driver; 
		  File temp = ts.getScreenshotAs(OutputType.FILE);
	      File src = new File("./Screenshots/screenshot6.png");
	      FileHandler.copy(temp, src);
	      driver.quit();
	}

}
