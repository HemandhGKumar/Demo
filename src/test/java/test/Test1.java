package test;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Page1;

public class Test1 {
	ChromeDriver driver;
	@BeforeTest
	public void testing()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void method()
	{
		driver.get("https://artoftesting.com/samplesiteforselenium");
	}
	@Test
	public void testf() throws IOException
	{
		Page1 p=new Page1(driver);
		
		p.textenter();
		p.dbleclick();
		p.radiobtn();
		p.dropdwn();
		p.screensht();
		p.tab();
		p.response();
	}

}
