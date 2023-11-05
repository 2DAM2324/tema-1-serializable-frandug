/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * @autor jesus francisco dugarte vargas aka zedeon 
 */

package Modelo;
import java.util.ArrayList;
import Modelo.Alquila;
import java.io.Serializable;
/**
 *
 * @author Zedeon
 */
public class Cliente  implements Serializable {
    private String dni;
    public String nombre;
    public String tlf;
    ArrayList<Alquila>alquileres_del_cliente = new ArrayList<Alquila>();
    ArrayList<Tienda>tiendas_del_cliente = new ArrayList<Tienda>();

    public ArrayList<Tienda> getTiendas_del_cliente() {
        return tiendas_del_cliente;
    }

    public void setTiendas_del_cliente(ArrayList<Tienda> tiendas_del_cliente) {
        this.tiendas_del_cliente = tiendas_del_cliente;
    }
    
    public Cliente(String dni, String nombre, String tlf, ArrayList<Alquila> alquileres_del_cliente,ArrayList<Tienda>Tiendas_del_cliente) {
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
        this.alquileres_del_cliente = alquileres_del_cliente;
        this.tiendas_del_cliente = Tiendas_del_cliente;
    }

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getDni() {
        return dni;
    }
    public boolean perteneceATienda(String idTienda) {
        for (Tienda tienda : tiendas_del_cliente) {
            if (tienda.getId_tienda().equals(idTienda)) {
                return true; // El cliente pertenece a la tienda
            }
        }
        return false; // El cliente no pertenece a la tienda
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

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public ArrayList<Alquila> getAlquileres_del_cliente() {
        return alquileres_del_cliente;
    }

    public void setAlquileres_del_cliente(ArrayList<Alquila> alquileres_del_cliente) {
        this.alquileres_del_cliente = alquileres_del_cliente;
    }
    
}
