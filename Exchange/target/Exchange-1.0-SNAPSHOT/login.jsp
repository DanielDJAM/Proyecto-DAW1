<%@page contentType="text/html" pageEncoding="UTF-8" errorPage = "includes/exceptions/MiembroException.jsp" %>

<!DOCTYPE html>
	<html lang="es">

	<head>
		<meta charset="utf-8">
		<meta name="author" content="Borja G">
		<title>CriptoExchange</title>

		<link rel="stylesheet" href="css/loginStyle.css" />
	</head>

	<body>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<img src="img/1_1-.png" alt="">
					<h1>Login</h1>
				</div>
				<form action="validarUsuario.jsp" method="POST">
					<div class="login-form">

						<div class="control-group">
							<input type="text" class="email"  value="" placeholder="username" id="email">
							<label class="email" for="email"></label>
						</div>

						<div class="control-group">
							<input type="password" class="contrasenia" value="" placeholder="password" id="contrasenia">
							<label class="contrasenia" for="contrasenia"></label>
						</div>

						<a class="btn btn-primary btn-large btn-block" href="validarUsuario.jsp">login</a>
						<a class="login-link" href="registro.jsp"> No tengo cuenta</a>
						<a class="login-link" href="">Lost your password?</a>
					</div>
				</form>
			</div>

		</div>
	</body>