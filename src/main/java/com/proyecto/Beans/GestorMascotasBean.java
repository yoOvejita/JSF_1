/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.Beans;

import com.proyecto.Entity.Mascota;
import jakarta.faces.bean.ManagedBean;

import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rusok-pro
 */
@ManagedBean(name = "gestor", eager = true)
@SessionScoped
public class GestorMascotasBean implements Serializable {
    private Mascota mascota = new Mascota();
    private List<Mascota> mascotas;
    /**
     * Creates a new instance of GestorMascotasBean
     */
    public GestorMascotasBean() {
        mascota = new Mascota("h201", "hamster ruso", 15.0, "ham.jpeg", 4);
        mascotas = new LinkedList<>();
        mascotas.add(new Mascota("h201", "hamster ruso", 15.0, "ham.jpeg", 4));
        mascotas.add(new Mascota("h404", "hamster dudoso", 150.0, "perrito.jpeg", 2));
        mascotas.add(new Mascota("h321", "hamster ruso", 15.0, "ham.jpeg", 4));
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    
    public String guardarMascota(Mascota masc){
        mascota = masc;
        System.out.println("Mascota lista!");
        return "resultado2";
    }
    
    public String registrar(){
        return "resultado2";
    }
}
