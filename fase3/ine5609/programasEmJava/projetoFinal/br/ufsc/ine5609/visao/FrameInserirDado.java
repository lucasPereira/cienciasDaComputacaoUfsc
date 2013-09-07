package br.ufsc.ine5609.visao;

import java.awt.Font;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import br.ufsc.ine5609.controle.ControleDeInsercao;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Escolaridade;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;

public class FrameInserirDado extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaskFormatter mskCpf;
	private Font digitos = new Font("Arial",0,17);
	private NumberFormatter nf = new NumberFormatter();
	
	public FrameInserirDado(){
		initComponents();
		setVisible(true);
	}
	 private void initComponents() {
		 try {
				mskCpf = new MaskFormatter("###.###.###-##");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        jPanel3 = new javax.swing.JPanel();
	        jLabel7 = new javax.swing.JLabel();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();
	        jTextField3.setFont(digitos);
	        jFormattedTextField1 = new javax.swing.JFormattedTextField(mskCpf);
	        jFormattedTextField1.setFont(digitos);
	        jSeparator3 = new javax.swing.JSeparator();
	        jButton5 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();
	        jLabel10 = new javax.swing.JLabel();
	        jFormattedTextField2 = new javax.swing.JFormattedTextField(nf);
	        jFormattedTextField2.setFont(digitos);
	        jLabel11 = new javax.swing.JLabel();
	        jFormattedTextField3 = new javax.swing.JFormattedTextField();
	        jFormattedTextField3.setFont(digitos);
	        jLabel12 = new javax.swing.JLabel();
	        jComboBox1 = new javax.swing.JComboBox();
	        jComboBox1.setFont(digitos);
	        jLabel13 = new javax.swing.JLabel();
	        jFormattedTextField4 = new javax.swing.JFormattedTextField(nf);
	        jFormattedTextField4.setFont(digitos);
	        

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jPanel3.setBackground(java.awt.SystemColor.inactiveCaption);
	        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

	        jLabel7.setFont(new java.awt.Font("Arial", 1, 18));
	        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel7.setText("CADASTRO");

	        jLabel8.setFont(new java.awt.Font("Arial", 1, 20));
	        jLabel8.setText("Nome: ");

	        jLabel9.setFont(new java.awt.Font("Arial", 1, 20));
	        jLabel9.setText("Cpf: ");

	        jButton5.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
	        jButton5.setText("Cancelar");
	        ControleDeInsercao controleInsercao = new ControleDeInsercao(this);
	        jButton5.addActionListener(controleInsercao);
	        jButton5.setActionCommand("CANCELAR");
	        
	        jButton6.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
	        jButton6.setText("OK");
	        jButton6.addActionListener(controleInsercao);
	        

	        jLabel10.setFont(new java.awt.Font("Arial", 1, 20));
	        jLabel10.setText("Idade: ");

	        jLabel11.setFont(new java.awt.Font("Arial", 1, 20));
	        jLabel11.setText("Cidade: ");

	        jLabel12.setFont(new java.awt.Font("Arial", 1, 20));
	        jLabel12.setText("Escolaridade: ");

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
					"Sem Escolaridade", "Fundamental", "Medio", "Superior Inc.",
					"Superior" }));

	        jLabel13.setFont(new java.awt.Font("Arial", 1, 20));
	        jLabel13.setText("Salario: ");

	        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addGap(141, 141, 141)
	                .addComponent(jLabel7)
	                .addContainerGap(157, Short.MAX_VALUE))
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel10)
	                    .addComponent(jLabel8)
	                    .addComponent(jLabel9))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
	                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel11)
	                .addContainerGap(312, Short.MAX_VALUE))
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel12)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(112, Short.MAX_VALUE))
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel13)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(234, Short.MAX_VALUE))
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addGap(111, 111, 111)
	                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(104, Short.MAX_VALUE))
	        );
	        jPanel3Layout.setVerticalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel7)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel8)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel9))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel10)
	                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel11)
	                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel13)
	                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel12)
	                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton6)
	                    .addComponent(jButton5))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 404, Short.MAX_VALUE)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 284, Short.MAX_VALUE)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>
	 	private Escolaridade getEscolaridade(){
	 		if(Escolaridade.SEM_ESCOLARIDADE.ordinal() == jComboBox1.getSelectedIndex())
	 			return Escolaridade.SEM_ESCOLARIDADE;
	 		else if(Escolaridade.FUNDAMENTAL.ordinal() == jComboBox1.getSelectedIndex())
	 			return Escolaridade.FUNDAMENTAL;
	 		else if(Escolaridade.MEDIO.ordinal() == jComboBox1.getSelectedIndex())
	 			return Escolaridade.MEDIO;
	 		else if(Escolaridade.SUPERIOR_INCOMPLETO.ordinal() == jComboBox1.getSelectedIndex())
	 			return Escolaridade.SUPERIOR_INCOMPLETO;
	 		
	 		return Escolaridade.SUPERIOR;
	 	}
	 	public Pessoa getPessoa(){
	 		String auxCpf = jFormattedTextField1.getText();
	 		auxCpf = auxCpf.replace(".","");
	 		auxCpf = auxCpf.replace("-","");
	 		Long formatador = new Long(auxCpf);
	 		long cpf = formatador.longValue();
	 		String auxSalario = jFormattedTextField4.getText();
	 		auxSalario = auxSalario.replace(".","");
	 		auxSalario = auxSalario.replace(",",".");
	 		Pessoa p = new Pessoa(jTextField3.getText(),cpf,getEscolaridade(),Double.parseDouble(auxSalario),
	 				Integer.parseInt(jFormattedTextField2.getText()),jFormattedTextField3.getText());
	 		
	 		return p;
	 	}
	 	
	 	

	 	// Variables declaration - do not modify
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JComboBox jComboBox1;
	    private javax.swing.JFormattedTextField jFormattedTextField1;
	    private javax.swing.JFormattedTextField jFormattedTextField2;
	    private javax.swing.JFormattedTextField jFormattedTextField3;
	    private javax.swing.JFormattedTextField jFormattedTextField4;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel12;
	    private javax.swing.JLabel jLabel13;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JPanel jPanel3;
	    private javax.swing.JSeparator jSeparator3;
	    private javax.swing.JTextField jTextField3;
	    // End of variables declaration

	}
	
	
