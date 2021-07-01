//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package TP03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		String title=request.getParameter("title");
        String author=request.getParameter("author");
        String sprice=request.getParameter("price");
        float price=Float.parseFloat(sprice);

        book e = new book();
        e.setId(id);
        e.setTitle(title);
        e.setAuthor(author);
        e.setPrice(price);

		int status = bookDao.update(e);
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
