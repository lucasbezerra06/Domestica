package view.painel;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ServAgenControl;

import javax.swing.JButton;

public class ServicosAgendados extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ServicosAgendados() {
		
		JLabel lblListaDeServios = new JLabel("Lista de servi\u00E7os agendados:(confirme os servi\u00E7os e clique em agendar)");
		ServAgenControl model = new ServAgenControl();
        model.addRow(new Object[]{"Rua Fritz Jank",21,"Pq Novo Mundo","Sr.Leonardo",true});
        model.addRow(new Object[]{"Rua Jardim das Margaridas",317,"Vila Buenos Aires","Sr.Lucas",true});
        model.addRow(new Object[]{"Rua Prates",456,"Bom Ratiro","Sr.Vanessa",true});
		table = new JTable(model);
		
		JButton btnSalvar = new JButton("Salvar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListaDeServios)
						.addComponent(btnSalvar))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListaDeServios)
					.addGap(12)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSalvar)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
