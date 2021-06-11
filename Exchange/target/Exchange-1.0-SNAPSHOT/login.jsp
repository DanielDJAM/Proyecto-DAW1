<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InicioSesion</title>
    <link rel="stylesheet" href="css/loginStyle.css">
</head>
<body>
    <div class="login">
        <div class="login-screen">
            <div class="app-title">
                <img src="img/1_1-.png" alt="">
					<h1>Login</h1>
            </div>
        <form method="post" action="action-login.jsp">
            <div class="login-form">
                <div class="control-group">
                    <input type="text" name="email" placeholder="email" required>
                    <label class="email" for="email"></label>
                    <input type="password" name="contrasenia" placeholder="password" required>
                    <label class="contrasenia" for="contrasenia"></label>
                </div>
                    <a class="btn btn-primary btn-large btn-block" href="action-login.jsp">login</a>
					<a class="login-link" href="registro.jsp"> No tengo cuenta</a>
            </div>
        </form>
            
            </div>
        </div>
    </div>
</body>
</html>