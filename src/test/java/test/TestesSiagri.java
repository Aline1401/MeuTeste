package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import backup.ArmazensGeraisPage;
import backup.LojaPage;
import backup.ProdutoAgricolaPage;
import backup.SementeiraPage;
import page.DistribuidorPage;
import page.Page;
import page.Segmentos;
import suporte.Web;

public class TestesSiagri {

	
	private WebDriver driver;
	private Page pagina;
	private Controle controle;
	private Segmentos segmentos;
	private DistribuidorPage distribuidor = new DistribuidorPage(driver);

	@Before
	public void Conectar() {
		driver = Web.createChrome();
		controle = new Controle(driver);
		segmentos = new Segmentos(driver);
		pagina = new Page(driver);
	}

	@After
	public void Fechar() {
		driver.quit();
	}

	@Test
	public void Exercicio1() {

		pagina.clickSegmentos();
		Assert.assertEquals("Distribuidor de insumos", segmentos.obterDistruibidor());

		Assert.assertEquals("Loja agropecu�ria", segmentos.obterLoja());

		Assert.assertEquals("Armaz�ns gerais", segmentos.obterArmazem());

		Assert.assertEquals("Produtor agr�cola", segmentos.obterProdutor());

		Assert.assertEquals("Sementeira", segmentos.obterSementeira());

		Assert.assertEquals("Outros", segmentos.obterOutros());
		
		//Com assertTrue
		//Assert.assertTrue("Segmento n�o atendido",segmentos.obterOutros().contentEquals("Outros"));
	}

	@Test
	public void Exercicio2() {

		pagina.clickSegmentos();
		Assert.assertEquals("Softwares para gest�o de distribuidores de insumos agr�colas", distribuidor.tituloDistruibidor());
		Assert.assertEquals("Otimize processos, reduza desperd�cios e tenha o controle de suas lojas em qualquer hora e lugar."
				+ " Com o Grupo Siagri, voc� compra melhor, evita perdas no estoque, vende com mais efici�ncia e ainda tem mais seguran�a nas opera��es de Barter!",
		distribuidor.descricaoDistribuidor());

		//driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
		distribuidor.clickFormulario();
		
		// verificando abertura do formul�rio conforme a descri��o, ser�?

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));

		// Validar desafios
		WebElement estoque = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]"));
		assertTrue(estoque.getText().equals("Estoque eficiente"));

		WebElement preco = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));
		assertTrue(preco.getText().equals("Forma��o de pre�os"));

		WebElement gestao = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		assertTrue(gestao.getText().equals("Gest�o de log�stica (expedi��o)"));

		WebElement mix = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));
		assertTrue(mix.getText().equals("Ampliar mix de atividades (armazenagem, Barter etc)"));

		WebElement orcamento = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[10]/span"));
		assertTrue(orcamento.getText().equals("Gest�o or�ament�ria"));

	}

	@Test
	public void Exercicio3() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new LojaPage(driver).clickLojaAgropecuaria();
		String Titulo = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2")))
				.getText();
		assertEquals("Softwares para gest�o de lojas e varejo agropecu�rio", Titulo);
		String descricao = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p[2]")))
				.getText();
		assertEquals(
				"Ganhe agilidade em vendas, confian�a nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecu�ria de forma completa com o software Siagri.",
				descricao);

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
// verificando abertura do formul�rio conforme a descri��o
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));

// Validar desafios
		WebElement agilidade = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		assertTrue(agilidade.getText().equals("Agilidade no atendimento"));

		WebElement eficiencia = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		assertTrue(eficiencia.getText().equals("Efici�ncia operacional"));

		WebElement controle = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));
		assertTrue(controle.getText().equals("Controle de comissionamento"));

		WebElement fiscal = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));
		assertTrue(fiscal.getText().equals("Conformidade fiscal"));

		WebElement fluxo = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		assertTrue(fluxo.getText().equals("Efici�ncia no fluxo de caixa em dia"));

	}

	@Test
	public void Exercicio4() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new ArmazensGeraisPage(driver).clickArmazensGerais();
		String Titulo = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2")))
				.getText();
		assertEquals("Softwares para gest�o de armaz�ns gerais e cerealistas", Titulo);
		String descricao = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p")))
				.getText();
		assertEquals(
				"Ganhe efici�ncia desde o recebimento at� a expedi��o dos gr�os. Com o Grupo Siagri, voc� gerencia todos os processos de armazenagem de gr�os com agilidade e seguran�a.",
				descricao);

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();

		// verificando abertura do formul�rio conforme a descri��o
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));
		driver.findElement(By.xpath("//*[@id=\"form-close\"]")).click();

		// Validar desafios
		WebElement contrato = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		assertTrue(contrato.getText().equals("Gest�o de contratos"));

		WebElement terceiros = driver.findElement(By.xpath("/html/body/section[4]/div/div[2]/div[2]/span"));
		assertTrue(terceiros.getText().equals("Controle de saldos de terceiros"));

		WebElement retencoes = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[4]/span"));
		assertTrue(retencoes.getText().equals("Controle de reten��es e transgenia"));

		WebElement exposicao = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));
		assertTrue(exposicao.getText().equals("An�lise de exposi��o"));

		WebElement servico = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		assertTrue(servico.getText().equals("Controle de servi�os prestados"));
	}

	@Test
	public void Exercicio5() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new ProdutoAgricolaPage(driver).clickProdutorAgricola();
		String Titulo = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2")))
				.getText();
		assertEquals("Softwares de gest�o para produtores de gr�os e algod�o", Titulo);
		String descricao = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p")))
				.getText();
		assertEquals(
				"Gest�o do planejamento da safra � contabilidade. Com o Grupo Siagri voc� gerencia seu neg�cio de ponta a ponta, centralizando a gest�o administrativa, financeira, fiscal e operacional.",
				descricao);

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();

		// verificando abertura do formul�rio conforme a descri��o
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));
		driver.findElement(By.xpath("//*[@id=\"form-close\"]")).click();

		WebElement safra = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		assertTrue(safra.getText().equals("Planejamento de safra"));

		WebElement armazenagem = driver
				.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		assertTrue(armazenagem.getText().equals("Gest�o de estoque (armazenagem)"));

		WebElement custo = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));
		assertTrue(custo.getText().equals("Controle de custos"));

		WebElement processo = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[9]/span"));
		assertTrue(processo.getText().equals("Padroniza��o de processos"));

		WebElement orcamento = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));
		assertTrue(orcamento.getText().equals("Gest�o or�ament�ria"));
	}

	@Test
	public void Exercicio6() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new SementeiraPage(driver).clickSementeira();
		String Titulo = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2")))
				.getText();
		assertEquals("Softwares para gest�o de sementeiras", Titulo);
		String descricao = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p")))
				.getText();
		assertEquals(
				"Ganhe efici�ncia no processo de beneficiamento de sementes. Com as solu��es Siagri, voc� gerencia desde o recebimento do gr�o, at� o embarque de sementes.",
				descricao);

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();

		// verificando abertura do formul�rio conforme a descri��o
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));
		driver.findElement(By.xpath("//*[@id=\"form-close\"]")).click();

		WebElement sementes = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		assertTrue(sementes.getText().equals("Gest�o de recebimento, produ��o e expedi��o de sementes"));

		WebElement lotes = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		assertTrue(lotes.getText().equals("Controle de lotes"));

		WebElement vendas = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));
		assertTrue(vendas.getText().equals("Gest�o de vendas das semente"));

		WebElement colheita = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		assertTrue(colheita.getText().equals("Gest�o da colheita e armazenagem de gr�os"));
	}

}
