//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package tpFinal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditOrder")
public class EditOrder extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Order</h1>");
        String sid = request.getParameter("ord_no");
        int id = Integer.parseInt(sid);

        order e = generalDAO.getOrderById(id);

        out.print("<form action='EditOrder2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='ord_no' value='"+ e.getOrdNo()+"'/></td></tr>");
        out.print("<tr><td>PURCH AMT:</td><td><input type='text' name='purch_amt' value= '"+e.getPurchAmt()+"' /></ td ></ tr > ");
        out.print("<tr><td>ORD DATE:</td><td><input type='text' name='ord_date' value='"+e.getOrdDate()+"'/></td></tr>");
        out.print("<tr><td>Customer:</td><td><input type='text' name='customer_id' value= '"+e.getCustomerId()+"' /></ td ></ tr > ");
        out.print("<tr><td>Salesman:</td><td><input type='text' name='salesman_id' value= '"+e.getSalesmanId()+"' /></ td ></ tr > ");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
