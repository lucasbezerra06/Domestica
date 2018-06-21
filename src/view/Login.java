package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.ControllUsuario;
import model.TiposUsuario;
import model.Usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwSenha;
	private ControllUsuario control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(12, 37, 74, 14);
		contentPane.add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(12, 55, 410, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 79, 74, 14);
		contentPane.add(lblSenha);
		
		pwSenha = new JPasswordField();
		pwSenha.setBounds(12, 97, 410, 20);
		contentPane.add(pwSenha);
		pwSenha.setColumns(10);
		
		JButton btnLogin = new JButton("Fazer Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(pwSenha.getPassword());
				control = new ControllUsuario();
				TiposUsuario tUsuario = new TiposUsuario();
				Usuarios usuario = control.logonSistema(txtUsuario.getText(),senha);
				if(senha != null && txtUsuario != null ) {
					if(usuario != null) {
						if(usuario.getTipoUsuario().getPermissao() != 9) {
							new PrincipalContratado(usuario);
							dispose();
						}else {
							new PrincipalAdmin(usuario);
							dispose();
						}
					}else {
					JOptionPane.showMessageDialog(null, "Senha Incorreta!", "ERRO!", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Informe seu usuario e senha!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
				/*tUsuario.setIdTipoUsuario(1);
				tUsuario.setPermissao(1);
				tUsuario.setTipoDescricao("Administrador");
				
				TiposUsuario tUsuario2 = new TiposUsuario();
				tUsuario2.setIdTipoUsuario(2);
				tUsuario2.setPermissao(2);
				tUsuario2.setTipoDescricao("Contratante");
				
				Usuarios usuario = new Usuarios();
				usuario.setNome("Roberto");
				usuario.setTipoUsuario(tUsuario);
				
				Usuarios usuario2 = new Usuarios();
				usuario2.setNome("Angelo");
				usuario2.setTipoUsuario(tUsuario2);
				String senha = new String(pwSenha.getPassword());
				if(senha != null && txtUsuario != null ) {
					if (txtUsuario.getText().equals(usuario.getNome()) && senha.equals("123456")) {
						new PrincipalAdmin(usuario);
						dispose();
					}else if(txtUsuario.getText().equals(usuario2.getNome()) && senha.equals("123456")) {
						new PrincipalContratado(usuario2);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha incorreta!", "ERRO!", JOptionPane.ERROR_MESSAGE);
						pwSenha.setText("");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Informe seu usuario e senha!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}*/
				
			}
		});
		btnLogin.setBounds(159, 145, 116, 23);
		contentPane.add(btnLogin);
	}

}
