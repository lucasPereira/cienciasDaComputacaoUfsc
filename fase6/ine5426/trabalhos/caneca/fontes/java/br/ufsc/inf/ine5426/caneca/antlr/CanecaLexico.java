// $ANTLR 3.4 fontes/g/CanecaLexico.g 2012-12-21 09:02:49

	package br.ufsc.inf.ine5426.caneca.antlr;
	import java.lang.System;
	import java.util.List;
	import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CanecaLexico extends Lexer {
    public static final int EOF=-1;
    public static final int ATRIBUIDOR=4;
    public static final int ATRIBUTO=5;
    public static final int CAPTURE=6;
    public static final int CARACTERE=7;
    public static final int CARACTERE_DE_ESCAPE=8;
    public static final int CARACTERE_NAO_IMPRIMIVEL=9;
    public static final int CHAMADA_DE_CLASSE=10;
    public static final int CHAMADA_DE_OBJETO=11;
    public static final int CLASSE=12;
    public static final int COLCHETE_DIREITO=13;
    public static final int COLCHETE_ESQUERDO=14;
    public static final int COMENTARIO_EM_BLOCO=15;
    public static final int COMENTARIO_EM_LINHA=16;
    public static final int COMO=17;
    public static final int CONSTANTE_INTEIRA=18;
    public static final int CONSTANTE_REAL=19;
    public static final int CONSTRUTOR=20;
    public static final int DECLARE=21;
    public static final int DEPURAR=22;
    public static final int DESTRUA=23;
    public static final int DESTRUTOR=24;
    public static final int DIFERENTE=25;
    public static final int DIGITO=26;
    public static final int DIVISAO=27;
    public static final int E=28;
    public static final int ENQUANTO=29;
    public static final int ESPACO_EM_BRANCO=30;
    public static final int ESSA=31;
    public static final int ESSE=32;
    public static final int ESTATICO=33;
    public static final int FIM=34;
    public static final int IDENTIFICADOR=35;
    public static final int IDENTIFICADOR_DE_PACOTE=36;
    public static final int IGUAL=37;
    public static final int IMPLEMENTA=38;
    public static final int IMPORTE=39;
    public static final int IMPRIMIR=40;
    public static final int INICIO=41;
    public static final int INTERFACE=42;
    public static final int LANCE=43;
    public static final int LETRA=44;
    public static final int LITERAL_CARACTERE=45;
    public static final int LITERAL_TEXTO=46;
    public static final int MAIOR=47;
    public static final int MAIOR_IGUAL=48;
    public static final int MENOR=49;
    public static final int MENOR_IGUAL=50;
    public static final int METODO=51;
    public static final int MULTIPLICACAO=52;
    public static final int NEGACAO=53;
    public static final int NOVA=54;
    public static final int NOVO=55;
    public static final int OU=56;
    public static final int PACOTE=57;
    public static final int PARA=58;
    public static final int PARENTESE_DIREITO=59;
    public static final int PARENTESE_ESQUERDO=60;
    public static final int PRIVADA=61;
    public static final int PRIVADO=62;
    public static final int PROTEGIDA=63;
    public static final int PROTEGIDO=64;
    public static final int PUBLICA=65;
    public static final int PUBLICO=66;
    public static final int QUEBRA_DE_LINHA=67;
    public static final int REPITA=68;
    public static final int RESTO_DA_DIVISAO=69;
    public static final int RETORNE=70;
    public static final int SE=71;
    public static final int SENAO=72;
    public static final int SEPARADOR=73;
    public static final int SOMA=74;
    public static final int SUBTRACAO=75;
    public static final int TABULACAO=76;
    public static final int TENTE=77;
    public static final int TERMINADOR=78;
    public static final int USADO_EM_TEXTO=79;
    public static final int VALOR_BOOLEANO=80;
    public static final int VALOR_NULO=81;

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
    			emitErrorMessage(String.format("[Erro léxico] %s %s\n", cabecalhoDeErro, mensagemDeErro));
    		}
    	}
    	
    	@Override
    	public String getErrorMessage(RecognitionException erro, String[] nomeDosSimbolos) {
    		if (erro instanceof MismatchedTokenException) {
    			MismatchedTokenException erroDeSimboloIncompativel = (MismatchedTokenException) erro;
    			String caractereIncompativel = getCharErrorDisplay(erroDeSimboloIncompativel.c);
    			String caractereEsperado = getCharErrorDisplay(erroDeSimboloIncompativel.expecting);
    			return String.format("[MismatchedTokenException]\nCaractere incompátivel: %s. O caractere esperado era: %s.", caractereIncompativel, caractereEsperado);
    		} else if (erro instanceof NoViableAltException) {
    			NoViableAltException erroDeAlternativaInviavel = (NoViableAltException) erro;
    			String caractereRecebido = getCharErrorDisplay(erroDeAlternativaInviavel.c);
    			return String.format("[NoViableAltException]\nSem alternativa viável. O caractere recebido foi: %s.", caractereRecebido);
    		} else if (erro instanceof EarlyExitException) {
    			EarlyExitException erroDeSaidaPrecoce = (EarlyExitException) erro;
    			String caractereRecebido = getCharErrorDisplay(erroDeSaidaPrecoce.c);
    			return String.format("[EarlyExitException]\nEsperava-se reconhecer pelo menos uma alternativa, mas não foi reconhecida nenhuma. O caractere recebido foi: %s.", caractereRecebido);
    		} else if (erro instanceof MismatchedSetException) {
    			MismatchedSetException erroDeConjuntoIncompativel = (MismatchedSetException) erro;
    			String caractereIncompativel = getCharErrorDisplay(erroDeConjuntoIncompativel.c);
    			BitSet conjuntoEsperado = erroDeConjuntoIncompativel.expecting;
    			return String.format("[MismatchedSetException]\nCaractere incompátivel: %s. O conjunto esperado era: %s.", caractereIncompativel, conjuntoEsperado);
    		} else if (erro instanceof MismatchedNotSetException) {
    			MismatchedNotSetException erroDeConjuntoNegadoIncompativel = (MismatchedNotSetException) erro;
    			String caractereIncompativel = getCharErrorDisplay(erroDeConjuntoNegadoIncompativel.c);
    			BitSet conjuntoNegadoEsperado = erroDeConjuntoNegadoIncompativel.expecting;
    			return String.format("[MismatchedNotSetException]\nCaractere incompátivel: %s. O conjunto negado esperado era: %s.", caractereIncompativel, conjuntoNegadoEsperado);
    		} else if (erro instanceof MismatchedRangeException) {
    			MismatchedRangeException erroDeIntervaloIncompativel = (MismatchedRangeException) erro;
    			String caractereIncompativel = getCharErrorDisplay(erroDeIntervaloIncompativel.c);
    			String inicioDoIntervaloEsperado = getCharErrorDisplay(erroDeIntervaloIncompativel.a);
    			String fimDoIntervaloEsperado = getCharErrorDisplay(erroDeIntervaloIncompativel.b);
    			return String.format("[MismatchedRangeException]\nCaractere incompátivel: %s. O intervalo do conjunto esperado era: {%s...%s}.", caractereIncompativel, inicioDoIntervaloEsperado, fimDoIntervaloEsperado);
    		} else if (erro instanceof FailedPredicateException) {
    			FailedPredicateException erroDePredicadoFalho = (FailedPredicateException) erro;
    			String regra = erroDePredicadoFalho.ruleName;
    			String predicado = erroDePredicadoFalho.predicateText;
    			return String.format("[FailedPredicateException]\nPredicado falho: %s na regra: %s.", predicado, regra);
    		}
    		return String.format("[Erro de reconhecimento]\n%s.", erro.getMessage());
    	}
    	
    	@Override
    	public String getErrorHeader(RecognitionException erro) {
    		String nomeDoArquivo = "";
    		if (getSourceName() != null) {
    			nomeDoArquivo = String.format("[%s] ", getSourceName());
    		}
    		return String.format("%s[%d, %d]", nomeDoArquivo, erro.line, erro.charPositionInLine);
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
    		return String.format("'%s'", valor);
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
    		return String.format("'%s'", valor);
    	}
    	
    	public String getTokenErrorDisplay(int tipoDoSimbolo, String[] nomeDosSimbolos) {
    		String nomeDoSimbolo = "DESCONHECIDO";
    		if (tipoDoSimbolo == Token.EOF) {
    			nomeDoSimbolo = "FIM_DE_ARQUIVO";
    		} else if (tipoDoSimbolo >= 0 && tipoDoSimbolo < nomeDosSimbolos.length) {
    			nomeDoSimbolo = nomeDosSimbolos[tipoDoSimbolo];
    		}
    		return String.format("<%s>", nomeDoSimbolo);
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CanecaLexico() {} 
    public CanecaLexico(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CanecaLexico(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "fontes/g/CanecaLexico.g"; }

    // $ANTLR start "IMPRIMIR"
    public final void mIMPRIMIR() throws RecognitionException {
        try {
            int _type = IMPRIMIR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:136:2: ( 'imprimir' )
            // fontes/g/CanecaLexico.g:136:4: 'imprimir'
            {
            match("imprimir"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPRIMIR"

    // $ANTLR start "DEPURAR"
    public final void mDEPURAR() throws RecognitionException {
        try {
            int _type = DEPURAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:140:2: ( 'depurar' )
            // fontes/g/CanecaLexico.g:140:4: 'depurar'
            {
            match("depurar"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEPURAR"

    // $ANTLR start "INICIO"
    public final void mINICIO() throws RecognitionException {
        try {
            int _type = INICIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:144:2: ( 'inicio' )
            // fontes/g/CanecaLexico.g:144:4: 'inicio'
            {
            match("inicio"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INICIO"

    // $ANTLR start "FIM"
    public final void mFIM() throws RecognitionException {
        try {
            int _type = FIM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:148:2: ( 'fim' )
            // fontes/g/CanecaLexico.g:148:4: 'fim'
            {
            match("fim"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FIM"

    // $ANTLR start "SE"
    public final void mSE() throws RecognitionException {
        try {
            int _type = SE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:152:2: ( 'se' )
            // fontes/g/CanecaLexico.g:152:4: 'se'
            {
            match("se"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SE"

    // $ANTLR start "SENAO"
    public final void mSENAO() throws RecognitionException {
        try {
            int _type = SENAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:156:2: ( 'senao' )
            // fontes/g/CanecaLexico.g:156:4: 'senao'
            {
            match("senao"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SENAO"

    // $ANTLR start "PARA"
    public final void mPARA() throws RecognitionException {
        try {
            int _type = PARA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:160:2: ( 'para' )
            // fontes/g/CanecaLexico.g:160:4: 'para'
            {
            match("para"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARA"

    // $ANTLR start "REPITA"
    public final void mREPITA() throws RecognitionException {
        try {
            int _type = REPITA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:164:2: ( 'repita' )
            // fontes/g/CanecaLexico.g:164:4: 'repita'
            {
            match("repita"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REPITA"

    // $ANTLR start "ENQUANTO"
    public final void mENQUANTO() throws RecognitionException {
        try {
            int _type = ENQUANTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:168:2: ( 'enquanto' )
            // fontes/g/CanecaLexico.g:168:4: 'enquanto'
            {
            match("enquanto"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ENQUANTO"

    // $ANTLR start "TENTE"
    public final void mTENTE() throws RecognitionException {
        try {
            int _type = TENTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:172:2: ( 'tente' )
            // fontes/g/CanecaLexico.g:172:4: 'tente'
            {
            match("tente"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TENTE"

    // $ANTLR start "LANCE"
    public final void mLANCE() throws RecognitionException {
        try {
            int _type = LANCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:176:2: ( 'lance' )
            // fontes/g/CanecaLexico.g:176:4: 'lance'
            {
            match("lance"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LANCE"

    // $ANTLR start "CAPTURE"
    public final void mCAPTURE() throws RecognitionException {
        try {
            int _type = CAPTURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:180:2: ( 'capture' )
            // fontes/g/CanecaLexico.g:180:4: 'capture'
            {
            match("capture"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CAPTURE"

    // $ANTLR start "RETORNE"
    public final void mRETORNE() throws RecognitionException {
        try {
            int _type = RETORNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:184:2: ( 'retorne' )
            // fontes/g/CanecaLexico.g:184:4: 'retorne'
            {
            match("retorne"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETORNE"

    // $ANTLR start "DESTRUA"
    public final void mDESTRUA() throws RecognitionException {
        try {
            int _type = DESTRUA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:188:2: ( 'destrua' )
            // fontes/g/CanecaLexico.g:188:4: 'destrua'
            {
            match("destrua"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DESTRUA"

    // $ANTLR start "DECLARE"
    public final void mDECLARE() throws RecognitionException {
        try {
            int _type = DECLARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:192:2: ( 'declare' )
            // fontes/g/CanecaLexico.g:192:4: 'declare'
            {
            match("declare"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECLARE"

    // $ANTLR start "PACOTE"
    public final void mPACOTE() throws RecognitionException {
        try {
            int _type = PACOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:196:2: ( 'pacote' )
            // fontes/g/CanecaLexico.g:196:4: 'pacote'
            {
            match("pacote"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PACOTE"

    // $ANTLR start "IMPORTE"
    public final void mIMPORTE() throws RecognitionException {
        try {
            int _type = IMPORTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:200:2: ( 'importe' )
            // fontes/g/CanecaLexico.g:200:4: 'importe'
            {
            match("importe"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPORTE"

    // $ANTLR start "COMO"
    public final void mCOMO() throws RecognitionException {
        try {
            int _type = COMO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:204:2: ( 'como' )
            // fontes/g/CanecaLexico.g:204:4: 'como'
            {
            match("como"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMO"

    // $ANTLR start "CLASSE"
    public final void mCLASSE() throws RecognitionException {
        try {
            int _type = CLASSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:208:2: ( 'classe' )
            // fontes/g/CanecaLexico.g:208:4: 'classe'
            {
            match("classe"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLASSE"

    // $ANTLR start "INTERFACE"
    public final void mINTERFACE() throws RecognitionException {
        try {
            int _type = INTERFACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:212:2: ( 'interface' )
            // fontes/g/CanecaLexico.g:212:4: 'interface'
            {
            match("interface"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTERFACE"

    // $ANTLR start "METODO"
    public final void mMETODO() throws RecognitionException {
        try {
            int _type = METODO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:216:2: ( 'metodo' )
            // fontes/g/CanecaLexico.g:216:4: 'metodo'
            {
            match("metodo"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "METODO"

    // $ANTLR start "ATRIBUTO"
    public final void mATRIBUTO() throws RecognitionException {
        try {
            int _type = ATRIBUTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:220:2: ( 'atributo' )
            // fontes/g/CanecaLexico.g:220:4: 'atributo'
            {
            match("atributo"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ATRIBUTO"

    // $ANTLR start "CONSTRUTOR"
    public final void mCONSTRUTOR() throws RecognitionException {
        try {
            int _type = CONSTRUTOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:224:2: ( 'construtor' )
            // fontes/g/CanecaLexico.g:224:4: 'construtor'
            {
            match("construtor"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONSTRUTOR"

    // $ANTLR start "DESTRUTOR"
    public final void mDESTRUTOR() throws RecognitionException {
        try {
            int _type = DESTRUTOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:228:2: ( 'destrutor' )
            // fontes/g/CanecaLexico.g:228:4: 'destrutor'
            {
            match("destrutor"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DESTRUTOR"

    // $ANTLR start "ESTATICO"
    public final void mESTATICO() throws RecognitionException {
        try {
            int _type = ESTATICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:232:2: ( 'estatico' )
            // fontes/g/CanecaLexico.g:232:4: 'estatico'
            {
            match("estatico"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESTATICO"

    // $ANTLR start "IMPLEMENTA"
    public final void mIMPLEMENTA() throws RecognitionException {
        try {
            int _type = IMPLEMENTA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:236:2: ( 'implementa' )
            // fontes/g/CanecaLexico.g:236:4: 'implementa'
            {
            match("implementa"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPLEMENTA"

    // $ANTLR start "PRIVADO"
    public final void mPRIVADO() throws RecognitionException {
        try {
            int _type = PRIVADO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:240:2: ( 'privado' )
            // fontes/g/CanecaLexico.g:240:4: 'privado'
            {
            match("privado"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PRIVADO"

    // $ANTLR start "PUBLICO"
    public final void mPUBLICO() throws RecognitionException {
        try {
            int _type = PUBLICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:244:2: ( 'publico' )
            // fontes/g/CanecaLexico.g:244:4: 'publico'
            {
            match("publico"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUBLICO"

    // $ANTLR start "PROTEGIDO"
    public final void mPROTEGIDO() throws RecognitionException {
        try {
            int _type = PROTEGIDO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:248:2: ( 'protegido' )
            // fontes/g/CanecaLexico.g:248:4: 'protegido'
            {
            match("protegido"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROTEGIDO"

    // $ANTLR start "PRIVADA"
    public final void mPRIVADA() throws RecognitionException {
        try {
            int _type = PRIVADA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:252:2: ( 'privada' )
            // fontes/g/CanecaLexico.g:252:4: 'privada'
            {
            match("privada"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PRIVADA"

    // $ANTLR start "PUBLICA"
    public final void mPUBLICA() throws RecognitionException {
        try {
            int _type = PUBLICA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:256:2: ( 'publica' )
            // fontes/g/CanecaLexico.g:256:4: 'publica'
            {
            match("publica"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUBLICA"

    // $ANTLR start "PROTEGIDA"
    public final void mPROTEGIDA() throws RecognitionException {
        try {
            int _type = PROTEGIDA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:260:2: ( 'protegida' )
            // fontes/g/CanecaLexico.g:260:4: 'protegida'
            {
            match("protegida"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROTEGIDA"

    // $ANTLR start "NOVO"
    public final void mNOVO() throws RecognitionException {
        try {
            int _type = NOVO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:264:2: ( 'novo' )
            // fontes/g/CanecaLexico.g:264:4: 'novo'
            {
            match("novo"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOVO"

    // $ANTLR start "NOVA"
    public final void mNOVA() throws RecognitionException {
        try {
            int _type = NOVA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:268:2: ( 'nova' )
            // fontes/g/CanecaLexico.g:268:4: 'nova'
            {
            match("nova"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOVA"

    // $ANTLR start "ESSE"
    public final void mESSE() throws RecognitionException {
        try {
            int _type = ESSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:272:2: ( 'esse' )
            // fontes/g/CanecaLexico.g:272:4: 'esse'
            {
            match("esse"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESSE"

    // $ANTLR start "ESSA"
    public final void mESSA() throws RecognitionException {
        try {
            int _type = ESSA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:276:2: ( 'essa' )
            // fontes/g/CanecaLexico.g:276:4: 'essa'
            {
            match("essa"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESSA"

    // $ANTLR start "CHAMADA_DE_OBJETO"
    public final void mCHAMADA_DE_OBJETO() throws RecognitionException {
        try {
            int _type = CHAMADA_DE_OBJETO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:280:2: ( '.' )
            // fontes/g/CanecaLexico.g:280:4: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAMADA_DE_OBJETO"

    // $ANTLR start "CHAMADA_DE_CLASSE"
    public final void mCHAMADA_DE_CLASSE() throws RecognitionException {
        try {
            int _type = CHAMADA_DE_CLASSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:284:2: ( ':' )
            // fontes/g/CanecaLexico.g:284:4: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAMADA_DE_CLASSE"

    // $ANTLR start "PARENTESE_ESQUERDO"
    public final void mPARENTESE_ESQUERDO() throws RecognitionException {
        try {
            int _type = PARENTESE_ESQUERDO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:288:2: ( '(' )
            // fontes/g/CanecaLexico.g:288:4: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARENTESE_ESQUERDO"

    // $ANTLR start "PARENTESE_DIREITO"
    public final void mPARENTESE_DIREITO() throws RecognitionException {
        try {
            int _type = PARENTESE_DIREITO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:292:2: ( ')' )
            // fontes/g/CanecaLexico.g:292:4: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARENTESE_DIREITO"

    // $ANTLR start "COLCHETE_ESQUERDO"
    public final void mCOLCHETE_ESQUERDO() throws RecognitionException {
        try {
            int _type = COLCHETE_ESQUERDO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:296:2: ( '[' )
            // fontes/g/CanecaLexico.g:296:4: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLCHETE_ESQUERDO"

    // $ANTLR start "COLCHETE_DIREITO"
    public final void mCOLCHETE_DIREITO() throws RecognitionException {
        try {
            int _type = COLCHETE_DIREITO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:300:2: ( ']' )
            // fontes/g/CanecaLexico.g:300:4: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLCHETE_DIREITO"

    // $ANTLR start "SEPARADOR"
    public final void mSEPARADOR() throws RecognitionException {
        try {
            int _type = SEPARADOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:304:2: ( ',' )
            // fontes/g/CanecaLexico.g:304:4: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEPARADOR"

    // $ANTLR start "TERMINADOR"
    public final void mTERMINADOR() throws RecognitionException {
        try {
            int _type = TERMINADOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:308:2: ( ';' )
            // fontes/g/CanecaLexico.g:308:4: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TERMINADOR"

    // $ANTLR start "ATRIBUIDOR"
    public final void mATRIBUIDOR() throws RecognitionException {
        try {
            int _type = ATRIBUIDOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:312:2: ( '=' )
            // fontes/g/CanecaLexico.g:312:4: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ATRIBUIDOR"

    // $ANTLR start "SOMA"
    public final void mSOMA() throws RecognitionException {
        try {
            int _type = SOMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:316:2: ( '+' )
            // fontes/g/CanecaLexico.g:316:4: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SOMA"

    // $ANTLR start "SUBTRACAO"
    public final void mSUBTRACAO() throws RecognitionException {
        try {
            int _type = SUBTRACAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:320:2: ( '-' )
            // fontes/g/CanecaLexico.g:320:4: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUBTRACAO"

    // $ANTLR start "MULTIPLICACAO"
    public final void mMULTIPLICACAO() throws RecognitionException {
        try {
            int _type = MULTIPLICACAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:324:2: ( '*' )
            // fontes/g/CanecaLexico.g:324:4: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTIPLICACAO"

    // $ANTLR start "DIVISAO"
    public final void mDIVISAO() throws RecognitionException {
        try {
            int _type = DIVISAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:328:2: ( '/' )
            // fontes/g/CanecaLexico.g:328:4: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVISAO"

    // $ANTLR start "RESTO_DA_DIVISAO"
    public final void mRESTO_DA_DIVISAO() throws RecognitionException {
        try {
            int _type = RESTO_DA_DIVISAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:332:2: ( '%' )
            // fontes/g/CanecaLexico.g:332:4: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RESTO_DA_DIVISAO"

    // $ANTLR start "NEGACAO"
    public final void mNEGACAO() throws RecognitionException {
        try {
            int _type = NEGACAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:336:2: ( '~' )
            // fontes/g/CanecaLexico.g:336:4: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEGACAO"

    // $ANTLR start "E"
    public final void mE() throws RecognitionException {
        try {
            int _type = E;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:340:2: ( '&&' )
            // fontes/g/CanecaLexico.g:340:4: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "E"

    // $ANTLR start "OU"
    public final void mOU() throws RecognitionException {
        try {
            int _type = OU;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:344:2: ( '||' )
            // fontes/g/CanecaLexico.g:344:4: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OU"

    // $ANTLR start "MENOR"
    public final void mMENOR() throws RecognitionException {
        try {
            int _type = MENOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:348:2: ( '<' )
            // fontes/g/CanecaLexico.g:348:4: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MENOR"

    // $ANTLR start "MAIOR"
    public final void mMAIOR() throws RecognitionException {
        try {
            int _type = MAIOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:352:2: ( '>' )
            // fontes/g/CanecaLexico.g:352:4: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAIOR"

    // $ANTLR start "MENOR_IGUAL"
    public final void mMENOR_IGUAL() throws RecognitionException {
        try {
            int _type = MENOR_IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:356:2: ( '<=' )
            // fontes/g/CanecaLexico.g:356:4: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MENOR_IGUAL"

    // $ANTLR start "MAIOR_IGUAL"
    public final void mMAIOR_IGUAL() throws RecognitionException {
        try {
            int _type = MAIOR_IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:360:2: ( '>=' )
            // fontes/g/CanecaLexico.g:360:4: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAIOR_IGUAL"

    // $ANTLR start "IGUAL"
    public final void mIGUAL() throws RecognitionException {
        try {
            int _type = IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:364:2: ( '==' )
            // fontes/g/CanecaLexico.g:364:4: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IGUAL"

    // $ANTLR start "DIFERENTE"
    public final void mDIFERENTE() throws RecognitionException {
        try {
            int _type = DIFERENTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:368:2: ( '!=' )
            // fontes/g/CanecaLexico.g:368:4: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIFERENTE"

    // $ANTLR start "VALOR_BOOLEANO"
    public final void mVALOR_BOOLEANO() throws RecognitionException {
        try {
            int _type = VALOR_BOOLEANO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:372:2: ( 'verdadeiro' | 'falso' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='v') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // fontes/g/CanecaLexico.g:372:4: 'verdadeiro'
                    {
                    match("verdadeiro"); 



                    }
                    break;
                case 2 :
                    // fontes/g/CanecaLexico.g:373:4: 'falso'
                    {
                    match("falso"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VALOR_BOOLEANO"

    // $ANTLR start "VALOR_NULO"
    public final void mVALOR_NULO() throws RecognitionException {
        try {
            int _type = VALOR_NULO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:377:2: ( 'nulo' )
            // fontes/g/CanecaLexico.g:377:4: 'nulo'
            {
            match("nulo"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VALOR_NULO"

    // $ANTLR start "CONSTANTE_INTEIRA"
    public final void mCONSTANTE_INTEIRA() throws RecognitionException {
        try {
            int _type = CONSTANTE_INTEIRA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:381:2: ( ( '-' )? ( DIGITO )+ )
            // fontes/g/CanecaLexico.g:381:4: ( '-' )? ( DIGITO )+
            {
            // fontes/g/CanecaLexico.g:381:4: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // fontes/g/CanecaLexico.g:381:5: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // fontes/g/CanecaLexico.g:381:11: ( DIGITO )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONSTANTE_INTEIRA"

    // $ANTLR start "CONSTANTE_REAL"
    public final void mCONSTANTE_REAL() throws RecognitionException {
        try {
            int _type = CONSTANTE_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:385:2: ( ( '-' )? ( DIGITO )+ '.' ( DIGITO )+ )
            // fontes/g/CanecaLexico.g:385:4: ( '-' )? ( DIGITO )+ '.' ( DIGITO )+
            {
            // fontes/g/CanecaLexico.g:385:4: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // fontes/g/CanecaLexico.g:385:5: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // fontes/g/CanecaLexico.g:385:11: ( DIGITO )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match('.'); 

            // fontes/g/CanecaLexico.g:385:23: ( DIGITO )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONSTANTE_REAL"

    // $ANTLR start "LITERAL_CARACTERE"
    public final void mLITERAL_CARACTERE() throws RecognitionException {
        try {
            int _type = LITERAL_CARACTERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:389:2: ( '\\'' CARACTERE '\\'' )
            // fontes/g/CanecaLexico.g:389:4: '\\'' CARACTERE '\\''
            {
            match('\''); 

            mCARACTERE(); 


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LITERAL_CARACTERE"

    // $ANTLR start "LITERAL_TEXTO"
    public final void mLITERAL_TEXTO() throws RecognitionException {
        try {
            int _type = LITERAL_TEXTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:393:2: ( '\"' ( CARACTERE )* '\"' )
            // fontes/g/CanecaLexico.g:393:4: '\"' ( CARACTERE )* '\"'
            {
            match('\"'); 

            // fontes/g/CanecaLexico.g:393:8: ( CARACTERE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\b')||LA7_0=='\u000B'||(LA7_0 >= '\u000E' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '&')||(LA7_0 >= '(' && LA7_0 <= '\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:393:9: CARACTERE
            	    {
            	    mCARACTERE(); 


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LITERAL_TEXTO"

    // $ANTLR start "IDENTIFICADOR"
    public final void mIDENTIFICADOR() throws RecognitionException {
        try {
            int _type = IDENTIFICADOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:397:2: ( LETRA ( LETRA | DIGITO | '_' )* )
            // fontes/g/CanecaLexico.g:397:4: LETRA ( LETRA | DIGITO | '_' )*
            {
            mLETRA(); 


            // fontes/g/CanecaLexico.g:397:10: ( LETRA | DIGITO | '_' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFICADOR"

    // $ANTLR start "IDENTIFICADOR_DE_PACOTE"
    public final void mIDENTIFICADOR_DE_PACOTE() throws RecognitionException {
        try {
            int _type = IDENTIFICADOR_DE_PACOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:401:2: ( '@' IDENTIFICADOR ( '.' IDENTIFICADOR )* )
            // fontes/g/CanecaLexico.g:401:4: '@' IDENTIFICADOR ( '.' IDENTIFICADOR )*
            {
            match('@'); 

            mIDENTIFICADOR(); 


            // fontes/g/CanecaLexico.g:401:22: ( '.' IDENTIFICADOR )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='.') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:401:23: '.' IDENTIFICADOR
            	    {
            	    match('.'); 

            	    mIDENTIFICADOR(); 


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFICADOR_DE_PACOTE"

    // $ANTLR start "ESPACO_EM_BRANCO"
    public final void mESPACO_EM_BRANCO() throws RecognitionException {
        try {
            int _type = ESPACO_EM_BRANCO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:405:2: ( ( ' ' | TABULACAO | QUEBRA_DE_LINHA ) )
            // fontes/g/CanecaLexico.g:405:4: ( ' ' | TABULACAO | QUEBRA_DE_LINHA )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESPACO_EM_BRANCO"

    // $ANTLR start "COMENTARIO_EM_LINHA"
    public final void mCOMENTARIO_EM_LINHA() throws RecognitionException {
        try {
            int _type = COMENTARIO_EM_LINHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:409:2: ( ( '?' (~ ( QUEBRA_DE_LINHA ) )* ) )
            // fontes/g/CanecaLexico.g:409:4: ( '?' (~ ( QUEBRA_DE_LINHA ) )* )
            {
            // fontes/g/CanecaLexico.g:409:4: ( '?' (~ ( QUEBRA_DE_LINHA ) )* )
            // fontes/g/CanecaLexico.g:409:5: '?' (~ ( QUEBRA_DE_LINHA ) )*
            {
            match('?'); 

            // fontes/g/CanecaLexico.g:409:9: (~ ( QUEBRA_DE_LINHA ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMENTARIO_EM_LINHA"

    // $ANTLR start "COMENTARIO_EM_BLOCO"
    public final void mCOMENTARIO_EM_BLOCO() throws RecognitionException {
        try {
            int _type = COMENTARIO_EM_BLOCO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // fontes/g/CanecaLexico.g:413:2: ( ( '#?' ( options {greedy=false; } : . )* '?#' ) )
            // fontes/g/CanecaLexico.g:413:4: ( '#?' ( options {greedy=false; } : . )* '?#' )
            {
            // fontes/g/CanecaLexico.g:413:4: ( '#?' ( options {greedy=false; } : . )* '?#' )
            // fontes/g/CanecaLexico.g:413:5: '#?' ( options {greedy=false; } : . )* '?#'
            {
            match("#?"); 



            // fontes/g/CanecaLexico.g:413:10: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='?') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='#') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1 >= '\u0000' && LA11_1 <= '\"')||(LA11_1 >= '$' && LA11_1 <= '\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '>')||(LA11_0 >= '@' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // fontes/g/CanecaLexico.g:413:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match("?#"); 



            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMENTARIO_EM_BLOCO"

    // $ANTLR start "CARACTERE"
    public final void mCARACTERE() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:417:2: ( CARACTERE_DE_ESCAPE |~ ( CARACTERE_NAO_IMPRIMIVEL ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\\') ) {
                alt12=1;
            }
            else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\b')||LA12_0=='\u000B'||(LA12_0 >= '\u000E' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= '&')||(LA12_0 >= '(' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= '\uFFFF')) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // fontes/g/CanecaLexico.g:417:4: CARACTERE_DE_ESCAPE
                    {
                    mCARACTERE_DE_ESCAPE(); 


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaLexico.g:418:4: ~ ( CARACTERE_NAO_IMPRIMIVEL )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||input.LA(1)=='\u000B'||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CARACTERE"

    // $ANTLR start "CARACTERE_NAO_IMPRIMIVEL"
    public final void mCARACTERE_NAO_IMPRIMIVEL() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:422:2: ( USADO_EM_TEXTO | TABULACAO | QUEBRA_DE_LINHA )
            // fontes/g/CanecaLexico.g:
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CARACTERE_NAO_IMPRIMIVEL"

    // $ANTLR start "CARACTERE_DE_ESCAPE"
    public final void mCARACTERE_DE_ESCAPE() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:428:2: ( '\\\\' ( 'n' | 'r' | 't' | 'f' | '\\\\' | '\\'' | '\"' ) )
            // fontes/g/CanecaLexico.g:428:4: '\\\\' ( 'n' | 'r' | 't' | 'f' | '\\\\' | '\\'' | '\"' )
            {
            match('\\'); 

            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CARACTERE_DE_ESCAPE"

    // $ANTLR start "QUEBRA_DE_LINHA"
    public final void mQUEBRA_DE_LINHA() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:432:2: ( '\\n' | '\\r' )
            // fontes/g/CanecaLexico.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUEBRA_DE_LINHA"

    // $ANTLR start "TABULACAO"
    public final void mTABULACAO() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:437:2: ( '\\t' | '\\f' )
            // fontes/g/CanecaLexico.g:
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TABULACAO"

    // $ANTLR start "USADO_EM_TEXTO"
    public final void mUSADO_EM_TEXTO() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:442:2: ( '\\\\' | '\\'' | '\"' )
            // fontes/g/CanecaLexico.g:
            {
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "USADO_EM_TEXTO"

    // $ANTLR start "LETRA"
    public final void mLETRA() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:448:2: ( 'A' .. 'Z' | 'a' .. 'z' )
            // fontes/g/CanecaLexico.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETRA"

    // $ANTLR start "DIGITO"
    public final void mDIGITO() throws RecognitionException {
        try {
            // fontes/g/CanecaLexico.g:453:2: ( '0' .. '9' )
            // fontes/g/CanecaLexico.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGITO"

    public void mTokens() throws RecognitionException {
        // fontes/g/CanecaLexico.g:1:8: ( IMPRIMIR | DEPURAR | INICIO | FIM | SE | SENAO | PARA | REPITA | ENQUANTO | TENTE | LANCE | CAPTURE | RETORNE | DESTRUA | DECLARE | PACOTE | IMPORTE | COMO | CLASSE | INTERFACE | METODO | ATRIBUTO | CONSTRUTOR | DESTRUTOR | ESTATICO | IMPLEMENTA | PRIVADO | PUBLICO | PROTEGIDO | PRIVADA | PUBLICA | PROTEGIDA | NOVO | NOVA | ESSE | ESSA | CHAMADA_DE_OBJETO | CHAMADA_DE_CLASSE | PARENTESE_ESQUERDO | PARENTESE_DIREITO | COLCHETE_ESQUERDO | COLCHETE_DIREITO | SEPARADOR | TERMINADOR | ATRIBUIDOR | SOMA | SUBTRACAO | MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO | NEGACAO | E | OU | MENOR | MAIOR | MENOR_IGUAL | MAIOR_IGUAL | IGUAL | DIFERENTE | VALOR_BOOLEANO | VALOR_NULO | CONSTANTE_INTEIRA | CONSTANTE_REAL | LITERAL_CARACTERE | LITERAL_TEXTO | IDENTIFICADOR | IDENTIFICADOR_DE_PACOTE | ESPACO_EM_BRANCO | COMENTARIO_EM_LINHA | COMENTARIO_EM_BLOCO )
        int alt13=70;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // fontes/g/CanecaLexico.g:1:10: IMPRIMIR
                {
                mIMPRIMIR(); 


                }
                break;
            case 2 :
                // fontes/g/CanecaLexico.g:1:19: DEPURAR
                {
                mDEPURAR(); 


                }
                break;
            case 3 :
                // fontes/g/CanecaLexico.g:1:27: INICIO
                {
                mINICIO(); 


                }
                break;
            case 4 :
                // fontes/g/CanecaLexico.g:1:34: FIM
                {
                mFIM(); 


                }
                break;
            case 5 :
                // fontes/g/CanecaLexico.g:1:38: SE
                {
                mSE(); 


                }
                break;
            case 6 :
                // fontes/g/CanecaLexico.g:1:41: SENAO
                {
                mSENAO(); 


                }
                break;
            case 7 :
                // fontes/g/CanecaLexico.g:1:47: PARA
                {
                mPARA(); 


                }
                break;
            case 8 :
                // fontes/g/CanecaLexico.g:1:52: REPITA
                {
                mREPITA(); 


                }
                break;
            case 9 :
                // fontes/g/CanecaLexico.g:1:59: ENQUANTO
                {
                mENQUANTO(); 


                }
                break;
            case 10 :
                // fontes/g/CanecaLexico.g:1:68: TENTE
                {
                mTENTE(); 


                }
                break;
            case 11 :
                // fontes/g/CanecaLexico.g:1:74: LANCE
                {
                mLANCE(); 


                }
                break;
            case 12 :
                // fontes/g/CanecaLexico.g:1:80: CAPTURE
                {
                mCAPTURE(); 


                }
                break;
            case 13 :
                // fontes/g/CanecaLexico.g:1:88: RETORNE
                {
                mRETORNE(); 


                }
                break;
            case 14 :
                // fontes/g/CanecaLexico.g:1:96: DESTRUA
                {
                mDESTRUA(); 


                }
                break;
            case 15 :
                // fontes/g/CanecaLexico.g:1:104: DECLARE
                {
                mDECLARE(); 


                }
                break;
            case 16 :
                // fontes/g/CanecaLexico.g:1:112: PACOTE
                {
                mPACOTE(); 


                }
                break;
            case 17 :
                // fontes/g/CanecaLexico.g:1:119: IMPORTE
                {
                mIMPORTE(); 


                }
                break;
            case 18 :
                // fontes/g/CanecaLexico.g:1:127: COMO
                {
                mCOMO(); 


                }
                break;
            case 19 :
                // fontes/g/CanecaLexico.g:1:132: CLASSE
                {
                mCLASSE(); 


                }
                break;
            case 20 :
                // fontes/g/CanecaLexico.g:1:139: INTERFACE
                {
                mINTERFACE(); 


                }
                break;
            case 21 :
                // fontes/g/CanecaLexico.g:1:149: METODO
                {
                mMETODO(); 


                }
                break;
            case 22 :
                // fontes/g/CanecaLexico.g:1:156: ATRIBUTO
                {
                mATRIBUTO(); 


                }
                break;
            case 23 :
                // fontes/g/CanecaLexico.g:1:165: CONSTRUTOR
                {
                mCONSTRUTOR(); 


                }
                break;
            case 24 :
                // fontes/g/CanecaLexico.g:1:176: DESTRUTOR
                {
                mDESTRUTOR(); 


                }
                break;
            case 25 :
                // fontes/g/CanecaLexico.g:1:186: ESTATICO
                {
                mESTATICO(); 


                }
                break;
            case 26 :
                // fontes/g/CanecaLexico.g:1:195: IMPLEMENTA
                {
                mIMPLEMENTA(); 


                }
                break;
            case 27 :
                // fontes/g/CanecaLexico.g:1:206: PRIVADO
                {
                mPRIVADO(); 


                }
                break;
            case 28 :
                // fontes/g/CanecaLexico.g:1:214: PUBLICO
                {
                mPUBLICO(); 


                }
                break;
            case 29 :
                // fontes/g/CanecaLexico.g:1:222: PROTEGIDO
                {
                mPROTEGIDO(); 


                }
                break;
            case 30 :
                // fontes/g/CanecaLexico.g:1:232: PRIVADA
                {
                mPRIVADA(); 


                }
                break;
            case 31 :
                // fontes/g/CanecaLexico.g:1:240: PUBLICA
                {
                mPUBLICA(); 


                }
                break;
            case 32 :
                // fontes/g/CanecaLexico.g:1:248: PROTEGIDA
                {
                mPROTEGIDA(); 


                }
                break;
            case 33 :
                // fontes/g/CanecaLexico.g:1:258: NOVO
                {
                mNOVO(); 


                }
                break;
            case 34 :
                // fontes/g/CanecaLexico.g:1:263: NOVA
                {
                mNOVA(); 


                }
                break;
            case 35 :
                // fontes/g/CanecaLexico.g:1:268: ESSE
                {
                mESSE(); 


                }
                break;
            case 36 :
                // fontes/g/CanecaLexico.g:1:273: ESSA
                {
                mESSA(); 


                }
                break;
            case 37 :
                // fontes/g/CanecaLexico.g:1:278: CHAMADA_DE_OBJETO
                {
                mCHAMADA_DE_OBJETO(); 


                }
                break;
            case 38 :
                // fontes/g/CanecaLexico.g:1:296: CHAMADA_DE_CLASSE
                {
                mCHAMADA_DE_CLASSE(); 


                }
                break;
            case 39 :
                // fontes/g/CanecaLexico.g:1:314: PARENTESE_ESQUERDO
                {
                mPARENTESE_ESQUERDO(); 


                }
                break;
            case 40 :
                // fontes/g/CanecaLexico.g:1:333: PARENTESE_DIREITO
                {
                mPARENTESE_DIREITO(); 


                }
                break;
            case 41 :
                // fontes/g/CanecaLexico.g:1:351: COLCHETE_ESQUERDO
                {
                mCOLCHETE_ESQUERDO(); 


                }
                break;
            case 42 :
                // fontes/g/CanecaLexico.g:1:369: COLCHETE_DIREITO
                {
                mCOLCHETE_DIREITO(); 


                }
                break;
            case 43 :
                // fontes/g/CanecaLexico.g:1:386: SEPARADOR
                {
                mSEPARADOR(); 


                }
                break;
            case 44 :
                // fontes/g/CanecaLexico.g:1:396: TERMINADOR
                {
                mTERMINADOR(); 


                }
                break;
            case 45 :
                // fontes/g/CanecaLexico.g:1:407: ATRIBUIDOR
                {
                mATRIBUIDOR(); 


                }
                break;
            case 46 :
                // fontes/g/CanecaLexico.g:1:418: SOMA
                {
                mSOMA(); 


                }
                break;
            case 47 :
                // fontes/g/CanecaLexico.g:1:423: SUBTRACAO
                {
                mSUBTRACAO(); 


                }
                break;
            case 48 :
                // fontes/g/CanecaLexico.g:1:433: MULTIPLICACAO
                {
                mMULTIPLICACAO(); 


                }
                break;
            case 49 :
                // fontes/g/CanecaLexico.g:1:447: DIVISAO
                {
                mDIVISAO(); 


                }
                break;
            case 50 :
                // fontes/g/CanecaLexico.g:1:455: RESTO_DA_DIVISAO
                {
                mRESTO_DA_DIVISAO(); 


                }
                break;
            case 51 :
                // fontes/g/CanecaLexico.g:1:472: NEGACAO
                {
                mNEGACAO(); 


                }
                break;
            case 52 :
                // fontes/g/CanecaLexico.g:1:480: E
                {
                mE(); 


                }
                break;
            case 53 :
                // fontes/g/CanecaLexico.g:1:482: OU
                {
                mOU(); 


                }
                break;
            case 54 :
                // fontes/g/CanecaLexico.g:1:485: MENOR
                {
                mMENOR(); 


                }
                break;
            case 55 :
                // fontes/g/CanecaLexico.g:1:491: MAIOR
                {
                mMAIOR(); 


                }
                break;
            case 56 :
                // fontes/g/CanecaLexico.g:1:497: MENOR_IGUAL
                {
                mMENOR_IGUAL(); 


                }
                break;
            case 57 :
                // fontes/g/CanecaLexico.g:1:509: MAIOR_IGUAL
                {
                mMAIOR_IGUAL(); 


                }
                break;
            case 58 :
                // fontes/g/CanecaLexico.g:1:521: IGUAL
                {
                mIGUAL(); 


                }
                break;
            case 59 :
                // fontes/g/CanecaLexico.g:1:527: DIFERENTE
                {
                mDIFERENTE(); 


                }
                break;
            case 60 :
                // fontes/g/CanecaLexico.g:1:537: VALOR_BOOLEANO
                {
                mVALOR_BOOLEANO(); 


                }
                break;
            case 61 :
                // fontes/g/CanecaLexico.g:1:552: VALOR_NULO
                {
                mVALOR_NULO(); 


                }
                break;
            case 62 :
                // fontes/g/CanecaLexico.g:1:563: CONSTANTE_INTEIRA
                {
                mCONSTANTE_INTEIRA(); 


                }
                break;
            case 63 :
                // fontes/g/CanecaLexico.g:1:581: CONSTANTE_REAL
                {
                mCONSTANTE_REAL(); 


                }
                break;
            case 64 :
                // fontes/g/CanecaLexico.g:1:596: LITERAL_CARACTERE
                {
                mLITERAL_CARACTERE(); 


                }
                break;
            case 65 :
                // fontes/g/CanecaLexico.g:1:614: LITERAL_TEXTO
                {
                mLITERAL_TEXTO(); 


                }
                break;
            case 66 :
                // fontes/g/CanecaLexico.g:1:628: IDENTIFICADOR
                {
                mIDENTIFICADOR(); 


                }
                break;
            case 67 :
                // fontes/g/CanecaLexico.g:1:642: IDENTIFICADOR_DE_PACOTE
                {
                mIDENTIFICADOR_DE_PACOTE(); 


                }
                break;
            case 68 :
                // fontes/g/CanecaLexico.g:1:666: ESPACO_EM_BRANCO
                {
                mESPACO_EM_BRANCO(); 


                }
                break;
            case 69 :
                // fontes/g/CanecaLexico.g:1:683: COMENTARIO_EM_LINHA
                {
                mCOMENTARIO_EM_LINHA(); 


                }
                break;
            case 70 :
                // fontes/g/CanecaLexico.g:1:703: COMENTARIO_EM_BLOCO
                {
                mCOMENTARIO_EM_BLOCO(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\15\46\10\uffff\1\101\1\uffff\1\102\6\uffff\1\104\1\106"+
        "\1\uffff\1\46\1\110\7\uffff\5\46\1\123\17\46\7\uffff\1\46\2\uffff"+
        "\6\46\1\161\2\46\1\uffff\35\46\1\uffff\2\46\1\u0095\10\46\1\u009e"+
        "\1\u009f\3\46\1\u00a3\4\46\1\u00a8\1\u00a9\1\u00aa\11\46\1\u00b4"+
        "\1\u00b5\1\uffff\10\46\2\uffff\1\u00be\1\u00bf\1\46\1\uffff\4\46"+
        "\3\uffff\4\46\1\u00c9\4\46\2\uffff\1\u00cf\3\46\1\u00d5\3\46\2\uffff"+
        "\2\46\1\u00db\1\u00dc\3\46\1\u00e0\1\46\1\uffff\1\46\1\u00e3\1\u00e4"+
        "\1\46\1\u00e6\1\uffff\1\u00e7\1\u00e8\1\46\1\u00ea\1\u00eb\1\uffff"+
        "\1\u00ec\2\46\1\u00ef\1\46\2\uffff\2\46\1\u00f3\1\uffff\2\46\2\uffff"+
        "\1\46\3\uffff\1\46\3\uffff\1\u00f9\1\u00fa\1\uffff\1\46\1\u00fc"+
        "\1\46\1\uffff\1\46\1\u00ff\1\u0100\1\u0101\1\u0102\2\uffff\1\46"+
        "\1\uffff\1\46\1\u0105\4\uffff\1\u0106\1\u00b4\2\uffff";
    static final String DFA13_eofS =
        "\u0107\uffff";
    static final String DFA13_minS =
        "\1\11\1\155\1\145\1\141\1\145\1\141\1\145\1\156\1\145\2\141\1\145"+
        "\1\164\1\157\10\uffff\1\75\1\uffff\1\60\6\uffff\2\75\1\uffff\1\145"+
        "\1\56\7\uffff\1\160\1\151\1\143\1\155\1\154\1\60\1\143\1\151\1\142"+
        "\1\160\1\161\1\163\2\156\1\160\1\155\1\141\1\164\1\162\1\166\1\154"+
        "\7\uffff\1\162\2\uffff\1\154\1\143\1\145\1\165\1\164\1\154\1\60"+
        "\1\163\1\141\1\uffff\1\141\1\157\1\166\1\164\1\154\1\151\1\157\1"+
        "\165\2\141\1\164\1\143\1\164\1\157\2\163\1\157\1\151\1\141\1\157"+
        "\1\144\1\151\1\162\1\145\1\151\3\162\1\141\1\uffff\2\157\1\60\1"+
        "\164\1\141\1\145\1\151\1\164\1\162\1\141\1\164\2\60\2\145\1\165"+
        "\1\60\1\164\1\163\1\144\1\142\3\60\1\141\1\155\1\164\1\155\1\157"+
        "\1\146\1\141\1\165\1\162\2\60\1\uffff\1\145\1\144\1\147\1\143\1"+
        "\141\2\156\1\151\2\uffff\2\60\1\162\1\uffff\1\162\1\145\1\157\1"+
        "\165\3\uffff\1\144\1\151\2\145\1\60\1\141\1\162\1\141\1\145\2\uffff"+
        "\1\60\1\141\1\151\1\141\1\60\1\145\1\164\1\143\2\uffff\1\145\1\165"+
        "\2\60\1\164\1\145\1\162\1\60\1\156\1\uffff\1\143\2\60\1\157\1\60"+
        "\1\uffff\2\60\1\144\2\60\1\uffff\1\60\2\157\1\60\1\164\2\uffff\1"+
        "\157\1\151\1\60\1\uffff\1\164\1\145\2\uffff\1\162\3\uffff\1\141"+
        "\3\uffff\2\60\1\uffff\1\157\1\60\1\162\1\uffff\1\141\4\60\2\uffff"+
        "\1\162\1\uffff\1\157\1\60\4\uffff\2\60\2\uffff";
    static final String DFA13_maxS =
        "\1\176\1\156\1\145\1\151\1\145\1\165\1\145\1\163\1\145\1\141\1\157"+
        "\1\145\1\164\1\165\10\uffff\1\75\1\uffff\1\71\6\uffff\2\75\1\uffff"+
        "\1\145\1\71\7\uffff\1\160\1\164\1\163\1\155\1\154\1\172\1\162\1"+
        "\157\1\142\1\164\1\161\1\164\2\156\1\160\1\156\1\141\1\164\1\162"+
        "\1\166\1\154\7\uffff\1\162\2\uffff\1\162\1\143\1\145\1\165\1\164"+
        "\1\154\1\172\1\163\1\141\1\uffff\1\141\1\157\1\166\1\164\1\154\1"+
        "\151\1\157\1\165\1\141\1\145\1\164\1\143\1\164\1\157\2\163\1\157"+
        "\1\151\2\157\1\144\1\151\1\162\1\145\1\151\3\162\1\141\1\uffff\2"+
        "\157\1\172\1\164\1\141\1\145\1\151\1\164\1\162\1\141\1\164\2\172"+
        "\2\145\1\165\1\172\1\164\1\163\1\144\1\142\3\172\1\141\1\155\1\164"+
        "\1\155\1\157\1\146\1\141\1\165\1\162\2\172\1\uffff\1\145\1\144\1"+
        "\147\1\143\1\141\2\156\1\151\2\uffff\2\172\1\162\1\uffff\1\162\1"+
        "\145\1\157\1\165\3\uffff\1\144\1\151\2\145\1\172\1\141\1\162\1\164"+
        "\1\145\2\uffff\1\172\1\157\1\151\1\157\1\172\1\145\1\164\1\143\2"+
        "\uffff\1\145\1\165\2\172\1\164\1\145\1\162\1\172\1\156\1\uffff\1"+
        "\143\2\172\1\157\1\172\1\uffff\2\172\1\144\2\172\1\uffff\1\172\2"+
        "\157\1\172\1\164\2\uffff\1\157\1\151\1\172\1\uffff\1\164\1\145\2"+
        "\uffff\1\162\3\uffff\1\157\3\uffff\2\172\1\uffff\1\157\1\172\1\162"+
        "\1\uffff\1\141\4\172\2\uffff\1\162\1\uffff\1\157\1\172\4\uffff\2"+
        "\172\2\uffff";
    static final String DFA13_acceptS =
        "\16\uffff\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\uffff\1\56\1"+
        "\uffff\1\60\1\61\1\62\1\63\1\64\1\65\2\uffff\1\73\2\uffff\1\100"+
        "\1\101\1\102\1\103\1\104\1\105\1\106\25\uffff\1\72\1\55\1\57\1\70"+
        "\1\66\1\71\1\67\1\uffff\1\76\1\77\11\uffff\1\5\35\uffff\1\4\43\uffff"+
        "\1\7\10\uffff\1\43\1\44\3\uffff\1\22\4\uffff\1\41\1\42\1\75\11\uffff"+
        "\1\74\1\6\10\uffff\1\12\1\13\11\uffff\1\3\5\uffff\1\20\5\uffff\1"+
        "\10\5\uffff\1\23\1\25\3\uffff\1\21\2\uffff\1\2\1\16\1\uffff\1\17"+
        "\1\33\1\36\1\uffff\1\34\1\37\1\15\2\uffff\1\14\3\uffff\1\1\5\uffff"+
        "\1\11\1\31\1\uffff\1\26\2\uffff\1\24\1\30\1\35\1\40\2\uffff\1\32"+
        "\1\27";
    static final String DFA13_specialS =
        "\u0107\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\50\1\uffff\2\50\22\uffff\1\50\1\41\1\45\1\52\1\uffff\1\33"+
            "\1\35\1\44\1\20\1\21\1\31\1\27\1\24\1\30\1\16\1\32\12\43\1\17"+
            "\1\25\1\37\1\26\1\40\1\51\1\47\32\46\1\22\1\uffff\1\23\3\uffff"+
            "\1\14\1\46\1\12\1\2\1\7\1\3\2\46\1\1\2\46\1\11\1\13\1\15\1\46"+
            "\1\5\1\46\1\6\1\4\1\10\1\46\1\42\4\46\1\uffff\1\36\1\uffff\1"+
            "\34",
            "\1\53\1\54",
            "\1\55",
            "\1\57\7\uffff\1\56",
            "\1\60",
            "\1\61\20\uffff\1\62\2\uffff\1\63",
            "\1\64",
            "\1\65\4\uffff\1\66",
            "\1\67",
            "\1\70",
            "\1\71\12\uffff\1\73\2\uffff\1\72",
            "\1\74",
            "\1\75",
            "\1\76\5\uffff\1\77",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\100",
            "",
            "\12\43",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\103",
            "\1\105",
            "",
            "\1\107",
            "\1\111\1\uffff\12\43",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\112",
            "\1\113\12\uffff\1\114",
            "\1\117\14\uffff\1\115\2\uffff\1\116",
            "\1\120",
            "\1\121",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\15\46\1\122\14\46",
            "\1\125\16\uffff\1\124",
            "\1\126\5\uffff\1\127",
            "\1\130",
            "\1\131\3\uffff\1\132",
            "\1\133",
            "\1\135\1\134",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\150",
            "",
            "",
            "\1\153\2\uffff\1\152\2\uffff\1\151",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\162",
            "\1\163",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\176\3\uffff\1\175",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0088\15\uffff\1\u0087",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "",
            "\1\u0093",
            "\1\u0094",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00c0",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc\22\uffff\1\u00cd",
            "\1\u00ce",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00d1\15\uffff\1\u00d0",
            "\1\u00d2",
            "\1\u00d4\15\uffff\1\u00d3",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "",
            "",
            "\1\u00d9",
            "\1\u00da",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00e1",
            "",
            "\1\u00e2",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00e5",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00e9",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00ed",
            "\1\u00ee",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00f0",
            "",
            "",
            "\1\u00f1",
            "\1\u00f2",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u00f4",
            "\1\u00f5",
            "",
            "",
            "\1\u00f6",
            "",
            "",
            "",
            "\1\u00f8\15\uffff\1\u00f7",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u00fb",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\1\u0103",
            "",
            "\1\u0104",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( IMPRIMIR | DEPURAR | INICIO | FIM | SE | SENAO | PARA | REPITA | ENQUANTO | TENTE | LANCE | CAPTURE | RETORNE | DESTRUA | DECLARE | PACOTE | IMPORTE | COMO | CLASSE | INTERFACE | METODO | ATRIBUTO | CONSTRUTOR | DESTRUTOR | ESTATICO | IMPLEMENTA | PRIVADO | PUBLICO | PROTEGIDO | PRIVADA | PUBLICA | PROTEGIDA | NOVO | NOVA | ESSE | ESSA | CHAMADA_DE_OBJETO | CHAMADA_DE_CLASSE | PARENTESE_ESQUERDO | PARENTESE_DIREITO | COLCHETE_ESQUERDO | COLCHETE_DIREITO | SEPARADOR | TERMINADOR | ATRIBUIDOR | SOMA | SUBTRACAO | MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO | NEGACAO | E | OU | MENOR | MAIOR | MENOR_IGUAL | MAIOR_IGUAL | IGUAL | DIFERENTE | VALOR_BOOLEANO | VALOR_NULO | CONSTANTE_INTEIRA | CONSTANTE_REAL | LITERAL_CARACTERE | LITERAL_TEXTO | IDENTIFICADOR | IDENTIFICADOR_DE_PACOTE | ESPACO_EM_BRANCO | COMENTARIO_EM_LINHA | COMENTARIO_EM_BLOCO );";
        }
    }
 

}