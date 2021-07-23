package com.project.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.pages.IngresoModuloEmpleo;

public class IngresoModuloEmpleoTest {
	
	private WebDriver driver;
	IngresoModuloEmpleo ingresoModuloEmpleo;

	@Before
	public void setUp() throws Exception {
		ingresoModuloEmpleo = new IngresoModuloEmpleo(driver);
		driver = ingresoModuloEmpleo.chromeDriverConnection();
		ingresoModuloEmpleo.visit("https://www.choucairtesting.com/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException{
		ingresoModuloEmpleo.ingresarModuloEmpleo();
		
		assertEquals("¿Qué es ser Choucair?", ingresoModuloEmpleo.textoObtenido1());
		System.out.println("Exitoso, mensaje recibido: " + ingresoModuloEmpleo.textoObtenido1());
		
		assertEquals("Prepararse para aplicar", ingresoModuloEmpleo.textoObtenido2());
		System.out.println("Exitoso, mensaje recibido: " + ingresoModuloEmpleo.textoObtenido2());
		
		assertEquals("Ir al portal de empleos", ingresoModuloEmpleo.opcionIrPortalEmpleo());
		System.out.println("Exitoso, mensaje recibido: " + ingresoModuloEmpleo.opcionIrPortalEmpleo());
		
	}
	
}
