package mvc.escola_app_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlunoDAO {
	public void save(Aluno aluno) {
		String sql = "INSERT INTO aluno (nome, nota1, nota2, nota3) VALUES (?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, aluno.getNome());
			statement.setInt(2, aluno.getNota1());
			statement.setInt(3, aluno.getNota2());
			statement.setInt(4, aluno.getNota3());
			
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar o aluno.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void update(Aluno aluno) {
		String sql = "UPDATE aluno SET nome = ?,nota1 = ?, nota2 = ?, nota3 = ? WHERE codigo = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement(sql);

			statement.setString(1, aluno.getNome());
			statement.setInt(2, aluno.getNota1());
			statement.setInt(3, aluno.getNota2());
			statement.setInt(4, aluno.getNota3());
			statement.setInt(5,aluno.getCodigo());

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar o aluno.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public List<Aluno> getAll() {
		String sql = "SELECT * FROM aluno";

		List<Aluno> alunos = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			// Enquanto existir dados no banco de dados
			while (resultSet.next()) {
				Aluno aluno = new Aluno	();
				aluno.setCodigo(resultSet.getInt("codigo"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setNota1(resultSet.getInt("nota1"));
				aluno.setNota2(resultSet.getInt("nota2"));
				aluno.setNota3(resultSet.getInt("nota3"));
				// Adiciono o contato recuperado, a lista de contatos
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao obter a lista de alunos.", e);
		} finally {
			// finally: Sempre é executado
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		return alunos;
	}

	public void removeById(int idAluno) {
		String sql = "DELETE FROM aluno WHERE codigo = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idAluno);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao excluir o aluno.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
}
