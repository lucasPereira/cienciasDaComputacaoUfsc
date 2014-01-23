import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.environment.Environment;

public final class AmbienteWumpus extends Environment {
	private static final String GUERREIRO = "guerreiro";
	private static final Term VIRAR_PARA_ESQUERDA = Literal.parseLiteral("virar(esquerda)");
	private static final Term VIRAR_PARA_DIREITA = Literal.parseLiteral("virar(direita)");
	private static final Term VIRAR_ALEATORIO = Literal.parseLiteral("virar(aleatorio)");
	private static final Term ANDAR = Literal.parseLiteral("andar");
	private static final Term ATIRAR = Literal.parseLiteral("atirar");
	private static final Term PEGAR_OURO = Literal.parseLiteral("pegar(ouro)");
	private static final Term SOLTAR_OURO = Literal.parseLiteral("soltar(ouro)");
	private static final Term SAIR = Literal.parseLiteral("sair");
	private MundoWumpus mundoWumpus;
	private ModeloWumpus modelo;
	private VisaoWumpus visao;

	@Override
	public void init(String[] argumentos) {
		mundoWumpus = new MundoWumpus();
		modelo = new ModeloWumpus(mundoWumpus);
		visao = new VisaoWumpus(modelo);
		atualizarPercepcoes();
	}

	@Override
	public boolean executeAction(String agente, Structure acao) {
		if (agente.equals(GUERREIRO)) {
			if (acao.equals(VIRAR_PARA_ESQUERDA)) {
				mundoWumpus.guerreiroVirarParaEsquerda();
			} else if (acao.equals(VIRAR_PARA_DIREITA)) {
				mundoWumpus.guerreiroVirarParaDireita();
			} else if (acao.equals(VIRAR_ALEATORIO)) {
				mundoWumpus.guerreiroVirarAleatorio();
			} else if (acao.equals(ANDAR)) {
				mundoWumpus.guerreiroAndar();
			} else if (acao.equals(ATIRAR)) {
				Boolean matouWumpus = mundoWumpus.guerreiroAtirar();
				if (matouWumpus) {
					modelo.removerWumpus();
				}
			} else if (acao.equals(PEGAR_OURO)) {
				Boolean pegouOuro = mundoWumpus.guerreiroPegarOuro();
				if (pegouOuro) {
					modelo.removerOuro();
				}
			} else if (acao.equals(SAIR)) {
				mundoWumpus.guerreiroSair();
			}
		}
		mostrarAcao(agente, acao);
		atualizarPercepcoes();
		esperar();
		return true;
	}

	private void esperar() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException excecao) {

		}
	}

	private void mostrarAcao(String agente, Structure acao) {
		System.out.println(String.format("Recebendo ação %s do agente %s.", acao.toString(), agente));
	}

	private void atualizarPercepcoes() {
		clearPercepts(GUERREIRO);
		clearPercepts();
		mundoWumpus.atualizarPercepcoes(this);
		modelo.atualizarPercepcoes();
	}
}
