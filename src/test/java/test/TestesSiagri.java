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
	String desafioRecusado = "Não é um desafio do segmento ";

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

		Assert.assertEquals("Loja agropecuária", segmentos.obterLoja());

		Assert.assertEquals("Armazéns gerais", segmentos.obterArmazem());

		Assert.assertEquals("Produtor agrícola", segmentos.obterProdutor());

		Assert.assertEquals("Sementeira", segmentos.obterSementeira());

		Assert.assertEquals("Outros", segmentos.obterOutros());
	}

	@Test
	public void validaSegmentoDistruibuidorDeInsumos() {

		pagina.clickSegmentos();

		Assert.assertEquals("Softwares para gestão de distribuidores de insumos agrícolas",
				distribuidor.getTituloDistruibidor());
		Assert.assertEquals(
				"Otimize processos, reduza desperdícios e tenha o controle de suas lojas em qualquer hora e lugar."
						+ " Com o Grupo Siagri, você compra melhor, evita perdas no estoque, vende com mais eficiência e ainda tem mais segurança nas operações de Barter!",
				distribuidor.getDescricaoDistribuidor());

		distribuidor.clickSoliciteDemostracao();
		distribuidor.aberturaFormulario();
		distribuidor.fecharFormulario();

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioEstoqueEficiente().equals("Estoque eficiente"));

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioFormacaodePrecos().equals("Formação de preços"));

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioGestaologistica().equals("Gestão de logística (expedição)"));

		Assert.assertTrue(desafioRecusado,
				distribuidor.getDesafioMixAtividades().equals("Ampliar mix de atividades (armazenagem, Barter etc)"));

		Assert.assertTrue(desafioRecusado, distribuidor.getDesafioGestaoOrcamentaria().equals("Gestão orçamentária"));

	}

	@Test
	public void validaSegmentoLojaAgropecuaria() {

		pagina.clickLojaAgropecuaria();

		Assert.assertEquals("Softwares para gestão de lojas e varejo agropecuário", loja.getTituloLoja());

		Assert.assertEquals(
				"Ganhe agilidade em vendas, confiança nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecuária de "
						+ "forma completa com o software Siagri.",
				loja.getDescricaoLoja());

		loja.clickSoliciteDemostracao();
		loja.aberturaFormulario();
		loja.fecharFormulario();
		Assert.assertTrue("Não é um desafio do segmento",
				loja.getDesafioAgilidade().equals("Agilidade no atendimento"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioEficiencia().equals("Eficiência operacional"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioControle().equals("Controle de comissionamento"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioFiscal().equals("Conformidade fiscal"));

		Assert.assertTrue(desafioRecusado, loja.getDesafioFluxo().equals("Eficiência no fluxo de caixa em dia"));

	}

	@Test
	public void validarSegmentoArmazensGerais() {

		pagina.clickArmazensGerais();

		Assert.assertEquals("Softwares para gestão de armazéns gerais e cerealistas", armazens.getTituloArmazens());

		Assert.assertEquals(
				"Ganhe eficiência desde o recebimento até a expedição dos grãos. Com o Grupo Siagri, você gerencia todos os processos de armazenagem de grãos "
						+ "com agilidade e segurança.",
				armazens.getDescricaoArmazens());

		armazens.clickSoliciteDemostracao();
		armazens.aberturaFormulario();
		armazens.fecharFormulario();

		Assert.assertTrue(desafioRecusado, armazens.getDesafioContrato().equals("Gestão de contratos"));

		Assert.assertTrue(desafioRecusado,
				armazens.getDesafioControleSaldoTerceiros().equals("Controle de saldos de terceiros"));

		Assert.assertTrue(desafioRecusado,
				armazens.getDesafioControleRetencaoTrangenia().equals("Controle de retenções e transgenia"));

		Assert.assertTrue(desafioRecusado, armazens.getDesafioExposicao().equals("Análise de exposição"));

		Assert.assertTrue(desafioRecusado, armazens.getDesafioServicosPrestacao().equals("Controle de serviços prestados"));

	}

	@Test
	public void validaSegmentoProdutoAgricola() {

		pagina.clickProdutorAgricola();
		Assert.assertEquals("Softwares de gestão para produtores de grãos e algodão", produtor.getTituloProdutor());
		Assert.assertEquals(
				"Gestão do planejamento da safra à contabilidade. Com o Grupo Siagri você gerencia seu negócio de ponta a ponta, centralizando a gestão administrativa, "
						+ "financeira, fiscal e operacional.",
				produtor.getDescricaoProdutor());

		produtor.clickSoliciteDemostracao();
		produtor.aberturaFormulario();
		produtor.fecharFormulario();
		Assert.assertTrue(desafioRecusado, produtor.getDesafioPlanejamentoSafra().equals("Planejamento de safra"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioArmazenagem().equals("Gestão de estoque (armazenagem)"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioControleCustos().equals("Controle de custos"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioPadronizacao().equals("Padronização de processos"));

		Assert.assertTrue(desafioRecusado, produtor.getDesafioGestaoOrcamentaria().equals("Gestão orçamentária"));
	}

	@Test
	public void validaSegmentoSementeira() {

		pagina.clickSementeira();
		Assert.assertEquals("Softwares para gestão de sementeiras", sementeira.getTituloSementeira());
		Assert.assertEquals(
				"Ganhe eficiência no processo de beneficiamento de sementes. Com as soluções Siagri, você gerencia desde o recebimento do grão, até o embarque de sementes.",
				sementeira.getDescricaoSementeira());

		sementeira.clickSoliciteDemostracao();
		sementeira.aberturaFormulario();
		sementeira.fecharFormulario();

		Assert.assertTrue(desafioRecusado, sementeira.getDesafioGestaoRecebimento()
				.equals("Gestão de recebimento, produção e expedição de sementes"));

		Assert.assertTrue(desafioRecusado, sementeira.getDesafioControleLotes().equals("Controle de lotes"));

		Assert.assertTrue(desafioRecusado, sementeira.getDesafioGestaoVendas().equals("Gestão de vendas das semente"));

		Assert.assertTrue(desafioRecusado,
				sementeira.getDesafioGestaoColheita().equals("Gestão da colheita e armazenagem de grãos"));

	}

}
