public final class Brisa extends PosicionavelAbstrato {
	@Override
	public void perceberAgente(Agente agente, Celula celula) {
		agente.perceberBrisa();
	}

	@Override
	public TipoDePosicionavel fornecerTipoDePosicionavel() {
		return TipoDePosicionavel.BRISA;
	}
}
