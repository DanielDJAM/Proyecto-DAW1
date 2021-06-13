<%@page import="es.iespuertolacruz.developers.excepcion.MiembroException" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="es">

            <head>
                <meta charset="utf-8">
                <meta name="author" content="Borja G">
                <title>Error Page</title>


                <link rel="stylesheet" href="css/errorStyle.css" />


            </head>

            <body>

                <div class="login">
                    <div class="login-screen">
                        <div class="app-title">
                            <img class="imagen" src="../../img/6.png" alt="">

                        </div>
                        <form action="validarUsuario.jsp" method="POST">
                            <div class="login-form">

                                <div class="control-group">

                                </div>

                                <div class="control-group">
                                    <h1 class="control-group">
                                        <% MiembroException e=(MiembroException) exception; String
                                            message=e.getMessage(); %>
                                            <%=message %></a>
                                    </h1>
                                </div>


                                <a class="login-link" href="login.jsp"> Volver a intentarlo</a>

                            </div>
                        </form>
                    </div>

                </div>
            </body>

            </html>