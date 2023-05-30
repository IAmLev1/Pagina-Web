<%-- 
    Document   : modificar
    Created on : May 30, 2023, 12:24:53 AM
    Author     : Levi.ing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar producto</title>
    </head>
    <body>
        <h1>Modificar registro</h1>

        <form action="ClientesController?accion=actualizar" method="POST" autocomplete="off">

            <input type="hidden" id="id" name="id" value="<c:out value="${producto.id}" />" />

            <p>
                Código: <input type="text" id="codigo" name="codigo" value="<c:out value="${producto.codigo}" />" required />
            </p>

            <p>
                Nombre: <input type="text" id="nombre" name="nombre" value="<c:out value="${producto.nombre}" />" required />
            </p>

            <p>
                Precio: <input type="text" id="precio" name="precio" value="<c:out value="${producto.precio}" />" required />
            </p>

            <p>
                Existencia <input type="text" id="existencia" name="existencia" value="<c:out value="${producto.existencia}" />" required />
            </p>

            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>