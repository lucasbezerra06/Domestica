package view.painel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Servicos;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarServicos extends JPanel {
	private JTextField txtServico;
	private JTextField txtValor;
	private JTextArea textADescricao;

	/**
	 * Create the panel.
	 */
	public CadastrarServicos() {
		
		JLabel lblServico = new JLabel("Servico:");
		
		txtServico = new JTextField();
		txtServico.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		
		JLabel lblValor = new JLabel("Valor:");
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ConfirmAction());
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblServico)
								.addComponent(lblDescrio)
								.addComponent(lblValor))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtServico, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
									.addGap(27))
								.addComponent(txtValor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(203)
							.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(227)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblServico))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescrio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValor))
					.addGap(35)
					.addComponent(btnConfirmar)
					.addGap(20))
		);
		
		textADescricao = new JTextArea();
		scrollPane.setViewportView(textADescricao);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(groupLayout);

	}
	private class ConfirmAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Servicos servico = new Servicos();
			servico.setNome(txtServico.getText());
			servico.setDescricao(textADescricao.getText());
			servico.setValor(Integer.parseInt(txtValor.getText()));
			
			System.out.println(servico.toString());
			
		}
		
	}

}


