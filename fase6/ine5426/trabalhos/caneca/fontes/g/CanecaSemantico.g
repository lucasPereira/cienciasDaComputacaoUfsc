tree grammar CanecaSemantico;

options {
	ASTLabelType = CommonTree;
	tokenVocab = CanecaArvore;
	filter = true;
}

@header {
	package br.ufsc.inf.ine5426.caneca.antlr;

	import br.ufsc.inf.ine5426.caneca.interno.Atributo;
	import br.ufsc.inf.ine5426.caneca.interno.Bloco;
	import br.ufsc.inf.ine5426.caneca.interno.Classe;
	import br.ufsc.inf.ine5426.caneca.interno.Construtor;
	import br.ufsc.inf.ine5426.caneca.interno.Destrutor;
	import br.ufsc.inf.ine5426.caneca.interno.Escopo;
	import br.ufsc.inf.ine5426.caneca.interno.Expressao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoAtribuicao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoChamadaDeMetodo;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoComando;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoConstanteInteira;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoConstanteReal;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoDiferente;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoDivisao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoE;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoIgual;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoInstanciacao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoLiteralCaractere;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoLiteralTexto;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoMaior;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoMaiorIgual;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoMenor;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoMenorIgual;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoMultiplicacao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoNegacao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoNegativacao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoOu;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoReferencia;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoRestoDaDivisao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoAdicao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoSubtracao;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoValorBooleano;
	import br.ufsc.inf.ine5426.caneca.interno.ExpressaoValorNulo;
	import br.ufsc.inf.ine5426.caneca.interno.Instrucao;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoCapture;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoDestrua;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoDepurar;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoEnquanto;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoImprimir;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoLance;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoPara;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoRepita;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoRetorne;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoSe;
	import br.ufsc.inf.ine5426.caneca.interno.InstrucaoTente;
	import br.ufsc.inf.ine5426.caneca.interno.Metodo;
	import br.ufsc.inf.ine5426.caneca.interno.TabelaDeSimbolos;
	import br.ufsc.inf.ine5426.caneca.interno.Tipo;
	import br.ufsc.inf.ine5426.caneca.interno.Variavel;
	
	import java.util.Stack;
}

@members {
	private TabelaDeSimbolos tabelaDeSimbolos;
	private Escopo escopoAtual;
	private Stack<Expressao> escoposDonos;
	private boolean debug = false;
	
	public void fixarTabelaDeSimbolos(TabelaDeSimbolos tabelaDeSimbolos) {
		this.tabelaDeSimbolos = tabelaDeSimbolos;
		this.escopoAtual = tabelaDeSimbolos;
		this.escoposDonos = new Stack<Expressao>();
	}
	
	public void mostrar(String mensagem) {
		if (debug) {
			System.out.println("......... " + mensagem);
		}
	}
}

@rulecatch {
	catch (RecognitionException erro) {
		throw erro;
	}
}

topdown
	: classe
	| atributo
	| construtor
	| destrutor
	| metodo
	| declaracao
	| bloco
	| imprimir
	| depurar
	| se
	| para
	| repita
	| enquanto
	| tente
	| capture
	| lance
	| destruicao
	| retorno
	| expressaoAtribuicao
	| expressaoOu
	| expressaoE
	| expressaoIgual
	| expressaoDiferente
	| expressaoMaior
	| expressaoMaiorIgual
	| expressaoMenor
	| expressaoMenorIgual
	| expressaoAdicao
	| expressaoSubtracao
	| expressaoMultiplicacao
	| expressaoDivisao
	| expressaoRestoDaDivisao
	| expressaoNegativacao
	| expressaoNegacao
	| expressaoPrimaria
	| comando
	| referencia
	| referenciaDeMetodo
	| instanciacao
	| chamada
	| chamadaDeMetodo
	;

bottomup
	: terminaClasse
	| terminarConstrutor
	| terminarDestrutor
	| terminarMetodo
	| terminarBloco
	| terminarSe
	| terminarPara
	| terminarRepita
	| terminarEnquanto
	| terminarTente
	| terminarCapture
	| terminarLance
	| terminarDestruicao
	| terminarRetorno
	| terminarExpressaoAtribuicao
	| terminarExpressaoOu
	| terminarExpressaoE
	| terminarExpressaoIgual
	| terminarExpressaoDiferente
	| terminarExpressaoMaior
	| terminarExpressaoMaiorIgual
	| terminarExpressaoMenor
	| terminarExpressaoMenorIgual
	| terminarExpressaoAdicao
	| terminarExpressaoSubtracao
	| terminarExpressaoMultiplicacao
	| terminarExpressaoDivisao
	| terminarExpressaoRestoDaDivisao
	| terminarExpressaoNegativacao
	| terminarExpressaoNegacao
	| terminarComando
	| terminarReferenciaDeMetodo
	| terminarInstanciacao
	| terminarChamadaDeMetodo
	;

