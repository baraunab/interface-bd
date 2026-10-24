package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.dao.ConsultaDAO;
import model.vo.Schemata;

public class InterfaceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter saida = resp.getWriter();
        ConsultaDAO banco = new ConsultaDAO();
        saida.println("<!DOCTYPE html><html><head><title>Consulta Cidades</title><style>html * {   font-size: 1.25em !important;   font-family: 'Courier New', sans-serif;}</style></head><body><table border=1px>");

        for(Schemata s : banco.listaBancos()) {
            saida.println("<tr><td> <button>" + s.getSchema_name() + "</button></td></tr>");
        }

        saida.println("</table></body></html>");
    }
}
