public final class CelulaSimples extends CelulaAbstrata {
	public CelulaSimples(MundoWumpus mundoWumpus, Integer linha, Integer coluna) {
		super(mundoWumpus, linha, coluna);
	}

	@Override
	public TipoDeCelula fornecerTipoDeCelula() {
		return TipoDeCelula.SIMPLES;
	}
}
