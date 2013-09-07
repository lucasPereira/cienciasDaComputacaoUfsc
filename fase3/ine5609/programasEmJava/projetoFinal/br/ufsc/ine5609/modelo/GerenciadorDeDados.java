package br.ufsc.ine5609.modelo;

import br.ufsc.ine5609.modelo.conjuntoDeDados.Escolaridade;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;
import br.ufsc.ine5609.modelo.diretorio.DiretorioContinuo;
import br.ufsc.ine5609.modelo.diretorio.DiretorioDiscreto;
import br.ufsc.ine5609.modelo.diretorio.DiretorioFlexivel;
import br.ufsc.ine5609.modelo.estrutraDeDados.TipoIterador;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeadaOrdenada;

public class GerenciadorDeDados {
	private static GerenciadorDeDados INSTANCIA = null;
	
	private ListaDePessoas listaComOsDados = ListaDePessoas.fornecerInstancia();
	private DiretorioDiscreto<Pessoa> diretorioEscolaridade;
	private DiretorioDiscreto<Pessoa> diretorioIdade;
	private DiretorioContinuo<Pessoa> diretorioSalario;
	private DiretorioFlexivel<String, Pessoa> diretorioCidade;
	
	private static final int QUANTIDADE_DE_INTERVALOS_SALARIO = 12;
	private static final double ESPACO_ENTRE_INTERVALOS_SALARIO = 1000;
	private static final int IDADE_MAXIMA = 120;
	
	private static final int ZERO = 0;
	private static final int UM = 1;

	public static GerenciadorDeDados fornecerInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new GerenciadorDeDados();
			INSTANCIA.criarDiretorios();
		}

		return INSTANCIA;
	}

	public void carregarDados() {
		criarDiretorios();
		TipoIterador<Pessoa> iterador = listaComOsDados.fornecerLista().fornecerIterador();
		while (iterador.temProximo()) {
			Pessoa pessoa = iterador.fornecerProximo();
			inserirDadoNosDiretorios(pessoa);
		}
	}
	
	public void inserirDado(Pessoa pessoa) {
		listaComOsDados.fornecerLista().inserirNoInicio(pessoa);
		inserirDadoNosDiretorios(pessoa);
	}
	
	private void inserirDadoNosDiretorios(Pessoa pessoa) {
		diretorioEscolaridade.inserirDado(pessoa.fornecerEscolaridade().ordinal(), pessoa);
		diretorioIdade.inserirDado(pessoa.fornecerIdade(), pessoa);
		diretorioSalario.inserirDado(pessoa.fornecerSalario(), pessoa);
		diretorioCidade.inserirDado(pessoa.fornecerCidade().toUpperCase(), pessoa);
	}
	
	public void removerDado(Pessoa pessoa) {
		listaComOsDados.fornecerLista().remover(pessoa);
		diretorioIdade.removerDado(pessoa.fornecerIdade(), pessoa);
		diretorioEscolaridade.removerDado(pessoa.fornecerEscolaridade().ordinal(), pessoa);
		diretorioSalario.removerDado(pessoa.fornecerSalario(), pessoa);
		diretorioCidade.removerDado(pessoa.fornecerCidade(), pessoa);
	}
	
	private void criarDiretorios() {
		criarDiretorioIdade();
		criarDiretorioEscolariedade();
		criarDiretorioSalario();
		criarDiretorioCidade();
	}
	
	private void criarDiretorioEscolariedade() {
		diretorioEscolaridade = new DiretorioDiscreto<Pessoa>(Escolaridade.values());
	}

	private void criarDiretorioIdade() {
		diretorioIdade = new DiretorioDiscreto<Pessoa>(ZERO, IDADE_MAXIMA);
	}
	
	private void criarDiretorioSalario() {
		double salario = ZERO;
		Double[] intervalosDeSalario = new Double[QUANTIDADE_DE_INTERVALOS_SALARIO];
		for(int cont = ZERO; cont < QUANTIDADE_DE_INTERVALOS_SALARIO; cont++) {
			intervalosDeSalario[cont] = salario;
			salario += ESPACO_ENTRE_INTERVALOS_SALARIO;
		}
		intervalosDeSalario[intervalosDeSalario.length-UM] = Double.MAX_VALUE;
		diretorioSalario = new DiretorioContinuo<Pessoa>(intervalosDeSalario);
	}
	
	public ListaEncadeada<Pessoa> buscar(ListaEncadeadaOrdenada<ListaEncadeada<Pessoa>> particoesBuscadas) {
		TipoIterador<ListaEncadeada<Pessoa>> iteradorDasParticoes = particoesBuscadas.fornecerIterador();
		ListaEncadeada<Pessoa> elementosBuscados = new ListaEncadeada<Pessoa>();
		if (iteradorDasParticoes.temProximo()) {
			elementosBuscados = pegarElementosDaPrimeiraParticao(iteradorDasParticoes);
		}
		while (iteradorDasParticoes.temProximo()) {
			TipoIterador<Pessoa> iteradorDosElementos = elementosBuscados.fornecerIterador();
			ListaEncadeada<Pessoa> particaoAtual = iteradorDasParticoes.fornecerProximo();
			while (iteradorDosElementos.temProximo()) {
				if (!particaoAtual.possui(iteradorDosElementos.fornecerProximo())) {
					iteradorDosElementos.remover();
				}
			}
		}
		
		return elementosBuscados;
	}
	
	private ListaEncadeada<Pessoa> pegarElementosDaPrimeiraParticao(TipoIterador<ListaEncadeada<Pessoa>> iteradorDasParticoes) {
		TipoIterador<Pessoa> iteradorDoPrimeiro = iteradorDasParticoes.fornecerProximo().fornecerIterador();
		ListaEncadeada<Pessoa> primeirosElementos = new ListaEncadeada<Pessoa>();
		while (iteradorDoPrimeiro.temProximo()) {
			primeirosElementos.inserirNoInicio(iteradorDoPrimeiro.fornecerProximo());
		}
		
		return primeirosElementos;
	}
	
	private void criarDiretorioCidade() {
		diretorioCidade = new DiretorioFlexivel<String, Pessoa>();
	}
	
	public ListaEncadeada<Pessoa> fornecerParticaoIdade(int chave) {
		return diretorioIdade.fornecerParticaoDoDiretorio(chave);
	}

	public ListaEncadeada<Pessoa> fornecerParticaoEscolaridade(int chave) {
		return diretorioEscolaridade.fornecerParticaoDoDiretorio(chave);
	}

	public ListaEncadeada<Pessoa> fornecerParticaoSalario(double chave) {
		return diretorioSalario.fornecerParticaoDoDiretorio(chave);
	}
	
	public ListaEncadeada<Pessoa> fornecerParticaoCidade(String chave) {
		return diretorioCidade.fornecerParticaoDoDiretorio(chave.toUpperCase());
	}
}