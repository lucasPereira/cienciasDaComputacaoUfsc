import javax.swing.JOptionPane;
public class Interface
{
	public Interface()
	{
		
	}
	
	public double pecaRaio()
	{
		String valorRaioDigitado = JOptionPane.showInputDialog("Digite o raio do circulo");
		double valorRaioTransformado = Double.parseDouble(valorRaioDigitado);
		return valorRaioTransformado;
	}
	
	public void imprimaArea(double area)
	{
		JOptionPane.showMessageDialog(null, "A area calculada e': "+area);
	}
}