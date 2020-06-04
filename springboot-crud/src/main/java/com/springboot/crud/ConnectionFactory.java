package com.springboot.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recuperarConexao() throws SQLException {
			
		System.out.println("Iniciando Conexão!!!");
		return DriverManager
				.getConnection("jdbc:h2:file:~/spring-boot-h2-db", "sa", "");
	}
}
