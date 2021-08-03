package test;


import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@Before
	public void Conectar() {
		driver = Web.createChrome();
		segmentos = new Segmentos(driver);
		pagina = new MovimentaPage(driver);
		distribuidor = new DistribuidorPage(driver);
		loja= new LojaPage(driver);
		armazens= new ArmazensGeraisPage(driver);
		produtor= new ProdutoAgricolaPage(driver);
		sementeira=new SementeiraPage(driver);
	}
	
	@After
	public void finaliza() throws IOException{
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

		distribuidor.clickSoliciteDemostracao();
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
		
		pagina.clickLojaAgropecuaria();
		
		Assert.assertEquals("Softwares para gestão de lojas e varejo agropecuário",loja.tituloLoja());
		
		Assert.assertEquals(
				"Ganhe agilidade em vendas, confiança nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecuária de "
				+ "forma completa com o software Siagri.",
				loja.descricaoLoja());

		loja.clickSoliciteDemostracao();
       // verificando abertura do formulário conforme a descrição
		loja.aberturaFormulario();				
		
		// Validar desafios
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioAgilidade().equals("Agilidade no atendimento"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioEficiencia().equals("Eficiência operacional"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioControle().equals("Controle de comissionamento"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioFiscal().equals("Conformidade fiscal"));
		
		Assert.assertTrue("Não é um desafio do segmento",loja.desafioFluxo().equals("Eficiência no fluxo de caixa em dia"));
		
	}

	@Test
	public void Exercicio4() {
		
		pagina.clickArmazensGerais();
		
		Assert.assertEquals("Softwares para gestão de armazéns gerais e cerealistas", armazens.tituloArmazens());
		
		Assert.assertEquals(
				"Ganhe eficiência desde o recebimento até a expedição dos grãos. Com o Grupo Siagri, você gerencia todos os processos de armazenagem de grãos "
				+ "com agilidade e segurança.",
				armazens.descricaoArmazens());

		
		armazens.clickSoliciteDemostracao();
		// verificando abertura do formulário conforme a descrição
		armazens.aberturaFormulario();
		// Validar desafios
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioContrato().equals("Gestão de contratos"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioControleSaldoTerceiros().equals("Controle de saldos de terceiros"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioControleRetencaoTrangenia().equals("Controle de retenções e transgenia"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioExposicao().equals("Análise de exposição"));
		
		Assert.assertTrue("Não é um desafio do segmento",armazens.desafioServicosPrestacao().equals("Controle de serviços prestados"));
		
	}

	@Test
	public void Exercicio5() {
		
		pagina.clickProdutorAgricola();
		Assert.assertEquals("Softwares de gestão para produtores de grãos e algodão", produtor.tituloProdutor());
		Assert.assertEquals(
					"Gestão do planejamento da safra à contabilidade. Com o Grupo Siagri você gerencia seu negócio de ponta a ponta, centralizando a gestão administrativa, "
					+ "financeira, fiscal e operacional.",
		produtor.descricaoProdutor());

		produtor.clickSoliciteDemostracao();
		// verificando abertura do formulário conforme a descrição
		produtor.aberturaFormulario();
		//validar desafios
		Assert.assertTrue("Não é um desafio do segmento",produtor.desafioPlanejamentoSafra().equals("Planejamento de safra"));
		
		Assert.assertTrue("Não é um desafio do segmento",produtor.desafioArmazenagem().equals("Gestão de estoque (armazenagem)"));
		
		Assert.assertTrue("Não é um desafio do segmento",produtor.desafioControleCustos().equals("Controle de custos"));
		
		Assert.assertTrue("Não é um desafio do segmento",produtor.desafioPadronizacao().equals("Padronização de processos"));
		
		Assert.assertTrue("Não é um desafio do segmento",produtor.desafioGestaoOrcamentaria().equals("Gestão orçamentária"));
	}

	@Test
	public void Exercicio6() {
		
		pagina.clickSementeira();
		Assert.assertEquals("Softwares para gestão de sementeiras", sementeira.tituloSementeira());
		Assert.assertEquals(
				"Ganhe eficiência no processo de beneficiamento de sementes. Com as soluções Siagri, você gerencia desde o recebimento do grão, até o embarque de sementes.",
				sementeira.descricaoSementeira());

		sementeira.clickSoliciteDemostracao();
		// verificando abertura do formulário conforme a descrição
		sementeira.aberturaFormulario();
		//validar desafios
			
		Assert.assertTrue("Não é um desafio do segmento",sementeira.desafioGestaoRecebimento().equals("Gestão de recebimento, produção e expedição de sementes"));
		
		Assert.assertTrue("Não é um desafio do segmento",sementeira.desafioControleLotes().equals("Controle de lotes"));
		
		Assert.assertTrue("Não é um desafio do segmento",sementeira.desafioGestaoVendas().equals("Gestão de vendas das semente"));
		
		Assert.assertTrue("Não é um desafio do segmento",sementeira.desafioGestaoColheita().equals("Gestão da colheita e armazenagem de grãos"));
		
	}

}
