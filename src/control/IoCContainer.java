package control;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import model.Client;

import java.sql.Connection;

public class IoCContainer {
	private String databaseUserName 		= null;
	private String databasePassword 		= null;
	private String jdbcDriver 				= null;
	private String localDatabaseHost		= null; 
	private Connection databaseConnection 	= null;
	private Configurations configurations 	= null;
	private XMLConfiguration xmlConfig 		= null;
	private Client client					= null;
	private ResultSet databaseResponse 		= null;
	
	//Constructor
	public IoCContainer(){}
	
	public void run(){
		String selectQuery = "select * from client";
		client = new Client(this.getDatabaseUserName(this.getConfigurations()), this.getDatabaseUserPassword(this.getConfigurations()), this.getDatabaseConnection());
		this.databaseResponse = client.initiateSelectQuery(selectQuery);
		
		try {
    		while(databaseResponse.next()){
				for(int x = 1; x != databaseResponse.getMetaData().getColumnCount();x++){
					System.out.print(databaseResponse.getString(x)+" | ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Public Methods
	/**
	 * IoC method to return initialized database connection. 
	 * @return Initialized database connection.
	 */
	public Connection getDatabaseConnection(){
		if(this.databaseConnection == null){
			try {
				Class.forName(this.getJdbcDriver(this.getConfigurations()));
				Connection temp = DriverManager.getConnection(this.getLocalDatabaseUrl(this.getConfigurations()), this.getDatabaseUserName(this.getConfigurations()), this.getDatabaseUserPassword(this.getConfigurations()));
				System.out.println("Connection established: "+temp);
				return temp;
			} catch (ClassNotFoundException e) {
				System.out.println("Unable to instantiate JDBC driver, driver missing.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Connection not successful.");
				e.printStackTrace();
			}
		}
		return this.databaseConnection;
	}
	
	//Private Methods
	private String getDatabaseUserName(Configurations configurations){
		if(this.databaseUserName == null){
	    	return this.getXmlConfigurations().getString("users.defaultUser.username");
		}
		return this.databaseUserName;
	}
	
	private String getDatabaseUserPassword(Configurations configurations){
		if(this.databasePassword == null){
	    	return this.getXmlConfigurations().getString("users.defaultUser.userPassword");
		}
		return this.databaseUserName;
	}
	
	private String getJdbcDriver(Configurations configurations){
		if(this.jdbcDriver == null){
	    	return this.getXmlConfigurations().getString("drivers.jdbc");
		}
		return this.jdbcDriver;
	}
	
	private String getLocalDatabaseUrl(Configurations configurations){
		if(this.localDatabaseHost == null){
	    	return this.getXmlConfigurations().getString("hosts.jdbcHost.local");
		}
		return this.localDatabaseHost;
	}
	
	private Configurations getConfigurations(){
		if(this.configurations == null){
			return new Configurations();
		}
		
		return this.configurations;
	}
	
	private XMLConfiguration getXmlConfigurations(){
		if(this.xmlConfig == null){
			try {
				return getConfigurations().xml("./properties/config.xml");
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return this.xmlConfig;
	}
}
