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

import backup.ProdutoAgricolaPage;
import backup.SementeiraPage;
import page.ArmazensGeraisPage;
import page.DistribuidorPage;
import page.LojaPage;
import page.Page;
import page.Segmentos;
import suporte.Web;

public class TestesSiagri {

	
	private WebDriver driver;
	private Page pagina;
	private Controle controle;
	private Segmentos segmentos;
	private DistribuidorPage distribuidor;
	private LojaPage loja;
	private ArmazensGeraisPage armazens;
	
	@Before
	public void Conectar() {
		driver = Web.createChrome();
		controle = new Controle(driver);
		segmentos = new Segmentos(driver);
		pagina = new Page(driver);
		distribuidor = new DistribuidorPage(driver);
		loja= new LojaPage(driver);
		armazens= new ArmazensGeraisPage(driver);
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

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
		//distribuidor.clickFormulario();
		
		// verificando abertura do formul�rio conforme a descri��o, ser�?

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));

		// Validar desafios
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioEstoqueEficiente().equals("Estoque eficiente"));
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioFormacaodePrecos().equals("Forma��o de pre�os"));
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioGestaologistica().equals("Gest�o de log�stica (expedi��o)"));
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioMixAtividades().equals("Ampliar mix de atividades (armazenagem, Barter etc)"));
				
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioGestaoOrcamentaria().equals("Gest�o or�ament�ria"));
		
	}

	@Test
	public void Exercicio3() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new LojaPage(driver).clickLojaAgropecuaria();
		
		Assert.assertEquals("Softwares para gest�o de lojas e varejo agropecu�rio",loja.tituloLoja());
		
		Assert.assertEquals(
				"Ganhe agilidade em vendas, confian�a nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecu�ria de "
				+ "forma completa com o software Siagri.",
				loja.descricaoLoja());

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
// verificando abertura do formul�rio conforme a descri��o
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));

// Validar desafios
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioAgilidade().equals("Agilidade no atendimento"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioEficiencia().equals("Efici�ncia operacional"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioControle().equals("Controle de comissionamento"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioFiscal().equals("Conformidade fiscal"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioFluxo().equals("Efici�ncia no fluxo de caixa em dia"));
		
	}

	@Test
	public void Exercicio4() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new ArmazensGeraisPage(driver).clickArmazensGerais();
		Assert.assertEquals("Softwares para gest�o de armaz�ns gerais e cerealistas", armazens.tituloArmazens());
		
		Assert.assertEquals(
				"Ganhe efici�ncia desde o recebimento at� a expedi��o dos gr�os. Com o Grupo Siagri, voc� gerencia todos os processos de armazenagem de gr�os "
				+ "com agilidade e seguran�a.",
				armazens.descricaoArmazens());

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
		
		// verificando abertura do formul�rio conforme a descri��o
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));
		driver.findElement(By.xpath("//*[@id=\"form-close\"]")).click();

		
		// Validar desafios
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioContrato().equals("Gest�o de contratos"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioControleSaldoTerceiros().equals("Controle de saldos de terceiros"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioControleRetencaoTrangenia().equals("Controle de reten��es e transgenia"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioExposicao().equals("An�lise de exposi��o"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioServicosPrestacao().equals("Controle de servi�os prestados"));
		
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
