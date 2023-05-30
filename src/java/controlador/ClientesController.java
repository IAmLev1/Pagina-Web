/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Clientes;
import modelo.ClientesDao;

/**
 *
 * @author Levi.ing
 */
@WebServlet(name = "ClientesController", urlPatterns = {"/ClientesController"})
public class ClientesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClientesDao clientesDao = new ClientesDao();
        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("clientes/index.jsp");
            List<Clientes> listaClientes = clientesDao.listarClientes();
            request.setAttribute("lista", listaClientes);
            
        } else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("clientes/nuevo.jsp");
            
        } else if (accion.equals("insertar")) {
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String idventa = request.getParameter("idventa");
            Double totalpagar = Double.parseDouble(request.getParameter("totalpagar"));
            Clientes producto = new Clientes(0, nombre, dni, telefono, correo, direccion, idventa, totalpagar);
            clientesDao.insertar(producto);

            dispatcher = request.getRequestDispatcher("clientes/index.jsp");
            List<Clientes> listaProductos = clientesDao.listarClientes();
            request.setAttribute("lista", listaProductos);
            
        } else if (accion.equals("modificar")) {
            dispatcher = request.getRequestDispatcher("clientes/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Clientes clientes = clientesDao.mostarClientes(id);
            request.setAttribute("producto", clientes);
            
        } else if (accion.equals("actualizar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String idventa = request.getParameter("idventa");
            Double totalpagar = Double.parseDouble(request.getParameter("totalpagar"));
            Clientes producto = new Clientes(id, nombre, dni, telefono, correo, direccion, idventa, totalpagar);
            clientesDao.actualizar(producto);

            dispatcher = request.getRequestDispatcher("clientes/index.jsp");
            List<Clientes> listaClientes = clientesDao.listarClientes();
            request.setAttribute("lista", listaClientes);
            
        } else if (accion.equals("eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));

            clientesDao.eliminar(id);
            dispatcher = request.getRequestDispatcher("clientes/index.jsp");
            List<Clientes> listaClientes = clientesDao.listarClientes();
            request.setAttribute("lista", listaClientes);
        } else {
            dispatcher = request.getRequestDispatcher("clientes/index.jsp");
            List<Clientes> listaClientes = clientesDao.listarClientes();
            request.setAttribute("lista", listaClientes);
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
