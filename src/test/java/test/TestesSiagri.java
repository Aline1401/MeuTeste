package test;


import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
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

	
	private WebDriver driver= Web.createChrome();
	private MovimentaPage pagina=new MovimentaPage(driver);
	private Segmentos segmentos= new Segmentos(driver);
	private DistribuidorPage distribuidor=new DistribuidorPage(driver);
	private LojaPage loja=new LojaPage(driver);
	private ArmazensGeraisPage armazens=new ArmazensGeraisPage(driver);
	private ProdutoAgricolaPage produtor=new ProdutoAgricolaPage(driver);
	private SementeiraPage sementeira=new SementeiraPage(driver);
	
	
	@After
	public void finaliza() throws IOException{
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

		distribuidor.clickSoliciteDemostracao();
		// verificando abertura do formul�rio 

		distribuidor.aberturaFormulario();
		// Validar desafios
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioEstoqueEficiente().equals("Estoque eficiente"));
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioFormacaodePrecos().equals("Forma��o de pre�os"));
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioGestaologistica().equals("Gest�o de log�stica (expedi��o)"));
		
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioMixAtividades().equals("Ampliar mix de atividades (armazenagem, Barter etc)"));
				
		Assert.assertTrue("N�o � um desafio do segmento",distribuidor.desafioGestaoOrcamentaria().equals("Gest�o or�ament�ria"));
		
	}

	@Test
	public void Exercicio3() {
		
		pagina.clickLojaAgropecuaria();
		
		Assert.assertEquals("Softwares para gest�o de lojas e varejo agropecu�rio",loja.tituloLoja());
		
		Assert.assertEquals(
				"Ganhe agilidade em vendas, confian�a nos controles de estoque e custos. Fidelize seu cliente e gerencie sua loja agropecu�ria de "
				+ "forma completa com o software Siagri.",
				loja.descricaoLoja());

		loja.clickSoliciteDemostracao();
       // verificando abertura do formul�rio conforme a descri��o
		loja.aberturaFormulario();				
		
		// Validar desafios
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioAgilidade().equals("Agilidade no atendimento"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioEficiencia().equals("Efici�ncia operacional"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioControle().equals("Controle de comissionamento"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioFiscal().equals("Conformidade fiscal"));
		
		Assert.assertTrue("N�o � um desafio do segmento",loja.desafioFluxo().equals("Efici�ncia no fluxo de caixa em dia"));
		
	}

	@Test
	public void Exercicio4() {
		
		pagina.clickArmazensGerais();
		
		Assert.assertEquals("Softwares para gest�o de armaz�ns gerais e cerealistas", armazens.tituloArmazens());
		
		Assert.assertEquals(
				"Ganhe efici�ncia desde o recebimento at� a expedi��o dos gr�os. Com o Grupo Siagri, voc� gerencia todos os processos de armazenagem de gr�os "
				+ "com agilidade e seguran�a.",
				armazens.descricaoArmazens());

		
		armazens.clickSoliciteDemostracao();
		// verificando abertura do formul�rio
		armazens.aberturaFormulario();
		// Validar desafios
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioContrato().equals("Gest�o de contratos"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioControleSaldoTerceiros().equals("Controle de saldos de terceiros"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioControleRetencaoTrangenia().equals("Controle de reten��es e transgenia"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioExposicao().equals("An�lise de exposi��o"));
		
		Assert.assertTrue("N�o � um desafio do segmento",armazens.desafioServicosPrestacao().equals("Controle de servi�os prestados"));
		
	}

	@Test
	public void Exercicio5() {
		
		pagina.clickProdutorAgricola();
		Assert.assertEquals("Softwares de gest�o para produtores de gr�os e algod�o", produtor.tituloProdutor());
		Assert.assertEquals(
					"Gest�o do planejamento da safra � contabilidade. Com o Grupo Siagri voc� gerencia seu neg�cio de ponta a ponta, centralizando a gest�o administrativa, "
					+ "financeira, fiscal e operacional.",
		produtor.descricaoProdutor());

		produtor.clickSoliciteDemostracao();
		// verificando abertura do formul�rio 
		produtor.aberturaFormulario();
		//validar desafios
		Assert.assertTrue("N�o � um desafio do segmento",produtor.desafioPlanejamentoSafra().equals("Planejamento de safra"));
		
		Assert.assertTrue("N�o � um desafio do segmento",produtor.desafioArmazenagem().equals("Gest�o de estoque (armazenagem)"));
		
		Assert.assertTrue("N�o � um desafio do segmento",produtor.desafioControleCustos().equals("Controle de custos"));
		
		Assert.assertTrue("N�o � um desafio do segmento",produtor.desafioPadronizacao().equals("Padroniza��o de processos"));
		
		Assert.assertTrue("N�o � um desafio do segmento",produtor.desafioGestaoOrcamentaria().equals("Gest�o or�ament�ria"));
	}

	@Test
	public void Exercicio6() {
		
		pagina.clickSementeira();
		Assert.assertEquals("Softwares para gest�o de sementeiras", sementeira.tituloSementeira());
		Assert.assertEquals(
				"Ganhe efici�ncia no processo de beneficiamento de sementes. Com as solu��es Siagri, voc� gerencia desde o recebimento do gr�o, at� o embarque de sementes.",
				sementeira.descricaoSementeira());

		sementeira.clickSoliciteDemostracao();
		// verificando abertura do formul�rio
		sementeira.aberturaFormulario();
		//validar desafios
			
		Assert.assertTrue("N�o � um desafio do segmento",sementeira.desafioGestaoRecebimento().equals("Gest�o de recebimento, produ��o e expedi��o de sementes"));
		
		Assert.assertTrue("N�o � um desafio do segmento",sementeira.desafioControleLotes().equals("Controle de lotes"));
		
		Assert.assertTrue("N�o � um desafio do segmento",sementeira.desafioGestaoVendas().equals("Gest�o de vendas das semente"));
		
		Assert.assertTrue("N�o � um desafio do segmento",sementeira.desafioGestaoColheita().equals("Gest�o da colheita e armazenagem de gr�os"));
		
	}

}
