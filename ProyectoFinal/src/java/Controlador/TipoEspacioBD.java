/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.ModeloTipoEspacio;
import java.io.File;

import java.io.FileNotFoundException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author cclavijop1
 */
public class TipoEspacioBD {
    
    private final String SQL_INSERT = "INSERT INTO tipoespacio (Nombre) VALUES (?)";
    private final String SQL_UPDATE = "UPDATE tipoespacio SET Nombre=? WHERE idTipoEspacio=?";
    private final String SQL_DELETE = "DELETE FROM tipoespacio WHERE idTipoEspacio = ?";
    private final String SQL_SELECT = "SELECT idTipoEspacio,nombre FROM tipoespacio";
    private Object conexion;
    
    
    public boolean insert(String Nombre) throws FileNotFoundException{
        
        Connection conn = null;
        PreparedStatement stmt=null;
        
        ResultSet rs= null;
       
        int rows=0;
        
        try{
          
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement (SQL_INSERT);
            int index=1;
            stmt.setString(index++,Nombre);
            System.out.println("Ejecutando query:"+SQL_INSERT)            ;
            rows= stmt.executeUpdate();
                        System.out.println("Registros Afectados:"+rows)            ;
                        

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return true;
    }
    
    
    
    public int delete (int idTipoEspacio){
     Connection conn = null;
        PreparedStatement stmt=null;
       
        int rows=0;
        
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement (SQL_DELETE);
            System.out.println("Ejecutando Delete :"+SQL_DELETE); 
           
            stmt.setInt(1,idTipoEspacio);

           
            rows= stmt.executeUpdate();
                        System.out.println("Registros Eliminados:"+rows) ;
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
        
    }
    
    
public int update (int idTipoEspacio, String NombreCiudades){
 Connection conn = null;
 PreparedStatement stmt = null;
 int rows=0;
     try{
         conn = Conexion.getConexion();
         stmt = conn.prepareStatement(SQL_UPDATE);
         int index = 1;
            stmt.setString(index++,NombreCiudades);
            stmt.setInt(index++,idTipoEspacio);
         rows = stmt.executeUpdate();
         System.out.println("registros actualizados" + rows);
         
     } catch(SQLException e){
         e.printStackTrace();
     }finally{
         Conexion.close(stmt);
         Conexion.close(conn);
     }
     return rows;
    }
    

 public List<ModeloTipoEspacio> selectEspacios (){
 
 Connection conn = null;
 PreparedStatement stmt = null;
 ResultSet rs= null;
 ModeloTipoEspacio rutina = null;
 List<ModeloTipoEspacio> rutinas = new ArrayList<ModeloTipoEspacio>();
 
 
 

 try {
 
 conn = Conexion.getConexion();
 stmt = conn.prepareStatement(SQL_SELECT);
  int index = 1;
            
 rs = stmt.executeQuery();
 
 
 while(rs.next()){
     
     
     
     int id_Ciudad = rs.getInt(1);
     
     String NombreCiudad = rs.getString(2);
     
     rutina = new ModeloTipoEspacio();
     rutina.setId(id_Ciudad);
     rutina.setNombre(NombreCiudad);
     
     
     
     rutinas.add(rutina);
      
 }}catch(SQLException e){
         e.printStackTrace();
 
     
     
 
 }finally{
     Conexion.close(stmt);
         Conexion.close(conn);
         Conexion.close(rs);
     
     
 }
        return rutinas;
         
    }


}