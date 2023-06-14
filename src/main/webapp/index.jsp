<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <title>Biblioteca</title>
</head>
<body class="body">
<h1 class="encabezado">Biblioteca</h1>

<h2 class="subtitulo">Seleccione:</h2>

<br>

<form action="categoria" method="get">
  <div class="centrar">
    <input type="submit" value="Ingresar Categoria" class="boton">
  </div>
</form>

<br>

<form action="libro" method="get">
  <div class="centrar">
    <input type="submit" value="Agregar Libro" class="boton">
  </div>
</form>

<br>

<form action="buscar" method="get">
  <div class="centrar">
    <input type="submit" value="Buscar Libro" class="boton">
  </div>
</form>

<br>

<form action="#" method="get">
  <div class="centrar">
    <input type="submit" value="Eliminar Libro" class="boton">
  </div>
</form>
</body>
</html>