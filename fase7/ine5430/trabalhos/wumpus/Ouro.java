public final class Ouro extends PosicionavelAbstrato {
	@Override
	public void perceberAgente(Agente agente, Celula celula) {
		agente.perceberBrilho();
	}

	@Override
	public TipoDePosicionavel fornecerTipoDePosicionavel() {
		return TipoDePosicionavel.OURO;
	}
}
