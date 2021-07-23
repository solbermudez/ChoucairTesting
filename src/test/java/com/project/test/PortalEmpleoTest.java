package com.project.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.pages.PortalEmpleosPage;

public class PortalEmpleoTest {
	
	private WebDriver driver;
	PortalEmpleosPage portalEmpleosPage;
	

	@Before
	public void setUp() throws Exception {
		portalEmpleosPage = new PortalEmpleosPage(driver);
		driver = portalEmpleosPage.chromeDriverConnection();
		portalEmpleosPage.visit("https://www.choucairtesting.com/empleos-testing/");
		driver.manage().window().maximize();
	}
	

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void portalEmpleoTest() throws InterruptedException{
		portalEmpleosPage.textoBotonFrame();
		
		assertEquals("Continuar", portalEmpleosPage.textoBotonFrame());

		
	}

}
