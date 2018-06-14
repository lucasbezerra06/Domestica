package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.Login;

public class Logout implements ActionListener{
	JFrame tela;
	public Logout(JFrame tela) {
		this.tela = tela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Login().setVisible(true);
		tela.dispose();
		
	}

}
