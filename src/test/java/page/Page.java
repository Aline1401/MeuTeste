package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page extends BasePage{
	
	public Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Segmentos clickSegmentos() {
		driver.findElement(By.linkText("Soluções")).click();
		driver.findElement(By.linkText("Segmentos")).click();
		return new Segmentos(driver);
		
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
