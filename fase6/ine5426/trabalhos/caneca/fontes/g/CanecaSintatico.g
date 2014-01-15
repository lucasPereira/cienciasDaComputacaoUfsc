parser grammar CanecaSintatico;

options {
	backtrack = false;
	k = 1;
	language = Java;
	output = AST;
	tokenVocab = CanecaLexico;
}

@header {
	package br.ufsc.inf.ine5426.caneca.antlr;
	import java.lang.System;
	import java.util.List;
	import java.util.LinkedList;
}

@members {
	private boolean mostrarErros = true;
	private List<RecognitionException> erros = new LinkedList<RecognitionException>();
	
	public void esconderErros() {
		this.mostrarErros = false;
	}
	
	public List<RecognitionException> fornecerErros() {
		return erros;
	}
	
	@Override
	public void reportError(RecognitionException erro) {
		erros.add(erro);
		super.reportError(erro);
	}
	
	@Override
	public void recover(IntStream entrada, RecognitionException erro) {
		super.recover(entrada, erro);
	}
	
	@Override
	public Object recoverFromMismatchedToken(IntStream entrada, int tipoDoSimbolo, BitSet conjuntoDeFollows) throws RecognitionException {
		throw new MismatchedTokenException(tipoDoSimbolo, entrada);
	}
	
	@Override
	public Object recoverFromMismatchedSet(IntStream entrada, RecognitionException erro, BitSet conjuntoDeFollows) throws RecognitionException {
		throw erro;
	}
	
	@Override
	public void emitErrorMessage(String mensagemDeErro) {
		System.err.println(mensagemDeErro);
	}
	
	@Override
	public void displayRecognitionError(String[] nomesDosSimbolos, RecognitionException erro) {
		if (mostrarErros) {
			String cabecalhoDeErro = getErrorHeader(erro);
			String mensagemDeErro = getErrorMessage(erro, nomesDosSimbolos);
			emitErrorMessage(String.format("[Erro sintático] \%s \%s\n", cabecalhoDeErro, mensagemDeErro));
		}
	}
	
	@Override
	public String getErrorMessage(RecognitionException erro, String[] nomeDosSimbolos) {
		if (erro instanceof UnwantedTokenException) {
			UnwantedTokenException erroDeSimboloNaoDesejado = (UnwantedTokenException) erro;
			String entradaNaoDesejada = getTokenErrorDisplay(erroDeSimboloNaoDesejado.getUnexpectedToken());
			String simboloEsperado = getTokenErrorDisplay(erroDeSimboloNaoDesejado.expecting, nomeDosSimbolos);
			return String.format("[UnwantedTokenException]\nEntrada não desejada: \%s. O símbolo esperado era: \%s.", entradaNaoDesejada, simboloEsperado);
		} else if (erro instanceof MissingTokenException) {
			MissingTokenException erroDeSimboloFaltando = (MissingTokenException) erro;
			String simboloFaltando = getTokenErrorDisplay(erroDeSimboloFaltando.expecting, nomeDosSimbolos);
			String entradaRecebida = getTokenErrorDisplay(erroDeSimboloFaltando.token);
			return String.format("[MissingTokenException]\nSímbolo faltando: \%s. A entrada recebida foi: \%s.", simboloFaltando, entradaRecebida);
		} else if (erro instanceof MismatchedTokenException) {
			MismatchedTokenException erroDeSimboloIncompativel = (MismatchedTokenException) erro;
			String entradaIncompativel = getTokenErrorDisplay(erroDeSimboloIncompativel.token);
			String simboloEsperado = getTokenErrorDisplay(erroDeSimboloIncompativel.expecting, nomeDosSimbolos);
			return String.format("[MismatchedTokenException]\nEntrada incompátivel: \%s. O símbolo esperado era: \%s.", entradaIncompativel, simboloEsperado);
		} else if (erro instanceof MismatchedTreeNodeException) {
			MismatchedTreeNodeException erroDeNodoIncompativel = (MismatchedTreeNodeException) erro;
			Object nodoIncompativel = erroDeNodoIncompativel.node;
			String simboloEsperado = getTokenErrorDisplay(erroDeNodoIncompativel.expecting, nomeDosSimbolos);
			return String.format("[MismatchedTreeNodeException]\nNodo incompátivel: \%s. O símbolo esperado era: \%s.", nodoIncompativel.toString(), simboloEsperado);
		} else if (erro instanceof NoViableAltException) {
			NoViableAltException erroDeAlternativaInviavel = (NoViableAltException) erro;
			String entradaRecebida = getTokenErrorDisplay(erroDeAlternativaInviavel.token);
			return String.format("[NoViableAltException]\nSem alternativa viável. A entrada recebida foi: \%s.", entradaRecebida);
		} else if (erro instanceof EarlyExitException) {
			EarlyExitException erroDeSaidaPrecoce = (EarlyExitException) erro;
			String entradaRecebida = getTokenErrorDisplay(erroDeSaidaPrecoce.token);
			return String.format("[EarlyExitException]\nEsperava-se reconhecer pelo menos uma alternativa, mas não foi reconhecida nenhuma. A entrada recebida foi: \%s.", entradaRecebida);
		} else if (erro instanceof MismatchedSetException) {
			MismatchedSetException erroDeConjuntoIncompativel = (MismatchedSetException) erro;
			String entradaIncompativel = getTokenErrorDisplay(erroDeConjuntoIncompativel.token);
			BitSet conjuntoEsperado = erroDeConjuntoIncompativel.expecting;
			return String.format("[MismatchedSetException]\nEntrada incompátivel: \%s. O conjunto esperado era: \%s.", entradaIncompativel, conjuntoEsperado);
		} else if (erro instanceof MismatchedNotSetException) {
			MismatchedNotSetException erroDeConjuntoNegadoIncompativel = (MismatchedNotSetException) erro;
			String entradaIncompativel = getTokenErrorDisplay(erroDeConjuntoNegadoIncompativel.token);
			BitSet conjuntoNegadoEsperado = erroDeConjuntoNegadoIncompativel.expecting;
			return String.format("[MismatchedNotSetException]\nEntrada incompátivel: \%s. O conjunto negado esperado era: \%s.", entradaIncompativel, conjuntoNegadoEsperado);
		} else if (erro instanceof FailedPredicateException) {
			FailedPredicateException erroDePredicadoFalho = (FailedPredicateException) erro;
			String regra = erroDePredicadoFalho.ruleName;
			String predicado = erroDePredicadoFalho.predicateText;
			return String.format("[FailedPredicateException]\nPredicado falho: \%s na regra: \%s.", predicado, regra);
		}
		return String.format("[Erro de reconhecimento]\n\%s.", erro.getMessage());
	}
	
	@Override
	public String getErrorHeader(RecognitionException erro) {
		String nomeDoArquivo = "";
		if (getSourceName() != null) {
			nomeDoArquivo = String.format("[\%s] ", getSourceName());
		}
		return String.format("\%s[\%d, \%d]", nomeDoArquivo, erro.line, erro.charPositionInLine);
	}
	
	@Override
	public String getTokenErrorDisplay(Token simbolo) {
		String valor = simbolo.getText();
		if (valor == null) {
			valor = getTokenErrorDisplay(simbolo.getType(), getTokenNames());
		}
		valor = valor.replaceAll("\n", "\\\\n");
		valor = valor.replaceAll("\r", "\\\\r");
		valor = valor.replaceAll("\t", "\\\\t");
		return String.format("'\%s'", valor);
	}
	
	public String getTokenErrorDisplay(int tipoDoSimbolo, String[] nomeDosSimbolos) {
		String nomeDoSimbolo = "DESCONHECIDO";
		if (tipoDoSimbolo == Token.EOF) {
			nomeDoSimbolo = "FIM_DE_ARQUIVO";
		} else if (tipoDoSimbolo >= 0 && tipoDoSimbolo < nomeDosSimbolos.length) {
			nomeDoSimbolo = nomeDosSimbolos[tipoDoSimbolo];
		}
		return String.format("<\%s>", nomeDoSimbolo);
	}
}

