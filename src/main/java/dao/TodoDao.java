package dao;

import modelo.Todo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TodoDao {
    public TodoDao() {
    }

    public static boolean inserir(Todo todo) throws SQLException {
        String sql = "INSERT INTO todo(nome,descricao) VALUES (?,?)";
        Boolean update = false;
        PreparedStatement prepared = ConectaBanco.getConnection().prepareStatement(sql);
        try {
            prepared.setString(1, todo.getNome());
            prepared.setString(2, todo.getDescricao());
            if (prepared.executeUpdate() > 0) {
                update = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TodoDao.class.getName()).log(Level.SEVERE, null, ex); // **
            update = false;
        }
        return update;
    }

    public static List<Todo> listarTodo() throws SQLException {

        String sql = "SELECT * FROM todo";

        List<Todo> retorno = new ArrayList<Todo>();

        PreparedStatement prepared = ConectaBanco.getConnection().prepareStatement(sql);
        try {
            ResultSet res = prepared.executeQuery();
            while(res.next()){
                Todo t = new Todo();
                t.setId(res.getInt("id"));
                t.setNome(res.getString("nome"));
                t.setDescricao(res.getString("descricao"));
                retorno.add(t);
            }
        }catch (SQLException ex) {
            Logger.getLogger(TodoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public static void remover(int id) throws SQLException {

        String sql = "DELETE FROM todo WHERE id = ?";
        PreparedStatement prepared = ConectaBanco.getConnection().prepareStatement(sql);
        try {
            prepared.setInt(1, id);
            prepared.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(TodoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
