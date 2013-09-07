public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		ColecaoInteiros colecao = new ColecaoInteiros(comunicaUsuario.pecaValores());
		
		String valoresColecao = colecao.fornecaStringValores();
		double mediaValores = colecao.fornecaMedia();
		int ocorrencia = comunicaUsuario.pecaOcorrencia();
		int posicaoPrimeiraOcorrencia = colecao.fornecaPrimeiraOcorrencia(ocorrencia);
		int posicao = comunicaUsuario.pecaPosicao();
		int valorPosicao = colecao.fornecaValorPosicao(posicao);
		int quantidadePares = colecao.fornecaQuantidadePares();
		int[] pares = colecao.fornecaValoresPares();
		
		comunicaUsuario.mostreColecao(valoresColecao, mediaValores, posicaoPrimeiraOcorrencia, ocorrencia, valorPosicao, posicao, quantidadePares, pares);
		
		ColecaoInteiros outraColecao = new ColecaoInteiros(comunicaUsuario.pecaValores());
		ColecaoInteiros uniaoColecao = new ColecaoInteiros (colecao.fornecaUniaoColecao(outraColecao));
		comunicaUsuario.mostreMensagem("União de Colecões:\n"+uniaoColecao.fornecaStringValores());
		
		colecao.invertaSelecao();
		comunicaUsuario.mostreMensagem("Colecao Invertida:\n"+colecao.fornecaStringValores());
		
		colecao.insiraValor2(comunicaUsuario.pecavalorInserirRemover(true));
		comunicaUsuario.mostreMensagem("Colecão com um valor adicionado:\n"+colecao.fornecaStringValores());
		
		boolean removeu = colecao.removaValor(comunicaUsuario.pecavalorInserirRemover(false));
		if(removeu)
		{
			comunicaUsuario.mostreMensagem("Colecão com um valor removido:\n"+colecao.fornecaStringValores());
		}
		else
		{
			comunicaUsuario.mostreMensagem("Não foi possível remover o valor da colecão pois o mesmo não se encontra nela.");
		}
		
		colecao.ordeneColecao();
		comunicaUsuario.mostreMensagem("Colecão Ordenada: "+colecao.fornecaStringValores());
	}
}
