package br.com.luizpalazzo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.luizpalazzo.entity.Student;
import br.com.luizpalazzo.util.DatabaseConnection;

public class StudentDao {

	public void save(Student student) throws SQLException {
		DatabaseConnection conexao = DatabaseConnection.getInstance();
		String sql = "insert into ALUNO(ID, CPF, NOME, DATA_NASCIMENTO, EMAIL, SENHA, FOTO, VALIDO) values(aluno_sequence.nextval,?,?,?,?,?,?,?)";

		try (Connection con = conexao.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1,student.getCpf());
			ps.setString(2,student.getNome());
			ps.setDate(3, Date.valueOf(student.getDataNascimento()));
			ps.setString(4,student.getEmail());
			ps.setString(5,student.getSenha());
			ps.setString(6,student.getFoto());
			ps.setInt(7,0);
			ps.execute();
		}
		
	}
	
    public List<Student> ListUnvalidated() throws SQLException {
    	String sql = "SELECT * FROM ALUNO WHERE VALIDO = 0";
    	DatabaseConnection conexao = DatabaseConnection.getInstance();
    	List<Student> studentList = new ArrayList<>();
    	try (Connection con	= conexao.getConnection(); Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql);) {              
               while (rs.next()) {
            	   studentList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8) ));
               }
           }
    	return studentList;		
    }

	public Student findActiveUser(String email, String senha) throws SQLException {
		String sql = "SELECT * FROM ALUNO WHERE VALIDO = 1";
    	DatabaseConnection conexao = DatabaseConnection.getInstance();
    	Student student = null;
    	try (Connection con	= conexao.getConnection(); Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql);) {              
               while (rs.next()) {
            	  student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
               }
           }
    	return student;		
	}

}
