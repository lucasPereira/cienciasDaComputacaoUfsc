tree grammar CanecaArvore;

options {
	ASTLabelType = CommonTree;
	backtrack = false;
	language = Java;
	k = 1;
	output = AST;
	tokenVocab = CanecaSintatico;
}

tokens {
	ARGUMENTOS_;
	ASSINATURA_;
	ASSINATURA_DE_METODO_;
	ASSINATURAS_DE_METODOS_;
	ATRIBUICAO_;
	ATRIBUTO_;
	ATRIBUTOS_;
	CABECALHO_;
	CAPTURAS_;
	CAPTURE_;
	CHAMADA_DE_CLASSE_;
	CHAMADA_DE_OBJETO_;
	CLASSE_;
	COMANDO_;
	CONSTRUTOR_;
	CONSTRUTORES_;
	CORPO_;
	DECLARACAO_;
	DECLARACAO_COM_ATRIBUICAO_OPICIONAL_;
	DESTRUICAO_;
	DESTRUTOR_;
	DESTRUTORES_;
	ENQUANTO_;
	EXPRESSAO_;
	IMPORTACAO_;
	IMPORTACOES_;
	INTERFACE_;
	INSTANCIACAO_;
	INSTRUCOES_;
	INTERFACES_;
	LANCE_;
	METODO_;
	METODOS_;
	PACOTE_;
	PARA_;
	PARAMETROS_;
	PRIMARIA_;
	PROGRAMA_;
	REFERENCIA_;
	REPITA_;
	RETORNO_;
	SE_;
	SELECAO_;
	NEGATIVACAO_;
	TENTE_;
	TIPO_;
	TIPO_GENERICO_;
	TIPOS_;
	TIPOS_GENERICOS_;
	UNIDADE_;
}


@header {
	package br.ufsc.inf.ine5426.caneca.antlr;
}

@members {
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
}

@rulecatch {
	catch (RecognitionException erro) {
		throw erro;
	}
}

programa
	: (unicadeDeCompilacao)+ -> ^(PROGRAMA_ (unicadeDeCompilacao)+)
	;

unicadeDeCompilacao
	: cabecalho
		( classe -> ^(UNIDADE_ cabecalho classe)
		| interfaces -> ^(UNIDADE_ cabecalho interfaces)
		)
	;

cabecalho
	: pacote importacoes -> ^(CABECALHO_ pacote importacoes)
	;

pacote
	: PACOTE IDENTIFICADOR_DE_PACOTE TERMINADOR -> ^(PACOTE_ IDENTIFICADOR_DE_PACOTE)
	;

importacoes
	: (importacao)* -> ^(IMPORTACOES_ (importacao)*)
	;

importacao
	: IMPORTE
		( IDENTIFICADOR IDENTIFICADOR_DE_PACOTE (COMO IDENTIFICADOR)? -> ^(IMPORTACAO_ IDENTIFICADOR IDENTIFICADOR_DE_PACOTE (IDENTIFICADOR)?)
		| IDENTIFICADOR_DE_PACOTE -> ^(IMPORTACAO_ IDENTIFICADOR_DE_PACOTE)
		) TERMINADOR
	;

classe
	: CLASSE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse -> ^(CLASSE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaClasse)
	;

interfaces
	: INTERFACE modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface -> ^(INTERFACE_ modificadorDeAcessoFeminino IDENTIFICADOR listaDeTiposGenericos listaDeInterfaces corpoDaInterface)
	;

corpoDaClasse
	: INICIO atributos construtores destrutor metodos FIM -> ^(CORPO_ atributos construtores destrutor metodos)
	;

corpoDaInterface
	: INICIO atributos assinaturasDeMetodos FIM -> ^(CORPO_ atributos assinaturasDeMetodos)
	;

atributos
	: (atributo)* -> ^(ATRIBUTOS_ (atributo)*)
	;

construtores
	: (construtor)+ -> ^(CONSTRUTORES_ (construtor)+)
	;

metodos
	: (metodo)* -> ^(METODOS_ (metodo)*)
	;

