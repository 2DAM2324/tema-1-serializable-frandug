/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * @autor jesus francisco dugarte vargas aka zedeon 
 */
package Modelo;
import Modelo.Almacena;
import Modelo.Pelicula;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zedeon
 */
public class Cinta implements Serializable {
    
    private String cod_cint;
    public String formato;
    public Pelicula Pelicula_almacenada; 

    public Cinta(String cod_cint, String formato, Pelicula una_pelicula) {
        this.cod_cint = cod_cint;
        this.formato = formato;
        this.Pelicula_almacenada = una_pelicula; 

    }

    public String getCod_cint() {
        return cod_cint;
    }

    public void setCod_cint(String cod_cint) {
        this.cod_cint = cod_cint;
    }   

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Pelicula getPelicula_almacenada() {
        return Pelicula_almacenada;
    }

    public void setPelicula_almacenada(Pelicula Pelicula_almacenada) {
        this.Pelicula_almacenada = Pelicula_almacenada;
    }

}
 