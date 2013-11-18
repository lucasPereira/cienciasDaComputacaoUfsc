package br.ufsc.grafos.superGrafos.estruturasDeDados;

import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.IteradorAbstrato;
import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.IteravelAbstrato;
import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.TipoIterador;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

/**
 * {@link ConjuntoAssociativo} implementado na forma de uma tabela de espalhamento.
 *
 * @param <C> chave que será usada para, inserir, remover e recuperar elementos do {@link ConjuntoAssociativo}.
 * @param <V> valor que será guardado no {@link ConjuntoAssociativo}.
 */
public final class ConjuntoAssociativo<C extends IgualavelCodificavel<C>, V> extends IteravelAbstrato<V> {

	private Lista<Entrada>[] tabela;
	private int quantidadeDeElementos;
	
	private static final float FATOR_DE_CARGA = 1f;
	private static final int FATOR_DE_AUMENTO = 2;
	private static final int PRIMO_MULTIPLICADOR = 31;
	private static final int CAPACIDADE_INICIAL_PADRÃO = 1;
	
	private static final int ZERO = 0;
	
	/**
	 * <p>Cria um {@link ConjuntoAssociativo} com a capacidade inicial fornecida.</p>
	 * 
	 * <p>Nota de implementação: A capacidade inicial sempre será arredondada para uma potência de dois.</p>
	 * 
	 * @param capacidadeInicial
	 */
	@SuppressWarnings("unchecked")
	public ConjuntoAssociativo(int capacidadeInicial) {
		tabela = new Lista[calcularTamanhoDaTabelaEmPotênciaDeDois(capacidadeInicial)];
		for (int contador = ZERO; contador < tabela.length; contador++) {
			tabela[contador] = new Lista<Entrada>();
		}
		quantidadeDeElementos = ZERO;
	}
	
	private int calcularTamanhoDaTabelaEmPotênciaDeDois(int capacidadeInicial) {
		int tamanhoDaTabelaDeEspalhamento = CAPACIDADE_INICIAL_PADRÃO;
		while (capacidadeInicial < tamanhoDaTabelaDeEspalhamento) {
			tamanhoDaTabelaDeEspalhamento *= FATOR_DE_AUMENTO;
		}
		
		return tamanhoDaTabelaDeEspalhamento;
	}
	
	/**
	 * <p>Cria um {@link ConjuntoAssociativo} com a capacidade inicial descrita 
	 * em {@link #CAPACIDADE_INICIAL_PADRÃO}.</p>
	 */
	public ConjuntoAssociativo() {
		this(CAPACIDADE_INICIAL_PADRÃO);
	}
	
	/**
	 * <p>Adiciona um valor ao {@link ConjuntoAssociativo}. Se já exisitr uma chave identica no
	 * {@link ConjuntoAssociativo}, então o valor representado por essa chave é substituído pelo
	 * valor inserido.</p>
	 * 
	 * <p>Nota de implementação: Caso a adição desse valor extrapole o fator de carga, então o tamanho da
	 * tabela de espalamento é aumentada conforme o {@link #FATOR_DE_AUMENTO}.</p>
	 *  
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param chave
	 * @param valor
	 */
	public void adicionar(C chave, V valor) {
		remover(chave);
		tabela[calcularPosiçãoNaTabela(chave)].adicionarNoÍnicio(new Entrada(chave, valor));
		quantidadeDeElementos++;
		if (tabela.length/quantidadeDeElementos < FATOR_DE_CARGA) {
			aumentarTabelaDeEspalhamento();
		} 
	}
	
	/**
	 * <p>Fornece o valor representado pela chave fornecida.</p> 
	 * 
	 * <p>Nota de implementação: É importante falar que 
	 * a complexidade dependerá do fator de carga da tabela de espalhamento. Entretanto 
	 * definimos um fator de carga de {@link #FATOR_DE_CARGA}, e sendo assim a complexidade tenderá a O(1).
	 * Esse mesmo aspecto é extendido para os métodos {@link #remover(C)} e {@link #contém(C)}.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param chave
	 * @return o valor referente a chave fornecida, ou null, caso a chave não esteja no {@link ConjuntoAssociativo}.
	 */
	public V fornecer(C chave) {
		TipoIterador<Entrada> iterador = tabela[calcularPosiçãoNaTabela(chave)].fornecerIterador();
		while (iterador.possuiPróximo()) {
			Entrada próximaEntrada = iterador.fornecerPróximo();
			if (próximaEntrada.chave.éIgual(chave)) {
				return próximaEntrada.valor;
			}
		}
		
		return null;
	}
	
