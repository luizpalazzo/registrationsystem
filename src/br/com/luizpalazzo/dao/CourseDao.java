package br.com.luizpalazzo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.luizpalazzo.entity.Course;
import br.com.luizpalazzo.util.DatabaseConnection;

public class CourseDao {

	public List<Course> availableCourses() throws SQLException {
		String sql = "SELECT * FROM DISCIPLINA";
    	DatabaseConnection conexao = DatabaseConnection.getInstance();
    	List<Course> courseList = new ArrayList<>();
    	try (Connection con	= conexao.getConnection(); Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql);) {              
               while (rs.next()) {
            	   if(getEnrollmentNumber(rs.getInt(1)) < rs.getInt(3)){
            		   courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            	   }
            	   
               }
           }
    	return courseList;
	}
	
	public int getEnrollmentNumber(int idDisciplina) throws SQLException {
		String sql = "SELECT COUNT(1) FROM MATRICULA WHERE ID_DISCIPLINA = ?";
    	DatabaseConnection conexao = DatabaseConnection.getInstance();
    	int result = 0;
    	ResultSet rs = null;
    	try (Connection con	= conexao.getConnection(); PreparedStatement stat = con.prepareStatement(sql);) {      
    		   stat.setInt(1, idDisciplina);
    		   rs = stat.executeQuery();
               while (rs.next()) {
            	  result = rs.getInt(1);
               }
           }
    	return result;	
		
	}
	
	public List<Course> allCourses() throws SQLException {
		String sql = "SELECT * FROM DISCIPLINA";
    	DatabaseConnection conexao = DatabaseConnection.getInstance();
    	List<Course> courseList = new ArrayList<>();
    	try (Connection con	= conexao.getConnection(); Statement stat = con.createStatement(); ResultSet rs = stat.executeQuery(sql);) {              
               while (rs.next()) {
            	   courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getInt(3)));
               }
           }
    	return courseList;		
	}

	public void enroll(int idCurso, int idAluno) {
		String sql = "INSERT INTO MATRICULA(ID_ALUNO, ID_DISCIPLINA, DATA_MATRICULA) VALUES(?, ?, ?)";
		DatabaseConnection conexao = DatabaseConnection.getInstance();
        try (Connection con	= conexao.getConnection();
        	 PreparedStatement pStat = con.prepareStatement(sql))
        {
            pStat.setInt(1, idAluno);
            pStat.setInt(2, idCurso);
            pStat.setDate(3, Date.valueOf(LocalDate.now()));
            pStat.executeUpdate();
            System.out.println("Matricula efetuada!");
        }
        catch(SQLException erro) {
        	throw new RuntimeException("Erro durante a matricula", erro);
        }
		
	}

	public boolean verifyEnroll(int idCurso, int idAluno) throws SQLException {
		String sql = "SELECT COUNT(1) FROM MATRICULA WHERE ID_DISCIPLINA = ? AND ID_ALUNO = ?";
    	DatabaseConnection conexao = DatabaseConnection.getInstance();
    	int result = 0;
    	ResultSet rs = null;
    	try (Connection con	= conexao.getConnection(); PreparedStatement stat = con.prepareStatement(sql);) {      
    		   stat.setInt(1, idCurso);
    		   stat.setInt(2, idAluno);
    		   rs = stat.executeQuery();
               while (rs.next()) {
            	  result = rs.getInt(1);
               }
           }
    	
    	if(result == 0){
    		return true;
    	}else{
    		return false;
    	}
		
	}



}
