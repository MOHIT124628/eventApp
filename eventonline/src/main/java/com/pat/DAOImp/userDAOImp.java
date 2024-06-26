package com.pat.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pat.DAO.userDAO;
import com.pat.modren.user;
import com.tap.modren.pro_user;

public class userDAOImp implements userDAO {
	@Override
	public void save(user user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book", "root", "root");
			String insert="INSERT INTO user (name, username, password, email, phone_number, city, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt=con.prepareStatement(insert);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPhone_number());
			stmt.setString(6, user.getCity());
			stmt.setString(7, user.getRole());
			
			int i=stmt.executeUpdate();
			if(i>0) {
				System.out.println("Menuid inserted successfully");
			}else {
				System.out.println("Please check the wrong");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void update(user user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book", "root", "root");
			
			String update="UPDATE user SET name = ?, username = ?, password = ?, email = ?, phone_number = ?, city = ?, role = ? WHERE user_id = ?";
			PreparedStatement stmt=con.prepareStatement(update);
			stmt.setString(1, user.getName());
			stmt.setString(2,user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPhone_number());
			stmt.setString(6, user.getCity());
			stmt.setString(7,user.getCity());
			
			int j=stmt.executeUpdate();
			if(j>0) {
				System.out.println("Menuid inserted successfully");
			}else {
				System.out.println("Please check the wrong");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int userid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book", "root","root");
			
			String delete="DELETE FROM user WHERE user_id = ?";
			PreparedStatement stmt=con.prepareStatement(delete);
			stmt.setInt(1, userid);
			int j=stmt.executeUpdate();
			if(j>0) {
				System.out.println("Menuid inserted successfully");
			}else {
				System.out.println("Please check the wrong");
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public user getUserById(int userid) {
		user us=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306//e_book", "root", "root");
			String getUserid="SELECT * FROM user WHERE userid = ?";
			
			PreparedStatement stmt=con.prepareStatement(getUserid);
			stmt.setInt(1, userid);
			ResultSet res=stmt.executeQuery();
			if(res.next()) {
				us=new user();
				us.setUserid(res.getInt("userid"));
				us.setName(res.getString("name"));
				us.setUsername(res.getString("username"));
				us.setPassword(res.getString("password"));
				us.setEmail(res.getString("email"));
                us.setPhone_number(res.getString("phone_number"));
                us.setCity(res.getString("city"));
                us.setRole(res.getString("role"));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}

		    
		   
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/e_book";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "root";
	private static final String SELECT_ALL_USERS = "SELECT * FROM user";

	@Override
	public List<user> getAll() {
		List<user> users = new ArrayList<>();

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
					PreparedStatement stmt = con.prepareStatement(SELECT_ALL_USERS);
					ResultSet resultSet = stmt.executeQuery()) {

				
				while (resultSet.next()) {
					user user = new user();
					user.setUserid(resultSet.getInt("userid"));
					user.setName(resultSet.getString("name"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));
					user.setPhone_number(resultSet.getString("phone_number"));
					user.setCity(resultSet.getString("city"));
					user.setRole(resultSet.getString("role"));
					users.add(user);
				}
			}
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return users;
	}
	
	
	public user validateUser(String email, String password) {
		System.out.println(email+"  "+password);
		user user = null;
        String sql = "SELECT * FROM user WHERE email=? AND password=?";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book", "root", "root");
	        
	        PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password); // Hash and compare the hash in a real application

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new user();
                user.setUserid(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone_number(resultSet.getString("phone_number"));
				user.setCity(resultSet.getString("city"));
				user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return user;
    }
}