	/**
	 * <p>Remove um valor do {@link ConjuntoAssociativo} associado a chave fornecida.</p>
	 * 
	 * <p>Nota de implementação: Veja {@link #fornecer(IgualavelCodificavel)}.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param chave
	 * @return verdadeiro se existir um valor associado a chave fornecida para ser removido.
	 */
	public boolean remover(C chave) {
		Lista<Entrada> partiçãoDeRemoção = tabela[calcularPosiçãoNaTabela(chave)];
		if (partiçãoDeRemoção.remover(new Entrada(chave, null))) {
			quantidadeDeElementos--;
			return true; 
		}
		
		return false;
	}
	
	/**
	 * <p>Verifica se um valor está no {@link ConjuntoAssociativo} dado uma chave.</p>
	 * 
	 * <p>Nota de implementação: Veja {@link #fornecer(IgualavelCodificavel)}.</p>
	 *  
	 * <p>Complexidade: O(1).</p> 
	 * 
	 * @param chave
	 * @return verdadeiro se o {@link ConjuntoAssociativo} contiver o valor associado a chave fornecida.
	 */
	public boolean contém(C chave) {
		Lista<Entrada> partiçãoDoElemento = tabela[calcularPosiçãoNaTabela(chave)];
		TipoIterador<Entrada> iterador = partiçãoDoElemento.fornecerIterador();
		while (iterador.possuiPróximo()) {
			if (iterador.fornecerPróximo().chave.éIgual(chave)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * <p>Fornece a quantidade de elementos presentes no {@link ConjuntoAssociativo}.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @return a quantidade de elementos presentes no {@link ConjuntoAssociativo}.
	 */
	public int fornecerQuantidadeDeElementos() {
		return quantidadeDeElementos;
	}
	
	private int calcularPosiçãoNaTabela(C chave) {
		int posição = (chave.fornecerCódigo()*PRIMO_MULTIPLICADOR)%tabela.length;
		return (posição < ZERO) ? -posição : posição;
	}
	
	private void aumentarTabelaDeEspalhamento() {
		int tamanhoDaNovaTabela = tabela.length*FATOR_DE_AUMENTO;
		@SuppressWarnings("unchecked")
		Lista<Entrada>[] novaTabela = new Lista[tamanhoDaNovaTabela];
		for (int contador = ZERO; contador < novaTabela.length; contador++) {
			novaTabela[contador] = new Lista<Entrada>(); 
		}
		Lista<Entrada>[] tabelaAntiga = tabela;
		tabela = novaTabela;
		quantidadeDeElementos = ZERO;
		int posiçãoNaTabela = ZERO;
		while (posiçãoNaTabela < tabelaAntiga.length) {
			Lista<Entrada> partiçãoDaTabela = tabelaAntiga[posiçãoNaTabela++];
			for (Entrada entrada : partiçãoDaTabela) {
				adicionar(entrada.chave, entrada.valor);
			}
		}
	}
	
	@Override
	public TipoIterador<V> fornecerIterador() {
		return new Iterador();
	}
	
	private final class Entrada implements IgualavelCodificavel<Entrada> {
		private C chave;
		private V valor;
		
		private Entrada(C chave, V valor) {
			this.chave = chave;
			this.valor = valor;
		}
	
		@Override
		public boolean éIgual(Entrada outro) {
			return chave.éIgual(outro.chave);
		}

		@Override
		public int fornecerCódigo() {
			return chave.fornecerCódigo();
		}
		
		@Override
		public String toString() {
			return valor.toString();
		}
	}
	
	private final class Iterador extends IteradorAbstrato<V> {
		
		private int cursor = ZERO;
		private TipoIterador<Entrada> cursorDaPartição = tabela[cursor].fornecerIterador();
		
		private Iterador() {
			chegarNoPróximo();
		}
		
		@Override
		public boolean possuiPróximo() {
			return (cursor < tabela.length);
		}

		@Override
		public V fornecerPróximo() {
			Entrada entrada = cursorDaPartição.fornecerPróximo();
			chegarNoPróximo();
			
			return entrada.valor;
		}
		
		private void chegarNoPróximo() {
			while (!cursorDaPartição.possuiPróximo() && ++cursor < tabela.length) {
				cursorDaPartição = tabela[cursor].fornecerIterador();
			} 
		}
	}
	
	@Override
	public String toString() {
		String texto = "{";
		TipoIterador<V> iterador = fornecerIterador();
		while (iterador.possuiPróximo()) {
			texto += iterador.fornecerPróximo().toString() + ", ";
		}
		texto = (texto.equals("{")) ? "{ }" : texto.substring(ZERO, texto.length()-2) + "}";
				
		return texto;
	}
}