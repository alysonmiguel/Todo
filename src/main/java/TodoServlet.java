import dao.TodoDao;
import modelo.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/todo")
public class TodoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            TodoDao.remover(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher encaminhar = request.getRequestDispatcher("/Home.jsp");
        encaminhar.forward(request, response);
    }
}
