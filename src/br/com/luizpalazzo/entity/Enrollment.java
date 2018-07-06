package br.com.luizpalazzo.entity;

public class Enrollment {
	
	private int idAluno;
	private int idDisciplina;
	
	public Enrollment(int idAluno, int idDisciplina) {
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	

}
