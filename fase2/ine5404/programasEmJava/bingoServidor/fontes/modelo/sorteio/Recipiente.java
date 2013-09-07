package modelo.sorteio;

import java.util.ArrayList;
import java.util.List;

public class Recipiente implements TipoRecipiente
{
	private static final int ZERO = 0;
	
	private List<Integer> bolinhas;
	
	public Recipiente()
	{
		bolinhas = new ArrayList<Integer>();
	}
	
	public final int fornecerQuantidadeDeBolinhas()
	{
		return bolinhas.size();
	}

	public final void guardarBolinha(int valorBolinha)
	{
		assert (valorBolinha > ZERO) : "Valor da bolinha deve ser maior que zero.";
		
		if(!verificarSeValorEstaNoRecipiente(valorBolinha))
		{
			bolinhas.add(valorBolinha);
		}
	}
	
	public final boolean verificarSeValorEstaNoRecipiente(int valor)
	{
		return bolinhas.contains(valor);
	}
}