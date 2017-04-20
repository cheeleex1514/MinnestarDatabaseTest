package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for creating a database user.
 * 
 * Created by Chee M. Lee on 4/11/17.
 */
public class Client implements QueryManager{
	private String databaseUserName 		= null;
	private String databasePassword 		= null;
	private boolean isConnectionSuccess 	= false;
	private Connection databaseConnection 	= null;
	private Statement selectStatement 		= null;
	private ResultSet databaseResponse 		= null;

	/**
	 * Constructor for DatabaseUser. Parameters must be valid credentials.
	 * 
	 * @param username The desired valid user name.
	 * @param userpassword The desired valid password.
	 */
	public Client(Connection dbConnection){
		if(dbConnection == null){
			System.out.println("Database connection was not a success.");
		}else{
			this.databaseConnection = dbConnection;
			this.setConnectionSuccess(true);
		}
	}
	
	/* * * * * * * * * * * * *
	 * Public Methods
	 * * * * * * * * * * * * */
	@Override
	public ResultSet initiateSelectQuery(String selectQuery) {
		if(this.getQueryResponse() != null){
			this.setDatabaseResponse(null);
		}
		
		if(this.isConnectionSuccess()){
			try	{
				if(this.selectStatement == null){
					this.selectStatement = this.databaseConnection.createStatement();
				}
				
				this.setDatabaseResponse(this.selectStatement.executeQuery(selectQuery));
				return this.getQueryResponse();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return this.getQueryResponse();
			}
		}else{
			System.out.println("No database connection detected, query failed.");
			return this.getQueryResponse();
		}
	}
	
	@Override
	public boolean updateDatabaseObject(String updateStatement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createDatabaseObject(String createStatement) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets database user name to desired user name.
	 * @param databaseUserName Desired user name.
	 */
	public void setDatabaseUserName(String databaseUserName) {this.databaseUserName = databaseUserName;}
	
	/**
	 * Sets database user password to desired password.
	 * @param databasePassword 
	 */
	public void setDatabasePassword(String databasePassword) {this.databasePassword = databasePassword;}
	
	/**
	 * Method to check connection success status.
	 * @return True if connection to database was successful, fail if not successful.
	 */
	public boolean isConnectionSuccess() {return isConnectionSuccess;}
	
	
	/* * * * * * * * * * * * *
	 * Private Methods
	 * * * * * * * * * * * * */
	/**
	 * Method to set state of database connection.
	 * @param isConnectionSuccess True if connection success, else false.
	 */
	private void setConnectionSuccess(boolean isConnectionSuccess) {this.isConnectionSuccess = isConnectionSuccess;}
	
	/**
	 * Method to set databaseResponse
	 * @param the database resultSet object or null if not null;
	 */
	private void setDatabaseResponse(ResultSet response){this.databaseResponse = response;}
	
	/**
	 * Gets the response from the database.
	 * @return Returns the set databaseResponse. 
	 */
	private ResultSet getQueryResponse(){return this.databaseResponse;}
}//DatabaseUser
