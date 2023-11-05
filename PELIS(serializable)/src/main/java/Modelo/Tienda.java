/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * @autor jesus francisco dugarte vargas aka zedeon 
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zedeon
 */
public class Tienda implements Serializable  {
    private String Id_tienda;
    private String nombre;
    private String direccion;
    private ArrayList <Cliente> clientes;

    public Tienda(String Id_tienda, String nombre, String direccion, ArrayList <Cliente>clientesdeunatienda) {
        this.Id_tienda = Id_tienda;
        this.nombre = nombre;
        this.direccion = direccion;
        this.clientes=clientesdeunatienda;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getId_tienda() {
        return Id_tienda;
    }

    public void setId_tienda(String Id_tienda) {
        this.Id_tienda = Id_tienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
