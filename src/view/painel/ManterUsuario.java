package view.painel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataAccesInter.CidadesDAO;
import DataAccesInter.EstadoDAO;
import DataAccesInter.TipoUsuarioDAO;
import DataAccesInter.UsuariosDAO;
import DataAccess.CidadesDAOImpl;
import DataAccess.EstadosDAOImpl;
import DataAccess.TipoUsuarioDAOImpl;
import DataAccess.UsuarioDAOImpl;
import controller.ControllUsuario;
import javafx.scene.control.ComboBox;
import model.Cidades;
import model.Endereco;
import model.Estados;
import model.TiposUsuario;
import model.Usuarios;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ManterUsuario extends JPanel{
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtSaldo;
	private JTextField txtConta;
	private JTextField txtAgencia;
	private JTextField txtBanco;
	private JTextField txtCodBan;
	private JTextField txtCep;
	private JTextField txtLogra;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtCompl;
	JComboBox <TiposUsuario>cmbTipo;
	JComboBox<Cidades> cmbCidade;
	JComboBox<Estados> cmbEstado;
	private ControllUsuario control;
	private JPasswordField pswSenha;
	public ManterUsuario() {
		control = new ControllUsuario();
		JLabel lblNome = new JLabel("Nome");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		
		JLabel lblSaldo = new JLabel("Saldo");
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		
		JLabel lblContaCorrente = new JLabel("Conta Corrente");
		
		txtConta = new JTextField();
		txtConta.setColumns(10);
		
		JLabel lblAgencia = new JLabel("Agencia");
		
		txtAgencia = new JTextField();
		txtAgencia.setColumns(10);
		
		JLabel lblBanco = new JLabel("Banco");
		
		txtBanco = new JTextField();
		txtBanco.setColumns(10);
		
		JLabel lblCodBanco = new JLabel("Cod Banco");
		
		txtCodBan = new JTextField();
		txtCodBan.setColumns(10);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario");
		
		cmbTipo = new JComboBox();
		tipoComboBox();
		JLabel lblCep = new JLabel("CEP");
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		
		txtLogra = new JTextField();
		txtLogra.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		
		txtCompl = new JTextField();
		txtCompl.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		
		cmbCidade = new JComboBox<Cidades>();
		JLabel lblEstado = new JLabel("Estado");
		
		cmbEstado = new JComboBox<Estados>();
		estadoComboBox();
		cmbEstado.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					for(int i = 0; i<cmbCidade.getItemCount();i++) {
						cmbCidade.removeItemAt(i);
					}
					Estados estado = new Estados();
					estado = (Estados) cmbEstado.getSelectedItem();
					cidadeComboBox(estado.getIdEstados());
				}
				
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new SalvarAction());
		JButton btnLimpar = new JButton("Limpar");
		
		JLabel lblSenha = new JLabel("Senha");
		
		pswSenha = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(cmbTipo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblTipoDeUsuario))
								.addComponent(lblCpf)
								.addComponent(lblRg)
								.addComponent(lblSaldo)
								.addComponent(lblContaCorrente)
								.addComponent(lblSenha)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(pswSenha, Alignment.LEADING)
									.addComponent(txtConta, Alignment.LEADING)
									.addComponent(txtSaldo, Alignment.LEADING)
									.addComponent(txtRG, Alignment.LEADING)
									.addComponent(txtCPF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
							.addGap(69)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstado)
								.addComponent(lblCidade)
								.addComponent(lblComplemento)
								.addComponent(lblNmero)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cmbCidade, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtCompl, Alignment.LEADING)
										.addComponent(txtNumero, Alignment.LEADING)
										.addComponent(lblCep, Alignment.LEADING)
										.addComponent(txtCep, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
										.addComponent(lblLogradouro, Alignment.LEADING)
										.addComponent(txtLogra, Alignment.LEADING)
										.addComponent(lblBairro, Alignment.LEADING)
										.addComponent(txtBairro, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(56)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtAgencia)
											.addComponent(lblAgencia))
										.addComponent(lblCodBanco)
										.addComponent(lblBanco)
										.addComponent(txtBanco, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCodBan, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar)))
					.addGap(113))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTipoDeUsuario)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblCpf)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRg)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtRG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSaldo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblContaCorrente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAgencia)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblBanco)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBanco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblCodBanco)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCodBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCep)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblLogradouro)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtLogra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblBairro)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNmero)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblComplemento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCompl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(lblEstado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnLimpar))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	public void tipoComboBox() {
		TipoUsuarioDAO tdao = new TipoUsuarioDAOImpl();
		
		try {
			for(TiposUsuario t : tdao.read()) {
				cmbTipo.addItem(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cidadeComboBox(int idEstado) {
		CidadesDAO cdao = new CidadesDAOImpl();
		try {
			for(Cidades c : cdao.read(idEstado)) {
				cmbCidade.addItem(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void estadoComboBox() {
		try {
			for(Estados e : control.lerEstado()) {
				cmbEstado.addItem(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuarios boundaryToEntity() {
		Usuarios usuario = new Usuarios();
		usuario.setTipoUsuario((TiposUsuario)cmbTipo.getSelectedItem());
		usuario.setNome(txtNome.getText());
		usuario.setCpf(txtCPF.getText());
		usuario.setRg(txtRG.getText());
		usuario.setSaldo(Float.parseFloat(txtSaldo.getText()));
		usuario.setContaCorrente(txtConta.getText());
		usuario.setAgencia(txtAgencia.getText());
		usuario.setBanco(txtBanco.getText());
		usuario.setCodBanco(Integer.parseInt(txtCodBan.getText()));			
		Endereco endereco = new Endereco();
		endereco.setCep(txtCep.getText());
		endereco.setLogradouro(txtLogra.getText());
		endereco.setBairro(txtBairro.getText());
		endereco.setNumero(Integer.parseInt(txtNumero.getText()));
		endereco.setComplemento(txtCompl.getText());
		usuario.setEnderecos(endereco);
		usuario.setSenha(new String(pswSenha.getPassword()));
		return usuario;
	}
	
	private class SalvarAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				control.inserir(boundaryToEntity());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
