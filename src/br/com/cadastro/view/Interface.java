package br.com.cadastro.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import br.com.cadastro.dao.CadastroDAO;
import br.com.cadastro.functions.*;
import br.com.cadastro.model.Cadastro;

public class Interface {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		CadastrarUsers cUsers = new CadastrarUsers();
		Atualizar atUsers = new Atualizar();
		Deletar delUser = new Deletar();

		JFrame janelaPrincipal = new JFrame();
		janelaPrincipal.setSize(600, 400);
		janelaPrincipal.setTitle("Cadastro de usuarios");
		janelaPrincipal.setDefaultCloseOperation(janelaPrincipal.EXIT_ON_CLOSE);

		JFrame frameTabela = new JFrame("Lista de Usuários");
		frameTabela.setSize(600, 400);
		frameTabela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		String[] colunas = { "ID", "Nome", "Email" };
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		JTable tabela = new JTable(modelo);
		tabela.setFont(new Font("Arial", Font.PLAIN,14));
		JScrollPane scroll1 = new JScrollPane(tabela);

		JButton btnC = new JButton("Cadastrar");
		JButton btnS = new JButton("Exibir usuários");
		JButton btnU = new JButton("Atualizar cadastro");
		JButton btnD = new JButton("Deletar cadastro");

		btnC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cUsers.CadastrarUsuarios();
			}
		});

		btnS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroDAO dao = new CadastroDAO();

				List<Cadastro> lista = dao.listarTodos();

				// Limpa a tabela
				modelo.setRowCount(0);

				// Adiciona cada usuário na tabela
					for (Cadastro u : lista) {
						Object[] row = { u.getId(), u.getNome(), u.getEmail() };
						modelo.addRow(row);
					}
			}
		});

		btnU.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				atUsers.atualizarUsuario();
			}

		});

		btnD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delUser.deletarUsuario();
			}
		});

		JPanel painelInferior = new JPanel();

		painelInferior.add(btnC);
		painelInferior.add(btnS);
		painelInferior.add(btnU);
		painelInferior.add(btnD);
		
		janelaPrincipal.setLayout(new BorderLayout());
		janelaPrincipal.add(scroll1, BorderLayout.CENTER);
		janelaPrincipal.add(painelInferior, BorderLayout.SOUTH);

		janelaPrincipal.setVisible(true);

	}

}
