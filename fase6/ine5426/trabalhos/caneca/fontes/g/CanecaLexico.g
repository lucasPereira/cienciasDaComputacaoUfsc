lexer grammar CanecaLexico;

options {
	language = Java;
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
	public void recover(RecognitionException erro) {
		input.consume();
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
			emitErrorMessage(String.format("[Erro léxico] \%s \%s\n", cabecalhoDeErro, mensagemDeErro));
		}
	}
	
	@Override
	public String getErrorMessage(RecognitionException erro, String[] nomeDosSimbolos) {
		if (erro instanceof MismatchedTokenException) {
			MismatchedTokenException erroDeSimboloIncompativel = (MismatchedTokenException) erro;
			String caractereIncompativel = getCharErrorDisplay(erroDeSimboloIncompativel.c);
			String caractereEsperado = getCharErrorDisplay(erroDeSimboloIncompativel.expecting);
			return String.format("[MismatchedTokenException]\nCaractere incompátivel: \%s. O caractere esperado era: \%s.", caractereIncompativel, caractereEsperado);
		} else if (erro instanceof NoViableAltException) {
			NoViableAltException erroDeAlternativaInviavel = (NoViableAltException) erro;
			String caractereRecebido = getCharErrorDisplay(erroDeAlternativaInviavel.c);
			return String.format("[NoViableAltException]\nSem alternativa viável. O caractere recebido foi: \%s.", caractereRecebido);
		} else if (erro instanceof EarlyExitException) {
			EarlyExitException erroDeSaidaPrecoce = (EarlyExitException) erro;
			String caractereRecebido = getCharErrorDisplay(erroDeSaidaPrecoce.c);
			return String.format("[EarlyExitException]\nEsperava-se reconhecer pelo menos uma alternativa, mas não foi reconhecida nenhuma. O caractere recebido foi: \%s.", caractereRecebido);
		} else if (erro instanceof MismatchedSetException) {
			MismatchedSetException erroDeConjuntoIncompativel = (MismatchedSetException) erro;
			String caractereIncompativel = getCharErrorDisplay(erroDeConjuntoIncompativel.c);
			BitSet conjuntoEsperado = erroDeConjuntoIncompativel.expecting;
			return String.format("[MismatchedSetException]\nCaractere incompátivel: \%s. O conjunto esperado era: \%s.", caractereIncompativel, conjuntoEsperado);
		} else if (erro instanceof MismatchedNotSetException) {
			MismatchedNotSetException erroDeConjuntoNegadoIncompativel = (MismatchedNotSetException) erro;
			String caractereIncompativel = getCharErrorDisplay(erroDeConjuntoNegadoIncompativel.c);
			BitSet conjuntoNegadoEsperado = erroDeConjuntoNegadoIncompativel.expecting;
			return String.format("[MismatchedNotSetException]\nCaractere incompátivel: \%s. O conjunto negado esperado era: \%s.", caractereIncompativel, conjuntoNegadoEsperado);
		} else if (erro instanceof MismatchedRangeException) {
			MismatchedRangeException erroDeIntervaloIncompativel = (MismatchedRangeException) erro;
			String caractereIncompativel = getCharErrorDisplay(erroDeIntervaloIncompativel.c);
			String inicioDoIntervaloEsperado = getCharErrorDisplay(erroDeIntervaloIncompativel.a);
			String fimDoIntervaloEsperado = getCharErrorDisplay(erroDeIntervaloIncompativel.b);
			return String.format("[MismatchedRangeException]\nCaractere incompátivel: \%s. O intervalo do conjunto esperado era: {\%s...\%s}.", caractereIncompativel, inicioDoIntervaloEsperado, fimDoIntervaloEsperado);
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
	
	@Override
	public String getCharErrorDisplay(int caractere) {
		String valor = String.valueOf((char) caractere);
		if (caractere == Token.EOF) {
			valor = getTokenErrorDisplay(caractere, getTokenNames());
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

IMPRIMIR
	: 'imprimir'
	;

DEPURAR
	: 'depurar'
	;

INICIO
	: 'inicio'
	;

FIM
	: 'fim'
	;

SE
	: 'se'
	;

SENAO
	: 'senao'
	;

PARA
	: 'para'
	;

REPITA
	: 'repita'
	;

ENQUANTO
	: 'enquanto'
	;

TENTE
	: 'tente'
	;

LANCE
	: 'lance'
	;

CAPTURE
	: 'capture'
	;

RETORNE
	: 'retorne'
	;

DESTRUA
	: 'destrua'
	;

DECLARE
	: 'declare'
	;

PACOTE
	: 'pacote'
	;

IMPORTE
	: 'importe'
	;

COMO
	: 'como'
	;

CLASSE
	: 'classe'
	;

INTERFACE
	: 'interface'
	;

METODO
	: 'metodo'
	;

ATRIBUTO
	: 'atributo'
	;

CONSTRUTOR
	: 'construtor'
	;

DESTRUTOR
	: 'destrutor'
	;

ESTATICO
	: 'estatico'
	;

IMPLEMENTA
	: 'implementa'
	;

PRIVADO
	: 'privado'
	;

PUBLICO
	: 'publico'
	;

PROTEGIDO
	: 'protegido'
	;

PRIVADA
	: 'privada'
	;

PUBLICA
	: 'publica'
	;

PROTEGIDA
	: 'protegida'
	;

NOVO
	: 'novo'
	;

NOVA
	: 'nova'
	;

ESSE
	: 'esse'
	;

ESSA
	: 'essa'
	;

CHAMADA_DE_OBJETO
	: '.'
	;

CHAMADA_DE_CLASSE
	: ':'
	;

PARENTESE_ESQUERDO
	: '('
	;

PARENTESE_DIREITO
	: ')'
	;

COLCHETE_ESQUERDO
	: '['
	;

COLCHETE_DIREITO
	: ']'
	;

SEPARADOR
	: ','
	;

TERMINADOR
	: ';'
	;

ATRIBUIDOR
	: '='
	;

SOMA
	: '+'
	;

SUBTRACAO
	: '-'
	;

MULTIPLICACAO
	: '*'
	;

DIVISAO
	: '/'
	;

RESTO_DA_DIVISAO
	: '%'
	;

NEGACAO
	: '~'
	;

E
	: '&&'
	;

OU
	: '||'
	;

MENOR
	: '<'
	;

MAIOR
	: '>'
	;

MENOR_IGUAL
	: '<='
	;

MAIOR_IGUAL
	: '>='
	;

IGUAL
	: '=='
	;

DIFERENTE
	: '!='
	;

VALOR_BOOLEANO
	: 'verdadeiro'
	| 'falso'
	;

VALOR_NULO
	: 'nulo'
	;

CONSTANTE_INTEIRA
	: ('-')? DIGITO+
	;

CONSTANTE_REAL
	: ('-')? DIGITO+ '.' DIGITO+
	;

LITERAL_CARACTERE
	: '\'' CARACTERE '\''
	;

LITERAL_TEXTO
	: '"' (CARACTERE)* '"'
	;

IDENTIFICADOR
	: LETRA (LETRA | DIGITO | '_')*
	;

IDENTIFICADOR_DE_PACOTE
	: '@' IDENTIFICADOR ('.' IDENTIFICADOR)*
	;

ESPACO_EM_BRANCO
	: (' ' | TABULACAO | QUEBRA_DE_LINHA) {skip();}
	;

COMENTARIO_EM_LINHA
	: ('?' ~(QUEBRA_DE_LINHA)*) {$channel=HIDDEN;}
	;

COMENTARIO_EM_BLOCO
	: ('#?' (options {greedy=false;}: .)* '?#') {$channel=HIDDEN;}
	;

fragment CARACTERE
	: CARACTERE_DE_ESCAPE
	| ~(CARACTERE_NAO_IMPRIMIVEL)
	;

fragment CARACTERE_NAO_IMPRIMIVEL
	: USADO_EM_TEXTO
	| TABULACAO
	| QUEBRA_DE_LINHA
	;

fragment CARACTERE_DE_ESCAPE
	: '\\' ('n' | 'r' | 't' | 'f' | '\\' | '\'' | '"')
	;

fragment QUEBRA_DE_LINHA
	: '\n'
	| '\r'
	;

fragment TABULACAO
	: '\t'
	| '\f'
	;

fragment USADO_EM_TEXTO
	: '\\'
	| '\''
	| '"'
	;

fragment LETRA
	: 'A'..'Z'
	| 'a'..'z'
	;

fragment DIGITO
	: '0'..'9'
	;
