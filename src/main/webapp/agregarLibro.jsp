<%--
  Created by IntelliJ IDEA.
  User: Aspire3
  Date: 13-06-2023
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Ingresar Libro</title>
</head>
<body>
<h1 class="encabezado">Ingresar Libro</h1>
<form action="libro" method="post">
    <div class="centrado">
        <label>ID: </label>
        <input name="id_libro" type="number" class="campoTexto">
        <br>
        <label>Nombre: </label>
        <input name="nombre" type="text" class="campoTexto">
        <br>
        <label>Editorial: </label>
        <input name="editorial" type="text" class="campoTexto">
        <br>
        <label>Categoria: </label>
        <input name="categoria" type="text" class="campoTexto">
        <br>
        <label>Año de Publicación: </label>
        <input name="año" type="number" class="campoTexto">
        <br>
        <label>Tipo de Libro: </label>
        <select name="tipo_libro" class="texto">
            <option value="fisico">Fisico</option>
            <option value="digital">Digital</option>
        </select>
        <br><br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
<
</body>
</html>
