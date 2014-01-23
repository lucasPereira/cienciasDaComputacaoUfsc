public final class CelulaBuraco extends CelulaAbstrata {
	public CelulaBuraco(MundoWumpus mundoWumpus, Integer linha, Integer coluna) {
		super(mundoWumpus, linha, coluna);
	}

	@Override
	public TipoDeCelula fornecerTipoDeCelula() {
		return TipoDeCelula.BURACO;
	}

	@Override
	public void receberAgente(Agente agente) {
		agente.morrer();
	}

}
