/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ltrbomb10
 */
public class Producto {
    
    private String codigo;
    private String descripcion;
    private double precio;
    
    Producto() {
        setCodigo("");
        setDescripcion("");
        setPrecio(0);
    }
    
    private static Scanner in =  new Scanner(System.in);
    private static int cantidadDeElementos;
    private static File file;
    private static DataOutputStream dos;
    private static DataInputStream dis;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(!codigo.isEmpty()) {
            this.codigo = codigo;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio >= 0)
            this.precio = precio;
    }
    
    public static void capturarProductos(){

    }
    
    public static void leerProductos() {
        
    }
    
    public static void mostrarProductos() {
        
    }
    
    @Override
    public String toString() {
       return "Codigo: " + codigo 
               + "\nDescripcion: " + descripcion 
               + "\nPrecio: " + precio; 
    }
}
