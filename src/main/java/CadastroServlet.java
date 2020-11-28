import dao.TodoDao;
import modelo.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Cadastro")
public class CadastroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Todo todo = new Todo();
        todo.setNome(request.getParameter("nome"));
        todo.setDescricao(request.getParameter("descricao"));

        TodoDao dao = new TodoDao();

        Boolean req = null;
        try {
            req = dao.inserir(todo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(req == true) {
            out.println("Cadastrado com sucesso");
            response.sendRedirect("/Home.jsp"); //
        } else {
            out.println("Erro ao cadastrar");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("ola");
    }
}
