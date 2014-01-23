import jason.asSyntax.Literal;
import jason.environment.Environment;

public final class Flecha extends AgenteAbstrato {
	public Flecha(Celula posicao, Celula direcao) {
		super(posicao, direcao);
	}

	@Override
	public TipoDePosicionavel fornecerTipoDePosicionavel() {
		return TipoDePosicionavel.FLECHA;
	}

	@Override
	public TipoDeAgente fornecerTipoDeAgente() {
		return TipoDeAgente.FLECHA;
	}
}
