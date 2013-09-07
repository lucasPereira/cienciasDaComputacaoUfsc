public class Mdc 
{
	public Mdc()
	{
		
	}
	
	public int fornecaMdc(int x, int y)
	{
		if((x <= 0 ) || (y <= 0 ))
		{
			return Integer.MAX_VALUE;
		}
		
		while(x != y)
		{
			if(x > y)
			{
				x = x-y;
			}
			else
			{
				y = y-x;
			}
		}
		return y;
	}
}
