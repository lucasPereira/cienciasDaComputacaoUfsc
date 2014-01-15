// $ANTLR 3.4 fontes/g/CanecaSintatico.g 2012-12-21 09:02:51

	package br.ufsc.inf.ine5426.caneca.antlr;
	import java.lang.System;
	import java.util.List;
	import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class CanecaSintatico extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATRIBUIDOR", "ATRIBUTO", "CAPTURE", "CARACTERE", "CARACTERE_DE_ESCAPE", "CARACTERE_NAO_IMPRIMIVEL", "CHAMADA_DE_CLASSE", "CHAMADA_DE_OBJETO", "CLASSE", "COLCHETE_DIREITO", "COLCHETE_ESQUERDO", "COMENTARIO_EM_BLOCO", "COMENTARIO_EM_LINHA", "COMO", "CONSTANTE_INTEIRA", "CONSTANTE_REAL", "CONSTRUTOR", "DECLARE", "DEPURAR", "DESTRUA", "DESTRUTOR", "DIFERENTE", "DIGITO", "DIVISAO", "E", "ENQUANTO", "ESPACO_EM_BRANCO", "ESSA", "ESSE", "ESTATICO", "FIM", "IDENTIFICADOR", "IDENTIFICADOR_DE_PACOTE", "IGUAL", "IMPLEMENTA", "IMPORTE", "IMPRIMIR", "INICIO", "INTERFACE", "LANCE", "LETRA", "LITERAL_CARACTERE", "LITERAL_TEXTO", "MAIOR", "MAIOR_IGUAL", "MENOR", "MENOR_IGUAL", "METODO", "MULTIPLICACAO", "NEGACAO", "NOVA", "NOVO", "OU", "PACOTE", "PARA", "PARENTESE_DIREITO", "PARENTESE_ESQUERDO", "PRIVADA", "PRIVADO", "PROTEGIDA", "PROTEGIDO", "PUBLICA", "PUBLICO", "QUEBRA_DE_LINHA", "REPITA", "RESTO_DA_DIVISAO", "RETORNE", "SE", "SENAO", "SEPARADOR", "SOMA", "SUBTRACAO", "TABULACAO", "TENTE", "TERMINADOR", "USADO_EM_TEXTO", "VALOR_BOOLEANO", "VALOR_NULO"
    };

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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CanecaSintatico(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CanecaSintatico(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return CanecaSintatico.tokenNames; }
    public String getGrammarFileName() { return "fontes/g/CanecaSintatico.g"; }


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
    			emitErrorMessage(String.format("[Erro sintático] %s %s\n", cabecalhoDeErro, mensagemDeErro));
    		}
    	}
    	
    	@Override
    	public String getErrorMessage(RecognitionException erro, String[] nomeDosSimbolos) {
    		if (erro instanceof UnwantedTokenException) {
    			UnwantedTokenException erroDeSimboloNaoDesejado = (UnwantedTokenException) erro;
    			String entradaNaoDesejada = getTokenErrorDisplay(erroDeSimboloNaoDesejado.getUnexpectedToken());
    			String simboloEsperado = getTokenErrorDisplay(erroDeSimboloNaoDesejado.expecting, nomeDosSimbolos);
    			return String.format("[UnwantedTokenException]\nEntrada não desejada: %s. O símbolo esperado era: %s.", entradaNaoDesejada, simboloEsperado);
    		} else if (erro instanceof MissingTokenException) {
    			MissingTokenException erroDeSimboloFaltando = (MissingTokenException) erro;
    			String simboloFaltando = getTokenErrorDisplay(erroDeSimboloFaltando.expecting, nomeDosSimbolos);
    			String entradaRecebida = getTokenErrorDisplay(erroDeSimboloFaltando.token);
    			return String.format("[MissingTokenException]\nSímbolo faltando: %s. A entrada recebida foi: %s.", simboloFaltando, entradaRecebida);
    		} else if (erro instanceof MismatchedTokenException) {
    			MismatchedTokenException erroDeSimboloIncompativel = (MismatchedTokenException) erro;
    			String entradaIncompativel = getTokenErrorDisplay(erroDeSimboloIncompativel.token);
    			String simboloEsperado = getTokenErrorDisplay(erroDeSimboloIncompativel.expecting, nomeDosSimbolos);
    			return String.format("[MismatchedTokenException]\nEntrada incompátivel: %s. O símbolo esperado era: %s.", entradaIncompativel, simboloEsperado);
    		} else if (erro instanceof MismatchedTreeNodeException) {
    			MismatchedTreeNodeException erroDeNodoIncompativel = (MismatchedTreeNodeException) erro;
    			Object nodoIncompativel = erroDeNodoIncompativel.node;
    			String simboloEsperado = getTokenErrorDisplay(erroDeNodoIncompativel.expecting, nomeDosSimbolos);
    			return String.format("[MismatchedTreeNodeException]\nNodo incompátivel: %s. O símbolo esperado era: %s.", nodoIncompativel.toString(), simboloEsperado);
    		} else if (erro instanceof NoViableAltException) {
    			NoViableAltException erroDeAlternativaInviavel = (NoViableAltException) erro;
    			String entradaRecebida = getTokenErrorDisplay(erroDeAlternativaInviavel.token);
    			return String.format("[NoViableAltException]\nSem alternativa viável. A entrada recebida foi: %s.", entradaRecebida);
    		} else if (erro instanceof EarlyExitException) {
    			EarlyExitException erroDeSaidaPrecoce = (EarlyExitException) erro;
    			String entradaRecebida = getTokenErrorDisplay(erroDeSaidaPrecoce.token);
    			return String.format("[EarlyExitException]\nEsperava-se reconhecer pelo menos uma alternativa, mas não foi reconhecida nenhuma. A entrada recebida foi: %s.", entradaRecebida);
    		} else if (erro instanceof MismatchedSetException) {
    			MismatchedSetException erroDeConjuntoIncompativel = (MismatchedSetException) erro;
    			String entradaIncompativel = getTokenErrorDisplay(erroDeConjuntoIncompativel.token);
    			BitSet conjuntoEsperado = erroDeConjuntoIncompativel.expecting;
    			return String.format("[MismatchedSetException]\nEntrada incompátivel: %s. O conjunto esperado era: %s.", entradaIncompativel, conjuntoEsperado);
    		} else if (erro instanceof MismatchedNotSetException) {
    			MismatchedNotSetException erroDeConjuntoNegadoIncompativel = (MismatchedNotSetException) erro;
    			String entradaIncompativel = getTokenErrorDisplay(erroDeConjuntoNegadoIncompativel.token);
    			BitSet conjuntoNegadoEsperado = erroDeConjuntoNegadoIncompativel.expecting;
    			return String.format("[MismatchedNotSetException]\nEntrada incompátivel: %s. O conjunto negado esperado era: %s.", entradaIncompativel, conjuntoNegadoEsperado);
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
    	
    	public String getTokenErrorDisplay(int tipoDoSimbolo, String[] nomeDosSimbolos) {
    		String nomeDoSimbolo = "DESCONHECIDO";
    		if (tipoDoSimbolo == Token.EOF) {
    			nomeDoSimbolo = "FIM_DE_ARQUIVO";
    		} else if (tipoDoSimbolo >= 0 && tipoDoSimbolo < nomeDosSimbolos.length) {
    			nomeDoSimbolo = nomeDosSimbolos[tipoDoSimbolo];
    		}
    		return String.format("<%s>", nomeDoSimbolo);
    	}


    public static class programa_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "programa"
    // fontes/g/CanecaSintatico.g:153:1: programa : ( unicadeDeCompilacao )+ ;
    public final CanecaSintatico.programa_return programa() throws RecognitionException {
        CanecaSintatico.programa_return retval = new CanecaSintatico.programa_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.unicadeDeCompilacao_return unicadeDeCompilacao1 =null;



        try {
            // fontes/g/CanecaSintatico.g:154:2: ( ( unicadeDeCompilacao )+ )
            // fontes/g/CanecaSintatico.g:154:4: ( unicadeDeCompilacao )+
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:154:4: ( unicadeDeCompilacao )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PACOTE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:154:5: unicadeDeCompilacao
            	    {
            	    pushFollow(FOLLOW_unicadeDeCompilacao_in_programa77);
            	    unicadeDeCompilacao1=unicadeDeCompilacao();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unicadeDeCompilacao1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "programa"


    public static class unicadeDeCompilacao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unicadeDeCompilacao"
    // fontes/g/CanecaSintatico.g:157:1: unicadeDeCompilacao : cabecalho ( classe | interfaces ) ;
    public final CanecaSintatico.unicadeDeCompilacao_return unicadeDeCompilacao() throws RecognitionException {
        CanecaSintatico.unicadeDeCompilacao_return retval = new CanecaSintatico.unicadeDeCompilacao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.cabecalho_return cabecalho2 =null;

        CanecaSintatico.classe_return classe3 =null;

        CanecaSintatico.interfaces_return interfaces4 =null;



        try {
            // fontes/g/CanecaSintatico.g:158:2: ( cabecalho ( classe | interfaces ) )
            // fontes/g/CanecaSintatico.g:158:4: cabecalho ( classe | interfaces )
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_cabecalho_in_unicadeDeCompilacao90);
            cabecalho2=cabecalho();

            state._fsp--;

            adaptor.addChild(root_0, cabecalho2.getTree());

            // fontes/g/CanecaSintatico.g:158:14: ( classe | interfaces )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CLASSE) ) {
                alt2=1;
            }
            else if ( (LA2_0==INTERFACE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:158:15: classe
                    {
                    pushFollow(FOLLOW_classe_in_unicadeDeCompilacao93);
                    classe3=classe();

                    state._fsp--;

                    adaptor.addChild(root_0, classe3.getTree());

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaSintatico.g:158:24: interfaces
                    {
                    pushFollow(FOLLOW_interfaces_in_unicadeDeCompilacao97);
                    interfaces4=interfaces();

                    state._fsp--;

                    adaptor.addChild(root_0, interfaces4.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unicadeDeCompilacao"


    public static class cabecalho_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cabecalho"
    // fontes/g/CanecaSintatico.g:161:1: cabecalho : pacote importacoes ;
    public final CanecaSintatico.cabecalho_return cabecalho() throws RecognitionException {
        CanecaSintatico.cabecalho_return retval = new CanecaSintatico.cabecalho_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.pacote_return pacote5 =null;

        CanecaSintatico.importacoes_return importacoes6 =null;



        try {
            // fontes/g/CanecaSintatico.g:162:2: ( pacote importacoes )
            // fontes/g/CanecaSintatico.g:162:4: pacote importacoes
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_pacote_in_cabecalho109);
            pacote5=pacote();

            state._fsp--;

            adaptor.addChild(root_0, pacote5.getTree());

            pushFollow(FOLLOW_importacoes_in_cabecalho111);
            importacoes6=importacoes();

            state._fsp--;

            adaptor.addChild(root_0, importacoes6.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cabecalho"


    public static class pacote_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pacote"
    // fontes/g/CanecaSintatico.g:165:1: pacote : PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR ;
    public final CanecaSintatico.pacote_return pacote() throws RecognitionException {
        CanecaSintatico.pacote_return retval = new CanecaSintatico.pacote_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PACOTE7=null;
        Token IDENTIFICADOR_DE_PACOTE8=null;
        Token TERMINADOR9=null;

        Object PACOTE7_tree=null;
        Object IDENTIFICADOR_DE_PACOTE8_tree=null;
        Object TERMINADOR9_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:166:2: ( PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR )
            // fontes/g/CanecaSintatico.g:166:4: PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR
            {
            root_0 = (Object)adaptor.nil();


            PACOTE7=(Token)match(input,PACOTE,FOLLOW_PACOTE_in_pacote122); 
            PACOTE7_tree = 
            (Object)adaptor.create(PACOTE7)
            ;
            adaptor.addChild(root_0, PACOTE7_tree);


            IDENTIFICADOR_DE_PACOTE8=(Token)match(input,IDENTIFICADOR_DE_PACOTE,FOLLOW_IDENTIFICADOR_DE_PACOTE_in_pacote124); 
            IDENTIFICADOR_DE_PACOTE8_tree = 
            (Object)adaptor.create(IDENTIFICADOR_DE_PACOTE8)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR_DE_PACOTE8_tree);


            TERMINADOR9=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_pacote126); 
            TERMINADOR9_tree = 
            (Object)adaptor.create(TERMINADOR9)
            ;
            adaptor.addChild(root_0, TERMINADOR9_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pacote"


    public static class importacoes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "importacoes"
    // fontes/g/CanecaSintatico.g:169:1: importacoes : ( importacao )* ;
    public final CanecaSintatico.importacoes_return importacoes() throws RecognitionException {
        CanecaSintatico.importacoes_return retval = new CanecaSintatico.importacoes_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.importacao_return importacao10 =null;



        try {
            // fontes/g/CanecaSintatico.g:170:2: ( ( importacao )* )
            // fontes/g/CanecaSintatico.g:170:4: ( importacao )*
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:170:4: ( importacao )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IMPORTE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:170:5: importacao
            	    {
            	    pushFollow(FOLLOW_importacao_in_importacoes138);
            	    importacao10=importacao();

            	    state._fsp--;

            	    adaptor.addChild(root_0, importacao10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "importacoes"


    public static class importacao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "importacao"
    // fontes/g/CanecaSintatico.g:173:1: importacao : IMPORTE ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? | IDENTIFICADOR_DE_PACOTE ) TERMINADOR ;
    public final CanecaSintatico.importacao_return importacao() throws RecognitionException {
        CanecaSintatico.importacao_return retval = new CanecaSintatico.importacao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IMPORTE11=null;
        Token IDENTIFICADOR12=null;
        Token IDENTIFICADOR_DE_PACOTE13=null;
        Token COMO14=null;
        Token IDENTIFICADOR15=null;
        Token IDENTIFICADOR_DE_PACOTE16=null;
        Token TERMINADOR17=null;

        Object IMPORTE11_tree=null;
        Object IDENTIFICADOR12_tree=null;
        Object IDENTIFICADOR_DE_PACOTE13_tree=null;
        Object COMO14_tree=null;
        Object IDENTIFICADOR15_tree=null;
        Object IDENTIFICADOR_DE_PACOTE16_tree=null;
        Object TERMINADOR17_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:174:2: ( IMPORTE ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? | IDENTIFICADOR_DE_PACOTE ) TERMINADOR )
            // fontes/g/CanecaSintatico.g:174:4: IMPORTE ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? | IDENTIFICADOR_DE_PACOTE ) TERMINADOR
            {
            root_0 = (Object)adaptor.nil();


            IMPORTE11=(Token)match(input,IMPORTE,FOLLOW_IMPORTE_in_importacao151); 
            IMPORTE11_tree = 
            (Object)adaptor.create(IMPORTE11)
            ;
            adaptor.addChild(root_0, IMPORTE11_tree);


            // fontes/g/CanecaSintatico.g:174:12: ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? | IDENTIFICADOR_DE_PACOTE )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENTIFICADOR) ) {
                alt5=1;
            }
            else if ( (LA5_0==IDENTIFICADOR_DE_PACOTE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:174:13: IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )?
                    {
                    IDENTIFICADOR12=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_importacao154); 
                    IDENTIFICADOR12_tree = 
                    (Object)adaptor.create(IDENTIFICADOR12)
                    ;
                    adaptor.addChild(root_0, IDENTIFICADOR12_tree);


                    IDENTIFICADOR_DE_PACOTE13=(Token)match(input,IDENTIFICADOR_DE_PACOTE,FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao156); 
                    IDENTIFICADOR_DE_PACOTE13_tree = 
                    (Object)adaptor.create(IDENTIFICADOR_DE_PACOTE13)
                    ;
                    adaptor.addChild(root_0, IDENTIFICADOR_DE_PACOTE13_tree);


                    // fontes/g/CanecaSintatico.g:174:51: ( COMO IDENTIFICADOR )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==COMO) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // fontes/g/CanecaSintatico.g:174:52: COMO IDENTIFICADOR
                            {
                            COMO14=(Token)match(input,COMO,FOLLOW_COMO_in_importacao159); 
                            COMO14_tree = 
                            (Object)adaptor.create(COMO14)
                            ;
                            adaptor.addChild(root_0, COMO14_tree);


                            IDENTIFICADOR15=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_importacao161); 
                            IDENTIFICADOR15_tree = 
                            (Object)adaptor.create(IDENTIFICADOR15)
                            ;
                            adaptor.addChild(root_0, IDENTIFICADOR15_tree);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaSintatico.g:174:75: IDENTIFICADOR_DE_PACOTE
                    {
                    IDENTIFICADOR_DE_PACOTE16=(Token)match(input,IDENTIFICADOR_DE_PACOTE,FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao167); 
                    IDENTIFICADOR_DE_PACOTE16_tree = 
                    (Object)adaptor.create(IDENTIFICADOR_DE_PACOTE16)
                    ;
                    adaptor.addChild(root_0, IDENTIFICADOR_DE_PACOTE16_tree);


                    }
                    break;

            }


            TERMINADOR17=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_importacao170); 
            TERMINADOR17_tree = 
            (Object)adaptor.create(TERMINADOR17)
            ;
            adaptor.addChild(root_0, TERMINADOR17_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "importacao"


    public static class classe_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "classe"
    // fontes/g/CanecaSintatico.g:177:1: classe : CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse ;
    public final CanecaSintatico.classe_return classe() throws RecognitionException {
        CanecaSintatico.classe_return retval = new CanecaSintatico.classe_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CLASSE18=null;
        Token IDENTIFICADOR20=null;
        CanecaSintatico.modificadorDeAcessoFeminino_return modificadorDeAcessoFeminino19 =null;

        CanecaSintatico.listaDeTiposGenericos_return listaDeTiposGenericos21 =null;

        CanecaSintatico.listaDeInterfaces_return listaDeInterfaces22 =null;

        CanecaSintatico.corpoDaClasse_return corpoDaClasse23 =null;


        Object CLASSE18_tree=null;
        Object IDENTIFICADOR20_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:178:2: ( CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse )
            // fontes/g/CanecaSintatico.g:178:4: CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse
            {
            root_0 = (Object)adaptor.nil();


            CLASSE18=(Token)match(input,CLASSE,FOLLOW_CLASSE_in_classe181); 
            CLASSE18_tree = 
            (Object)adaptor.create(CLASSE18)
            ;
            adaptor.addChild(root_0, CLASSE18_tree);


            pushFollow(FOLLOW_modificadorDeAcessoFeminino_in_classe183);
            modificadorDeAcessoFeminino19=modificadorDeAcessoFeminino();

            state._fsp--;

            adaptor.addChild(root_0, modificadorDeAcessoFeminino19.getTree());

            IDENTIFICADOR20=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_classe185); 
            IDENTIFICADOR20_tree = 
            (Object)adaptor.create(IDENTIFICADOR20)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR20_tree);


            pushFollow(FOLLOW_listaDeTiposGenericos_in_classe187);
            listaDeTiposGenericos21=listaDeTiposGenericos();

            state._fsp--;

            adaptor.addChild(root_0, listaDeTiposGenericos21.getTree());

            pushFollow(FOLLOW_listaDeInterfaces_in_classe189);
            listaDeInterfaces22=listaDeInterfaces();

            state._fsp--;

            adaptor.addChild(root_0, listaDeInterfaces22.getTree());

            pushFollow(FOLLOW_corpoDaClasse_in_classe191);
            corpoDaClasse23=corpoDaClasse();

            state._fsp--;

            adaptor.addChild(root_0, corpoDaClasse23.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "classe"


    public static class interfaces_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "interfaces"
    // fontes/g/CanecaSintatico.g:181:1: interfaces : INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface ;
    public final CanecaSintatico.interfaces_return interfaces() throws RecognitionException {
        CanecaSintatico.interfaces_return retval = new CanecaSintatico.interfaces_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INTERFACE24=null;
        Token IDENTIFICADOR26=null;
        CanecaSintatico.modificadorDeAcessoFeminino_return modificadorDeAcessoFeminino25 =null;

        CanecaSintatico.listaDeTiposGenericos_return listaDeTiposGenericos27 =null;

        CanecaSintatico.listaDeInterfaces_return listaDeInterfaces28 =null;

        CanecaSintatico.corpoDaInterface_return corpoDaInterface29 =null;


        Object INTERFACE24_tree=null;
        Object IDENTIFICADOR26_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:182:2: ( INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface )
            // fontes/g/CanecaSintatico.g:182:4: INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface
            {
            root_0 = (Object)adaptor.nil();


            INTERFACE24=(Token)match(input,INTERFACE,FOLLOW_INTERFACE_in_interfaces202); 
            INTERFACE24_tree = 
            (Object)adaptor.create(INTERFACE24)
            ;
            adaptor.addChild(root_0, INTERFACE24_tree);


            pushFollow(FOLLOW_modificadorDeAcessoFeminino_in_interfaces204);
            modificadorDeAcessoFeminino25=modificadorDeAcessoFeminino();

            state._fsp--;

            adaptor.addChild(root_0, modificadorDeAcessoFeminino25.getTree());

            IDENTIFICADOR26=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_interfaces206); 
            IDENTIFICADOR26_tree = 
            (Object)adaptor.create(IDENTIFICADOR26)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR26_tree);


            pushFollow(FOLLOW_listaDeTiposGenericos_in_interfaces208);
            listaDeTiposGenericos27=listaDeTiposGenericos();

            state._fsp--;

            adaptor.addChild(root_0, listaDeTiposGenericos27.getTree());

            pushFollow(FOLLOW_listaDeInterfaces_in_interfaces210);
            listaDeInterfaces28=listaDeInterfaces();

            state._fsp--;

            adaptor.addChild(root_0, listaDeInterfaces28.getTree());

            pushFollow(FOLLOW_corpoDaInterface_in_interfaces212);
            corpoDaInterface29=corpoDaInterface();

            state._fsp--;

            adaptor.addChild(root_0, corpoDaInterface29.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "interfaces"


    public static class corpoDaClasse_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "corpoDaClasse"
    // fontes/g/CanecaSintatico.g:185:1: corpoDaClasse : INICIO atributos construtores destrutor metodos FIM ;
    public final CanecaSintatico.corpoDaClasse_return corpoDaClasse() throws RecognitionException {
        CanecaSintatico.corpoDaClasse_return retval = new CanecaSintatico.corpoDaClasse_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INICIO30=null;
        Token FIM35=null;
        CanecaSintatico.atributos_return atributos31 =null;

        CanecaSintatico.construtores_return construtores32 =null;

        CanecaSintatico.destrutor_return destrutor33 =null;

        CanecaSintatico.metodos_return metodos34 =null;


        Object INICIO30_tree=null;
        Object FIM35_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:186:2: ( INICIO atributos construtores destrutor metodos FIM )
            // fontes/g/CanecaSintatico.g:186:4: INICIO atributos construtores destrutor metodos FIM
            {
            root_0 = (Object)adaptor.nil();


            INICIO30=(Token)match(input,INICIO,FOLLOW_INICIO_in_corpoDaClasse223); 
            INICIO30_tree = 
            (Object)adaptor.create(INICIO30)
            ;
            adaptor.addChild(root_0, INICIO30_tree);


            pushFollow(FOLLOW_atributos_in_corpoDaClasse225);
            atributos31=atributos();

            state._fsp--;

            adaptor.addChild(root_0, atributos31.getTree());

            pushFollow(FOLLOW_construtores_in_corpoDaClasse227);
            construtores32=construtores();

            state._fsp--;

            adaptor.addChild(root_0, construtores32.getTree());

            pushFollow(FOLLOW_destrutor_in_corpoDaClasse229);
            destrutor33=destrutor();

            state._fsp--;

            adaptor.addChild(root_0, destrutor33.getTree());

            pushFollow(FOLLOW_metodos_in_corpoDaClasse231);
            metodos34=metodos();

            state._fsp--;

            adaptor.addChild(root_0, metodos34.getTree());

            FIM35=(Token)match(input,FIM,FOLLOW_FIM_in_corpoDaClasse233); 
            FIM35_tree = 
            (Object)adaptor.create(FIM35)
            ;
            adaptor.addChild(root_0, FIM35_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "corpoDaClasse"


    public static class corpoDaInterface_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "corpoDaInterface"
    // fontes/g/CanecaSintatico.g:189:1: corpoDaInterface : INICIO atributos assinaturasDeMetodos FIM ;
    public final CanecaSintatico.corpoDaInterface_return corpoDaInterface() throws RecognitionException {
        CanecaSintatico.corpoDaInterface_return retval = new CanecaSintatico.corpoDaInterface_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INICIO36=null;
        Token FIM39=null;
        CanecaSintatico.atributos_return atributos37 =null;

        CanecaSintatico.assinaturasDeMetodos_return assinaturasDeMetodos38 =null;


        Object INICIO36_tree=null;
        Object FIM39_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:190:2: ( INICIO atributos assinaturasDeMetodos FIM )
            // fontes/g/CanecaSintatico.g:190:4: INICIO atributos assinaturasDeMetodos FIM
            {
            root_0 = (Object)adaptor.nil();


            INICIO36=(Token)match(input,INICIO,FOLLOW_INICIO_in_corpoDaInterface244); 
            INICIO36_tree = 
            (Object)adaptor.create(INICIO36)
            ;
            adaptor.addChild(root_0, INICIO36_tree);


            pushFollow(FOLLOW_atributos_in_corpoDaInterface246);
            atributos37=atributos();

            state._fsp--;

            adaptor.addChild(root_0, atributos37.getTree());

            pushFollow(FOLLOW_assinaturasDeMetodos_in_corpoDaInterface248);
            assinaturasDeMetodos38=assinaturasDeMetodos();

            state._fsp--;

            adaptor.addChild(root_0, assinaturasDeMetodos38.getTree());

            FIM39=(Token)match(input,FIM,FOLLOW_FIM_in_corpoDaInterface250); 
            FIM39_tree = 
            (Object)adaptor.create(FIM39)
            ;
            adaptor.addChild(root_0, FIM39_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "corpoDaInterface"


    public static class atributos_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atributos"
    // fontes/g/CanecaSintatico.g:193:1: atributos : ( atributo )* ;
    public final CanecaSintatico.atributos_return atributos() throws RecognitionException {
        CanecaSintatico.atributos_return retval = new CanecaSintatico.atributos_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.atributo_return atributo40 =null;



        try {
            // fontes/g/CanecaSintatico.g:194:2: ( ( atributo )* )
            // fontes/g/CanecaSintatico.g:194:4: ( atributo )*
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:194:4: ( atributo )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ATRIBUTO) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:194:5: atributo
            	    {
            	    pushFollow(FOLLOW_atributo_in_atributos262);
            	    atributo40=atributo();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atributo40.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atributos"


    public static class construtores_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "construtores"
    // fontes/g/CanecaSintatico.g:197:1: construtores : ( construtor )+ ;
    public final CanecaSintatico.construtores_return construtores() throws RecognitionException {
        CanecaSintatico.construtores_return retval = new CanecaSintatico.construtores_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.construtor_return construtor41 =null;



        try {
            // fontes/g/CanecaSintatico.g:198:2: ( ( construtor )+ )
            // fontes/g/CanecaSintatico.g:198:4: ( construtor )+
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:198:4: ( construtor )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==CONSTRUTOR) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:198:5: construtor
            	    {
            	    pushFollow(FOLLOW_construtor_in_construtores276);
            	    construtor41=construtor();

            	    state._fsp--;

            	    adaptor.addChild(root_0, construtor41.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "construtores"


    public static class metodos_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "metodos"
    // fontes/g/CanecaSintatico.g:201:1: metodos : ( metodo )* ;
    public final CanecaSintatico.metodos_return metodos() throws RecognitionException {
        CanecaSintatico.metodos_return retval = new CanecaSintatico.metodos_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.metodo_return metodo42 =null;



        try {
            // fontes/g/CanecaSintatico.g:202:2: ( ( metodo )* )
            // fontes/g/CanecaSintatico.g:202:4: ( metodo )*
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:202:4: ( metodo )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==METODO) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:202:5: metodo
            	    {
            	    pushFollow(FOLLOW_metodo_in_metodos290);
            	    metodo42=metodo();

            	    state._fsp--;

            	    adaptor.addChild(root_0, metodo42.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metodos"


    public static class assinaturasDeMetodos_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturasDeMetodos"
    // fontes/g/CanecaSintatico.g:205:1: assinaturasDeMetodos : ( assinaturaDeMetodo TERMINADOR )* ;
    public final CanecaSintatico.assinaturasDeMetodos_return assinaturasDeMetodos() throws RecognitionException {
        CanecaSintatico.assinaturasDeMetodos_return retval = new CanecaSintatico.assinaturasDeMetodos_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token TERMINADOR44=null;
        CanecaSintatico.assinaturaDeMetodo_return assinaturaDeMetodo43 =null;


        Object TERMINADOR44_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:206:2: ( ( assinaturaDeMetodo TERMINADOR )* )
            // fontes/g/CanecaSintatico.g:206:4: ( assinaturaDeMetodo TERMINADOR )*
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:206:4: ( assinaturaDeMetodo TERMINADOR )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==METODO) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:206:5: assinaturaDeMetodo TERMINADOR
            	    {
            	    pushFollow(FOLLOW_assinaturaDeMetodo_in_assinaturasDeMetodos304);
            	    assinaturaDeMetodo43=assinaturaDeMetodo();

            	    state._fsp--;

            	    adaptor.addChild(root_0, assinaturaDeMetodo43.getTree());

            	    TERMINADOR44=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_assinaturasDeMetodos306); 
            	    TERMINADOR44_tree = 
            	    (Object)adaptor.create(TERMINADOR44)
            	    ;
            	    adaptor.addChild(root_0, TERMINADOR44_tree);


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturasDeMetodos"


    public static class atributo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atributo"
    // fontes/g/CanecaSintatico.g:209:1: atributo : ATRIBUTO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ( ATRIBUIDOR expressaoOuLogico )? TERMINADOR ;
    public final CanecaSintatico.atributo_return atributo() throws RecognitionException {
        CanecaSintatico.atributo_return retval = new CanecaSintatico.atributo_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ATRIBUTO45=null;
        Token ESTATICO47=null;
        Token IDENTIFICADOR49=null;
        Token ATRIBUIDOR50=null;
        Token TERMINADOR52=null;
        CanecaSintatico.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino46 =null;

        CanecaSintatico.tipo_return tipo48 =null;

        CanecaSintatico.expressaoOuLogico_return expressaoOuLogico51 =null;


        Object ATRIBUTO45_tree=null;
        Object ESTATICO47_tree=null;
        Object IDENTIFICADOR49_tree=null;
        Object ATRIBUIDOR50_tree=null;
        Object TERMINADOR52_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:210:2: ( ATRIBUTO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ( ATRIBUIDOR expressaoOuLogico )? TERMINADOR )
            // fontes/g/CanecaSintatico.g:210:4: ATRIBUTO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ( ATRIBUIDOR expressaoOuLogico )? TERMINADOR
            {
            root_0 = (Object)adaptor.nil();


            ATRIBUTO45=(Token)match(input,ATRIBUTO,FOLLOW_ATRIBUTO_in_atributo319); 
            ATRIBUTO45_tree = 
            (Object)adaptor.create(ATRIBUTO45)
            ;
            adaptor.addChild(root_0, ATRIBUTO45_tree);


            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_atributo321);
            modificadorDeAcessoMasculino46=modificadorDeAcessoMasculino();

            state._fsp--;

            adaptor.addChild(root_0, modificadorDeAcessoMasculino46.getTree());

            // fontes/g/CanecaSintatico.g:210:42: ( ESTATICO )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ESTATICO) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:210:43: ESTATICO
                    {
                    ESTATICO47=(Token)match(input,ESTATICO,FOLLOW_ESTATICO_in_atributo324); 
                    ESTATICO47_tree = 
                    (Object)adaptor.create(ESTATICO47)
                    ;
                    adaptor.addChild(root_0, ESTATICO47_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_tipo_in_atributo328);
            tipo48=tipo();

            state._fsp--;

            adaptor.addChild(root_0, tipo48.getTree());

            IDENTIFICADOR49=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_atributo330); 
            IDENTIFICADOR49_tree = 
            (Object)adaptor.create(IDENTIFICADOR49)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR49_tree);


            // fontes/g/CanecaSintatico.g:210:73: ( ATRIBUIDOR expressaoOuLogico )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ATRIBUIDOR) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:210:74: ATRIBUIDOR expressaoOuLogico
                    {
                    ATRIBUIDOR50=(Token)match(input,ATRIBUIDOR,FOLLOW_ATRIBUIDOR_in_atributo333); 
                    ATRIBUIDOR50_tree = 
                    (Object)adaptor.create(ATRIBUIDOR50)
                    ;
                    adaptor.addChild(root_0, ATRIBUIDOR50_tree);


                    pushFollow(FOLLOW_expressaoOuLogico_in_atributo335);
                    expressaoOuLogico51=expressaoOuLogico();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoOuLogico51.getTree());

                    }
                    break;

            }


            TERMINADOR52=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_atributo339); 
            TERMINADOR52_tree = 
            (Object)adaptor.create(TERMINADOR52)
            ;
            adaptor.addChild(root_0, TERMINADOR52_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atributo"


    public static class construtor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "construtor"
    // fontes/g/CanecaSintatico.g:213:1: construtor : assinaturaDeConstrutor blocoDeInstrucoes ;
    public final CanecaSintatico.construtor_return construtor() throws RecognitionException {
        CanecaSintatico.construtor_return retval = new CanecaSintatico.construtor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.assinaturaDeConstrutor_return assinaturaDeConstrutor53 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes54 =null;



        try {
            // fontes/g/CanecaSintatico.g:214:2: ( assinaturaDeConstrutor blocoDeInstrucoes )
            // fontes/g/CanecaSintatico.g:214:4: assinaturaDeConstrutor blocoDeInstrucoes
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_assinaturaDeConstrutor_in_construtor350);
            assinaturaDeConstrutor53=assinaturaDeConstrutor();

            state._fsp--;

            adaptor.addChild(root_0, assinaturaDeConstrutor53.getTree());

            pushFollow(FOLLOW_blocoDeInstrucoes_in_construtor352);
            blocoDeInstrucoes54=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes54.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "construtor"


    public static class destrutor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "destrutor"
    // fontes/g/CanecaSintatico.g:217:1: destrutor : assinaturaDeDestrutor blocoDeInstrucoes ;
    public final CanecaSintatico.destrutor_return destrutor() throws RecognitionException {
        CanecaSintatico.destrutor_return retval = new CanecaSintatico.destrutor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.assinaturaDeDestrutor_return assinaturaDeDestrutor55 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes56 =null;



        try {
            // fontes/g/CanecaSintatico.g:218:2: ( assinaturaDeDestrutor blocoDeInstrucoes )
            // fontes/g/CanecaSintatico.g:218:4: assinaturaDeDestrutor blocoDeInstrucoes
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_assinaturaDeDestrutor_in_destrutor363);
            assinaturaDeDestrutor55=assinaturaDeDestrutor();

            state._fsp--;

            adaptor.addChild(root_0, assinaturaDeDestrutor55.getTree());

            pushFollow(FOLLOW_blocoDeInstrucoes_in_destrutor365);
            blocoDeInstrucoes56=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes56.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "destrutor"


    public static class metodo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "metodo"
    // fontes/g/CanecaSintatico.g:221:1: metodo : assinaturaDeMetodo blocoDeInstrucoes ;
    public final CanecaSintatico.metodo_return metodo() throws RecognitionException {
        CanecaSintatico.metodo_return retval = new CanecaSintatico.metodo_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.assinaturaDeMetodo_return assinaturaDeMetodo57 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes58 =null;



        try {
            // fontes/g/CanecaSintatico.g:222:2: ( assinaturaDeMetodo blocoDeInstrucoes )
            // fontes/g/CanecaSintatico.g:222:4: assinaturaDeMetodo blocoDeInstrucoes
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_assinaturaDeMetodo_in_metodo376);
            assinaturaDeMetodo57=assinaturaDeMetodo();

            state._fsp--;

            adaptor.addChild(root_0, assinaturaDeMetodo57.getTree());

            pushFollow(FOLLOW_blocoDeInstrucoes_in_metodo378);
            blocoDeInstrucoes58=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes58.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metodo"


    public static class assinaturaDeConstrutor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturaDeConstrutor"
    // fontes/g/CanecaSintatico.g:225:1: assinaturaDeConstrutor : CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos ;
    public final CanecaSintatico.assinaturaDeConstrutor_return assinaturaDeConstrutor() throws RecognitionException {
        CanecaSintatico.assinaturaDeConstrutor_return retval = new CanecaSintatico.assinaturaDeConstrutor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CONSTRUTOR59=null;
        Token IDENTIFICADOR61=null;
        CanecaSintatico.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino60 =null;

        CanecaSintatico.listaDeArgumentos_return listaDeArgumentos62 =null;


        Object CONSTRUTOR59_tree=null;
        Object IDENTIFICADOR61_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:226:2: ( CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos )
            // fontes/g/CanecaSintatico.g:226:4: CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos
            {
            root_0 = (Object)adaptor.nil();


            CONSTRUTOR59=(Token)match(input,CONSTRUTOR,FOLLOW_CONSTRUTOR_in_assinaturaDeConstrutor389); 
            CONSTRUTOR59_tree = 
            (Object)adaptor.create(CONSTRUTOR59)
            ;
            adaptor.addChild(root_0, CONSTRUTOR59_tree);


            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeConstrutor391);
            modificadorDeAcessoMasculino60=modificadorDeAcessoMasculino();

            state._fsp--;

            adaptor.addChild(root_0, modificadorDeAcessoMasculino60.getTree());

            IDENTIFICADOR61=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_assinaturaDeConstrutor393); 
            IDENTIFICADOR61_tree = 
            (Object)adaptor.create(IDENTIFICADOR61)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR61_tree);


            pushFollow(FOLLOW_listaDeArgumentos_in_assinaturaDeConstrutor395);
            listaDeArgumentos62=listaDeArgumentos();

            state._fsp--;

            adaptor.addChild(root_0, listaDeArgumentos62.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturaDeConstrutor"


    public static class assinaturaDeDestrutor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturaDeDestrutor"
    // fontes/g/CanecaSintatico.g:229:1: assinaturaDeDestrutor : DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia ;
    public final CanecaSintatico.assinaturaDeDestrutor_return assinaturaDeDestrutor() throws RecognitionException {
        CanecaSintatico.assinaturaDeDestrutor_return retval = new CanecaSintatico.assinaturaDeDestrutor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token DESTRUTOR63=null;
        Token IDENTIFICADOR65=null;
        CanecaSintatico.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino64 =null;

        CanecaSintatico.listaDeArgumentosVazia_return listaDeArgumentosVazia66 =null;


        Object DESTRUTOR63_tree=null;
        Object IDENTIFICADOR65_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:230:2: ( DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia )
            // fontes/g/CanecaSintatico.g:230:4: DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia
            {
            root_0 = (Object)adaptor.nil();


            DESTRUTOR63=(Token)match(input,DESTRUTOR,FOLLOW_DESTRUTOR_in_assinaturaDeDestrutor406); 
            DESTRUTOR63_tree = 
            (Object)adaptor.create(DESTRUTOR63)
            ;
            adaptor.addChild(root_0, DESTRUTOR63_tree);


            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeDestrutor408);
            modificadorDeAcessoMasculino64=modificadorDeAcessoMasculino();

            state._fsp--;

            adaptor.addChild(root_0, modificadorDeAcessoMasculino64.getTree());

            IDENTIFICADOR65=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_assinaturaDeDestrutor410); 
            IDENTIFICADOR65_tree = 
            (Object)adaptor.create(IDENTIFICADOR65)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR65_tree);


            pushFollow(FOLLOW_listaDeArgumentosVazia_in_assinaturaDeDestrutor412);
            listaDeArgumentosVazia66=listaDeArgumentosVazia();

            state._fsp--;

            adaptor.addChild(root_0, listaDeArgumentosVazia66.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturaDeDestrutor"


    public static class assinaturaDeMetodo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturaDeMetodo"
    // fontes/g/CanecaSintatico.g:233:1: assinaturaDeMetodo : METODO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos ;
    public final CanecaSintatico.assinaturaDeMetodo_return assinaturaDeMetodo() throws RecognitionException {
        CanecaSintatico.assinaturaDeMetodo_return retval = new CanecaSintatico.assinaturaDeMetodo_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token METODO67=null;
        Token ESTATICO69=null;
        Token IDENTIFICADOR71=null;
        CanecaSintatico.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino68 =null;

        CanecaSintatico.tipo_return tipo70 =null;

        CanecaSintatico.listaDeArgumentos_return listaDeArgumentos72 =null;


        Object METODO67_tree=null;
        Object ESTATICO69_tree=null;
        Object IDENTIFICADOR71_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:234:2: ( METODO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos )
            // fontes/g/CanecaSintatico.g:234:4: METODO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos
            {
            root_0 = (Object)adaptor.nil();


            METODO67=(Token)match(input,METODO,FOLLOW_METODO_in_assinaturaDeMetodo423); 
            METODO67_tree = 
            (Object)adaptor.create(METODO67)
            ;
            adaptor.addChild(root_0, METODO67_tree);


            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeMetodo425);
            modificadorDeAcessoMasculino68=modificadorDeAcessoMasculino();

            state._fsp--;

            adaptor.addChild(root_0, modificadorDeAcessoMasculino68.getTree());

            // fontes/g/CanecaSintatico.g:234:40: ( ESTATICO )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ESTATICO) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:234:41: ESTATICO
                    {
                    ESTATICO69=(Token)match(input,ESTATICO,FOLLOW_ESTATICO_in_assinaturaDeMetodo428); 
                    ESTATICO69_tree = 
                    (Object)adaptor.create(ESTATICO69)
                    ;
                    adaptor.addChild(root_0, ESTATICO69_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_tipo_in_assinaturaDeMetodo432);
            tipo70=tipo();

            state._fsp--;

            adaptor.addChild(root_0, tipo70.getTree());

            IDENTIFICADOR71=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_assinaturaDeMetodo434); 
            IDENTIFICADOR71_tree = 
            (Object)adaptor.create(IDENTIFICADOR71)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR71_tree);


            pushFollow(FOLLOW_listaDeArgumentos_in_assinaturaDeMetodo436);
            listaDeArgumentos72=listaDeArgumentos();

            state._fsp--;

            adaptor.addChild(root_0, listaDeArgumentos72.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturaDeMetodo"


    public static class modificadorDeAcessoMasculino_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "modificadorDeAcessoMasculino"
    // fontes/g/CanecaSintatico.g:237:1: modificadorDeAcessoMasculino : ( PUBLICO | PRIVADO | PROTEGIDO );
    public final CanecaSintatico.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino() throws RecognitionException {
        CanecaSintatico.modificadorDeAcessoMasculino_return retval = new CanecaSintatico.modificadorDeAcessoMasculino_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set73=null;

        Object set73_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:238:2: ( PUBLICO | PRIVADO | PROTEGIDO )
            // fontes/g/CanecaSintatico.g:
            {
            root_0 = (Object)adaptor.nil();


            set73=(Token)input.LT(1);

            if ( input.LA(1)==PRIVADO||input.LA(1)==PROTEGIDO||input.LA(1)==PUBLICO ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set73)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "modificadorDeAcessoMasculino"


    public static class modificadorDeAcessoFeminino_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "modificadorDeAcessoFeminino"
    // fontes/g/CanecaSintatico.g:243:1: modificadorDeAcessoFeminino : ( PUBLICA | PRIVADA | PROTEGIDA );
    public final CanecaSintatico.modificadorDeAcessoFeminino_return modificadorDeAcessoFeminino() throws RecognitionException {
        CanecaSintatico.modificadorDeAcessoFeminino_return retval = new CanecaSintatico.modificadorDeAcessoFeminino_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set74=null;

        Object set74_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:244:2: ( PUBLICA | PRIVADA | PROTEGIDA )
            // fontes/g/CanecaSintatico.g:
            {
            root_0 = (Object)adaptor.nil();


            set74=(Token)input.LT(1);

            if ( input.LA(1)==PRIVADA||input.LA(1)==PROTEGIDA||input.LA(1)==PUBLICA ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set74)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "modificadorDeAcessoFeminino"


    public static class listaDeParametros_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeParametros"
    // fontes/g/CanecaSintatico.g:249:1: listaDeParametros : PARENTESE_ESQUERDO ( expressao ( SEPARADOR expressao )* )? PARENTESE_DIREITO ;
    public final CanecaSintatico.listaDeParametros_return listaDeParametros() throws RecognitionException {
        CanecaSintatico.listaDeParametros_return retval = new CanecaSintatico.listaDeParametros_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PARENTESE_ESQUERDO75=null;
        Token SEPARADOR77=null;
        Token PARENTESE_DIREITO79=null;
        CanecaSintatico.expressao_return expressao76 =null;

        CanecaSintatico.expressao_return expressao78 =null;


        Object PARENTESE_ESQUERDO75_tree=null;
        Object SEPARADOR77_tree=null;
        Object PARENTESE_DIREITO79_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:250:2: ( PARENTESE_ESQUERDO ( expressao ( SEPARADOR expressao )* )? PARENTESE_DIREITO )
            // fontes/g/CanecaSintatico.g:250:4: PARENTESE_ESQUERDO ( expressao ( SEPARADOR expressao )* )? PARENTESE_DIREITO
            {
            root_0 = (Object)adaptor.nil();


            PARENTESE_ESQUERDO75=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_listaDeParametros489); 
            PARENTESE_ESQUERDO75_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO75)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO75_tree);


            // fontes/g/CanecaSintatico.g:250:23: ( expressao ( SEPARADOR expressao )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0 >= CONSTANTE_INTEIRA && LA14_0 <= CONSTANTE_REAL)||(LA14_0 >= ESSA && LA14_0 <= ESSE)||LA14_0==IDENTIFICADOR||(LA14_0 >= LITERAL_CARACTERE && LA14_0 <= LITERAL_TEXTO)||(LA14_0 >= NEGACAO && LA14_0 <= NOVO)||LA14_0==PARENTESE_ESQUERDO||LA14_0==SUBTRACAO||(LA14_0 >= VALOR_BOOLEANO && LA14_0 <= VALOR_NULO)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:250:24: expressao ( SEPARADOR expressao )*
                    {
                    pushFollow(FOLLOW_expressao_in_listaDeParametros492);
                    expressao76=expressao();

                    state._fsp--;

                    adaptor.addChild(root_0, expressao76.getTree());

                    // fontes/g/CanecaSintatico.g:250:34: ( SEPARADOR expressao )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==SEPARADOR) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // fontes/g/CanecaSintatico.g:250:35: SEPARADOR expressao
                    	    {
                    	    SEPARADOR77=(Token)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeParametros495); 
                    	    SEPARADOR77_tree = 
                    	    (Object)adaptor.create(SEPARADOR77)
                    	    ;
                    	    adaptor.addChild(root_0, SEPARADOR77_tree);


                    	    pushFollow(FOLLOW_expressao_in_listaDeParametros497);
                    	    expressao78=expressao();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expressao78.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            PARENTESE_DIREITO79=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_listaDeParametros503); 
            PARENTESE_DIREITO79_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO79)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO79_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeParametros"


    public static class listaDeArgumentosVazia_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeArgumentosVazia"
    // fontes/g/CanecaSintatico.g:253:1: listaDeArgumentosVazia : PARENTESE_ESQUERDO PARENTESE_DIREITO ;
    public final CanecaSintatico.listaDeArgumentosVazia_return listaDeArgumentosVazia() throws RecognitionException {
        CanecaSintatico.listaDeArgumentosVazia_return retval = new CanecaSintatico.listaDeArgumentosVazia_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PARENTESE_ESQUERDO80=null;
        Token PARENTESE_DIREITO81=null;

        Object PARENTESE_ESQUERDO80_tree=null;
        Object PARENTESE_DIREITO81_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:254:2: ( PARENTESE_ESQUERDO PARENTESE_DIREITO )
            // fontes/g/CanecaSintatico.g:254:4: PARENTESE_ESQUERDO PARENTESE_DIREITO
            {
            root_0 = (Object)adaptor.nil();


            PARENTESE_ESQUERDO80=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentosVazia514); 
            PARENTESE_ESQUERDO80_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO80)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO80_tree);


            PARENTESE_DIREITO81=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentosVazia516); 
            PARENTESE_DIREITO81_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO81)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO81_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeArgumentosVazia"


    public static class listaDeArgumentos_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeArgumentos"
    // fontes/g/CanecaSintatico.g:257:1: listaDeArgumentos : PARENTESE_ESQUERDO ( declaracao ( SEPARADOR declaracao )* )? PARENTESE_DIREITO ;
    public final CanecaSintatico.listaDeArgumentos_return listaDeArgumentos() throws RecognitionException {
        CanecaSintatico.listaDeArgumentos_return retval = new CanecaSintatico.listaDeArgumentos_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PARENTESE_ESQUERDO82=null;
        Token SEPARADOR84=null;
        Token PARENTESE_DIREITO86=null;
        CanecaSintatico.declaracao_return declaracao83 =null;

        CanecaSintatico.declaracao_return declaracao85 =null;


        Object PARENTESE_ESQUERDO82_tree=null;
        Object SEPARADOR84_tree=null;
        Object PARENTESE_DIREITO86_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:258:2: ( PARENTESE_ESQUERDO ( declaracao ( SEPARADOR declaracao )* )? PARENTESE_DIREITO )
            // fontes/g/CanecaSintatico.g:258:4: PARENTESE_ESQUERDO ( declaracao ( SEPARADOR declaracao )* )? PARENTESE_DIREITO
            {
            root_0 = (Object)adaptor.nil();


            PARENTESE_ESQUERDO82=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentos527); 
            PARENTESE_ESQUERDO82_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO82)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO82_tree);


            // fontes/g/CanecaSintatico.g:258:23: ( declaracao ( SEPARADOR declaracao )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENTIFICADOR) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:258:24: declaracao ( SEPARADOR declaracao )*
                    {
                    pushFollow(FOLLOW_declaracao_in_listaDeArgumentos530);
                    declaracao83=declaracao();

                    state._fsp--;

                    adaptor.addChild(root_0, declaracao83.getTree());

                    // fontes/g/CanecaSintatico.g:258:35: ( SEPARADOR declaracao )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==SEPARADOR) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // fontes/g/CanecaSintatico.g:258:36: SEPARADOR declaracao
                    	    {
                    	    SEPARADOR84=(Token)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeArgumentos533); 
                    	    SEPARADOR84_tree = 
                    	    (Object)adaptor.create(SEPARADOR84)
                    	    ;
                    	    adaptor.addChild(root_0, SEPARADOR84_tree);


                    	    pushFollow(FOLLOW_declaracao_in_listaDeArgumentos535);
                    	    declaracao85=declaracao();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, declaracao85.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }


            PARENTESE_DIREITO86=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentos541); 
            PARENTESE_DIREITO86_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO86)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO86_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeArgumentos"


    public static class listaDeInterfaces_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeInterfaces"
    // fontes/g/CanecaSintatico.g:261:1: listaDeInterfaces : ( IMPLEMENTA tipo ( SEPARADOR tipo )* )? ;
    public final CanecaSintatico.listaDeInterfaces_return listaDeInterfaces() throws RecognitionException {
        CanecaSintatico.listaDeInterfaces_return retval = new CanecaSintatico.listaDeInterfaces_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IMPLEMENTA87=null;
        Token SEPARADOR89=null;
        CanecaSintatico.tipo_return tipo88 =null;

        CanecaSintatico.tipo_return tipo90 =null;


        Object IMPLEMENTA87_tree=null;
        Object SEPARADOR89_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:262:2: ( ( IMPLEMENTA tipo ( SEPARADOR tipo )* )? )
            // fontes/g/CanecaSintatico.g:262:4: ( IMPLEMENTA tipo ( SEPARADOR tipo )* )?
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:262:4: ( IMPLEMENTA tipo ( SEPARADOR tipo )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IMPLEMENTA) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:262:5: IMPLEMENTA tipo ( SEPARADOR tipo )*
                    {
                    IMPLEMENTA87=(Token)match(input,IMPLEMENTA,FOLLOW_IMPLEMENTA_in_listaDeInterfaces553); 
                    IMPLEMENTA87_tree = 
                    (Object)adaptor.create(IMPLEMENTA87)
                    ;
                    adaptor.addChild(root_0, IMPLEMENTA87_tree);


                    pushFollow(FOLLOW_tipo_in_listaDeInterfaces555);
                    tipo88=tipo();

                    state._fsp--;

                    adaptor.addChild(root_0, tipo88.getTree());

                    // fontes/g/CanecaSintatico.g:262:21: ( SEPARADOR tipo )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==SEPARADOR) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // fontes/g/CanecaSintatico.g:262:22: SEPARADOR tipo
                    	    {
                    	    SEPARADOR89=(Token)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeInterfaces558); 
                    	    SEPARADOR89_tree = 
                    	    (Object)adaptor.create(SEPARADOR89)
                    	    ;
                    	    adaptor.addChild(root_0, SEPARADOR89_tree);


                    	    pushFollow(FOLLOW_tipo_in_listaDeInterfaces560);
                    	    tipo90=tipo();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, tipo90.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeInterfaces"


    public static class listaDeTiposGenericos_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeTiposGenericos"
    // fontes/g/CanecaSintatico.g:265:1: listaDeTiposGenericos : ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )* ;
    public final CanecaSintatico.listaDeTiposGenericos_return listaDeTiposGenericos() throws RecognitionException {
        CanecaSintatico.listaDeTiposGenericos_return retval = new CanecaSintatico.listaDeTiposGenericos_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLCHETE_ESQUERDO91=null;
        Token COLCHETE_DIREITO93=null;
        CanecaSintatico.tipoGenerico_return tipoGenerico92 =null;


        Object COLCHETE_ESQUERDO91_tree=null;
        Object COLCHETE_DIREITO93_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:266:2: ( ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )* )
            // fontes/g/CanecaSintatico.g:266:4: ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )*
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:266:4: ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COLCHETE_ESQUERDO) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:266:5: COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO
            	    {
            	    COLCHETE_ESQUERDO91=(Token)match(input,COLCHETE_ESQUERDO,FOLLOW_COLCHETE_ESQUERDO_in_listaDeTiposGenericos576); 
            	    COLCHETE_ESQUERDO91_tree = 
            	    (Object)adaptor.create(COLCHETE_ESQUERDO91)
            	    ;
            	    adaptor.addChild(root_0, COLCHETE_ESQUERDO91_tree);


            	    pushFollow(FOLLOW_tipoGenerico_in_listaDeTiposGenericos578);
            	    tipoGenerico92=tipoGenerico();

            	    state._fsp--;

            	    adaptor.addChild(root_0, tipoGenerico92.getTree());

            	    COLCHETE_DIREITO93=(Token)match(input,COLCHETE_DIREITO,FOLLOW_COLCHETE_DIREITO_in_listaDeTiposGenericos580); 
            	    COLCHETE_DIREITO93_tree = 
            	    (Object)adaptor.create(COLCHETE_DIREITO93)
            	    ;
            	    adaptor.addChild(root_0, COLCHETE_DIREITO93_tree);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeTiposGenericos"


    public static class listaDeTipos_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeTipos"
    // fontes/g/CanecaSintatico.g:269:1: listaDeTipos : ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )? ;
    public final CanecaSintatico.listaDeTipos_return listaDeTipos() throws RecognitionException {
        CanecaSintatico.listaDeTipos_return retval = new CanecaSintatico.listaDeTipos_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLCHETE_ESQUERDO94=null;
        Token SEPARADOR96=null;
        Token COLCHETE_DIREITO98=null;
        CanecaSintatico.tipo_return tipo95 =null;

        CanecaSintatico.tipo_return tipo97 =null;


        Object COLCHETE_ESQUERDO94_tree=null;
        Object SEPARADOR96_tree=null;
        Object COLCHETE_DIREITO98_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:270:2: ( ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )? )
            // fontes/g/CanecaSintatico.g:270:4: ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )?
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:270:4: ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==COLCHETE_ESQUERDO) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:270:5: COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO
                    {
                    COLCHETE_ESQUERDO94=(Token)match(input,COLCHETE_ESQUERDO,FOLLOW_COLCHETE_ESQUERDO_in_listaDeTipos594); 
                    COLCHETE_ESQUERDO94_tree = 
                    (Object)adaptor.create(COLCHETE_ESQUERDO94)
                    ;
                    adaptor.addChild(root_0, COLCHETE_ESQUERDO94_tree);


                    pushFollow(FOLLOW_tipo_in_listaDeTipos596);
                    tipo95=tipo();

                    state._fsp--;

                    adaptor.addChild(root_0, tipo95.getTree());

                    // fontes/g/CanecaSintatico.g:270:28: ( SEPARADOR tipo )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==SEPARADOR) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // fontes/g/CanecaSintatico.g:270:29: SEPARADOR tipo
                    	    {
                    	    SEPARADOR96=(Token)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeTipos599); 
                    	    SEPARADOR96_tree = 
                    	    (Object)adaptor.create(SEPARADOR96)
                    	    ;
                    	    adaptor.addChild(root_0, SEPARADOR96_tree);


                    	    pushFollow(FOLLOW_tipo_in_listaDeTipos601);
                    	    tipo97=tipo();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, tipo97.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    COLCHETE_DIREITO98=(Token)match(input,COLCHETE_DIREITO,FOLLOW_COLCHETE_DIREITO_in_listaDeTipos605); 
                    COLCHETE_DIREITO98_tree = 
                    (Object)adaptor.create(COLCHETE_DIREITO98)
                    ;
                    adaptor.addChild(root_0, COLCHETE_DIREITO98_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeTipos"


    public static class listaDeCapturas_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeCapturas"
    // fontes/g/CanecaSintatico.g:273:1: listaDeCapturas : ( capture )+ ;
    public final CanecaSintatico.listaDeCapturas_return listaDeCapturas() throws RecognitionException {
        CanecaSintatico.listaDeCapturas_return retval = new CanecaSintatico.listaDeCapturas_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.capture_return capture99 =null;



        try {
            // fontes/g/CanecaSintatico.g:274:2: ( ( capture )+ )
            // fontes/g/CanecaSintatico.g:274:4: ( capture )+
            {
            root_0 = (Object)adaptor.nil();


            // fontes/g/CanecaSintatico.g:274:4: ( capture )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==CAPTURE) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:274:5: capture
            	    {
            	    pushFollow(FOLLOW_capture_in_listaDeCapturas619);
            	    capture99=capture();

            	    state._fsp--;

            	    adaptor.addChild(root_0, capture99.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeCapturas"


    public static class tipoGenerico_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tipoGenerico"
    // fontes/g/CanecaSintatico.g:277:1: tipoGenerico : IDENTIFICADOR listaDeInterfaces ;
    public final CanecaSintatico.tipoGenerico_return tipoGenerico() throws RecognitionException {
        CanecaSintatico.tipoGenerico_return retval = new CanecaSintatico.tipoGenerico_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDENTIFICADOR100=null;
        CanecaSintatico.listaDeInterfaces_return listaDeInterfaces101 =null;


        Object IDENTIFICADOR100_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:278:2: ( IDENTIFICADOR listaDeInterfaces )
            // fontes/g/CanecaSintatico.g:278:4: IDENTIFICADOR listaDeInterfaces
            {
            root_0 = (Object)adaptor.nil();


            IDENTIFICADOR100=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_tipoGenerico632); 
            IDENTIFICADOR100_tree = 
            (Object)adaptor.create(IDENTIFICADOR100)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR100_tree);


            pushFollow(FOLLOW_listaDeInterfaces_in_tipoGenerico634);
            listaDeInterfaces101=listaDeInterfaces();

            state._fsp--;

            adaptor.addChild(root_0, listaDeInterfaces101.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tipoGenerico"


    public static class tipo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tipo"
    // fontes/g/CanecaSintatico.g:281:1: tipo : IDENTIFICADOR listaDeTipos ;
    public final CanecaSintatico.tipo_return tipo() throws RecognitionException {
        CanecaSintatico.tipo_return retval = new CanecaSintatico.tipo_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDENTIFICADOR102=null;
        CanecaSintatico.listaDeTipos_return listaDeTipos103 =null;


        Object IDENTIFICADOR102_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:282:2: ( IDENTIFICADOR listaDeTipos )
            // fontes/g/CanecaSintatico.g:282:4: IDENTIFICADOR listaDeTipos
            {
            root_0 = (Object)adaptor.nil();


            IDENTIFICADOR102=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_tipo645); 
            IDENTIFICADOR102_tree = 
            (Object)adaptor.create(IDENTIFICADOR102)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR102_tree);


            pushFollow(FOLLOW_listaDeTipos_in_tipo647);
            listaDeTipos103=listaDeTipos();

            state._fsp--;

            adaptor.addChild(root_0, listaDeTipos103.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tipo"


    public static class declaracao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declaracao"
    // fontes/g/CanecaSintatico.g:285:1: declaracao : tipo IDENTIFICADOR ;
    public final CanecaSintatico.declaracao_return declaracao() throws RecognitionException {
        CanecaSintatico.declaracao_return retval = new CanecaSintatico.declaracao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDENTIFICADOR105=null;
        CanecaSintatico.tipo_return tipo104 =null;


        Object IDENTIFICADOR105_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:286:2: ( tipo IDENTIFICADOR )
            // fontes/g/CanecaSintatico.g:286:4: tipo IDENTIFICADOR
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_tipo_in_declaracao658);
            tipo104=tipo();

            state._fsp--;

            adaptor.addChild(root_0, tipo104.getTree());

            IDENTIFICADOR105=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_declaracao660); 
            IDENTIFICADOR105_tree = 
            (Object)adaptor.create(IDENTIFICADOR105)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR105_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declaracao"


    public static class declaracaoComAtribuicaoOpcional_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declaracaoComAtribuicaoOpcional"
    // fontes/g/CanecaSintatico.g:289:1: declaracaoComAtribuicaoOpcional : tipo IDENTIFICADOR ( ATRIBUIDOR expressaoOuLogico )? ;
    public final CanecaSintatico.declaracaoComAtribuicaoOpcional_return declaracaoComAtribuicaoOpcional() throws RecognitionException {
        CanecaSintatico.declaracaoComAtribuicaoOpcional_return retval = new CanecaSintatico.declaracaoComAtribuicaoOpcional_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDENTIFICADOR107=null;
        Token ATRIBUIDOR108=null;
        CanecaSintatico.tipo_return tipo106 =null;

        CanecaSintatico.expressaoOuLogico_return expressaoOuLogico109 =null;


        Object IDENTIFICADOR107_tree=null;
        Object ATRIBUIDOR108_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:290:2: ( tipo IDENTIFICADOR ( ATRIBUIDOR expressaoOuLogico )? )
            // fontes/g/CanecaSintatico.g:290:4: tipo IDENTIFICADOR ( ATRIBUIDOR expressaoOuLogico )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_tipo_in_declaracaoComAtribuicaoOpcional671);
            tipo106=tipo();

            state._fsp--;

            adaptor.addChild(root_0, tipo106.getTree());

            IDENTIFICADOR107=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_declaracaoComAtribuicaoOpcional673); 
            IDENTIFICADOR107_tree = 
            (Object)adaptor.create(IDENTIFICADOR107)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR107_tree);


            // fontes/g/CanecaSintatico.g:290:23: ( ATRIBUIDOR expressaoOuLogico )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ATRIBUIDOR) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:290:24: ATRIBUIDOR expressaoOuLogico
                    {
                    ATRIBUIDOR108=(Token)match(input,ATRIBUIDOR,FOLLOW_ATRIBUIDOR_in_declaracaoComAtribuicaoOpcional676); 
                    ATRIBUIDOR108_tree = 
                    (Object)adaptor.create(ATRIBUIDOR108)
                    ;
                    adaptor.addChild(root_0, ATRIBUIDOR108_tree);


                    pushFollow(FOLLOW_expressaoOuLogico_in_declaracaoComAtribuicaoOpcional678);
                    expressaoOuLogico109=expressaoOuLogico();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoOuLogico109.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declaracaoComAtribuicaoOpcional"


    public static class expressao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressao"
    // fontes/g/CanecaSintatico.g:293:1: expressao : expressaoOuLogico ( ATRIBUIDOR expressaoOuLogico )? ;
    public final CanecaSintatico.expressao_return expressao() throws RecognitionException {
        CanecaSintatico.expressao_return retval = new CanecaSintatico.expressao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ATRIBUIDOR111=null;
        CanecaSintatico.expressaoOuLogico_return expressaoOuLogico110 =null;

        CanecaSintatico.expressaoOuLogico_return expressaoOuLogico112 =null;


        Object ATRIBUIDOR111_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:294:2: ( expressaoOuLogico ( ATRIBUIDOR expressaoOuLogico )? )
            // fontes/g/CanecaSintatico.g:294:4: expressaoOuLogico ( ATRIBUIDOR expressaoOuLogico )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expressaoOuLogico_in_expressao691);
            expressaoOuLogico110=expressaoOuLogico();

            state._fsp--;

            adaptor.addChild(root_0, expressaoOuLogico110.getTree());

            // fontes/g/CanecaSintatico.g:294:22: ( ATRIBUIDOR expressaoOuLogico )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ATRIBUIDOR) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:294:23: ATRIBUIDOR expressaoOuLogico
                    {
                    ATRIBUIDOR111=(Token)match(input,ATRIBUIDOR,FOLLOW_ATRIBUIDOR_in_expressao694); 
                    ATRIBUIDOR111_tree = 
                    (Object)adaptor.create(ATRIBUIDOR111)
                    ;
                    adaptor.addChild(root_0, ATRIBUIDOR111_tree);


                    pushFollow(FOLLOW_expressaoOuLogico_in_expressao696);
                    expressaoOuLogico112=expressaoOuLogico();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoOuLogico112.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressao"


    public static class expressaoOuLogico_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoOuLogico"
    // fontes/g/CanecaSintatico.g:297:1: expressaoOuLogico : expressaoELogico ( OU expressaoELogico )* ;
    public final CanecaSintatico.expressaoOuLogico_return expressaoOuLogico() throws RecognitionException {
        CanecaSintatico.expressaoOuLogico_return retval = new CanecaSintatico.expressaoOuLogico_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token OU114=null;
        CanecaSintatico.expressaoELogico_return expressaoELogico113 =null;

        CanecaSintatico.expressaoELogico_return expressaoELogico115 =null;


        Object OU114_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:298:2: ( expressaoELogico ( OU expressaoELogico )* )
            // fontes/g/CanecaSintatico.g:298:4: expressaoELogico ( OU expressaoELogico )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expressaoELogico_in_expressaoOuLogico709);
            expressaoELogico113=expressaoELogico();

            state._fsp--;

            adaptor.addChild(root_0, expressaoELogico113.getTree());

            // fontes/g/CanecaSintatico.g:298:21: ( OU expressaoELogico )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==OU) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:298:22: OU expressaoELogico
            	    {
            	    OU114=(Token)match(input,OU,FOLLOW_OU_in_expressaoOuLogico712); 
            	    OU114_tree = 
            	    (Object)adaptor.create(OU114)
            	    ;
            	    adaptor.addChild(root_0, OU114_tree);


            	    pushFollow(FOLLOW_expressaoELogico_in_expressaoOuLogico714);
            	    expressaoELogico115=expressaoELogico();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expressaoELogico115.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoOuLogico"


    public static class expressaoELogico_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoELogico"
    // fontes/g/CanecaSintatico.g:301:1: expressaoELogico : expressaoComparacaoLogica ( E expressaoComparacaoLogica )* ;
    public final CanecaSintatico.expressaoELogico_return expressaoELogico() throws RecognitionException {
        CanecaSintatico.expressaoELogico_return retval = new CanecaSintatico.expressaoELogico_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token E117=null;
        CanecaSintatico.expressaoComparacaoLogica_return expressaoComparacaoLogica116 =null;

        CanecaSintatico.expressaoComparacaoLogica_return expressaoComparacaoLogica118 =null;


        Object E117_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:302:2: ( expressaoComparacaoLogica ( E expressaoComparacaoLogica )* )
            // fontes/g/CanecaSintatico.g:302:4: expressaoComparacaoLogica ( E expressaoComparacaoLogica )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expressaoComparacaoLogica_in_expressaoELogico727);
            expressaoComparacaoLogica116=expressaoComparacaoLogica();

            state._fsp--;

            adaptor.addChild(root_0, expressaoComparacaoLogica116.getTree());

            // fontes/g/CanecaSintatico.g:302:30: ( E expressaoComparacaoLogica )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==E) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:302:31: E expressaoComparacaoLogica
            	    {
            	    E117=(Token)match(input,E,FOLLOW_E_in_expressaoELogico730); 
            	    E117_tree = 
            	    (Object)adaptor.create(E117)
            	    ;
            	    adaptor.addChild(root_0, E117_tree);


            	    pushFollow(FOLLOW_expressaoComparacaoLogica_in_expressaoELogico732);
            	    expressaoComparacaoLogica118=expressaoComparacaoLogica();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expressaoComparacaoLogica118.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoELogico"


    public static class expressaoComparacaoLogica_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoComparacaoLogica"
    // fontes/g/CanecaSintatico.g:305:1: expressaoComparacaoLogica : expressaoAditiva ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) expressaoAditiva )? ;
    public final CanecaSintatico.expressaoComparacaoLogica_return expressaoComparacaoLogica() throws RecognitionException {
        CanecaSintatico.expressaoComparacaoLogica_return retval = new CanecaSintatico.expressaoComparacaoLogica_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set120=null;
        CanecaSintatico.expressaoAditiva_return expressaoAditiva119 =null;

        CanecaSintatico.expressaoAditiva_return expressaoAditiva121 =null;


        Object set120_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:306:2: ( expressaoAditiva ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) expressaoAditiva )? )
            // fontes/g/CanecaSintatico.g:306:4: expressaoAditiva ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) expressaoAditiva )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica745);
            expressaoAditiva119=expressaoAditiva();

            state._fsp--;

            adaptor.addChild(root_0, expressaoAditiva119.getTree());

            // fontes/g/CanecaSintatico.g:306:21: ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) expressaoAditiva )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==DIFERENTE||LA27_0==IGUAL||(LA27_0 >= MAIOR && LA27_0 <= MENOR_IGUAL)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:306:22: ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) expressaoAditiva
                    {
                    set120=(Token)input.LT(1);

                    if ( input.LA(1)==DIFERENTE||input.LA(1)==IGUAL||(input.LA(1) >= MAIOR && input.LA(1) <= MENOR_IGUAL) ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set120)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica772);
                    expressaoAditiva121=expressaoAditiva();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoAditiva121.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoComparacaoLogica"


    public static class expressaoAditiva_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoAditiva"
    // fontes/g/CanecaSintatico.g:309:1: expressaoAditiva : expressaoMultiplicativa ( ( SOMA | SUBTRACAO ) expressaoMultiplicativa )* ;
    public final CanecaSintatico.expressaoAditiva_return expressaoAditiva() throws RecognitionException {
        CanecaSintatico.expressaoAditiva_return retval = new CanecaSintatico.expressaoAditiva_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set123=null;
        CanecaSintatico.expressaoMultiplicativa_return expressaoMultiplicativa122 =null;

        CanecaSintatico.expressaoMultiplicativa_return expressaoMultiplicativa124 =null;


        Object set123_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:310:2: ( expressaoMultiplicativa ( ( SOMA | SUBTRACAO ) expressaoMultiplicativa )* )
            // fontes/g/CanecaSintatico.g:310:4: expressaoMultiplicativa ( ( SOMA | SUBTRACAO ) expressaoMultiplicativa )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expressaoMultiplicativa_in_expressaoAditiva785);
            expressaoMultiplicativa122=expressaoMultiplicativa();

            state._fsp--;

            adaptor.addChild(root_0, expressaoMultiplicativa122.getTree());

            // fontes/g/CanecaSintatico.g:310:28: ( ( SOMA | SUBTRACAO ) expressaoMultiplicativa )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0 >= SOMA && LA28_0 <= SUBTRACAO)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:310:29: ( SOMA | SUBTRACAO ) expressaoMultiplicativa
            	    {
            	    set123=(Token)input.LT(1);

            	    if ( (input.LA(1) >= SOMA && input.LA(1) <= SUBTRACAO) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (Object)adaptor.create(set123)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_expressaoMultiplicativa_in_expressaoAditiva796);
            	    expressaoMultiplicativa124=expressaoMultiplicativa();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expressaoMultiplicativa124.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoAditiva"


    public static class expressaoMultiplicativa_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoMultiplicativa"
    // fontes/g/CanecaSintatico.g:313:1: expressaoMultiplicativa : expressaoUnaria ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) expressaoUnaria )* ;
    public final CanecaSintatico.expressaoMultiplicativa_return expressaoMultiplicativa() throws RecognitionException {
        CanecaSintatico.expressaoMultiplicativa_return retval = new CanecaSintatico.expressaoMultiplicativa_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set126=null;
        CanecaSintatico.expressaoUnaria_return expressaoUnaria125 =null;

        CanecaSintatico.expressaoUnaria_return expressaoUnaria127 =null;


        Object set126_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:314:2: ( expressaoUnaria ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) expressaoUnaria )* )
            // fontes/g/CanecaSintatico.g:314:4: expressaoUnaria ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) expressaoUnaria )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expressaoUnaria_in_expressaoMultiplicativa809);
            expressaoUnaria125=expressaoUnaria();

            state._fsp--;

            adaptor.addChild(root_0, expressaoUnaria125.getTree());

            // fontes/g/CanecaSintatico.g:314:20: ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) expressaoUnaria )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==DIVISAO||LA29_0==MULTIPLICACAO||LA29_0==RESTO_DA_DIVISAO) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:314:21: ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) expressaoUnaria
            	    {
            	    set126=(Token)input.LT(1);

            	    if ( input.LA(1)==DIVISAO||input.LA(1)==MULTIPLICACAO||input.LA(1)==RESTO_DA_DIVISAO ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (Object)adaptor.create(set126)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_expressaoUnaria_in_expressaoMultiplicativa824);
            	    expressaoUnaria127=expressaoUnaria();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expressaoUnaria127.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoMultiplicativa"


    public static class expressaoUnaria_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoUnaria"
    // fontes/g/CanecaSintatico.g:317:1: expressaoUnaria : ( expressaoPrimaria | SUBTRACAO expressaoPrimaria | NEGACAO expressaoPrimaria );
    public final CanecaSintatico.expressaoUnaria_return expressaoUnaria() throws RecognitionException {
        CanecaSintatico.expressaoUnaria_return retval = new CanecaSintatico.expressaoUnaria_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SUBTRACAO129=null;
        Token NEGACAO131=null;
        CanecaSintatico.expressaoPrimaria_return expressaoPrimaria128 =null;

        CanecaSintatico.expressaoPrimaria_return expressaoPrimaria130 =null;

        CanecaSintatico.expressaoPrimaria_return expressaoPrimaria132 =null;


        Object SUBTRACAO129_tree=null;
        Object NEGACAO131_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:318:2: ( expressaoPrimaria | SUBTRACAO expressaoPrimaria | NEGACAO expressaoPrimaria )
            int alt30=3;
            switch ( input.LA(1) ) {
            case CONSTANTE_INTEIRA:
            case CONSTANTE_REAL:
            case ESSA:
            case ESSE:
            case IDENTIFICADOR:
            case LITERAL_CARACTERE:
            case LITERAL_TEXTO:
            case NOVA:
            case NOVO:
            case PARENTESE_ESQUERDO:
            case VALOR_BOOLEANO:
            case VALOR_NULO:
                {
                alt30=1;
                }
                break;
            case SUBTRACAO:
                {
                alt30=2;
                }
                break;
            case NEGACAO:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:318:4: expressaoPrimaria
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_expressaoPrimaria_in_expressaoUnaria837);
                    expressaoPrimaria128=expressaoPrimaria();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoPrimaria128.getTree());

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaSintatico.g:319:4: SUBTRACAO expressaoPrimaria
                    {
                    root_0 = (Object)adaptor.nil();


                    SUBTRACAO129=(Token)match(input,SUBTRACAO,FOLLOW_SUBTRACAO_in_expressaoUnaria842); 
                    SUBTRACAO129_tree = 
                    (Object)adaptor.create(SUBTRACAO129)
                    ;
                    adaptor.addChild(root_0, SUBTRACAO129_tree);


                    pushFollow(FOLLOW_expressaoPrimaria_in_expressaoUnaria844);
                    expressaoPrimaria130=expressaoPrimaria();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoPrimaria130.getTree());

                    }
                    break;
                case 3 :
                    // fontes/g/CanecaSintatico.g:320:4: NEGACAO expressaoPrimaria
                    {
                    root_0 = (Object)adaptor.nil();


                    NEGACAO131=(Token)match(input,NEGACAO,FOLLOW_NEGACAO_in_expressaoUnaria849); 
                    NEGACAO131_tree = 
                    (Object)adaptor.create(NEGACAO131)
                    ;
                    adaptor.addChild(root_0, NEGACAO131_tree);


                    pushFollow(FOLLOW_expressaoPrimaria_in_expressaoUnaria851);
                    expressaoPrimaria132=expressaoPrimaria();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoPrimaria132.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoUnaria"


    public static class expressaoPrimaria_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoPrimaria"
    // fontes/g/CanecaSintatico.g:323:1: expressaoPrimaria : ( PARENTESE_ESQUERDO expressao PARENTESE_DIREITO | VALOR_BOOLEANO | VALOR_NULO | CONSTANTE_INTEIRA | CONSTANTE_REAL | LITERAL_CARACTERE | LITERAL_TEXTO | comando );
    public final CanecaSintatico.expressaoPrimaria_return expressaoPrimaria() throws RecognitionException {
        CanecaSintatico.expressaoPrimaria_return retval = new CanecaSintatico.expressaoPrimaria_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PARENTESE_ESQUERDO133=null;
        Token PARENTESE_DIREITO135=null;
        Token VALOR_BOOLEANO136=null;
        Token VALOR_NULO137=null;
        Token CONSTANTE_INTEIRA138=null;
        Token CONSTANTE_REAL139=null;
        Token LITERAL_CARACTERE140=null;
        Token LITERAL_TEXTO141=null;
        CanecaSintatico.expressao_return expressao134 =null;

        CanecaSintatico.comando_return comando142 =null;


        Object PARENTESE_ESQUERDO133_tree=null;
        Object PARENTESE_DIREITO135_tree=null;
        Object VALOR_BOOLEANO136_tree=null;
        Object VALOR_NULO137_tree=null;
        Object CONSTANTE_INTEIRA138_tree=null;
        Object CONSTANTE_REAL139_tree=null;
        Object LITERAL_CARACTERE140_tree=null;
        Object LITERAL_TEXTO141_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:324:2: ( PARENTESE_ESQUERDO expressao PARENTESE_DIREITO | VALOR_BOOLEANO | VALOR_NULO | CONSTANTE_INTEIRA | CONSTANTE_REAL | LITERAL_CARACTERE | LITERAL_TEXTO | comando )
            int alt31=8;
            switch ( input.LA(1) ) {
            case PARENTESE_ESQUERDO:
                {
                alt31=1;
                }
                break;
            case VALOR_BOOLEANO:
                {
                alt31=2;
                }
                break;
            case VALOR_NULO:
                {
                alt31=3;
                }
                break;
            case CONSTANTE_INTEIRA:
                {
                alt31=4;
                }
                break;
            case CONSTANTE_REAL:
                {
                alt31=5;
                }
                break;
            case LITERAL_CARACTERE:
                {
                alt31=6;
                }
                break;
            case LITERAL_TEXTO:
                {
                alt31=7;
                }
                break;
            case ESSA:
            case ESSE:
            case IDENTIFICADOR:
            case NOVA:
            case NOVO:
                {
                alt31=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:324:4: PARENTESE_ESQUERDO expressao PARENTESE_DIREITO
                    {
                    root_0 = (Object)adaptor.nil();


                    PARENTESE_ESQUERDO133=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_expressaoPrimaria862); 
                    PARENTESE_ESQUERDO133_tree = 
                    (Object)adaptor.create(PARENTESE_ESQUERDO133)
                    ;
                    adaptor.addChild(root_0, PARENTESE_ESQUERDO133_tree);


                    pushFollow(FOLLOW_expressao_in_expressaoPrimaria864);
                    expressao134=expressao();

                    state._fsp--;

                    adaptor.addChild(root_0, expressao134.getTree());

                    PARENTESE_DIREITO135=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_expressaoPrimaria866); 
                    PARENTESE_DIREITO135_tree = 
                    (Object)adaptor.create(PARENTESE_DIREITO135)
                    ;
                    adaptor.addChild(root_0, PARENTESE_DIREITO135_tree);


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaSintatico.g:325:4: VALOR_BOOLEANO
                    {
                    root_0 = (Object)adaptor.nil();


                    VALOR_BOOLEANO136=(Token)match(input,VALOR_BOOLEANO,FOLLOW_VALOR_BOOLEANO_in_expressaoPrimaria871); 
                    VALOR_BOOLEANO136_tree = 
                    (Object)adaptor.create(VALOR_BOOLEANO136)
                    ;
                    adaptor.addChild(root_0, VALOR_BOOLEANO136_tree);


                    }
                    break;
                case 3 :
                    // fontes/g/CanecaSintatico.g:326:4: VALOR_NULO
                    {
                    root_0 = (Object)adaptor.nil();


                    VALOR_NULO137=(Token)match(input,VALOR_NULO,FOLLOW_VALOR_NULO_in_expressaoPrimaria876); 
                    VALOR_NULO137_tree = 
                    (Object)adaptor.create(VALOR_NULO137)
                    ;
                    adaptor.addChild(root_0, VALOR_NULO137_tree);


                    }
                    break;
                case 4 :
                    // fontes/g/CanecaSintatico.g:327:4: CONSTANTE_INTEIRA
                    {
                    root_0 = (Object)adaptor.nil();


                    CONSTANTE_INTEIRA138=(Token)match(input,CONSTANTE_INTEIRA,FOLLOW_CONSTANTE_INTEIRA_in_expressaoPrimaria881); 
                    CONSTANTE_INTEIRA138_tree = 
                    (Object)adaptor.create(CONSTANTE_INTEIRA138)
                    ;
                    adaptor.addChild(root_0, CONSTANTE_INTEIRA138_tree);


                    }
                    break;
                case 5 :
                    // fontes/g/CanecaSintatico.g:328:4: CONSTANTE_REAL
                    {
                    root_0 = (Object)adaptor.nil();


                    CONSTANTE_REAL139=(Token)match(input,CONSTANTE_REAL,FOLLOW_CONSTANTE_REAL_in_expressaoPrimaria886); 
                    CONSTANTE_REAL139_tree = 
                    (Object)adaptor.create(CONSTANTE_REAL139)
                    ;
                    adaptor.addChild(root_0, CONSTANTE_REAL139_tree);


                    }
                    break;
                case 6 :
                    // fontes/g/CanecaSintatico.g:329:4: LITERAL_CARACTERE
                    {
                    root_0 = (Object)adaptor.nil();


                    LITERAL_CARACTERE140=(Token)match(input,LITERAL_CARACTERE,FOLLOW_LITERAL_CARACTERE_in_expressaoPrimaria891); 
                    LITERAL_CARACTERE140_tree = 
                    (Object)adaptor.create(LITERAL_CARACTERE140)
                    ;
                    adaptor.addChild(root_0, LITERAL_CARACTERE140_tree);


                    }
                    break;
                case 7 :
                    // fontes/g/CanecaSintatico.g:330:4: LITERAL_TEXTO
                    {
                    root_0 = (Object)adaptor.nil();


                    LITERAL_TEXTO141=(Token)match(input,LITERAL_TEXTO,FOLLOW_LITERAL_TEXTO_in_expressaoPrimaria896); 
                    LITERAL_TEXTO141_tree = 
                    (Object)adaptor.create(LITERAL_TEXTO141)
                    ;
                    adaptor.addChild(root_0, LITERAL_TEXTO141_tree);


                    }
                    break;
                case 8 :
                    // fontes/g/CanecaSintatico.g:331:4: comando
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_comando_in_expressaoPrimaria901);
                    comando142=comando();

                    state._fsp--;

                    adaptor.addChild(root_0, comando142.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoPrimaria"


    public static class comando_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comando"
    // fontes/g/CanecaSintatico.g:334:1: comando : referencia ( chamada )* ;
    public final CanecaSintatico.comando_return comando() throws RecognitionException {
        CanecaSintatico.comando_return retval = new CanecaSintatico.comando_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        CanecaSintatico.referencia_return referencia143 =null;

        CanecaSintatico.chamada_return chamada144 =null;



        try {
            // fontes/g/CanecaSintatico.g:335:2: ( referencia ( chamada )* )
            // fontes/g/CanecaSintatico.g:335:4: referencia ( chamada )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_referencia_in_comando912);
            referencia143=referencia();

            state._fsp--;

            adaptor.addChild(root_0, referencia143.getTree());

            // fontes/g/CanecaSintatico.g:335:15: ( chamada )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0 >= CHAMADA_DE_CLASSE && LA32_0 <= CHAMADA_DE_OBJETO)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:335:16: chamada
            	    {
            	    pushFollow(FOLLOW_chamada_in_comando915);
            	    chamada144=chamada();

            	    state._fsp--;

            	    adaptor.addChild(root_0, chamada144.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comando"


    public static class referencia_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "referencia"
    // fontes/g/CanecaSintatico.g:338:1: referencia : ( ESSE | ESSA | instanciacao | IDENTIFICADOR ( listaDeParametros )? );
    public final CanecaSintatico.referencia_return referencia() throws RecognitionException {
        CanecaSintatico.referencia_return retval = new CanecaSintatico.referencia_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ESSE145=null;
        Token ESSA146=null;
        Token IDENTIFICADOR148=null;
        CanecaSintatico.instanciacao_return instanciacao147 =null;

        CanecaSintatico.listaDeParametros_return listaDeParametros149 =null;


        Object ESSE145_tree=null;
        Object ESSA146_tree=null;
        Object IDENTIFICADOR148_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:339:2: ( ESSE | ESSA | instanciacao | IDENTIFICADOR ( listaDeParametros )? )
            int alt34=4;
            switch ( input.LA(1) ) {
            case ESSE:
                {
                alt34=1;
                }
                break;
            case ESSA:
                {
                alt34=2;
                }
                break;
            case NOVA:
            case NOVO:
                {
                alt34=3;
                }
                break;
            case IDENTIFICADOR:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:339:4: ESSE
                    {
                    root_0 = (Object)adaptor.nil();


                    ESSE145=(Token)match(input,ESSE,FOLLOW_ESSE_in_referencia928); 
                    ESSE145_tree = 
                    (Object)adaptor.create(ESSE145)
                    ;
                    adaptor.addChild(root_0, ESSE145_tree);


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaSintatico.g:340:4: ESSA
                    {
                    root_0 = (Object)adaptor.nil();


                    ESSA146=(Token)match(input,ESSA,FOLLOW_ESSA_in_referencia933); 
                    ESSA146_tree = 
                    (Object)adaptor.create(ESSA146)
                    ;
                    adaptor.addChild(root_0, ESSA146_tree);


                    }
                    break;
                case 3 :
                    // fontes/g/CanecaSintatico.g:341:4: instanciacao
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instanciacao_in_referencia938);
                    instanciacao147=instanciacao();

                    state._fsp--;

                    adaptor.addChild(root_0, instanciacao147.getTree());

                    }
                    break;
                case 4 :
                    // fontes/g/CanecaSintatico.g:342:4: IDENTIFICADOR ( listaDeParametros )?
                    {
                    root_0 = (Object)adaptor.nil();


                    IDENTIFICADOR148=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_referencia943); 
                    IDENTIFICADOR148_tree = 
                    (Object)adaptor.create(IDENTIFICADOR148)
                    ;
                    adaptor.addChild(root_0, IDENTIFICADOR148_tree);


                    // fontes/g/CanecaSintatico.g:342:18: ( listaDeParametros )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==PARENTESE_ESQUERDO) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // fontes/g/CanecaSintatico.g:342:19: listaDeParametros
                            {
                            pushFollow(FOLLOW_listaDeParametros_in_referencia946);
                            listaDeParametros149=listaDeParametros();

                            state._fsp--;

                            adaptor.addChild(root_0, listaDeParametros149.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "referencia"


    public static class chamada_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chamada"
    // fontes/g/CanecaSintatico.g:345:1: chamada : ( CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO ) IDENTIFICADOR ( listaDeParametros )? ;
    public final CanecaSintatico.chamada_return chamada() throws RecognitionException {
        CanecaSintatico.chamada_return retval = new CanecaSintatico.chamada_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set150=null;
        Token IDENTIFICADOR151=null;
        CanecaSintatico.listaDeParametros_return listaDeParametros152 =null;


        Object set150_tree=null;
        Object IDENTIFICADOR151_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:346:2: ( ( CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO ) IDENTIFICADOR ( listaDeParametros )? )
            // fontes/g/CanecaSintatico.g:346:4: ( CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO ) IDENTIFICADOR ( listaDeParametros )?
            {
            root_0 = (Object)adaptor.nil();


            set150=(Token)input.LT(1);

            if ( (input.LA(1) >= CHAMADA_DE_CLASSE && input.LA(1) <= CHAMADA_DE_OBJETO) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set150)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            IDENTIFICADOR151=(Token)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_chamada967); 
            IDENTIFICADOR151_tree = 
            (Object)adaptor.create(IDENTIFICADOR151)
            ;
            adaptor.addChild(root_0, IDENTIFICADOR151_tree);


            // fontes/g/CanecaSintatico.g:346:58: ( listaDeParametros )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==PARENTESE_ESQUERDO) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:346:59: listaDeParametros
                    {
                    pushFollow(FOLLOW_listaDeParametros_in_chamada970);
                    listaDeParametros152=listaDeParametros();

                    state._fsp--;

                    adaptor.addChild(root_0, listaDeParametros152.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "chamada"


    public static class instanciacao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instanciacao"
    // fontes/g/CanecaSintatico.g:349:1: instanciacao : ( NOVO | NOVA ) tipo listaDeParametros ;
    public final CanecaSintatico.instanciacao_return instanciacao() throws RecognitionException {
        CanecaSintatico.instanciacao_return retval = new CanecaSintatico.instanciacao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set153=null;
        CanecaSintatico.tipo_return tipo154 =null;

        CanecaSintatico.listaDeParametros_return listaDeParametros155 =null;


        Object set153_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:350:2: ( ( NOVO | NOVA ) tipo listaDeParametros )
            // fontes/g/CanecaSintatico.g:350:4: ( NOVO | NOVA ) tipo listaDeParametros
            {
            root_0 = (Object)adaptor.nil();


            set153=(Token)input.LT(1);

            if ( (input.LA(1) >= NOVA && input.LA(1) <= NOVO) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set153)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            pushFollow(FOLLOW_tipo_in_instanciacao991);
            tipo154=tipo();

            state._fsp--;

            adaptor.addChild(root_0, tipo154.getTree());

            pushFollow(FOLLOW_listaDeParametros_in_instanciacao993);
            listaDeParametros155=listaDeParametros();

            state._fsp--;

            adaptor.addChild(root_0, listaDeParametros155.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instanciacao"


    public static class destruicao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "destruicao"
    // fontes/g/CanecaSintatico.g:353:1: destruicao : DESTRUA expressao ;
    public final CanecaSintatico.destruicao_return destruicao() throws RecognitionException {
        CanecaSintatico.destruicao_return retval = new CanecaSintatico.destruicao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token DESTRUA156=null;
        CanecaSintatico.expressao_return expressao157 =null;


        Object DESTRUA156_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:354:2: ( DESTRUA expressao )
            // fontes/g/CanecaSintatico.g:354:4: DESTRUA expressao
            {
            root_0 = (Object)adaptor.nil();


            DESTRUA156=(Token)match(input,DESTRUA,FOLLOW_DESTRUA_in_destruicao1004); 
            DESTRUA156_tree = 
            (Object)adaptor.create(DESTRUA156)
            ;
            adaptor.addChild(root_0, DESTRUA156_tree);


            pushFollow(FOLLOW_expressao_in_destruicao1006);
            expressao157=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao157.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "destruicao"


    public static class retorno_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "retorno"
    // fontes/g/CanecaSintatico.g:357:1: retorno : RETORNE expressao ;
    public final CanecaSintatico.retorno_return retorno() throws RecognitionException {
        CanecaSintatico.retorno_return retval = new CanecaSintatico.retorno_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token RETORNE158=null;
        CanecaSintatico.expressao_return expressao159 =null;


        Object RETORNE158_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:358:2: ( RETORNE expressao )
            // fontes/g/CanecaSintatico.g:358:4: RETORNE expressao
            {
            root_0 = (Object)adaptor.nil();


            RETORNE158=(Token)match(input,RETORNE,FOLLOW_RETORNE_in_retorno1018); 
            RETORNE158_tree = 
            (Object)adaptor.create(RETORNE158)
            ;
            adaptor.addChild(root_0, RETORNE158_tree);


            pushFollow(FOLLOW_expressao_in_retorno1020);
            expressao159=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao159.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "retorno"


    public static class se_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "se"
    // fontes/g/CanecaSintatico.g:361:1: se : SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes ( SENAO blocoDeInstrucoes )? ;
    public final CanecaSintatico.se_return se() throws RecognitionException {
        CanecaSintatico.se_return retval = new CanecaSintatico.se_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SE160=null;
        Token PARENTESE_ESQUERDO161=null;
        Token PARENTESE_DIREITO163=null;
        Token SENAO165=null;
        CanecaSintatico.expressao_return expressao162 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes164 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes166 =null;


        Object SE160_tree=null;
        Object PARENTESE_ESQUERDO161_tree=null;
        Object PARENTESE_DIREITO163_tree=null;
        Object SENAO165_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:362:2: ( SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes ( SENAO blocoDeInstrucoes )? )
            // fontes/g/CanecaSintatico.g:362:4: SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes ( SENAO blocoDeInstrucoes )?
            {
            root_0 = (Object)adaptor.nil();


            SE160=(Token)match(input,SE,FOLLOW_SE_in_se1031); 
            SE160_tree = 
            (Object)adaptor.create(SE160)
            ;
            adaptor.addChild(root_0, SE160_tree);


            PARENTESE_ESQUERDO161=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_se1033); 
            PARENTESE_ESQUERDO161_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO161)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO161_tree);


            pushFollow(FOLLOW_expressao_in_se1035);
            expressao162=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao162.getTree());

            PARENTESE_DIREITO163=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_se1037); 
            PARENTESE_DIREITO163_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO163)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO163_tree);


            pushFollow(FOLLOW_blocoDeInstrucoes_in_se1039);
            blocoDeInstrucoes164=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes164.getTree());

            // fontes/g/CanecaSintatico.g:362:72: ( SENAO blocoDeInstrucoes )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==SENAO) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:362:73: SENAO blocoDeInstrucoes
                    {
                    SENAO165=(Token)match(input,SENAO,FOLLOW_SENAO_in_se1042); 
                    SENAO165_tree = 
                    (Object)adaptor.create(SENAO165)
                    ;
                    adaptor.addChild(root_0, SENAO165_tree);


                    pushFollow(FOLLOW_blocoDeInstrucoes_in_se1044);
                    blocoDeInstrucoes166=blocoDeInstrucoes();

                    state._fsp--;

                    adaptor.addChild(root_0, blocoDeInstrucoes166.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "se"


    public static class para_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "para"
    // fontes/g/CanecaSintatico.g:365:1: para : PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes ;
    public final CanecaSintatico.para_return para() throws RecognitionException {
        CanecaSintatico.para_return retval = new CanecaSintatico.para_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PARA167=null;
        Token PARENTESE_ESQUERDO168=null;
        Token TERMINADOR170=null;
        Token TERMINADOR172=null;
        Token PARENTESE_DIREITO174=null;
        CanecaSintatico.expressao_return expressao169 =null;

        CanecaSintatico.expressao_return expressao171 =null;

        CanecaSintatico.expressao_return expressao173 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes175 =null;


        Object PARA167_tree=null;
        Object PARENTESE_ESQUERDO168_tree=null;
        Object TERMINADOR170_tree=null;
        Object TERMINADOR172_tree=null;
        Object PARENTESE_DIREITO174_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:366:2: ( PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes )
            // fontes/g/CanecaSintatico.g:366:4: PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes
            {
            root_0 = (Object)adaptor.nil();


            PARA167=(Token)match(input,PARA,FOLLOW_PARA_in_para1057); 
            PARA167_tree = 
            (Object)adaptor.create(PARA167)
            ;
            adaptor.addChild(root_0, PARA167_tree);


            PARENTESE_ESQUERDO168=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_para1059); 
            PARENTESE_ESQUERDO168_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO168)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO168_tree);


            pushFollow(FOLLOW_expressao_in_para1061);
            expressao169=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao169.getTree());

            TERMINADOR170=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_para1063); 
            TERMINADOR170_tree = 
            (Object)adaptor.create(TERMINADOR170)
            ;
            adaptor.addChild(root_0, TERMINADOR170_tree);


            pushFollow(FOLLOW_expressao_in_para1065);
            expressao171=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao171.getTree());

            TERMINADOR172=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_para1067); 
            TERMINADOR172_tree = 
            (Object)adaptor.create(TERMINADOR172)
            ;
            adaptor.addChild(root_0, TERMINADOR172_tree);


            pushFollow(FOLLOW_expressao_in_para1069);
            expressao173=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao173.getTree());

            PARENTESE_DIREITO174=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_para1071); 
            PARENTESE_DIREITO174_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO174)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO174_tree);


            pushFollow(FOLLOW_blocoDeInstrucoes_in_para1073);
            blocoDeInstrucoes175=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes175.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "para"


    public static class repita_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "repita"
    // fontes/g/CanecaSintatico.g:369:1: repita : REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes ;
    public final CanecaSintatico.repita_return repita() throws RecognitionException {
        CanecaSintatico.repita_return retval = new CanecaSintatico.repita_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token REPITA176=null;
        Token PARENTESE_ESQUERDO177=null;
        Token TERMINADOR179=null;
        Token PARENTESE_DIREITO181=null;
        CanecaSintatico.declaracao_return declaracao178 =null;

        CanecaSintatico.expressao_return expressao180 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes182 =null;


        Object REPITA176_tree=null;
        Object PARENTESE_ESQUERDO177_tree=null;
        Object TERMINADOR179_tree=null;
        Object PARENTESE_DIREITO181_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:370:2: ( REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes )
            // fontes/g/CanecaSintatico.g:370:4: REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes
            {
            root_0 = (Object)adaptor.nil();


            REPITA176=(Token)match(input,REPITA,FOLLOW_REPITA_in_repita1084); 
            REPITA176_tree = 
            (Object)adaptor.create(REPITA176)
            ;
            adaptor.addChild(root_0, REPITA176_tree);


            PARENTESE_ESQUERDO177=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_repita1086); 
            PARENTESE_ESQUERDO177_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO177)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO177_tree);


            pushFollow(FOLLOW_declaracao_in_repita1088);
            declaracao178=declaracao();

            state._fsp--;

            adaptor.addChild(root_0, declaracao178.getTree());

            TERMINADOR179=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_repita1090); 
            TERMINADOR179_tree = 
            (Object)adaptor.create(TERMINADOR179)
            ;
            adaptor.addChild(root_0, TERMINADOR179_tree);


            pushFollow(FOLLOW_expressao_in_repita1092);
            expressao180=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao180.getTree());

            PARENTESE_DIREITO181=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_repita1094); 
            PARENTESE_DIREITO181_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO181)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO181_tree);


            pushFollow(FOLLOW_blocoDeInstrucoes_in_repita1096);
            blocoDeInstrucoes182=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes182.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "repita"


    public static class enquanto_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "enquanto"
    // fontes/g/CanecaSintatico.g:373:1: enquanto : ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes ;
    public final CanecaSintatico.enquanto_return enquanto() throws RecognitionException {
        CanecaSintatico.enquanto_return retval = new CanecaSintatico.enquanto_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ENQUANTO183=null;
        Token PARENTESE_ESQUERDO184=null;
        Token PARENTESE_DIREITO186=null;
        CanecaSintatico.expressao_return expressao185 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes187 =null;


        Object ENQUANTO183_tree=null;
        Object PARENTESE_ESQUERDO184_tree=null;
        Object PARENTESE_DIREITO186_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:374:2: ( ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes )
            // fontes/g/CanecaSintatico.g:374:4: ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes
            {
            root_0 = (Object)adaptor.nil();


            ENQUANTO183=(Token)match(input,ENQUANTO,FOLLOW_ENQUANTO_in_enquanto1107); 
            ENQUANTO183_tree = 
            (Object)adaptor.create(ENQUANTO183)
            ;
            adaptor.addChild(root_0, ENQUANTO183_tree);


            PARENTESE_ESQUERDO184=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_enquanto1109); 
            PARENTESE_ESQUERDO184_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO184)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO184_tree);


            pushFollow(FOLLOW_expressao_in_enquanto1111);
            expressao185=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao185.getTree());

            PARENTESE_DIREITO186=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_enquanto1113); 
            PARENTESE_DIREITO186_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO186)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO186_tree);


            pushFollow(FOLLOW_blocoDeInstrucoes_in_enquanto1115);
            blocoDeInstrucoes187=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes187.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "enquanto"


    public static class tente_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tente"
    // fontes/g/CanecaSintatico.g:377:1: tente : TENTE blocoDeInstrucoes listaDeCapturas ;
    public final CanecaSintatico.tente_return tente() throws RecognitionException {
        CanecaSintatico.tente_return retval = new CanecaSintatico.tente_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token TENTE188=null;
        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes189 =null;

        CanecaSintatico.listaDeCapturas_return listaDeCapturas190 =null;


        Object TENTE188_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:378:2: ( TENTE blocoDeInstrucoes listaDeCapturas )
            // fontes/g/CanecaSintatico.g:378:4: TENTE blocoDeInstrucoes listaDeCapturas
            {
            root_0 = (Object)adaptor.nil();


            TENTE188=(Token)match(input,TENTE,FOLLOW_TENTE_in_tente1126); 
            TENTE188_tree = 
            (Object)adaptor.create(TENTE188)
            ;
            adaptor.addChild(root_0, TENTE188_tree);


            pushFollow(FOLLOW_blocoDeInstrucoes_in_tente1128);
            blocoDeInstrucoes189=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes189.getTree());

            pushFollow(FOLLOW_listaDeCapturas_in_tente1130);
            listaDeCapturas190=listaDeCapturas();

            state._fsp--;

            adaptor.addChild(root_0, listaDeCapturas190.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tente"


    public static class capture_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "capture"
    // fontes/g/CanecaSintatico.g:381:1: capture : CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes ;
    public final CanecaSintatico.capture_return capture() throws RecognitionException {
        CanecaSintatico.capture_return retval = new CanecaSintatico.capture_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CAPTURE191=null;
        Token PARENTESE_ESQUERDO192=null;
        Token PARENTESE_DIREITO194=null;
        CanecaSintatico.declaracao_return declaracao193 =null;

        CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes195 =null;


        Object CAPTURE191_tree=null;
        Object PARENTESE_ESQUERDO192_tree=null;
        Object PARENTESE_DIREITO194_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:382:2: ( CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes )
            // fontes/g/CanecaSintatico.g:382:4: CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes
            {
            root_0 = (Object)adaptor.nil();


            CAPTURE191=(Token)match(input,CAPTURE,FOLLOW_CAPTURE_in_capture1141); 
            CAPTURE191_tree = 
            (Object)adaptor.create(CAPTURE191)
            ;
            adaptor.addChild(root_0, CAPTURE191_tree);


            PARENTESE_ESQUERDO192=(Token)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_capture1143); 
            PARENTESE_ESQUERDO192_tree = 
            (Object)adaptor.create(PARENTESE_ESQUERDO192)
            ;
            adaptor.addChild(root_0, PARENTESE_ESQUERDO192_tree);


            pushFollow(FOLLOW_declaracao_in_capture1145);
            declaracao193=declaracao();

            state._fsp--;

            adaptor.addChild(root_0, declaracao193.getTree());

            PARENTESE_DIREITO194=(Token)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_capture1147); 
            PARENTESE_DIREITO194_tree = 
            (Object)adaptor.create(PARENTESE_DIREITO194)
            ;
            adaptor.addChild(root_0, PARENTESE_DIREITO194_tree);


            pushFollow(FOLLOW_blocoDeInstrucoes_in_capture1149);
            blocoDeInstrucoes195=blocoDeInstrucoes();

            state._fsp--;

            adaptor.addChild(root_0, blocoDeInstrucoes195.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "capture"


    public static class lance_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lance"
    // fontes/g/CanecaSintatico.g:385:1: lance : LANCE expressao ;
    public final CanecaSintatico.lance_return lance() throws RecognitionException {
        CanecaSintatico.lance_return retval = new CanecaSintatico.lance_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LANCE196=null;
        CanecaSintatico.expressao_return expressao197 =null;


        Object LANCE196_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:386:2: ( LANCE expressao )
            // fontes/g/CanecaSintatico.g:386:4: LANCE expressao
            {
            root_0 = (Object)adaptor.nil();


            LANCE196=(Token)match(input,LANCE,FOLLOW_LANCE_in_lance1160); 
            LANCE196_tree = 
            (Object)adaptor.create(LANCE196)
            ;
            adaptor.addChild(root_0, LANCE196_tree);


            pushFollow(FOLLOW_expressao_in_lance1162);
            expressao197=expressao();

            state._fsp--;

            adaptor.addChild(root_0, expressao197.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lance"


    public static class instrucao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instrucao"
    // fontes/g/CanecaSintatico.g:389:1: instrucao : ( ( options {k=2; } : expressao TERMINADOR | declaracaoComAtribuicaoOpcional TERMINADOR ) | IMPRIMIR TERMINADOR | DEPURAR TERMINADOR | destruicao TERMINADOR | retorno TERMINADOR | se | para | repita | enquanto | tente | lance TERMINADOR );
    public final CanecaSintatico.instrucao_return instrucao() throws RecognitionException {
        CanecaSintatico.instrucao_return retval = new CanecaSintatico.instrucao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token TERMINADOR199=null;
        Token TERMINADOR201=null;
        Token IMPRIMIR202=null;
        Token TERMINADOR203=null;
        Token DEPURAR204=null;
        Token TERMINADOR205=null;
        Token TERMINADOR207=null;
        Token TERMINADOR209=null;
        Token TERMINADOR216=null;
        CanecaSintatico.expressao_return expressao198 =null;

        CanecaSintatico.declaracaoComAtribuicaoOpcional_return declaracaoComAtribuicaoOpcional200 =null;

        CanecaSintatico.destruicao_return destruicao206 =null;

        CanecaSintatico.retorno_return retorno208 =null;

        CanecaSintatico.se_return se210 =null;

        CanecaSintatico.para_return para211 =null;

        CanecaSintatico.repita_return repita212 =null;

        CanecaSintatico.enquanto_return enquanto213 =null;

        CanecaSintatico.tente_return tente214 =null;

        CanecaSintatico.lance_return lance215 =null;


        Object TERMINADOR199_tree=null;
        Object TERMINADOR201_tree=null;
        Object IMPRIMIR202_tree=null;
        Object TERMINADOR203_tree=null;
        Object DEPURAR204_tree=null;
        Object TERMINADOR205_tree=null;
        Object TERMINADOR207_tree=null;
        Object TERMINADOR209_tree=null;
        Object TERMINADOR216_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:390:2: ( ( options {k=2; } : expressao TERMINADOR | declaracaoComAtribuicaoOpcional TERMINADOR ) | IMPRIMIR TERMINADOR | DEPURAR TERMINADOR | destruicao TERMINADOR | retorno TERMINADOR | se | para | repita | enquanto | tente | lance TERMINADOR )
            int alt38=11;
            switch ( input.LA(1) ) {
            case CONSTANTE_INTEIRA:
            case CONSTANTE_REAL:
            case ESSA:
            case ESSE:
            case IDENTIFICADOR:
            case LITERAL_CARACTERE:
            case LITERAL_TEXTO:
            case NEGACAO:
            case NOVA:
            case NOVO:
            case PARENTESE_ESQUERDO:
            case SUBTRACAO:
            case VALOR_BOOLEANO:
            case VALOR_NULO:
                {
                alt38=1;
                }
                break;
            case IMPRIMIR:
                {
                alt38=2;
                }
                break;
            case DEPURAR:
                {
                alt38=3;
                }
                break;
            case DESTRUA:
                {
                alt38=4;
                }
                break;
            case RETORNE:
                {
                alt38=5;
                }
                break;
            case SE:
                {
                alt38=6;
                }
                break;
            case PARA:
                {
                alt38=7;
                }
                break;
            case REPITA:
                {
                alt38=8;
                }
                break;
            case ENQUANTO:
                {
                alt38=9;
                }
                break;
            case TENTE:
                {
                alt38=10;
                }
                break;
            case LANCE:
                {
                alt38=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // fontes/g/CanecaSintatico.g:391:2: ( options {k=2; } : expressao TERMINADOR | declaracaoComAtribuicaoOpcional TERMINADOR )
                    {
                    root_0 = (Object)adaptor.nil();


                    // fontes/g/CanecaSintatico.g:391:2: ( options {k=2; } : expressao TERMINADOR | declaracaoComAtribuicaoOpcional TERMINADOR )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0 >= CONSTANTE_INTEIRA && LA37_0 <= CONSTANTE_REAL)||(LA37_0 >= ESSA && LA37_0 <= ESSE)||(LA37_0 >= LITERAL_CARACTERE && LA37_0 <= LITERAL_TEXTO)||(LA37_0 >= NEGACAO && LA37_0 <= NOVO)||LA37_0==PARENTESE_ESQUERDO||LA37_0==SUBTRACAO||(LA37_0 >= VALOR_BOOLEANO && LA37_0 <= VALOR_NULO)) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==IDENTIFICADOR) ) {
                        int LA37_11 = input.LA(2);

                        if ( (LA37_11==ATRIBUIDOR||(LA37_11 >= CHAMADA_DE_CLASSE && LA37_11 <= CHAMADA_DE_OBJETO)||LA37_11==DIFERENTE||(LA37_11 >= DIVISAO && LA37_11 <= E)||LA37_11==IGUAL||(LA37_11 >= MAIOR && LA37_11 <= MENOR_IGUAL)||LA37_11==MULTIPLICACAO||LA37_11==OU||LA37_11==PARENTESE_ESQUERDO||LA37_11==RESTO_DA_DIVISAO||(LA37_11 >= SOMA && LA37_11 <= SUBTRACAO)||LA37_11==TERMINADOR) ) {
                            alt37=1;
                        }
                        else if ( (LA37_11==COLCHETE_ESQUERDO||LA37_11==IDENTIFICADOR) ) {
                            alt37=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 37, 11, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;

                    }
                    switch (alt37) {
                        case 1 :
                            // fontes/g/CanecaSintatico.g:392:5: expressao TERMINADOR
                            {
                            pushFollow(FOLLOW_expressao_in_instrucao1190);
                            expressao198=expressao();

                            state._fsp--;

                            adaptor.addChild(root_0, expressao198.getTree());

                            TERMINADOR199=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao1192); 
                            TERMINADOR199_tree = 
                            (Object)adaptor.create(TERMINADOR199)
                            ;
                            adaptor.addChild(root_0, TERMINADOR199_tree);


                            }
                            break;
                        case 2 :
                            // fontes/g/CanecaSintatico.g:393:5: declaracaoComAtribuicaoOpcional TERMINADOR
                            {
                            pushFollow(FOLLOW_declaracaoComAtribuicaoOpcional_in_instrucao1198);
                            declaracaoComAtribuicaoOpcional200=declaracaoComAtribuicaoOpcional();

                            state._fsp--;

                            adaptor.addChild(root_0, declaracaoComAtribuicaoOpcional200.getTree());

                            TERMINADOR201=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao1200); 
                            TERMINADOR201_tree = 
                            (Object)adaptor.create(TERMINADOR201)
                            ;
                            adaptor.addChild(root_0, TERMINADOR201_tree);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaSintatico.g:395:4: IMPRIMIR TERMINADOR
                    {
                    root_0 = (Object)adaptor.nil();


                    IMPRIMIR202=(Token)match(input,IMPRIMIR,FOLLOW_IMPRIMIR_in_instrucao1208); 
                    IMPRIMIR202_tree = 
                    (Object)adaptor.create(IMPRIMIR202)
                    ;
                    adaptor.addChild(root_0, IMPRIMIR202_tree);


                    TERMINADOR203=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao1210); 
                    TERMINADOR203_tree = 
                    (Object)adaptor.create(TERMINADOR203)
                    ;
                    adaptor.addChild(root_0, TERMINADOR203_tree);


                    }
                    break;
                case 3 :
                    // fontes/g/CanecaSintatico.g:396:4: DEPURAR TERMINADOR
                    {
                    root_0 = (Object)adaptor.nil();


                    DEPURAR204=(Token)match(input,DEPURAR,FOLLOW_DEPURAR_in_instrucao1215); 
                    DEPURAR204_tree = 
                    (Object)adaptor.create(DEPURAR204)
                    ;
                    adaptor.addChild(root_0, DEPURAR204_tree);


                    TERMINADOR205=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao1217); 
                    TERMINADOR205_tree = 
                    (Object)adaptor.create(TERMINADOR205)
                    ;
                    adaptor.addChild(root_0, TERMINADOR205_tree);


                    }
                    break;
                case 4 :
                    // fontes/g/CanecaSintatico.g:397:4: destruicao TERMINADOR
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_destruicao_in_instrucao1222);
                    destruicao206=destruicao();

                    state._fsp--;

                    adaptor.addChild(root_0, destruicao206.getTree());

                    TERMINADOR207=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao1224); 
                    TERMINADOR207_tree = 
                    (Object)adaptor.create(TERMINADOR207)
                    ;
                    adaptor.addChild(root_0, TERMINADOR207_tree);


                    }
                    break;
                case 5 :
                    // fontes/g/CanecaSintatico.g:398:4: retorno TERMINADOR
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_retorno_in_instrucao1229);
                    retorno208=retorno();

                    state._fsp--;

                    adaptor.addChild(root_0, retorno208.getTree());

                    TERMINADOR209=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao1231); 
                    TERMINADOR209_tree = 
                    (Object)adaptor.create(TERMINADOR209)
                    ;
                    adaptor.addChild(root_0, TERMINADOR209_tree);


                    }
                    break;
                case 6 :
                    // fontes/g/CanecaSintatico.g:399:4: se
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_se_in_instrucao1236);
                    se210=se();

                    state._fsp--;

                    adaptor.addChild(root_0, se210.getTree());

                    }
                    break;
                case 7 :
                    // fontes/g/CanecaSintatico.g:400:4: para
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_para_in_instrucao1241);
                    para211=para();

                    state._fsp--;

                    adaptor.addChild(root_0, para211.getTree());

                    }
                    break;
                case 8 :
                    // fontes/g/CanecaSintatico.g:401:4: repita
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_repita_in_instrucao1246);
                    repita212=repita();

                    state._fsp--;

                    adaptor.addChild(root_0, repita212.getTree());

                    }
                    break;
                case 9 :
                    // fontes/g/CanecaSintatico.g:402:4: enquanto
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_enquanto_in_instrucao1251);
                    enquanto213=enquanto();

                    state._fsp--;

                    adaptor.addChild(root_0, enquanto213.getTree());

                    }
                    break;
                case 10 :
                    // fontes/g/CanecaSintatico.g:403:4: tente
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_tente_in_instrucao1256);
                    tente214=tente();

                    state._fsp--;

                    adaptor.addChild(root_0, tente214.getTree());

                    }
                    break;
                case 11 :
                    // fontes/g/CanecaSintatico.g:404:4: lance TERMINADOR
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_lance_in_instrucao1261);
                    lance215=lance();

                    state._fsp--;

                    adaptor.addChild(root_0, lance215.getTree());

                    TERMINADOR216=(Token)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao1263); 
                    TERMINADOR216_tree = 
                    (Object)adaptor.create(TERMINADOR216)
                    ;
                    adaptor.addChild(root_0, TERMINADOR216_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instrucao"


    public static class blocoDeInstrucoes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "blocoDeInstrucoes"
    // fontes/g/CanecaSintatico.g:407:1: blocoDeInstrucoes : INICIO ( instrucao )* FIM ;
    public final CanecaSintatico.blocoDeInstrucoes_return blocoDeInstrucoes() throws RecognitionException {
        CanecaSintatico.blocoDeInstrucoes_return retval = new CanecaSintatico.blocoDeInstrucoes_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INICIO217=null;
        Token FIM219=null;
        CanecaSintatico.instrucao_return instrucao218 =null;


        Object INICIO217_tree=null;
        Object FIM219_tree=null;

        try {
            // fontes/g/CanecaSintatico.g:408:2: ( INICIO ( instrucao )* FIM )
            // fontes/g/CanecaSintatico.g:408:4: INICIO ( instrucao )* FIM
            {
            root_0 = (Object)adaptor.nil();


            INICIO217=(Token)match(input,INICIO,FOLLOW_INICIO_in_blocoDeInstrucoes1274); 
            INICIO217_tree = 
            (Object)adaptor.create(INICIO217)
            ;
            adaptor.addChild(root_0, INICIO217_tree);


            // fontes/g/CanecaSintatico.g:408:11: ( instrucao )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0 >= CONSTANTE_INTEIRA && LA39_0 <= CONSTANTE_REAL)||(LA39_0 >= DEPURAR && LA39_0 <= DESTRUA)||LA39_0==ENQUANTO||(LA39_0 >= ESSA && LA39_0 <= ESSE)||LA39_0==IDENTIFICADOR||LA39_0==IMPRIMIR||LA39_0==LANCE||(LA39_0 >= LITERAL_CARACTERE && LA39_0 <= LITERAL_TEXTO)||(LA39_0 >= NEGACAO && LA39_0 <= NOVO)||LA39_0==PARA||LA39_0==PARENTESE_ESQUERDO||LA39_0==REPITA||(LA39_0 >= RETORNE && LA39_0 <= SE)||LA39_0==SUBTRACAO||LA39_0==TENTE||(LA39_0 >= VALOR_BOOLEANO && LA39_0 <= VALOR_NULO)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // fontes/g/CanecaSintatico.g:408:12: instrucao
            	    {
            	    pushFollow(FOLLOW_instrucao_in_blocoDeInstrucoes1277);
            	    instrucao218=instrucao();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instrucao218.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            FIM219=(Token)match(input,FIM,FOLLOW_FIM_in_blocoDeInstrucoes1281); 
            FIM219_tree = 
            (Object)adaptor.create(FIM219)
            ;
            adaptor.addChild(root_0, FIM219_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException erro) {
        		reportError(erro);
        		recover(input, erro);
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "blocoDeInstrucoes"

    // Delegated rules


 

    public static final BitSet FOLLOW_unicadeDeCompilacao_in_programa77 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_cabecalho_in_unicadeDeCompilacao90 = new BitSet(new long[]{0x0000040000001000L});
    public static final BitSet FOLLOW_classe_in_unicadeDeCompilacao93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaces_in_unicadeDeCompilacao97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pacote_in_cabecalho109 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_importacoes_in_cabecalho111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACOTE_in_pacote122 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_DE_PACOTE_in_pacote124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_pacote126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importacao_in_importacoes138 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_IMPORTE_in_importacao151 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_importacao154 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao156 = new BitSet(new long[]{0x0000000000020000L,0x0000000000004000L});
    public static final BitSet FOLLOW_COMO_in_importacao159 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_importacao161 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_importacao170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASSE_in_classe181 = new BitSet(new long[]{0xA000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_modificadorDeAcessoFeminino_in_classe183 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_classe185 = new BitSet(new long[]{0x0000024000004000L});
    public static final BitSet FOLLOW_listaDeTiposGenericos_in_classe187 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_listaDeInterfaces_in_classe189 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_corpoDaClasse_in_classe191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTERFACE_in_interfaces202 = new BitSet(new long[]{0xA000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_modificadorDeAcessoFeminino_in_interfaces204 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_interfaces206 = new BitSet(new long[]{0x0000024000004000L});
    public static final BitSet FOLLOW_listaDeTiposGenericos_in_interfaces208 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_listaDeInterfaces_in_interfaces210 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_corpoDaInterface_in_interfaces212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INICIO_in_corpoDaClasse223 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_atributos_in_corpoDaClasse225 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_construtores_in_corpoDaClasse227 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_destrutor_in_corpoDaClasse229 = new BitSet(new long[]{0x0008000400000000L});
    public static final BitSet FOLLOW_metodos_in_corpoDaClasse231 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FIM_in_corpoDaClasse233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INICIO_in_corpoDaInterface244 = new BitSet(new long[]{0x0008000400000020L});
    public static final BitSet FOLLOW_atributos_in_corpoDaInterface246 = new BitSet(new long[]{0x0008000400000000L});
    public static final BitSet FOLLOW_assinaturasDeMetodos_in_corpoDaInterface248 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FIM_in_corpoDaInterface250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atributo_in_atributos262 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_construtor_in_construtores276 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_metodo_in_metodos290 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_assinaturaDeMetodo_in_assinaturasDeMetodos304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_assinaturasDeMetodos306 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ATRIBUTO_in_atributo319 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_atributo321 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_ESTATICO_in_atributo324 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_atributo328 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_atributo330 = new BitSet(new long[]{0x0000000000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_ATRIBUIDOR_in_atributo333 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_atributo335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_atributo339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assinaturaDeConstrutor_in_construtor350 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_construtor352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assinaturaDeDestrutor_in_destrutor363 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_destrutor365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assinaturaDeMetodo_in_metodo376 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_metodo378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRUTOR_in_assinaturaDeConstrutor389 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeConstrutor391 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_assinaturaDeConstrutor393 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeArgumentos_in_assinaturaDeConstrutor395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESTRUTOR_in_assinaturaDeDestrutor406 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeDestrutor408 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_assinaturaDeDestrutor410 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeArgumentosVazia_in_assinaturaDeDestrutor412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METODO_in_assinaturaDeMetodo423 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeMetodo425 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_ESTATICO_in_assinaturaDeMetodo428 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_assinaturaDeMetodo432 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_assinaturaDeMetodo434 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeArgumentos_in_assinaturaDeMetodo436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_listaDeParametros489 = new BitSet(new long[]{0x18E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_listaDeParametros492 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeParametros495 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_listaDeParametros497 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_listaDeParametros503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentosVazia514 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentosVazia516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentos527 = new BitSet(new long[]{0x0800000800000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeArgumentos530 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeArgumentos533 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeArgumentos535 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentos541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTA_in_listaDeInterfaces553 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeInterfaces555 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeInterfaces558 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeInterfaces560 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_COLCHETE_ESQUERDO_in_listaDeTiposGenericos576 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipoGenerico_in_listaDeTiposGenericos578 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLCHETE_DIREITO_in_listaDeTiposGenericos580 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_COLCHETE_ESQUERDO_in_listaDeTipos594 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeTipos596 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeTipos599 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeTipos601 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000200L});
    public static final BitSet FOLLOW_COLCHETE_DIREITO_in_listaDeTipos605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_capture_in_listaDeCapturas619 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_tipoGenerico632 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_listaDeInterfaces_in_tipoGenerico634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_tipo645 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_listaDeTipos_in_tipo647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_declaracao658 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_declaracao660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_declaracaoComAtribuicaoOpcional671 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_declaracaoComAtribuicaoOpcional673 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ATRIBUIDOR_in_declaracaoComAtribuicaoOpcional676 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_declaracaoComAtribuicaoOpcional678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_expressao691 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ATRIBUIDOR_in_expressao694 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_expressao696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressaoELogico_in_expressaoOuLogico709 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_OU_in_expressaoOuLogico712 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoELogico_in_expressaoOuLogico714 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_expressaoComparacaoLogica_in_expressaoELogico727 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_E_in_expressaoELogico730 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoComparacaoLogica_in_expressaoELogico732 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica745 = new BitSet(new long[]{0x0007802002000002L});
    public static final BitSet FOLLOW_set_in_expressaoComparacaoLogica748 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressaoMultiplicativa_in_expressaoAditiva785 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_expressaoAditiva788 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoMultiplicativa_in_expressaoAditiva796 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_expressaoUnaria_in_expressaoMultiplicativa809 = new BitSet(new long[]{0x0010000008000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_expressaoMultiplicativa812 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoUnaria_in_expressaoMultiplicativa824 = new BitSet(new long[]{0x0010000008000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_expressaoPrimaria_in_expressaoUnaria837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBTRACAO_in_expressaoUnaria842 = new BitSet(new long[]{0x10C06009800C0000L,0x0000000000030000L});
    public static final BitSet FOLLOW_expressaoPrimaria_in_expressaoUnaria844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGACAO_in_expressaoUnaria849 = new BitSet(new long[]{0x10C06009800C0000L,0x0000000000030000L});
    public static final BitSet FOLLOW_expressaoPrimaria_in_expressaoUnaria851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_expressaoPrimaria862 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_expressaoPrimaria864 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_expressaoPrimaria866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALOR_BOOLEANO_in_expressaoPrimaria871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALOR_NULO_in_expressaoPrimaria876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTE_INTEIRA_in_expressaoPrimaria881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTE_REAL_in_expressaoPrimaria886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_CARACTERE_in_expressaoPrimaria891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_TEXTO_in_expressaoPrimaria896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comando_in_expressaoPrimaria901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referencia_in_comando912 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_chamada_in_comando915 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_ESSE_in_referencia928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESSA_in_referencia933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanciacao_in_referencia938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_referencia943 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_listaDeParametros_in_referencia946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_chamada959 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_chamada967 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_listaDeParametros_in_chamada970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_instanciacao983 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_instanciacao991 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeParametros_in_instanciacao993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESTRUA_in_destruicao1004 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_destruicao1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETORNE_in_retorno1018 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_retorno1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SE_in_se1031 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_se1033 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_se1035 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_se1037 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_se1039 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_SENAO_in_se1042 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_se1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARA_in_para1057 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_para1059 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_para1061 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_para1063 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_para1065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_para1067 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_para1069 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_para1071 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_para1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPITA_in_repita1084 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_repita1086 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_declaracao_in_repita1088 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_repita1090 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_repita1092 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_repita1094 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_repita1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENQUANTO_in_enquanto1107 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_enquanto1109 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_enquanto1111 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_enquanto1113 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_enquanto1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TENTE_in_tente1126 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_tente1128 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_listaDeCapturas_in_tente1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPTURE_in_capture1141 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_capture1143 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_declaracao_in_capture1145 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_capture1147 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_capture1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANCE_in_lance1160 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_lance1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_instrucao1190 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoComAtribuicaoOpcional_in_instrucao1198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPRIMIR_in_instrucao1208 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEPURAR_in_instrucao1215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_destruicao_in_instrucao1222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorno_in_instrucao1229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_instrucao1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_instrucao1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repita_in_instrucao1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_instrucao1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tente_in_instrucao1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lance_in_instrucao1261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INICIO_in_blocoDeInstrucoes1274 = new BitSet(new long[]{0x14E0690DA0CC0000L,0x00000000000328D0L});
    public static final BitSet FOLLOW_instrucao_in_blocoDeInstrucoes1277 = new BitSet(new long[]{0x14E0690DA0CC0000L,0x00000000000328D0L});
    public static final BitSet FOLLOW_FIM_in_blocoDeInstrucoes1281 = new BitSet(new long[]{0x0000000000000002L});

}