<%-- 
    Document   : index
    Created on : 21/01/2015, 10:01:00 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/login.css">
        <link rel="shortcut icon" href="img/cara.png">
        <title>Login</title>
    </head>
    <body>
        <section class="Section">
            <h1 class="Section-title">Login</h1>
            <form action="">
            	<input type="email" class="Section-txt" placeholder="Email" required>
            	<input type="password" class="Section-txt" placeholder="Password" required>
            	<input type="submit" class="Section-submit" value="Enviar">
                <p>¿Eres nuevo por aqui?, pues <a href="sRegistro" class="Section-link">Registrate</a></p>
            </form>
        </section>
    </body>
</html>
