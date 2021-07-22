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

@WebServlet("/SaveOrder")
public class SaveOrder extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sPurchAmt=request.getParameter("purchAmt");
		float purchAmt=Float.parseFloat(sPurchAmt);
		String ordDate=request.getParameter("ordDate");
        String sCustomeId=request.getParameter("customerId");
        int customerId=Integer.parseInt(sCustomeId);
        String sSalesmanId=request.getParameter("salesmanId");
        int salesmanId=Integer.parseInt(sSalesmanId);

        order e=new order();
        e.setPurchAmt(purchAmt);
        e.setOrdDate(ordDate);
        e.setCustomerId(customerId);
        e.setSalesmanId(salesmanId);

		int status = generalDAO.saveOrder(e);
		if (status > 0) {

			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
