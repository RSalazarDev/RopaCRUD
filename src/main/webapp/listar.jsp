<%-- 
    Document   : listar
    Created on : Mar 14, 2021, 6:05:46 PM
    Author     : salaz
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Prenda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   
        <title>JSP Page</title>
        <style>
            #lista { padding: 30px}
        </style>
    </head>
    <body>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="index.jsp">Tienda Bosco</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="ServletPrenda?op=listar">Listar Prendas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletPrenda?op=insert1"">Nueva Prenda</a>
      </li>
     
    </ul>
  </div>
</nav>
        <div  id="lista">
        <h1>Listado de prendas</h1>
        <% List<Prenda> misPrendas = (List<Prenda>) request.getAttribute("misPrendas");
        %>
        <table class="table table-hover">
            <tr><th>id</th><th>Cantidad</th><td>Tipo</td><td>Color</td><td>Borrar</td><td>Actualizar</td></tr>
            <% for( Prenda p: misPrendas) { 
                
            String cadenaBorrar = "<a onclick='return Confirmation()' href='ServletPrenda?op=borrar&id="+p.getId()+"'><i class='fas fa-trash-alt'></i></i></a>";
            String cadenaActualizar = "<a href='ServletPrenda?op=update1&id="+p.getId()+"'><i class='fas fa-wrench'></i></a>";
             %>
            <tr>
                <td><%=p.getId()%></td><td><%=p.getCantidad()%></td><td><%=p.getTipo()%></td>
                <td><%=p.getColor()%></td><td><%=cadenaBorrar%></td><td><%=cadenaActualizar%></td>
        
            </tr>    
            
            <% } %>
        </table>
        </div>
        <script>
            function Confirmation(){
                if ( confirm("Está seguro?")==true) {
                    alert("Procedo a borrar");
                    return true;
                }else {
                    alert("Operación cancelada");
                    return false;
                }
            }
        </script>

 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
