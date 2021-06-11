<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.developers.controller.MiembroController' %>
<%@ page import='es.iespuertolacruz.developers.api.Miembro' %>
<%@ page errorPage = "loginException.jsp" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de verificacion de usuario</title>
        <link rel="stylesheet" href="css/style.css">
            
    </head>

    <body>
        <h1>Verificacion Usuario</h1>

        <jsp:useBean id="controller" class="es.iespuertolacruz.developers.controller.MiembroController" />
        <% String email = request.getParameter("email"); %>
        <%  String contrasenia = request.getParameter("contrasenia"); %>
        <%  String tipo = request.getParameter("tipo"); %>
        <% MiembroController miembroController = new MiembroController(); %>
        <% Miembro miembro = miembroController.login(email,contrasenia); %>

        <% if (miembro.getTipoUsuario().equals("admin")){
            response.sendRedirect("http://localhost:8080/admin-page.jsp"); 
        }
        %>
        <% if (miembro.getTipoUsuario().equals("miembro")){
            response.sendRedirect("http://localhost:8080/index.jsp"); 
        }
        %>

        <table>
            <tr>
                <th>DatosPersonales</th>
                <th>email</th>
                <th>contrasenia</th>
                <th>Direccion</th>
                <th>Tarjeta</th>
            </tr>
            <tr>
                <td><%= miembro.getDatosPersonales()%></td>
                <td><%= miembro.getEmail()%></td>
                <td><%= miembro.getContrasenia()%></td>
                <td><%= miembro.getDireccion()%></td>
                <td><%= miembro.getTarjeta()%></td>
            </tr>
        </table>
    </body>

</html>
