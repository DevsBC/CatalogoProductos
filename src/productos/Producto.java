/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

/**
 *
 * @author ltrbomb10
 */
public class Producto {
    
    private String codigo;
    private String descripcion;
    private double precio;
    
    Producto() {
        setCodigo();
        setDescripcion();
        setPrecio();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
            this.codigo = codigo;
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
        this.precio = precio;
    }
}
