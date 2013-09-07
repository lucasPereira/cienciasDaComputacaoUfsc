public class Principal 
{
	public static void main(String[] parametro)
	{
		String s1 = " UFSC  ";
		String s2 = "Universidade Federal de Santa Catarina";
		
		//Método length
		int tamanho = s1.length();
		System.out.println(tamanho);
		
		//Método charAt
		char letra = s2.charAt(7);
		System.out.println(letra);
		
		//Método equals
		boolean igual = s1.equals(s2);
		System.out.print(igual);
		igual = s1.equals(s1);
		System.out.println(" "+igual);
		
		//Método compareTo
		int x = s1.compareTo(s2);
		System.out.print(x);
		x = s2.compareTo(s1);
		System.out.print(" "+x);
		x = s1.compareTo(s1);
		System.out.println(" "+x);
	}
}
