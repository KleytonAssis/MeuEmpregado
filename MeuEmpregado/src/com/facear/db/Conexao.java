package com.facear.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection con;

	private String driver;
	private String url;
	private String username;
	private String password;

	public Conexao() {
//		driver = "com.mysql.jdbc.Driver";
//		url = "jdbc:mysql://localhost:3306/MyLogin?useSSL=false";
		username = "sa";
		password = "admin27";

		 driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 url = "jdbc:sqlserver://localhost:1434;databaseName=MyLogin";

	}

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Class.forName(driver);
		this.con = DriverManager.getConnection(url, username, password);

		return this.con;
	}
}
