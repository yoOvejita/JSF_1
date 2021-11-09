/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.Beans;

import com.proyecto.Entity.Desarrollador;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author rusok-pro
 */
@Named(value = "frijol")
@SessionScoped
public class GestionaDesarrolladorBean implements Serializable {
    private Desarrollador desarrollador;
    /**
     * Creates a new instance of GestionaDesarrolladorBean
     */
    public GestionaDesarrolladorBean(){
    desarrollador = new Desarrollador();
    desarrollador.setGenero("F");//F=Femenino, M=Masculino
    desarrollador.setDisponible(true);
    desarrollador.setLenguajesProgramacion(new String[]{"l1","l2"});
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }
    public String registrar(){
    return "registrado";//Crear la vista
}
}
