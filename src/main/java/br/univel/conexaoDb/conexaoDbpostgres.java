package br.univel.conexaoDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class conexaoDbpostgres {
	public static String status = "Não conectou...";

	public static Connection getconexaoDbpstgres() {

		Connection connection = null;  

		try {
			String driverName = "org.postgresql.Driver";
			Class.forName(driverName);
			String serverName = "localhost:5432"; 
			String mydatabase = "trabalhobim"; 
			String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
			String username = "postgres"; // 
			String password = "1234"; 
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				status = ("Conectado com sucesso!");
			} else {
				status = ("Não foi possivel realizar conexão");
			}

			return connection;

		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;

			
			
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;

		}

	}

	public static String statusConection() {
		return status;
	}

	public static boolean FecharConexao() {
		try {
			conexaoDbpostgres.getconexaoDbpstgres().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static Connection ReiniciarConexao() {
		FecharConexao();
		return conexaoDbpostgres.getconexaoDbpstgres();
	}
	

}
