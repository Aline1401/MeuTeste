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
	public String verificaEstoqueEficiente() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		
		}
	public String verificaFormacaodePrecos() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));
		
		}
	public String verificaGestaologistica() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		
		}
	public String verificaMixAtividades() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));
		
		}
	public String verificaGestaoOrcamentaria() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[10]/span"));
}
	
}

