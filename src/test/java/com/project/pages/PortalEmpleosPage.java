package com.project.pages;

import java.awt.Frame;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.library.Base;

public class PortalEmpleosPage extends Base{
	
	private WebDriver driver;

	
	public PortalEmpleosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By buttonPortalEmpleosLocator = By.xpath("//a[@href='#elementor-action%3Aaction%3Dpopup%3Aopen%26settings%3DeyJpZCI6IjExODc2IiwidG9nZ2xlIjpmYWxzZX0%3D']");
	
	//By frameLocator =  By.name("__bkframe"); 
	WebElement frameElementLocator2 = driver.findElement(By.name("__bkframe"));

	By buttonFrameContinuarLocator = By.xpath("//a[@href='https://www.magneto365.com/choucair']");
	
	
	public void clicPortalEmpleos() throws InterruptedException{
        click(buttonPortalEmpleosLocator);
        
    }

	public void framePortalEmpleo() {
		switchTo(frameElementLocator2);
		findElement(buttonFrameContinuarLocator).getText();
		System.out.println(buttonFrameContinuarLocator);


	}
	
	public String textoBotonFrame(){
        return getText(buttonFrameContinuarLocator);
    }

}
