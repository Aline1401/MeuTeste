package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;

public class DistribuidorPage extends BasePage{

	public DistribuidorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String tituloDistruibidor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));
		
		}
	public String descricaoDistribuidor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p"));
		
		}
	public String clickFormulario() {
		return click(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span"));
		
		}

}
