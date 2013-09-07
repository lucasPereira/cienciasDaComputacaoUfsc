//Aluno: Lucas Pereira da Silva - 10100754

public class Relogios 
{
	private int h;
	private int m;
	private int s;
	
	public Relogios(int valorH, int valorM, int valorS)
	{
		if(valorH >= 0 && valorH <= 24)
		{	
			h = valorH;
		}
		else
		{
			h = 0;
		}
		
		if(valorM >= 0 && valorM <= 60)
		{
			m = valorM;
		}
		else
		{
			m = 0;
		}

		if(valorM >= 0 && valorM <= 60)
		{
			s = valorS;
		}
		else
		{
			s = 0;
		}
	}
	
	public Relogios()
	{
		h = 0;
		m = 0;
		s = 0;
	}
	
	public void tictac()
	{
		s++;
	
		/*Qualquer valor dado para as horas, minutos e segundos será corigido mostrado assim o valor correto. Por exemplo se o horário recebido for 23:800:125 então após passar pelos IFs abaixo o horário correto será retornado que é: 12:22:5*/
		if(s > 59)
		{
			m = m+s/60;
			s = s%60;
		}
		if(m > 59)
		{
			h = h+m/60;
			m = m%60;
		}
		if(h > 23)
		{
			h = 0+h%24;
		}
	}
	
	public String fornecaHorario()
	{
		return h+":"+m+":"+s;
	}
}