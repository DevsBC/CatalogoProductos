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
    
    private static String codigo;
    private static String descripcion;
    private static double precio;
    
    Producto() {
        setCodigo("");
        setDescripcion("");
        setPrecio(0);
    }
    
    private static Scanner in =  new Scanner(System.in);
    private static int[] cantidadDeElementos;
    private static File file = new File("productos.dat");
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
        try {    
            Producto p = new Producto();
            int count = 0;
            String exit = "";
            String codigo = "";
            String descripcion = "";
            int precio = 0;
            file.createNewFile();
             
            dos = new DataOutputStream(
                  new BufferedOutputStream(
                  new FileOutputStream(file)));
            
            while(!exit.equalsIgnoreCase("S")){
                System.out.print("Ingrese el codigo: ");
                codigo = in.next();
                p.setCodigo(codigo);
                dos.writeUTF(codigo);
                System.out.print("Ingrese la descripcion: ");
                descripcion = in.next();
                p.setDescripcion(descripcion);
                System.out.print("Ingrese el precio: ");
                precio = in.nextInt();
                p.setPrecio(precio);
                count++;
                System.out.print("Ha terminado?(S/N):");
                exit = in.next();      
            }
            cantidadDeElementos = new int[count];
        
            System.out.println("Hemos salido");
            System.out.println("Hay " + count + " productos");
            
            dos.close();
        } catch(IOException e) {
            
        }
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
