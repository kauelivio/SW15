//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package tpFinal;

import java.util.*;
import java.sql.*;

public class generalDAO {
	
	public static Connection getConnection() {
		Connection con = null;
		try {

			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			// Database name to access
			String dbName = "tpFinal";
			String dbUsername = "root";
			String dbPassword = "admin";
			Class.forName(dbDriver);

			con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static int saveSalesman(salesman e) 
  {
		int status = 0;
		try {
			Connection con = generalDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(

					"insert into salesman(name,city,commission) values (?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getCity());
			ps.setDouble(3, e.getCommission());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

  public static int updateSalesman(salesman e)
  {
        int status = 0;
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
            "update salesman set name=?,city=?,commission=? where salesman_id=?");
            ps.setString(1, e.getName());
            ps.setString(2, e.getCity());
            ps.setDouble(3, e.getCommission());
            ps.setInt(4, e.getId());

            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return status;
  }

  public static int deleteSalesman(int id)
  {
        int status = 0;
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from salesman where salesman_id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return status;
  }

  public static salesman getSalesmanById(int id)
  {
        salesman e = new salesman();
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from salesman where salesman_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setCity(rs.getString(3));
                e.setCommission(rs.getFloat(4));
            }
            con.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return e;
  }

  public static List<salesman> getAllSalesmans()
  {
        List<salesman> list = new ArrayList<salesman>();

        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from salesman");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                salesman e = new salesman();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setCity(rs.getString(3));
                e.setCommission(rs.getFloat(4));
                list.add(e);
            }
            con.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return list;
  }
	
	public static int saveCustomer(customer e) 
  {
		int status = 0;
		try {
			Connection con = generalDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(

					"insert into customer(cust_name,city,grade,salesman_id) values (?,?,?,?)");
			ps.setString(1, e.getCustName());
			ps.setString(2, e.getCity());
			ps.setInt(3, e.getGrade());
			ps.setInt(4, e.getSalesmanId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
  
  public static int updateCustomer(customer e)
  {
        int status = 0;
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
            "update customer set cust_name=?,city=?,grade=?,salesman_id=? where customer_id=?");
            ps.setString(1, e.getCustName());
		    ps.setString(2, e.getCity());
		    ps.setInt(3, e.getGrade());
		    ps.setInt(4, e.getSalesmanId());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return status;
  }

  public static int deleteCustomer(int id)
  {
        int status = 0;
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from customer where customer_id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return status;
  }

  public static customer getCustomerById(int id)
  {
        customer e = new customer();
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from customer where customer_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                e.setId(rs.getInt(1));
                e.setCustName(rs.getString(2));
                e.setCity(rs.getString(3));
                e.setGrade(rs.getInt(4));
                e.setSalesmanId(rs.getInt(5));
            }
            con.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return e;
  }

  public static List<customer> getAllCustomers()
  {
        List<customer> list = new ArrayList<customer>();

        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from customer");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                customer e = new customer();
                e.setId(rs.getInt(1));
                e.setCustName(rs.getString(2));
                e.setCity(rs.getString(3));
                e.setGrade(rs.getInt(4));
                e.setSalesmanId(rs.getInt(5));
                list.add(e);
            }
            con.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return list;
  }

	public static int saveOrder(order e) 
  {
		int status = 0;
		try {
			Connection con = generalDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(

					"insert into orders(purch_amt,ord_date,customer_id,salesman_id) values (?,?,?,?)");
			ps.setDouble(1, e.getPurchAmt());
			ps.setString(2, e.getOrdDate());
			ps.setInt(3, e.getCustomerId());
			ps.setInt(4, e.getSalesmanId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

  public static int updateOrder(order e)
  {
        int status = 0;
        try
        {
        	Connection con = generalDAO.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	        "update orders set purch_amt=?,ord_date=?,customer_id=?,salesman_id=? where ord_no=?");
	        ps.setDouble(1, e.getPurchAmt());
	        ps.setString(2, e.getOrdDate());
		    ps.setInt(3, e.getCustomerId());
		    ps.setInt(4, e.getSalesmanId());
            ps.setInt(5, e.getOrdNo());

            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return status;
  }

  public static int deleteOrder(int id)
  {
        int status = 0;
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from orders where ord_no=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return status;
  }

  public static order getOrderById(int id)
  {
        order e = new order();
        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from orders where ord_no=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                e.setOrdNo(rs.getInt(1));
                e.setPurchAmt(rs.getFloat(2));
                e.setOrdDate(rs.getString(3));
                e.setCustomerId(rs.getInt(4));
                e.setSalesmanId(rs.getInt(5));
            }
            con.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return e;
  }

  public static List<order> getAllOrders()
  {
        List<order> list = new ArrayList<order>();

        try
        {
            Connection con = generalDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from orders");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                order e = new order();
                e.setOrdNo(rs.getInt(1));
                e.setPurchAmt(rs.getFloat(2));
                e.setOrdDate(rs.getString(3));
                e.setCustomerId(rs.getInt(4));
                e.setSalesmanId(rs.getInt(5));
                list.add(e);
            }
            con.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return list;
  }

}
