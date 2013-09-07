package modelo.servidor;

import apliques.ApliqueServidor;
import comunicacaoEmRede.EnvioDeNumeroSorteado; 
import comunicacaoEmRede.RecebimentoNovoBingo;
import controle.IniciarTratadoresServidor;
import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.TEXTO;

public class FachadaServidor 
{	
	private boolean bingo;
	
	public FachadaServidor(ApliqueServidor aplique)
	{
		new EnvioDeNumeroSorteado();
		new IniciarTratadoresServidor(this);
		new RecebimentoNovoBingo(this).para(TEXTO);
		bingo = false;
	}
	
	public void iniciarServidor()
	{
		new Servidor(this);
	}
	
	public void bingo()
	{
		bingo = true;
	}
	
	public void semBingo()
	{
		bingo = false;
	}
	
	public boolean verificarSeJaFizeramBingo()
	{
		return bingo;
	}
	
	public void enviarNumeroSorteado(int numero)
	{
		new EnvioDeNumeroSorteado().enviarNumeroSorteado(numero);
	}
} 