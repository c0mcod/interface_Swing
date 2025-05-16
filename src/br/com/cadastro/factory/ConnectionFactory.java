package br.com.cadastro.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//Usuário do bd
	private static final String USERNAME = "root";
	
	//senha do bd
	private static final String PASSWORD = "1234";
	
	//Caminho do banco de dados/porta/nome do banco de dados
	private static final String DATA_BASE_URL = "jdbc:mysql://localhost:3306/cadastrousers";

	
	// conexão com o banco de dados
	public static Connection createConnectionToMySQL() throws Exception {
		//faz com que a classe seja carregada pelo JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATA_BASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão", e);
        }
    }
	
	public static void main(String[] args) throws Exception {
		//carregar o driver JDBC do MySQL.
		Connection con = createConnectionToMySQL();
		
		//verificar se a conexão é nula.
		if(con != null) {
			System.out.println("conexão obtida");
			con.close();
		}
	}
	
	
}


