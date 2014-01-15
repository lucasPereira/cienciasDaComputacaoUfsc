package br.ufsc.inf.ine5426.caneca.maquina;

import br.ufsc.inf.ine5426.caneca.interno.ExpressaoInstanciacao;
import br.ufsc.inf.ine5426.caneca.interno.TabelaDeSimbolos;
import br.ufsc.inf.ine5426.caneca.interno.Tipo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

public class MaquinaCaneca {
	protected Contexto areaDeDados = new Contexto();
	protected ArrayList<Codigo> areaDeCodigo;
	protected Stack<Valor> pilhaDeDados;
	protected Stack<Contexto> pilhaDeContextos;
	protected Stack<Integer> pilhaDeExecucao;
	protected Integer contadorDePrograma;
	
	public MaquinaCaneca() {
		areaDeDados = new Contexto();
		areaDeCodigo = new ArrayList<Codigo>();
		pilhaDeDados = new Stack<Valor>();
		pilhaDeExecucao = new Stack<Integer>();
		pilhaDeContextos = new Stack<Contexto>();
		contadorDePrograma = 0;
	}
	
	public ArrayList<Codigo> gerarCodigo(TabelaDeSimbolos tabelaDeSimbolos, String nomeDaClassePrincipal) {
		areaDeCodigo.add(new CodigoInstanciar(nomeDaClassePrincipal));
		areaDeCodigo.add(new CodigoExtrairContexto());
		areaDeCodigo.add(new CodigoChamar("construtor", 4));
		areaDeCodigo.add(new CodigoResolverSimbolo("esse"));
		areaDeCodigo.add(new CodigoFecharContexto());
		areaDeCodigo.add(new CodigoSair());
		tabelaDeSimbolos.gerarCodigo(areaDeCodigo, areaDeDados);
		return areaDeCodigo;
	}
	
	public void executar() {
		Integer fimDoCodigo = areaDeCodigo.size();
		pilhaDeContextos.push(areaDeDados);
		while (contadorDePrograma < fimDoCodigo) {
			Codigo codigo = areaDeCodigo.get(contadorDePrograma);
			contadorDePrograma++;
			codigo.executar(this);
		}
	}
}
