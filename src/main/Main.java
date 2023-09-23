package main;

import java.util.Date;
import java.util.List;

import mvc.escola_app_dao.Aluno;
import mvc.escola_app_dao.AlunoDAO;

public class Main {
	public static void main(String[] args) {
		AlunoDAO alunoDAO = new AlunoDAO();

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Amanda");
		aluno1.setNota1(7);
		aluno1.setNota2(3);
		aluno1.setNota3(8);

		// Buscar 
		List<Aluno> alunos = alunoDAO.getAll();
		
		// Salvar aluno
		// alunoDAO.save(aluno1);
		
		// Remover aluno
		alunoDAO.removeById(aluno1.getCodigo());
		
		// Atualizar aluno
		alunoDAO.update(aluno1);
	}

}




		
		
