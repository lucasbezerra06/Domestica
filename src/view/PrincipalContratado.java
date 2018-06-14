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

import view.painel.AvaliacServico;
import view.painel.ListaServicos;
import view.painel.ServicosAgendados;


import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class PrincipalContratado extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JScrollPane scrollPane;
	private JMenu mnServios;
	private JMenuItem mntmServiosAgendados;
	private JMenuItem mntmAvaliao;
	private JMenuItem mntmDefServ;
	private Usuarios usuario;
	private JMenuItem mntmLogout;
	/*
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalContratado frame = new PrincipalContratado(new Usuarios());
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
	public PrincipalContratado(Usuarios usuario) {
		super(usuario.getNome());
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 405);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnServios = new JMenu("Servi\u00E7os");
		menuBar.add(mnServios);
		
		mntmDefServ = new JMenuItem("Definir");
		mnServios.add(mntmDefServ);
		
		mntmServiosAgendados = new JMenuItem("Agendados");
		mnServios.add(mntmServiosAgendados);
		
		mntmAvaliao = new JMenuItem("Avalia\u00E7\u00E3o");
		mnServios.add(mntmAvaliao);
		
		mntmLogout = new JMenuItem("LOGOUT");
		menuBar.add(mntmLogout);
		mntmLogout.addActionListener(new Logout(this));
		
		mntmServiosAgendados.addActionListener(this);
		mntmDefServ.addActionListener(this);
		mntmAvaliao.addActionListener(this);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		if(cmd.equals("Definir")){
			trocarPainel("Lista de Serviços", new ListaServicos());
		}
		else if(cmd.equals("Agendados")) {
			trocarPainel("Serviços Agendados", new ServicosAgendados());
		}
		else if(cmd.equals("Avaliação")) {
			trocarPainel("Avalie o Serviço", new AvaliacServico());
		}
	}
	
	private void trocarPainel(String Titulo,JPanel painel) {
		setTitle("..::   "+Titulo+"   ::..");
		lblTitulo.setText(Titulo);
		lblTitulo.setVisible(true);
		scrollPane.setViewportView(painel);
		scrollPane.repaint();
	}
}
