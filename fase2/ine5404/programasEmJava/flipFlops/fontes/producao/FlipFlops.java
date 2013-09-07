package producao;
import edugraf.jadix.fachada.Pichador;
import edugraf.pichador.Cor;
import edugraf.pichador.TipoPichador;

public class FlipFlops 
{
	protected boolean transicao;
	protected int delay;
	public FlipFlops(boolean valorTransicao, int valorDelay)
	{
		transicao = valorTransicao;

		if(valorDelay < 0 || valorDelay > 20)
		{
			delay = 0;
		}
		else
		{
			delay = valorDelay;
		}
	}
	
	public int fornecaEsquerda()
	{
		return -360;
	}
	
	public int fornecaTopo()
	{
		return 190;
	}
	
	public void desenheOndasFlipFLopJK(FlipFlopJK flipFlop, int comprimentoDeOnda, double velocidade)
	{
		int topo = this.fornecaTopo();	
		this.desenheLinhasVerticais(comprimentoDeOnda);
		
		new Pichador().semRastros().andarPara(-380, topo).comRastros().escrever("Clk");
		this.desenheClock(comprimentoDeOnda, 0.03);
		
		topo -= comprimentoDeOnda + 20;
		new Pichador().semRastros().andarPara(-380, topo).comRastros().escrever("J");
		this.desenheOndas(flipFlop.valoresJ, comprimentoDeOnda, velocidade, topo);
		
		topo -= comprimentoDeOnda + 20;
		new Pichador().semRastros().andarPara(-380, topo).comRastros().escrever("K");
		this.desenheOndas(flipFlop.valoresK, comprimentoDeOnda, velocidade, topo);
		
		topo -= comprimentoDeOnda + 20;
		new Pichador().semRastros().andarPara(-380, topo).comRastros().escrever("Q (Fazer)");
		
		topo -= comprimentoDeOnda + 20;
		new Pichador().semRastros().andarPara(-380, topo).comRastros().escrever("~Q (Fazer)");
	}
	

	public void desenheClock(int comprimentoDeOnda, double velocidade)
	{	
		Cor corTransicaoPositiva;
		Cor corTransicaoNegativa;
		if(transicao)
		{
			corTransicaoPositiva = Cor.VERMELHO;
			corTransicaoNegativa = Cor.PRETO;
		}
		else
		{
			corTransicaoNegativa = Cor.VERMELHO;
			corTransicaoPositiva = Cor.PRETO;
		}
		boolean anterior = transicao;
		
		TipoPichador ondas = new Pichador().semRastros().andarPara(this.fornecaEsquerda(), this.fornecaTopo()).fixarEspessura(3).comRastros();
		for(int cont = 0; cont < 16; cont++)
		{
			if(cont == 0)
			{
				if(anterior && cont == 0)
				{
					ondas.semRastros().frente(comprimentoDeOnda).comRastros();
				}
				ondas.direita(90).frente(comprimentoDeOnda).direita(-90).descansar(velocidade);
			}
			
			if(anterior)
			{
				ondas.direita(180).fixarCorDosRastros(corTransicaoNegativa).frente(comprimentoDeOnda).fixarCorDosRastros(Cor.PRETO).descansar(velocidade).direita(-90).frente(comprimentoDeOnda).direita(-90).descansar(velocidade);
				anterior = false;
			}
			else
			{
				ondas.fixarCorDosRastros(corTransicaoPositiva).frente(comprimentoDeOnda).fixarCorDosRastros(Cor.PRETO).descansar(velocidade).direita(90).frente(comprimentoDeOnda).direita(-90).descansar(velocidade);
				anterior = true;
			}
		}
	}
		
	public void desenheOndas(boolean[] niveisLogicos, int comprimentoDeOnda, double velocidade, int posicaoY)
	{
		boolean anterior = niveisLogicos[0];
		
		TipoPichador ondas = new Pichador().semRastros().fixarEspessura(3).andarPara(this.fornecaEsquerda(), posicaoY).comRastros();
		for(int contA = 0; contA < 2; contA++)
		{
			for(int contB = 0; contB < 4; contB++)
			{
				if(anterior == niveisLogicos[contB])
				{
					if(contA == 0 && contB == 0)
					{
						if(anterior)
						{
							ondas.semRastros().frente(comprimentoDeOnda).comRastros();
						}
						ondas.direita(90).frente(delay).direita(-90).descansar(velocidade);
					}
					ondas.direita(90).frente(2*comprimentoDeOnda).direita(-90).descansar(velocidade);
				}
				else
				{
					if(anterior)
					{
						ondas.direita(180).frente(comprimentoDeOnda).descansar(velocidade).direita(-90).frente(2*comprimentoDeOnda).direita(-90).descansar(velocidade);
						anterior = false;
					}
					else
					{
						ondas.frente(comprimentoDeOnda).descansar(velocidade).direita(90).frente(2*comprimentoDeOnda).direita(-90).descansar(velocidade);
						anterior = true;
					}
				}
			}
		}
	}
	
	public void desenheLinhasVerticais(int comprimentoDeOnda)
	{
		TipoPichador linhasVerticais = new Pichador();
		linhasVerticais.semRastros().andarPara(this.fornecaEsquerda(), 260).fixarCorDosRastros(Cor.CINZA_CLARO).comRastros().direita(180).frente(510);
		boolean mudarDirecao = true;
		for(int cont = 0; cont < 20; cont++)
		{
			if(mudarDirecao)
			{
				linhasVerticais.direita(-90).frente(comprimentoDeOnda).direita(-90).frente(510);
				mudarDirecao = false;
			}
			else
			{
				linhasVerticais.direita(90).frente(comprimentoDeOnda).direita(90).frente(510);
				mudarDirecao = true;
			}
		}
	}
}
