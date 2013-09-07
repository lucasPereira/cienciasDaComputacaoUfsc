public class Apoio extends Funcionarios
{	
	public Apoio(String valorNome, double valorSalarioBase, double valorGratificacaoProducao, int valorDependentes)
	{
		super(valorNome, valorSalarioBase, valorGratificacaoProducao, valorDependentes);
	}
	
	public double fornecaAuxilioEducacao()
	{
		double auxilioEducacao = 60;
		
		if(dependentes >= 5)
		{
			return auxilioEducacao*5;
		}
		return dependentes*auxilioEducacao; 
	}
	
	public double fornecaSalarioBruto()
	{
		return salarioBase+gratificacaoProducao+this.fornecaAuxilioEducacao();
	}
	
	public double fornecaImposto()
	{
		double imposto = this.fornecaSalarioBruto()-this.fornecaAuxilioEducacao();
		
		if(imposto <= 1000)
		{
			return 0;
		}
		
		if(imposto <= 1800)
		{
			return imposto*0.1-100;
		}
		
		return imposto*0.25-370;
	}
}