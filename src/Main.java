/**
 * Created by Chee M. Lee on 4/7/17.
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import control.DatabaseUser;

public class Main {
    public static void main(String[] args) {
    	DatabaseUser user = new DatabaseUser("root","root");
    	String selectQuery = "select * from client";
    	user.databaseConnector();
    	ResultSet databaseResponse = user.initiateSelectQuery(selectQuery);
    	
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

}
