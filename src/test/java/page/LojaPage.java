package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LojaPage extends BasePage {

	public LojaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getTituloLoja() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));

	}

	public String getDescricaoLoja() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p[2]"));

	}

	public void clickSoliciteDemostracao() {
		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();

	}

	public void aberturaFormulario() {
		WebDriverWait formulario = new WebDriverWait(driver, 20);
		formulario.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-form")));

	}

	public void fecharFormulario() {
		click(By.xpath("//*[@id=\"form-close\"]"));
	}

	public String getDesafioAgilidade() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));

	}

	public String getDesafioEficiencia() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));

	}

	public String getDesafioControle() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));

	}

	public String getDesafioFiscal() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));

	}

	public String getDesafioFluxo() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));

	}
}
