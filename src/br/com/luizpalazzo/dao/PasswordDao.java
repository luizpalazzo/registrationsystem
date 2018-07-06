package br.com.luizpalazzo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.luizpalazzo.util.DatabaseConnection;

public class PasswordDao {

	public void changePassword(String senha, int id) {
		String sql = "UPDATE ALUNO SET SENHA = ? WHERE ID = ?";
		DatabaseConnection conexao = DatabaseConnection.getInstance();
        try (Connection con	= conexao.getConnection();
        	 PreparedStatement pStat = con.prepareStatement(sql))
        {
            pStat.setString(1, senha);
            pStat.setInt(2, id);
            pStat.executeUpdate();
            System.out.println("Senha alterada!");
        }
        catch(SQLException erro) {
        	throw new RuntimeException("Erro na alteracao", erro);
        }
		
	}

}
