/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.EspaciosBD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cclavijo
 */
public class nuevoEspacio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        int elemento = Integer.parseInt(request.getParameter("elemento"));
        int numsillas = Integer.parseInt(request.getParameter("number"));
        String  Videobeam = request.getParameter("Videobeam");
        String  direccion = request.getParameter("direccion");
        String  caracteristicas = request.getParameter("caracteristicas");
        CrearEspacio(numsillas,Videobeam,direccion,caracteristicas,elemento);
        PrintWriter out = response.getWriter();
        
        out.println("<html> \n" +
"<head> \n" +
"<title>Procesado</title> \n" +
"<META HTTP-EQUIV=\"REFRESH\" CONTENT=\"1;URL=/ProyectoFinal/MenuPrincipal.jsp\"> \n" +
"</head> \n" +
"<body> \n" +
"Espacio Creado Correctamente \n" +
"</body> \n" +
"</html>");

        
        
        
    }
    
    
    
    public boolean CrearEspacio (int numsillas,String Videobeam,String direccion,String caracteristicas, int tipo) throws FileNotFoundException {

        EspaciosBD espacio = new EspaciosBD();
        espacio.insert(numsillas, Videobeam, direccion, caracteristicas,tipo);
        boolean bandera=true;
 return bandera;
}
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
}
