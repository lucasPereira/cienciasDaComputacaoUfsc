import java.util.HashSet;
import java.util.Set;

public abstract class CelulaAbstrata implements Celula {
	protected MundoWumpus mundoWumpus;
	private Integer linha;
	private Integer coluna;
	private Set<Posicionavel> posicionaveis;
	private Set<Agente> agentes;

	public CelulaAbstrata(MundoWumpus mundoWumpus, Integer linha, Integer coluna) {
		posicionaveis = new HashSet<Posicionavel>();
		agentes = new HashSet<Agente>();
		this.mundoWumpus = mundoWumpus;
		this.linha = linha;
		this.coluna = coluna;
	}

	@Override
	public final Boolean mesmoLocal(Celula outra) {
		return (linha == outra.fornecerLinha() && coluna == outra.fornecerColuna());
	}

	@Override
	public final Boolean aoLesteDe(Celula outra) {
		return (fornecerAdjacenteAoOeste().mesmoLocal(outra));
	}

	@Override
	public final Boolean aoOesteDe(Celula outra) {
		return (fornecerAdjacenteAoLeste().mesmoLocal(outra));
	}

	@Override
	public final Boolean aoNorteDe(Celula outra) {
		return (fornecerAdjacenteAoSul().mesmoLocal(outra));
	}

	@Override
	public final Boolean aoSulDe(Celula outra) {
		return (fornecerAdjacenteAoNorte().mesmoLocal(outra));
	}

	@Override
	public final Celula fornecerAdjacenteAoNorte() {
		return mundoWumpus.fornecerCelula(linha - 1, coluna);
	}

	@Override
	public final Celula fornecerAdjacenteAoSul() {
		return mundoWumpus.fornecerCelula(linha + 1, coluna);
	}

	@Override
	public final Celula fornecerAdjacenteAoLeste() {
		return mundoWumpus.fornecerCelula(linha, coluna + 1);
	}

	@Override
	public final Celula fornecerAdjacenteAoOeste() {
		return mundoWumpus.fornecerCelula(linha, coluna - 1);
	}

	@Override
	public Celula fornecerNovaDirecao(Celula novaPosicao) {
		Celula novaDirecao = null;
		if (novaPosicao.aoNorteDe(this)) {
			novaDirecao = novaPosicao.fornecerAdjacenteAoNorte();
		} else if (novaPosicao.aoSulDe(this)) {
			novaDirecao = novaPosicao.fornecerAdjacenteAoSul();
		} else if (novaPosicao.aoLesteDe(this)) {
			novaDirecao = novaPosicao.fornecerAdjacenteAoLeste();
		} else if (novaPosicao.aoOesteDe(this)) {
			novaDirecao = novaPosicao.fornecerAdjacenteAoOeste();
		}
		return novaDirecao;
	}

	@Override
	public Celula fornecerDirecaoContraria(Celula posicao) {
		Celula direcaoContraria = null;
		if (this.aoNorteDe(posicao)) {
			direcaoContraria = posicao.fornecerAdjacenteAoSul();
		} else if (this.aoSulDe(posicao)) {
			direcaoContraria = posicao.fornecerAdjacenteAoNorte();
		} else if (this.aoLesteDe(posicao)) {
			direcaoContraria = posicao.fornecerAdjacenteAoOeste();
		} else if (this.aoOesteDe(posicao)) {
			direcaoContraria = posicao.fornecerAdjacenteAoLeste();
		}
		return direcaoContraria;
	}

	@Override
	public Celula fornecerDirecaoParaEsquerda(Celula posicao) {
		Celula direcaoAEsquerda = null;
		if (this.aoNorteDe(posicao)) {
			direcaoAEsquerda = posicao.fornecerAdjacenteAoOeste();
		} else if (this.aoSulDe(posicao)) {
			direcaoAEsquerda = posicao.fornecerAdjacenteAoLeste();
		} else if (this.aoLesteDe(posicao)) {
			direcaoAEsquerda = posicao.fornecerAdjacenteAoNorte();
		} else if (this.aoOesteDe(posicao)) {
			direcaoAEsquerda = posicao.fornecerAdjacenteAoSul();
		}
		return direcaoAEsquerda;
	}

	@Override
	public Celula fornecerDirecaoParaDireita(Celula posicao) {
		Celula direcaoADireita = null;
		if (this.aoNorteDe(posicao)) {
			direcaoADireita = posicao.fornecerAdjacenteAoLeste();
		} else if (this.aoSulDe(posicao)) {
			direcaoADireita = posicao.fornecerAdjacenteAoOeste();
		} else if (this.aoLesteDe(posicao)) {
			direcaoADireita = posicao.fornecerAdjacenteAoSul();
		} else if (this.aoOesteDe(posicao)) {
			direcaoADireita = posicao.fornecerAdjacenteAoNorte();
		}
		return direcaoADireita;
	}

	@Override
	public void receberAgente(Agente agente) {
		for (Posicionavel posicionavel : posicionaveis) {
			posicionavel.perceberAgente(agente, this);
		}
		agentes.add(agente);
		posicionaveis.add(agente);
	}

	@Override
	public final void removerAgente(Agente agente) {
		posicionaveis.remove(agente);
		agentes.remove(agente);
	}

	@Override
	public final void receberPosicionavel(Posicionavel posicionavel) {
		posicionaveis.add(posicionavel);
	}

	@Override
	public final void removerPosicionavel(Posicionavel posicionavel) {
		posicionaveis.remove(posicionavel);
	}

	@Override
	public final Set<Agente> fornecerAgentes() {
		return agentes;
	}

	@Override
	public final Set<Posicionavel> fornecerPosicionaveis() {
		return posicionaveis;
	}

	@Override
	public final Boolean vazia() {
		return posicionaveis.isEmpty();
	}

	@Override
	public final Integer fornecerLinha() {
		return linha;
	}

	@Override
	public final Integer fornecerColuna() {
		return coluna;
	}

	@Override
	public boolean equals(Object outra) {
		if (outra instanceof Celula ||
			outra instanceof CelulaBuraco ||
			outra instanceof CelulaAbstrata ||
			outra instanceof CelulaSimples ||
			outra instanceof CelulaExterna) {
			return mesmoLocal((Celula) outra);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (fornecerLinha().hashCode() + fornecerColuna().hashCode());
	}
}
