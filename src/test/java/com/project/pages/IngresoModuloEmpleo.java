package com.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.library.Base;

public class IngresoModuloEmpleo extends Base{
	

    public IngresoModuloEmpleo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By moduloEmpleoLocator = By.id("menu-item-550");
    By opcionqueeschoucairLocator = By.linkText("¿Qué es ser Choucair?");
    By opcionpreparaseparaaplicarlocator = By.linkText("Prepararse para aplicar");
    By opcionirportalempleoslocator = By.className("elementor-button-text");
    
    public void ingresarModuloEmpleo() throws InterruptedException{
        click(moduloEmpleoLocator);
    }

    public String textoObtenido1(){
        List<WebElement> opcion1 = findElements(opcionqueeschoucairLocator);
        return getText(opcion1.get(0));
    }
    
    public String textoObtenido2(){
        List<WebElement> opcion2 = findElements(opcionpreparaseparaaplicarlocator);
        return getText(opcion2.get(0));
    }
    
    public String opcionIrPortalEmpleo(){
        List<WebElement> opcion3 = findElements(opcionirportalempleoslocator);
        return getText(opcion3.get(0));
    }
    
    
}
