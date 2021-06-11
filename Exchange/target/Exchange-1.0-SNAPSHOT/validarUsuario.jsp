<%@page contentType="text/html" pageEncoding="UTF8" %>
<%@ page import='es.iespuertolacruz.developers.api.Miembro' %>
<%@ page errorPage = "includes/exceptions/loginException.jsp" %>


    <htm lang= "es">
    <body>
        <h1>Verificar datos</h1>
        <jsp:useBean id="miembroController" class="es.iespuertolacruz.developers.controller.MiembroController"/>

        <% String email = request.getParameter("email"); %>
        <% String contrasenia = request.getParameter("contrasenia"); %>  
        <% Miembro miembro = miembroController.login(email,contrasenia); %>
       
    </body>
</html>

