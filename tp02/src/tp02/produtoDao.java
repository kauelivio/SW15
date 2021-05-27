//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package tp02;

import java.util.*;
import java.sql.*;

public class produtoDao {
	
	public static Connection getConnection() {
		Connection con = null;
		try {

			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			// Database name to access
			String dbName = "tp02";
			String dbUsername = "root";
			String dbPassword = "admin";
			Class.forName(dbDriver);

			con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static int save(produto e) {
		int status = 0;
		try {
			Connection con = produtoDao.getConnection();
			PreparedStatement ps = con.prepareStatement(

					"insert into user905(nome,unidadeCompra,descricao,qtdPrevistoMes,precoMaxComprado) values (?,?,?,?,?)");
			ps.setString(1, e.getNome());
			ps.setInt(2, e.getUnidadeCompra());
			ps.setString(3, e.getDescricao());
			ps.setDouble(4, e.getQtdPrevistoMes());
			ps.setDouble(5, e.getPrecoMaxComprado());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	public static int update(produto e) {
		int status = 0;
		try {
			Connection con = produtoDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update user905 set nome=?,unidadeCompra=?,descricao=?,qtdPrevistoMes=?,precoMaxComprado=? where id=?");
			ps.setString(1, e.getNome());
			ps.setInt(2, e.getUnidadeCompra());
			ps.setString(3, e.getDescricao());
			ps.setDouble(4, e.getQtdPrevistoMes());
			ps.setDouble(5, e.getPrecoMaxComprado());
			ps.setInt(6, e.getId());

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
			Connection con = produtoDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user905 where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
	public static produto getProdutoById(int id) {
		produto e = new produto();

		try {
			Connection con = produtoDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905 where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setUnidadeCompra(rs.getInt(3));
				e.setDescricao(rs.getString(4));
				e.setQtdPrevistoMes(rs.getDouble(5));
				e.setPrecoMaxComprado(rs.getDouble(6));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
	
	public static List<produto> getAllProdutos() {
		List<produto> list = new ArrayList<produto>();

		try {
			Connection con = produtoDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				produto e = new produto();
				e.setId(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setUnidadeCompra(rs.getInt(3));
				e.setDescricao(rs.getString(4));
				e.setQtdPrevistoMes(rs.getDouble(5));
				e.setPrecoMaxComprado(rs.getDouble(6));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
