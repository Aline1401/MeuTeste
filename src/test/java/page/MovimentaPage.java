package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovimentaPage extends BasePage{
	
	public MovimentaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Segmentos clickSegmentos() {
		driver.findElement(By.linkText("Solu��es")).click();
		driver.findElement(By.linkText("Segmentos")).click();
		return new Segmentos(driver);
		
	}
	
	public Segmentos clickLojaAgropecuaria() {
		driver.findElement(By.linkText("Solu��es")).click();
		driver.findElement(By.linkText("Segmentos")).click();
		driver.findElement(By.linkText("Loja agropecu�ria")).click();
		return new Segmentos(driver);
		
		
	}
	public Segmentos clickArmazensGerais() {
		driver.findElement(By.linkText("Solu��es")).click();
		driver.findElement(By.linkText("Segmentos")).click();
		driver.findElement(By.linkText("Armaz�ns gerais")).click();
		return new Segmentos(driver);
		
	}
	public Segmentos clickProdutorAgricola() {
		driver.findElement(By.linkText("Solu��es")).click();
		driver.findElement(By.linkText("Segmentos")).click();
		driver.findElement(By.linkText("Produtor agr�cola")).click();
		return new Segmentos(driver);
		
	}
	public Segmentos clickSementeira() {
		driver.findElement(By.linkText("Solu��es")).click();
		driver.findElement(By.linkText("Segmentos")).click();
		driver.findElement(By.linkText("Sementeira")).click();
		return new Segmentos(driver);
		
	}
}
