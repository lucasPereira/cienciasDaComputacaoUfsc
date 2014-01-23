import jason.environment.grid.GridWorldModel;

import java.util.List;

public final class ModeloWumpus extends GridWorldModel {
	public static final int LINHAS = 4;
	public static final int COLUNAS = 4;
	public static final int GUERREIRO = 1;
	public static final int WUMPUS = 256;
	public static final int BRISA = 16;
	public static final int CHEIRO = 32;
	public static final int OURO = 64;
	public static final int BURACO = 128;
	private MundoWumpus mundoWumpus;

	public ModeloWumpus(MundoWumpus mundoWumpus) {
		super(LINHAS, COLUNAS, 5);
		this.mundoWumpus = mundoWumpus;
		inicializarPosicoes();
	}

	public void atualizarPercepcoes() {
		atualizarPosicoes();
	}

	public void atualizarPosicoes() {
		Celula celulaDoGuerreiro = mundoWumpus.fornecerGuerreiro().fornecerPosicao();
		setAgPos(GUERREIRO, celulaDoGuerreiro.fornecerColuna(), celulaDoGuerreiro.fornecerLinha());
	}

	public void inicializarPosicoes() {
		for (List<Celula> linhaDoTabuleiro : mundoWumpus.fornecerTabuleiro()) {
			for (Celula celula : linhaDoTabuleiro) {
				Integer linha = celula.fornecerLinha();
				Integer coluna = celula.fornecerColuna();
				for (Posicionavel posicionavel : celula.fornecerPosicionaveis()) {
					if (posicionavel.fornecerTipoDePosicionavel().equals(TipoDePosicionavel.BRISA)) {
						add(BRISA, coluna, linha);
						System.out.println(String.format("brisa [%d, %d]", linha, coluna)); 
					} else if (posicionavel.fornecerTipoDePosicionavel().equals(TipoDePosicionavel.CHEIRO)) {
						add(CHEIRO, coluna, linha);
						System.out.println(String.format("cheiro [%d, %d]", linha, coluna)); 
					} else if (posicionavel.fornecerTipoDePosicionavel().equals(TipoDePosicionavel.OURO)) {
						add(OURO, coluna, linha);
						System.out.println(String.format("ouro [%d, %d]", linha, coluna)); 
					} else if (posicionavel.fornecerTipoDePosicionavel().equals(TipoDePosicionavel.GUERREIRO)) {
						setAgPos(GUERREIRO, coluna, linha);
						System.out.println(String.format("guerreiro [%d, %d]", linha, coluna)); 
					} else if (posicionavel.fornecerTipoDePosicionavel().equals(TipoDePosicionavel.WUMPUS)) {
						add(WUMPUS, coluna, linha);
						System.out.println(String.format("wumpus [%d, %d]", linha, coluna)); 
					}
				}
				if (celula.fornecerTipoDeCelula().equals(TipoDeCelula.BURACO)) {
					add(BURACO, coluna, linha);
				}
			}
		}
	}

	public void removerOuro() {
		Celula posicaoDoOuro = mundoWumpus.fornecerGuerreiro().fornecerPosicao();
		remove(OURO, posicaoDoOuro.fornecerColuna(), posicaoDoOuro.fornecerLinha());
	}

	public void removerWumpus() {
		Celula posicaoDoWumpus = mundoWumpus.fornecerWumpus().fornecerPosicao();
		Celula posicaoDaBrisaNorte = posicaoDoWumpus.fornecerAdjacenteAoNorte();
		Celula posicaoDaBrisaSul = posicaoDoWumpus.fornecerAdjacenteAoSul();
		Celula posicaoDaBrisaLeste = posicaoDoWumpus.fornecerAdjacenteAoLeste();
		Celula posicaoDaBrisaOeste = posicaoDoWumpus.fornecerAdjacenteAoOeste();
		remove(WUMPUS, posicaoDoWumpus.fornecerColuna(), posicaoDoWumpus.fornecerLinha());
		if (!posicaoDaBrisaNorte.fornecerTipoDeCelula().equals(TipoDeCelula.EXTERNA)) {
			remove(CHEIRO, posicaoDaBrisaNorte.fornecerColuna(), posicaoDaBrisaNorte.fornecerLinha());
		}
		if (!posicaoDaBrisaSul.fornecerTipoDeCelula().equals(TipoDeCelula.EXTERNA)) {
			remove(CHEIRO, posicaoDaBrisaSul.fornecerColuna(), posicaoDaBrisaSul.fornecerLinha());
		}
		if (!posicaoDaBrisaLeste.fornecerTipoDeCelula().equals(TipoDeCelula.EXTERNA)) {
			remove(CHEIRO, posicaoDaBrisaLeste.fornecerColuna(), posicaoDaBrisaLeste.fornecerLinha());
		}
		if (!posicaoDaBrisaOeste.fornecerTipoDeCelula().equals(TipoDeCelula.EXTERNA)) {
			remove(CHEIRO, posicaoDaBrisaOeste.fornecerColuna(), posicaoDaBrisaOeste.fornecerLinha());
		}
	}
}
