//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package TP03;

import java.util.*;
import java.sql.*;

public class bookDao {
	public static Connection getConnection() {
		Connection con = null;
		try {

			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			// Database name to access
			String dbName = "bookstore";
			String dbUsername = "root";
			String dbPassword = "admin";
			Class.forName(dbDriver);

			con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static int save(book e) {
		int status = 0;
		try {
			Connection con = bookDao.getConnection();
			PreparedStatement ps = con.prepareStatement(

					"insert into book(title,author,price) values (?,?,?)");
			ps.setString(1, e.getTitle());
			ps.setString(2, e.getAuthor());
			ps.setFloat(3, e.getPrice());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	public static int update(book e) {
		int status = 0;
		try {
			Connection con = bookDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update book set title=?,author=?,price=? where id=?");
			ps.setString(1, e.getTitle());
			ps.setString(2, e.getAuthor());
			ps.setFloat(3, e.getPrice());
			ps.setInt(4, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = bookDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from book where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
	public static book getProdutoById(int id) {
		book e = new book();

		try {
			Connection con = bookDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setTitle(rs.getString(2));
				e.setAuthor(rs.getString(3));
				e.setPrice(rs.getFloat(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
	
	public static List<book> getAllBooks() {
		List<book> list = new ArrayList<book>();

		try {
			Connection con = bookDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book e = new book();
				e.setId(rs.getInt(1));
				e.setTitle(rs.getString(2));
				e.setAuthor(rs.getString(3));
				e.setPrice(rs.getFloat(4));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
