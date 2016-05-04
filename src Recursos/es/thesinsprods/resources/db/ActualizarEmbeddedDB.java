package es.thesinsprods.resources.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ActualizarEmbeddedDB {


	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection con;
		
		ConexionEmbeddedDB p=new ConexionEmbeddedDB();
		con=p.accederDB();
		Statement tabla=con.createStatement();
		ResultSet rs;
		rs=tabla.executeQuery("SELECT * FROM ESCUDOS");
		while(rs.next()){
			System.out.println(rs.getString("TIPO"));
			System.out.println(rs.getString("REQUISITOS"));
			System.out.println(rs.getString("ATRIBUTO"));
			System.out.println(rs.getString("EFECTO"));
		}
		
          
	}



}
