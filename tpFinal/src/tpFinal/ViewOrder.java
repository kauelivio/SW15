//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package tpFinal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewOrder")
public class ViewOrder extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='addOrder.html'>Add New Order</a>");
        out.println("<a href='index.html'>Back to menu</a>");
        out.println("<h1>Order List</h1>");
        
        List<order> list = generalDAO.getAllOrders();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>OrdNo</th><th>PurchAmt</th><th>OrdDate</th><th>Customer</th><th>SalesMan</th><th>Edit</th><th>Delete</th></tr>");
        for(order e:list)
        {
            out.print("<tr><td>" + e.getOrdNo() + "</td><td>" + e.getPurchAmt() + "</td><td> "+e.getOrdDate()+" </td><td> "+e.getCustomerId()+" </td><td> "+e.getSalesmanId()+" </td><td><a href = 'EditOrder?ord_no="+e.getOrdNo()+"'> edit </a></td><td><a href = 'DeleteOrder?ord_no="+e.getOrdNo()+"'> delete </a></td></tr> ");
        }
        out.print("</table>");
        
        out.close();
    }
}
