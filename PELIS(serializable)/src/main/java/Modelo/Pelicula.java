/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * @autor jesus francisco dugarte vargas aka zedeon 
 */
package Modelo;
import Modelo.Almacena;
import java.io.Serializable;
/**
 *
 * @author Zedeon
 */
public class Pelicula implements Serializable{
    
    private String cod_pelicula;
    public String titulo;
    public String genero;
    public String fecha_estreno;
    private Cinta cinta_donde_se_almacena;

    public Pelicula(String cod_pelicula, String titulo, String genero, String fecha_estreno, Cinta cinta_donde_se_almacena) {
        this.cod_pelicula = cod_pelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.fecha_estreno = fecha_estreno;
        this.cinta_donde_se_almacena = cinta_donde_se_almacena;
    }

    public Cinta getCinta_donde_se_almacena() {
        return cinta_donde_se_almacena;
    }

    public void setCinta_donde_se_almacena(Cinta cinta_donde_se_almacena) {
        this.cinta_donde_se_almacena = cinta_donde_se_almacena;
    }
    

    public String getCod_pelicula() {
        return cod_pelicula;
    }

    public void setCod_pelicula(String cod_pelicula) {
        this.cod_pelicula = cod_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(String fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

  
}
