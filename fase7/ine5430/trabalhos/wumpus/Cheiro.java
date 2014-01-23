public final class Cheiro extends PosicionavelAbstrato {
	@Override
	public void perceberAgente(Agente agente, Celula celula) {
		agente.perceberCheiro();
	}

	@Override
	public TipoDePosicionavel fornecerTipoDePosicionavel() {
		return TipoDePosicionavel.CHEIRO;
	}
}
