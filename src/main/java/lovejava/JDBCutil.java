package lovejava;

import java.sql.*;

public class JDBCutil {
	
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getconnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/todolistdb";
		String user="root";
		String password="root";
		return DriverManager.getConnection(url,user,password);
	}
	
	 public static void closeAll(Connection connect, Statement statement) {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
}

}
