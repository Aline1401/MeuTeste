package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.BasePage;

public class Controle extends BasePage{

	public Controle(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public String validaTexto(By by) {
		return driver.findElement(by).getText();
		
	}
	public void obterLink(String link) {
		driver.findElement(By.linkText("link")).click();
		
	}
	
}
