package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public abstract class Procedimento<T> extends EscopoAbstrato implements Simbolo {
	private Map<String, Variavel> argumentos;
	private Stack<Variavel> argumentosEmPilha;
	private Bloco bloco;
	private String nome;
	private int linha;
	private int coluna;
	
	public Procedimento(Escopo escopoPai, String nome, int linha, int coluna) {
		super(escopoPai);
		this.nome = nome;
		this.linha = linha;
		this.coluna = coluna;
		argumentos = new HashMap<String, Variavel>();
		argumentosEmPilha = new Stack<Variavel>();
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeDados.definirPontoDeEntrada(nome, areaDeCodigo.size());
		areaDeCodigo.add(new CodigoAbrirContextoDeProcedimento(fornecerEscopoPai().comoTexto()));
		while (!argumentosEmPilha.empty()) {
			areaDeCodigo.add(new CodigoDefinirSimbolo(argumentosEmPilha.pop().fornecerNome()));
		}
		bloco.gerarCodigo(areaDeCodigo, areaDeDados);
		areaDeCodigo.add(new CodigoFecharContexto());
		areaDeCodigo.add(new CodigoRetornar());
	}
	
	public final boolean mesmaAssinatura(Procedimento<T> outro) {
		if (argumentos.size() == outro.argumentos.size()) {
			Iterator<Variavel> iterador = argumentos.values().iterator();
			Iterator<Variavel> iteradorDoOutro = outro.argumentos.values().iterator();
			boolean mesmaAssinatura = true;
			while (iterador.hasNext() && mesmaAssinatura) {
				if (!iterador.next().mesmoTipo(iteradorDoOutro.next())) {
					mesmaAssinatura = false;
				}
			}
			return mesmaAssinatura;
		}
		return false;
	}
	
	@Override
	public final boolean definirVariavel(Variavel variavel) {
		if (argumentos.containsKey(variavel.fornecerNome())) {
			Reporter.instancia().reportarErroDeDefinicaoRepetidaDeVariavel(variavel);
			return false;
		}
		argumentos.put(variavel.fornecerNome(), variavel);
		argumentosEmPilha.push(variavel);
		Reporter.instancia().reportarDefinicaoDeVariavel(variavel);
		return true;
	}
	
	@Override
	public final boolean definirBloco(Bloco bloco) {
		this.bloco = bloco;
		Reporter.instancia().reportarDefinicaoDeBloco(bloco);
		return true;
	}
	
	@Override
	public String fornecerNome() {
		return nome;
	}
	
	@Override
	public final int fornecerLinha() {
		return linha;
	}
	
	@Override
	public final int fornecerColuna() {
		return coluna;
	}
}
