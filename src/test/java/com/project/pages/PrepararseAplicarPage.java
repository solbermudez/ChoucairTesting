package com.project.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.library.Base;

public class PrepararseAplicarPage extends Base{
	

	public PrepararseAplicarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By links = By.xpath("//a[@rel=\"noopener\"]"); 
    By opcionpreparaseparaaplicarlocator = By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[4]/div/div/div[2]/div/div/div/div/div/a/span/span");
    By imgpreparaseparaaplicarlocator = By.xpath("//img[@title='empleosazulMesa de trabajo 1']");

    
	public boolean clicPrepararseAplicar() {
		findElement(opcionpreparaseparaaplicarlocator).click();
		return true;
	}

	public boolean imgClicPrepararseAplicar() {
		findElement(imgpreparaseparaaplicarlocator).click();
		return true;

	}
	
	
	public boolean validarLinksPagina() {
		String urllinks = "";
		List<WebElement> validarlinks =  findElements(links);
		List<String> listaLinksInvalidos =  new ArrayList<String>();
		List<String> linksEncontrados =  new ArrayList<String>();
		List<String> linksExcepcion =  new ArrayList<String>();
		
		HttpsURLConnection httpsConnection = null;
		int responseCode = 200;
		Iterator<WebElement> iteration = validarlinks.iterator();
		
		
		while (iteration.hasNext()) {
			urllinks = iteration.next().getAttribute("href");
			if(urllinks==null || urllinks.isEmpty()) {
				System.out.println("El link" + urllinks + " no fue encontrado");
				continue;
			}
			try {
				httpsConnection = (HttpsURLConnection)(new URL(urllinks).openConnection());
				httpsConnection.setRequestMethod("HEAD");
				httpsConnection.setRequestMethod("GET");  
				httpsConnection.connect();
				responseCode = httpsConnection.getResponseCode();
				
				if(responseCode == 400 || responseCode == 401 || responseCode == 403 || responseCode == 404 || responseCode == 407 ||
						responseCode == 500 || responseCode == 501 || responseCode == 502 || responseCode == 505) {
					
					System.out.println("Error en la lista con la url: " + urllinks);
					listaLinksInvalidos.add(urllinks);
				} else {
					System.out.println("Link valido: " + urllinks);
					linksEncontrados.add(urllinks);
				} 
				
			} catch(Exception e) {
				//e.printStackTrace();
				System.out.println("Error de Excepcion: " + urllinks);
				linksExcepcion.add(urllinks);
			}
		}
		
		System.out.println("Cantidad links correctos: " + linksEncontrados.size());
		System.out.println("Cantidad links no encontrados: " + listaLinksInvalidos.size());
		System.out.println("Cantidad links con excepcion: " + linksExcepcion.size());
		
		if(listaLinksInvalidos.size()>0) {
			System.out.println("Lista de links no validos");
			for (int i = 0; i < listaLinksInvalidos.size(); i++) {
				System.out.println(listaLinksInvalidos.get(i));
			}
			return false;
		} else {
			return true;
		}
		
	}


}
