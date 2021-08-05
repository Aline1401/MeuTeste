package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoAgricolaPage extends BasePage {

	public ProdutoAgricolaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ProdutoAgricolaPage clickProdutorAgricola() {

		driver.findElement(By.linkText("Produtor agrícola")).click();
		return this;
	}

	public String getTituloProdutor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));

	}

	public String getDescricaoProdutor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p"));

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

	public String getDesafioPlanejamentoSafra() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));

	}

	public String getDesafioArmazenagem() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));

	}

	public String getDesafioControleCustos() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));

	}

	public String getDesafioPadronizacao() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[9]/span"));

	}

	public String getDesafioGestaoOrcamentaria() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));

	}
}
