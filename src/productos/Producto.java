package productos;

import java.io.*;
import java.util.*;

/**
 *
 * @authors:
 * Juan Carlos Aranda,
 * Luis Angel Aguila, 
 * Carlos Eduardo Moreno,
 * Jose Adolfo Chaparro.
 */
public class Producto {
    
    /* Variables de instancia */
    private String codigo;
    private String descripcion;
    private double precio;
    
    /* Constructor vacio para la consistencia de los datos */
    Producto() {
        setCodigo("");
        setDescripcion("");
        setPrecio(0);
    }
    
    /* Constructor con parametros por si acaso */
    Producto(String codigo, String descripcion, double precio) {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPrecio(precio);
    }
    
    /* variable de entrada al teclado */
    private static Scanner in =  new Scanner(System.in);
    
    /* Objetos de manejo de archivos */
    private static File file = new File("productos.dat");
    private static DataOutputStream dos;
    private static DataInputStream dis; 
    
    /* Array del objeto Producto */
    private static ArrayList<Producto> productos = new ArrayList<>();
    
    /* Objeto Producto para rellenar los datos */
    private static Producto p = new Producto();
    
    
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
    
    
    /* Metodo para pedir datos al usuario y escribirlos al archivo productos.dat */
    public static void capturarProductos(){
        int contadorDeProductos = 0;
        /* Variable para confirmar que se han ingresado todos los datos */
        String exit= "";
        
        /* Variable auxiliar para continuar ciclo */
        boolean continuar = true;
        
        do{  
            try {     
                file.createNewFile();
                
             /* Abrir conexion con el archivo */
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
                    dos.writeUTF(p.getDescripcion()); // escribe en archivo
                
                    System.out.print("Ingrese el precio: ");
                    double precio = in.nextDouble();
                    if(precio < 0) {
                        System.out.println("Ingrese un valor valido");
                        System.out.print("Ingrese el precio: ");
                        precio = in.nextDouble();       
                    }
                    p.setPrecio(precio);
                    dos.writeDouble(p.getPrecio()); // escribe en archivo
                
                    contadorDeProductos++;
                
                    System.out.print("Ha terminado?(S/N):");
                    exit = in.next();
                    System.out.println("");
                }
                System.out.println("Hay " + contadorDeProductos + " productos");
            
                continuar = false;
                
                dos.close();
            } catch(IOException e) {
                System.out.println("Hubo un error al tratar el archivo: " + e);
            } catch(InputMismatchException e) {
                System.err.println("Ingrese un valor valido\n " + e);
                in.next(); 
                System.out.println("Introducir datos de nuevo\n");
            }
        }while(continuar);
    }
    
    /* Metodo para leer del archivo para pasarlo al programa */
    public static void leerProductos() {
        try {
            file.createNewFile();
            
            /* abre conexion con el archivo */
            dis = new DataInputStream(
                  new BufferedInputStream(
                  new FileInputStream(file)));
            
            while(dis.available() > 0) {   
                p = new Producto(); // crea un objeto nuevo en cada iteracion
                String codigo = dis.readUTF(); // lee del archivo
                p.setCodigo(codigo);
                
                String descripcion = dis.readUTF(); // lee del archivo
                p.setDescripcion(descripcion);
                
                double precio = dis.readDouble(); // lee del archivo
                p.setPrecio(precio);
                      
                productos.add(p); // agrega el objeto actual al arrayList
            }
            dis.close();
        } catch (IOException e) {
            System.out.println("Error al tratar el archivo: " + e);
        }
    }
    
    public static void mostrarProductos() {
        /* Metodo para recorrer el ArrayList */
        productos.stream().forEach((producto) -> {
            System.out.println(producto);
        });
    }
    
    /* Formato del objeto */
    @Override
    public String toString() {
       return "\nCodigo: " + codigo 
               + "\nDescripcion: " + descripcion 
               + "\nPrecio: $" + precio +  "\n";
    }
}