@rulecatch {
	catch (RecognitionException erro) {
		reportError(erro);
		recover(input, erro);
	}
}

programa
	: (unicadeDeCompilacao)+
	;

unicadeDeCompilacao
	: cabecalho (classe | interfaces)
	;

cabecalho
	: pacote importacoes
	;

pacote
	: PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR
	;

importacoes
	: (importacao)*
	;

importacao
	: IMPORTE (IDENTIFICADOR IDENTIFICADOR_DE_PACOTE (COMO IDENTIFICADOR)? | IDENTIFICADOR_DE_PACOTE) TERMINADOR
	;

classe
	: CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse
	;

interfaces
	: INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface
	;

corpoDaClasse
	: INICIO atributos construtores destrutor metodos FIM
	;

corpoDaInterface
	: INICIO atributos assinaturasDeMetodos FIM
	;

atributos
	: (atributo)*
	;

construtores
	: (construtor)+
	;

metodos
	: (metodo)*
	;

assinaturasDeMetodos
	: (assinaturaDeMetodo TERMINADOR)*
	;

atributo
	: ATRIBUTO modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR (ATRIBUIDOR expressaoOuLogico)? TERMINADOR
	;

construtor
	: assinaturaDeConstrutor blocoDeInstrucoes
	;

destrutor
	: assinaturaDeDestrutor blocoDeInstrucoes
	;

