<!DOCTYPE html>
<html lang="es">
    <%@page contentType="text/html" pageEncoding="UTF8"%>
<head>
	<meta charset="utf-8">
	<meta name="author" content="Borja G">
	<title>CriptoExchange</title>

    <link rel="stylesheet" href="css/loginStyle.css"/>
</head>
<body>
	<div class="login">
		<div class="login-screen">
			<div class="app-title">
                <img src="img/1_1-.png" alt="">
				<h1>Login</h1>
			</div>

			<div class="login-form">
				<div class="control-group">
				<input type="text" class="login-field" value="" placeholder="username" id="login-name">
				<label class="login-field-icon fui-user" for="login-name"></label>
				</div>

				<div class="control-group">
				<input type="password" class="login-field" value="" placeholder="password" id="login-pass">
				<label class="login-field-icon fui-lock" for="login-pass"></label>
				</div>

				<a class="btn btn-primary btn-large btn-block" href="#">login</a>
                <a class="login-link" href="registro.jsp"> No tengo cuenta</a>
				<a class="login-link" href="#">Lost your password?</a>
			</div>
		</div>
	</div>
</body>