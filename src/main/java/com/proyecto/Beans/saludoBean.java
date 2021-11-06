/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.Beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ViewScoped;

/**
 *
 * @author rusok-pro
 */
//@Named(value = "saludo")
@ManagedBean(name="saludo", eager = true)
@SessionScoped
public class saludoBean {
    int resultado = 0;
    /**
     * Creates a new instance of saludoBean
     */
    public saludoBean() {
    }
    
    public String obtenerSaludo(){
        return "Hola a todos y todas";
    }
    public String sumar(String n1, String n2){
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int res = num1 + num2;
        resultado = res;
        return "resultado";
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}
