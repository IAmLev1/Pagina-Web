/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Levi.ing
 */
public class ClientesDao {
    
    Connection conexion;   

    public ClientesDao(){
        
        Conexion con = new Conexion();
        conexion =  con.getConexion();
    }
    
    public List<Clientes> listarClientes() {

        PreparedStatement ps;
        ResultSet rs;

        List<Clientes> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, dni, nombre, correo, telefono, direccion, idventa, totalpagar FROM clientes");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                String idVenta = rs.getString("idventa");
                Double totalpagar = rs.getDouble("totalpagar");
                

                Clientes clientes = new Clientes( id, nombre, dni, telefono, correo, direccion, idVenta, totalpagar);
                lista.add(clientes);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.toString());
            return null;
        }
    }
    
        public Clientes mostarClientes(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Clientes clientes = null;

        List<Clientes> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, dni, nombre, correo, telefono, direccion, idventa, totalpagar FROM clientes WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                String idVenta = rs.getString("id venta");
                Double totalpagar = rs.getDouble("totalpagar");

                clientes = new Clientes( id, nombre, dni, telefono, correo, direccion, idVenta, totalpagar);

            }
            return clientes;
        } catch (SQLException e) {
            System.out.println("Error al mostrar producto: " + e.toString());
            return null;
        }
    }

    public boolean insertar(Clientes clientes) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO clientes (dni, nombre, correo, telefono, direccion, idventa, totalpagar) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, clientes.getDni());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getCorreo());
            ps.setString(4, clientes.getTelefono());
            ps.setString(5, clientes.getDireccion());
            ps.setString(6, clientes.getIdventas());
            ps.setDouble(7, clientes.getTotalpagar());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.toString());
            return false;
        }
    }
    
    public boolean actualizar(Clientes clientes) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE productos SET dni=?, nombre=?, correo=?, telefono=?, direccio=?, idventa=?, totalpagar=? WHERE id=?");
            ps.setString(1, clientes.getDni());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getCorreo());
            ps.setString(4, clientes.getTelefono());
            ps.setString(5, clientes.getDireccion());
            ps.setString(6, clientes.getIdventas());
            ps.setDouble(7, clientes.getTotalpagar());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM productos WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.toString());
            return false;
        }
    }

    
}
