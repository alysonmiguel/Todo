<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Todo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.TodoDao" %>

<html>
  <head>
      <!-- Required meta tags -->
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

      <title>Home</title>
  </head>
  <body>

  <div class="container card mb-5 mt-2 bg-light">
      <div class="card-body" >
          <form action="${pageContext.request.contextPath}/Cadastro" method="post">
              <p> <label>Nome:</label>
                <input class="form-control" required minlength="3" maxlength="50" type="text" id="nome" name="nome"> </p>

              <p> <label>Descrição:</label>
                  <input class="form-control" type="text" id="descricao" name="descricao"> </p>

                  <button type="submit" class="btn btn-primary btn-lg btn-block">Salvar</button>

          </form>
      </div>
  </div>

  <div class="container ">
      <div class="table-responsive">
          <table class="table table-hover mb-1">
              <thead class="thead-dark" >
                  <tr>
                      <th>Nome</th>
                      <th>Descrição</th>
                      <th>Remover</th>
                  </tr>
              </thead>

              <tbody>
                  <%
                      TodoDao dao = new TodoDao();
                      ArrayList<Todo> listarTodo = (ArrayList<Todo>) dao.listarTodo();
                  %>
                  <% for (Todo t: listarTodo) { %>
                  <tr>
                      <td><% out.println(t.getNome());  %></td>
                      <td><% out.println(t.getDescricao()); %></td>
                      <td>
                      <%
                          String path = pageContext.getServletContext().getContextPath();
                          out.print(  "<a class=\"btn btn-outline-danger\" href='"+path+"/todo?id="+ t.getId()+ "'> Remover </a> ");
                      %>
                      </td>
                  </tr>
                  <% } %>
              </tbody>
          </table>
      </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

  </body>
</html>
