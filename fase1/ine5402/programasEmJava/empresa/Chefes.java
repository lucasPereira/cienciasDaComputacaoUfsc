public class Chefes extends Funcionarios 
{
	private double gratificacaoChefia;
	
	public Chefes(String valorNome, double valorSalarioBase, double valorGratificacaoProducao, int valorDependentes, double valorGratificacaoChefia)
	{
		super(valorNome, valorSalarioBase, valorGratificacaoProducao, valorDependentes);
		
		gratificacaoChefia = valorGratificacaoChefia;
		if(gratificacaoChefia < 0)
		{
			gratificacaoChefia = gratificacaoChefia*(-1);
		}
	}
	
	public double fornecaGratificacaoChefia()
	{
		return gratificacaoChefia;
	}
	
	public double fornecaSalarioBruto()
	{
		//Método está sendo sobreposto
		return salarioBase+gratificacaoProducao+gratificacaoChefia;
	}
	
	public boolean altereGratificacaoChefia(double valorGratificacaoChefia)
	{
		if(valorGratificacaoChefia >= 0)
		{
			gratificacaoChefia = valorGratificacaoChefia;
			return true;
		}
		return false;
	}
}