package com.fssa.blood.DAO;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.User;
import com.fssa.utils.ConnectionUtil;


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
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getPassword());
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
			
			public boolean update(User user,String email)throws DAOException {
				try {
				Connection connection = getConnection();
				
				String updatequery = "UPDATE user SET name = ?, password = ?,address = ?, phone = ? where email = ?";
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
					
					String deletequery = "UPDATE user SET isdeleted = 1 WHERE email = ?";
					PreparedStatement state = connection.prepareStatement(deletequery);
					state.setString(1,email);
					
					int row = state.executeUpdate();
					
					return (row == 1);
					
					
				}catch(SQLException e) {
					throw new DAOException(e);
				}
				}
				
				public User getUserByEmail(String email) throws DAOException {

					final String SELECTQUERY = "SELECT * FROM user WHERE email = ?";

					try {
					Connection connection = getConnection();
					PreparedStatement state = connection.prepareStatement(SELECTQUERY);

					state.setString(1, email);

						try (ResultSet rs = state.executeQuery()) {

							if (rs.next()) {

								
								String name = rs.getString("name");
								String email1 = rs.getString("email");
								String password = rs.getString("password");
								String address = rs.getString("address");
								String phone = rs.getString("phone");
//								String bloodgroup = rs.getString("bloodgroup");  
								

								return new User(name,email1,password,address,phone);

							}

						}

					} catch (SQLException e) {
						throw new DAOException("Cannot get user's details");
					}
					return null;

				}
				public static void main(String[] args) {
					try {
						User user = new UserDAO().getUserByEmail("ajai@gmail.com");
						System.out.println(user);
					} catch (DAOException e) {
						e.printStackTrace();
					}
				}
				
				
				
				public static int getUserIdByEmail(String email) throws DAOException {
					int id = 0;
					String queryDeleteEvents = "SELECT id FROM user WHERE email = ? ";
					try (Connection con = ConnectionUtil.getConnection()) {
						try (PreparedStatement pst = con.prepareStatement(queryDeleteEvents)) {

							pst.setString(1, email);
							try (ResultSet rs = pst.executeQuery()) {

								if (rs.next()) {
									id = rs.getInt("id");

								}

							}
						}
					} catch (SQLException e) {
						throw new DAOException(e.getMessage());
					}
					return id;
				}

				
			
			
		}
	
	