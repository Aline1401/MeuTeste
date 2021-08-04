package test;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import page.ArmazensGeraisPage;
import page.DistribuidorPage;
import page.LojaPage;
import page.MovimentaPage;
import page.ProdutoAgricolaPage;
import page.Segmentos;
import page.SementeiraPage;
import suporte.Web;

public class TestesSiagri {

	private WebDriver driver;
	private MovimentaPage pagina;
	private Segmentos segmentos;
	private DistribuidorPage distribuidor;
	private LojaPage loja;
	private ArmazensGeraisPage armazens;
	private ProdutoAgricolaPage produtor;
	private SementeiraPage sementeira;
	String desafioRecusado = "N�o � um desafio do segmento ";

	@Before
	public void setUp() {
		driver = Web.createChrome();
		pagina = new MovimentaPage(driver);
		segmentos = new Segmentos(driver);
		distribuidor = new DistribuidorPage(driver);
		loja = new LojaPage(driver);
		armazens = new ArmazensGeraisPage(driver);
		produtor = new ProdutoAgricolaPage(driver);
		sementeira = new SementeiraPage(driver);
	}

	@After
	public void tearDown() throws IOException {
		driver.quit();
	}

	@Test
	public void validarSementosAtendidosPelaSiagri() {

		pagina.clickSegmentos();

		Assert.assertEquals("Distribuidor de insumos", segmentos.obterDistruibidor());

		Assert.assertEquals("Loja agropecu�ria", segmentos.obterLoja());

		Assert.assertEquals("Armaz�ns gerais", segmentos.obterArmazem());

		Assert.assertEquals("Produtor agr�cola", segmentos.obterProdutor());

		Assert.assertEquals("Sementeira", segmentos.obterSementeira());

		Assert.assertEquals("Outros", segmentos.obterOutros());
	}

	@Test
	public void validaSegmentoDistruibuidorDeInsumos() {

		pagina.clickSegmentos();

		Assert.assertEquals("Softwares para gest�o de distribuidores de insumos agr�colas",
				distribuidor.getTituloDistruibidor());
		Assert.assertEquals(
				"Otimize processos, reduza desperd�cios e tenha o controle de suas lojas em qualquer hora e lugar."
						+ " Com o Grupo Siagri, voc� compra melhor, evita perdas no estoque, vende com mais efici�ncia e ainda tem mais seguran�a nas opera��es de Barter!",
				distribuidor.getDescricaoDistribuidor());

		distribuidor.clickSoliciteDemostracao();
		distribuidor.aberturaFormulario();
		distribuidor.fecharFormulario();

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioEstoqueEficiente().equals("Estoque eficiente"));

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioFormacaodePrecos().equals("Forma��o de pre�os"));

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioGestaologistica().equals("Gest�o de log�stica (expedi��o)"));

		Assert.assertTrue(desafioRecusado,
				distribuidor.getDesafioMixAtividades().equals("Ampliar mix de atividades (armazenagem, Barter etc)"));

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioGestaoOrcamentaria().equals("Gest�o or�ament�ria"));

	}

	@Test
	public void validaSegmentoLojaAgropecuaria() {

		pagina.clickLojaAgropecuaria();

		Assert.assertEquals("Softwares para gest�o de lojas e varejo agropecu�rio", loja.getTituloLoja());

		Assert.assertEquals(
				"Ganhe agilidade em vendas, confian�a nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecu�ria de "
						+ "forma completa com o software Siagri.",
				loja.getDescricaoLoja());

		loja.clickSoliciteDemostracao();
		loja.aberturaFormulario();
		loja.fecharFormulario();
		Assert.assertTrue("N�o � um desafio do segmento",
				loja.getDesafioAgilidade().equals("Agilidade no atendimento"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioEficiencia().equals("Efici�ncia operacional"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioControle().equals("Controle de comissionamento"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioFiscal().equals("Conformidade fiscal"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioFluxo().equals("Efici�ncia no fluxo de caixa em dia"));

	}

	@Test
	public void validarSegmentoArmazensGerais() {

		pagina.clickArmazensGerais();

		Assert.assertEquals("Softwares para gest�o de armaz�ns gerais e cerealistas", armazens.getTituloArmazens());

		Assert.assertEquals(
				"Ganhe efici�ncia desde o recebimento at� a expedi��o dos gr�os. Com o Grupo Siagri, voc� gerencia todos os processos de armazenagem de gr�os "
						+ "com agilidade e seguran�a.",
				armazens.getDescricaoArmazens());

		armazens.clickSoliciteDemostracao();
		armazens.aberturaFormulario();
		armazens.fecharFormulario();

		Assert.assertTrue(desafioRecusado, armazens.getDesafioContrato().equals("Gest�o de contratos"));

		Assert.assertTrue(desafioRecusado,
				armazens.getDesafioControleSaldoTerceiros().equals("Controle de saldos de terceiros"));

		Assert.assertTrue(desafioRecusado,
				armazens.getDesafioControleRetencaoTrangenia().equals("Controle de reten��es e transgenia"));

		Assert.assertTrue(desafioRecusado, armazens.getDesafioExposicao().equals("An�lise de exposi��o"));

		Assert.assertTrue(desafioRecusado, armazens.getDesafioServicosPrestacao().equals("Controle de servi�os prestados"));

	}

	@Test
	public void validaSegmentoProdutoAgricola() {

		pagina.clickProdutorAgricola();
		Assert.assertEquals("Softwares de gest�o para produtores de gr�os e algod�o", produtor.getTituloProdutor());
		Assert.assertEquals(
				"Gest�o do planejamento da safra � contabilidade. Com o Grupo Siagri voc� gerencia seu neg�cio de ponta a ponta, centralizando a gest�o administrativa, "
						+ "financeira, fiscal e operacional.",
				produtor.getDescricaoProdutor());

		produtor.clickSoliciteDemostracao();
		produtor.aberturaFormulario();
		produtor.fecharFormulario();
		Assert.assertTrue(desafioRecusado, produtor.getDesafioPlanejamentoSafra().equals("Planejamento de safra"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioArmazenagem().equals("Gest�o de estoque (armazenagem)"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioControleCustos().equals("Controle de custos"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioPadronizacao().equals("Padroniza��o de processos"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioGestaoOrcamentaria().equals("Gest�o or�ament�ria"));
	}

	@Test
	public void validaSegmentoSementeira() {

		pagina.clickSementeira();
		Assert.assertEquals("Softwares para gest�o de sementeiras", sementeira.getTituloSementeira());
		Assert.assertEquals(
				"Ganhe efici�ncia no processo de beneficiamento de sementes. Com as solu��es Siagri, voc� gerencia desde o recebimento do gr�o, at� o embarque de sementes.",
				sementeira.getDescricaoSementeira());

		sementeira.clickSoliciteDemostracao();
		sementeira.aberturaFormulario();
		sementeira.fecharFormulario();

		Assert.assertTrue(desafioRecusado, sementeira.getDesafioGestaoRecebimento()
				.equals("Gest�o de recebimento, produ��o e expedi��o de sementes"));

		Assert.assertTrue(desafioRecusado, sementeira.getDesafioControleLotes().equals("Controle de lotes"));

		Assert.assertTrue(desafioRecusado, sementeira.getDesafioGestaoVendas().equals("Gest�o de vendas das semente"));

		Assert.assertTrue(desafioRecusado,
				sementeira.getDesafioGestaoColheita().equals("Gest�o da colheita e armazenagem de gr�os"));

	}

}
