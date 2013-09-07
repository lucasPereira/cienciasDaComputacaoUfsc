package aplique;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class UmAplique extends Aplique {

	private ComponenteDix grade;
	
	public void iniciar() 
	{
		grade = obterPaginaDix().criarComponente(TiposDeComponentesDix.GRADE, "gradeDinamica");
		grade.fixarLinhasEColunas(4, 5);
		grade.fixarAltura(500);
		grade.fixarLargura(400);
	}
}