package com.lora.data;

import java.sql.*;

import com.lora.business.NodeLocationObject;

public class PostgresConnection{

	private static Connection openConnection(){
		
		Connection connection = null;
		
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;

		}


		try {

			//TODO: adjust connection to lora-app-server machine
/*			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/testdb", "postgres",
					"Fyp123");
*/
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/loraserver", "postgres", "e1u21an1");
			/*
			 * if database testdb doesn't exist, create it and switch connection:
			 * try connecting to 127.0.0.1:5432/testdb first
			 * if it doesn't work:
			 * 
			 * connect to 127.0.0.1:5432/postgres
			 * createStatement.executeQuery("CREATE DATABASE testdb");
			 * connect to 127.0.0.1:5432/testdb
			 * 
			 * 
			 */
			 // if table node_location doesn't exist, create it:
			 
		/*	
			Statement createStatement = connection.createStatement();
			//ResultSet createResult = 
			createStatement.executeQuery("CREATE TABLE IF NOT EXISTS node_location "
																 +"(ID integer PRIMARY KEY NOT NULL"
																 +", LONGITUDE real NOT NULL"
																 +", LATITUDE real NOT NULL);");
			createStatement.executeQuery("insert into node_location values (4, 1.34, 7.54);");													 
			//createResult.close();
			createStatement.close();
		*/	
		} catch (SQLException e) {

			//System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}
		
		return connection;
	}

	public static int executeUpdate(String update){
		Connection connection = null;
		Statement statement = null;
		int result = -1;
		
		try {
			connection = openConnection();
			if (connection == null) System.out.println("SHIIIIIIIIT. null cnx");
			statement = connection.createStatement();
			result = statement.executeUpdate(update);
			//result.close();
			//statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static ResultSet executeQuery(String query){
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		//String query = null;
		
		
		try {
			connection = openConnection();
			if (connection == null) System.out.println("SHIIIIIIIIT. null cnx");
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			//result.close();
			//statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String args[]) throws SQLException{
		
		NodeLocationObject nodeLoc = new NodeLocationObject(9, 5.87, 9.24);
		String query = "insert into node_location values (" 
				+ nodeLoc.getNodeId() 
				+ ", "
				+ nodeLoc.getLongitude()
				+ ", "
				+ nodeLoc.getLatitude()
				+");";
		PostgresConnection.executeUpdate(query);
	}
}
