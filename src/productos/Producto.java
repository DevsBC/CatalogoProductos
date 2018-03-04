/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import java.io.*;
import java.util.*;

/**
 *
 * @author ltrbomb10
 */
public class Producto {
    
    private  String codigo;
    private  String descripcion;
    private  double precio;
    
    Producto() {
        setCodigo("");
        setDescripcion("");
        setPrecio(0);
    }
    
    Producto(String codigo, String descripcion, double precio) {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPrecio(precio);
    }
    
    private static Scanner in =  new Scanner(System.in);
    private static File file = new File("productos.dat");
    private static DataOutputStream dos;
    private static DataInputStream dis; 
    private static ArrayList<Producto> productos = new ArrayList<>();
    
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
        Producto p = new Producto();
        int count = 0;
        String exit= "";
        boolean continuar = true;
        do{
        
        try {     
            file.createNewFile();
             
            dos = new DataOutputStream(
                  new BufferedOutputStream(
                  new FileOutputStream(file)));
            
            while(!exit.equalsIgnoreCase("S")){
                System.out.print("Ingrese el codigo: ");
                String codigo = in.next();
                p.setCodigo(codigo);
                dos.writeUTF(p.getCodigo());
                
                System.out.print("Ingrese la descripcion: ");
                String descripcion = in.next();
                p.setDescripcion(descripcion);
                dos.writeUTF(p.getDescripcion());
                
                System.out.print("Ingrese el precio: ");
                double precio = in.nextDouble();
                p.setPrecio(precio);
                dos.writeDouble(p.getPrecio());
                
                count++;
                
                System.out.print("Ha terminado?(S/N):");
                exit = in.next();      
            }
        
            System.out.println("Hemos salido");
            System.out.println("Hay " + count + " productos");
            
            continuar = false;
            dos.close();
        } catch(IOException e) {
            System.out.println("Hubo un error mi compa " + e);
        } catch(InputMismatchException e) {
            System.err.println("Ingrese un valor valido " + e);
            in.next(); 
            System.out.println("Introducir datos de nuevo");
        }
        }while(continuar);
    }
    
    
    public static void leerProductos() {
        Producto p2 = new Producto();
        String codigo;
        String descripcion;
        double precio;
        try {
            file.createNewFile();
            
            dis = new DataInputStream(
            new BufferedInputStream(
            new FileInputStream(file)));
            
            System.out.println("pendejo");
            
            while(dis.available() > 0) {
                System.out.println("entro");
                
                codigo = dis.readUTF();
                p2.setCodigo(codigo);
                descripcion = dis.readUTF();
                p2.setDescripcion(descripcion);
                precio = dis.readDouble();
                p2.setPrecio(precio);
                
                System.out.println("entromas");
                
                productos.add(p2);    
            }
            dis.close();
        } catch (IOException e) {
            System.out.println("No se armo compa " + e);
        }
    }
    
    public static void mostrarProductos() {
        productos.stream().forEach((producto) -> {
            System.out.println("\n" + producto);
        });
    }
    
    @Override
    public String toString() {
       return "Codigo: " + codigo 
               + "\nDescripcion: " + descripcion 
               + "\nPrecio: " + precio; 
    }
}
