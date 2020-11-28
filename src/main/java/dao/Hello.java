package dao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Hello", urlPatterns = "/conexao")
public class Hello extends HttpServlet {
    public Hello() {
        System.out.println("CONSTRUTOR");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("INIT");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("DESTROY");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("SERVICE");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int i = 0;
        //resp.getWriter().println(i++);
        //resp.addCookie(new Cookie("aula", "web"));
        //resp.setStatus(201);

        String cliente = req.getParameter("nome");
        resp.getWriter().println("Ola, " + cliente);

        Connection connection = null;
        try {
            connection = ConectaBanco.getConnection();
        } catch (SQLException ex) {
            resp.getWriter().append("Connection Failed! Check output console");
        }

        if(connection!= null){
            resp.getWriter().append("A conexão com o banco foi realizada!");
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            resp.getWriter().append("A conexão com o banco falhou!");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello World");
    }
}
