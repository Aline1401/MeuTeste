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

		Assert.assertEquals("Loja agropecuária", segmentos.obterLoja());

		Assert.assertEquals("Armazéns gerais", segmentos.obterArmazem());

		Assert.assertEquals("Produtor agrícola", segmentos.obterProdutor());

		Assert.assertEquals("Sementeira", segmentos.obterSementeira());

		Assert.assertEquals("Outros", segmentos.obterOutros());
		
		//Com assertTrue
		//Assert.assertTrue("Segmento não atendido",segmentos.obterOutros().contentEquals("Outros"));
	}

	@Test
	public void Exercicio2() {

		pagina.clickSegmentos();
		
		Assert.assertEquals("Softwares para gestão de distribuidores de insumos agrícolas", distribuidor.tituloDistruibidor());
		Assert.assertEquals("Otimize processos, reduza desperdícios e tenha o controle de suas lojas em qualquer hora e lugar."
				+ " Com o Grupo Siagri, você compra melhor, evita perdas no estoque, vende com mais eficiência e ainda tem mais segurança nas operações de Barter!",
		distribuidor.descricaoDistribuidor());

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
		//distribuidor.clickFormulario();
		
		// verificando abertura do formulário conforme a descrição, será?

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));

		// Validar desafios
		
		Assert.assertTrue("Não é um desafio do segmento",distribuidor.desafioEstoqueEficiente().equals("Estoque eficiente"));
		
		Assert.assertTrue("Não é um desafio do segmento",distribuidor.desafioFormacaodePrecos().equals("Formação de preços"));
		
		Assert.assertTrue("Não é um desafio do segmento",distribuidor.desafioGestaologistica().equals("Gestão de logística (expedição)"));
		
		Assert.assertTrue("Não é um desafio do segmento",distribuidor.desafioMixAtividades().equals("Ampliar mix de atividades (armazenagem, Barter etc)"));
				
		Assert.assertTrue("Não é um desafio do segmento",distribuidor.desafioGestaoOrcamentaria().equals("Gestão orçamentária"));
		
	}

	@Test
	public void Exercicio3() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new LojaPage(driver).clickLojaAgropecuaria();
		
		Assert.assertEquals("Softwares para gestão de lojas e varejo agropecuário",loja.tituloLoja());
		
		Assert.assertEquals(
				"Ganhe agilidade em vendas, confiança nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecuária de "
				+ "forma completa com o software Siagri.",
				loja.descricaoLoja());

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
// verificando abertura do formulário conforme a descrição
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));

// Validar desafios
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioAgilidade().equals("Agilidade no atendimento"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioEficiencia().equals("Eficiência operacional"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioControle().equals("Controle de comissionamento"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioFiscal().equals("Conformidade fiscal"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioFluxo().equals("Eficiência no fluxo de caixa em dia"));
		
	}

	@Test
	public void Exercicio4() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new ArmazensGeraisPage(driver).clickArmazensGerais();
		Assert.assertEquals("Softwares para gestão de armazéns gerais e cerealistas", armazens.tituloArmazens());
		
		Assert.assertEquals(
				"Ganhe eficiência desde o recebimento até a expedição dos grãos. Com o Grupo Siagri, você gerencia todos os processos de armazenagem de grãos "
				+ "com agilidade e segurança.",
				armazens.descricaoArmazens());

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();
		
		// verificando abertura do formulário conforme a descrição
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));
		driver.findElement(By.xpath("//*[@id=\"form-close\"]")).click();

		
		// Validar desafios
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioContrato().equals("Gestão de contratos"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioControleSaldoTerceiros().equals("Controle de saldos de terceiros"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioControleRetencaoTrangenia().equals("Controle de retenções e transgenia"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioExposicao().equals("Análise de exposição"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioServicosPrestacao().equals("Controle de serviços prestados"));
		
	}

	@Test
	public void Exercicio5() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new ProdutoAgricolaPage(driver).clickProdutorAgricola();
		String Titulo = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2")))
				.getText();
		assertEquals("Softwares de gestão para produtores de grãos e algodão", Titulo);
		String descricao = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p")))
				.getText();
		assertEquals(
				"Gestão do planejamento da safra à contabilidade. Com o Grupo Siagri você gerencia seu negócio de ponta a ponta, centralizando a gestão administrativa, financeira, fiscal e operacional.",
				descricao);

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();

		// verificando abertura do formulário conforme a descrição
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));
		driver.findElement(By.xpath("//*[@id=\"form-close\"]")).click();

		WebElement safra = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		assertTrue(safra.getText().equals("Planejamento de safra"));

		WebElement armazenagem = driver
				.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		assertTrue(armazenagem.getText().equals("Gestão de estoque (armazenagem)"));

		WebElement custo = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]/span"));
		assertTrue(custo.getText().equals("Controle de custos"));

		WebElement processo = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[9]/span"));
		assertTrue(processo.getText().equals("Padronização de processos"));

		WebElement orcamento = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]/span"));
		assertTrue(orcamento.getText().equals("Gestão orçamentária"));
	}

	@Test
	public void Exercicio6() {
		// new Page(driver).clickSolucoes().menuSegmentos();
		new SementeiraPage(driver).clickSementeira();
		String Titulo = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/h2")))
				.getText();
		assertEquals("Softwares para gestão de sementeiras", Titulo);
		String descricao = ((WebElement) driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p")))
				.getText();
		assertEquals(
				"Ganhe eficiência no processo de beneficiamento de sementes. Com as soluções Siagri, você gerencia desde o recebimento do grão, até o embarque de sementes.",
				descricao);

		driver.findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/span")).click();

		// verificando abertura do formulário conforme a descrição
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-form\"]/div/h4")));
		driver.findElement(By.xpath("//*[@id=\"form-close\"]")).click();

		WebElement sementes = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]/span"));
		assertTrue(sementes.getText().equals("Gestão de recebimento, produção e expedição de sementes"));

		WebElement lotes = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]/span"));
		assertTrue(lotes.getText().equals("Controle de lotes"));

		WebElement vendas = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]/span"));
		assertTrue(vendas.getText().equals("Gestão de vendas das semente"));

		WebElement colheita = driver.findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]/span"));
		assertTrue(colheita.getText().equals("Gestão da colheita e armazenagem de grãos"));
	}

}
