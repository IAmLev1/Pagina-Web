/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Levi.ing
 */
public class Clientes {
    
    private int id;
    private String dni, nombre, correo, telefono, direccion, idventas;
    private double totalpagar;

    public Clientes(int id, String nombre, String dni, String telefono, String correo, String direccion, String idventas, double totalpagar) {
        this.id = id;
        this.telefono = telefono;
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.idventas = idventas;
        this.totalpagar = totalpagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdventas() {
        return idventas;
    }

    public void setIdventas(String idventa) {
        this.idventas = idventa;
    }

    public double getTotalpagar() {
        return totalpagar;
    }

    public void setTotalpagar(double totalpagar) {
        this.totalpagar = totalpagar;
    }
    
    
}
