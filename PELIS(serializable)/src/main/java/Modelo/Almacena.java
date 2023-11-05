/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * @autor jesus francisco dugarte vargas aka zedeon 
 */
package Modelo;
import Modelo.Cinta;
import Modelo.Pelicula;
import java.io.Serializable;

/**
 *
 * @author Zedeon
 */
public class Almacena implements Serializable {
    public Cinta una_cinta;
    public Pelicula una_peli;
    public String una_fecha;

    public Almacena(Cinta una_cinta, Pelicula una_peli, String una_fecha) {
        this.una_cinta = una_cinta;
        this.una_peli = una_peli;
        this.una_fecha = una_fecha;
    }

    public Cinta getUna_cinta() {
        return una_cinta;
    }

    public void setUna_cinta(Cinta una_cinta) {
        this.una_cinta = una_cinta;
    }

    public Pelicula getUna_peli() {
        return una_peli;
    }

    public void setUna_peli(Pelicula una_peli) {
        this.una_peli = una_peli;
    }

    public String getUna_fecha() {
        return una_fecha;
    }

    public void setUna_fecha(String una_fecha) {
        this.una_fecha = una_fecha;
    }
    
    
}
