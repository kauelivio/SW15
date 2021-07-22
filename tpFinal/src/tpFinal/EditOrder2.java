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

@WebServlet("/EditOrder2")
public class EditOrder2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();

		    String sordNo = request.getParameter("ord_no");
		    int ordNo = Integer.parseInt(sordNo);
		    String spurchAmt = request.getParameter("purch_amt");
		    float purchAmt = Float.parseFloat(spurchAmt);
		    String ordDate = request.getParameter("ord_date");
		    String scustomer = request.getParameter("customer_id");
		    int customer = Integer.parseInt(scustomer);
		    String ssalesman = request.getParameter("salesman_id");
		    int salesman = Integer.parseInt(ssalesman);

		    order e = new order();
		    e.setOrdNo(ordNo);
		    e.setPurchAmt(purchAmt);
		    e.setOrdDate(ordDate);
		    e.setCustomerId(customer);
		    e.setSalesmanId(salesman);

		    int status = generalDAO.updateOrder(e);
		    if(status>0)
		    {
		        response.sendRedirect("ViewOrder");
		    }
		    else
		    {
		        out.println("Sorry! unable to update record");
		    }

		        out.close();
		    }
}
