package bloodDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bloodDAOexception.DAOException;
import bloodmodel.User;
import io.github.cdimascio.dotenv.Dotenv;

public class UserDAO {
	
	//connection to database 
	public Connection getConnection() throws SQLException {
		String dbUrl;
		String dbUser;
		String dbPassword;

		if (System.getenv("CI") != null) {
			dbUrl = System.getenv("DB_URL");
			dbUser = System.getenv("DB_USER");
			dbPassword = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			dbUrl = env.get("DB_URL");
			dbUser = env.get("DB_USER");
			dbPassword = env.get("DB_PASSWORD");
		}
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","123456");
		return connection;
	}
	
	//login
	
	public boolean login(User user) throws DAOException {
		
		try {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM USER WHERE email = ? AND PASSWORD = ?";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, user.getemail());
		pmt.setString(2, user.getpassword());
		ResultSet rs = pmt.executeQuery();

		return rs.next();
		} catch(SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
	// create User
	
	public boolean createUser(User user) throws DAOException {
		
		try {
			Connection connection = getConnection();
			
			String query = "INSERT INTO register(name,email,password,address,phone,id)"+" VALUES(?,?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);
			
			state.setString(1,user.getname());
			state.setString(2,user.getemail());
			state.setString(3,user.getpassword());
			state.setString(4,user.getaddress());
			state.setString(5,user.getphone());
			state.setString(6,user.getid());
			
			//Excete the query 
			
			int row = state.executeUpdate();
			return (row == 1);
		}catch(SQLException e) {
			throw new DAOException(e);
		}
	}
			
	
	//update user
			
			public boolean update(User user)throws DAOException {
				try {
				Connection connection = getConnection();
				
				String updatequery = "UPDATE user SET name = ?,email = ?, password = ?,address = ?, phone = ?, id = ?";
				PreparedStatement state = connection.prepareStatement(updatequery);
				
				state.setString(1,user.getname());
				state.setString(2,user.getemail());
				state.setString(3,user.getpassword());
				state.setString(4,user.getaddress());
				state.setString(5,user.getphone());
				state.setString(6,user.getid());
				
				int row = state.executeUpdate();
				
				return (row == 1);
				}catch(SQLException e){
					throw new DAOException(e);
				}
				
			}
				
				
			
			//delete user
				public boolean delete(User user)throws DAOException {
					try {
					Connection connection = getConnection();
					
					String deletequery = "DELETE FROM user WHERE email = ?";
					PreparedStatement state = connection.prepareStatement(deletequery);
					state.setString(1,user.getemail());
					
					int row = state.executeUpdate();
					
					return (row == 1);
					
					
				}catch(SQLException e) {
					throw new DAOException(e);
				}
				}
				
			
			
		}
	
	
	



