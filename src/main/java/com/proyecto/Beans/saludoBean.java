/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.Beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

/**
 *
 * @author rusok-pro
 */
//@Named(value = "saludo")
@ManagedBean(name="saludo", eager = true)
@ViewScoped
public class saludoBean {

    /**
     * Creates a new instance of saludoBean
     */
    public saludoBean() {
    }
    
    public String obtenerSaludo(){
        return "Hola a todos y todas";
    }
}
