//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package tp02;

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
		out.println("<a href='index.html'>Voltar para o menu</a>");
		out.println("<h1>Lista de Produtos</h1>");

		List<produto> list = produtoDao.getAllProdutos();

		out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Nome</th><th>Unidade de Compra</th><th>Descrição</th><th>Quantidade Previsto</th><th>Preço Máx Comprado</th><th>Editar</th><th>Apagar</th></tr>");

        for(produto e:list){
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getUnidadeCompra()+"</td><td>"+e.getDescricao()+"</td><td>"+e.getQtdPrevistoMes()+"</td><td>"+e.getPrecoMaxComprado()+"<td></td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

		out.close();
	}
}
