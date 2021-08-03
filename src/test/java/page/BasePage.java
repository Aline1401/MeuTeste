package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	protected static WebDriver driver;
	public BasePage(WebDriver driver) {
		BasePage.driver=driver;
	}
	
	public String validaTexto(By string) {
		return driver.findElement(string).getText();
	}
	
	public void click(By texto) {
		driver.findElement(texto).click();
		
	}
	
}
