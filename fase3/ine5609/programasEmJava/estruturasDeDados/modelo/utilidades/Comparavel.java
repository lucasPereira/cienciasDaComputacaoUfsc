package modelo.utilidades;

public interface Comparavel<T> extends Igualavel<T> 
{	
	public boolean verificarSeÉMaior(T outro);
	
	public boolean verificarSeÉMenor(T outro);
}
