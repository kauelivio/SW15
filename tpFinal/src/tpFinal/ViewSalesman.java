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

@WebServlet("/ViewSalesman")
public class ViewSalesman extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='addSalesman.html'>Add New Salesman</a>");
        out.println("<a href='index.html'>Back to menu</a>");
        out.println("<h1>Salesman List</h1>");
        
        List<salesman> list = generalDAO.getAllSalesmans();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Name</th><th>City</th><th>Commission</th><th>Edit</th><th>Delete</th></tr>");
        for(salesman e:list)
        {
            out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td> "+e.getCity()+" </td><td> "+e.getCommission()+" </td><td><a href = 'EditSalesman?salesman_id="+e.getId()+"'> edit </a></td><td><a href = 'DeleteSalesman?salesman_id="+e.getId()+"'> delete </a></td></tr> ");
        }
        out.print("</table>");
        
        out.close();
    }
}
