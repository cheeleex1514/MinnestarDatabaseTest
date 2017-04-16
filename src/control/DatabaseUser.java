package control;
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
public class DatabaseUser implements DatabaseConnections{
	private String databaseUserName 		= "";
	private String databasePassword 		= "";
	private boolean isProperlyIntialized 	= false;
	private boolean isConnectionSuccess 	= false;
	private Connection databaseConnection 	= null;
	private Statement selectStatment 		= null;
	private ResultSet databaseResponse 		= null;
	
	/**
	 * Constructor for DatabaseUser. Parameters must be valid credentials.
	 * 
	 * @param username The desired valid user name.
	 * @param userpassword The desired valid password.
	 */
	public DatabaseUser(String username, String userpassword) throws IllegalArgumentException{
		if(username.isEmpty() || userpassword.isEmpty()){
			this.setProperlyIntialized(false);
			System.out.println("Unable to instantiate DatabaseUser.");
			throw new IllegalArgumentException("Username or password cannot be empty.");
		}else{
			this.databaseUserName = username;
			this.databasePassword = userpassword;
			this.setProperlyIntialized(true);
		}
	}
	
	/* * * * * * * * * * * * *
	 * Public Methods
	 * * * * * * * * * * * * */
	@Override
	public void databaseConnector() {
		if(this.isProperlyIntialized())
		{
			try 
			{
				Class.forName(constants.Variables.JDBC_DRIVER);
				databaseConnection = DriverManager.getConnection(constants.Variables.DB_LOCAL_CONNECTION, this.databaseUserName, this.databasePassword);
				
				System.out.println("Connection Object Created : " + databaseConnection);
				this.setConnectionSuccess(true);
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver class not found.");
				e.printStackTrace();
				this.setConnectionSuccess(false);
			} catch (SQLException e) {
				System.out.println("Database connection unsuccessful.");
				e.printStackTrace();
				this.setConnectionSuccess(false);
			}
		}
	}

	@Override
	public ResultSet initiateSelectQuery(String selectQuery) {
		if(this.getQueryResponse() != null){
			this.setDatabaseResponse(null);
		}
		
		if(this.isConnectionSuccess()){
			try	{
				if(this.selectStatment == null){
					this.selectStatment = this.databaseConnection.createStatement();
				}
				
				this.databaseResponse = this.selectStatment.executeQuery(selectQuery);
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
	public void closeDatabaseConnection(){
		try {
			System.out.println("Ending database connection.");
			this.selectStatment.close();
			this.databaseResponse.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	 * Method to return the current state of DatabaseUser object.
	 * @return True if properly instantiated, else false.
	 */
	private boolean isProperlyIntialized(){return this.isProperlyIntialized;}
	
	/**
	 * Method to set the state of DatabaseUser object.
	 * @param isProperlyIntialized True if properly instantiated, else false.
	 */
	private void setProperlyIntialized(boolean isProperlyIntialized) {this.isProperlyIntialized = isProperlyIntialized;}

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
