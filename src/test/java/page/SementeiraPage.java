package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SementeiraPage extends BasePage{

	public SementeiraPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public String tituloSementeira() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));
		
		}
	public String descricaoSementeira() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p"));
		
		}
	public String clickSoliciteDemostracao() {
		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
		return null;
	}	
	public String desafioGestaoRecebimento(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		
		}
	public String desafioControleLotes(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		
		}
	public String desafioGestaoVendas(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));
		
		}
	public String desafioGestaoColheita(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		
		}
}
