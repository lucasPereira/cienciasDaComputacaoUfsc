// $ANTLR 3.4 fontes/g/CanecaArvore.g 2012-12-21 09:02:52

	package br.ufsc.inf.ine5426.caneca.antlr;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class CanecaArvore extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATRIBUIDOR", "ATRIBUTO", "CAPTURE", "CARACTERE", "CARACTERE_DE_ESCAPE", "CARACTERE_NAO_IMPRIMIVEL", "CHAMADA_DE_CLASSE", "CHAMADA_DE_OBJETO", "CLASSE", "COLCHETE_DIREITO", "COLCHETE_ESQUERDO", "COMENTARIO_EM_BLOCO", "COMENTARIO_EM_LINHA", "COMO", "CONSTANTE_INTEIRA", "CONSTANTE_REAL", "CONSTRUTOR", "DECLARE", "DEPURAR", "DESTRUA", "DESTRUTOR", "DIFERENTE", "DIGITO", "DIVISAO", "E", "ENQUANTO", "ESPACO_EM_BRANCO", "ESSA", "ESSE", "ESTATICO", "FIM", "IDENTIFICADOR", "IDENTIFICADOR_DE_PACOTE", "IGUAL", "IMPLEMENTA", "IMPORTE", "IMPRIMIR", "INICIO", "INTERFACE", "LANCE", "LETRA", "LITERAL_CARACTERE", "LITERAL_TEXTO", "MAIOR", "MAIOR_IGUAL", "MENOR", "MENOR_IGUAL", "METODO", "MULTIPLICACAO", "NEGACAO", "NOVA", "NOVO", "OU", "PACOTE", "PARA", "PARENTESE_DIREITO", "PARENTESE_ESQUERDO", "PRIVADA", "PRIVADO", "PROTEGIDA", "PROTEGIDO", "PUBLICA", "PUBLICO", "QUEBRA_DE_LINHA", "REPITA", "RESTO_DA_DIVISAO", "RETORNE", "SE", "SENAO", "SEPARADOR", "SOMA", "SUBTRACAO", "TABULACAO", "TENTE", "TERMINADOR", "USADO_EM_TEXTO", "VALOR_BOOLEANO", "VALOR_NULO", "ARGUMENTOS_", "ASSINATURAS_DE_METODOS_", "ASSINATURA_", "ASSINATURA_DE_METODO_", "ATRIBUICAO_", "ATRIBUTOS_", "ATRIBUTO_", "CABECALHO_", "CAPTURAS_", "CAPTURE_", "CHAMADA_DE_CLASSE_", "CHAMADA_DE_OBJETO_", "CLASSE_", "COMANDO_", "CONSTRUTORES_", "CONSTRUTOR_", "CORPO_", "DECLARACAO_", "DECLARACAO_COM_ATRIBUICAO_OPICIONAL_", "DESTRUICAO_", "DESTRUTORES_", "DESTRUTOR_", "ENQUANTO_", "EXPRESSAO_", "IMPORTACAO_", "IMPORTACOES_", "INSTANCIACAO_", "INSTRUCOES_", "INTERFACES_", "INTERFACE_", "LANCE_", "METODOS_", "METODO_", "NEGATIVACAO_", "PACOTE_", "PARAMETROS_", "PARA_", "PRIMARIA_", "PROGRAMA_", "REFERENCIA_", "REPITA_", "RETORNO_", "SELECAO_", "SE_", "TENTE_", "TIPOS_", "TIPOS_GENERICOS_", "TIPO_", "TIPO_GENERICO_", "UNIDADE_"
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
    public static final int ARGUMENTOS_=82;
    public static final int ASSINATURAS_DE_METODOS_=83;
    public static final int ASSINATURA_=84;
    public static final int ASSINATURA_DE_METODO_=85;
    public static final int ATRIBUICAO_=86;
    public static final int ATRIBUTOS_=87;
    public static final int ATRIBUTO_=88;
    public static final int CABECALHO_=89;
    public static final int CAPTURAS_=90;
    public static final int CAPTURE_=91;
    public static final int CHAMADA_DE_CLASSE_=92;
    public static final int CHAMADA_DE_OBJETO_=93;
    public static final int CLASSE_=94;
    public static final int COMANDO_=95;
    public static final int CONSTRUTORES_=96;
    public static final int CONSTRUTOR_=97;
    public static final int CORPO_=98;
    public static final int DECLARACAO_=99;
    public static final int DECLARACAO_COM_ATRIBUICAO_OPICIONAL_=100;
    public static final int DESTRUICAO_=101;
    public static final int DESTRUTORES_=102;
    public static final int DESTRUTOR_=103;
    public static final int ENQUANTO_=104;
    public static final int EXPRESSAO_=105;
    public static final int IMPORTACAO_=106;
    public static final int IMPORTACOES_=107;
    public static final int INSTANCIACAO_=108;
    public static final int INSTRUCOES_=109;
    public static final int INTERFACES_=110;
    public static final int INTERFACE_=111;
    public static final int LANCE_=112;
    public static final int METODOS_=113;
    public static final int METODO_=114;
    public static final int NEGATIVACAO_=115;
    public static final int PACOTE_=116;
    public static final int PARAMETROS_=117;
    public static final int PARA_=118;
    public static final int PRIMARIA_=119;
    public static final int PROGRAMA_=120;
    public static final int REFERENCIA_=121;
    public static final int REPITA_=122;
    public static final int RETORNO_=123;
    public static final int SELECAO_=124;
    public static final int SE_=125;
    public static final int TENTE_=126;
    public static final int TIPOS_=127;
    public static final int TIPOS_GENERICOS_=128;
    public static final int TIPO_=129;
    public static final int TIPO_GENERICO_=130;
    public static final int UNIDADE_=131;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public CanecaArvore(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public CanecaArvore(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return CanecaArvore.tokenNames; }
    public String getGrammarFileName() { return "fontes/g/CanecaArvore.g"; }


    	@Override
    	public void recover(IntStream entrada, RecognitionException erro) {
    		
    	}
    	
    	@Override
    	public Object recoverFromMismatchedToken(IntStream entrada, int tipoDoSimbolo, BitSet conjuntoDeFollows) throws RecognitionException {
    		throw new MismatchedTokenException(tipoDoSimbolo, entrada);
    	}
    	
    	@Override
    	public Object recoverFromMismatchedSet(IntStream entrada, RecognitionException erro, BitSet conjuntoDeFollows) throws RecognitionException {
    		throw erro;
    	}


    public static class programa_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "programa"
    // fontes/g/CanecaArvore.g:93:1: programa : ( unicadeDeCompilacao )+ -> ^( PROGRAMA_ ( unicadeDeCompilacao )+ ) ;
    public final CanecaArvore.programa_return programa() throws RecognitionException {
        CanecaArvore.programa_return retval = new CanecaArvore.programa_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.unicadeDeCompilacao_return unicadeDeCompilacao1 =null;


        RewriteRuleSubtreeStream stream_unicadeDeCompilacao=new RewriteRuleSubtreeStream(adaptor,"rule unicadeDeCompilacao");
        try {
            // fontes/g/CanecaArvore.g:94:2: ( ( unicadeDeCompilacao )+ -> ^( PROGRAMA_ ( unicadeDeCompilacao )+ ) )
            // fontes/g/CanecaArvore.g:94:4: ( unicadeDeCompilacao )+
            {
            // fontes/g/CanecaArvore.g:94:4: ( unicadeDeCompilacao )+
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
            	    // fontes/g/CanecaArvore.g:94:5: unicadeDeCompilacao
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_unicadeDeCompilacao_in_programa291);
            	    unicadeDeCompilacao1=unicadeDeCompilacao();

            	    state._fsp--;

            	    stream_unicadeDeCompilacao.add(unicadeDeCompilacao1.getTree());

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


            // AST REWRITE
            // elements: unicadeDeCompilacao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 94:27: -> ^( PROGRAMA_ ( unicadeDeCompilacao )+ )
            {
                // fontes/g/CanecaArvore.g:94:30: ^( PROGRAMA_ ( unicadeDeCompilacao )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PROGRAMA_, "PROGRAMA_")
                , root_1);

                if ( !(stream_unicadeDeCompilacao.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_unicadeDeCompilacao.hasNext() ) {
                    adaptor.addChild(root_1, stream_unicadeDeCompilacao.nextTree());

                }
                stream_unicadeDeCompilacao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "programa"


    public static class unicadeDeCompilacao_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unicadeDeCompilacao"
    // fontes/g/CanecaArvore.g:97:1: unicadeDeCompilacao : cabecalho ( classe -> ^( UNIDADE_ cabecalho classe ) | interfaces -> ^( UNIDADE_ cabecalho interfaces ) ) ;
    public final CanecaArvore.unicadeDeCompilacao_return unicadeDeCompilacao() throws RecognitionException {
        CanecaArvore.unicadeDeCompilacao_return retval = new CanecaArvore.unicadeDeCompilacao_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.cabecalho_return cabecalho2 =null;

        CanecaArvore.classe_return classe3 =null;

        CanecaArvore.interfaces_return interfaces4 =null;


        RewriteRuleSubtreeStream stream_classe=new RewriteRuleSubtreeStream(adaptor,"rule classe");
        RewriteRuleSubtreeStream stream_interfaces=new RewriteRuleSubtreeStream(adaptor,"rule interfaces");
        RewriteRuleSubtreeStream stream_cabecalho=new RewriteRuleSubtreeStream(adaptor,"rule cabecalho");
        try {
            // fontes/g/CanecaArvore.g:98:2: ( cabecalho ( classe -> ^( UNIDADE_ cabecalho classe ) | interfaces -> ^( UNIDADE_ cabecalho interfaces ) ) )
            // fontes/g/CanecaArvore.g:98:4: cabecalho ( classe -> ^( UNIDADE_ cabecalho classe ) | interfaces -> ^( UNIDADE_ cabecalho interfaces ) )
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cabecalho_in_unicadeDeCompilacao315);
            cabecalho2=cabecalho();

            state._fsp--;

            stream_cabecalho.add(cabecalho2.getTree());

            // fontes/g/CanecaArvore.g:99:3: ( classe -> ^( UNIDADE_ cabecalho classe ) | interfaces -> ^( UNIDADE_ cabecalho interfaces ) )
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
                    // fontes/g/CanecaArvore.g:99:5: classe
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_classe_in_unicadeDeCompilacao321);
                    classe3=classe();

                    state._fsp--;

                    stream_classe.add(classe3.getTree());

                    // AST REWRITE
                    // elements: classe, cabecalho
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 99:12: -> ^( UNIDADE_ cabecalho classe )
                    {
                        // fontes/g/CanecaArvore.g:99:15: ^( UNIDADE_ cabecalho classe )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(UNIDADE_, "UNIDADE_")
                        , root_1);

                        adaptor.addChild(root_1, stream_cabecalho.nextTree());

                        adaptor.addChild(root_1, stream_classe.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:100:5: interfaces
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_interfaces_in_unicadeDeCompilacao337);
                    interfaces4=interfaces();

                    state._fsp--;

                    stream_interfaces.add(interfaces4.getTree());

                    // AST REWRITE
                    // elements: cabecalho, interfaces
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 100:16: -> ^( UNIDADE_ cabecalho interfaces )
                    {
                        // fontes/g/CanecaArvore.g:100:19: ^( UNIDADE_ cabecalho interfaces )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(UNIDADE_, "UNIDADE_")
                        , root_1);

                        adaptor.addChild(root_1, stream_cabecalho.nextTree());

                        adaptor.addChild(root_1, stream_interfaces.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unicadeDeCompilacao"


    public static class cabecalho_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cabecalho"
    // fontes/g/CanecaArvore.g:104:1: cabecalho : pacote importacoes -> ^( CABECALHO_ pacote importacoes ) ;
    public final CanecaArvore.cabecalho_return cabecalho() throws RecognitionException {
        CanecaArvore.cabecalho_return retval = new CanecaArvore.cabecalho_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.pacote_return pacote5 =null;

        CanecaArvore.importacoes_return importacoes6 =null;


        RewriteRuleSubtreeStream stream_pacote=new RewriteRuleSubtreeStream(adaptor,"rule pacote");
        RewriteRuleSubtreeStream stream_importacoes=new RewriteRuleSubtreeStream(adaptor,"rule importacoes");
        try {
            // fontes/g/CanecaArvore.g:105:2: ( pacote importacoes -> ^( CABECALHO_ pacote importacoes ) )
            // fontes/g/CanecaArvore.g:105:4: pacote importacoes
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_pacote_in_cabecalho362);
            pacote5=pacote();

            state._fsp--;

            stream_pacote.add(pacote5.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_importacoes_in_cabecalho364);
            importacoes6=importacoes();

            state._fsp--;

            stream_importacoes.add(importacoes6.getTree());

            // AST REWRITE
            // elements: pacote, importacoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 105:23: -> ^( CABECALHO_ pacote importacoes )
            {
                // fontes/g/CanecaArvore.g:105:26: ^( CABECALHO_ pacote importacoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CABECALHO_, "CABECALHO_")
                , root_1);

                adaptor.addChild(root_1, stream_pacote.nextTree());

                adaptor.addChild(root_1, stream_importacoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cabecalho"


    public static class pacote_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pacote"
    // fontes/g/CanecaArvore.g:108:1: pacote : PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR -> ^( PACOTE_ IDENTIFICADOR_DE_PACOTE ) ;
    public final CanecaArvore.pacote_return pacote() throws RecognitionException {
        CanecaArvore.pacote_return retval = new CanecaArvore.pacote_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PACOTE7=null;
        CommonTree IDENTIFICADOR_DE_PACOTE8=null;
        CommonTree TERMINADOR9=null;

        CommonTree PACOTE7_tree=null;
        CommonTree IDENTIFICADOR_DE_PACOTE8_tree=null;
        CommonTree TERMINADOR9_tree=null;
        RewriteRuleNodeStream stream_PACOTE=new RewriteRuleNodeStream(adaptor,"token PACOTE");
        RewriteRuleNodeStream stream_TERMINADOR=new RewriteRuleNodeStream(adaptor,"token TERMINADOR");
        RewriteRuleNodeStream stream_IDENTIFICADOR_DE_PACOTE=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR_DE_PACOTE");

        try {
            // fontes/g/CanecaArvore.g:109:2: ( PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR -> ^( PACOTE_ IDENTIFICADOR_DE_PACOTE ) )
            // fontes/g/CanecaArvore.g:109:4: PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR
            {
            _last = (CommonTree)input.LT(1);
            PACOTE7=(CommonTree)match(input,PACOTE,FOLLOW_PACOTE_in_pacote385);  
            stream_PACOTE.add(PACOTE7);


            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR_DE_PACOTE8=(CommonTree)match(input,IDENTIFICADOR_DE_PACOTE,FOLLOW_IDENTIFICADOR_DE_PACOTE_in_pacote387);  
            stream_IDENTIFICADOR_DE_PACOTE.add(IDENTIFICADOR_DE_PACOTE8);


            _last = (CommonTree)input.LT(1);
            TERMINADOR9=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_pacote389);  
            stream_TERMINADOR.add(TERMINADOR9);


            // AST REWRITE
            // elements: IDENTIFICADOR_DE_PACOTE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 109:46: -> ^( PACOTE_ IDENTIFICADOR_DE_PACOTE )
            {
                // fontes/g/CanecaArvore.g:109:49: ^( PACOTE_ IDENTIFICADOR_DE_PACOTE )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PACOTE_, "PACOTE_")
                , root_1);

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR_DE_PACOTE.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pacote"


    public static class importacoes_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "importacoes"
    // fontes/g/CanecaArvore.g:112:1: importacoes : ( importacao )* -> ^( IMPORTACOES_ ( importacao )* ) ;
    public final CanecaArvore.importacoes_return importacoes() throws RecognitionException {
        CanecaArvore.importacoes_return retval = new CanecaArvore.importacoes_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.importacao_return importacao10 =null;


        RewriteRuleSubtreeStream stream_importacao=new RewriteRuleSubtreeStream(adaptor,"rule importacao");
        try {
            // fontes/g/CanecaArvore.g:113:2: ( ( importacao )* -> ^( IMPORTACOES_ ( importacao )* ) )
            // fontes/g/CanecaArvore.g:113:4: ( importacao )*
            {
            // fontes/g/CanecaArvore.g:113:4: ( importacao )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IMPORTE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:113:5: importacao
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_importacao_in_importacoes409);
            	    importacao10=importacao();

            	    state._fsp--;

            	    stream_importacao.add(importacao10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // AST REWRITE
            // elements: importacao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 113:18: -> ^( IMPORTACOES_ ( importacao )* )
            {
                // fontes/g/CanecaArvore.g:113:21: ^( IMPORTACOES_ ( importacao )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPORTACOES_, "IMPORTACOES_")
                , root_1);

                // fontes/g/CanecaArvore.g:113:36: ( importacao )*
                while ( stream_importacao.hasNext() ) {
                    adaptor.addChild(root_1, stream_importacao.nextTree());

                }
                stream_importacao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "importacoes"


    public static class importacao_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "importacao"
    // fontes/g/CanecaArvore.g:116:1: importacao : IMPORTE ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? -> ^( IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( IDENTIFICADOR )? ) | IDENTIFICADOR_DE_PACOTE -> ^( IMPORTACAO_ IDENTIFICADOR_DE_PACOTE ) ) TERMINADOR ;
    public final CanecaArvore.importacao_return importacao() throws RecognitionException {
        CanecaArvore.importacao_return retval = new CanecaArvore.importacao_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORTE11=null;
        CommonTree IDENTIFICADOR12=null;
        CommonTree IDENTIFICADOR_DE_PACOTE13=null;
        CommonTree COMO14=null;
        CommonTree IDENTIFICADOR15=null;
        CommonTree IDENTIFICADOR_DE_PACOTE16=null;
        CommonTree TERMINADOR17=null;

        CommonTree IMPORTE11_tree=null;
        CommonTree IDENTIFICADOR12_tree=null;
        CommonTree IDENTIFICADOR_DE_PACOTE13_tree=null;
        CommonTree COMO14_tree=null;
        CommonTree IDENTIFICADOR15_tree=null;
        CommonTree IDENTIFICADOR_DE_PACOTE16_tree=null;
        CommonTree TERMINADOR17_tree=null;
        RewriteRuleNodeStream stream_TERMINADOR=new RewriteRuleNodeStream(adaptor,"token TERMINADOR");
        RewriteRuleNodeStream stream_COMO=new RewriteRuleNodeStream(adaptor,"token COMO");
        RewriteRuleNodeStream stream_IMPORTE=new RewriteRuleNodeStream(adaptor,"token IMPORTE");
        RewriteRuleNodeStream stream_IDENTIFICADOR_DE_PACOTE=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR_DE_PACOTE");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");

        try {
            // fontes/g/CanecaArvore.g:117:2: ( IMPORTE ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? -> ^( IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( IDENTIFICADOR )? ) | IDENTIFICADOR_DE_PACOTE -> ^( IMPORTACAO_ IDENTIFICADOR_DE_PACOTE ) ) TERMINADOR )
            // fontes/g/CanecaArvore.g:117:4: IMPORTE ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? -> ^( IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( IDENTIFICADOR )? ) | IDENTIFICADOR_DE_PACOTE -> ^( IMPORTACAO_ IDENTIFICADOR_DE_PACOTE ) ) TERMINADOR
            {
            _last = (CommonTree)input.LT(1);
            IMPORTE11=(CommonTree)match(input,IMPORTE,FOLLOW_IMPORTE_in_importacao433);  
            stream_IMPORTE.add(IMPORTE11);


            // fontes/g/CanecaArvore.g:118:3: ( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )? -> ^( IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( IDENTIFICADOR )? ) | IDENTIFICADOR_DE_PACOTE -> ^( IMPORTACAO_ IDENTIFICADOR_DE_PACOTE ) )
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
                    // fontes/g/CanecaArvore.g:118:5: IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( COMO IDENTIFICADOR )?
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFICADOR12=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_importacao439);  
                    stream_IDENTIFICADOR.add(IDENTIFICADOR12);


                    _last = (CommonTree)input.LT(1);
                    IDENTIFICADOR_DE_PACOTE13=(CommonTree)match(input,IDENTIFICADOR_DE_PACOTE,FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao441);  
                    stream_IDENTIFICADOR_DE_PACOTE.add(IDENTIFICADOR_DE_PACOTE13);


                    // fontes/g/CanecaArvore.g:118:43: ( COMO IDENTIFICADOR )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==COMO) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // fontes/g/CanecaArvore.g:118:44: COMO IDENTIFICADOR
                            {
                            _last = (CommonTree)input.LT(1);
                            COMO14=(CommonTree)match(input,COMO,FOLLOW_COMO_in_importacao444);  
                            stream_COMO.add(COMO14);


                            _last = (CommonTree)input.LT(1);
                            IDENTIFICADOR15=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_importacao446);  
                            stream_IDENTIFICADOR.add(IDENTIFICADOR15);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: IDENTIFICADOR, IDENTIFICADOR, IDENTIFICADOR_DE_PACOTE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 118:65: -> ^( IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( IDENTIFICADOR )? )
                    {
                        // fontes/g/CanecaArvore.g:118:68: ^( IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE ( IDENTIFICADOR )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(IMPORTACAO_, "IMPORTACAO_")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR_DE_PACOTE.nextNode()
                        );

                        // fontes/g/CanecaArvore.g:118:120: ( IDENTIFICADOR )?
                        if ( stream_IDENTIFICADOR.hasNext() ) {
                            adaptor.addChild(root_1, 
                            stream_IDENTIFICADOR.nextNode()
                            );

                        }
                        stream_IDENTIFICADOR.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:119:5: IDENTIFICADOR_DE_PACOTE
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFICADOR_DE_PACOTE16=(CommonTree)match(input,IDENTIFICADOR_DE_PACOTE,FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao469);  
                    stream_IDENTIFICADOR_DE_PACOTE.add(IDENTIFICADOR_DE_PACOTE16);


                    // AST REWRITE
                    // elements: IDENTIFICADOR_DE_PACOTE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 119:29: -> ^( IMPORTACAO_ IDENTIFICADOR_DE_PACOTE )
                    {
                        // fontes/g/CanecaArvore.g:119:32: ^( IMPORTACAO_ IDENTIFICADOR_DE_PACOTE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(IMPORTACAO_, "IMPORTACAO_")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR_DE_PACOTE.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            TERMINADOR17=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_importacao483);  
            stream_TERMINADOR.add(TERMINADOR17);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "importacao"


    public static class classe_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "classe"
    // fontes/g/CanecaArvore.g:123:1: classe : CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse -> ^( CLASSE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse ) ;
    public final CanecaArvore.classe_return classe() throws RecognitionException {
        CanecaArvore.classe_return retval = new CanecaArvore.classe_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CLASSE18=null;
        CommonTree IDENTIFICADOR20=null;
        CanecaArvore.modificadorDeAcessoFeminino_return modificadorDeAcessoFeminino19 =null;

        CanecaArvore.listaDeTiposGenericos_return listaDeTiposGenericos21 =null;

        CanecaArvore.listaDeInterfaces_return listaDeInterfaces22 =null;

        CanecaArvore.corpoDaClasse_return corpoDaClasse23 =null;


        CommonTree CLASSE18_tree=null;
        CommonTree IDENTIFICADOR20_tree=null;
        RewriteRuleNodeStream stream_CLASSE=new RewriteRuleNodeStream(adaptor,"token CLASSE");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_modificadorDeAcessoFeminino=new RewriteRuleSubtreeStream(adaptor,"rule modificadorDeAcessoFeminino");
        RewriteRuleSubtreeStream stream_corpoDaClasse=new RewriteRuleSubtreeStream(adaptor,"rule corpoDaClasse");
        RewriteRuleSubtreeStream stream_listaDeTiposGenericos=new RewriteRuleSubtreeStream(adaptor,"rule listaDeTiposGenericos");
        RewriteRuleSubtreeStream stream_listaDeInterfaces=new RewriteRuleSubtreeStream(adaptor,"rule listaDeInterfaces");
        try {
            // fontes/g/CanecaArvore.g:124:2: ( CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse -> ^( CLASSE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse ) )
            // fontes/g/CanecaArvore.g:124:4: CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse
            {
            _last = (CommonTree)input.LT(1);
            CLASSE18=(CommonTree)match(input,CLASSE,FOLLOW_CLASSE_in_classe494);  
            stream_CLASSE.add(CLASSE18);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_modificadorDeAcessoFeminino_in_classe496);
            modificadorDeAcessoFeminino19=modificadorDeAcessoFeminino();

            state._fsp--;

            stream_modificadorDeAcessoFeminino.add(modificadorDeAcessoFeminino19.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR20=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_classe498);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR20);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeTiposGenericos_in_classe500);
            listaDeTiposGenericos21=listaDeTiposGenericos();

            state._fsp--;

            stream_listaDeTiposGenericos.add(listaDeTiposGenericos21.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeInterfaces_in_classe502);
            listaDeInterfaces22=listaDeInterfaces();

            state._fsp--;

            stream_listaDeInterfaces.add(listaDeInterfaces22.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_corpoDaClasse_in_classe504);
            corpoDaClasse23=corpoDaClasse();

            state._fsp--;

            stream_corpoDaClasse.add(corpoDaClasse23.getTree());

            // AST REWRITE
            // elements: corpoDaClasse, IDENTIFICADOR, modificadorDeAcessoFeminino, listaDeTiposGenericos, listaDeInterfaces
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 124:107: -> ^( CLASSE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse )
            {
                // fontes/g/CanecaArvore.g:124:110: ^( CLASSE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CLASSE_, "CLASSE_")
                , root_1);

                adaptor.addChild(root_1, stream_modificadorDeAcessoFeminino.nextTree());

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_1, stream_listaDeTiposGenericos.nextTree());

                adaptor.addChild(root_1, stream_listaDeInterfaces.nextTree());

                adaptor.addChild(root_1, stream_corpoDaClasse.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "classe"


    public static class interfaces_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "interfaces"
    // fontes/g/CanecaArvore.g:127:1: interfaces : INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface -> ^( INTERFACE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface ) ;
    public final CanecaArvore.interfaces_return interfaces() throws RecognitionException {
        CanecaArvore.interfaces_return retval = new CanecaArvore.interfaces_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INTERFACE24=null;
        CommonTree IDENTIFICADOR26=null;
        CanecaArvore.modificadorDeAcessoFeminino_return modificadorDeAcessoFeminino25 =null;

        CanecaArvore.listaDeTiposGenericos_return listaDeTiposGenericos27 =null;

        CanecaArvore.listaDeInterfaces_return listaDeInterfaces28 =null;

        CanecaArvore.corpoDaInterface_return corpoDaInterface29 =null;


        CommonTree INTERFACE24_tree=null;
        CommonTree IDENTIFICADOR26_tree=null;
        RewriteRuleNodeStream stream_INTERFACE=new RewriteRuleNodeStream(adaptor,"token INTERFACE");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_corpoDaInterface=new RewriteRuleSubtreeStream(adaptor,"rule corpoDaInterface");
        RewriteRuleSubtreeStream stream_modificadorDeAcessoFeminino=new RewriteRuleSubtreeStream(adaptor,"rule modificadorDeAcessoFeminino");
        RewriteRuleSubtreeStream stream_listaDeTiposGenericos=new RewriteRuleSubtreeStream(adaptor,"rule listaDeTiposGenericos");
        RewriteRuleSubtreeStream stream_listaDeInterfaces=new RewriteRuleSubtreeStream(adaptor,"rule listaDeInterfaces");
        try {
            // fontes/g/CanecaArvore.g:128:2: ( INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface -> ^( INTERFACE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface ) )
            // fontes/g/CanecaArvore.g:128:4: INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface
            {
            _last = (CommonTree)input.LT(1);
            INTERFACE24=(CommonTree)match(input,INTERFACE,FOLLOW_INTERFACE_in_interfaces531);  
            stream_INTERFACE.add(INTERFACE24);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_modificadorDeAcessoFeminino_in_interfaces533);
            modificadorDeAcessoFeminino25=modificadorDeAcessoFeminino();

            state._fsp--;

            stream_modificadorDeAcessoFeminino.add(modificadorDeAcessoFeminino25.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR26=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_interfaces535);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR26);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeTiposGenericos_in_interfaces537);
            listaDeTiposGenericos27=listaDeTiposGenericos();

            state._fsp--;

            stream_listaDeTiposGenericos.add(listaDeTiposGenericos27.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeInterfaces_in_interfaces539);
            listaDeInterfaces28=listaDeInterfaces();

            state._fsp--;

            stream_listaDeInterfaces.add(listaDeInterfaces28.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_corpoDaInterface_in_interfaces541);
            corpoDaInterface29=corpoDaInterface();

            state._fsp--;

            stream_corpoDaInterface.add(corpoDaInterface29.getTree());

            // AST REWRITE
            // elements: listaDeTiposGenericos, IDENTIFICADOR, corpoDaInterface, listaDeInterfaces, modificadorDeAcessoFeminino
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 128:113: -> ^( INTERFACE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface )
            {
                // fontes/g/CanecaArvore.g:128:116: ^( INTERFACE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(INTERFACE_, "INTERFACE_")
                , root_1);

                adaptor.addChild(root_1, stream_modificadorDeAcessoFeminino.nextTree());

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_1, stream_listaDeTiposGenericos.nextTree());

                adaptor.addChild(root_1, stream_listaDeInterfaces.nextTree());

                adaptor.addChild(root_1, stream_corpoDaInterface.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "interfaces"


    public static class corpoDaClasse_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "corpoDaClasse"
    // fontes/g/CanecaArvore.g:131:1: corpoDaClasse : INICIO atributos construtores destrutor metodos FIM -> ^( CORPO_ atributos construtores destrutor metodos ) ;
    public final CanecaArvore.corpoDaClasse_return corpoDaClasse() throws RecognitionException {
        CanecaArvore.corpoDaClasse_return retval = new CanecaArvore.corpoDaClasse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INICIO30=null;
        CommonTree FIM35=null;
        CanecaArvore.atributos_return atributos31 =null;

        CanecaArvore.construtores_return construtores32 =null;

        CanecaArvore.destrutor_return destrutor33 =null;

        CanecaArvore.metodos_return metodos34 =null;


        CommonTree INICIO30_tree=null;
        CommonTree FIM35_tree=null;
        RewriteRuleNodeStream stream_INICIO=new RewriteRuleNodeStream(adaptor,"token INICIO");
        RewriteRuleNodeStream stream_FIM=new RewriteRuleNodeStream(adaptor,"token FIM");
        RewriteRuleSubtreeStream stream_construtores=new RewriteRuleSubtreeStream(adaptor,"rule construtores");
        RewriteRuleSubtreeStream stream_atributos=new RewriteRuleSubtreeStream(adaptor,"rule atributos");
        RewriteRuleSubtreeStream stream_metodos=new RewriteRuleSubtreeStream(adaptor,"rule metodos");
        RewriteRuleSubtreeStream stream_destrutor=new RewriteRuleSubtreeStream(adaptor,"rule destrutor");
        try {
            // fontes/g/CanecaArvore.g:132:2: ( INICIO atributos construtores destrutor metodos FIM -> ^( CORPO_ atributos construtores destrutor metodos ) )
            // fontes/g/CanecaArvore.g:132:4: INICIO atributos construtores destrutor metodos FIM
            {
            _last = (CommonTree)input.LT(1);
            INICIO30=(CommonTree)match(input,INICIO,FOLLOW_INICIO_in_corpoDaClasse568);  
            stream_INICIO.add(INICIO30);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_atributos_in_corpoDaClasse570);
            atributos31=atributos();

            state._fsp--;

            stream_atributos.add(atributos31.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_construtores_in_corpoDaClasse572);
            construtores32=construtores();

            state._fsp--;

            stream_construtores.add(construtores32.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_destrutor_in_corpoDaClasse574);
            destrutor33=destrutor();

            state._fsp--;

            stream_destrutor.add(destrutor33.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_metodos_in_corpoDaClasse576);
            metodos34=metodos();

            state._fsp--;

            stream_metodos.add(metodos34.getTree());

            _last = (CommonTree)input.LT(1);
            FIM35=(CommonTree)match(input,FIM,FOLLOW_FIM_in_corpoDaClasse578);  
            stream_FIM.add(FIM35);


            // AST REWRITE
            // elements: destrutor, atributos, construtores, metodos
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 132:56: -> ^( CORPO_ atributos construtores destrutor metodos )
            {
                // fontes/g/CanecaArvore.g:132:59: ^( CORPO_ atributos construtores destrutor metodos )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CORPO_, "CORPO_")
                , root_1);

                adaptor.addChild(root_1, stream_atributos.nextTree());

                adaptor.addChild(root_1, stream_construtores.nextTree());

                adaptor.addChild(root_1, stream_destrutor.nextTree());

                adaptor.addChild(root_1, stream_metodos.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "corpoDaClasse"


    public static class corpoDaInterface_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "corpoDaInterface"
    // fontes/g/CanecaArvore.g:135:1: corpoDaInterface : INICIO atributos assinaturasDeMetodos FIM -> ^( CORPO_ atributos assinaturasDeMetodos ) ;
    public final CanecaArvore.corpoDaInterface_return corpoDaInterface() throws RecognitionException {
        CanecaArvore.corpoDaInterface_return retval = new CanecaArvore.corpoDaInterface_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INICIO36=null;
        CommonTree FIM39=null;
        CanecaArvore.atributos_return atributos37 =null;

        CanecaArvore.assinaturasDeMetodos_return assinaturasDeMetodos38 =null;


        CommonTree INICIO36_tree=null;
        CommonTree FIM39_tree=null;
        RewriteRuleNodeStream stream_INICIO=new RewriteRuleNodeStream(adaptor,"token INICIO");
        RewriteRuleNodeStream stream_FIM=new RewriteRuleNodeStream(adaptor,"token FIM");
        RewriteRuleSubtreeStream stream_atributos=new RewriteRuleSubtreeStream(adaptor,"rule atributos");
        RewriteRuleSubtreeStream stream_assinaturasDeMetodos=new RewriteRuleSubtreeStream(adaptor,"rule assinaturasDeMetodos");
        try {
            // fontes/g/CanecaArvore.g:136:2: ( INICIO atributos assinaturasDeMetodos FIM -> ^( CORPO_ atributos assinaturasDeMetodos ) )
            // fontes/g/CanecaArvore.g:136:4: INICIO atributos assinaturasDeMetodos FIM
            {
            _last = (CommonTree)input.LT(1);
            INICIO36=(CommonTree)match(input,INICIO,FOLLOW_INICIO_in_corpoDaInterface603);  
            stream_INICIO.add(INICIO36);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_atributos_in_corpoDaInterface605);
            atributos37=atributos();

            state._fsp--;

            stream_atributos.add(atributos37.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assinaturasDeMetodos_in_corpoDaInterface607);
            assinaturasDeMetodos38=assinaturasDeMetodos();

            state._fsp--;

            stream_assinaturasDeMetodos.add(assinaturasDeMetodos38.getTree());

            _last = (CommonTree)input.LT(1);
            FIM39=(CommonTree)match(input,FIM,FOLLOW_FIM_in_corpoDaInterface609);  
            stream_FIM.add(FIM39);


            // AST REWRITE
            // elements: assinaturasDeMetodos, atributos
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 136:46: -> ^( CORPO_ atributos assinaturasDeMetodos )
            {
                // fontes/g/CanecaArvore.g:136:49: ^( CORPO_ atributos assinaturasDeMetodos )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CORPO_, "CORPO_")
                , root_1);

                adaptor.addChild(root_1, stream_atributos.nextTree());

                adaptor.addChild(root_1, stream_assinaturasDeMetodos.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "corpoDaInterface"


    public static class atributos_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atributos"
    // fontes/g/CanecaArvore.g:139:1: atributos : ( atributo )* -> ^( ATRIBUTOS_ ( atributo )* ) ;
    public final CanecaArvore.atributos_return atributos() throws RecognitionException {
        CanecaArvore.atributos_return retval = new CanecaArvore.atributos_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.atributo_return atributo40 =null;


        RewriteRuleSubtreeStream stream_atributo=new RewriteRuleSubtreeStream(adaptor,"rule atributo");
        try {
            // fontes/g/CanecaArvore.g:140:2: ( ( atributo )* -> ^( ATRIBUTOS_ ( atributo )* ) )
            // fontes/g/CanecaArvore.g:140:4: ( atributo )*
            {
            // fontes/g/CanecaArvore.g:140:4: ( atributo )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ATRIBUTO) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:140:5: atributo
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_atributo_in_atributos631);
            	    atributo40=atributo();

            	    state._fsp--;

            	    stream_atributo.add(atributo40.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // AST REWRITE
            // elements: atributo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 140:16: -> ^( ATRIBUTOS_ ( atributo )* )
            {
                // fontes/g/CanecaArvore.g:140:19: ^( ATRIBUTOS_ ( atributo )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATRIBUTOS_, "ATRIBUTOS_")
                , root_1);

                // fontes/g/CanecaArvore.g:140:32: ( atributo )*
                while ( stream_atributo.hasNext() ) {
                    adaptor.addChild(root_1, stream_atributo.nextTree());

                }
                stream_atributo.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atributos"


    public static class construtores_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "construtores"
    // fontes/g/CanecaArvore.g:143:1: construtores : ( construtor )+ -> ^( CONSTRUTORES_ ( construtor )+ ) ;
    public final CanecaArvore.construtores_return construtores() throws RecognitionException {
        CanecaArvore.construtores_return retval = new CanecaArvore.construtores_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.construtor_return construtor41 =null;


        RewriteRuleSubtreeStream stream_construtor=new RewriteRuleSubtreeStream(adaptor,"rule construtor");
        try {
            // fontes/g/CanecaArvore.g:144:2: ( ( construtor )+ -> ^( CONSTRUTORES_ ( construtor )+ ) )
            // fontes/g/CanecaArvore.g:144:4: ( construtor )+
            {
            // fontes/g/CanecaArvore.g:144:4: ( construtor )+
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
            	    // fontes/g/CanecaArvore.g:144:5: construtor
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_construtor_in_construtores656);
            	    construtor41=construtor();

            	    state._fsp--;

            	    stream_construtor.add(construtor41.getTree());

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


            // AST REWRITE
            // elements: construtor
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 144:18: -> ^( CONSTRUTORES_ ( construtor )+ )
            {
                // fontes/g/CanecaArvore.g:144:21: ^( CONSTRUTORES_ ( construtor )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONSTRUTORES_, "CONSTRUTORES_")
                , root_1);

                if ( !(stream_construtor.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_construtor.hasNext() ) {
                    adaptor.addChild(root_1, stream_construtor.nextTree());

                }
                stream_construtor.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "construtores"


    public static class metodos_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "metodos"
    // fontes/g/CanecaArvore.g:147:1: metodos : ( metodo )* -> ^( METODOS_ ( metodo )* ) ;
    public final CanecaArvore.metodos_return metodos() throws RecognitionException {
        CanecaArvore.metodos_return retval = new CanecaArvore.metodos_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.metodo_return metodo42 =null;


        RewriteRuleSubtreeStream stream_metodo=new RewriteRuleSubtreeStream(adaptor,"rule metodo");
        try {
            // fontes/g/CanecaArvore.g:148:2: ( ( metodo )* -> ^( METODOS_ ( metodo )* ) )
            // fontes/g/CanecaArvore.g:148:4: ( metodo )*
            {
            // fontes/g/CanecaArvore.g:148:4: ( metodo )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==METODO) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:148:5: metodo
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_metodo_in_metodos681);
            	    metodo42=metodo();

            	    state._fsp--;

            	    stream_metodo.add(metodo42.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // AST REWRITE
            // elements: metodo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:14: -> ^( METODOS_ ( metodo )* )
            {
                // fontes/g/CanecaArvore.g:148:17: ^( METODOS_ ( metodo )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(METODOS_, "METODOS_")
                , root_1);

                // fontes/g/CanecaArvore.g:148:28: ( metodo )*
                while ( stream_metodo.hasNext() ) {
                    adaptor.addChild(root_1, stream_metodo.nextTree());

                }
                stream_metodo.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metodos"


    public static class assinaturasDeMetodos_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturasDeMetodos"
    // fontes/g/CanecaArvore.g:151:1: assinaturasDeMetodos : ( assinaturaDeMetodo TERMINADOR )* -> ^( ASSINATURAS_DE_METODOS_ ( assinaturaDeMetodo )* ) ;
    public final CanecaArvore.assinaturasDeMetodos_return assinaturasDeMetodos() throws RecognitionException {
        CanecaArvore.assinaturasDeMetodos_return retval = new CanecaArvore.assinaturasDeMetodos_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TERMINADOR44=null;
        CanecaArvore.assinaturaDeMetodo_return assinaturaDeMetodo43 =null;


        CommonTree TERMINADOR44_tree=null;
        RewriteRuleNodeStream stream_TERMINADOR=new RewriteRuleNodeStream(adaptor,"token TERMINADOR");
        RewriteRuleSubtreeStream stream_assinaturaDeMetodo=new RewriteRuleSubtreeStream(adaptor,"rule assinaturaDeMetodo");
        try {
            // fontes/g/CanecaArvore.g:152:2: ( ( assinaturaDeMetodo TERMINADOR )* -> ^( ASSINATURAS_DE_METODOS_ ( assinaturaDeMetodo )* ) )
            // fontes/g/CanecaArvore.g:152:4: ( assinaturaDeMetodo TERMINADOR )*
            {
            // fontes/g/CanecaArvore.g:152:4: ( assinaturaDeMetodo TERMINADOR )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==METODO) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:152:5: assinaturaDeMetodo TERMINADOR
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assinaturaDeMetodo_in_assinaturasDeMetodos706);
            	    assinaturaDeMetodo43=assinaturaDeMetodo();

            	    state._fsp--;

            	    stream_assinaturaDeMetodo.add(assinaturaDeMetodo43.getTree());

            	    _last = (CommonTree)input.LT(1);
            	    TERMINADOR44=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_assinaturasDeMetodos708);  
            	    stream_TERMINADOR.add(TERMINADOR44);


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // AST REWRITE
            // elements: assinaturaDeMetodo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 152:37: -> ^( ASSINATURAS_DE_METODOS_ ( assinaturaDeMetodo )* )
            {
                // fontes/g/CanecaArvore.g:152:40: ^( ASSINATURAS_DE_METODOS_ ( assinaturaDeMetodo )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSINATURAS_DE_METODOS_, "ASSINATURAS_DE_METODOS_")
                , root_1);

                // fontes/g/CanecaArvore.g:152:66: ( assinaturaDeMetodo )*
                while ( stream_assinaturaDeMetodo.hasNext() ) {
                    adaptor.addChild(root_1, stream_assinaturaDeMetodo.nextTree());

                }
                stream_assinaturaDeMetodo.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturasDeMetodos"


    public static class atributo_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atributo"
    // fontes/g/CanecaArvore.g:155:1: atributo : ATRIBUTO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ( -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) ) TERMINADOR ;
    public final CanecaArvore.atributo_return atributo() throws RecognitionException {
        CanecaArvore.atributo_return retval = new CanecaArvore.atributo_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ATRIBUTO45=null;
        CommonTree ESTATICO47=null;
        CommonTree IDENTIFICADOR49=null;
        CommonTree ATRIBUIDOR50=null;
        CommonTree TERMINADOR52=null;
        CanecaArvore.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino46 =null;

        CanecaArvore.tipo_return tipo48 =null;

        CanecaArvore.expressaoOuLogico_return expressaoOuLogico51 =null;


        CommonTree ATRIBUTO45_tree=null;
        CommonTree ESTATICO47_tree=null;
        CommonTree IDENTIFICADOR49_tree=null;
        CommonTree ATRIBUIDOR50_tree=null;
        CommonTree TERMINADOR52_tree=null;
        RewriteRuleNodeStream stream_ATRIBUIDOR=new RewriteRuleNodeStream(adaptor,"token ATRIBUIDOR");
        RewriteRuleNodeStream stream_ATRIBUTO=new RewriteRuleNodeStream(adaptor,"token ATRIBUTO");
        RewriteRuleNodeStream stream_TERMINADOR=new RewriteRuleNodeStream(adaptor,"token TERMINADOR");
        RewriteRuleNodeStream stream_ESTATICO=new RewriteRuleNodeStream(adaptor,"token ESTATICO");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_modificadorDeAcessoMasculino=new RewriteRuleSubtreeStream(adaptor,"rule modificadorDeAcessoMasculino");
        RewriteRuleSubtreeStream stream_expressaoOuLogico=new RewriteRuleSubtreeStream(adaptor,"rule expressaoOuLogico");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // fontes/g/CanecaArvore.g:156:2: ( ATRIBUTO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ( -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) ) TERMINADOR )
            // fontes/g/CanecaArvore.g:156:4: ATRIBUTO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ( -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) ) TERMINADOR
            {
            _last = (CommonTree)input.LT(1);
            ATRIBUTO45=(CommonTree)match(input,ATRIBUTO,FOLLOW_ATRIBUTO_in_atributo732);  
            stream_ATRIBUTO.add(ATRIBUTO45);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_atributo734);
            modificadorDeAcessoMasculino46=modificadorDeAcessoMasculino();

            state._fsp--;

            stream_modificadorDeAcessoMasculino.add(modificadorDeAcessoMasculino46.getTree());

            // fontes/g/CanecaArvore.g:156:42: ( ESTATICO )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ESTATICO) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // fontes/g/CanecaArvore.g:156:43: ESTATICO
                    {
                    _last = (CommonTree)input.LT(1);
                    ESTATICO47=(CommonTree)match(input,ESTATICO,FOLLOW_ESTATICO_in_atributo737);  
                    stream_ESTATICO.add(ESTATICO47);


                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_tipo_in_atributo741);
            tipo48=tipo();

            state._fsp--;

            stream_tipo.add(tipo48.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR49=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_atributo743);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR49);


            // fontes/g/CanecaArvore.g:157:3: ( -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==TERMINADOR) ) {
                alt11=1;
            }
            else if ( (LA11_0==ATRIBUIDOR) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // fontes/g/CanecaArvore.g:157:5: 
                    {
                    // AST REWRITE
                    // elements: IDENTIFICADOR, modificadorDeAcessoMasculino, tipo, ESTATICO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 157:5: -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR )
                    {
                        // fontes/g/CanecaArvore.g:157:8: ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATRIBUTO_, "ATRIBUTO_")
                        , root_1);

                        adaptor.addChild(root_1, stream_modificadorDeAcessoMasculino.nextTree());

                        // fontes/g/CanecaArvore.g:157:49: ( ESTATICO )?
                        if ( stream_ESTATICO.hasNext() ) {
                            adaptor.addChild(root_1, 
                            stream_ESTATICO.nextNode()
                            );

                        }
                        stream_ESTATICO.reset();

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:158:5: ATRIBUIDOR expressaoOuLogico
                    {
                    _last = (CommonTree)input.LT(1);
                    ATRIBUIDOR50=(CommonTree)match(input,ATRIBUIDOR,FOLLOW_ATRIBUIDOR_in_atributo771);  
                    stream_ATRIBUIDOR.add(ATRIBUIDOR50);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressaoOuLogico_in_atributo773);
                    expressaoOuLogico51=expressaoOuLogico();

                    state._fsp--;

                    stream_expressaoOuLogico.add(expressaoOuLogico51.getTree());

                    // AST REWRITE
                    // elements: tipo, ESTATICO, ATRIBUIDOR, IDENTIFICADOR, modificadorDeAcessoMasculino, expressaoOuLogico, IDENTIFICADOR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 158:34: -> ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico )
                    {
                        // fontes/g/CanecaArvore.g:158:37: ^( ATRIBUTO_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATRIBUTO_, "ATRIBUTO_")
                        , root_1);

                        adaptor.addChild(root_1, stream_modificadorDeAcessoMasculino.nextTree());

                        // fontes/g/CanecaArvore.g:158:78: ( ESTATICO )?
                        if ( stream_ESTATICO.hasNext() ) {
                            adaptor.addChild(root_1, 
                            stream_ESTATICO.nextNode()
                            );

                        }
                        stream_ESTATICO.reset();

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                        // fontes/g/CanecaArvore.g:158:110: ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_ATRIBUIDOR.nextNode()
                        , root_1);

                        // fontes/g/CanecaArvore.g:158:123: ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(PRIMARIA_, "PRIMARIA_")
                        , root_2);

                        // fontes/g/CanecaArvore.g:158:135: ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(COMANDO_, "COMANDO_")
                        , root_3);

                        // fontes/g/CanecaArvore.g:158:146: ^( REFERENCIA_ IDENTIFICADOR )
                        {
                        CommonTree root_4 = (CommonTree)adaptor.nil();
                        root_4 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(REFERENCIA_, "REFERENCIA_")
                        , root_4);

                        adaptor.addChild(root_4, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        adaptor.addChild(root_3, root_4);
                        }

                        adaptor.addChild(root_2, root_3);
                        }

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, stream_expressaoOuLogico.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            TERMINADOR52=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_atributo817);  
            stream_TERMINADOR.add(TERMINADOR52);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atributo"


    public static class construtor_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "construtor"
    // fontes/g/CanecaArvore.g:162:1: construtor : assinaturaDeConstrutor blocoDeInstrucoes -> ^( CONSTRUTOR_ assinaturaDeConstrutor blocoDeInstrucoes ) ;
    public final CanecaArvore.construtor_return construtor() throws RecognitionException {
        CanecaArvore.construtor_return retval = new CanecaArvore.construtor_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.assinaturaDeConstrutor_return assinaturaDeConstrutor53 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes54 =null;


        RewriteRuleSubtreeStream stream_assinaturaDeConstrutor=new RewriteRuleSubtreeStream(adaptor,"rule assinaturaDeConstrutor");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        try {
            // fontes/g/CanecaArvore.g:163:2: ( assinaturaDeConstrutor blocoDeInstrucoes -> ^( CONSTRUTOR_ assinaturaDeConstrutor blocoDeInstrucoes ) )
            // fontes/g/CanecaArvore.g:163:4: assinaturaDeConstrutor blocoDeInstrucoes
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assinaturaDeConstrutor_in_construtor828);
            assinaturaDeConstrutor53=assinaturaDeConstrutor();

            state._fsp--;

            stream_assinaturaDeConstrutor.add(assinaturaDeConstrutor53.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_construtor830);
            blocoDeInstrucoes54=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes54.getTree());

            // AST REWRITE
            // elements: assinaturaDeConstrutor, blocoDeInstrucoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 163:45: -> ^( CONSTRUTOR_ assinaturaDeConstrutor blocoDeInstrucoes )
            {
                // fontes/g/CanecaArvore.g:163:48: ^( CONSTRUTOR_ assinaturaDeConstrutor blocoDeInstrucoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONSTRUTOR_, "CONSTRUTOR_")
                , root_1);

                adaptor.addChild(root_1, stream_assinaturaDeConstrutor.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "construtor"


    public static class destrutor_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "destrutor"
    // fontes/g/CanecaArvore.g:166:1: destrutor : assinaturaDeDestrutor blocoDeInstrucoes -> ^( DESTRUTOR_ assinaturaDeDestrutor blocoDeInstrucoes ) ;
    public final CanecaArvore.destrutor_return destrutor() throws RecognitionException {
        CanecaArvore.destrutor_return retval = new CanecaArvore.destrutor_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.assinaturaDeDestrutor_return assinaturaDeDestrutor55 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes56 =null;


        RewriteRuleSubtreeStream stream_assinaturaDeDestrutor=new RewriteRuleSubtreeStream(adaptor,"rule assinaturaDeDestrutor");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        try {
            // fontes/g/CanecaArvore.g:167:2: ( assinaturaDeDestrutor blocoDeInstrucoes -> ^( DESTRUTOR_ assinaturaDeDestrutor blocoDeInstrucoes ) )
            // fontes/g/CanecaArvore.g:167:4: assinaturaDeDestrutor blocoDeInstrucoes
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assinaturaDeDestrutor_in_destrutor851);
            assinaturaDeDestrutor55=assinaturaDeDestrutor();

            state._fsp--;

            stream_assinaturaDeDestrutor.add(assinaturaDeDestrutor55.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_destrutor853);
            blocoDeInstrucoes56=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes56.getTree());

            // AST REWRITE
            // elements: assinaturaDeDestrutor, blocoDeInstrucoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 167:44: -> ^( DESTRUTOR_ assinaturaDeDestrutor blocoDeInstrucoes )
            {
                // fontes/g/CanecaArvore.g:167:47: ^( DESTRUTOR_ assinaturaDeDestrutor blocoDeInstrucoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DESTRUTOR_, "DESTRUTOR_")
                , root_1);

                adaptor.addChild(root_1, stream_assinaturaDeDestrutor.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "destrutor"


    public static class metodo_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "metodo"
    // fontes/g/CanecaArvore.g:170:1: metodo : assinaturaDeMetodo blocoDeInstrucoes -> ^( METODO_ assinaturaDeMetodo blocoDeInstrucoes ) ;
    public final CanecaArvore.metodo_return metodo() throws RecognitionException {
        CanecaArvore.metodo_return retval = new CanecaArvore.metodo_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.assinaturaDeMetodo_return assinaturaDeMetodo57 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes58 =null;


        RewriteRuleSubtreeStream stream_assinaturaDeMetodo=new RewriteRuleSubtreeStream(adaptor,"rule assinaturaDeMetodo");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        try {
            // fontes/g/CanecaArvore.g:171:2: ( assinaturaDeMetodo blocoDeInstrucoes -> ^( METODO_ assinaturaDeMetodo blocoDeInstrucoes ) )
            // fontes/g/CanecaArvore.g:171:4: assinaturaDeMetodo blocoDeInstrucoes
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assinaturaDeMetodo_in_metodo874);
            assinaturaDeMetodo57=assinaturaDeMetodo();

            state._fsp--;

            stream_assinaturaDeMetodo.add(assinaturaDeMetodo57.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_metodo876);
            blocoDeInstrucoes58=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes58.getTree());

            // AST REWRITE
            // elements: assinaturaDeMetodo, blocoDeInstrucoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 171:41: -> ^( METODO_ assinaturaDeMetodo blocoDeInstrucoes )
            {
                // fontes/g/CanecaArvore.g:171:44: ^( METODO_ assinaturaDeMetodo blocoDeInstrucoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(METODO_, "METODO_")
                , root_1);

                adaptor.addChild(root_1, stream_assinaturaDeMetodo.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metodo"


    public static class assinaturaDeConstrutor_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturaDeConstrutor"
    // fontes/g/CanecaArvore.g:174:1: assinaturaDeConstrutor : CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos -> ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos ) ;
    public final CanecaArvore.assinaturaDeConstrutor_return assinaturaDeConstrutor() throws RecognitionException {
        CanecaArvore.assinaturaDeConstrutor_return retval = new CanecaArvore.assinaturaDeConstrutor_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CONSTRUTOR59=null;
        CommonTree IDENTIFICADOR61=null;
        CanecaArvore.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino60 =null;

        CanecaArvore.listaDeArgumentos_return listaDeArgumentos62 =null;


        CommonTree CONSTRUTOR59_tree=null;
        CommonTree IDENTIFICADOR61_tree=null;
        RewriteRuleNodeStream stream_CONSTRUTOR=new RewriteRuleNodeStream(adaptor,"token CONSTRUTOR");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_modificadorDeAcessoMasculino=new RewriteRuleSubtreeStream(adaptor,"rule modificadorDeAcessoMasculino");
        RewriteRuleSubtreeStream stream_listaDeArgumentos=new RewriteRuleSubtreeStream(adaptor,"rule listaDeArgumentos");
        try {
            // fontes/g/CanecaArvore.g:175:2: ( CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos -> ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos ) )
            // fontes/g/CanecaArvore.g:175:4: CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos
            {
            _last = (CommonTree)input.LT(1);
            CONSTRUTOR59=(CommonTree)match(input,CONSTRUTOR,FOLLOW_CONSTRUTOR_in_assinaturaDeConstrutor897);  
            stream_CONSTRUTOR.add(CONSTRUTOR59);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeConstrutor899);
            modificadorDeAcessoMasculino60=modificadorDeAcessoMasculino();

            state._fsp--;

            stream_modificadorDeAcessoMasculino.add(modificadorDeAcessoMasculino60.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR61=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_assinaturaDeConstrutor901);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR61);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeArgumentos_in_assinaturaDeConstrutor903);
            listaDeArgumentos62=listaDeArgumentos();

            state._fsp--;

            stream_listaDeArgumentos.add(listaDeArgumentos62.getTree());

            // AST REWRITE
            // elements: listaDeArgumentos, modificadorDeAcessoMasculino, IDENTIFICADOR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 175:76: -> ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos )
            {
                // fontes/g/CanecaArvore.g:175:79: ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSINATURA_, "ASSINATURA_")
                , root_1);

                adaptor.addChild(root_1, stream_modificadorDeAcessoMasculino.nextTree());

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_1, stream_listaDeArgumentos.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturaDeConstrutor"


    public static class assinaturaDeDestrutor_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturaDeDestrutor"
    // fontes/g/CanecaArvore.g:178:1: assinaturaDeDestrutor : DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia -> ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia ) ;
    public final CanecaArvore.assinaturaDeDestrutor_return assinaturaDeDestrutor() throws RecognitionException {
        CanecaArvore.assinaturaDeDestrutor_return retval = new CanecaArvore.assinaturaDeDestrutor_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DESTRUTOR63=null;
        CommonTree IDENTIFICADOR65=null;
        CanecaArvore.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino64 =null;

        CanecaArvore.listaDeArgumentosVazia_return listaDeArgumentosVazia66 =null;


        CommonTree DESTRUTOR63_tree=null;
        CommonTree IDENTIFICADOR65_tree=null;
        RewriteRuleNodeStream stream_DESTRUTOR=new RewriteRuleNodeStream(adaptor,"token DESTRUTOR");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_modificadorDeAcessoMasculino=new RewriteRuleSubtreeStream(adaptor,"rule modificadorDeAcessoMasculino");
        RewriteRuleSubtreeStream stream_listaDeArgumentosVazia=new RewriteRuleSubtreeStream(adaptor,"rule listaDeArgumentosVazia");
        try {
            // fontes/g/CanecaArvore.g:179:2: ( DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia -> ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia ) )
            // fontes/g/CanecaArvore.g:179:4: DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia
            {
            _last = (CommonTree)input.LT(1);
            DESTRUTOR63=(CommonTree)match(input,DESTRUTOR,FOLLOW_DESTRUTOR_in_assinaturaDeDestrutor926);  
            stream_DESTRUTOR.add(DESTRUTOR63);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeDestrutor928);
            modificadorDeAcessoMasculino64=modificadorDeAcessoMasculino();

            state._fsp--;

            stream_modificadorDeAcessoMasculino.add(modificadorDeAcessoMasculino64.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR65=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_assinaturaDeDestrutor930);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR65);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeArgumentosVazia_in_assinaturaDeDestrutor932);
            listaDeArgumentosVazia66=listaDeArgumentosVazia();

            state._fsp--;

            stream_listaDeArgumentosVazia.add(listaDeArgumentosVazia66.getTree());

            // AST REWRITE
            // elements: listaDeArgumentosVazia, modificadorDeAcessoMasculino, IDENTIFICADOR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 179:80: -> ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia )
            {
                // fontes/g/CanecaArvore.g:179:83: ^( ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSINATURA_, "ASSINATURA_")
                , root_1);

                adaptor.addChild(root_1, stream_modificadorDeAcessoMasculino.nextTree());

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_1, stream_listaDeArgumentosVazia.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturaDeDestrutor"


    public static class assinaturaDeMetodo_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assinaturaDeMetodo"
    // fontes/g/CanecaArvore.g:182:1: assinaturaDeMetodo : METODO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos -> ^( ASSINATURA_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos ) ;
    public final CanecaArvore.assinaturaDeMetodo_return assinaturaDeMetodo() throws RecognitionException {
        CanecaArvore.assinaturaDeMetodo_return retval = new CanecaArvore.assinaturaDeMetodo_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree METODO67=null;
        CommonTree ESTATICO69=null;
        CommonTree IDENTIFICADOR71=null;
        CanecaArvore.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino68 =null;

        CanecaArvore.tipo_return tipo70 =null;

        CanecaArvore.listaDeArgumentos_return listaDeArgumentos72 =null;


        CommonTree METODO67_tree=null;
        CommonTree ESTATICO69_tree=null;
        CommonTree IDENTIFICADOR71_tree=null;
        RewriteRuleNodeStream stream_METODO=new RewriteRuleNodeStream(adaptor,"token METODO");
        RewriteRuleNodeStream stream_ESTATICO=new RewriteRuleNodeStream(adaptor,"token ESTATICO");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_modificadorDeAcessoMasculino=new RewriteRuleSubtreeStream(adaptor,"rule modificadorDeAcessoMasculino");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        RewriteRuleSubtreeStream stream_listaDeArgumentos=new RewriteRuleSubtreeStream(adaptor,"rule listaDeArgumentos");
        try {
            // fontes/g/CanecaArvore.g:183:2: ( METODO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos -> ^( ASSINATURA_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos ) )
            // fontes/g/CanecaArvore.g:183:4: METODO modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos
            {
            _last = (CommonTree)input.LT(1);
            METODO67=(CommonTree)match(input,METODO,FOLLOW_METODO_in_assinaturaDeMetodo955);  
            stream_METODO.add(METODO67);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeMetodo957);
            modificadorDeAcessoMasculino68=modificadorDeAcessoMasculino();

            state._fsp--;

            stream_modificadorDeAcessoMasculino.add(modificadorDeAcessoMasculino68.getTree());

            // fontes/g/CanecaArvore.g:183:40: ( ESTATICO )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ESTATICO) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // fontes/g/CanecaArvore.g:183:41: ESTATICO
                    {
                    _last = (CommonTree)input.LT(1);
                    ESTATICO69=(CommonTree)match(input,ESTATICO,FOLLOW_ESTATICO_in_assinaturaDeMetodo960);  
                    stream_ESTATICO.add(ESTATICO69);


                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_tipo_in_assinaturaDeMetodo964);
            tipo70=tipo();

            state._fsp--;

            stream_tipo.add(tipo70.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR71=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_assinaturaDeMetodo966);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR71);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeArgumentos_in_assinaturaDeMetodo968);
            listaDeArgumentos72=listaDeArgumentos();

            state._fsp--;

            stream_listaDeArgumentos.add(listaDeArgumentos72.getTree());

            // AST REWRITE
            // elements: IDENTIFICADOR, modificadorDeAcessoMasculino, listaDeArgumentos, ESTATICO, tipo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 183:89: -> ^( ASSINATURA_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos )
            {
                // fontes/g/CanecaArvore.g:183:92: ^( ASSINATURA_ modificadorDeAcessoMasculino ( ESTATICO )? tipo IDENTIFICADOR listaDeArgumentos )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSINATURA_, "ASSINATURA_")
                , root_1);

                adaptor.addChild(root_1, stream_modificadorDeAcessoMasculino.nextTree());

                // fontes/g/CanecaArvore.g:183:135: ( ESTATICO )?
                if ( stream_ESTATICO.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_ESTATICO.nextNode()
                    );

                }
                stream_ESTATICO.reset();

                adaptor.addChild(root_1, stream_tipo.nextTree());

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_1, stream_listaDeArgumentos.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assinaturaDeMetodo"


    public static class modificadorDeAcessoMasculino_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "modificadorDeAcessoMasculino"
    // fontes/g/CanecaArvore.g:186:1: modificadorDeAcessoMasculino : ( PUBLICO | PRIVADO | PROTEGIDO );
    public final CanecaArvore.modificadorDeAcessoMasculino_return modificadorDeAcessoMasculino() throws RecognitionException {
        CanecaArvore.modificadorDeAcessoMasculino_return retval = new CanecaArvore.modificadorDeAcessoMasculino_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set73=null;

        CommonTree set73_tree=null;

        try {
            // fontes/g/CanecaArvore.g:187:2: ( PUBLICO | PRIVADO | PROTEGIDO )
            // fontes/g/CanecaArvore.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set73=(CommonTree)input.LT(1);

            if ( input.LA(1)==PRIVADO||input.LA(1)==PROTEGIDO||input.LA(1)==PUBLICO ) {
                input.consume();
                set73_tree = (CommonTree)adaptor.dupNode(set73);


                adaptor.addChild(root_0, set73_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "modificadorDeAcessoMasculino"


    public static class modificadorDeAcessoFeminino_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "modificadorDeAcessoFeminino"
    // fontes/g/CanecaArvore.g:192:1: modificadorDeAcessoFeminino : ( PUBLICA | PRIVADA | PROTEGIDA );
    public final CanecaArvore.modificadorDeAcessoFeminino_return modificadorDeAcessoFeminino() throws RecognitionException {
        CanecaArvore.modificadorDeAcessoFeminino_return retval = new CanecaArvore.modificadorDeAcessoFeminino_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set74=null;

        CommonTree set74_tree=null;

        try {
            // fontes/g/CanecaArvore.g:193:2: ( PUBLICA | PRIVADA | PROTEGIDA )
            // fontes/g/CanecaArvore.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set74=(CommonTree)input.LT(1);

            if ( input.LA(1)==PRIVADA||input.LA(1)==PROTEGIDA||input.LA(1)==PUBLICA ) {
                input.consume();
                set74_tree = (CommonTree)adaptor.dupNode(set74);


                adaptor.addChild(root_0, set74_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "modificadorDeAcessoFeminino"


    public static class listaDeParametros_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeParametros"
    // fontes/g/CanecaArvore.g:198:1: listaDeParametros : PARENTESE_ESQUERDO ( expressao ( SEPARADOR expressao )* )? PARENTESE_DIREITO -> ^( PARAMETROS_ ( expressao )* ) ;
    public final CanecaArvore.listaDeParametros_return listaDeParametros() throws RecognitionException {
        CanecaArvore.listaDeParametros_return retval = new CanecaArvore.listaDeParametros_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARENTESE_ESQUERDO75=null;
        CommonTree SEPARADOR77=null;
        CommonTree PARENTESE_DIREITO79=null;
        CanecaArvore.expressao_return expressao76 =null;

        CanecaArvore.expressao_return expressao78 =null;


        CommonTree PARENTESE_ESQUERDO75_tree=null;
        CommonTree SEPARADOR77_tree=null;
        CommonTree PARENTESE_DIREITO79_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleNodeStream stream_SEPARADOR=new RewriteRuleNodeStream(adaptor,"token SEPARADOR");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:199:2: ( PARENTESE_ESQUERDO ( expressao ( SEPARADOR expressao )* )? PARENTESE_DIREITO -> ^( PARAMETROS_ ( expressao )* ) )
            // fontes/g/CanecaArvore.g:199:4: PARENTESE_ESQUERDO ( expressao ( SEPARADOR expressao )* )? PARENTESE_DIREITO
            {
            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO75=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_listaDeParametros1040);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO75);


            // fontes/g/CanecaArvore.g:199:23: ( expressao ( SEPARADOR expressao )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0 >= CONSTANTE_INTEIRA && LA14_0 <= CONSTANTE_REAL)||(LA14_0 >= ESSA && LA14_0 <= ESSE)||LA14_0==IDENTIFICADOR||(LA14_0 >= LITERAL_CARACTERE && LA14_0 <= LITERAL_TEXTO)||(LA14_0 >= NEGACAO && LA14_0 <= NOVO)||LA14_0==PARENTESE_ESQUERDO||LA14_0==SUBTRACAO||(LA14_0 >= VALOR_BOOLEANO && LA14_0 <= VALOR_NULO)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // fontes/g/CanecaArvore.g:199:24: expressao ( SEPARADOR expressao )*
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressao_in_listaDeParametros1043);
                    expressao76=expressao();

                    state._fsp--;

                    stream_expressao.add(expressao76.getTree());

                    // fontes/g/CanecaArvore.g:199:34: ( SEPARADOR expressao )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==SEPARADOR) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // fontes/g/CanecaArvore.g:199:35: SEPARADOR expressao
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    SEPARADOR77=(CommonTree)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeParametros1046);  
                    	    stream_SEPARADOR.add(SEPARADOR77);


                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expressao_in_listaDeParametros1048);
                    	    expressao78=expressao();

                    	    state._fsp--;

                    	    stream_expressao.add(expressao78.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO79=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_listaDeParametros1054);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO79);


            // AST REWRITE
            // elements: expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 199:77: -> ^( PARAMETROS_ ( expressao )* )
            {
                // fontes/g/CanecaArvore.g:199:80: ^( PARAMETROS_ ( expressao )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PARAMETROS_, "PARAMETROS_")
                , root_1);

                // fontes/g/CanecaArvore.g:199:94: ( expressao )*
                while ( stream_expressao.hasNext() ) {
                    adaptor.addChild(root_1, stream_expressao.nextTree());

                }
                stream_expressao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeParametros"


    public static class listaDeArgumentosVazia_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeArgumentosVazia"
    // fontes/g/CanecaArvore.g:202:1: listaDeArgumentosVazia : PARENTESE_ESQUERDO PARENTESE_DIREITO -> ^( ARGUMENTOS_ ) ;
    public final CanecaArvore.listaDeArgumentosVazia_return listaDeArgumentosVazia() throws RecognitionException {
        CanecaArvore.listaDeArgumentosVazia_return retval = new CanecaArvore.listaDeArgumentosVazia_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARENTESE_ESQUERDO80=null;
        CommonTree PARENTESE_DIREITO81=null;

        CommonTree PARENTESE_ESQUERDO80_tree=null;
        CommonTree PARENTESE_DIREITO81_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");

        try {
            // fontes/g/CanecaArvore.g:203:2: ( PARENTESE_ESQUERDO PARENTESE_DIREITO -> ^( ARGUMENTOS_ ) )
            // fontes/g/CanecaArvore.g:203:4: PARENTESE_ESQUERDO PARENTESE_DIREITO
            {
            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO80=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentosVazia1076);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO80);


            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO81=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentosVazia1078);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO81);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 203:41: -> ^( ARGUMENTOS_ )
            {
                // fontes/g/CanecaArvore.g:203:44: ^( ARGUMENTOS_ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ARGUMENTOS_, "ARGUMENTOS_")
                , root_1);

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeArgumentosVazia"


    public static class listaDeArgumentos_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeArgumentos"
    // fontes/g/CanecaArvore.g:206:1: listaDeArgumentos : PARENTESE_ESQUERDO ( declaracao ( SEPARADOR declaracao )* )? PARENTESE_DIREITO -> ^( ARGUMENTOS_ ( declaracao )* ) ;
    public final CanecaArvore.listaDeArgumentos_return listaDeArgumentos() throws RecognitionException {
        CanecaArvore.listaDeArgumentos_return retval = new CanecaArvore.listaDeArgumentos_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARENTESE_ESQUERDO82=null;
        CommonTree SEPARADOR84=null;
        CommonTree PARENTESE_DIREITO86=null;
        CanecaArvore.declaracao_return declaracao83 =null;

        CanecaArvore.declaracao_return declaracao85 =null;


        CommonTree PARENTESE_ESQUERDO82_tree=null;
        CommonTree SEPARADOR84_tree=null;
        CommonTree PARENTESE_DIREITO86_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleNodeStream stream_SEPARADOR=new RewriteRuleNodeStream(adaptor,"token SEPARADOR");
        RewriteRuleSubtreeStream stream_declaracao=new RewriteRuleSubtreeStream(adaptor,"rule declaracao");
        try {
            // fontes/g/CanecaArvore.g:207:2: ( PARENTESE_ESQUERDO ( declaracao ( SEPARADOR declaracao )* )? PARENTESE_DIREITO -> ^( ARGUMENTOS_ ( declaracao )* ) )
            // fontes/g/CanecaArvore.g:207:4: PARENTESE_ESQUERDO ( declaracao ( SEPARADOR declaracao )* )? PARENTESE_DIREITO
            {
            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO82=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentos1095);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO82);


            // fontes/g/CanecaArvore.g:207:23: ( declaracao ( SEPARADOR declaracao )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENTIFICADOR) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // fontes/g/CanecaArvore.g:207:24: declaracao ( SEPARADOR declaracao )*
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_declaracao_in_listaDeArgumentos1098);
                    declaracao83=declaracao();

                    state._fsp--;

                    stream_declaracao.add(declaracao83.getTree());

                    // fontes/g/CanecaArvore.g:207:35: ( SEPARADOR declaracao )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==SEPARADOR) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // fontes/g/CanecaArvore.g:207:36: SEPARADOR declaracao
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    SEPARADOR84=(CommonTree)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeArgumentos1101);  
                    	    stream_SEPARADOR.add(SEPARADOR84);


                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_declaracao_in_listaDeArgumentos1103);
                    	    declaracao85=declaracao();

                    	    state._fsp--;

                    	    stream_declaracao.add(declaracao85.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO86=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentos1109);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO86);


            // AST REWRITE
            // elements: declaracao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 207:79: -> ^( ARGUMENTOS_ ( declaracao )* )
            {
                // fontes/g/CanecaArvore.g:207:82: ^( ARGUMENTOS_ ( declaracao )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ARGUMENTOS_, "ARGUMENTOS_")
                , root_1);

                // fontes/g/CanecaArvore.g:207:96: ( declaracao )*
                while ( stream_declaracao.hasNext() ) {
                    adaptor.addChild(root_1, stream_declaracao.nextTree());

                }
                stream_declaracao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeArgumentos"


    public static class listaDeInterfaces_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeInterfaces"
    // fontes/g/CanecaArvore.g:210:1: listaDeInterfaces : ( IMPLEMENTA tipo ( SEPARADOR tipo )* )? -> ^( INTERFACES_ ( tipo )* ) ;
    public final CanecaArvore.listaDeInterfaces_return listaDeInterfaces() throws RecognitionException {
        CanecaArvore.listaDeInterfaces_return retval = new CanecaArvore.listaDeInterfaces_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPLEMENTA87=null;
        CommonTree SEPARADOR89=null;
        CanecaArvore.tipo_return tipo88 =null;

        CanecaArvore.tipo_return tipo90 =null;


        CommonTree IMPLEMENTA87_tree=null;
        CommonTree SEPARADOR89_tree=null;
        RewriteRuleNodeStream stream_IMPLEMENTA=new RewriteRuleNodeStream(adaptor,"token IMPLEMENTA");
        RewriteRuleNodeStream stream_SEPARADOR=new RewriteRuleNodeStream(adaptor,"token SEPARADOR");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // fontes/g/CanecaArvore.g:211:2: ( ( IMPLEMENTA tipo ( SEPARADOR tipo )* )? -> ^( INTERFACES_ ( tipo )* ) )
            // fontes/g/CanecaArvore.g:211:4: ( IMPLEMENTA tipo ( SEPARADOR tipo )* )?
            {
            // fontes/g/CanecaArvore.g:211:4: ( IMPLEMENTA tipo ( SEPARADOR tipo )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IMPLEMENTA) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // fontes/g/CanecaArvore.g:211:5: IMPLEMENTA tipo ( SEPARADOR tipo )*
                    {
                    _last = (CommonTree)input.LT(1);
                    IMPLEMENTA87=(CommonTree)match(input,IMPLEMENTA,FOLLOW_IMPLEMENTA_in_listaDeInterfaces1132);  
                    stream_IMPLEMENTA.add(IMPLEMENTA87);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tipo_in_listaDeInterfaces1134);
                    tipo88=tipo();

                    state._fsp--;

                    stream_tipo.add(tipo88.getTree());

                    // fontes/g/CanecaArvore.g:211:21: ( SEPARADOR tipo )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==SEPARADOR) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // fontes/g/CanecaArvore.g:211:22: SEPARADOR tipo
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    SEPARADOR89=(CommonTree)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeInterfaces1137);  
                    	    stream_SEPARADOR.add(SEPARADOR89);


                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_tipo_in_listaDeInterfaces1139);
                    	    tipo90=tipo();

                    	    state._fsp--;

                    	    stream_tipo.add(tipo90.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }


            // AST REWRITE
            // elements: tipo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 211:41: -> ^( INTERFACES_ ( tipo )* )
            {
                // fontes/g/CanecaArvore.g:211:44: ^( INTERFACES_ ( tipo )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(INTERFACES_, "INTERFACES_")
                , root_1);

                // fontes/g/CanecaArvore.g:211:58: ( tipo )*
                while ( stream_tipo.hasNext() ) {
                    adaptor.addChild(root_1, stream_tipo.nextTree());

                }
                stream_tipo.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeInterfaces"


    public static class listaDeTiposGenericos_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeTiposGenericos"
    // fontes/g/CanecaArvore.g:214:1: listaDeTiposGenericos : ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )* -> ^( TIPOS_GENERICOS_ ( tipoGenerico )* ) ;
    public final CanecaArvore.listaDeTiposGenericos_return listaDeTiposGenericos() throws RecognitionException {
        CanecaArvore.listaDeTiposGenericos_return retval = new CanecaArvore.listaDeTiposGenericos_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COLCHETE_ESQUERDO91=null;
        CommonTree COLCHETE_DIREITO93=null;
        CanecaArvore.tipoGenerico_return tipoGenerico92 =null;


        CommonTree COLCHETE_ESQUERDO91_tree=null;
        CommonTree COLCHETE_DIREITO93_tree=null;
        RewriteRuleNodeStream stream_COLCHETE_DIREITO=new RewriteRuleNodeStream(adaptor,"token COLCHETE_DIREITO");
        RewriteRuleNodeStream stream_COLCHETE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token COLCHETE_ESQUERDO");
        RewriteRuleSubtreeStream stream_tipoGenerico=new RewriteRuleSubtreeStream(adaptor,"rule tipoGenerico");
        try {
            // fontes/g/CanecaArvore.g:215:2: ( ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )* -> ^( TIPOS_GENERICOS_ ( tipoGenerico )* ) )
            // fontes/g/CanecaArvore.g:215:4: ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )*
            {
            // fontes/g/CanecaArvore.g:215:4: ( COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COLCHETE_ESQUERDO) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:215:5: COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    COLCHETE_ESQUERDO91=(CommonTree)match(input,COLCHETE_ESQUERDO,FOLLOW_COLCHETE_ESQUERDO_in_listaDeTiposGenericos1166);  
            	    stream_COLCHETE_ESQUERDO.add(COLCHETE_ESQUERDO91);


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_tipoGenerico_in_listaDeTiposGenericos1168);
            	    tipoGenerico92=tipoGenerico();

            	    state._fsp--;

            	    stream_tipoGenerico.add(tipoGenerico92.getTree());

            	    _last = (CommonTree)input.LT(1);
            	    COLCHETE_DIREITO93=(CommonTree)match(input,COLCHETE_DIREITO,FOLLOW_COLCHETE_DIREITO_in_listaDeTiposGenericos1170);  
            	    stream_COLCHETE_DIREITO.add(COLCHETE_DIREITO93);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            // AST REWRITE
            // elements: tipoGenerico
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 215:55: -> ^( TIPOS_GENERICOS_ ( tipoGenerico )* )
            {
                // fontes/g/CanecaArvore.g:215:58: ^( TIPOS_GENERICOS_ ( tipoGenerico )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TIPOS_GENERICOS_, "TIPOS_GENERICOS_")
                , root_1);

                // fontes/g/CanecaArvore.g:215:77: ( tipoGenerico )*
                while ( stream_tipoGenerico.hasNext() ) {
                    adaptor.addChild(root_1, stream_tipoGenerico.nextTree());

                }
                stream_tipoGenerico.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeTiposGenericos"


    public static class listaDeTipos_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeTipos"
    // fontes/g/CanecaArvore.g:218:1: listaDeTipos : ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )? -> ^( TIPOS_ ( tipo )* ) ;
    public final CanecaArvore.listaDeTipos_return listaDeTipos() throws RecognitionException {
        CanecaArvore.listaDeTipos_return retval = new CanecaArvore.listaDeTipos_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COLCHETE_ESQUERDO94=null;
        CommonTree SEPARADOR96=null;
        CommonTree COLCHETE_DIREITO98=null;
        CanecaArvore.tipo_return tipo95 =null;

        CanecaArvore.tipo_return tipo97 =null;


        CommonTree COLCHETE_ESQUERDO94_tree=null;
        CommonTree SEPARADOR96_tree=null;
        CommonTree COLCHETE_DIREITO98_tree=null;
        RewriteRuleNodeStream stream_COLCHETE_DIREITO=new RewriteRuleNodeStream(adaptor,"token COLCHETE_DIREITO");
        RewriteRuleNodeStream stream_COLCHETE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token COLCHETE_ESQUERDO");
        RewriteRuleNodeStream stream_SEPARADOR=new RewriteRuleNodeStream(adaptor,"token SEPARADOR");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // fontes/g/CanecaArvore.g:219:2: ( ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )? -> ^( TIPOS_ ( tipo )* ) )
            // fontes/g/CanecaArvore.g:219:4: ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )?
            {
            // fontes/g/CanecaArvore.g:219:4: ( COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==COLCHETE_ESQUERDO) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // fontes/g/CanecaArvore.g:219:5: COLCHETE_ESQUERDO tipo ( SEPARADOR tipo )* COLCHETE_DIREITO
                    {
                    _last = (CommonTree)input.LT(1);
                    COLCHETE_ESQUERDO94=(CommonTree)match(input,COLCHETE_ESQUERDO,FOLLOW_COLCHETE_ESQUERDO_in_listaDeTipos1195);  
                    stream_COLCHETE_ESQUERDO.add(COLCHETE_ESQUERDO94);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tipo_in_listaDeTipos1197);
                    tipo95=tipo();

                    state._fsp--;

                    stream_tipo.add(tipo95.getTree());

                    // fontes/g/CanecaArvore.g:219:28: ( SEPARADOR tipo )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==SEPARADOR) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // fontes/g/CanecaArvore.g:219:29: SEPARADOR tipo
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    SEPARADOR96=(CommonTree)match(input,SEPARADOR,FOLLOW_SEPARADOR_in_listaDeTipos1200);  
                    	    stream_SEPARADOR.add(SEPARADOR96);


                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_tipo_in_listaDeTipos1202);
                    	    tipo97=tipo();

                    	    state._fsp--;

                    	    stream_tipo.add(tipo97.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    _last = (CommonTree)input.LT(1);
                    COLCHETE_DIREITO98=(CommonTree)match(input,COLCHETE_DIREITO,FOLLOW_COLCHETE_DIREITO_in_listaDeTipos1206);  
                    stream_COLCHETE_DIREITO.add(COLCHETE_DIREITO98);


                    }
                    break;

            }


            // AST REWRITE
            // elements: tipo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 219:65: -> ^( TIPOS_ ( tipo )* )
            {
                // fontes/g/CanecaArvore.g:219:68: ^( TIPOS_ ( tipo )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TIPOS_, "TIPOS_")
                , root_1);

                // fontes/g/CanecaArvore.g:219:77: ( tipo )*
                while ( stream_tipo.hasNext() ) {
                    adaptor.addChild(root_1, stream_tipo.nextTree());

                }
                stream_tipo.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeTipos"


    public static class listaDeCapturas_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaDeCapturas"
    // fontes/g/CanecaArvore.g:222:1: listaDeCapturas : ( capture )+ -> ^( CAPTURAS_ ( capture )+ ) ;
    public final CanecaArvore.listaDeCapturas_return listaDeCapturas() throws RecognitionException {
        CanecaArvore.listaDeCapturas_return retval = new CanecaArvore.listaDeCapturas_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.capture_return capture99 =null;


        RewriteRuleSubtreeStream stream_capture=new RewriteRuleSubtreeStream(adaptor,"rule capture");
        try {
            // fontes/g/CanecaArvore.g:223:2: ( ( capture )+ -> ^( CAPTURAS_ ( capture )+ ) )
            // fontes/g/CanecaArvore.g:223:4: ( capture )+
            {
            // fontes/g/CanecaArvore.g:223:4: ( capture )+
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
            	    // fontes/g/CanecaArvore.g:223:5: capture
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_capture_in_listaDeCapturas1231);
            	    capture99=capture();

            	    state._fsp--;

            	    stream_capture.add(capture99.getTree());

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


            // AST REWRITE
            // elements: capture
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 223:15: -> ^( CAPTURAS_ ( capture )+ )
            {
                // fontes/g/CanecaArvore.g:223:18: ^( CAPTURAS_ ( capture )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CAPTURAS_, "CAPTURAS_")
                , root_1);

                if ( !(stream_capture.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_capture.hasNext() ) {
                    adaptor.addChild(root_1, stream_capture.nextTree());

                }
                stream_capture.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listaDeCapturas"


    public static class tipoGenerico_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tipoGenerico"
    // fontes/g/CanecaArvore.g:226:1: tipoGenerico : IDENTIFICADOR listaDeInterfaces -> ^( TIPO_GENERICO_ IDENTIFICADOR listaDeInterfaces ) ;
    public final CanecaArvore.tipoGenerico_return tipoGenerico() throws RecognitionException {
        CanecaArvore.tipoGenerico_return retval = new CanecaArvore.tipoGenerico_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFICADOR100=null;
        CanecaArvore.listaDeInterfaces_return listaDeInterfaces101 =null;


        CommonTree IDENTIFICADOR100_tree=null;
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_listaDeInterfaces=new RewriteRuleSubtreeStream(adaptor,"rule listaDeInterfaces");
        try {
            // fontes/g/CanecaArvore.g:227:2: ( IDENTIFICADOR listaDeInterfaces -> ^( TIPO_GENERICO_ IDENTIFICADOR listaDeInterfaces ) )
            // fontes/g/CanecaArvore.g:227:4: IDENTIFICADOR listaDeInterfaces
            {
            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR100=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_tipoGenerico1255);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR100);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeInterfaces_in_tipoGenerico1257);
            listaDeInterfaces101=listaDeInterfaces();

            state._fsp--;

            stream_listaDeInterfaces.add(listaDeInterfaces101.getTree());

            // AST REWRITE
            // elements: IDENTIFICADOR, listaDeInterfaces
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 227:36: -> ^( TIPO_GENERICO_ IDENTIFICADOR listaDeInterfaces )
            {
                // fontes/g/CanecaArvore.g:227:39: ^( TIPO_GENERICO_ IDENTIFICADOR listaDeInterfaces )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TIPO_GENERICO_, "TIPO_GENERICO_")
                , root_1);

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_1, stream_listaDeInterfaces.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tipoGenerico"


    public static class tipo_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tipo"
    // fontes/g/CanecaArvore.g:230:1: tipo : IDENTIFICADOR listaDeTipos -> ^( TIPO_ IDENTIFICADOR listaDeTipos ) ;
    public final CanecaArvore.tipo_return tipo() throws RecognitionException {
        CanecaArvore.tipo_return retval = new CanecaArvore.tipo_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFICADOR102=null;
        CanecaArvore.listaDeTipos_return listaDeTipos103 =null;


        CommonTree IDENTIFICADOR102_tree=null;
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_listaDeTipos=new RewriteRuleSubtreeStream(adaptor,"rule listaDeTipos");
        try {
            // fontes/g/CanecaArvore.g:231:2: ( IDENTIFICADOR listaDeTipos -> ^( TIPO_ IDENTIFICADOR listaDeTipos ) )
            // fontes/g/CanecaArvore.g:231:4: IDENTIFICADOR listaDeTipos
            {
            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR102=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_tipo1278);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR102);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeTipos_in_tipo1280);
            listaDeTipos103=listaDeTipos();

            state._fsp--;

            stream_listaDeTipos.add(listaDeTipos103.getTree());

            // AST REWRITE
            // elements: listaDeTipos, IDENTIFICADOR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 231:31: -> ^( TIPO_ IDENTIFICADOR listaDeTipos )
            {
                // fontes/g/CanecaArvore.g:231:34: ^( TIPO_ IDENTIFICADOR listaDeTipos )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TIPO_, "TIPO_")
                , root_1);

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_1, stream_listaDeTipos.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tipo"


    public static class declaracao_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declaracao"
    // fontes/g/CanecaArvore.g:234:1: declaracao : tipo IDENTIFICADOR -> ^( DECLARACAO_ tipo IDENTIFICADOR ) ;
    public final CanecaArvore.declaracao_return declaracao() throws RecognitionException {
        CanecaArvore.declaracao_return retval = new CanecaArvore.declaracao_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFICADOR105=null;
        CanecaArvore.tipo_return tipo104 =null;


        CommonTree IDENTIFICADOR105_tree=null;
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // fontes/g/CanecaArvore.g:235:2: ( tipo IDENTIFICADOR -> ^( DECLARACAO_ tipo IDENTIFICADOR ) )
            // fontes/g/CanecaArvore.g:235:4: tipo IDENTIFICADOR
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_tipo_in_declaracao1301);
            tipo104=tipo();

            state._fsp--;

            stream_tipo.add(tipo104.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR105=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_declaracao1303);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR105);


            // AST REWRITE
            // elements: IDENTIFICADOR, tipo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 235:23: -> ^( DECLARACAO_ tipo IDENTIFICADOR )
            {
                // fontes/g/CanecaArvore.g:235:26: ^( DECLARACAO_ tipo IDENTIFICADOR )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DECLARACAO_, "DECLARACAO_")
                , root_1);

                adaptor.addChild(root_1, stream_tipo.nextTree());

                adaptor.addChild(root_1, 
                stream_IDENTIFICADOR.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declaracao"


    public static class declaracaoComAtribuicaoOpcional_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declaracaoComAtribuicaoOpcional"
    // fontes/g/CanecaArvore.g:238:1: declaracaoComAtribuicaoOpcional : tipo IDENTIFICADOR ( -> ^( DECLARACAO_ tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( DECLARACAO_ tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) ) ;
    public final CanecaArvore.declaracaoComAtribuicaoOpcional_return declaracaoComAtribuicaoOpcional() throws RecognitionException {
        CanecaArvore.declaracaoComAtribuicaoOpcional_return retval = new CanecaArvore.declaracaoComAtribuicaoOpcional_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFICADOR107=null;
        CommonTree ATRIBUIDOR108=null;
        CanecaArvore.tipo_return tipo106 =null;

        CanecaArvore.expressaoOuLogico_return expressaoOuLogico109 =null;


        CommonTree IDENTIFICADOR107_tree=null;
        CommonTree ATRIBUIDOR108_tree=null;
        RewriteRuleNodeStream stream_ATRIBUIDOR=new RewriteRuleNodeStream(adaptor,"token ATRIBUIDOR");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_expressaoOuLogico=new RewriteRuleSubtreeStream(adaptor,"rule expressaoOuLogico");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // fontes/g/CanecaArvore.g:239:2: ( tipo IDENTIFICADOR ( -> ^( DECLARACAO_ tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( DECLARACAO_ tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) ) )
            // fontes/g/CanecaArvore.g:239:4: tipo IDENTIFICADOR ( -> ^( DECLARACAO_ tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( DECLARACAO_ tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) )
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_tipo_in_declaracaoComAtribuicaoOpcional1324);
            tipo106=tipo();

            state._fsp--;

            stream_tipo.add(tipo106.getTree());

            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR107=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_declaracaoComAtribuicaoOpcional1326);  
            stream_IDENTIFICADOR.add(IDENTIFICADOR107);


            // fontes/g/CanecaArvore.g:240:3: ( -> ^( DECLARACAO_ tipo IDENTIFICADOR ) | ATRIBUIDOR expressaoOuLogico -> ^( DECLARACAO_ tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==TERMINADOR) ) {
                alt23=1;
            }
            else if ( (LA23_0==ATRIBUIDOR) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // fontes/g/CanecaArvore.g:240:5: 
                    {
                    // AST REWRITE
                    // elements: IDENTIFICADOR, tipo
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 240:5: -> ^( DECLARACAO_ tipo IDENTIFICADOR )
                    {
                        // fontes/g/CanecaArvore.g:240:8: ^( DECLARACAO_ tipo IDENTIFICADOR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(DECLARACAO_, "DECLARACAO_")
                        , root_1);

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:241:5: ATRIBUIDOR expressaoOuLogico
                    {
                    _last = (CommonTree)input.LT(1);
                    ATRIBUIDOR108=(CommonTree)match(input,ATRIBUIDOR,FOLLOW_ATRIBUIDOR_in_declaracaoComAtribuicaoOpcional1347);  
                    stream_ATRIBUIDOR.add(ATRIBUIDOR108);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressaoOuLogico_in_declaracaoComAtribuicaoOpcional1349);
                    expressaoOuLogico109=expressaoOuLogico();

                    state._fsp--;

                    stream_expressaoOuLogico.add(expressaoOuLogico109.getTree());

                    // AST REWRITE
                    // elements: ATRIBUIDOR, tipo, IDENTIFICADOR, IDENTIFICADOR, expressaoOuLogico
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 241:34: -> ^( DECLARACAO_ tipo IDENTIFICADOR ) ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico )
                    {
                        // fontes/g/CanecaArvore.g:241:37: ^( DECLARACAO_ tipo IDENTIFICADOR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(DECLARACAO_, "DECLARACAO_")
                        , root_1);

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                        // fontes/g/CanecaArvore.g:241:71: ^( ATRIBUIDOR ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) ) expressaoOuLogico )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_ATRIBUIDOR.nextNode()
                        , root_1);

                        // fontes/g/CanecaArvore.g:241:84: ^( PRIMARIA_ ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(PRIMARIA_, "PRIMARIA_")
                        , root_2);

                        // fontes/g/CanecaArvore.g:241:96: ^( COMANDO_ ^( REFERENCIA_ IDENTIFICADOR ) )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(COMANDO_, "COMANDO_")
                        , root_3);

                        // fontes/g/CanecaArvore.g:241:107: ^( REFERENCIA_ IDENTIFICADOR )
                        {
                        CommonTree root_4 = (CommonTree)adaptor.nil();
                        root_4 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(REFERENCIA_, "REFERENCIA_")
                        , root_4);

                        adaptor.addChild(root_4, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        adaptor.addChild(root_3, root_4);
                        }

                        adaptor.addChild(root_2, root_3);
                        }

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, stream_expressaoOuLogico.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declaracaoComAtribuicaoOpcional"


    public static class expressao_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressao"
    // fontes/g/CanecaArvore.g:245:1: expressao : expressaoOuLogico ( ATRIBUIDOR ^ expressaoOuLogico )? ;
    public final CanecaArvore.expressao_return expressao() throws RecognitionException {
        CanecaArvore.expressao_return retval = new CanecaArvore.expressao_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ATRIBUIDOR111=null;
        CanecaArvore.expressaoOuLogico_return expressaoOuLogico110 =null;

        CanecaArvore.expressaoOuLogico_return expressaoOuLogico112 =null;


        CommonTree ATRIBUIDOR111_tree=null;

        try {
            // fontes/g/CanecaArvore.g:246:2: ( expressaoOuLogico ( ATRIBUIDOR ^ expressaoOuLogico )? )
            // fontes/g/CanecaArvore.g:246:4: expressaoOuLogico ( ATRIBUIDOR ^ expressaoOuLogico )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressaoOuLogico_in_expressao1394);
            expressaoOuLogico110=expressaoOuLogico();

            state._fsp--;

            adaptor.addChild(root_0, expressaoOuLogico110.getTree());


            // fontes/g/CanecaArvore.g:246:22: ( ATRIBUIDOR ^ expressaoOuLogico )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ATRIBUIDOR) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // fontes/g/CanecaArvore.g:246:23: ATRIBUIDOR ^ expressaoOuLogico
                    {
                    _last = (CommonTree)input.LT(1);
                    ATRIBUIDOR111=(CommonTree)match(input,ATRIBUIDOR,FOLLOW_ATRIBUIDOR_in_expressao1397); 
                    ATRIBUIDOR111_tree = (CommonTree)adaptor.dupNode(ATRIBUIDOR111);


                    root_0 = (CommonTree)adaptor.becomeRoot(ATRIBUIDOR111_tree, root_0);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressaoOuLogico_in_expressao1400);
                    expressaoOuLogico112=expressaoOuLogico();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoOuLogico112.getTree());


                    }
                    break;

            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressao"


    public static class expressaoOuLogico_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoOuLogico"
    // fontes/g/CanecaArvore.g:249:1: expressaoOuLogico : expressaoELogico ( OU ^ expressaoELogico )* ;
    public final CanecaArvore.expressaoOuLogico_return expressaoOuLogico() throws RecognitionException {
        CanecaArvore.expressaoOuLogico_return retval = new CanecaArvore.expressaoOuLogico_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OU114=null;
        CanecaArvore.expressaoELogico_return expressaoELogico113 =null;

        CanecaArvore.expressaoELogico_return expressaoELogico115 =null;


        CommonTree OU114_tree=null;

        try {
            // fontes/g/CanecaArvore.g:250:2: ( expressaoELogico ( OU ^ expressaoELogico )* )
            // fontes/g/CanecaArvore.g:250:4: expressaoELogico ( OU ^ expressaoELogico )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressaoELogico_in_expressaoOuLogico1413);
            expressaoELogico113=expressaoELogico();

            state._fsp--;

            adaptor.addChild(root_0, expressaoELogico113.getTree());


            // fontes/g/CanecaArvore.g:250:21: ( OU ^ expressaoELogico )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==OU) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:250:22: OU ^ expressaoELogico
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    OU114=(CommonTree)match(input,OU,FOLLOW_OU_in_expressaoOuLogico1416); 
            	    OU114_tree = (CommonTree)adaptor.dupNode(OU114);


            	    root_0 = (CommonTree)adaptor.becomeRoot(OU114_tree, root_0);


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expressaoELogico_in_expressaoOuLogico1419);
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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoOuLogico"


    public static class expressaoELogico_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoELogico"
    // fontes/g/CanecaArvore.g:253:1: expressaoELogico : expressaoComparacaoLogica ( E ^ expressaoComparacaoLogica )* ;
    public final CanecaArvore.expressaoELogico_return expressaoELogico() throws RecognitionException {
        CanecaArvore.expressaoELogico_return retval = new CanecaArvore.expressaoELogico_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree E117=null;
        CanecaArvore.expressaoComparacaoLogica_return expressaoComparacaoLogica116 =null;

        CanecaArvore.expressaoComparacaoLogica_return expressaoComparacaoLogica118 =null;


        CommonTree E117_tree=null;

        try {
            // fontes/g/CanecaArvore.g:254:2: ( expressaoComparacaoLogica ( E ^ expressaoComparacaoLogica )* )
            // fontes/g/CanecaArvore.g:254:4: expressaoComparacaoLogica ( E ^ expressaoComparacaoLogica )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressaoComparacaoLogica_in_expressaoELogico1432);
            expressaoComparacaoLogica116=expressaoComparacaoLogica();

            state._fsp--;

            adaptor.addChild(root_0, expressaoComparacaoLogica116.getTree());


            // fontes/g/CanecaArvore.g:254:30: ( E ^ expressaoComparacaoLogica )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==E) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:254:31: E ^ expressaoComparacaoLogica
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    E117=(CommonTree)match(input,E,FOLLOW_E_in_expressaoELogico1435); 
            	    E117_tree = (CommonTree)adaptor.dupNode(E117);


            	    root_0 = (CommonTree)adaptor.becomeRoot(E117_tree, root_0);


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expressaoComparacaoLogica_in_expressaoELogico1438);
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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoELogico"


    public static class expressaoComparacaoLogica_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoComparacaoLogica"
    // fontes/g/CanecaArvore.g:257:1: expressaoComparacaoLogica : expressaoAditiva ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) ^ expressaoAditiva )? ;
    public final CanecaArvore.expressaoComparacaoLogica_return expressaoComparacaoLogica() throws RecognitionException {
        CanecaArvore.expressaoComparacaoLogica_return retval = new CanecaArvore.expressaoComparacaoLogica_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set120=null;
        CanecaArvore.expressaoAditiva_return expressaoAditiva119 =null;

        CanecaArvore.expressaoAditiva_return expressaoAditiva121 =null;


        CommonTree set120_tree=null;

        try {
            // fontes/g/CanecaArvore.g:258:2: ( expressaoAditiva ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) ^ expressaoAditiva )? )
            // fontes/g/CanecaArvore.g:258:4: expressaoAditiva ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) ^ expressaoAditiva )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica1451);
            expressaoAditiva119=expressaoAditiva();

            state._fsp--;

            adaptor.addChild(root_0, expressaoAditiva119.getTree());


            // fontes/g/CanecaArvore.g:258:21: ( ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) ^ expressaoAditiva )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==DIFERENTE||LA27_0==IGUAL||(LA27_0 >= MAIOR && LA27_0 <= MENOR_IGUAL)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // fontes/g/CanecaArvore.g:258:22: ( IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL ) ^ expressaoAditiva
                    {
                    set120=(CommonTree)input.LT(1);

                    if ( input.LA(1)==DIFERENTE||input.LA(1)==IGUAL||(input.LA(1) >= MAIOR && input.LA(1) <= MENOR_IGUAL) ) {
                        input.consume();
                        set120_tree = (CommonTree)adaptor.dupNode(set120);


                        root_0 = (CommonTree)adaptor.becomeRoot(set120_tree, root_0);

                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica1479);
                    expressaoAditiva121=expressaoAditiva();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoAditiva121.getTree());


                    }
                    break;

            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoComparacaoLogica"


    public static class expressaoAditiva_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoAditiva"
    // fontes/g/CanecaArvore.g:261:1: expressaoAditiva : expressaoMultiplicativa ( ( SOMA | SUBTRACAO ) ^ expressaoMultiplicativa )* ;
    public final CanecaArvore.expressaoAditiva_return expressaoAditiva() throws RecognitionException {
        CanecaArvore.expressaoAditiva_return retval = new CanecaArvore.expressaoAditiva_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set123=null;
        CanecaArvore.expressaoMultiplicativa_return expressaoMultiplicativa122 =null;

        CanecaArvore.expressaoMultiplicativa_return expressaoMultiplicativa124 =null;


        CommonTree set123_tree=null;

        try {
            // fontes/g/CanecaArvore.g:262:2: ( expressaoMultiplicativa ( ( SOMA | SUBTRACAO ) ^ expressaoMultiplicativa )* )
            // fontes/g/CanecaArvore.g:262:4: expressaoMultiplicativa ( ( SOMA | SUBTRACAO ) ^ expressaoMultiplicativa )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressaoMultiplicativa_in_expressaoAditiva1492);
            expressaoMultiplicativa122=expressaoMultiplicativa();

            state._fsp--;

            adaptor.addChild(root_0, expressaoMultiplicativa122.getTree());


            // fontes/g/CanecaArvore.g:262:28: ( ( SOMA | SUBTRACAO ) ^ expressaoMultiplicativa )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0 >= SOMA && LA28_0 <= SUBTRACAO)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:262:29: ( SOMA | SUBTRACAO ) ^ expressaoMultiplicativa
            	    {
            	    set123=(CommonTree)input.LT(1);

            	    if ( (input.LA(1) >= SOMA && input.LA(1) <= SUBTRACAO) ) {
            	        input.consume();
            	        set123_tree = (CommonTree)adaptor.dupNode(set123);


            	        root_0 = (CommonTree)adaptor.becomeRoot(set123_tree, root_0);

            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expressaoMultiplicativa_in_expressaoAditiva1504);
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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoAditiva"


    public static class expressaoMultiplicativa_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoMultiplicativa"
    // fontes/g/CanecaArvore.g:265:1: expressaoMultiplicativa : expressaoUnaria ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) ^ expressaoUnaria )* ;
    public final CanecaArvore.expressaoMultiplicativa_return expressaoMultiplicativa() throws RecognitionException {
        CanecaArvore.expressaoMultiplicativa_return retval = new CanecaArvore.expressaoMultiplicativa_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set126=null;
        CanecaArvore.expressaoUnaria_return expressaoUnaria125 =null;

        CanecaArvore.expressaoUnaria_return expressaoUnaria127 =null;


        CommonTree set126_tree=null;

        try {
            // fontes/g/CanecaArvore.g:266:2: ( expressaoUnaria ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) ^ expressaoUnaria )* )
            // fontes/g/CanecaArvore.g:266:4: expressaoUnaria ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) ^ expressaoUnaria )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressaoUnaria_in_expressaoMultiplicativa1517);
            expressaoUnaria125=expressaoUnaria();

            state._fsp--;

            adaptor.addChild(root_0, expressaoUnaria125.getTree());


            // fontes/g/CanecaArvore.g:266:20: ( ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) ^ expressaoUnaria )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==DIVISAO||LA29_0==MULTIPLICACAO||LA29_0==RESTO_DA_DIVISAO) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:266:21: ( MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO ) ^ expressaoUnaria
            	    {
            	    set126=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DIVISAO||input.LA(1)==MULTIPLICACAO||input.LA(1)==RESTO_DA_DIVISAO ) {
            	        input.consume();
            	        set126_tree = (CommonTree)adaptor.dupNode(set126);


            	        root_0 = (CommonTree)adaptor.becomeRoot(set126_tree, root_0);

            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expressaoUnaria_in_expressaoMultiplicativa1533);
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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoMultiplicativa"


    public static class expressaoUnaria_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoUnaria"
    // fontes/g/CanecaArvore.g:269:1: expressaoUnaria : ( expressaoPrimaria | SUBTRACAO expressaoPrimaria -> ^( NEGATIVACAO_ expressaoPrimaria ) | NEGACAO expressaoPrimaria -> ^( NEGACAO expressaoPrimaria ) );
    public final CanecaArvore.expressaoUnaria_return expressaoUnaria() throws RecognitionException {
        CanecaArvore.expressaoUnaria_return retval = new CanecaArvore.expressaoUnaria_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SUBTRACAO129=null;
        CommonTree NEGACAO131=null;
        CanecaArvore.expressaoPrimaria_return expressaoPrimaria128 =null;

        CanecaArvore.expressaoPrimaria_return expressaoPrimaria130 =null;

        CanecaArvore.expressaoPrimaria_return expressaoPrimaria132 =null;


        CommonTree SUBTRACAO129_tree=null;
        CommonTree NEGACAO131_tree=null;
        RewriteRuleNodeStream stream_NEGACAO=new RewriteRuleNodeStream(adaptor,"token NEGACAO");
        RewriteRuleNodeStream stream_SUBTRACAO=new RewriteRuleNodeStream(adaptor,"token SUBTRACAO");
        RewriteRuleSubtreeStream stream_expressaoPrimaria=new RewriteRuleSubtreeStream(adaptor,"rule expressaoPrimaria");
        try {
            // fontes/g/CanecaArvore.g:270:2: ( expressaoPrimaria | SUBTRACAO expressaoPrimaria -> ^( NEGATIVACAO_ expressaoPrimaria ) | NEGACAO expressaoPrimaria -> ^( NEGACAO expressaoPrimaria ) )
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
                    // fontes/g/CanecaArvore.g:270:4: expressaoPrimaria
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressaoPrimaria_in_expressaoUnaria1546);
                    expressaoPrimaria128=expressaoPrimaria();

                    state._fsp--;

                    adaptor.addChild(root_0, expressaoPrimaria128.getTree());


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:271:4: SUBTRACAO expressaoPrimaria
                    {
                    _last = (CommonTree)input.LT(1);
                    SUBTRACAO129=(CommonTree)match(input,SUBTRACAO,FOLLOW_SUBTRACAO_in_expressaoUnaria1551);  
                    stream_SUBTRACAO.add(SUBTRACAO129);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressaoPrimaria_in_expressaoUnaria1553);
                    expressaoPrimaria130=expressaoPrimaria();

                    state._fsp--;

                    stream_expressaoPrimaria.add(expressaoPrimaria130.getTree());

                    // AST REWRITE
                    // elements: expressaoPrimaria
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 271:32: -> ^( NEGATIVACAO_ expressaoPrimaria )
                    {
                        // fontes/g/CanecaArvore.g:271:35: ^( NEGATIVACAO_ expressaoPrimaria )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(NEGATIVACAO_, "NEGATIVACAO_")
                        , root_1);

                        adaptor.addChild(root_1, stream_expressaoPrimaria.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // fontes/g/CanecaArvore.g:272:4: NEGACAO expressaoPrimaria
                    {
                    _last = (CommonTree)input.LT(1);
                    NEGACAO131=(CommonTree)match(input,NEGACAO,FOLLOW_NEGACAO_in_expressaoUnaria1566);  
                    stream_NEGACAO.add(NEGACAO131);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressaoPrimaria_in_expressaoUnaria1568);
                    expressaoPrimaria132=expressaoPrimaria();

                    state._fsp--;

                    stream_expressaoPrimaria.add(expressaoPrimaria132.getTree());

                    // AST REWRITE
                    // elements: expressaoPrimaria, NEGACAO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 272:30: -> ^( NEGACAO expressaoPrimaria )
                    {
                        // fontes/g/CanecaArvore.g:272:33: ^( NEGACAO expressaoPrimaria )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_NEGACAO.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_expressaoPrimaria.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoUnaria"


    public static class expressaoPrimaria_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressaoPrimaria"
    // fontes/g/CanecaArvore.g:275:1: expressaoPrimaria : ( PARENTESE_ESQUERDO expressao PARENTESE_DIREITO -> expressao | VALOR_BOOLEANO | VALOR_NULO | CONSTANTE_INTEIRA | CONSTANTE_REAL | LITERAL_CARACTERE | LITERAL_TEXTO | comando );
    public final CanecaArvore.expressaoPrimaria_return expressaoPrimaria() throws RecognitionException {
        CanecaArvore.expressaoPrimaria_return retval = new CanecaArvore.expressaoPrimaria_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARENTESE_ESQUERDO133=null;
        CommonTree PARENTESE_DIREITO135=null;
        CommonTree VALOR_BOOLEANO136=null;
        CommonTree VALOR_NULO137=null;
        CommonTree CONSTANTE_INTEIRA138=null;
        CommonTree CONSTANTE_REAL139=null;
        CommonTree LITERAL_CARACTERE140=null;
        CommonTree LITERAL_TEXTO141=null;
        CanecaArvore.expressao_return expressao134 =null;

        CanecaArvore.comando_return comando142 =null;


        CommonTree PARENTESE_ESQUERDO133_tree=null;
        CommonTree PARENTESE_DIREITO135_tree=null;
        CommonTree VALOR_BOOLEANO136_tree=null;
        CommonTree VALOR_NULO137_tree=null;
        CommonTree CONSTANTE_INTEIRA138_tree=null;
        CommonTree CONSTANTE_REAL139_tree=null;
        CommonTree LITERAL_CARACTERE140_tree=null;
        CommonTree LITERAL_TEXTO141_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:276:2: ( PARENTESE_ESQUERDO expressao PARENTESE_DIREITO -> expressao | VALOR_BOOLEANO | VALOR_NULO | CONSTANTE_INTEIRA | CONSTANTE_REAL | LITERAL_CARACTERE | LITERAL_TEXTO | comando )
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
                    // fontes/g/CanecaArvore.g:276:4: PARENTESE_ESQUERDO expressao PARENTESE_DIREITO
                    {
                    _last = (CommonTree)input.LT(1);
                    PARENTESE_ESQUERDO133=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_expressaoPrimaria1587);  
                    stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO133);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expressao_in_expressaoPrimaria1589);
                    expressao134=expressao();

                    state._fsp--;

                    stream_expressao.add(expressao134.getTree());

                    _last = (CommonTree)input.LT(1);
                    PARENTESE_DIREITO135=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_expressaoPrimaria1591);  
                    stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO135);


                    // AST REWRITE
                    // elements: expressao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 276:51: -> expressao
                    {
                        adaptor.addChild(root_0, stream_expressao.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:277:4: VALOR_BOOLEANO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    VALOR_BOOLEANO136=(CommonTree)match(input,VALOR_BOOLEANO,FOLLOW_VALOR_BOOLEANO_in_expressaoPrimaria1600); 
                    VALOR_BOOLEANO136_tree = (CommonTree)adaptor.dupNode(VALOR_BOOLEANO136);


                    adaptor.addChild(root_0, VALOR_BOOLEANO136_tree);


                    }
                    break;
                case 3 :
                    // fontes/g/CanecaArvore.g:278:4: VALOR_NULO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    VALOR_NULO137=(CommonTree)match(input,VALOR_NULO,FOLLOW_VALOR_NULO_in_expressaoPrimaria1605); 
                    VALOR_NULO137_tree = (CommonTree)adaptor.dupNode(VALOR_NULO137);


                    adaptor.addChild(root_0, VALOR_NULO137_tree);


                    }
                    break;
                case 4 :
                    // fontes/g/CanecaArvore.g:279:4: CONSTANTE_INTEIRA
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CONSTANTE_INTEIRA138=(CommonTree)match(input,CONSTANTE_INTEIRA,FOLLOW_CONSTANTE_INTEIRA_in_expressaoPrimaria1610); 
                    CONSTANTE_INTEIRA138_tree = (CommonTree)adaptor.dupNode(CONSTANTE_INTEIRA138);


                    adaptor.addChild(root_0, CONSTANTE_INTEIRA138_tree);


                    }
                    break;
                case 5 :
                    // fontes/g/CanecaArvore.g:280:4: CONSTANTE_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CONSTANTE_REAL139=(CommonTree)match(input,CONSTANTE_REAL,FOLLOW_CONSTANTE_REAL_in_expressaoPrimaria1615); 
                    CONSTANTE_REAL139_tree = (CommonTree)adaptor.dupNode(CONSTANTE_REAL139);


                    adaptor.addChild(root_0, CONSTANTE_REAL139_tree);


                    }
                    break;
                case 6 :
                    // fontes/g/CanecaArvore.g:281:4: LITERAL_CARACTERE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LITERAL_CARACTERE140=(CommonTree)match(input,LITERAL_CARACTERE,FOLLOW_LITERAL_CARACTERE_in_expressaoPrimaria1620); 
                    LITERAL_CARACTERE140_tree = (CommonTree)adaptor.dupNode(LITERAL_CARACTERE140);


                    adaptor.addChild(root_0, LITERAL_CARACTERE140_tree);


                    }
                    break;
                case 7 :
                    // fontes/g/CanecaArvore.g:282:4: LITERAL_TEXTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LITERAL_TEXTO141=(CommonTree)match(input,LITERAL_TEXTO,FOLLOW_LITERAL_TEXTO_in_expressaoPrimaria1625); 
                    LITERAL_TEXTO141_tree = (CommonTree)adaptor.dupNode(LITERAL_TEXTO141);


                    adaptor.addChild(root_0, LITERAL_TEXTO141_tree);


                    }
                    break;
                case 8 :
                    // fontes/g/CanecaArvore.g:283:4: comando
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comando_in_expressaoPrimaria1630);
                    comando142=comando();

                    state._fsp--;

                    adaptor.addChild(root_0, comando142.getTree());


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressaoPrimaria"


    public static class comando_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comando"
    // fontes/g/CanecaArvore.g:286:1: comando : referencia ( chamada )* -> ^( COMANDO_ referencia ( chamada )* ) ;
    public final CanecaArvore.comando_return comando() throws RecognitionException {
        CanecaArvore.comando_return retval = new CanecaArvore.comando_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CanecaArvore.referencia_return referencia143 =null;

        CanecaArvore.chamada_return chamada144 =null;


        RewriteRuleSubtreeStream stream_chamada=new RewriteRuleSubtreeStream(adaptor,"rule chamada");
        RewriteRuleSubtreeStream stream_referencia=new RewriteRuleSubtreeStream(adaptor,"rule referencia");
        try {
            // fontes/g/CanecaArvore.g:287:2: ( referencia ( chamada )* -> ^( COMANDO_ referencia ( chamada )* ) )
            // fontes/g/CanecaArvore.g:287:4: referencia ( chamada )*
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_referencia_in_comando1641);
            referencia143=referencia();

            state._fsp--;

            stream_referencia.add(referencia143.getTree());

            // fontes/g/CanecaArvore.g:287:15: ( chamada )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0 >= CHAMADA_DE_CLASSE && LA32_0 <= CHAMADA_DE_OBJETO)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:287:16: chamada
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_chamada_in_comando1644);
            	    chamada144=chamada();

            	    state._fsp--;

            	    stream_chamada.add(chamada144.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            // AST REWRITE
            // elements: referencia, chamada
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 287:26: -> ^( COMANDO_ referencia ( chamada )* )
            {
                // fontes/g/CanecaArvore.g:287:29: ^( COMANDO_ referencia ( chamada )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMANDO_, "COMANDO_")
                , root_1);

                adaptor.addChild(root_1, stream_referencia.nextTree());

                // fontes/g/CanecaArvore.g:287:51: ( chamada )*
                while ( stream_chamada.hasNext() ) {
                    adaptor.addChild(root_1, stream_chamada.nextTree());

                }
                stream_chamada.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comando"


    public static class referencia_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "referencia"
    // fontes/g/CanecaArvore.g:290:1: referencia : ( ESSE -> ^( REFERENCIA_ ESSE ) | ESSA -> ^( REFERENCIA_ ESSA ) | instanciacao -> ^( REFERENCIA_ instanciacao ) | IDENTIFICADOR ( listaDeParametros )? -> ^( REFERENCIA_ IDENTIFICADOR ( listaDeParametros )? ) );
    public final CanecaArvore.referencia_return referencia() throws RecognitionException {
        CanecaArvore.referencia_return retval = new CanecaArvore.referencia_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ESSE145=null;
        CommonTree ESSA146=null;
        CommonTree IDENTIFICADOR148=null;
        CanecaArvore.instanciacao_return instanciacao147 =null;

        CanecaArvore.listaDeParametros_return listaDeParametros149 =null;


        CommonTree ESSE145_tree=null;
        CommonTree ESSA146_tree=null;
        CommonTree IDENTIFICADOR148_tree=null;
        RewriteRuleNodeStream stream_ESSE=new RewriteRuleNodeStream(adaptor,"token ESSE");
        RewriteRuleNodeStream stream_ESSA=new RewriteRuleNodeStream(adaptor,"token ESSA");
        RewriteRuleNodeStream stream_IDENTIFICADOR=new RewriteRuleNodeStream(adaptor,"token IDENTIFICADOR");
        RewriteRuleSubtreeStream stream_listaDeParametros=new RewriteRuleSubtreeStream(adaptor,"rule listaDeParametros");
        RewriteRuleSubtreeStream stream_instanciacao=new RewriteRuleSubtreeStream(adaptor,"rule instanciacao");
        try {
            // fontes/g/CanecaArvore.g:291:2: ( ESSE -> ^( REFERENCIA_ ESSE ) | ESSA -> ^( REFERENCIA_ ESSA ) | instanciacao -> ^( REFERENCIA_ instanciacao ) | IDENTIFICADOR ( listaDeParametros )? -> ^( REFERENCIA_ IDENTIFICADOR ( listaDeParametros )? ) )
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
                    // fontes/g/CanecaArvore.g:291:4: ESSE
                    {
                    _last = (CommonTree)input.LT(1);
                    ESSE145=(CommonTree)match(input,ESSE,FOLLOW_ESSE_in_referencia1670);  
                    stream_ESSE.add(ESSE145);


                    // AST REWRITE
                    // elements: ESSE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 291:9: -> ^( REFERENCIA_ ESSE )
                    {
                        // fontes/g/CanecaArvore.g:291:12: ^( REFERENCIA_ ESSE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(REFERENCIA_, "REFERENCIA_")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_ESSE.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:292:4: ESSA
                    {
                    _last = (CommonTree)input.LT(1);
                    ESSA146=(CommonTree)match(input,ESSA,FOLLOW_ESSA_in_referencia1683);  
                    stream_ESSA.add(ESSA146);


                    // AST REWRITE
                    // elements: ESSA
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 292:9: -> ^( REFERENCIA_ ESSA )
                    {
                        // fontes/g/CanecaArvore.g:292:12: ^( REFERENCIA_ ESSA )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(REFERENCIA_, "REFERENCIA_")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_ESSA.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // fontes/g/CanecaArvore.g:293:4: instanciacao
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_instanciacao_in_referencia1696);
                    instanciacao147=instanciacao();

                    state._fsp--;

                    stream_instanciacao.add(instanciacao147.getTree());

                    // AST REWRITE
                    // elements: instanciacao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 293:17: -> ^( REFERENCIA_ instanciacao )
                    {
                        // fontes/g/CanecaArvore.g:293:20: ^( REFERENCIA_ instanciacao )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(REFERENCIA_, "REFERENCIA_")
                        , root_1);

                        adaptor.addChild(root_1, stream_instanciacao.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 4 :
                    // fontes/g/CanecaArvore.g:294:4: IDENTIFICADOR ( listaDeParametros )?
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFICADOR148=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_referencia1709);  
                    stream_IDENTIFICADOR.add(IDENTIFICADOR148);


                    // fontes/g/CanecaArvore.g:294:18: ( listaDeParametros )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==PARENTESE_ESQUERDO) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // fontes/g/CanecaArvore.g:294:19: listaDeParametros
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_listaDeParametros_in_referencia1712);
                            listaDeParametros149=listaDeParametros();

                            state._fsp--;

                            stream_listaDeParametros.add(listaDeParametros149.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: IDENTIFICADOR, listaDeParametros
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 294:39: -> ^( REFERENCIA_ IDENTIFICADOR ( listaDeParametros )? )
                    {
                        // fontes/g/CanecaArvore.g:294:42: ^( REFERENCIA_ IDENTIFICADOR ( listaDeParametros )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(REFERENCIA_, "REFERENCIA_")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFICADOR.nextNode()
                        );

                        // fontes/g/CanecaArvore.g:294:70: ( listaDeParametros )?
                        if ( stream_listaDeParametros.hasNext() ) {
                            adaptor.addChild(root_1, stream_listaDeParametros.nextTree());

                        }
                        stream_listaDeParametros.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "referencia"


    public static class chamada_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chamada"
    // fontes/g/CanecaArvore.g:297:1: chamada : ( CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO ) ^ IDENTIFICADOR ( listaDeParametros )? ;
    public final CanecaArvore.chamada_return chamada() throws RecognitionException {
        CanecaArvore.chamada_return retval = new CanecaArvore.chamada_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set150=null;
        CommonTree IDENTIFICADOR151=null;
        CanecaArvore.listaDeParametros_return listaDeParametros152 =null;


        CommonTree set150_tree=null;
        CommonTree IDENTIFICADOR151_tree=null;

        try {
            // fontes/g/CanecaArvore.g:298:2: ( ( CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO ) ^ IDENTIFICADOR ( listaDeParametros )? )
            // fontes/g/CanecaArvore.g:298:4: ( CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO ) ^ IDENTIFICADOR ( listaDeParametros )?
            {
            root_0 = (CommonTree)adaptor.nil();


            set150=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= CHAMADA_DE_CLASSE && input.LA(1) <= CHAMADA_DE_OBJETO) ) {
                input.consume();
                set150_tree = (CommonTree)adaptor.dupNode(set150);


                root_0 = (CommonTree)adaptor.becomeRoot(set150_tree, root_0);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            _last = (CommonTree)input.LT(1);
            IDENTIFICADOR151=(CommonTree)match(input,IDENTIFICADOR,FOLLOW_IDENTIFICADOR_in_chamada1747); 
            IDENTIFICADOR151_tree = (CommonTree)adaptor.dupNode(IDENTIFICADOR151);


            adaptor.addChild(root_0, IDENTIFICADOR151_tree);


            // fontes/g/CanecaArvore.g:298:59: ( listaDeParametros )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==PARENTESE_ESQUERDO) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // fontes/g/CanecaArvore.g:298:60: listaDeParametros
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_listaDeParametros_in_chamada1750);
                    listaDeParametros152=listaDeParametros();

                    state._fsp--;

                    adaptor.addChild(root_0, listaDeParametros152.getTree());


                    }
                    break;

            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "chamada"


    public static class instanciacao_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instanciacao"
    // fontes/g/CanecaArvore.g:301:1: instanciacao : ( NOVO | NOVA ) tipo listaDeParametros -> ^( INSTANCIACAO_ tipo listaDeParametros ) ;
    public final CanecaArvore.instanciacao_return instanciacao() throws RecognitionException {
        CanecaArvore.instanciacao_return retval = new CanecaArvore.instanciacao_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NOVO153=null;
        CommonTree NOVA154=null;
        CanecaArvore.tipo_return tipo155 =null;

        CanecaArvore.listaDeParametros_return listaDeParametros156 =null;


        CommonTree NOVO153_tree=null;
        CommonTree NOVA154_tree=null;
        RewriteRuleNodeStream stream_NOVO=new RewriteRuleNodeStream(adaptor,"token NOVO");
        RewriteRuleNodeStream stream_NOVA=new RewriteRuleNodeStream(adaptor,"token NOVA");
        RewriteRuleSubtreeStream stream_listaDeParametros=new RewriteRuleSubtreeStream(adaptor,"rule listaDeParametros");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // fontes/g/CanecaArvore.g:302:2: ( ( NOVO | NOVA ) tipo listaDeParametros -> ^( INSTANCIACAO_ tipo listaDeParametros ) )
            // fontes/g/CanecaArvore.g:302:4: ( NOVO | NOVA ) tipo listaDeParametros
            {
            // fontes/g/CanecaArvore.g:302:4: ( NOVO | NOVA )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==NOVO) ) {
                alt36=1;
            }
            else if ( (LA36_0==NOVA) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // fontes/g/CanecaArvore.g:302:5: NOVO
                    {
                    _last = (CommonTree)input.LT(1);
                    NOVO153=(CommonTree)match(input,NOVO,FOLLOW_NOVO_in_instanciacao1764);  
                    stream_NOVO.add(NOVO153);


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:302:12: NOVA
                    {
                    _last = (CommonTree)input.LT(1);
                    NOVA154=(CommonTree)match(input,NOVA,FOLLOW_NOVA_in_instanciacao1768);  
                    stream_NOVA.add(NOVA154);


                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_tipo_in_instanciacao1771);
            tipo155=tipo();

            state._fsp--;

            stream_tipo.add(tipo155.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeParametros_in_instanciacao1773);
            listaDeParametros156=listaDeParametros();

            state._fsp--;

            stream_listaDeParametros.add(listaDeParametros156.getTree());

            // AST REWRITE
            // elements: listaDeParametros, tipo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 302:41: -> ^( INSTANCIACAO_ tipo listaDeParametros )
            {
                // fontes/g/CanecaArvore.g:302:44: ^( INSTANCIACAO_ tipo listaDeParametros )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(INSTANCIACAO_, "INSTANCIACAO_")
                , root_1);

                adaptor.addChild(root_1, stream_tipo.nextTree());

                adaptor.addChild(root_1, stream_listaDeParametros.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instanciacao"


    public static class destruicao_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "destruicao"
    // fontes/g/CanecaArvore.g:305:1: destruicao : DESTRUA expressao -> ^( DESTRUICAO_ expressao ) ;
    public final CanecaArvore.destruicao_return destruicao() throws RecognitionException {
        CanecaArvore.destruicao_return retval = new CanecaArvore.destruicao_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DESTRUA157=null;
        CanecaArvore.expressao_return expressao158 =null;


        CommonTree DESTRUA157_tree=null;
        RewriteRuleNodeStream stream_DESTRUA=new RewriteRuleNodeStream(adaptor,"token DESTRUA");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:306:2: ( DESTRUA expressao -> ^( DESTRUICAO_ expressao ) )
            // fontes/g/CanecaArvore.g:306:4: DESTRUA expressao
            {
            _last = (CommonTree)input.LT(1);
            DESTRUA157=(CommonTree)match(input,DESTRUA,FOLLOW_DESTRUA_in_destruicao1794);  
            stream_DESTRUA.add(DESTRUA157);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_destruicao1796);
            expressao158=expressao();

            state._fsp--;

            stream_expressao.add(expressao158.getTree());

            // AST REWRITE
            // elements: expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 306:22: -> ^( DESTRUICAO_ expressao )
            {
                // fontes/g/CanecaArvore.g:306:25: ^( DESTRUICAO_ expressao )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DESTRUICAO_, "DESTRUICAO_")
                , root_1);

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "destruicao"


    public static class retorno_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "retorno"
    // fontes/g/CanecaArvore.g:309:1: retorno : RETORNE expressao -> ^( RETORNO_ expressao ) ;
    public final CanecaArvore.retorno_return retorno() throws RecognitionException {
        CanecaArvore.retorno_return retval = new CanecaArvore.retorno_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RETORNE159=null;
        CanecaArvore.expressao_return expressao160 =null;


        CommonTree RETORNE159_tree=null;
        RewriteRuleNodeStream stream_RETORNE=new RewriteRuleNodeStream(adaptor,"token RETORNE");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:310:2: ( RETORNE expressao -> ^( RETORNO_ expressao ) )
            // fontes/g/CanecaArvore.g:310:4: RETORNE expressao
            {
            _last = (CommonTree)input.LT(1);
            RETORNE159=(CommonTree)match(input,RETORNE,FOLLOW_RETORNE_in_retorno1816);  
            stream_RETORNE.add(RETORNE159);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_retorno1818);
            expressao160=expressao();

            state._fsp--;

            stream_expressao.add(expressao160.getTree());

            // AST REWRITE
            // elements: expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 310:22: -> ^( RETORNO_ expressao )
            {
                // fontes/g/CanecaArvore.g:310:25: ^( RETORNO_ expressao )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RETORNO_, "RETORNO_")
                , root_1);

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "retorno"


    public static class se_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "se"
    // fontes/g/CanecaArvore.g:313:1: se : SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes ( SENAO blocoDeInstrucoes )? -> ^( SE_ expressao blocoDeInstrucoes ( blocoDeInstrucoes )? ) ;
    public final CanecaArvore.se_return se() throws RecognitionException {
        CanecaArvore.se_return retval = new CanecaArvore.se_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SE161=null;
        CommonTree PARENTESE_ESQUERDO162=null;
        CommonTree PARENTESE_DIREITO164=null;
        CommonTree SENAO166=null;
        CanecaArvore.expressao_return expressao163 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes165 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes167 =null;


        CommonTree SE161_tree=null;
        CommonTree PARENTESE_ESQUERDO162_tree=null;
        CommonTree PARENTESE_DIREITO164_tree=null;
        CommonTree SENAO166_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_SE=new RewriteRuleNodeStream(adaptor,"token SE");
        RewriteRuleNodeStream stream_SENAO=new RewriteRuleNodeStream(adaptor,"token SENAO");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:314:2: ( SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes ( SENAO blocoDeInstrucoes )? -> ^( SE_ expressao blocoDeInstrucoes ( blocoDeInstrucoes )? ) )
            // fontes/g/CanecaArvore.g:314:4: SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes ( SENAO blocoDeInstrucoes )?
            {
            _last = (CommonTree)input.LT(1);
            SE161=(CommonTree)match(input,SE,FOLLOW_SE_in_se1837);  
            stream_SE.add(SE161);


            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO162=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_se1839);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO162);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_se1841);
            expressao163=expressao();

            state._fsp--;

            stream_expressao.add(expressao163.getTree());

            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO164=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_se1843);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO164);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_se1845);
            blocoDeInstrucoes165=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes165.getTree());

            // fontes/g/CanecaArvore.g:314:72: ( SENAO blocoDeInstrucoes )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==SENAO) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // fontes/g/CanecaArvore.g:314:73: SENAO blocoDeInstrucoes
                    {
                    _last = (CommonTree)input.LT(1);
                    SENAO166=(CommonTree)match(input,SENAO,FOLLOW_SENAO_in_se1848);  
                    stream_SENAO.add(SENAO166);


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blocoDeInstrucoes_in_se1850);
                    blocoDeInstrucoes167=blocoDeInstrucoes();

                    state._fsp--;

                    stream_blocoDeInstrucoes.add(blocoDeInstrucoes167.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: expressao, blocoDeInstrucoes, blocoDeInstrucoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 314:99: -> ^( SE_ expressao blocoDeInstrucoes ( blocoDeInstrucoes )? )
            {
                // fontes/g/CanecaArvore.g:314:102: ^( SE_ expressao blocoDeInstrucoes ( blocoDeInstrucoes )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SE_, "SE_")
                , root_1);

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                // fontes/g/CanecaArvore.g:314:136: ( blocoDeInstrucoes )?
                if ( stream_blocoDeInstrucoes.hasNext() ) {
                    adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                }
                stream_blocoDeInstrucoes.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "se"


    public static class para_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "para"
    // fontes/g/CanecaArvore.g:317:1: para : PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^( PARA_ expressao expressao expressao blocoDeInstrucoes ) ;
    public final CanecaArvore.para_return para() throws RecognitionException {
        CanecaArvore.para_return retval = new CanecaArvore.para_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARA168=null;
        CommonTree PARENTESE_ESQUERDO169=null;
        CommonTree TERMINADOR171=null;
        CommonTree TERMINADOR173=null;
        CommonTree PARENTESE_DIREITO175=null;
        CanecaArvore.expressao_return expressao170 =null;

        CanecaArvore.expressao_return expressao172 =null;

        CanecaArvore.expressao_return expressao174 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes176 =null;


        CommonTree PARA168_tree=null;
        CommonTree PARENTESE_ESQUERDO169_tree=null;
        CommonTree TERMINADOR171_tree=null;
        CommonTree TERMINADOR173_tree=null;
        CommonTree PARENTESE_DIREITO175_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_TERMINADOR=new RewriteRuleNodeStream(adaptor,"token TERMINADOR");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleNodeStream stream_PARA=new RewriteRuleNodeStream(adaptor,"token PARA");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:318:2: ( PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^( PARA_ expressao expressao expressao blocoDeInstrucoes ) )
            // fontes/g/CanecaArvore.g:318:4: PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes
            {
            _last = (CommonTree)input.LT(1);
            PARA168=(CommonTree)match(input,PARA,FOLLOW_PARA_in_para1876);  
            stream_PARA.add(PARA168);


            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO169=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_para1878);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO169);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_para1880);
            expressao170=expressao();

            state._fsp--;

            stream_expressao.add(expressao170.getTree());

            _last = (CommonTree)input.LT(1);
            TERMINADOR171=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_para1882);  
            stream_TERMINADOR.add(TERMINADOR171);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_para1884);
            expressao172=expressao();

            state._fsp--;

            stream_expressao.add(expressao172.getTree());

            _last = (CommonTree)input.LT(1);
            TERMINADOR173=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_para1886);  
            stream_TERMINADOR.add(TERMINADOR173);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_para1888);
            expressao174=expressao();

            state._fsp--;

            stream_expressao.add(expressao174.getTree());

            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO175=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_para1890);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO175);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_para1892);
            blocoDeInstrucoes176=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes176.getTree());

            // AST REWRITE
            // elements: expressao, blocoDeInstrucoes, expressao, expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 318:116: -> ^( PARA_ expressao expressao expressao blocoDeInstrucoes )
            {
                // fontes/g/CanecaArvore.g:318:119: ^( PARA_ expressao expressao expressao blocoDeInstrucoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PARA_, "PARA_")
                , root_1);

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "para"


    public static class repita_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "repita"
    // fontes/g/CanecaArvore.g:321:1: repita : REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^( REPITA_ declaracao expressao blocoDeInstrucoes ) ;
    public final CanecaArvore.repita_return repita() throws RecognitionException {
        CanecaArvore.repita_return retval = new CanecaArvore.repita_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPITA177=null;
        CommonTree PARENTESE_ESQUERDO178=null;
        CommonTree TERMINADOR180=null;
        CommonTree PARENTESE_DIREITO182=null;
        CanecaArvore.declaracao_return declaracao179 =null;

        CanecaArvore.expressao_return expressao181 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes183 =null;


        CommonTree REPITA177_tree=null;
        CommonTree PARENTESE_ESQUERDO178_tree=null;
        CommonTree TERMINADOR180_tree=null;
        CommonTree PARENTESE_DIREITO182_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_TERMINADOR=new RewriteRuleNodeStream(adaptor,"token TERMINADOR");
        RewriteRuleNodeStream stream_REPITA=new RewriteRuleNodeStream(adaptor,"token REPITA");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleSubtreeStream stream_declaracao=new RewriteRuleSubtreeStream(adaptor,"rule declaracao");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:322:2: ( REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^( REPITA_ declaracao expressao blocoDeInstrucoes ) )
            // fontes/g/CanecaArvore.g:322:4: REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes
            {
            _last = (CommonTree)input.LT(1);
            REPITA177=(CommonTree)match(input,REPITA,FOLLOW_REPITA_in_repita1917);  
            stream_REPITA.add(REPITA177);


            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO178=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_repita1919);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO178);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_declaracao_in_repita1921);
            declaracao179=declaracao();

            state._fsp--;

            stream_declaracao.add(declaracao179.getTree());

            _last = (CommonTree)input.LT(1);
            TERMINADOR180=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_repita1923);  
            stream_TERMINADOR.add(TERMINADOR180);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_repita1925);
            expressao181=expressao();

            state._fsp--;

            stream_expressao.add(expressao181.getTree());

            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO182=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_repita1927);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO182);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_repita1929);
            blocoDeInstrucoes183=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes183.getTree());

            // AST REWRITE
            // elements: declaracao, expressao, blocoDeInstrucoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 322:98: -> ^( REPITA_ declaracao expressao blocoDeInstrucoes )
            {
                // fontes/g/CanecaArvore.g:322:101: ^( REPITA_ declaracao expressao blocoDeInstrucoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(REPITA_, "REPITA_")
                , root_1);

                adaptor.addChild(root_1, stream_declaracao.nextTree());

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "repita"


    public static class enquanto_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "enquanto"
    // fontes/g/CanecaArvore.g:325:1: enquanto : ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^( ENQUANTO_ expressao blocoDeInstrucoes ) ;
    public final CanecaArvore.enquanto_return enquanto() throws RecognitionException {
        CanecaArvore.enquanto_return retval = new CanecaArvore.enquanto_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ENQUANTO184=null;
        CommonTree PARENTESE_ESQUERDO185=null;
        CommonTree PARENTESE_DIREITO187=null;
        CanecaArvore.expressao_return expressao186 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes188 =null;


        CommonTree ENQUANTO184_tree=null;
        CommonTree PARENTESE_ESQUERDO185_tree=null;
        CommonTree PARENTESE_DIREITO187_tree=null;
        RewriteRuleNodeStream stream_ENQUANTO=new RewriteRuleNodeStream(adaptor,"token ENQUANTO");
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:326:2: ( ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^( ENQUANTO_ expressao blocoDeInstrucoes ) )
            // fontes/g/CanecaArvore.g:326:4: ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes
            {
            _last = (CommonTree)input.LT(1);
            ENQUANTO184=(CommonTree)match(input,ENQUANTO,FOLLOW_ENQUANTO_in_enquanto1952);  
            stream_ENQUANTO.add(ENQUANTO184);


            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO185=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_enquanto1954);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO185);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_enquanto1956);
            expressao186=expressao();

            state._fsp--;

            stream_expressao.add(expressao186.getTree());

            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO187=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_enquanto1958);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO187);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_enquanto1960);
            blocoDeInstrucoes188=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes188.getTree());

            // AST REWRITE
            // elements: expressao, blocoDeInstrucoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 326:78: -> ^( ENQUANTO_ expressao blocoDeInstrucoes )
            {
                // fontes/g/CanecaArvore.g:326:81: ^( ENQUANTO_ expressao blocoDeInstrucoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ENQUANTO_, "ENQUANTO_")
                , root_1);

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "enquanto"


    public static class tente_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tente"
    // fontes/g/CanecaArvore.g:329:1: tente : TENTE blocoDeInstrucoes listaDeCapturas -> ^( TENTE_ blocoDeInstrucoes listaDeCapturas ) ;
    public final CanecaArvore.tente_return tente() throws RecognitionException {
        CanecaArvore.tente_return retval = new CanecaArvore.tente_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TENTE189=null;
        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes190 =null;

        CanecaArvore.listaDeCapturas_return listaDeCapturas191 =null;


        CommonTree TENTE189_tree=null;
        RewriteRuleNodeStream stream_TENTE=new RewriteRuleNodeStream(adaptor,"token TENTE");
        RewriteRuleSubtreeStream stream_listaDeCapturas=new RewriteRuleSubtreeStream(adaptor,"rule listaDeCapturas");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        try {
            // fontes/g/CanecaArvore.g:330:2: ( TENTE blocoDeInstrucoes listaDeCapturas -> ^( TENTE_ blocoDeInstrucoes listaDeCapturas ) )
            // fontes/g/CanecaArvore.g:330:4: TENTE blocoDeInstrucoes listaDeCapturas
            {
            _last = (CommonTree)input.LT(1);
            TENTE189=(CommonTree)match(input,TENTE,FOLLOW_TENTE_in_tente1981);  
            stream_TENTE.add(TENTE189);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_tente1983);
            blocoDeInstrucoes190=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes190.getTree());

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_listaDeCapturas_in_tente1985);
            listaDeCapturas191=listaDeCapturas();

            state._fsp--;

            stream_listaDeCapturas.add(listaDeCapturas191.getTree());

            // AST REWRITE
            // elements: listaDeCapturas, blocoDeInstrucoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 330:44: -> ^( TENTE_ blocoDeInstrucoes listaDeCapturas )
            {
                // fontes/g/CanecaArvore.g:330:47: ^( TENTE_ blocoDeInstrucoes listaDeCapturas )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TENTE_, "TENTE_")
                , root_1);

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_1, stream_listaDeCapturas.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tente"


    public static class capture_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "capture"
    // fontes/g/CanecaArvore.g:333:1: capture : CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes -> ^( CAPTURE_ declaracao blocoDeInstrucoes ) ;
    public final CanecaArvore.capture_return capture() throws RecognitionException {
        CanecaArvore.capture_return retval = new CanecaArvore.capture_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CAPTURE192=null;
        CommonTree PARENTESE_ESQUERDO193=null;
        CommonTree PARENTESE_DIREITO195=null;
        CanecaArvore.declaracao_return declaracao194 =null;

        CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes196 =null;


        CommonTree CAPTURE192_tree=null;
        CommonTree PARENTESE_ESQUERDO193_tree=null;
        CommonTree PARENTESE_DIREITO195_tree=null;
        RewriteRuleNodeStream stream_PARENTESE_ESQUERDO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_ESQUERDO");
        RewriteRuleNodeStream stream_CAPTURE=new RewriteRuleNodeStream(adaptor,"token CAPTURE");
        RewriteRuleNodeStream stream_PARENTESE_DIREITO=new RewriteRuleNodeStream(adaptor,"token PARENTESE_DIREITO");
        RewriteRuleSubtreeStream stream_declaracao=new RewriteRuleSubtreeStream(adaptor,"rule declaracao");
        RewriteRuleSubtreeStream stream_blocoDeInstrucoes=new RewriteRuleSubtreeStream(adaptor,"rule blocoDeInstrucoes");
        try {
            // fontes/g/CanecaArvore.g:334:2: ( CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes -> ^( CAPTURE_ declaracao blocoDeInstrucoes ) )
            // fontes/g/CanecaArvore.g:334:4: CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes
            {
            _last = (CommonTree)input.LT(1);
            CAPTURE192=(CommonTree)match(input,CAPTURE,FOLLOW_CAPTURE_in_capture2006);  
            stream_CAPTURE.add(CAPTURE192);


            _last = (CommonTree)input.LT(1);
            PARENTESE_ESQUERDO193=(CommonTree)match(input,PARENTESE_ESQUERDO,FOLLOW_PARENTESE_ESQUERDO_in_capture2008);  
            stream_PARENTESE_ESQUERDO.add(PARENTESE_ESQUERDO193);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_declaracao_in_capture2010);
            declaracao194=declaracao();

            state._fsp--;

            stream_declaracao.add(declaracao194.getTree());

            _last = (CommonTree)input.LT(1);
            PARENTESE_DIREITO195=(CommonTree)match(input,PARENTESE_DIREITO,FOLLOW_PARENTESE_DIREITO_in_capture2012);  
            stream_PARENTESE_DIREITO.add(PARENTESE_DIREITO195);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_blocoDeInstrucoes_in_capture2014);
            blocoDeInstrucoes196=blocoDeInstrucoes();

            state._fsp--;

            stream_blocoDeInstrucoes.add(blocoDeInstrucoes196.getTree());

            // AST REWRITE
            // elements: blocoDeInstrucoes, declaracao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 334:78: -> ^( CAPTURE_ declaracao blocoDeInstrucoes )
            {
                // fontes/g/CanecaArvore.g:334:81: ^( CAPTURE_ declaracao blocoDeInstrucoes )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CAPTURE_, "CAPTURE_")
                , root_1);

                adaptor.addChild(root_1, stream_declaracao.nextTree());

                adaptor.addChild(root_1, stream_blocoDeInstrucoes.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "capture"


    public static class lance_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lance"
    // fontes/g/CanecaArvore.g:337:1: lance : LANCE expressao -> ^( LANCE_ expressao ) ;
    public final CanecaArvore.lance_return lance() throws RecognitionException {
        CanecaArvore.lance_return retval = new CanecaArvore.lance_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LANCE197=null;
        CanecaArvore.expressao_return expressao198 =null;


        CommonTree LANCE197_tree=null;
        RewriteRuleNodeStream stream_LANCE=new RewriteRuleNodeStream(adaptor,"token LANCE");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try {
            // fontes/g/CanecaArvore.g:338:2: ( LANCE expressao -> ^( LANCE_ expressao ) )
            // fontes/g/CanecaArvore.g:338:4: LANCE expressao
            {
            _last = (CommonTree)input.LT(1);
            LANCE197=(CommonTree)match(input,LANCE,FOLLOW_LANCE_in_lance2035);  
            stream_LANCE.add(LANCE197);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expressao_in_lance2037);
            expressao198=expressao();

            state._fsp--;

            stream_expressao.add(expressao198.getTree());

            // AST REWRITE
            // elements: expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 338:20: -> ^( LANCE_ expressao )
            {
                // fontes/g/CanecaArvore.g:338:23: ^( LANCE_ expressao )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(LANCE_, "LANCE_")
                , root_1);

                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lance"


    public static class instrucao_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instrucao"
    // fontes/g/CanecaArvore.g:341:1: instrucao : ( ( options {k=2; } : expressao TERMINADOR !| declaracaoComAtribuicaoOpcional TERMINADOR !) | IMPRIMIR TERMINADOR !| DEPURAR TERMINADOR !| destruicao TERMINADOR !| retorno TERMINADOR !| se | para | repita | enquanto | tente | lance TERMINADOR !);
    public final CanecaArvore.instrucao_return instrucao() throws RecognitionException {
        CanecaArvore.instrucao_return retval = new CanecaArvore.instrucao_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TERMINADOR200=null;
        CommonTree TERMINADOR202=null;
        CommonTree IMPRIMIR203=null;
        CommonTree TERMINADOR204=null;
        CommonTree DEPURAR205=null;
        CommonTree TERMINADOR206=null;
        CommonTree TERMINADOR208=null;
        CommonTree TERMINADOR210=null;
        CommonTree TERMINADOR217=null;
        CanecaArvore.expressao_return expressao199 =null;

        CanecaArvore.declaracaoComAtribuicaoOpcional_return declaracaoComAtribuicaoOpcional201 =null;

        CanecaArvore.destruicao_return destruicao207 =null;

        CanecaArvore.retorno_return retorno209 =null;

        CanecaArvore.se_return se211 =null;

        CanecaArvore.para_return para212 =null;

        CanecaArvore.repita_return repita213 =null;

        CanecaArvore.enquanto_return enquanto214 =null;

        CanecaArvore.tente_return tente215 =null;

        CanecaArvore.lance_return lance216 =null;


        CommonTree TERMINADOR200_tree=null;
        CommonTree TERMINADOR202_tree=null;
        CommonTree IMPRIMIR203_tree=null;
        CommonTree TERMINADOR204_tree=null;
        CommonTree DEPURAR205_tree=null;
        CommonTree TERMINADOR206_tree=null;
        CommonTree TERMINADOR208_tree=null;
        CommonTree TERMINADOR210_tree=null;
        CommonTree TERMINADOR217_tree=null;

        try {
            // fontes/g/CanecaArvore.g:342:2: ( ( options {k=2; } : expressao TERMINADOR !| declaracaoComAtribuicaoOpcional TERMINADOR !) | IMPRIMIR TERMINADOR !| DEPURAR TERMINADOR !| destruicao TERMINADOR !| retorno TERMINADOR !| se | para | repita | enquanto | tente | lance TERMINADOR !)
            int alt39=11;
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
                alt39=1;
                }
                break;
            case IMPRIMIR:
                {
                alt39=2;
                }
                break;
            case DEPURAR:
                {
                alt39=3;
                }
                break;
            case DESTRUA:
                {
                alt39=4;
                }
                break;
            case RETORNE:
                {
                alt39=5;
                }
                break;
            case SE:
                {
                alt39=6;
                }
                break;
            case PARA:
                {
                alt39=7;
                }
                break;
            case REPITA:
                {
                alt39=8;
                }
                break;
            case ENQUANTO:
                {
                alt39=9;
                }
                break;
            case TENTE:
                {
                alt39=10;
                }
                break;
            case LANCE:
                {
                alt39=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // fontes/g/CanecaArvore.g:343:2: ( options {k=2; } : expressao TERMINADOR !| declaracaoComAtribuicaoOpcional TERMINADOR !)
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // fontes/g/CanecaArvore.g:343:2: ( options {k=2; } : expressao TERMINADOR !| declaracaoComAtribuicaoOpcional TERMINADOR !)
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0 >= CONSTANTE_INTEIRA && LA38_0 <= CONSTANTE_REAL)||(LA38_0 >= ESSA && LA38_0 <= ESSE)||(LA38_0 >= LITERAL_CARACTERE && LA38_0 <= LITERAL_TEXTO)||(LA38_0 >= NEGACAO && LA38_0 <= NOVO)||LA38_0==PARENTESE_ESQUERDO||LA38_0==SUBTRACAO||(LA38_0 >= VALOR_BOOLEANO && LA38_0 <= VALOR_NULO)) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==IDENTIFICADOR) ) {
                        int LA38_12 = input.LA(2);

                        if ( (LA38_12==ATRIBUIDOR||(LA38_12 >= CHAMADA_DE_CLASSE && LA38_12 <= CHAMADA_DE_OBJETO)||LA38_12==DIFERENTE||(LA38_12 >= DIVISAO && LA38_12 <= E)||LA38_12==IGUAL||(LA38_12 >= MAIOR && LA38_12 <= MENOR_IGUAL)||LA38_12==MULTIPLICACAO||LA38_12==OU||LA38_12==PARENTESE_ESQUERDO||LA38_12==RESTO_DA_DIVISAO||(LA38_12 >= SOMA && LA38_12 <= SUBTRACAO)||LA38_12==TERMINADOR) ) {
                            alt38=1;
                        }
                        else if ( (LA38_12==COLCHETE_ESQUERDO||LA38_12==IDENTIFICADOR) ) {
                            alt38=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 38, 12, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;

                    }
                    switch (alt38) {
                        case 1 :
                            // fontes/g/CanecaArvore.g:344:5: expressao TERMINADOR !
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expressao_in_instrucao2073);
                            expressao199=expressao();

                            state._fsp--;

                            adaptor.addChild(root_0, expressao199.getTree());


                            _last = (CommonTree)input.LT(1);
                            TERMINADOR200=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao2075); 

                            }
                            break;
                        case 2 :
                            // fontes/g/CanecaArvore.g:345:5: declaracaoComAtribuicaoOpcional TERMINADOR !
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_declaracaoComAtribuicaoOpcional_in_instrucao2082);
                            declaracaoComAtribuicaoOpcional201=declaracaoComAtribuicaoOpcional();

                            state._fsp--;

                            adaptor.addChild(root_0, declaracaoComAtribuicaoOpcional201.getTree());


                            _last = (CommonTree)input.LT(1);
                            TERMINADOR202=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao2084); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // fontes/g/CanecaArvore.g:347:4: IMPRIMIR TERMINADOR !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPRIMIR203=(CommonTree)match(input,IMPRIMIR,FOLLOW_IMPRIMIR_in_instrucao2093); 
                    IMPRIMIR203_tree = (CommonTree)adaptor.dupNode(IMPRIMIR203);


                    adaptor.addChild(root_0, IMPRIMIR203_tree);


                    _last = (CommonTree)input.LT(1);
                    TERMINADOR204=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao2095); 

                    }
                    break;
                case 3 :
                    // fontes/g/CanecaArvore.g:348:4: DEPURAR TERMINADOR !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEPURAR205=(CommonTree)match(input,DEPURAR,FOLLOW_DEPURAR_in_instrucao2101); 
                    DEPURAR205_tree = (CommonTree)adaptor.dupNode(DEPURAR205);


                    adaptor.addChild(root_0, DEPURAR205_tree);


                    _last = (CommonTree)input.LT(1);
                    TERMINADOR206=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao2103); 

                    }
                    break;
                case 4 :
                    // fontes/g/CanecaArvore.g:349:4: destruicao TERMINADOR !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_destruicao_in_instrucao2109);
                    destruicao207=destruicao();

                    state._fsp--;

                    adaptor.addChild(root_0, destruicao207.getTree());


                    _last = (CommonTree)input.LT(1);
                    TERMINADOR208=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao2111); 

                    }
                    break;
                case 5 :
                    // fontes/g/CanecaArvore.g:350:4: retorno TERMINADOR !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_retorno_in_instrucao2117);
                    retorno209=retorno();

                    state._fsp--;

                    adaptor.addChild(root_0, retorno209.getTree());


                    _last = (CommonTree)input.LT(1);
                    TERMINADOR210=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao2119); 

                    }
                    break;
                case 6 :
                    // fontes/g/CanecaArvore.g:351:4: se
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_se_in_instrucao2125);
                    se211=se();

                    state._fsp--;

                    adaptor.addChild(root_0, se211.getTree());


                    }
                    break;
                case 7 :
                    // fontes/g/CanecaArvore.g:352:4: para
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_para_in_instrucao2130);
                    para212=para();

                    state._fsp--;

                    adaptor.addChild(root_0, para212.getTree());


                    }
                    break;
                case 8 :
                    // fontes/g/CanecaArvore.g:353:4: repita
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_repita_in_instrucao2135);
                    repita213=repita();

                    state._fsp--;

                    adaptor.addChild(root_0, repita213.getTree());


                    }
                    break;
                case 9 :
                    // fontes/g/CanecaArvore.g:354:4: enquanto
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_enquanto_in_instrucao2140);
                    enquanto214=enquanto();

                    state._fsp--;

                    adaptor.addChild(root_0, enquanto214.getTree());


                    }
                    break;
                case 10 :
                    // fontes/g/CanecaArvore.g:355:4: tente
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tente_in_instrucao2145);
                    tente215=tente();

                    state._fsp--;

                    adaptor.addChild(root_0, tente215.getTree());


                    }
                    break;
                case 11 :
                    // fontes/g/CanecaArvore.g:356:4: lance TERMINADOR !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_lance_in_instrucao2150);
                    lance216=lance();

                    state._fsp--;

                    adaptor.addChild(root_0, lance216.getTree());


                    _last = (CommonTree)input.LT(1);
                    TERMINADOR217=(CommonTree)match(input,TERMINADOR,FOLLOW_TERMINADOR_in_instrucao2152); 

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instrucao"


    public static class blocoDeInstrucoes_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "blocoDeInstrucoes"
    // fontes/g/CanecaArvore.g:359:1: blocoDeInstrucoes : INICIO ( instrucao )* FIM -> ^( INSTRUCOES_ ( instrucao )* ) ;
    public final CanecaArvore.blocoDeInstrucoes_return blocoDeInstrucoes() throws RecognitionException {
        CanecaArvore.blocoDeInstrucoes_return retval = new CanecaArvore.blocoDeInstrucoes_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INICIO218=null;
        CommonTree FIM220=null;
        CanecaArvore.instrucao_return instrucao219 =null;


        CommonTree INICIO218_tree=null;
        CommonTree FIM220_tree=null;
        RewriteRuleNodeStream stream_INICIO=new RewriteRuleNodeStream(adaptor,"token INICIO");
        RewriteRuleNodeStream stream_FIM=new RewriteRuleNodeStream(adaptor,"token FIM");
        RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");
        try {
            // fontes/g/CanecaArvore.g:360:2: ( INICIO ( instrucao )* FIM -> ^( INSTRUCOES_ ( instrucao )* ) )
            // fontes/g/CanecaArvore.g:360:4: INICIO ( instrucao )* FIM
            {
            _last = (CommonTree)input.LT(1);
            INICIO218=(CommonTree)match(input,INICIO,FOLLOW_INICIO_in_blocoDeInstrucoes2164);  
            stream_INICIO.add(INICIO218);


            // fontes/g/CanecaArvore.g:360:11: ( instrucao )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0 >= CONSTANTE_INTEIRA && LA40_0 <= CONSTANTE_REAL)||(LA40_0 >= DEPURAR && LA40_0 <= DESTRUA)||LA40_0==ENQUANTO||(LA40_0 >= ESSA && LA40_0 <= ESSE)||LA40_0==IDENTIFICADOR||LA40_0==IMPRIMIR||LA40_0==LANCE||(LA40_0 >= LITERAL_CARACTERE && LA40_0 <= LITERAL_TEXTO)||(LA40_0 >= NEGACAO && LA40_0 <= NOVO)||LA40_0==PARA||LA40_0==PARENTESE_ESQUERDO||LA40_0==REPITA||(LA40_0 >= RETORNE && LA40_0 <= SE)||LA40_0==SUBTRACAO||LA40_0==TENTE||(LA40_0 >= VALOR_BOOLEANO && LA40_0 <= VALOR_NULO)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // fontes/g/CanecaArvore.g:360:12: instrucao
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_instrucao_in_blocoDeInstrucoes2167);
            	    instrucao219=instrucao();

            	    state._fsp--;

            	    stream_instrucao.add(instrucao219.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            FIM220=(CommonTree)match(input,FIM,FOLLOW_FIM_in_blocoDeInstrucoes2171);  
            stream_FIM.add(FIM220);


            // AST REWRITE
            // elements: instrucao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 360:28: -> ^( INSTRUCOES_ ( instrucao )* )
            {
                // fontes/g/CanecaArvore.g:360:31: ^( INSTRUCOES_ ( instrucao )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(INSTRUCOES_, "INSTRUCOES_")
                , root_1);

                // fontes/g/CanecaArvore.g:360:45: ( instrucao )*
                while ( stream_instrucao.hasNext() ) {
                    adaptor.addChild(root_1, stream_instrucao.nextTree());

                }
                stream_instrucao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }

        	catch (RecognitionException erro) {
        		throw erro;
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "blocoDeInstrucoes"

    // Delegated rules


 

    public static final BitSet FOLLOW_unicadeDeCompilacao_in_programa291 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_cabecalho_in_unicadeDeCompilacao315 = new BitSet(new long[]{0x0000040000001000L});
    public static final BitSet FOLLOW_classe_in_unicadeDeCompilacao321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaces_in_unicadeDeCompilacao337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pacote_in_cabecalho362 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_importacoes_in_cabecalho364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACOTE_in_pacote385 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_DE_PACOTE_in_pacote387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_pacote389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importacao_in_importacoes409 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_IMPORTE_in_importacao433 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_importacao439 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao441 = new BitSet(new long[]{0x0000000000020000L,0x0000000000004000L});
    public static final BitSet FOLLOW_COMO_in_importacao444 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_importacao446 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_DE_PACOTE_in_importacao469 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_importacao483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASSE_in_classe494 = new BitSet(new long[]{0xA000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_modificadorDeAcessoFeminino_in_classe496 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_classe498 = new BitSet(new long[]{0x0000024000004000L});
    public static final BitSet FOLLOW_listaDeTiposGenericos_in_classe500 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_listaDeInterfaces_in_classe502 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_corpoDaClasse_in_classe504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTERFACE_in_interfaces531 = new BitSet(new long[]{0xA000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_modificadorDeAcessoFeminino_in_interfaces533 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_interfaces535 = new BitSet(new long[]{0x0000024000004000L});
    public static final BitSet FOLLOW_listaDeTiposGenericos_in_interfaces537 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_listaDeInterfaces_in_interfaces539 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_corpoDaInterface_in_interfaces541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INICIO_in_corpoDaClasse568 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_atributos_in_corpoDaClasse570 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_construtores_in_corpoDaClasse572 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_destrutor_in_corpoDaClasse574 = new BitSet(new long[]{0x0008000400000000L});
    public static final BitSet FOLLOW_metodos_in_corpoDaClasse576 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FIM_in_corpoDaClasse578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INICIO_in_corpoDaInterface603 = new BitSet(new long[]{0x0008000400000020L});
    public static final BitSet FOLLOW_atributos_in_corpoDaInterface605 = new BitSet(new long[]{0x0008000400000000L});
    public static final BitSet FOLLOW_assinaturasDeMetodos_in_corpoDaInterface607 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FIM_in_corpoDaInterface609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atributo_in_atributos631 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_construtor_in_construtores656 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_metodo_in_metodos681 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_assinaturaDeMetodo_in_assinaturasDeMetodos706 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_assinaturasDeMetodos708 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ATRIBUTO_in_atributo732 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_atributo734 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_ESTATICO_in_atributo737 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_atributo741 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_atributo743 = new BitSet(new long[]{0x0000000000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_ATRIBUIDOR_in_atributo771 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_atributo773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_atributo817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assinaturaDeConstrutor_in_construtor828 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_construtor830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assinaturaDeDestrutor_in_destrutor851 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_destrutor853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assinaturaDeMetodo_in_metodo874 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_metodo876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRUTOR_in_assinaturaDeConstrutor897 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeConstrutor899 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_assinaturaDeConstrutor901 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeArgumentos_in_assinaturaDeConstrutor903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESTRUTOR_in_assinaturaDeDestrutor926 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeDestrutor928 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_assinaturaDeDestrutor930 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeArgumentosVazia_in_assinaturaDeDestrutor932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METODO_in_assinaturaDeMetodo955 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_modificadorDeAcessoMasculino_in_assinaturaDeMetodo957 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_ESTATICO_in_assinaturaDeMetodo960 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_assinaturaDeMetodo964 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_assinaturaDeMetodo966 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeArgumentos_in_assinaturaDeMetodo968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_listaDeParametros1040 = new BitSet(new long[]{0x18E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_listaDeParametros1043 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeParametros1046 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_listaDeParametros1048 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_listaDeParametros1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentosVazia1076 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentosVazia1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_listaDeArgumentos1095 = new BitSet(new long[]{0x0800000800000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeArgumentos1098 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeArgumentos1101 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeArgumentos1103 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_listaDeArgumentos1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTA_in_listaDeInterfaces1132 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeInterfaces1134 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeInterfaces1137 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeInterfaces1139 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_COLCHETE_ESQUERDO_in_listaDeTiposGenericos1166 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipoGenerico_in_listaDeTiposGenericos1168 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLCHETE_DIREITO_in_listaDeTiposGenericos1170 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_COLCHETE_ESQUERDO_in_listaDeTipos1195 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeTipos1197 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARADOR_in_listaDeTipos1200 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_listaDeTipos1202 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000200L});
    public static final BitSet FOLLOW_COLCHETE_DIREITO_in_listaDeTipos1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_capture_in_listaDeCapturas1231 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_tipoGenerico1255 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_listaDeInterfaces_in_tipoGenerico1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_tipo1278 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_listaDeTipos_in_tipo1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_declaracao1301 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_declaracao1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_declaracaoComAtribuicaoOpcional1324 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_declaracaoComAtribuicaoOpcional1326 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ATRIBUIDOR_in_declaracaoComAtribuicaoOpcional1347 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_declaracaoComAtribuicaoOpcional1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_expressao1394 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ATRIBUIDOR_in_expressao1397 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoOuLogico_in_expressao1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressaoELogico_in_expressaoOuLogico1413 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_OU_in_expressaoOuLogico1416 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoELogico_in_expressaoOuLogico1419 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_expressaoComparacaoLogica_in_expressaoELogico1432 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_E_in_expressaoELogico1435 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoComparacaoLogica_in_expressaoELogico1438 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica1451 = new BitSet(new long[]{0x0007802002000002L});
    public static final BitSet FOLLOW_set_in_expressaoComparacaoLogica1454 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoAditiva_in_expressaoComparacaoLogica1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressaoMultiplicativa_in_expressaoAditiva1492 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_expressaoAditiva1495 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoMultiplicativa_in_expressaoAditiva1504 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_expressaoUnaria_in_expressaoMultiplicativa1517 = new BitSet(new long[]{0x0010000008000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_expressaoMultiplicativa1520 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressaoUnaria_in_expressaoMultiplicativa1533 = new BitSet(new long[]{0x0010000008000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_expressaoPrimaria_in_expressaoUnaria1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBTRACAO_in_expressaoUnaria1551 = new BitSet(new long[]{0x10C06009800C0000L,0x0000000000030000L});
    public static final BitSet FOLLOW_expressaoPrimaria_in_expressaoUnaria1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGACAO_in_expressaoUnaria1566 = new BitSet(new long[]{0x10C06009800C0000L,0x0000000000030000L});
    public static final BitSet FOLLOW_expressaoPrimaria_in_expressaoUnaria1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_expressaoPrimaria1587 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_expressaoPrimaria1589 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_expressaoPrimaria1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALOR_BOOLEANO_in_expressaoPrimaria1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALOR_NULO_in_expressaoPrimaria1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTE_INTEIRA_in_expressaoPrimaria1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTE_REAL_in_expressaoPrimaria1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_CARACTERE_in_expressaoPrimaria1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_TEXTO_in_expressaoPrimaria1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comando_in_expressaoPrimaria1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referencia_in_comando1641 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_chamada_in_comando1644 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_ESSE_in_referencia1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESSA_in_referencia1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanciacao_in_referencia1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_referencia1709 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_listaDeParametros_in_referencia1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_chamada1738 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFICADOR_in_chamada1747 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_listaDeParametros_in_chamada1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOVO_in_instanciacao1764 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NOVA_in_instanciacao1768 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_tipo_in_instanciacao1771 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listaDeParametros_in_instanciacao1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESTRUA_in_destruicao1794 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_destruicao1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETORNE_in_retorno1816 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_retorno1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SE_in_se1837 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_se1839 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_se1841 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_se1843 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_se1845 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_SENAO_in_se1848 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_se1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARA_in_para1876 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_para1878 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_para1880 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_para1882 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_para1884 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_para1886 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_para1888 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_para1890 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_para1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPITA_in_repita1917 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_repita1919 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_declaracao_in_repita1921 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_repita1923 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_repita1925 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_repita1927 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_repita1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENQUANTO_in_enquanto1952 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_enquanto1954 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_enquanto1956 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_enquanto1958 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_enquanto1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TENTE_in_tente1981 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_tente1983 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_listaDeCapturas_in_tente1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPTURE_in_capture2006 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_PARENTESE_ESQUERDO_in_capture2008 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_declaracao_in_capture2010 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PARENTESE_DIREITO_in_capture2012 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_blocoDeInstrucoes_in_capture2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANCE_in_lance2035 = new BitSet(new long[]{0x10E06009800C0000L,0x0000000000030800L});
    public static final BitSet FOLLOW_expressao_in_lance2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_instrucao2073 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoComAtribuicaoOpcional_in_instrucao2082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPRIMIR_in_instrucao2093 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEPURAR_in_instrucao2101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_destruicao_in_instrucao2109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorno_in_instrucao2117 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_instrucao2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_instrucao2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repita_in_instrucao2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_instrucao2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tente_in_instrucao2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lance_in_instrucao2150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_TERMINADOR_in_instrucao2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INICIO_in_blocoDeInstrucoes2164 = new BitSet(new long[]{0x14E0690DA0CC0000L,0x00000000000328D0L});
    public static final BitSet FOLLOW_instrucao_in_blocoDeInstrucoes2167 = new BitSet(new long[]{0x14E0690DA0CC0000L,0x00000000000328D0L});
    public static final BitSet FOLLOW_FIM_in_blocoDeInstrucoes2171 = new BitSet(new long[]{0x0000000000000002L});

}