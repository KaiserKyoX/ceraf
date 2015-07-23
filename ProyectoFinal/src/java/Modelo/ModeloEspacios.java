/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cclavijo
 */
public class ModeloEspacios {
    
    private int id;
    private int numpuestos;
    private String videbeam;
    private String direccion;
    private String Caracteristicas;

    public ModeloEspacios(int id, int numpuestos, String videbeam, String direccion, String Caracteristicas) {
        this.id = id;
        this.numpuestos = numpuestos;
        this.videbeam = videbeam;
        this.direccion = direccion;
        this.Caracteristicas = Caracteristicas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumpuestos() {
        return numpuestos;
    }

    public void setNumpuestos(int numpuestos) {
        this.numpuestos = numpuestos;
    }

    public String getVidebeam() {
        return videbeam;
    }

    public void setVidebeam(String videbeam) {
        this.videbeam = videbeam;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }
    
    
    
    
    
    
    
}
