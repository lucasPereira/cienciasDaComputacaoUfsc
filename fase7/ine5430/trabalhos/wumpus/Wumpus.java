import jason.asSyntax.Literal;
import jason.environment.Environment;

public final class Wumpus extends AgenteAbstrato {
	public Wumpus(Celula posicao) {
		super(posicao);
	}

	@Override
	public void perceberAgente(Agente agente, Celula celula) {
		agente.morrer();
	}

	@Override
	public TipoDePosicionavel fornecerTipoDePosicionavel() {
		return TipoDePosicionavel.WUMPUS;
	}

	@Override
	public TipoDeAgente fornecerTipoDeAgente() {
		return TipoDeAgente.WUMPUS;
	}
}
