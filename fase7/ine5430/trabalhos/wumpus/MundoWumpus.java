import jason.asSyntax.Structure;
import jason.environment.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class MundoWumpus {
	public static final Integer LINHAS = 4;
	public static final Integer COLUNAS = 4;
	private static final Integer BURACOS = 3;
	private static final Integer LINHA_GUERREIRO = 0;
	private static final Integer COLUNA_GUERREIRO = 0;
	private Random geradorAleatorio;
	private List<List<Celula>> tabuleiro;
	private Guerreiro guerreiro;
	private Wumpus wumpus;

	public MundoWumpus() {
		geradorAleatorio = new Random();
		construirTabuleiro();
		construirEntidades();
	}

	public void atualizarPercepcoes(AmbienteWumpus ambiente) {
		for (List<Celula> linha : tabuleiro) {
			for (Celula celula : linha) {
				for (Agente agente : celula.fornecerAgentes()) {
					agente.atualizarPercepcoes(ambiente);
				}
			}
		}
	}

	public List<List<Celula>> fornecerTabuleiro() {
		return tabuleiro;
	}

	public Guerreiro fornecerGuerreiro() {
		return guerreiro;
	}

	public Wumpus fornecerWumpus() {
		return wumpus;
	}

	public void guerreiroVirarParaEsquerda() {
		guerreiro.virarParaEsquerda();
	}

	public void guerreiroVirarParaDireita() {
		guerreiro.virarParaDireita();
	}

	public void guerreiroVirarAleatorio() {
		Integer lado = geradorAleatorio.nextInt(4);
		for (Integer contador = 0; contador <= lado; contador++) {
				guerreiroVirarParaEsquerda();
		}
	}

	public void guerreiroAndar() {
		guerreiro.andar();
	}

	public Boolean guerreiroAtirar() {
		Boolean matouWumpus = false;
		Celula posicaoDoWumpus = wumpus.fornecerPosicao();
		Celula posicao = guerreiro.fornecerPosicao();
		Celula proximaPosicao = guerreiro.fornecerDirecao();
		do {
			Celula posicaoVelha = posicao;
			posicao = proximaPosicao;
			proximaPosicao = posicaoVelha.fornecerNovaDirecao(posicao);
			if (posicao.mesmoLocal(posicaoDoWumpus)) {
				matouWumpus = true;
			}
		} while (posicao.fornecerTipoDeCelula().equals(TipoDeCelula.SIMPLES));
		if (matouWumpus) {
			Cheiro cheiro = new Cheiro();
			posicaoDoWumpus.removerAgente(wumpus);
			posicaoDoWumpus.fornecerAdjacenteAoNorte().removerPosicionavel(cheiro);
			posicaoDoWumpus.fornecerAdjacenteAoSul().removerPosicionavel(cheiro);
			posicaoDoWumpus.fornecerAdjacenteAoLeste().removerPosicionavel(cheiro);
			posicaoDoWumpus.fornecerAdjacenteAoOeste().removerPosicionavel(cheiro);
		}
		return matouWumpus;
	}

	public Boolean guerreiroPegarOuro() {
		Celula posicaoDoGuerreiro = guerreiro.fornecerPosicao();
		Posicionavel ouro = null;
		for (Posicionavel posicionavel : posicaoDoGuerreiro.fornecerPosicionaveis()) {
			if (posicionavel.fornecerTipoDePosicionavel().equals(TipoDePosicionavel.OURO)) {
				ouro = posicionavel;
			}
		}
		if (ouro != null) {
			posicaoDoGuerreiro.removerPosicionavel(ouro);
			return true;
		}
		return false;
	}

	public void guerreiroSair() {
		
	}

	public Celula fornecerCelula(Integer linha, Integer coluna) {
		if (foraDosLimites(linha, coluna)) {
			return new CelulaExterna(this, linha, coluna);
		}
		return tabuleiro.get(linha).get(coluna);
	}

	private Boolean foraDosLimites(Integer linha, Integer coluna) {
		return (linha < 0 || linha >= LINHAS || coluna < 0 || coluna >= COLUNAS);
	}

	private void construirTabuleiro() {
		tabuleiro = new ArrayList<List<Celula>>(LINHAS);
		for (Integer indiceDaLinha = 0; indiceDaLinha < LINHAS; indiceDaLinha++) {
			ArrayList<Celula> linha = new ArrayList<Celula>(COLUNAS);
			tabuleiro.add(indiceDaLinha, linha);
			for (Integer indiceDaColuna = 0; indiceDaColuna < COLUNAS; indiceDaColuna++) {
				linha.add(indiceDaColuna, new CelulaSimples(this, indiceDaLinha, indiceDaColuna));
			}
		}
	}

	private void construirEntidades() {
		posicionarGuerreiro();
		posicionarWumpus();
		posicionarBuracos();
		posicionarOuro();
		posicionarCheiros();
		posicionarBrisas();
		guerreiro.fornecerPosicao().receberAgente(guerreiro);
		wumpus.fornecerPosicao().receberAgente(wumpus);
	}

	private void posicionarGuerreiro() {
		Celula posicao = tabuleiro.get(LINHA_GUERREIRO).get(COLUNA_GUERREIRO);
		Celula direcao =  posicao.fornecerAdjacenteAoLeste();
		guerreiro = new Guerreiro(posicao, direcao);
		posicao.receberAgente(guerreiro);
	}

	private void posicionarWumpus() {
		Celula posicao = sortearCelulaSimplesVazia();
		wumpus = new Wumpus(posicao);
		posicao.receberAgente(wumpus);
	}

	private void posicionarOuro() {
		Celula posicao = sortearCelulaSimplesVazia();
		posicao.receberPosicionavel(new Ouro());
	}

	private void posicionarBuracos() {
		for (Integer contador = 0; contador < BURACOS; contador++) {
			Celula posicaoDoBuraco = sortearCelulaSimplesVazia();
			Integer linha = posicaoDoBuraco.fornecerLinha();
			Integer coluna = posicaoDoBuraco.fornecerColuna();
			Celula buraco = new CelulaBuraco(this, linha, coluna);
			tabuleiro.get(linha).set(coluna, buraco);
		}
	}

	private void posicionarBrisas() {
		for (List<Celula> linha : tabuleiro) {
			for (Celula celula : linha) {
				if (celula.fornecerTipoDeCelula().equals(TipoDeCelula.BURACO)) {
					Celula vizinhoAoNorte = celula.fornecerAdjacenteAoNorte();
					Celula vizinhoAoSul = celula.fornecerAdjacenteAoSul();
					Celula vizinhoAoLeste = celula.fornecerAdjacenteAoLeste();
					Celula vizinhoAoOeste = celula.fornecerAdjacenteAoOeste();
					vizinhoAoNorte.receberPosicionavel(new Brisa());
					vizinhoAoSul.receberPosicionavel(new Brisa());
					vizinhoAoLeste.receberPosicionavel(new Brisa());
					vizinhoAoOeste.receberPosicionavel(new Brisa());
				}
			}
		}
	}

	private void posicionarCheiros() {
		Celula posicaoDoWumpus = wumpus.fornecerPosicao();
		Celula vizinhoAoNorte = posicaoDoWumpus.fornecerAdjacenteAoNorte();
		Celula vizinhoAoSul = posicaoDoWumpus.fornecerAdjacenteAoSul();
		Celula vizinhoAoLeste = posicaoDoWumpus.fornecerAdjacenteAoLeste();
		Celula vizinhoAoOeste = posicaoDoWumpus.fornecerAdjacenteAoOeste();
		vizinhoAoNorte.receberPosicionavel(new Cheiro());
		vizinhoAoSul.receberPosicionavel(new Cheiro());
		vizinhoAoLeste.receberPosicionavel(new Cheiro());
		vizinhoAoOeste.receberPosicionavel(new Cheiro());
	}

	private Celula sortearCelulaSimplesVazia() {
		Celula celulaSorteada;
		do {
			Integer linha = geradorAleatorio.nextInt(LINHAS);
			Integer coluna = geradorAleatorio.nextInt(COLUNAS);
			celulaSorteada = tabuleiro.get(linha).get(coluna);
		} while (!celulaSorteada.fornecerTipoDeCelula().equals(TipoDeCelula.SIMPLES) || !celulaSorteada.vazia());
		return celulaSorteada;
	}
}
