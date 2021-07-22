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

@WebServlet("/ViewCustomer")
public class ViewCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='addCustomer.html'>Add New Customer</a>");
        out.println("<a href='index.html'>Back to menu</a>");
        out.println("<h1>Customer List</h1>");
        
        List<customer> list = generalDAO.getAllCustomers();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Name</th><th>City</th><th>Grade</th><th>SalesMan</th><th>Edit</th><th>Delete</th></tr>");
        for(customer e:list)
        {
            out.print("<tr><td>" + e.getId() + "</td><td>" + e.getCustName() + "</td><td> "+e.getCity()+" </td><td> "+e.getGrade()+" </td><td> "+e.getSalesmanId()+" </td><td><a href = 'EditCustomer?customer_id="+e.getId()+"'> edit </a></td><td><a href = 'DeleteCustomer?customer_id="+e.getId()+"'> delete </a></td></tr> ");
        }
        out.print("</table>");
        
        out.close();
    }
}
