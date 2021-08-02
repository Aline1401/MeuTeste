package backup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.BasePage;

public class LojaPage extends BasePage{

	public LojaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public LojaPage clickLojaAgropecuaria() {
		driver.findElement(By.linkText("Loja agropecuária")).click();
		return this;
	}

}
