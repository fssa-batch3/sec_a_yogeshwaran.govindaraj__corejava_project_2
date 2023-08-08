package blood.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import blood.DAOExpection.DAOExpection;
import blood.model.Request;

public class RequestDAO {

	public Connection getConnection()throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","123456");
		return connection;
		
	}
	 public boolean create(Request request)throws DAOExpection, SQLException{
		 
		 Connection connection = getConnection();
		 
		 String createquery = "INSERT INTO request(title,description, BloodGroup, requestDate,id,contactNo) VALUES (?,?,?,?,?,?)";
		 PreparedStatement state = connection.prepareStatement(createquery);
		 
		 state.setString(1,request.gettitle());
		 state.setString(2,request.getdescription());
		 state.setString(3,request.getBloodGroup());
		 state.setString(4, request.getrequestDate());
		 state.setString(5, request.getid());
		 state.setString(6, request.getcontactNo());
		 
		 int row = state.executeUpdate();
		 return(row == 1);
	 }
}
