package com.project.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.pages.PrepararseAplicarPage;

public class PreparaseAplicarTest {
	
	private WebDriver driver;
	PrepararseAplicarPage prepararseAplicarPage;
	
	@Before
	public void setUp() throws Exception {
		prepararseAplicarPage = new PrepararseAplicarPage(driver);
		driver = prepararseAplicarPage.chromeDriverConnection();
		prepararseAplicarPage.visit("https://www.choucairtesting.com/empleos-testing/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	public void clicPrepararseAplicar() {
		assertTrue("No permite hacer clic", prepararseAplicarPage.clicPrepararseAplicar());			
		System.out.println("Texto Prepararse para aplicar: " + prepararseAplicarPage.clicPrepararseAplicar());
	}
	
	@Test
	public void imgClicPrepararseAplicar() {
		assertTrue("No permite hacer clic", prepararseAplicarPage.imgClicPrepararseAplicar());			
		System.out.println("Imagen Prepararse para aplicar: " + prepararseAplicarPage.imgClicPrepararseAplicar());
	}

	@Test
	public void validarLinksPreparase() {
		assertTrue("Se encontraron link invalidos", prepararseAplicarPage.validarLinksPagina());			
	}
	
	

}





















