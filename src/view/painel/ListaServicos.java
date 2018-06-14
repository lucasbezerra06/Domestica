package view.painel;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ListaServControl;
import model.Servicos;
import model.Usuarios;

import javax.swing.JButton;

public class ListaServicos extends JPanel {
	private JTable table;
	private Usuarios usuario;
	private Servicos servicos[] = new Servicos[4];

	/**
	 * Create the panel.
	 */
	public ListaServicos() {
		for(int i = 0;i < 4;i++) {
			servicos[i] = new Servicos();
		}
		usuario = new Usuarios();
		usuario.setNome("Lucas");
		usuario.setIdUsuarios(4);
		System.out.println(usuario.getServicosPrestrados().size());
		
		servicos[0].setNome("Passar Roupa");
		servicos[1].setNome("Lavar Roaupa");
		servicos[2].setNome("Limpeza leve");
		servicos[3].setNome("Limpeza passada");
		
		JLabel lblSelecioneUmServio = new JLabel("Selecione um servi\u00E7o e clique em salvar.");
		
			ListaServControl model = new ListaServControl();
	        model.addRow(new Object[]{servicos[0].getNome(), false});
	        model.addRow(new Object[]{servicos[1].getNome(), false});
	        model.addRow(new Object[]{servicos[2].getNome(), false});
	        model.addRow(new Object[]{servicos[3].getNome(), false});
		
		table = new JTable(model);
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new SalvarAction());
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelecioneUmServio)
						.addComponent(btnSalvar)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelecioneUmServio)
					.addGap(12)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSalvar)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private class SalvarAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0;i < table.getRowCount(); i++) {
				if (((Boolean)table.getValueAt(i, 1))){
					usuario.setServicosPrestrados(servicos[i]);
				}
		}
			System.out.println("\n\nServicos de "+usuario.getNome()+": ");
			Set<Servicos> listServico = usuario.getServicosPrestrados();
			for(Servicos servico : listServico){
			    System.out.println (servico.getNome()); 
			}
		}
		
	}
}
