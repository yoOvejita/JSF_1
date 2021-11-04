/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.Beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 *
 * @author rusok-pro
 */
@Named(value = "producto")
@ManagedBean(name="productito", eager = true)
@SessionScoped
public class ProductoBean implements Serializable {
    private String img;
    private String nombre;
    private Double precio;
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        img = "perrito.jpeg";
        nombre = "puppy";
        precio=200.5;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
