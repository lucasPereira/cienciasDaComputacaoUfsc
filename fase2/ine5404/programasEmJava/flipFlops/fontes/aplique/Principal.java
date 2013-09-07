package aplique;
import producao.FlipFlopJK;
import producao.Interface;
import edugraf.jadix.Aplique;

public class Principal extends Aplique 
{
	public void iniciar() 
	{
		FlipFlopJK flipFlop = Interface.pecaJK(20);
		flipFlop.desenheOndasFlipFLopJK(flipFlop, 40, 0.11);
	}
}