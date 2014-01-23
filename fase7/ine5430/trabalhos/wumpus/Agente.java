public interface Agente extends Posicionavel {
	public TipoDeAgente fornecerTipoDeAgente();

	public void atualizarPercepcoes(AmbienteWumpus ambiente);

	public Celula fornecerPosicao();

	public void atualizarPosicao(Celula posicao);

	public Celula fornecerDirecao();

	public void atualizarDirecao(Celula direcao);

	public void perceberBrisa();

	public void perceberCheiro();

	public void perceberBatida();

	public void perceberGrito();

	public void perceberBrilho();

	public void virarParaEsquerda();

	public void virarParaDireita();

	public void andar();

	public void atirar();

	public void pegar(Posicionavel posicionavel);

	public void soltar(Posicionavel posicionavel);

	public void sair();

	public void morrer();
}
