package backup;

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

		Assert.assertEquals("Softwares para gestão de lojas e varejo agropecuário", loja.getTituloLoja());

		Assert.assertEquals(
				"Ganhe agilidade em vendas, confiança nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecuária de "
						+ "forma completa com o software Siagri.",
				loja.getDescricaoLoja());

		loja.clickSoliciteDemostracao();
		// verificando abertura do formulário conforme a descrição
		loja.aberturaFormulario();
		// WebDriverWait formulario = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("modal-form")));
		// formulario.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-form")));
		// Validar desafios
		Assert.assertTrue("Não é um desafio do segmento", loja.getDesafioAgilidade().equals("Agilidade no atendimento"));

		Assert.assertTrue("Não é um desafio do segmento", loja.getDesafioEficiencia().equals("Eficiência operacional"));

		Assert.assertTrue("Não é um desafio do segmento", loja.getDesafioControle().equals("Controle de comissionamento"));

		Assert.assertTrue("Não é um desafio do segmento", loja.getDesafioFiscal().equals("Conformidade fiscal"));

		Assert.assertTrue("Não é um desafio do segmento",
				loja.getDesafioFluxo().equals("Eficiência no fluxo de caixa em dia"));

	}
}
