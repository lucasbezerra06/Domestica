package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logout;
import model.Usuarios;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import view.painel.CadastrarServicos;
import view.painel.ManterUsuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class PrincipalAdmin extends JFrame{
	private Usuarios usuario;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JScrollPane scrollPane;
	private JMenu mnServios;
	private JMenu mnUsuario;
	private JMenuItem mntmInserir;
	private JMenuItem mntmLogout;
	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAdmin frame = new PrincipalAdmin(new Usuarios());
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
	public PrincipalAdmin(Usuarios usuario) {
		super(usuario.getNome());
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 405);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		mntmInserir = new JMenuItem("Inserir");
		mntmInserir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				trocarPainel("Inserir Usuarios", new ManterUsuario());
			}
		});
		mnUsuario.add(mntmInserir);
		
		mnServios = new JMenu("Servi\u00E7os");
		menuBar.add(mnServios);
		
		JMenuItem mntmCadServ = new JMenuItem("Inserir");
		mnServios.add(mntmCadServ);
		
		mntmLogout = new JMenuItem("LOGOUT");
		mntmLogout.addActionListener(new Logout(this));
		menuBar.add(mntmLogout);
		mntmCadServ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trocarPainel("Cadastro de Serviços", new CadastrarServicos());
				
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		scrollPane = new JScrollPane();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(scrollPane);
		
		JPanel panelTop = new JPanel();
		scrollPane.setColumnHeaderView(panelTop);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setVisible(false);
		panelTop.add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.setVisible(true);
	
		
		
		
	}
	private void trocarPainel(String Titulo,JPanel painel) {
		setTitle("..::   "+Titulo+"   ::..");
		lblTitulo.setText(Titulo);
		lblTitulo.setVisible(true);
		scrollPane.setViewportView(painel);
		scrollPane.repaint();
	}
}
