/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * @autor jesus francisco dugarte vargas aka zedeon 
 */
package Modelo;
import Modelo.Cinta;
import Modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Zedeon
 */
public class Alquila implements Serializable {
    private String Dni_clt;
    private String Fecha;
    private  String id_cinta; 

    public String getId_cliente() {
        return Dni_clt;
    }

    public void setId_cliente(String id_cliente) {
        this.Dni_clt = id_cliente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getId_cinta() {
        return id_cinta;
    }

    public void setId_cinta(String id_cinta) {
        this.id_cinta = id_cinta;
    }

    public Alquila(String id_cliente, String Fecha, String id_cinta) {
        this.Dni_clt = id_cliente;
        this.Fecha = Fecha;
        this.id_cinta = id_cinta;
    }
    

}
