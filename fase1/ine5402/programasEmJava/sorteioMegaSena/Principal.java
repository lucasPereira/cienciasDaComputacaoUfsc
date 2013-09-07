//Aluno: Lucas Pereira da Silva - 10100754

public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		Sorteio sorteados = new Sorteio();
		
		sorteados.ordeneSorteio();
		int[] numerosSorteados = sorteados.fornecaSorteio();	
		//OBS: É realizado apenas um sorteio para todos apostadores.
		char inserir;
		double valorTotalApostado = 0.0;
		
		do
		{
			Apostadores apostador = comunicaUsuario.pecaApostador();
			int[] numerosApostados = apostador.fornecaNumerosApostados();
			int quantidadeNumerosApostados = numerosApostados.length;
			switch(quantidadeNumerosApostados)
			{
				case 6: valorTotalApostado += 1.00;
				break;
				case 7: valorTotalApostado += 7.00;
				break;
				case 8: valorTotalApostado += 28.00;
				break;
				case 9: valorTotalApostado += 168.00;
				break;
				case 10: valorTotalApostado += 1260.00;
			}
			int acertos = sorteados.fornecaNumeroAcertos(numerosApostados);
			comunicaUsuario.mostreApostadorMegaSena(numerosApostados, numerosSorteados, acertos, apostador.fornecaNome());
			inserir = comunicaUsuario.pecaInserirApostador();
		}
		while(inserir == 's');
		
		comunicaUsuario.mostreMensagem("Valor total gasto pelos apostadores: R$ "+valorTotalApostado);
	}
}