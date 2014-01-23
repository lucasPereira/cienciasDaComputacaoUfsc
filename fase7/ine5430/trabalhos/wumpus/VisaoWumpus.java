import jason.environment.grid.GridWorldView;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public final class VisaoWumpus extends GridWorldView {
	public static final int LINHAS = 4;
	public static final int COLUNAS = 4;
	public static final int GUERREIRO = 1;
	public static final int WUMPUS = 256;
	public static final int BRISA = 16;
	public static final int CHEIRO = 32;
	public static final int OURO = 64;
	public static final int BURACO = 128;
	private ModeloWumpus modelo;
	private Font fontePadrao;

	public VisaoWumpus(ModeloWumpus modelo) {
		super(modelo, "Mundo Wumpus", 600);
		this.modelo = modelo;
		fontePadrao = new Font("Courier New", Font.BOLD, 18);
		setVisible(true);
		repaint();
	}

	@Override
	public void draw(Graphics grafico, int posicaoX, int posicaoY, int objeto) {
		if (objeto == BRISA) {
			desenharBrisa(grafico, posicaoX, posicaoY);
		} else if (objeto == CHEIRO) {
			desenharCheiro(grafico, posicaoX, posicaoY);
		} else if (objeto == OURO) {
			desenharOuro(grafico, posicaoX, posicaoY);
		} else if (objeto == BURACO) {
			desenharBuraco(grafico, posicaoX, posicaoY);
		} else if (objeto == WUMPUS) {
			desenharWumpus(grafico, posicaoX, posicaoY);
		}
	}

	@Override
	public void drawAgent(Graphics grafico, int posicaoX, int posicaoY, Color cor, int identificadorDoAgente) {
		if (identificadorDoAgente == GUERREIRO) {
			desenharGuerreiro(grafico, posicaoX, posicaoY);
		}
	}

	public void desenharGuerreiro(Graphics grafico, int posicaoX, int posicaoY) {
		grafico.setColor(Color.blue);
		drawString(grafico, posicaoX, posicaoY, fontePadrao, "G");
	}

	public void desenharWumpus(Graphics grafico, int posicaoX, int posicaoY) {
		grafico.setColor(Color.red);
		drawString(grafico, posicaoX, posicaoY, fontePadrao, "W    ");
	}

	public void desenharBrisa(Graphics grafico, int posicaoX, int posicaoY) {
		grafico.setColor(Color.gray);
		drawString(grafico, posicaoX, posicaoY, fontePadrao, "V        ");
	}

	public void desenharCheiro(Graphics grafico, int posicaoX, int posicaoY) {
		grafico.setColor(Color.magenta);
		drawString(grafico, posicaoX, posicaoY, fontePadrao, "C    ");
	}

	public void desenharOuro(Graphics grafico, int posicaoX, int posicaoY) {
		grafico.setColor(Color.orange);
		super.drawString(grafico, posicaoX, posicaoY, fontePadrao, "        O");
	}

	public void desenharBuraco(Graphics grafico, int posicaoX, int posicaoY) {
		grafico.setColor(Color.black);
		drawString(grafico, posicaoX, posicaoY, fontePadrao, "    B");
	}
}
