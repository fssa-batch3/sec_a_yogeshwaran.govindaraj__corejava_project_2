package blood.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	 
	 
	 public boolean read(Request request)throws  SQLException{
		 
		 Connection connection = getConnection();
		 
		 String read = " SELECT *FROM blood.request";
		 PreparedStatement state = connection.prepareStatement(read);
		 
		 ResultSet resultset = state.executeQuery();
		 String query = "Request Attributes title = ?,description = ?,BloodGroup = ?, requestDate = ?, id = ?, contactNo = ?";
		 
		 while(resultset.next()){
			 
			 String title = resultset.getString("title");
			 String description = resultset.getString("description");
			 String BloodGroup = resultset.getString("BloodGroup");
			 String requestDate = resultset.getString("requestDate");
			 String id = resultset.getString("id");
			 String contactNo = resultset.getString("contactNo");
			 
			 
			 System.out.println("title" + title);
			 System.out.println("description" + description);
			 System.out.println("BloodGroup" + BloodGroup);
			 System.out.println("requestDate" + requestDate);
			 System.out.println("id" + id);
			 System.out.println("contactNo" + contactNo);
			 
			 
		 }
		 
		 resultset.close();
         state.close();
         connection.close();
		return false;
     } 
		 
		 

	 
	 
	 public boolean update (Request request)throws SQLException{
		 
		 Connection connection = getConnection();
		 
		 String update = "Update request set title = ?,description = ?,BloodGroup = ?, requestDate = ?, id = ?, contactNo = ?";
		 PreparedStatement state = connection.prepareStatement(update);
		 
		 state.setString(1, request.gettitle());
		 state.setString(2, request.getdescription());
		 state.setString(3, request.getBloodGroup());
		 state.setString(4, request.getrequestDate());
		 state.setString(5, request.getid());
		 state.setString(6, request.getcontactNo());
		 
		 int row = state.executeUpdate();
		 return(row == 1);
		 
	 }
}
