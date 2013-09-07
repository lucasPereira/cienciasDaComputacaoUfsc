public class Principal 
{
	public static void main(String[] parametro)
	{
		Fila filaReparticao = new Fila();
		Pessoas pessoa;
		boolean continua = true;
		while(continua)
		{
			int opcao = Interface.mostreMenuPecaOpcao();
			switch(opcao)
			{
				case 1:
				{
					pessoa = Interface.pecaPessoa();
					filaReparticao.insiraPessoa(pessoa);
					Interface.mostreMensagem(pessoa.fornecaNome()+" foi inserido(a) na fila.");
					break;
				}
				case 2:
				{
					pessoa = filaReparticao.removaPessoa();
					if(pessoa == null)
					{
						Interface.mostreMensagem("Não há ninguém para ser atendido.");
					}
					else
					{
						Interface.mostreMensagem("Pessoa a ser atendida: "+pessoa.fornecaNome()+".");
					}
					break;
				}
				case 3:
				{
					String pessoaNaFila = Interface.pecaNomePessoaBuscar();
					boolean estaNaFila = filaReparticao.estaNaFila(pessoaNaFila);
					if(estaNaFila)
					{
						Interface.mostreMensagem(pessoaNaFila+" está na fila.");
					}
					else
					{
						Interface.mostreMensagem(pessoaNaFila+" não está na fila.");
					}
					break;
				}
				case 4:
				{
					int posicao = Interface.pecaPosicao();
					Pessoas pessoaNaPosicao = filaReparticao.fornecaPessoaNaPosicao(posicao-1);
					if(pessoaNaPosicao != null)
					{
						Interface.mostreMensagem(
						pessoaNaPosicao.fornecaNome()
						+"\nSexo: "+pessoaNaPosicao.fornecaSexo()
						+"\nIdade: "+pessoaNaPosicao.fornecaIdade()
						+"\nPosicao na fila: "+posicao
						);
					}
					else
					{
						Interface.mostreMensagem("Não existe niguém na posicao "+posicao+" na fila.");
					}
					break;
				}
				case 5:
				{
					if(filaReparticao.filaVazia())
					{
						Interface.mostreMensagem("Não há ninguém na fila para listar.");
					}
					else
					{
						String[] nomePessoasNafila = filaReparticao.fornecaNomes();
						String nomes = "";
						for(int cont = 0; cont < filaReparticao.fornecaTamanhoDaFila(); cont++)
						{
							nomes += (cont+1)+". "+nomePessoasNafila[cont]+".\n";
						}
						Interface.mostreMensagem(nomes);
					}
					break;
				}
				case 6:
				{
					if(!filaReparticao.filaVazia())
					{
						int tamanho = filaReparticao.fornecaTamanhoDaFila();
						int somaIdades = 0;
						for(int cont = 0; cont < tamanho; cont++)
						{
							somaIdades += filaReparticao.fornecaIdade(cont);
						}
						double mediaIdades = (double)somaIdades/tamanho;
						Interface.mostreMensagem("Média de idade das pessoas na fila: "+mediaIdades);
					}
					else
					{
						Interface.mostreMensagem("Não há ninguém na fila.");
					}
					break;
				}
				case 7:
				{
					if(!filaReparticao.filaVazia())
					{
						int tamanho = filaReparticao.fornecaTamanhoDaFila();
						int idadePessoaMaisVelha = 0;
						Pessoas pessoaMaisVelha = null;
						for(int cont = 0; cont < tamanho; cont++)
						{
							if(idadePessoaMaisVelha < filaReparticao.fornecaIdade(cont))
							{
								idadePessoaMaisVelha = filaReparticao.fornecaIdade(cont);
								pessoaMaisVelha = filaReparticao.fornecaPessoaNaPosicao(cont);
							}
						}
						Interface.mostreMensagem(
						"Pessoa mais velha: "
						+pessoaMaisVelha.fornecaNome()
						+"\nSexo: "+pessoaMaisVelha.fornecaSexo()
						+"\nIdade: "+pessoaMaisVelha.fornecaIdade()
						);
					}
					else
					{
						Interface.mostreMensagem("Não há ninguém na fila.");
					}
					break;
				}
				case 8:
				{
					continua = false;
					break;
				}
				default:
				{
					Interface.mostreMensagem("Opcão inválida.");
				}
			}
		}
	}
}