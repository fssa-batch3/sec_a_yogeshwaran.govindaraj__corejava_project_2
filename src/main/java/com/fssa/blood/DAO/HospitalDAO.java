package com.fssa.blood.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Hospital;

public class HospitalDAO {
	
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
	
	public boolean login(Hospital user) throws DAOException {
		
		try {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM USER WHERE email = ? AND PASSWORD = ?";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getPassword());
		ResultSet rs = pmt.executeQuery();

		return rs.next();
		} catch(SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
		// Create User
	
	public boolean createUser(Hospital user) throws DAOException {
		
		try {
			Connection connection = getConnection();
			
			String query = "INSERT INTO hospital(name,email,password,address,phone) VALUES(?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);
			
			state.setString(1,user.getName());
			state.setString(2,user.getEmail());
			state.setString(3,user.getPassword());
			state.setString(4,user.getAddress());
			state.setString(5,user.getPhone());

			
			// Execute the query 
			
			int row = state.executeUpdate();
			return (row == 1);
		}catch(SQLException e) {
			throw new DAOException(e);
		}
	}
			
	
			//Update User
			
			public boolean update(Hospital user,String email)throws DAOException {
				try {
				Connection connection = getConnection();
				
				String updatequery = "UPDATE hospital SET name = ?, password = ?,address = ?, phone = ? where email = ?";
				PreparedStatement state = connection.prepareStatement(updatequery);
				
				state.setString(1,user.getName());
				state.setString(2,user.getPassword());
				state.setString(3,user.getAddress());
				state.setString(4,user.getPhone());
				state.setString(5,user.getEmail());
				
				int row = state.executeUpdate();
				
				return (row == 1);
				}catch(SQLException e){
					throw new DAOException(e);
				}
				
			}
				
				
			
			//Delete User
				public boolean delete(String email)throws DAOException {
					try {
					Connection connection = getConnection();
					
					String deletequery = "UPDATE hospital SET isdeleted = 1 WHERE email = ?";
					PreparedStatement state = connection.prepareStatement(deletequery);
					state.setString(1,email);
					
					int row = state.executeUpdate();
					
					return (row == 1);
					
					
				}catch(SQLException e) {
					throw new DAOException(e);
				}
				}
				
			
			
		}
	
