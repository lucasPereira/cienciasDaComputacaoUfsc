//Aluno: Lucas Pereira da Silva

public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		Contas conta = new Contas(000, 0, -30);
		
		int operacao = 1;
		
		while(operacao == 1 || operacao == 2 || operacao == 3)
		{
			operacao = comunicaUsuario.pecaOperacao();
			if(operacao == 1)
			{
				double valorDeposito = comunicaUsuario.pecaValorDeposito();
				boolean deposito = conta.deposite(valorDeposito);
				comunicaUsuario.mostreDeposito(deposito);
			}
			else
			{
				if(operacao == 2)
				{
					double valorSaque = comunicaUsuario.pecaValorSaque();
					if(conta.fornecaSaldo() != conta.fornecaLimiteSaqueNegativo())
					{
						double saque = conta.saque(valorSaque);
						comunicaUsuario.mostreSaque(saque);
					}
					else
					{
						comunicaUsuario.mostreMensagem("Não foi possivel realizar o saque pois você ultrapassou o limite de saque negativo.");
					}	
				}
				else
				{
					if(operacao == 3)
					{
						comunicaUsuario.mostreSaldo(conta.fornecaSaldo(), conta.fornecaLimiteSaqueNegativo());
					}
					else
					{
						comunicaUsuario.mostreMensagem("O Gold Bank agradece a sua preferencia. Volte sempre.");
					}
				}
			}
		}
	}
}