import jason.asSyntax.Literal;
import jason.environment.Environment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class Guerreiro extends AgenteAbstrato {
	private Set<Celula> mapaDeBrisas;
	private Set<Celula> mapaDeParedes;
	private Set<Celula> mapaDeBrilhos;
	private Set<Celula> mapaDeCheiros;
	private Boolean vivo;

	public Guerreiro(Celula posicao, Celula direcao) {
		super(posicao, direcao);
		mapaDeBrisas = new HashSet<Celula>();
		mapaDeParedes = new HashSet<Celula>();
		mapaDeBrilhos = new HashSet<Celula>();
		mapaDeCheiros = new HashSet<Celula>();
		vivo = true;
	}

	@Override
	public TipoDePosicionavel fornecerTipoDePosicionavel() {
		return TipoDePosicionavel.GUERREIRO;
	}

	@Override
	public TipoDeAgente fornecerTipoDeAgente() {
		return TipoDeAgente.GUERREIRO;
	}

	@Override
	public void atualizarPercepcoes(AmbienteWumpus ambiente) {
		String nome = fornecerTipoDeAgente().fornecerNome();
		adicionarPercepcaoPosicao(nome, ambiente);
		adicionarPercepcaoDirecao(nome, ambiente);
		adicionarPercepcaoCheiros(nome, ambiente);
		adicionarPercepcaoBrisas(nome, ambiente);
		adicionarPercepcaoBrilhos(nome, ambiente);
		adicionarPercepcaoParedes(nome, ambiente);
		adicionarPercepcaoVivo(nome, ambiente);
	}

	@Override
	public void perceberCheiro() {
		Celula posicaoDoCheiro = fornecerPosicao();
		mapaDeCheiros.add(posicaoDoCheiro);
	}

	@Override
	public void perceberBrisa() {
		Celula posicaoDaBrisa = fornecerPosicao();
		mapaDeBrisas.add(posicaoDaBrisa);
	}

	@Override
	public void perceberBrilho() {
		Celula posicaoDoBrilho = fornecerPosicao();
		mapaDeBrilhos.add(posicaoDoBrilho);
	}

	@Override
	public void perceberBatida() {
		Celula velhaPosicao = fornecerPosicao();
		Celula velhaDirecao = fornecerDirecao();
		Celula novaPosicao = velhaDirecao.fornecerDirecaoContraria(velhaPosicao);
		this.atualizarPosicao(novaPosicao);
		this.atualizarDirecao(velhaPosicao);
		velhaPosicao.removerAgente(this);
		novaPosicao.receberAgente(this);
		mapaDeParedes.add(velhaPosicao);
	}

	@Override
	public void virarParaEsquerda() {
		Celula posicao = fornecerPosicao();
		Celula velhaDirecao = fornecerDirecao();
		Celula novaDirecao = velhaDirecao.fornecerDirecaoParaEsquerda(posicao);
		atualizarDirecao(novaDirecao);
	}

	@Override
	public void virarParaDireita() {
		Celula posicao = fornecerPosicao();
		Celula velhaDirecao = fornecerDirecao();
		Celula novaDirecao = velhaDirecao.fornecerDirecaoParaDireita(posicao);
		atualizarDirecao(novaDirecao);
	}

	@Override
	public void andar() {
		Celula velhaPosicao = fornecerPosicao();
		Celula novaPosicao = fornecerDirecao();
		Celula novaDirecao = velhaPosicao.fornecerNovaDirecao(novaPosicao);
		atualizarPosicao(novaPosicao);
		atualizarDirecao(novaDirecao);;
		velhaPosicao.removerAgente(this);
		novaPosicao.receberAgente(this);
	}

	@Override
	public void morrer() {
		vivo = false;
	}

	private void adicionarPercepcaoPosicao(String nomeDoAgente, AmbienteWumpus ambiente) {
		Celula posicao = fornecerPosicao();
		String percepcao = String.format("posicao(%d, %d)", posicao.fornecerColuna(), posicao.fornecerLinha());
		ambiente.addPercept(nomeDoAgente, Literal.parseLiteral(percepcao));
	}

	private void adicionarPercepcaoDirecao(String nomeDoAgente, AmbienteWumpus ambiente) {
		Celula direcao = fornecerDirecao();
		String percepcao = String.format("direcao(%d, %d)", direcao.fornecerColuna(), direcao.fornecerLinha());
		ambiente.addPercept(nomeDoAgente, Literal.parseLiteral(percepcao));
	}

	private void adicionarPercepcaoCheiros(String nomeDoAgente, AmbienteWumpus ambiente) {
		for (Celula cheiro : mapaDeCheiros) {
			String percepcao = String.format("cheiro(%d, %d)", cheiro.fornecerColuna(), cheiro.fornecerLinha());
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral(percepcao));
		}
		if (mapaDeCheiros.contains(fornecerPosicao())) {
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral("cheiro"));
		}
	}

	private void adicionarPercepcaoBrisas(String nomeDoAgente, AmbienteWumpus ambiente) {
		for (Celula brisa : mapaDeBrisas) {
			String percepcao = String.format("brisa(%d, %d)", brisa.fornecerColuna(), brisa.fornecerLinha());
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral(percepcao));
		}
		if (mapaDeBrisas.contains(fornecerPosicao())) {
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral("brisa"));
		}
	}

	private void adicionarPercepcaoBrilhos(String nomeDoAgente, AmbienteWumpus ambiente) {
		for (Celula brilho : mapaDeBrilhos) {
			String percepcao = String.format("brilho(%d, %d)", brilho.fornecerColuna(), brilho.fornecerLinha());
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral(percepcao));
		}
		if (mapaDeBrilhos.contains(fornecerPosicao())) {
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral("brilho"));
		}
	}

	private void adicionarPercepcaoParedes(String nomeDoAgente, AmbienteWumpus ambiente) {
		for (Celula parede : mapaDeParedes) {
			String percepcao = String.format("parede(%d, %d)", parede.fornecerColuna(), parede.fornecerLinha());
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral(percepcao));
		}
	}

	private void adicionarPercepcaoVivo(String nomeDoAgente, AmbienteWumpus ambiente) {
		if (vivo) {
			ambiente.addPercept(nomeDoAgente, Literal.parseLiteral("vivo"));
		}
	}
}
