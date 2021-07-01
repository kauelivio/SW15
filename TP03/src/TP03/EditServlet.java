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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Book</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		book e = bookDao.getProdutoById(id);

		out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+ e.getId()+"'/></td></tr>");
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='"+e.getTitle()+"'/></td></tr>");
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='"+e.getAuthor()+"'/></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='number' name='price' value='"+e.getPrice()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

		out.close();
	}
}
