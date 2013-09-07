package br.ufsc.ine5609.visao;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import br.ufsc.ine5609.controle.ControleDoAtualizadorDeTabela;
import br.ufsc.ine5609.controle.ControleDeCarregamentoDeDados;
import br.ufsc.ine5609.controle.ControleDeBuscas;
import br.ufsc.ine5609.controle.ControleDoFrameInserirDado;
import br.ufsc.ine5609.controle.ControleDeRemocaoDeDados;
import br.ufsc.ine5609.modelo.ListaDePessoas;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeTabela;

public class FrameInicial extends JFrame implements ChangeListener {
	private static final long serialVersionUID = 1L;

	public FrameInicial() {
		super(
				"ESTRUTURAS DE DADOS 2011/1    "
						+ (new java.text.SimpleDateFormat("dd/MM/yyyy")
								.format(new java.util.Date(System
										.currentTimeMillis())) + "          VERSAO 1.0.1"));
		Toolkit t = this.getToolkit();
		Dimension d = t.getScreenSize();
		Point p = new Point(d.width / 2 - 400, d.height / 2 - 200);
		this.setLocation(p);
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jButton1.setFocusable(false);
		jButton2 = new javax.swing.JButton();
		jButton2.setFocusable(false);
		jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jButton3 = new javax.swing.JButton();
		jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jButton3.setFocusable(false);
		jButton4 = new javax.swing.JButton();
		jButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jButton4.setFocusable(false);
		jButton5 = new javax.swing.JButton();
		jButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jButton5.setFocusable(false);
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton1.setFocusable(false);
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});
		jRadioButton2 = new javax.swing.JRadioButton();
		jRadioButton2.setFocusable(false);
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox1.setEnabled(false);
		jSlider1 = new javax.swing.JSlider();
		jSlider1.setEnabled(false);
		jSlider1.setMinimum(1);
		jSlider1.setMaximum(120);
		jLabel2 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton3.setFocusable(false);
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});
		jTextField1 = new javax.swing.JTextField();
		jTextField1.setEnabled(false);
		jRadioButton4 = new javax.swing.JRadioButton();
		jRadioButton4.setFocusable(false);
		jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton4ActionPerformed(evt);
			}
		});
		jComboBox2 = new javax.swing.JComboBox();
		jComboBox2.setEnabled(false);
		jComboBox3 = new javax.swing.JComboBox();
		jSlider1.addChangeListener(this);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(51, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		jLabel1.setText("GERENCIADOR DE DADOS");

		jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor(
				"Button.disabledForeground"));
		jButton1.setText("INSERIR DADOS");
		jButton1.addActionListener(new ControleDoFrameInserirDado());

		jButton2.setBackground(javax.swing.UIManager.getDefaults().getColor(
				"Button.disabledForeground"));
		jButton2.setText("CARREGAR DADOS");
		jButton2.addActionListener(new ControleDeCarregamentoDeDados());

		jButton3.setBackground(javax.swing.UIManager.getDefaults().getColor(
				"Button.disabledForeground"));
		jButton3.setText("BUSCAR");
		jButton3.addActionListener(new ControleDeBuscas(this));

		jButton4.setBackground(javax.swing.UIManager.getDefaults().getColor(
				"Button.disabledForeground"));
		jButton4.setText("REMOVER");
		jButton4.addActionListener(new ControleDeRemocaoDeDados(this));
		
		jButton5.setBackground(javax.swing.UIManager.getDefaults().getColor(
		"Button.disabledForeground"));
		jButton5.setText("<< VOLTAR");
		jButton5.addActionListener(new ControleDoAtualizadorDeTabela());

		jRadioButton1.setBackground(new java.awt.Color(0, 255, 255));
		jRadioButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		jRadioButton1.setText("ESCOLARIDADE: ");

		jRadioButton2.setBackground(new java.awt.Color(0, 255, 255));
		jRadioButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		jRadioButton2.setText("IDADE: ");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Sem Escolaridade", "Fundamental", "Medio", "Superior Inc.",
				"Superior" }));
		jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

		jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel2.setText("50");

		jRadioButton3.setBackground(new java.awt.Color(0, 255, 255));
		jRadioButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		jRadioButton3.setText("CIDADE: ");

		jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jTextField1.setText("");

		jRadioButton4.setBackground(new java.awt.Color(0, 255, 255));
		jRadioButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		jRadioButton4.setText("SALARIO: ");

		jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
		jLabel3.setText("BUSCA");

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"0 <= x < 1000", "1000 <= x < 2000", "2000 <= x < 3000",
				"3000 <= x < 4000", "4000 <= x < 5000", "5000 <= x < 6000",
				"6000 <= x < 7000", "7000 <= x < 8000", "8000 <= x < 9000",
				"9000 <= x < 10000", "x >= 10000" }));

		// Carrega atualizador da tabela
		AtualizadorDeTabela.getInstance().setTable(jTable1);
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox3, 0, 239, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 203, Short.MAX_VALUE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, 203, Short.MAX_VALUE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel3))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(308, 308, 308))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton2)
                                .addComponent(jLabel2))
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSlider jSlider1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;

	// End of variables declaration

	public int getChaveEscolaridade() {
		return jComboBox1.getSelectedIndex();
	}

	public int getChaveIdade() {
		return jSlider1.getValue();
	}

	public double getChaveSalario() {
		String valorSelecionado = jComboBox2.getSelectedItem().toString();
		String[] valores = valorSelecionado.split(" <= x < ");
		double valor = Double.MAX_VALUE;
		if (valores[0].compareTo("x >= 10000") != 0) {
			valor = Double.parseDouble(valores[0]);
		}

		return valor;
	}

	public String getChaveCidade() {
		return jTextField1.getText();
	}

	public boolean buscarEscolaridade() {
		return jRadioButton1.isSelected();
	}

	public boolean buscarIdade() {
		return jRadioButton2.isSelected();
	}

	public boolean buscarCidade() {
		return jRadioButton3.isSelected();
	}

	public boolean buscarSalario() {
		return jRadioButton4.isSelected();
	}

	public void stateChanged(ChangeEvent e) {
		jLabel2.setText("" + jSlider1.getValue());
	}

	private void jRadioButton1ActionPerformed(ActionEvent evt) {
		if (jRadioButton1.isSelected())
			jComboBox1.setEnabled(true);
		else
			jComboBox1.setEnabled(false);
	}

	private void jRadioButton2ActionPerformed(ActionEvent evt) {
		if (jRadioButton2.isSelected())
			jSlider1.setEnabled(true);
		else
			jSlider1.setEnabled(false);
	}

	private void jRadioButton3ActionPerformed(ActionEvent evt) {
		if (jRadioButton3.isSelected())
			jTextField1.setEnabled(true);
		else
			jTextField1.setEnabled(false);
	}

	private void jRadioButton4ActionPerformed(ActionEvent evt) {
		if (jRadioButton4.isSelected())
			jComboBox2.setEnabled(true);
		else
			jComboBox2.setEnabled(false);
	}

	public void atualizarListaDePessoas() {
		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(ListaDePessoas
				.fornecerInstancia().fornecerArrayComAsPessoas()));
	}

	public Pessoa fornecerPessoaParaRemover() {
		return (Pessoa) jComboBox3.getSelectedItem();
	}

}