assinaturasDeMetodos
	: (assinaturaDeMetodo TERMINADOR)* -> ^(ASSINATURAS_DE_METODOS_ (assinaturaDeMetodo)*)
	;

atributo
	: ATRIBUTO modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR 
		( -> ^(ATRIBUTO_ modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR)
		| ATRIBUIDOR expressaoOuLogico -> ^(ATRIBUTO_ modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR) ^(ATRIBUIDOR ^(PRIMARIA_ ^(COMANDO_ ^(REFERENCIA_ IDENTIFICADOR)))  expressaoOuLogico)
		) TERMINADOR
	;

construtor
	: assinaturaDeConstrutor blocoDeInstrucoes -> ^(CONSTRUTOR_ assinaturaDeConstrutor blocoDeInstrucoes)
	;

destrutor
	: assinaturaDeDestrutor blocoDeInstrucoes -> ^(DESTRUTOR_ assinaturaDeDestrutor blocoDeInstrucoes)
	;

metodo
	: assinaturaDeMetodo blocoDeInstrucoes -> ^(METODO_ assinaturaDeMetodo blocoDeInstrucoes)
	;

assinaturaDeConstrutor
	: CONSTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos -> ^(ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentos)
	;

assinaturaDeDestrutor
	: DESTRUTOR modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia -> ^(ASSINATURA_ modificadorDeAcessoMasculino IDENTIFICADOR listaDeArgumentosVazia)
	;

assinaturaDeMetodo
	: METODO modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR listaDeArgumentos -> ^(ASSINATURA_ modificadorDeAcessoMasculino (ESTATICO)? tipo IDENTIFICADOR listaDeArgumentos)
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
	: PARENTESE_ESQUERDO (expressao (SEPARADOR expressao)*)? PARENTESE_DIREITO -> ^(PARAMETROS_ (expressao)*)
	;

listaDeArgumentosVazia
	: PARENTESE_ESQUERDO PARENTESE_DIREITO -> ^(ARGUMENTOS_)
	;

listaDeArgumentos
	: PARENTESE_ESQUERDO (declaracao (SEPARADOR declaracao)*)? PARENTESE_DIREITO -> ^(ARGUMENTOS_ (declaracao)*)
	;

listaDeInterfaces
	: (IMPLEMENTA tipo (SEPARADOR tipo)*)? -> ^(INTERFACES_ (tipo)*)
	;

listaDeTiposGenericos
	: (COLCHETE_ESQUERDO tipoGenerico COLCHETE_DIREITO)* -> ^(TIPOS_GENERICOS_ (tipoGenerico)*)
	;

listaDeTipos
	: (COLCHETE_ESQUERDO tipo (SEPARADOR tipo)* COLCHETE_DIREITO)? -> ^(TIPOS_ (tipo)*)
	;

listaDeCapturas
	: (capture)+ -> ^(CAPTURAS_ (capture)+)
	;

tipoGenerico
	: IDENTIFICADOR listaDeInterfaces -> ^(TIPO_GENERICO_ IDENTIFICADOR listaDeInterfaces)
	;

tipo
	: IDENTIFICADOR listaDeTipos -> ^(TIPO_ IDENTIFICADOR listaDeTipos)
	;

declaracao
	: tipo IDENTIFICADOR -> ^(DECLARACAO_ tipo IDENTIFICADOR)
	;

declaracaoComAtribuicaoOpcional
	: tipo IDENTIFICADOR 
		( -> ^(DECLARACAO_ tipo IDENTIFICADOR)
		| ATRIBUIDOR expressaoOuLogico -> ^(DECLARACAO_ tipo IDENTIFICADOR) ^(ATRIBUIDOR ^(PRIMARIA_ ^(COMANDO_ ^(REFERENCIA_ IDENTIFICADOR))) expressaoOuLogico)
		)
	;

expressao
	: expressaoOuLogico (ATRIBUIDOR^ expressaoOuLogico)?
	;

expressaoOuLogico
	: expressaoELogico (OU^ expressaoELogico)*
	;

