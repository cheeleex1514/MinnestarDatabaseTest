package control;

import java.sql.ResultSet;

/**
 * Interface for creating a connection to MySQL database.
 * Requires the following imported libraries:
 * 		java.sql.Connection;
 * 		java.sql.DriverManager;
 * 		java.sql.Statement;
 * 		java.sql.ResultSet; 
 * 
 * @author Chee M. Lee on 4/11/17.
 *
 */
public interface DatabaseConnections {
	
	/**
	 * Method to create a connection to the database, require properly 
	 * instantiated database user object with valid username and value password.
	 */
	public void databaseConnector();
	
	
	/**
	 * Method to return a select query response from the database.
	 * 
	 * @param selectQuery The desired select statement.
	 * @return The select query returned from database.
	 */
	public ResultSet initiateSelectQuery(String selectQuery);
	
	
	/**
	 * Close all database connections
	 */
	public void closeDatabaseConnection();
	
}
