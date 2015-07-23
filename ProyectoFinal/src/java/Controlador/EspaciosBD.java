/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.ModeloEspacios;
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
public class EspaciosBD {
    
    private final String SQL_INSERT = "INSERT INTO Espacios (numespacios,VideoBeam,Direccion,Caracteristicas,TipoEspacio) VALUES (?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE Espacios SET numespacios=?,VideoBeam=?,Direccion=?,Caracteristicas=? WHERE idEspacios=?";
    private final String SQL_DELETE = "DELETE FROM Espacios WHERE idEspacios = ?";
    private final String SQL_SELECT = "SELECT idEspacios,numespacios,VideoBeam,Direccion,Caracteristicas FROM Espacios";
    private Object conexion;
    
    
    public boolean insert(int numespacios,String VideoBeam,String Direccion,String Caracteristicas,int Tipo) throws FileNotFoundException{
        
       
        Connection conn = null;
        PreparedStatement stmt=null;
        
        ResultSet rs= null;
       
        int rows=0;
        
        try{
          
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement (SQL_INSERT);
            int index=1;
            stmt.setInt(index++,numespacios);
            stmt.setString(index++,(VideoBeam));
            stmt.setString(index++,Direccion);
            stmt.setString(index++,Caracteristicas);
            stmt.setInt(index++,Tipo);
            

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
    
    
    
    public int delete (int idEspacios){
     Connection conn = null;
        PreparedStatement stmt=null;
       
        int rows=0;
        
        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement (SQL_DELETE);
            System.out.println("Ejecutando Delete :"+SQL_DELETE); 
           
            stmt.setInt(1,idEspacios);

           
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
    
    
public int update (int idEspacios,int numespacios,boolean VideoBeam,String Direccion,String Caracteristicas){
 Connection conn = null;
 PreparedStatement stmt = null;
 String video;
 video = Boolean.toString(VideoBeam);
 int rows=0;
     try{
         conn = Conexion.getConexion();
         stmt = conn.prepareStatement(SQL_UPDATE);
         int index = 1;
            stmt.setInt(index++,numespacios);
            stmt.setString(index++,video);
            stmt.setString(index++,Direccion);
            stmt.setString(index++,Caracteristicas);
            stmt.setInt(index++,idEspacios);
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
    

 public List<ModeloEspacios> selectClientes (){
 
 Connection conn = null;
 PreparedStatement stmt = null;
 ResultSet rs= null;
 ModeloEspacios rutina = null;
 List<ModeloEspacios> rutinas = new ArrayList<ModeloEspacios>();
 
 
 

 try {
 
 conn = Conexion.getConexion();
 stmt = conn.prepareStatement(SQL_SELECT);
  int index = 1;
            
 rs = stmt.executeQuery();
 
 
 while(rs.next()){
     
   
     
     int idEspacios= rs.getInt(1);
     int numespacios = rs.getInt(2);
     String VideoBeam= rs.getString(3);
     String Direccion= rs.getString(4);
     String Caracteristicas = rs.getString(5);
     
    
     
     rutina = new ModeloEspacios(idEspacios,numespacios,VideoBeam,Direccion,Caracteristicas);
    
     
     
     
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