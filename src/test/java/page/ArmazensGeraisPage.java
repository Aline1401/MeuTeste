package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArmazensGeraisPage extends BasePage {

	public ArmazensGeraisPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ArmazensGeraisPage clickArmazensGerais() {
		driver.findElement(By.linkText("Armaz?ns gerais")).click();
		return this;
	}

	public String getTituloArmazens() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2"));

	}

	public String getDescricaoArmazens() {
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

	public String getDesafioContrato() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));

	}

	public String getDesafioControleSaldoTerceiros() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));

	}

	public String getDesafioControleRetencaoTrangenia() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[4]/span"));

	}

	public String getDesafioExposicao() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));

	}

	public String getDesafioServicosPrestacao() {
		return validaTexto(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));

	}
}
