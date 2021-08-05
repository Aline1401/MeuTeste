package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DistribuidorPage extends BasePage {

	public DistribuidorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getTituloDistruibidor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));

	}

	public String getDescricaoDistruibuidor() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p"));

	}

	public void clickSoliciteDemostracao() {
		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();

	}

	public void clickFormulario() {
		click(By.xpath("//*[@id=\\\"segmentos-titulo\\\"]/div/div[1]/span"));

	}

	public void aberturaFormulario() {
		WebDriverWait formulario = new WebDriverWait(driver, 20);
		formulario.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-form")));

	}

	public void fecharFormulario() {
		click(By.xpath("//*[@id=\"form-close\"]"));
	}

	public String getDesafioEstoqueEficiente() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));

	}

	public String getDesafioFormacaodePrecos() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));

	}

	public String getDesafioGestaologistica() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));

	}

	public String getDesafioMixAtividades() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));

	}

	public String getDesafioGestaoOrcamentaria() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[10]/span"));
	}

}
