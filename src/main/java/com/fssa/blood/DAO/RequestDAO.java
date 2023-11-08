package com.fssa.blood.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.model.User;
import com.mysql.cj.xdevapi.Statement;

public class RequestDAO {

	// connection to database

	public static Connection getConnection() {

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
	
	
	// Create the  request

	public boolean createrequest(Request request) throws DAOException {
		try {
			Connection connection = getConnection();

			String query = "INSERT INTO request (name,description,bloodgroup,date,number, email) VALUES(?,?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);

			state.setString(1, request.getname());
			state.setString(2, request.getdescription());
			state.setString(3, request.getgroup());
			state.setDate(4, Date.valueOf(request.getdate()));
			state.setLong(5, request.getnumber());
			state.setString(6, request.getemail());

			int row = state.executeUpdate();
			state.close();
			connection.close();
			return (row == 1);

		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}

//	public static void main(String[] args) {
//		Request req = new Request();
//		req.settitle("I need a blood");
//		req.setdescription("i need help");
//		req.setgroup("A+");
//		LocalDate dt =LocalDate.now(); 
//		req.setdate(dt);
//		req.setnumber(6380843014l);
//		req.setemail("arun@gmail.com");
//		
//		
//		
//		
//		try {
//			System.out.println(new RequestDAO().createrequest(req));
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	// Read query

	public static List<Request> listrequest() throws DAOException {
	    List<Request> list = new ArrayList<>();

	    try (Connection connection = getConnection();
	         PreparedStatement state = connection.prepareStatement("SELECT * FROM request ")) {


	        try (ResultSet resultSet = state.executeQuery()) {
	            while (resultSet.next()) {
	                String name = resultSet.getString("name");
	                String description = resultSet.getString("description");
	                String group = resultSet.getString("bloodgroup");

	                java.sql.Date sqlDate = resultSet.getDate("date");
	                LocalDate localDate = sqlDate.toLocalDate();

	                Long number = resultSet.getLong("number");

	                String emailId = resultSet.getString("email");
	                int id = resultSet.getInt("id");

	                Request req = new Request();

	                req.setName(name);
	                req.setdescription(description); // Correct method name
	                req.setgroup(group); // Correct method name
	                req.setdate(localDate);
	                req.setnumber(number);
	                req.setemail(emailId);
	                req.setId(id);

	                list.add(req);
	            }
	        }

	        return list;

	    } catch (SQLException e) {
	    	e.printStackTrace();
	        throw new DAOException("Error fetching requests by email");
	    }
	}
	
	public static void main(String[] args) {
		
		try {
			List<Request> req = listrequest();
			System.out.println(req.get(1).toString());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

	
	public static Request readRequest(String email) throws DAOException {

	    Request donatingrequest = new Request();
	    try {
	        Connection connection = null;
			try {
				connection = getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        String readquery = "SELECT * FROM request WHERE email = ?";
	        PreparedStatement state = connection.prepareStatement(readquery);
	        state.setString(1, email); // Set the email parameter

	        ResultSet resultSet = state.executeQuery();

	        if (resultSet.next()) {
	        	
	        	
	            String name = resultSet.getString("name");
	            String description = resultSet.getString("description");
	            String group = resultSet.getString("bloodgroup");

	            java.sql.Date sqlDate = resultSet.getDate("date");
	            LocalDate localDate = sqlDate.toLocalDate();

	            Long number = resultSet.getLong("number");

	            String emailId = resultSet.getString("email");
	            int id = resultSet.getInt("id");

	            Request req = new Request();

	            req.setName(name);
	            req.setdescription(description); // Correct method name
	            req.setgroup(group); // Correct method name
	            req.setdate(localDate);
	            req.setnumber(number);
	            req.setemail(emailId);
	            req.setId(id);
	            	
	            donatingrequest = req;
	            
	        }
	        resultSet.close();
	        state.close();
	        connection.close();

	        return donatingrequest;

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}

	
	
	
	
//	Update request
	

	public boolean updaterequest(Request request, String email) throws DAOException {
		try {
			Connection connection = getConnection();

			String updatequery = "UPDATE request SET name = ?,description = ?, bloodgroup = ?,date = ?, number = ? WHERE email = ?";
			PreparedStatement state = connection.prepareStatement(updatequery);

			state.setString(1, request.getname());
			state.setString(2, request.getdescription());
			state.setString(3, request.getgroup());
			state.setDate(4, Date.valueOf(request.getdate()));
			state.setLong(5, request.getnumber());
			state.setString(6, request.getemail());

			int row = state.executeUpdate();
			return (row == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
	// Email only one time we have to use 
	

	public boolean sameEmailExist(String email) throws SQLException, DAOException {
		boolean match = false;
		int count = 0;

		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM request WHERE email = ?");) {

			pst.setString(1, email);
			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					String email1 = resultSet.getString("email");
					System.out.println("email: " + email1);
					if (email.toLowerCase().trim().equals(email1)) {
						count++;
					}
				}
			}

			if (count > 0) {
				match = true;
			}
		} catch (SQLException e) {
			throw new DAOException("Error: " + e);
		}

		return match;
	}
	

	
	


//	Delete Request
	

	public boolean deleterequest(String email) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String deleteQuery = "UPDATE request SET is_deleted = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, 1);
			statement.setString(2, email);
			
			

			// Execute the query
			int rows = statement.executeUpdate();

			statement.close();
			connection.close();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
	
	

}
