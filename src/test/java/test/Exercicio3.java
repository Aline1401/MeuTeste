package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import page.LojaPage;
import page.MovimentaPage;
import suporte.Web;

public class Exercicio3 {

	@Test
	public void Exercicio3Teste() {
		WebDriver driver = Web.createChrome();
		LojaPage loja = new LojaPage(driver);
		MovimentaPage pagina = new MovimentaPage(driver);

		pagina.clickLojaAgropecuaria();

		Assert.assertEquals("Softwares para gest�o de lojas e varejo agropecu�rio", loja.tituloLoja());

		Assert.assertEquals(
				"Ganhe agilidade em vendas, confian�a nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecu�ria de "
						+ "forma completa com o software Siagri.",
				loja.descricaoLoja());

		loja.clickSoliciteDemostracao();
		// verificando abertura do formul�rio conforme a descri��o
		loja.aberturaFormulario();
		// WebDriverWait formulario = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("modal-form")));
		// formulario.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-form")));
		// Validar desafios
		Assert.assertTrue("N�o � um desafio do segmento", loja.desafioAgilidade().equals("Agilidade no atendimento"));

		Assert.assertTrue("N�o � um desafio do segmento", loja.desafioEficiencia().equals("Efici�ncia operacional"));

		Assert.assertTrue("N�o � um desafio do segmento", loja.desafioControle().equals("Controle de comissionamento"));

		Assert.assertTrue("N�o � um desafio do segmento", loja.desafioFiscal().equals("Conformidade fiscal"));

		Assert.assertTrue("N�o � um desafio do segmento",
				loja.desafioFluxo().equals("Efici�ncia no fluxo de caixa em dia"));

	}
}
