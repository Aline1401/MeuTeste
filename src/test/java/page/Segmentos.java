package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Segmentos extends BasePage{
	public Segmentos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	//************************Exercício1********************************
	
	public String obterDistruibidor() {
		return validaTexto(By.xpath("//*[@id=\"seg-3\"]/a[1]/span"));
	}
	
	public String obterLoja() {
		return validaTexto(By.xpath("//*[@id=\"seg-3\"]/a[2]/span"));
	}
	
	public String obterArmazem() {
		return validaTexto(By.xpath("//*[@id=\"seg-3\"]/a[3]/span"));
	}
	
	public String obterProdutor() {
		return validaTexto(By.xpath("//*[@id=\"seg-3\"]/a[4]/span"));
	}
	
	public String obterSementeira() {
		return validaTexto(By.xpath("//*[@id=\"seg-3\"]/a[5]/span"));
	}
	
	public String obterOutros() {
		return validaTexto(By.xpath("//*[@id=\"seg-3\"]/a[6]/span"));
	}
}
