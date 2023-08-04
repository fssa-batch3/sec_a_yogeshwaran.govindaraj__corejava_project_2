package blood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
	
	//connection to database 
	public Connection.void getConnection()throws SQLExpection(){
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","123456");
		return connection;
	}
	
	public boolean createUser(User user) throws DAOExpection(){
		
		
			Connection connection = getConnection();
			
			String query = "INSERT INTO user(name,email,password,address,phone,id) VALUES(?,?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);
			
			state.setString(1,user.getname());
			state.setString(2,user.getemail());
			state.setString(3,user.setpassword);
			state.setString(4,user.setaddress());
			state.setint(5,user.getphone());
			state.setint(6,user.getid());
			
			//Excete the query 
			
			int row = state.executeUpdate();
			return row = 1;
			
			
			public boolean update(User user)throws DAOExpection(){
				
				Connection connection = getConnection();
				
				String updatequery = "UPDATE user SET name = ?,email = ?, password = ?,address = ?, phone = ?, id = ?";
				PreparedStatement state = Connection.preparedStatement(updatequery);
				
				state.setString(1,user.getname());
				state.setString(2,user.getemail());
				state.setString(3,user.getpassword());
				state.setString(4,user.getaddress());
				state.setint(5,user.getphone());
				state.setint(6,user.getid());
				
				int row = state.executeUpdate();
				
				return row = 1;
				
				
				public boolean delete(User user)throw DAOExpection(){
					
					Connection connection = getConnection();
					
					String deletequery = "DELETE FROM user WHERE email = ?";
					PreparedStatement state = Connection.prepareStatement(deletequery);
					state.setString(1,user.getemail());
					
					int row = statement.executeUpdate();
					
					return row = 1;
					
					
				}
				
			
			
		}
	
	
	



