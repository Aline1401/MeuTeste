package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoAgricolaPage extends BasePage{

	public ProdutoAgricolaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoAgricolaPage clickProdutorAgricola() {
	
	driver.findElement(By.linkText("Produtor agrícola")).click();
    return this;
}
	public String tituloProdutor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));
		
		}
	public String descricaoProdutor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p"));
		
		}
	
	public String desafioPlanejamentoSafra(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		
		}
	public String desafioArmazenagem(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		
		}
	public String desafioControleCustos(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));
		
		}
	public String desafioPadronizacao(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[9]/span"));
		
		}
	public String desafioGestaoOrcamentaria(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));
		
		}
}
