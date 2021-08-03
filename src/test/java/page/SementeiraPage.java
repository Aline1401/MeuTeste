package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public String aberturaFormulario() {
		WebDriverWait formulario = new WebDriverWait(driver, 20);
		formulario.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-form")));
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
