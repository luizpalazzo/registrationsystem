package br.com.luizpalazzo.entity;

import java.time.LocalDate;

public class Student {
	
	private int id;
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	private String foto;
	private int valido;
	private LocalDate dataNascimento;
	
	public Student(int id, String cpf, String nome, LocalDate dataNascimento, String email, String senha, String foto,  int valido) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.dataNascimento = dataNascimento;
		this.valido = valido;
	}
	
	public Student(String cpf, String nome, String email, String senha, String foto, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.dataNascimento = dataNascimento;
		valido = 0;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getValido() {
		return valido;
	}

	public void setValido(int valido) {
		this.valido = valido;
	}
	

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Student [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto=" + foto
				+ ", valido=" + valido + "]";
	}

}
