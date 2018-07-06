package br.com.luizpalazzo.util;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseConnection {
	
	private BasicDataSource dataSource;
	private String user = "sys as sysdba";
	private String pass = "admin";
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	
	private static DatabaseConnection conexaoBD = new DatabaseConnection();
	
	private DatabaseConnection() {
		dataSource = new BasicDataSource();
		dataSource.setUsername(user);
		dataSource.setPassword(pass);
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
	}
	
	public static DatabaseConnection getInstance() {
		return conexaoBD;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
