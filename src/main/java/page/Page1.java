package page;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Page1 {
	ChromeDriver driver;
	By text=By.xpath("//*[@id=\"fname\"]");
	By dble=By.xpath("//*[@id=\"dblClkBtn\"]");
	By radio=By.xpath("//*[@id=\"male\"]");
	By drop=By.xpath("//*[@id=\"testingDropdown\"]");
	By alrt=By.xpath("//*[@id=\"AlertBox\"]/button");
	By dragimg=By.xpath("//*[@id=\"myImage\"]");
	By dragarea=By.xpath("//*[@id=\"targetDiv\"]");
	By submit=By.xpath("//*[@id=\"idOfButton\"]");
	
	public Page1(ChromeDriver driver)
	{
		this.driver=driver;
	}
	public void textenter()
	{
		driver.findElement(text).sendKeys("Hello..");
	}
	public void dbleclick()
	{
		Actions act=new Actions(driver);
		act.doubleClick(driver.findElement(dble));
		act.perform();
	}
	public void radiobtn()
	{
		driver.findElement(radio).click();
	}
	public void dropdwn()
	{
		Select dropdown=new Select(driver.findElement(drop));
		dropdown.selectByValue("Manual");
	}
	public void alert()
	{
		driver.findElement(alrt).click();
		Alert a=driver.switchTo().alert();
		String al=a.getText();
		a.accept();
		
	}
	
	public void submitbtn()
	{
		driver.findElement(submit).click();
	}
	public void screensht() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\heman\\OneDrive\\Pictures\\scrnsht.png"));
		WebElement btn=driver.findElement(dble);
		File src1=btn.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File("C:\\Users\\heman\\OneDrive\\Pictures\\scrnsht1.png"));
	}
	public void tab()
	{
		String pwindow=driver.getWindowHandle();
		WebDriver wb=driver.switchTo().newWindow(WindowType.TAB);
		wb.get("https://www.google.com/");
		Set<String>alllinks=driver.getWindowHandles();
		for(String all:alllinks)
		{
			if(!all.equalsIgnoreCase(pwindow))
			{
				driver.switchTo().window(pwindow);
				String sr=driver.getTitle();
			}
		}
	}
	public void response() throws IOException 
	{
		String crnt=driver.getCurrentUrl();
		List<WebElement>lnk=driver.findElements(By.tagName("a"));
		System.out.println("The count of link is "+lnk.size());
		for(WebElement ln:lnk)
		{
			String h=ln.getAttribute("href");
		}
		
		URL u=new URL(crnt);
		HttpURLConnection con=(HttpURLConnection)u.openConnection();
		con.connect();
		if(con.getResponseCode()==200)
		{
			System.out.println("Response code is 200");
		}
		else if(con.getResponseCode()==201)
		{
			System.out.println("Response code is 201");
		}
	}

}
