<%--
  Created by IntelliJ IDEA.
  User: Aspire3
  Date: 06-06-2023
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Ingresar Categoria</title>
</head>
<body>
<h1 class="encabezado">Ingresar Categoria</h1>

<form action="categoria" method="post">
    <div class="centrar">
        <label>Categoria: </label>
        <input name="categoria" type="text" class="campoTexto">
        <br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
<a class="centrar" href="index.jsp">Volver</a>
</body>
</html>
