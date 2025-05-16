package br.com.cadastro.functions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.cadastro.dao.*;

public class Deletar {
	@SuppressWarnings("static-access")
	public void deletarUsuario() {
		CadastroDAO dao = new CadastroDAO();
		
		JFrame deleteUser = new JFrame();
		deleteUser.setSize(500, 400);
		deleteUser.setLayout(new FlowLayout());
		deleteUser.setTitle("Deletar Usuário");
		deleteUser.setDefaultCloseOperation(deleteUser.DISPOSE_ON_CLOSE);

		JLabel idLabel = new JLabel("ID");
		JTextField campoId = new JTextField(20);
		JButton deleteBtn = new JButton("Deletar usuário");

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idDelete = campoId.getText();
				int intIdDelete = Integer.parseInt(idDelete);
				try {
					dao.deleteCadastro(intIdDelete);
					JOptionPane.showMessageDialog(deleteBtn, "Usuário deletado com sucesso!");
					deleteUser.dispose();
				} catch (Exception e1) {

					e1.printStackTrace();
					JOptionPane.showMessageDialog(deleteBtn, "Usuário não encontrado!");
					deleteUser.dispose();
				}
			}
		});
		deleteUser.add(idLabel);
		deleteUser.add(campoId);
		deleteUser.add(deleteBtn);
		deleteUser.setVisible(true);
	}
}
