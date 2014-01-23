import java.util.Set;

public interface Celula {
	public TipoDeCelula fornecerTipoDeCelula();

	public Boolean mesmoLocal(Celula outra);

	public Boolean aoLesteDe(Celula outra);

	public Boolean aoOesteDe(Celula outra);

	public Boolean aoNorteDe(Celula outra);

	public Boolean aoSulDe(Celula outra);

	public Celula fornecerAdjacenteAoNorte();

	public Celula fornecerAdjacenteAoSul();

	public Celula fornecerAdjacenteAoLeste();

	public Celula fornecerAdjacenteAoOeste();

	public Celula fornecerNovaDirecao(Celula novaPosicao);

	public Celula fornecerDirecaoContraria(Celula posicao);

	public Celula fornecerDirecaoParaEsquerda(Celula posicao);

	public Celula fornecerDirecaoParaDireita(Celula posicao);

	public void receberAgente(Agente agente);

	public void removerAgente(Agente agente);

	public void receberPosicionavel(Posicionavel posicionavel);

	public void removerPosicionavel(Posicionavel posicionavel);

	public Set<Agente> fornecerAgentes();

	public Set<Posicionavel> fornecerPosicionaveis();

	public Boolean vazia();

	public Integer fornecerLinha();

	public Integer fornecerColuna();
}
