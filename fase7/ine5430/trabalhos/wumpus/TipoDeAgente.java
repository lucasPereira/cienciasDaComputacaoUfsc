public enum TipoDeAgente {
	FLECHA,
	GUERREIRO,
	WUMPUS;

	public String fornecerNome() {
		return toString().toLowerCase();
	}
}
