<%-- Document : index Created on : May 30, 2023, 10:10:04 AM Author : Levi.ing --%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link href="css/styles.css" rel="stylesheet" />
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title >Clientes</title>
        
        </head>
        
        
        
        <body class="bg-black" >
            <h1 style="color: white; display: flex; justify-content: center" class="text-uppercase mb-5" >Clientes</h1>
            <table  class=" tablas"  width="80%" >
                <thead  style="color: white">
                    <th>Dni</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th>Id Ventas</th>
                    <th>Total a pagar</th>
                    <th></th>
                    <th></th>
                </thead>

                <tbody style="color: white">
                    <c:forEach var="clientes" items="${lista}">
                        <tr>
                            <td>
                                <c:out value="${clientes.dni}" />
                            </td>
                            <td>
                                <c:out value="${clientes.nombre}" />
                            </td>
                            <td>
                                <c:out value="${clientes.correo}" />
                            </td>
                            <td>
                                <c:out value="${clientes.telefono}" />
                            </td>
                            <td>
                                <c:out value="${clientes.direccion}" />
                            </td>
                            <td>
                                <c:out value="${clientes.idventas}" />
                            </td>
                            <td>
                                <c:out value="${clientes.totalpagar}" />
                            </td>
                            <td><a href="ClientesController?accion=modificar&id=<c:out value="
                                    ${producto.id}" />">Modificar</a></td>
                            <td><a href="ClientesController?accion=eliminar&id=<c:out value="
                                    ${producto.id}" />">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>

        </html>