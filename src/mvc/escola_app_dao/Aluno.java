package mvc.escola_app_dao;

public class Aluno {

	private int codigo;
	private String nome;
	private int nota1;
	private int nota2;
	private int nota3;

	public Aluno(int codigo, String nome, int nota1, int nota2, int nota3) {
		this.codigo = codigo;
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	

	public Aluno() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getNota3() {
		return nota3;
	}

	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}

//Método toString
	// Retorna uma representação textual do objeto Project
	@Override
	public String toString() {
		return this.nome;
	}


	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}



