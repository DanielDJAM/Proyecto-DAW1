<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InicioSesion</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <div class="page">
        <h1>Inicio Sesion</h1>
        <p>Seleccion que rol quieres iniciar sesion</p>
        <form method="post" action="action-login.jsp">
            <div class="login">
                <input type="text" name="email" placeholder="email" required>
                <input type="password" name="contrasenia" placeholder="password" required>
            </div>
            <input type="submit" value="Continuar"> <br>
        </form>

        <div class="bottom-container">
            <div class="row">
                <div class="col">
                    <a href="registro.jsp" style="color:black" class="btn">Registrarse</a>
                </div>
                <div class="col">
                    <a href="#" style="color:black" class="btn">olvido su Contraseña?</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>