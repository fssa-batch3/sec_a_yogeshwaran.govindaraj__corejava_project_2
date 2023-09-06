package com.fssa.blood.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.User;


public class UserDAO {
	
	//Connection to Database 
	
	public Connection getConnection()  {

		Connection connection = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable  to connect database", e); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e); 
		}
		return connection;
	}
	
	
	//login User
	
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
	
	
		// Create User
	
	public boolean createUser(User user) throws DAOException {
		
		try {
			Connection connection = getConnection();
			
			String query = "INSERT INTO user(name,email,password,address,phone) VALUES(?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);
			
			state.setString(1,user.getname());
			state.setString(2,user.getemail());
			state.setString(3,user.getpassword());
			state.setString(4,user.getaddress());
			state.setString(5,user.getphone());

			
			// Execute the query 
			
			int row = state.executeUpdate();
			return (row == 1);
		}catch(SQLException e) {
			throw new DAOException(e);
		}
	}
			
	
			//Update User
			
			public boolean update(User user)throws DAOException {
				try {
				Connection connection = getConnection();
				
				String updatequery = "UPDATE user SET name = ?,email = ?, password = ?,address = ?, phone = ?";
				PreparedStatement state = connection.prepareStatement(updatequery);
				
				state.setString(1,user.getname());
				state.setString(2,user.getemail());
				state.setString(3,user.getpassword());
				state.setString(4,user.getaddress());
				state.setString(5,user.getphone());
			
				
				int row = state.executeUpdate();
				
				return (row == 1);
				}catch(SQLException e){
					throw new DAOException(e);
				}
				
			}
				
				
			
			//Delete User
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
	
	
	



