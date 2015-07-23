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
public class Auditorio  implements Espacio{

    
    private int id;
    private int numpuestos;
    private boolean videbeam=false;
    private String direccion;
    private String Caracteristicas;

    public Auditorio(int id, int numpuestos, String direccion, String Caracteristicas) {
        this.id = id;
        this.numpuestos = numpuestos;
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

    public boolean isVidebeam() {
        return videbeam;
    }

    public void setVidebeam(boolean videbeam) {
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
    
    
    
    @Override
    public void listacaracteristicas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