metodo
	: assinaturaDeMetodo blocoDeInstrucoes
	;

assinaturaDeConstrutor
	: CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos
	;

assinaturaDeDestrutor
	: DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia
	;

assinaturaDeMetodo
	: METODO modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR listaDeArgumentos
	;

modificadorDeAcessoMasculino
	: PUBLICO
	| PRIVADO
	| PROTEGIDO
	;

modificadorDeAcessoFeminino
	: PUBLICA
	| PRIVADA
	| PROTEGIDA
	;

listaDeParametros
	: PARENTESE_ESQUERDO (expressao (SEPARADOR expressao)*)? PARENTESE_DIREITO
	;

listaDeArgumentosVazia
	: PARENTESE_ESQUERDO PARENTESE_DIREITO
	;

listaDeArgumentos
	: PARENTESE_ESQUERDO (declaracao (SEPARADOR declaracao)*)? PARENTESE_DIREITO
	;

listaDeInterfaces
	: (IMPLEMENTA tipo (SEPARADOR tipo)*)?
	;

listaDeTiposGenericos
	: (COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO)*
	;

listaDeTipos
	: (COLCHETE_ESQUERDO tipo (SEPARADOR tipo)* COLCHETE_DIREITO)?
	;

listaDeCapturas
	: (capture)+
	;

tipoGenerico
	: IDENTIFICADOR listaDeInterfaces
	;

tipo
	: IDENTIFICADOR listaDeTipos
	;

declaracao
	: tipo IDENTIFICADOR
	;

declaracaoComAtribuicaoOpcional
	: tipo IDENTIFICADOR (ATRIBUIDOR expressaoOuLogico)?
	;

expressao
	: expressaoOuLogico (ATRIBUIDOR expressaoOuLogico)?
	;

expressaoOuLogico
	: expressaoELogico (OU expressaoELogico)*
	;

expressaoELogico
	: expressaoComparacaoLogica (E expressaoComparacaoLogica)*
	;

expressaoComparacaoLogica
	: expressaoAditiva ((IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL) expressaoAditiva)?
	;

expressaoAditiva
	: expressaoMultiplicativa ((SOMA | SUBTRACAO) expressaoMultiplicativa)*
	;

expressaoMultiplicativa
	: expressaoUnaria ((MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO) expressaoUnaria)*
	;

expressaoUnaria
	: expressaoPrimaria
	| SUBTRACAO expressaoPrimaria
	| NEGACAO expressaoPrimaria
	;

expressaoPrimaria
	: PARENTESE_ESQUERDO expressao PARENTESE_DIREITO
	| VALOR_BOOLEANO
	| VALOR_NULO
	| CONSTANTE_INTEIRA
	| CONSTANTE_REAL
	| LITERAL_CARACTERE
	| LITERAL_TEXTO
	| comando
	;

comando
	: referencia (chamada)*
	;

referencia
	: ESSE
	| ESSA
	| instanciacao
	| IDENTIFICADOR (listaDeParametros)?
	;

chamada
	: (CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO) IDENTIFICADOR (listaDeParametros)?
	;

instanciacao
	: (NOVO | NOVA) tipo listaDeParametros
	;

destruicao
	: DESTRUA expressao
	;

retorno 
	: RETORNE expressao
	;

se
	: SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes (SENAO blocoDeInstrucoes)?
	;

para
	: PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes
	;

repita
	: REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes
	;

enquanto
	: ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes
	;

tente
	: TENTE blocoDeInstrucoes listaDeCapturas
	;

capture
	: CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes
	;

lance
	: LANCE expressao
	;

instrucao 
	:
	( options {k = 2;}
		: expressao TERMINADOR
		| declaracaoComAtribuicaoOpcional TERMINADOR
	)
	| IMPRIMIR TERMINADOR
	| DEPURAR TERMINADOR
	| destruicao TERMINADOR
	| retorno TERMINADOR
	| se
	| para
	| repita
	| enquanto
	| tente
	| lance TERMINADOR
	;

blocoDeInstrucoes
	: INICIO (instrucao)* FIM
	;
