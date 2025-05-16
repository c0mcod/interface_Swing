package br.com.cadastro.functions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.cadastro.dao.CadastroDAO;
import br.com.cadastro.model.Cadastro;

public class CadastrarUsers {
	@SuppressWarnings("static-access")
	public void CadastrarUsuarios() {
		Cadastro cadastro = new Cadastro();
		CadastroDAO dao = new CadastroDAO();

		JFrame JCadastro = new JFrame();
		JCadastro.setSize(600, 200);
		JCadastro.setLayout(new FlowLayout());
		JCadastro.setTitle("cadastro");
		JCadastro.setDefaultCloseOperation(JCadastro.DISPOSE_ON_CLOSE);
		JLabel labelNome = new JLabel("Nome");
		JTextField nome = new JTextField(20);
		JLabel labelEmail = new JLabel("Email");
		JTextField email = new JTextField(20);
		JButton enviar = new JButton("Enviar");

		JCadastro.add(labelNome);
		JCadastro.add(nome);
		JCadastro.add(labelEmail);
		JCadastro.add(email);
		JCadastro.add(enviar);

		JCadastro.setVisible(true);

		enviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeBD = nome.getText();
					String emailBD = email.getText();

					cadastro.setNome(nomeBD);
					cadastro.setEmail(emailBD);
					dao.cadastrarUser(cadastro);

					JOptionPane.showMessageDialog(enviar, "Usuario cadastrado com sucesso!");
					JCadastro.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}