programa
	: ^(PROGRAMA_ (unicadeDeCompilacao)+)
	;

unicadeDeCompilacao
	: ^(UNIDADE_ cabecalho classe)
	| ^(UNIDADE_ cabecalho interfaces)
	;

cabecalho
	: ^(CABECALHO_ pacote importacoes)
	;

pacote
	: ^(PACOTE_ IDENTIFICADOR_DE_PACOTE)
	;

importacoes
	: ^(IMPORTACOES_ (importacao)*)
	;

importacao
	: ^(IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE (IDENTIFICADOR)?)
	| ^(IMPORTACAO_ IDENTIFICADOR_DE_PACOTE)
	;

classe
	: ^(CLASSE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces .)
		{
			mostrar("classe");
			Classe classe = new Classe(escopoAtual, $IDENTIFICADOR.text, $IDENTIFICADOR.getLine(), $IDENTIFICADOR.getCharPositionInLine());
			escopoAtual.definirClasse(classe);
			escopoAtual = classe;
		}
	;

terminaClasse
	: ^(CLASSE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces .)
		{
			mostrar("terminarClasse");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

interfaces
	: ^(INTERFACE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface)
	;

corpoDaClasse
	: ^(CORPO_ atributos construtores destrutor metodos)
	;

corpoDaInterface
	: ^(CORPO_ atributos assinaturasDeMetodos)
	;

atributos
	: ^(ATRIBUTOS_ (atributo)*)
	;

construtores
	: ^(CONSTRUTORES_ (construtor)+)
	;

metodos
	: ^(METODOS_ (metodo)*)
	;

assinaturasDeMetodos
	: ^(ASSINATURAS_DE_METODOS_ (^(ASSINATURA_ modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR .))*)
	;

atributo
	: ^(ATRIBUTO_ modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR (.)?)
		{
			mostrar("atributo");
			Atributo atributo = new Atributo(escopoAtual, $tipo.tipo, $IDENTIFICADOR.text, $IDENTIFICADOR.getLine(), $IDENTIFICADOR.getCharPositionInLine());
			escopoAtual.definirAtributo(atributo);
		}
	;

construtor
	: ^(CONSTRUTOR_  ^(ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR .) .)
		{
			mostrar("construtor");
			Construtor construtor = new Construtor(escopoAtual, $IDENTIFICADOR.text, $IDENTIFICADOR.getLine(), $IDENTIFICADOR.getCharPositionInLine());
			escopoAtual.definirConstrutor(construtor);
			escopoAtual = construtor;
		}
	;

terminarConstrutor
	: ^(CONSTRUTOR_  ^(ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR .) .)
		{
			mostrar("terminarConstrutor");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

destrutor
	: ^(DESTRUTOR_ ^(ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR .) .)
		{
			mostrar("destrutor");
			Destrutor destrutor = new Destrutor(escopoAtual, $IDENTIFICADOR.text, $IDENTIFICADOR.getLine(), $IDENTIFICADOR.getCharPositionInLine());
			escopoAtual.definirDestrutor(destrutor);
			escopoAtual = destrutor;
		}
	;

terminarDestrutor
	: ^(DESTRUTOR_ ^(ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR .) .)
		{
			mostrar("terminarDestrutor");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

metodo
	: ^(METODO_ ^(ASSINATURA_ modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR .) .)
		{
			mostrar("metodo");
			Metodo metodo = new Metodo(escopoAtual, $tipo.tipo, $IDENTIFICADOR.text, $IDENTIFICADOR.getLine(), $IDENTIFICADOR.getCharPositionInLine());
			escopoAtual.definirMetodo(metodo);
			escopoAtual = metodo;
		}
	;

terminarMetodo
	: ^(METODO_ ^(ASSINATURA_ modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR .) .)
		{
			mostrar("terminarMetodo");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
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
	: ^(PARAMETROS_ (.)*)
	;

listaDeArgumentosVazia
	: ARGUMENTOS_
	;

listaDeArgumentos
	: ^(ARGUMENTOS_ (.)*)
	;

listaDeInterfaces
	: ^(INTERFACES_ (tipo)*)
	;

listaDeTiposGenericos
	: ^(TIPOS_GENERICOS_ (tipoGenerico)*)
	;

listaDeTipos
	: ^(TIPOS_ (tipo)*)
	;

listaDeCapturas
	: ^(CAPTURAS_ (capture)+)
	;

tipoGenerico
	: ^(TIPO_GENERICO_ IDENTIFICADOR listaDeInterfaces)
	;

tipo returns [Tipo tipo]
	: ^(TIPO_ IDENTIFICADOR listaDeTipos)
		{
			$tipo = new Tipo($IDENTIFICADOR.text);
		}
	;

declaracao
	: ^(DECLARACAO_ tipo IDENTIFICADOR)
		{
			mostrar("variavel");
			Variavel variavel = new Variavel(escopoAtual, $tipo.tipo, $IDENTIFICADOR.text, $IDENTIFICADOR.getLine(), $IDENTIFICADOR.getCharPositionInLine());
			escopoAtual.definirVariavel(variavel);
		}
	;

expressaoAtribuicao
	: ^(ATRIBUIDOR . .)
		{
			mostrar("=");
			ExpressaoAtribuicao expressao = new ExpressaoAtribuicao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoAtribuicao
	: ^(ATRIBUIDOR . .)
		{
			mostrar("terminar =");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoOu
	: ^(OU . .)
		{
			mostrar("||");
			ExpressaoOu expressao = new ExpressaoOu(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoOu
	: ^(OU . .)
		{
			mostrar("terminar ||");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoE
	: ^(E . .)
		{
			mostrar("&&");
			ExpressaoE expressao = new ExpressaoE(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoE
	: ^(E . .)
		{
			mostrar("terminar &&");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoIgual
	: ^(IGUAL . .)
		{
			mostrar("==");
			ExpressaoIgual expressao = new ExpressaoIgual(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoIgual
	: ^(IGUAL . .)
		{
			mostrar("terminar ==");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoDiferente
	: ^(DIFERENTE . .)
		{
			mostrar("!=");
			ExpressaoDiferente expressao = new ExpressaoDiferente(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoDiferente
	: ^(DIFERENTE . .)
		{
			mostrar("terminar !=");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoMaior
	: ^(MAIOR . .)
		{
			mostrar(">");
			ExpressaoMaior expressao = new ExpressaoMaior(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoMaior
	: ^(MAIOR . .)
		{
			mostrar("terminar >");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoMaiorIgual
	: ^(MAIOR_IGUAL . .)
		{
			mostrar(">=");
			ExpressaoMaiorIgual expressao = new ExpressaoMaiorIgual(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoMaiorIgual
	: ^(MAIOR_IGUAL . .)
		{
			mostrar("terminar >=");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoMenor
	: ^(MENOR . .)
		{
			mostrar("<");
			ExpressaoMenor expressao = new ExpressaoMenor(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoMenor
	: ^(MENOR . .)
		{
			mostrar("terminar <");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoMenorIgual
	: ^(MENOR_IGUAL . .)
		{
			mostrar("<=");
			ExpressaoMenorIgual expressao = new ExpressaoMenorIgual(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoMenorIgual
	: ^(MENOR_IGUAL . .)
		{
			mostrar("terminar <=");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoAdicao
	: ^(SOMA . .)
		{
			mostrar("+");
			ExpressaoAdicao expressao = new ExpressaoAdicao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoAdicao
	: ^(SOMA . .)
		{
			mostrar("terminar +");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoSubtracao
	: ^(SUBTRACAO . .)
		{
			mostrar("-");
			ExpressaoSubtracao expressao = new ExpressaoSubtracao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoSubtracao
	: ^(SUBTRACAO . .)
		{
			mostrar("terminar -");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoMultiplicacao
	: ^(MULTIPLICACAO . .)
		{
			mostrar("*");
			ExpressaoMultiplicacao expressao = new ExpressaoMultiplicacao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoMultiplicacao
	: ^(MULTIPLICACAO . .)
		{
			mostrar("terminar *");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoDivisao
	: ^(DIVISAO . .)
		{
			mostrar("/");
			ExpressaoDivisao expressao = new ExpressaoDivisao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoDivisao
	: ^(DIVISAO . .)
		{
			mostrar("terminar /");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoRestoDaDivisao
	: ^(RESTO_DA_DIVISAO . .)
		{
			mostrar("\%");
			ExpressaoRestoDaDivisao expressao = new ExpressaoRestoDaDivisao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoRestoDaDivisao
	: ^(RESTO_DA_DIVISAO . .)
		{
			mostrar("terminar \%");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoNegativacao
	: ^(NEGATIVACAO_ .)
		{
			mostrar("-");
			ExpressaoNegativacao expressao = new ExpressaoNegativacao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoNegativacao
	: ^(NEGATIVACAO_ .)
		{
			mostrar("terminar -");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoNegacao
	: ^(NEGACAO .)
		{
			mostrar("~");
			ExpressaoNegacao expressao = new ExpressaoNegacao(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarExpressaoNegacao
	: ^(NEGACAO .)
		{
			mostrar("terminar ~");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

expressaoPrimaria
	: VALOR_BOOLEANO
		{
			mostrar($VALOR_BOOLEANO.text);
			escopoAtual.definirExpressao(new ExpressaoValorBooleano(escopoAtual, $VALOR_BOOLEANO.text));
		}
	| VALOR_NULO
		{
			mostrar($VALOR_NULO.text);
			escopoAtual.definirExpressao(new ExpressaoValorNulo(escopoAtual, $VALOR_NULO.text));
		}
	| CONSTANTE_INTEIRA
		{
			mostrar($CONSTANTE_INTEIRA.text);
			escopoAtual.definirExpressao(new ExpressaoConstanteInteira(escopoAtual, $CONSTANTE_INTEIRA.text));
		}
	| CONSTANTE_REAL
		{
			mostrar($CONSTANTE_REAL.text);
			escopoAtual.definirExpressao(new ExpressaoConstanteReal(escopoAtual, $CONSTANTE_REAL.text));
		}
	| LITERAL_CARACTERE
		{
			mostrar($LITERAL_CARACTERE.text);
			escopoAtual.definirExpressao(new ExpressaoLiteralCaractere(escopoAtual, $LITERAL_CARACTERE.text));
		}
	| LITERAL_TEXTO
		{
			mostrar($LITERAL_TEXTO.text);
			escopoAtual.definirExpressao(new ExpressaoLiteralTexto(escopoAtual, $LITERAL_TEXTO.text));
		}
	;

comando
	: ^(COMANDO_ . (.)*)
		{
			mostrar("comando");
			ExpressaoComando expressao = new ExpressaoComando(escopoAtual);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
		}
	;

terminarComando
	: ^(COMANDO_ . (.)*)
		{
			mostrar("terminarComando");
			escopoAtual = escopoAtual.fornecerEscopoPai();
			escoposDonos.pop();
		}
	;

referencia
	: ^(REFERENCIA_ ESSE)
		{
			mostrar($ESSE.text);
			ExpressaoReferencia expressao = new ExpressaoReferencia(escopoAtual, escopoAtual, $ESSE.text);
			escopoAtual.definirExpressao(expressao);
			escoposDonos.push(expressao);
		}
	| ^(REFERENCIA_ ESSA)
		{
			mostrar($ESSA.text);
			ExpressaoReferencia expressao = new ExpressaoReferencia(escopoAtual, escopoAtual, $ESSA.text);
			escopoAtual.definirExpressao(expressao);
			escoposDonos.push(expressao);
		}
	| ^(REFERENCIA_ IDENTIFICADOR)
		{
			mostrar($IDENTIFICADOR.text);
			ExpressaoReferencia expressao = new ExpressaoReferencia(escopoAtual, escopoAtual, $IDENTIFICADOR.text);
			escopoAtual.definirExpressao(expressao);
			escoposDonos.push(expressao);
		}
	;

referenciaDeMetodo
	: ^(REFERENCIA_ IDENTIFICADOR .+)
		{
			mostrar("referenciaDeMetodo");
			ExpressaoChamadaDeMetodo expressao = new ExpressaoChamadaDeMetodo(escopoAtual, escopoAtual, $IDENTIFICADOR.text);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
			escoposDonos.push(expressao);
		}
	;

terminarReferenciaDeMetodo
	: ^(REFERENCIA_ IDENTIFICADOR .+)
		{
			mostrar("terminarReferenciaDeMetodo");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

instanciacao
	: ^(INSTANCIACAO_ tipo .)
		{
			mostrar("instanciacao");
			ExpressaoInstanciacao expressao = new ExpressaoInstanciacao(escopoAtual, $tipo.tipo);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
			escoposDonos.push(expressao);
		}
	;

terminarInstanciacao
	: ^(INSTANCIACAO_ tipo .)
		{
			mostrar("terminarInstanciacao");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

chamada
	: ^((CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO) IDENTIFICADOR)
		{
			mostrar("." + $IDENTIFICADOR.text);
			ExpressaoReferencia expressao = new ExpressaoReferencia(escopoAtual, escoposDonos.pop(), $IDENTIFICADOR.text);
			escopoAtual.definirExpressao(expressao);
			escoposDonos.push(expressao);
		}
	;

chamadaDeMetodo
	: ^((CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO) IDENTIFICADOR .+)
		{
			mostrar("chamadaDeMetodo");
			ExpressaoChamadaDeMetodo expressao = new ExpressaoChamadaDeMetodo(escopoAtual, escoposDonos.pop(), $IDENTIFICADOR.text);
			escopoAtual.definirExpressao(expressao);
			escopoAtual = expressao;
			escoposDonos.push(expressao);
		}
	;

terminarChamadaDeMetodo
	: ^((CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO) IDENTIFICADOR .+)
		{
			mostrar("terminarChamadaDeMetodo");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

destruicao
	: ^(DESTRUICAO_ .)
		{
			mostrar("destrua");
			InstrucaoDestrua instrucao = new InstrucaoDestrua(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarDestruicao
	: ^(DESTRUICAO_ .)
		{
			mostrar("terminarDestruicao");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

retorno 
	: ^(RETORNO_ .)
		{
			mostrar("retorne");
			InstrucaoRetorne instrucao = new InstrucaoRetorne(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarRetorno
	: ^(RETORNO_ .)
		{
			mostrar("terminarRetorne");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

se
	: ^(SE_ . . .?)
		{
			mostrar("se");
			InstrucaoSe instrucao = new InstrucaoSe(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarSe
	: ^(SE_ . . .?)
		{
			mostrar("terminarSe");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

para
	: ^(PARA_ . . . .)
		{
			mostrar("para");
			InstrucaoPara instrucao = new InstrucaoPara(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarPara
	: ^(PARA_ . . . .)
		{
			mostrar("terminarPara");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

repita
	: ^(REPITA_ . . .)
		{
			mostrar("repita");
			InstrucaoRepita instrucao = new InstrucaoRepita(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarRepita
	: ^(REPITA_ . . .)
		{
			mostrar("terminarRepita");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

enquanto
	: ^(ENQUANTO_ . .)
		{
			mostrar("enquanto");
			InstrucaoEnquanto instrucao = new InstrucaoEnquanto(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarEnquanto
	: ^(ENQUANTO_ . .)
		{
			mostrar("terminarEnquanto");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

tente
	: ^(TENTE_ . .)
		{
			mostrar("tente");
			InstrucaoTente instrucao = new InstrucaoTente(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarTente
	: ^(TENTE_ . .)
		{
			mostrar("terminarTente");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

capture
	: ^(CAPTURE_ . .)
		{
			mostrar("capture");
			InstrucaoCapture instrucao = new InstrucaoCapture(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarCapture
	: ^(CAPTURE_ . .)
		{
			mostrar("terminarCapture");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

lance
	: ^(LANCE_ .)
		{
			mostrar("lance");
			InstrucaoLance instrucao = new InstrucaoLance(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
			escopoAtual = instrucao;
		}
	;

terminarLance
	: ^(LANCE_ .)
		{
			mostrar("terminarLance");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;

imprimir
	: IMPRIMIR
		{
			mostrar("imprimir");
			InstrucaoImprimir instrucao = new InstrucaoImprimir(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
		}
	;

depurar
	: DEPURAR
		{
			mostrar("depurar");
			InstrucaoDepurar instrucao = new InstrucaoDepurar(escopoAtual);
			escopoAtual.definirInstrucao(instrucao);
		}
	;

bloco
	: ^(INSTRUCOES_ (.)*)
		{
			mostrar("bloco");
			Bloco bloco = new Bloco(escopoAtual);
			escopoAtual.definirBloco(bloco);
			escopoAtual = bloco;
		}
	;

terminarBloco
	: ^(INSTRUCOES_ (.)*)
		{
			mostrar("terminarBloco");
			escopoAtual = escopoAtual.fornecerEscopoPai();
		}
	;
