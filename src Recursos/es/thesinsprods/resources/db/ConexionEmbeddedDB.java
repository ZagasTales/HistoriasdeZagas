package es.thesinsprods.resources.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionEmbeddedDB {
	
	private Connection conn=null;
	public Connection crearDB() throws ClassNotFoundException{
		
		try{
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:.\\Base de Datos\\DBEmbedded.DB;create=true");
				}
		catch (SQLException ex){}
		
		return conn;
	}
	
	public Connection accederDB() throws ClassNotFoundException{
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:.\\Base de Datos\\DBEmbedded.DB");
			
			if(conn!=null){
		
			}
			
		}
		
		catch(SQLException ex){}
		return conn;
		
	}


	
	
	public void cerrarCon() throws SQLException{
		
		conn.close();
		
	}
	
	

}
