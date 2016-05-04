package es.thesinsprods.resources.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ConexionDBOnline {

	private Connection conn = null;
	

	public Connection accederDB() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		try {
			File server=new File("./conexion/server");
			FileReader fr = new FileReader(server);
			BufferedReader br = new BufferedReader(fr);
			String ip=br.readLine();
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@"+ip+":1521:XE", "ZAGASROOT",
					"putospk2");

		}

		catch (SQLException ex) {
			
			System.out.println ("No va");
		}
		return conn;

	}

	public Connection accederDBSYS() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "SYS AS SYSDBA",
					"putospk2");

		}

		catch (SQLException ex) {
		}
		return conn;

	}

	public void cerrarCon() throws SQLException {

		conn.close();
	}

}