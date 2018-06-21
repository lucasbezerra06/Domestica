package view.painel;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ControllServicos;
import controller.ListaServControl;
import model.Servicos;
import model.Usuarios;

import javax.swing.JButton;

public class ListaServicos extends JPanel {
	private JTable table;
	private Usuarios usuario;
	private List<Servicos> servicos;

	/**
	 * Create the panel.
	 */
	public ListaServicos(Usuarios usurio) {
		usuario = new Usuarios();
		this.usuario = usurio;
		
		System.out.println(usuario.getServicosPrestrados().size());
		
		JLabel lblSelecioneUmServio = new JLabel("Selecione um servi\u00E7o e clique em salvar.");
		
			ListaServControl model = new ListaServControl();

	        servicos = new ControllServicos().read();
			for(int i = 0;i < servicos.size();i++) {
				model.addRow(new Object[]{servicos.get(i), false});
			}
		
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
					usuario.setServicosPrestrados(servicos.get(i));
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
