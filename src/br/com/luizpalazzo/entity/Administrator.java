package br.com.luizpalazzo.entity;

public class Administrator {
	
	private int id;
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	
	public Administrator(int id, String cpf, String nome, String email, String senha) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ "]";
	}
	
	
	
	

}
