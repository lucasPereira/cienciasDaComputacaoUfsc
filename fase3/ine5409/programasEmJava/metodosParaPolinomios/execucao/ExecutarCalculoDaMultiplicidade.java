package execucao;

import modelo.CalculoDaMultiplicidade;
import utilidades.SuperArray;

public class ExecutarCalculoDaMultiplicidade 
{
	public static void main(String[] args)
	{
		SuperArray coeficientes = new SuperArray(1, 6);
		coeficientes.atribuir(1, 1);
		coeficientes.atribuir(2, -1);
		coeficientes.atribuir(3, -5);
		coeficientes.atribuir(4, 1);
		coeficientes.atribuir(5, 8);
		coeficientes.atribuir(6, 4);
		int multiplicidade = CalculoDaMultiplicidade.calcularMultiplicidade(5, -1, coeficientes, 0);
		System.out.println(multiplicidade);
	}
}
