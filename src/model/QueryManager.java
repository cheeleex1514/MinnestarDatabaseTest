package model;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

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
public interface QueryManager {
	
	/**
	 * Method to return a select query response from the database.
	 * 
	 * @param selectQuery The desired select statement.
	 * @return The select query returned from database.
	 */
	public ResultSet initiateSelectQuery(String selectQuery);
	
	/**
	 * Method update a record in the database.
	 * 
	 * @param selectQuery The desired select statement.
	 * @return The select query returned from database.
	 */
	public boolean updateDatabaseObject(String updateStatement);
	
	/**
	 * Method to create a new record in the database.
	 * 
	 * @param selectQuery The desired select statement.
	 * @return The select query returned from database.
	 */
	public boolean createDatabaseObject(String createStatement);

}
