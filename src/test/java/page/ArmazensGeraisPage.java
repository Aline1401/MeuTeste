package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArmazensGeraisPage extends BasePage{

	public ArmazensGeraisPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ArmazensGeraisPage clickArmazensGerais() {
		driver.findElement(By.linkText("Armazéns gerais")).click();
		return this;
	}

	public String tituloArmazens() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));
		
		}
	public String descricaoArmazens() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p"));
		
		}
	
	public String desafioContrato(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		
		}
	public String desafioControleSaldoTerceiros(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		
		}
	public String desafioControleRetencaoTrangenia(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[4]/span"));
		
		}
	public String desafioExposicao(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));
		
		}
	public String desafioServicosPrestacao(){
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		
		}
	}

