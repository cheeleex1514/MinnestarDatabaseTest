package constants;
/**
 * Class for constant variables.
 * 
 * @author Chee M. Lee
 *
 */

public final class Variables {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_LOCAL_CONNECTION = "jdbc:mysql://localhost:3306/db_minnestar?useSSL=false";
	
	public Variables() throws AssertionError{
		throw new AssertionError("Class cannot be instantiated..."); //cannot be instantiated
	}
}
