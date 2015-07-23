package Controlador;

import java.sql.*;

public class Conexion {

    public static String JDBC_DRIVER="com.mysql.jdbc.Driver";
    public static String JDBC_url ="jdbc:mysql://localhost:3306/";
    public static String JDBC_BD ="ceraf";
    public static String JDBC_USER ="ceraf";
    public static String JDBC_PASWORD ="ceraf";
    public static Driver driver = null;

  
   

public static  synchronized Connection getConexion()throws SQLException {
        
        if (driver==null){
            try{
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
                
            
            }
            catch (Exception e){
                System.out.println("fallo carga driver");
                e.printStackTrace();
            }
            
            
        }
        
        return DriverManager.getConnection(JDBC_url+JDBC_BD,JDBC_USER,JDBC_PASWORD);
        
    }


public static void close(ResultSet rs){
try{
    if (rs != null) rs.close();
}

catch (SQLException sqle){
     System.out.println("fallo carga driver");
                sqle.printStackTrace();
}


}
public static void close (PreparedStatement stmt ){

try{
    
    if (stmt != null) stmt.close();
    
}catch (SQLException sqle){
     System.out.println("fallo carga driver");
                sqle.printStackTrace();
}

}

public static void close(Connection conn){
    try{
        if(conn != null) conn.close();
    }catch (SQLException sqle){
     System.out.println("fallo carga driver");
                sqle.printStackTrace();
}
    
    
    
}


   
}