package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	public void clickFormulario() {
	 click(By.xpath("//*[@id=\\\"segmentos-titulo\\\"]/div/div[1]/span"));

		}
	public String desafioEstoqueEficiente() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		
		}
	public String desafioFormacaodePrecos() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));
		
		}
	public String desafioGestaologistica() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		
		}
	public String desafioMixAtividades() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));
		
		}
	public String desafioGestaoOrcamentaria() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[10]/span"));
}
	
}

