package modelo.estruturasLineares.lista;

import modelo.caixaDoElemento.CaixaDuplaDoElemento;
import modelo.execoes.execoesDeLista.ExecaoDeListaVazia;

public final class ListaComCursorDuplamenteEncadeadaComAlocacaoDinamica<E>
{
	private CaixaDuplaDoElemento<E> cursor;
	private CaixaDuplaDoElemento<E> caixaDuplaDoPrimeiroElemento;
	private CaixaDuplaDoElemento<E> caixaDuplaDoUltimoElemento;
	
	private static final int ZERO = 0;
	
	public boolean buscar(E elemento)
	{
		if (verificarSeEstaVazia()) return false;		
		CaixaDuplaDoElemento<E> caixaDuplaAuxiliar = caixaDuplaDoPrimeiroElemento;
		CaixaDuplaDoElemento<E> caixaDuplaFalsaDoElmentoBuscado = new CaixaDuplaDoElemento<E>(elemento);
		caixaDuplaDoUltimoElemento.receberCaixaDuplaDoElementoPosterior(caixaDuplaFalsaDoElmentoBuscado);
		while (!caixaDuplaAuxiliar.fornecerElemento().equals(elemento))
		{
			caixaDuplaAuxiliar = caixaDuplaAuxiliar.fornecerCaixaDuplaDoElementoPosterior();
		}
		caixaDuplaDoUltimoElemento.receberCaixaDuplaDoElementoPosterior(null);
		if (!caixaDuplaFalsaDoElmentoBuscado.equals(caixaDuplaAuxiliar))
		{
			cursor = caixaDuplaAuxiliar;
			return true;
		}
		
		return false;
	}
	
	public E acessar()
	{
		lancarExecaoDeListaVaziaSeNecessario();
		
		return cursor.fornecerElemento();
	}
	
	public void excluir()
	{
		lancarExecaoDeListaVaziaSeNecessario();
		CaixaDuplaDoElemento<E> caixaDuplaDoElementoAnterior = cursor.fornecerCaixaDuplaDoElementoAnteriror();
		CaixaDuplaDoElemento<E> caixaDuplaDoElementoPosterior = cursor.fornecerCaixaDuplaDoElementoPosterior();
		cursor = caixaDuplaDoElementoPosterior;
		if (cursor.verificarSePossuiElementoAnteriror())
		{
			caixaDuplaDoElementoAnterior.receberCaixaDuplaDoElementoPosterior(caixaDuplaDoElementoPosterior);
			cursor = caixaDuplaDoElementoAnterior;
		}
		if (cursor.verificarSePossuiElementoPosterior())
		{
			caixaDuplaDoElementoPosterior.receberCaixaDuplaDoElementoAnterior(caixaDuplaDoElementoAnterior);
		}
	}
	
	public void inserirAntes(E elemento)
	{
		if (verificarSeEstaVazia())
		{
			cursor = new CaixaDuplaDoElemento<E>(elemento);
			caixaDuplaDoPrimeiroElemento = cursor;
			caixaDuplaDoUltimoElemento = cursor;
		}
		else
		{
			CaixaDuplaDoElemento<E> caixaDuplaAnteriorAoCursor = cursor.fornecerCaixaDuplaDoElementoAnteriror();
			CaixaDuplaDoElemento<E> caixaDuplaDoNovoElemento = new CaixaDuplaDoElemento<E>(elemento);
			caixaDuplaDoNovoElemento.receberCaixaDuplaDoElementoAnterior(caixaDuplaAnteriorAoCursor);
			caixaDuplaDoNovoElemento.receberCaixaDuplaDoElementoPosterior(cursor);
			if (cursor.verificarSePossuiElementoAnteriror())
			{
				caixaDuplaAnteriorAoCursor.receberCaixaDuplaDoElementoPosterior(caixaDuplaDoNovoElemento);
			}
			cursor.receberCaixaDuplaDoElementoAnterior(new CaixaDuplaDoElemento<E>(elemento));
			irParaPrimeiro(caixaDuplaDoPrimeiroElemento);
		}
	}
	
	public void inserirDepois(E elemento)
	{
		if (verificarSeEstaVazia())
		{
			cursor = new CaixaDuplaDoElemento<E>(elemento);
			caixaDuplaDoPrimeiroElemento = cursor;
			caixaDuplaDoUltimoElemento = cursor;
		}
		else
		{
			CaixaDuplaDoElemento<E> caixaDuplaPosteriorAoCursor = cursor.fornecerCaixaDuplaDoElementoPosterior();
			CaixaDuplaDoElemento<E> caixaDuplaDoNovoElemento = new CaixaDuplaDoElemento<E>(elemento);
			caixaDuplaDoNovoElemento.receberCaixaDuplaDoElementoAnterior(caixaDuplaPosteriorAoCursor);
			caixaDuplaDoNovoElemento.receberCaixaDuplaDoElementoAnterior(cursor);
			if (cursor.verificarSePossuiElementoPosterior())
			{
				caixaDuplaPosteriorAoCursor.receberCaixaDuplaDoElementoAnterior(caixaDuplaDoNovoElemento);
			}
			cursor.receberCaixaDuplaDoElementoPosterior(caixaDuplaDoNovoElemento);
			irParaUltimo(caixaDuplaDoUltimoElemento);
		}
	}
	
	public void irParaPrimeiro()
	{
		irParaPrimeiro(cursor);
	}
	
	public void irParaUltimo()
	{
		irParaUltimo(cursor);
	}
	
	public void avancarKElementos(int k)
	{
		while (cursor.verificarSePossuiElementoPosterior() && (k > ZERO))
		{
			cursor = cursor.fornecerCaixaDuplaDoElementoPosterior();
			k--;
		}
	}
	
	public void retrocederKElementos(int k)
	{
		while (cursor.verificarSePossuiElementoAnteriror() && (k > ZERO))
		{
			cursor = cursor.fornecerCaixaDuplaDoElementoAnteriror();
			k--;
		}
	}
	
	private boolean verificarSeEstaVazia()
	{
		return (caixaDuplaDoPrimeiroElemento == null && caixaDuplaDoUltimoElemento == null && cursor == null);
	}
	
	private void irParaPrimeiro(CaixaDuplaDoElemento<E> caixaDuplaDoElmento)
	{
		while (caixaDuplaDoElmento.verificarSePossuiElementoAnteriror())
		{
			caixaDuplaDoElmento = caixaDuplaDoElmento.fornecerCaixaDuplaDoElementoAnteriror();
		}
	}
	
	private void irParaUltimo(CaixaDuplaDoElemento<E> caixaDuplaDoElmento)
	{
		while (caixaDuplaDoElmento.verificarSePossuiElementoPosterior())
		{
			caixaDuplaDoElmento = caixaDuplaDoElmento.fornecerCaixaDuplaDoElementoPosterior();
		}
	}
	
	private void lancarExecaoDeListaVaziaSeNecessario()
	{
		if (verificarSeEstaVazia()) throw new ExecaoDeListaVazia();
	}
}