package br.com.luizpalazzo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.luizpalazzo.entity.Administrator;
import br.com.luizpalazzo.util.DatabaseConnection;

public class AdministratorDao {

	public Administrator findByEmailAndSenha(String email, String senha) throws SQLException {
		DatabaseConnection conexao = DatabaseConnection.getInstance();
		String sql = "SELECT * FROM ADMINISTRADOR WHERE EMAIL = ? AND SENHA = ?";
		Administrator admin = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			con = conexao.getConnection();
			ps = con.prepareStatement(sql); 
			
			ps.setString(1, email);
			ps.setString(2, senha);
			
			
			resultSet = ps.executeQuery();
			

			while(resultSet.next()) {
				admin = new Administrator(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			}
			
		}catch(SQLException e){
			throw new SQLException("Erro na consulta de dados");
		}catch(NullPointerException e){
			throw new NullPointerException("Usuário não encontrado");
		}finally{
			con.close();
			ps.close();
			resultSet.close();
		}
		return admin;
	}

	public void acceptStudent(int id) {
		String sql = "UPDATE ALUNO SET VALIDO = 1 WHERE ID = ?";
		DatabaseConnection conexao = DatabaseConnection.getInstance();
        try (Connection con	= conexao.getConnection();
        	 PreparedStatement pStat = con.prepareStatement(sql))
        {
            pStat.setInt(1, id);
            pStat.executeUpdate();
            System.out.println("Usuario liberado!");
        }
        catch(SQLException erro) {
        	throw new RuntimeException("Erro durante a liberacao", erro);
        }
		
	}
	
	public void revokeStudent(int id) {
		String sql = "DELETE FROM ALUNO WHERE ID = ?";
		DatabaseConnection conexao = DatabaseConnection.getInstance();
        try (Connection con	= conexao.getConnection();
        	 PreparedStatement pStat = con.prepareStatement(sql))
        {
            pStat.setInt(1, id);
            pStat.executeUpdate();
            System.out.println("Usuario deletado!");
        }
        catch(SQLException erro) {
        	throw new RuntimeException("Erro durante a exclusao", erro);
        }
		
	}
	
	

}
