public abstract class AgenteAbstrato extends PosicionavelAbstrato implements Agente {
	private Celula posicao;
	private Celula direcao;

	public AgenteAbstrato(Celula posicao) {
		this.posicao = posicao;
		this.direcao = posicao;
	}

	public AgenteAbstrato(Celula posicao, Celula direcao) {
		this.posicao = posicao;
		this.direcao = direcao;
	}

	@Override
	public void atualizarPercepcoes(AmbienteWumpus ambiente) {
		
	}

	@Override
	public final Celula fornecerPosicao() {
		return posicao;
	}

	@Override
	public void atualizarPosicao(Celula posicao) {
		this.posicao = posicao;
	}

	@Override
	public final Celula fornecerDirecao() {
		return direcao;
	}

	@Override
	public void atualizarDirecao(Celula direcao) {
		this.direcao = direcao;
	}

	@Override
	public void perceberBrisa() {
		
	}

	@Override
	public void perceberCheiro() {
		
	}

	@Override
	public void perceberBatida() {
		
	}

	@Override
	public void perceberGrito() {
		
	}

	@Override
	public void perceberBrilho() {
		
	}

	@Override
	public void virarParaEsquerda() {
		
	}

	@Override
	public void virarParaDireita() {
		
	}

	@Override
	public void andar() {
		
	}

	@Override
	public void atirar() {
		
	}

	@Override
	public void pegar(Posicionavel posicionavel) {
		
	}

	@Override
	public void soltar(Posicionavel posicionavel) {
		
	}

	@Override
	public void sair() {
		
	}

	@Override
	public void morrer() {
		
	}

	@Override
	public boolean equals(Object outro) {
		if (outro instanceof Agente) {
			TipoDeAgente meuTipo = fornecerTipoDeAgente();
			TipoDeAgente tipoDoOutro = ((Agente) outro).fornecerTipoDeAgente();
			return tipoDoOutro.equals(meuTipo);
		}
		return false;
	}
}
