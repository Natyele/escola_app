package mvc.escola_app_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=escola_app;encrypt=false";
	public static final String USER = "sa";
	public static final String PASS = "12345678";

	/**
	 * Esse método devolve uma conexão. <br>
	 * {@code static} Diz que eu posso chamar esse método sem criar uma instancia
	 * dessa classe. Não é necessário criar um objeto da Classe
	 * {@code ConnectionFactory}, para poder executa-lo. É como se fosse um método
	 * global, náo é muito usual, vai depender de cada objeto.
	 * 
	 * @return Conexão com o banco de dados.
	 */
	public static Connection getConnection() {
		// try - catch: É uma forma de pegar erros que podem acontecer e fazer
		// um tratamento. Faz tratamento de exceção/erro. No try se coloca todo
		// código que é possivel de erro.
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão com o banco de dados", e);
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			// Se a conexão existir, feche-a.
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			closeConnection(connection);
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			closeConnection(connection, statement);
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.", e);
		}
	}
}
