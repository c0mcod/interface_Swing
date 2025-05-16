package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastro.factory.ConnectionFactory;
import br.com.cadastro.model.Cadastro;

public class CadastroDAO {

	public void cadastrarUser(Cadastro cadastro) throws SQLException {
		String sql = "INSERT INTO usuario(nome, email) VALUES (?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cadastro.getNome());
			pstm.setString(2, cadastro.getEmail());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}

			if (pstm != null) {
				pstm.close();
			}

		}

	}

	public List<Cadastro> listarTodos() {
		List<Cadastro> Lista = new ArrayList<>();
		String sql = "SELECT * FROM usuario";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cadastro cadastro = new Cadastro();
				cadastro.setId(rset.getInt("id"));
				cadastro.setNome(rset.getString("nome"));
				cadastro.setEmail(rset.getString("email"));
				Lista.add(cadastro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Lista;
	}

	public void updateCadastro(Cadastro cadastro) throws SQLException {
		String sql = "UPDATE usuario SET nome = ?, email = ?" + "WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cadastro.getNome());
			pstm.setString(2, cadastro.getEmail());
			
			pstm.setInt(3, cadastro.getId());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.close();
			}
			if(pstm != null) {
				pstm.close();
			}
		}
	}

	public void deleteCadastro(int id) throws Exception {
		String sql = "DELETE FROM usuario WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.close();
			}
			if(pstm != null) {
				
			}
		} 
	}
}
