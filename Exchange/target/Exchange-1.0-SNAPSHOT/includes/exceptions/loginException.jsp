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
                <form action="" method="post">


                    <br><br>
                    <div class="mensaje">
                        <table>
                            <tr>
                                <th scope=""></th>

                                <td>
                                    <p>
                                        <% MiembroException e=(MiembroException) exception; 
                                        String message=e.getMessage(); %>
                                             <%=message %></a> 
                                                <img src="../../img/6.png" alt="">
                                                <br>
                                                <a class="enlace" href="../../login.jsp"> Pulse para intentarlo de nuevo</a>
                                              
                                    </p>


                                </td>



                            </tr>
                        </table>
                    </div>

                </form>
            </body>

            </html>