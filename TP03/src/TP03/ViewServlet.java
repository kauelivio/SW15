//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package TP03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.jsp'>Voltar para o menu</a>");
		out.println("<h1>Book List</h1>");

		List<book> list = bookDao.getAllBooks();

		out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Title</th><th>Author</th><th>Price</th><th>Editar</th><th>Apagar</th></tr>");

        for(book e:list){
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getTitle()+"</td><td>"+e.getAuthor()+"</td><td>"+e.getPrice()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

		out.close();
	}
}
