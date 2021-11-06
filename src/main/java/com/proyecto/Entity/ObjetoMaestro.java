/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author rusok-pro
 */
public class ObjetoMaestro {
    public String ID, Message;
    public Global Global;
    public List<Country> Countries;
    public Date Date;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Global getGlobal() {
        return Global;
    }

    public void setGlobal(Global Global) {
        this.Global = Global;
    }

    public List<Country> getCountries() {
        return Countries;
    }

    public void setCountries(List<Country> Countries) {
        this.Countries = Countries;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }
    
}
