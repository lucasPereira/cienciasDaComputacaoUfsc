//Aluno: Lucas Pereira - 10100754

import javax.swing.JOptionPane;
public class Interface 
{
	public Interface()
	{
		
	}
	
	public Quadrados pecaLados()
	{
		String valorLadoA = JOptionPane.showInputDialog("Insira o lado A do retângulo");
		double ladoA = Double.parseDouble(valorLadoA);
		String valorLadoB = JOptionPane.showInputDialog("Insira o lado B do retângulo");
		double ladoB = Double.parseDouble(valorLadoB);
		
		Quadrados quadrado = new Quadrados(ladoA, ladoB);
		return quadrado;
	}
	
	public void mostreRetangulo(double area, double perimetro, double diagonal)
	{
		JOptionPane.showMessageDialog(null, "Área do Retângulo: "+area+"\nPerimetro do Retângulo: "+perimetro+"\nDiagonal do Retângulo: "+diagonal);
	}
}