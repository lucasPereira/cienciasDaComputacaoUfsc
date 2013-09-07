public class Principal 
{
	public static void main(String[] paramentro)
	{
		Interface comunicaUsuario = new Interface();
		Funcionarios funcionarioMaiorSalarioBruto = null;
	
		int numeroFuncionarios = comunicaUsuario.pecaNumeroFuncionarios();
		double maiorSalarioBruto = 0;
	
		for(int cont = 0; cont < numeroFuncionarios; cont++)
		{
			Funcionarios funcionario = comunicaUsuario.pecaFuncionario();
			comunicaUsuario.mostreFuncionario(funcionario);
			
			if(!(funcionario  instanceof Chefes || funcionario instanceof Apoio))
			{
				double salarioBruto = funcionario.fornecaSalarioBruto();
				if(salarioBruto >= maiorSalarioBruto)
				{
					maiorSalarioBruto = salarioBruto;
					funcionarioMaiorSalarioBruto = funcionario;
				}
			}
		}
		
		if(funcionarioMaiorSalarioBruto != null)
		{
			comunicaUsuario.mostreFuncionario(funcionarioMaiorSalarioBruto);
		}
		else
		{
			comunicaUsuario.mostreMensagem("Nenhum funcionário comum foi inserido.");
		}
	}
}