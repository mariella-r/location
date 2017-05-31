package com.lora.data;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;


public class TestDB {

	public static String dbtest() {

/*		RedisClient redisClient = new RedisClient(
			      RedisURI.create("redis://127.0.0.1:6379"));
			    RedisConnection<String, String> redisConnection = redisClient.connect();

			    System.out.println("Connected to Redis");

			    redisConnection.close();
			    redisClient.shutdown();
*/		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/testdb", "postgres",
					"Fyp123");

			//TODO:
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
			 * 
			 * if table node_location doesn't exist, create it:
			 * 
			 * 			createStatement.executeQuery("CREATE TABLE node_location "
					+"(ID INT PRIMARY KEY NOT NULL"
					+", LONGITUDE INT NOT NULL"+
					", LATITUDE INT NOT NULL)");
			 * */
			
			Statement createStatement = connection.createStatement();
			//ResultSet createResult = 
			//createStatement.executeQuery("");
			//createResult.close();
			createStatement.close();
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		return "All good";
	}

	
}