expressaoELogico
	: expressaoComparacaoLogica (E^ expressaoComparacaoLogica)*
	;

expressaoComparacaoLogica
	: expressaoAditiva ((IGUAL | DIFERENTE | MAIOR | MAIOR_IGUAL | MENOR | MENOR_IGUAL)^ expressaoAditiva)?
	;

expressaoAditiva
	: expressaoMultiplicativa ((SOMA | SUBTRACAO)^ expressaoMultiplicativa)*
	;

expressaoMultiplicativa
	: expressaoUnaria ((MULTIPLICACAO | DIVISAO | RESTO_DA_DIVISAO)^ expressaoUnaria)*
	;

expressaoUnaria
	: expressaoPrimaria
	| SUBTRACAO expressaoPrimaria -> ^(NEGATIVACAO_ expressaoPrimaria)
	| NEGACAO expressaoPrimaria -> ^(NEGACAO expressaoPrimaria)
	;

expressaoPrimaria
	: PARENTESE_ESQUERDO expressao PARENTESE_DIREITO -> expressao
	| VALOR_BOOLEANO
	| VALOR_NULO
	| CONSTANTE_INTEIRA
	| CONSTANTE_REAL
	| LITERAL_CARACTERE
	| LITERAL_TEXTO
	| comando
	;

comando
	: referencia (chamada)* -> ^(COMANDO_ referencia (chamada)*)
	;

referencia
	: ESSE -> ^(REFERENCIA_ ESSE)
	| ESSA -> ^(REFERENCIA_ ESSA)
	| instanciacao -> ^(REFERENCIA_ instanciacao)
	| IDENTIFICADOR (listaDeParametros)? -> ^(REFERENCIA_ IDENTIFICADOR (listaDeParametros)?)
	;

chamada
	: (CHAMADA_DE_CLASSE | CHAMADA_DE_OBJETO)^ IDENTIFICADOR (listaDeParametros)?
	;

instanciacao
	: (NOVO | NOVA) tipo listaDeParametros -> ^(INSTANCIACAO_ tipo listaDeParametros)
	;

destruicao
	: DESTRUA expressao -> ^(DESTRUICAO_ expressao)
	;

retorno 
	: RETORNE expressao -> ^(RETORNO_ expressao)
	;

se
	: SE PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes (SENAO blocoDeInstrucoes)? -> ^(SE_ expressao blocoDeInstrucoes blocoDeInstrucoes?)
	;

para
	: PARA PARENTESE_ESQUERDO expressao TERMINADOR expressao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^(PARA_ expressao expressao expressao blocoDeInstrucoes)
	;

repita
	: REPITA PARENTESE_ESQUERDO declaracao TERMINADOR expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^(REPITA_ declaracao expressao blocoDeInstrucoes)
	;

enquanto
	: ENQUANTO PARENTESE_ESQUERDO expressao PARENTESE_DIREITO blocoDeInstrucoes -> ^(ENQUANTO_ expressao blocoDeInstrucoes)
	;

tente
	: TENTE blocoDeInstrucoes listaDeCapturas -> ^(TENTE_ blocoDeInstrucoes listaDeCapturas)
	;

capture
	: CAPTURE PARENTESE_ESQUERDO declaracao PARENTESE_DIREITO blocoDeInstrucoes -> ^(CAPTURE_ declaracao blocoDeInstrucoes)
	;

lance
	: LANCE expressao -> ^(LANCE_ expressao)
	;

instrucao 
	:
	( options {k = 2;}
		: expressao TERMINADOR!
		| declaracaoComAtribuicaoOpcional TERMINADOR!
	)
	| IMPRIMIR TERMINADOR!
	| DEPURAR TERMINADOR!
	| destruicao TERMINADOR!
	| retorno TERMINADOR!
	| se
	| para
	| repita
	| enquanto
	| tente
	| lance TERMINADOR!
	;

blocoDeInstrucoes
	: INICIO (instrucao)* FIM -> ^(INSTRUCOES_ (instrucao)*)
	;

