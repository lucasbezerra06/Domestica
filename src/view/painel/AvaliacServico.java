package view.painel;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

import model.Avaliacoes;

import javax.swing.event.ChangeEvent;

public class AvaliacServico extends JPanel {

	/**
	 * Create the panel.
	 */
	private JSlider slider;
	private int Nota;
	private JLabel lblNota;
	private JTextArea textAvaliacao;
	public AvaliacServico() {
		
		JLabel lblTitulo = new JLabel("Diga o que voc\u00EA achou do servi\u00E7o executado:");

		JScrollPane scrollPane = new JScrollPane();
		
		slider = new JSlider(JSlider.HORIZONTAL, 0,5,0);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Nota = slider.getValue();
				lblNota .setText("Nota: "+Nota);
				
			}
		});
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ConfirmAction());
		lblNota = new JLabel();
		lblNota.setText("Nota: "+Nota);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblTitulo)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirmar)
						.addComponent(lblNota))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNota)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnConfirmar)
					.addContainerGap())
		);
		
		textAvaliacao = new JTextArea();
		scrollPane.setViewportView(textAvaliacao);
		setLayout(groupLayout);

	}
	private class ConfirmAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Avaliacoes avaliacao = new Avaliacoes();
			avaliacao.setAvaliacaoText(textAvaliacao.getText());
			avaliacao.setAvaliacao(Nota);
			System.out.println(avaliacao.toString());
		}
		
	}
}
