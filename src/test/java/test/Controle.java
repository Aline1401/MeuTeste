package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

	public List<String> obtersegmentos(String id) {
		WebElement segmento = driver.findElement(By.xpath("\"//*[@id=\\\"seg-3\\\"]/a\""));
		Select combo = new Select(segmento);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;

}	
	
}
