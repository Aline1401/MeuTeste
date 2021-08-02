package backup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.BasePage;

public class ArmazensGeraisPage extends BasePage{

	public ArmazensGeraisPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ArmazensGeraisPage clickArmazensGerais() {
		driver.findElement(By.linkText("Armazéns gerais")).click();
		return this;
	}

	
}
