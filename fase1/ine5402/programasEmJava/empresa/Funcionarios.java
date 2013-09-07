public class Funcionarios extends Pessoas  
{
	protected double salarioBase;
	protected double gratificacaoProducao;
	protected int dependentes;
	
	public Funcionarios(String valorNome, double valorSalarioBase, double valorGratificacaoProducao, int valorDependentes)
	{
		super(valorNome, 0, '*'); //Chama construtor da Super Classe
		
		salarioBase = valorSalarioBase;
		if(salarioBase < 0)
		{
			salarioBase=salarioBase*(-1);
		}
		
		gratificacaoProducao = valorGratificacaoProducao;
		if(gratificacaoProducao < 0)
		{
			gratificacaoProducao = gratificacaoProducao*(-1);
		}
		
		dependentes = valorDependentes;
		if(dependentes < 0)
		{
			dependentes = dependentes*(-1);
		}
	}
	
	public double fornecaSalarioBase()
	{
		return salarioBase;
	}
	
	public double fornecaGratificacaoProducao()
	{
		return gratificacaoProducao;
	}
	
	public double fornecaDependentes()
	{
		return dependentes;
	}
	
	public double fornecaSalarioBruto()
	{
		return salarioBase+gratificacaoProducao;
	}
	
	public double fornecaImposto()
	{
		double salarioBruto = this.fornecaSalarioBruto();
		
		if(salarioBruto <= 1000)
		{
			return 0;
		}
		
		if(salarioBruto <= 1800)
		{
			return salarioBruto*0.1-100;
		}
		
		return salarioBruto*0.25-370;
	}
	
	public double fornecaSalarioLiquido()
	{
		return this.fornecaSalarioBruto()-this.fornecaImposto(); 
	}
	
	public String fornecaAtributos()
	{
		return "\nDependentes: "+dependentes
		+"\nSalário Base: R$ "+salarioBase
		+"\nGratificacão de Producão: R$ "+gratificacaoProducao;
	}
	
	public boolean altereSalarioBase(double valorSalarioBase)
	{
		if(valorSalarioBase >= 0)
		{
			salarioBase = valorSalarioBase;
			return true;
		}
		return false;
	}
	
	public boolean altereGratificacaoProducao(double valorGratificacaoProducao)
	{
		if(valorGratificacaoProducao >= 0)
		{
			gratificacaoProducao = valorGratificacaoProducao;
			return true;
		}
		return false;
	}
	
	public boolean altereDependentes(int valorDependentes)
	{
		if(valorDependentes >= 0)
		{
			dependentes = valorDependentes;
			return true;
		}
		return false;
	}
}