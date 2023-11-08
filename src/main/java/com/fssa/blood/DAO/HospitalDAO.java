package com.fssa.blood.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Hospital;
import com.fssa.blood.model.User;

public class HospitalDAO {

	public Connection getConnection() {

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

	// login User


	
	public boolean login(Hospital user) throws DAOException {
	    try {
	        Connection connection = getConnection();
	        String query = "SELECT * FROM hospital WHERE email = ? AND PASSWORD = ?";
	        PreparedStatement pmt = connection.prepareStatement(query);
	        pmt.setString(1, user.getEmail());
	        pmt.setString(2, user.getPassword());

	        try (ResultSet rs = pmt.executeQuery()) {
	            boolean userExists = rs.next(); // Store the result in a variable
	            System.out.println("rs " + userExists);
	            return userExists; // Return the stored result
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DAOException(e);
	    }
	}

	
	

	// Create User

	public boolean createUser(Hospital user) throws DAOException {

		try {
			Connection connection = getConnection();

			String query = "INSERT INTO hospital(name,email,password,address,phone) VALUES(?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);

			state.setString(1, user.getName());
			state.setString(2, user.getEmail());
			state.setString(3, user.getPassword());
			state.setString(4, user.getAddress());
			state.setString(5, user.getPhone());

			// Execute the query

			int row = state.executeUpdate();
			return (row == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Update User

	public boolean update(Hospital user, String email) throws DAOException {
		try {
			Connection connection = getConnection();

			String updatequery = "UPDATE hospital SET name = ?, password = ?,address = ?, phone = ? where email = ?";
			PreparedStatement state = connection.prepareStatement(updatequery);

			state.setString(1, user.getName());
			state.setString(2, user.getPassword());
			state.setString(3, user.getAddress());
			state.setString(4, user.getPhone());
			state.setString(5, user.getEmail());

			int row = state.executeUpdate();

			return (row == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	// Delete User
	public boolean delete(String email) throws DAOException {
		try {
			Connection connection = getConnection();

			String deletequery = "UPDATE hospital SET isdeleted = 1 WHERE email = ?";
			PreparedStatement state = connection.prepareStatement(deletequery);
			state.setString(1, email);

			int row = state.executeUpdate();

			return (row == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public Hospital getHospitalByEmail(String email) throws DAOException {

		final String SELECTQUERY = "SELECT * FROM hospital WHERE email = ?";

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

					return new Hospital(name, email1, password, address, phone);

				}

			}

		} catch (SQLException e) {
			throw new DAOException("Cannot get user's details");
		}
		return null;

	}
	/*
	 * public static void main(String[] args) { try { Hospital user = new
	 * HospitalDAO().getHospitalByEmail("ajai@gmail.com"); System.out.println(user);
	 * } catch (DAOException e) { e.printStackTrace(); } }
	 */

	public static void main(String[] args) {

		Hospital user = new Hospital();
		user.setEmail("mailyogeshkg@gmail.com");
		user.setPassword("@Yogesh12");

		try {
			boolean c = new HospitalDAO().login(user);
			System.out.println("in main " + c);
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
