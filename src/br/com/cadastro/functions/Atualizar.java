package br.com.cadastro.functions;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.cadastro.model.Cadastro;
import br.com.cadastro.dao.*;

public class Atualizar {
	@SuppressWarnings("static-access")
	public void atualizarUsuario() {
		CadastroDAO dao = new CadastroDAO();
		JFrame updtC = new JFrame();
		updtC.setSize(500, 200);
		updtC.setTitle("Atualizar cadastro");
		updtC.setLayout(new GridLayout(10, 20));
		updtC.setDefaultCloseOperation(updtC.DISPOSE_ON_CLOSE);

		JLabel labelId = new JLabel("ID");
		JTextField campoId = new JTextField(15);

		JLabel labelNome = new JLabel("Nome");
		JTextField campoNome = new JTextField(15);

		JLabel labelEmail = new JLabel("Email");
		JTextField campoEmail = new JTextField(15);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Cadastro c = new Cadastro();
					String nomeBD = campoNome.getText();
					String emailBD = campoEmail.getText();
					String idBD = campoId.getText();

					int idBDInt = Integer.parseInt(idBD);
					c.setEmail(emailBD);
					c.setNome(nomeBD);
					c.setId(idBDInt);

					JOptionPane.showMessageDialog(btnAtualizar, "Cadastro atualizado!");
					updtC.dispose();
					try {
						dao.updateCadastro(c);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		updtC.add(labelId);
		updtC.add(campoId);
		updtC.add(labelNome);
		updtC.add(campoNome);
		updtC.add(labelEmail);
		updtC.add(campoEmail);
		updtC.add(btnAtualizar);
		updtC.setVisible(true);
	}

}
