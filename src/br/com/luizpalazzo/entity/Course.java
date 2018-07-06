package br.com.luizpalazzo.entity;

public class Course {
	
	private int codigo;
	private String nome;
	private int qtdMaxima;
	
	public Course(int codigo, String nome, int qtdMaxima) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.qtdMaxima = qtdMaxima;
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
	public int getQtdMaxima() {
		return qtdMaxima;
	}
	public void setQtdMaxima(int qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}
	
	

}
