/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Prenda;
import modelo.PrendaCRUD;

/**
 *
 * @author salaz
 */
public class ServletPrenda extends HttpServlet {
private int id;
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
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletRopa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrenda at "+ request.getContextPath() + "</h1>");
            if ( op.equals("listar")){
                List<Prenda> misPrendas = PrendaCRUD.getPrendas();
                request.setAttribute("misPrendas", misPrendas);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                

            }
            if ( op.equals("insert1")) { //cuando le indicamos que vaya a insertar
                 request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
            if ( op.equals("insert2")) { //cuando le indicamos que vaya a insertar
                
                    Prenda miPrenda = new Prenda();
                    miPrenda.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                    miPrenda.setColor(request.getParameter("color"));
                    miPrenda.setTipo(request.getParameter("tipo"));
                    
                    
                    PrendaCRUD.insertaPrenda(miPrenda);
                    out.println("<h1>Registro insertado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
                    

            }
            
            if ( op.equals("borrar")) { //cuando le indicamos que vaya a borrar
                int id = Integer.parseInt(request.getParameter("id"));
                
                if (PrendaCRUD.borrarPrenda(id)>0 ) {
                    
                    out.println("<h1>Registro Borrado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
                }
                 
            }
            
            if ( op.equals("update1")) { //cuando le indicamos que vaya a borrar
                id = Integer.parseInt(request.getParameter("id"));
                Prenda miPrenda = PrendaCRUD.getPrenda(id);
                request.setAttribute("miPrenda", miPrenda);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
            if ( op.equals("update2")) { //cuando le indicamos que vaya a borrar
               String tipo = request.getParameter("tipo");
               String color = request.getParameter("color");
               int cantidad = Integer.parseInt(request.getParameter("cantidad"));
               
                Prenda miPrenda = new Prenda(id,cantidad,tipo,color);
                PrendaCRUD.insertaPrenda(miPrenda);
                String mensaje="Prenda actualizada";
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("miPrenda", miPrenda);
                request.getRequestDispatcher("update.jsp").forward(request, response);

            }
            
            out.println("</body>");
            out.println("</html>");
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
