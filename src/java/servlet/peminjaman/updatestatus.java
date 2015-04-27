/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.peminjaman;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.DatabaseInfo;
import models.Peminjaman;

/**
 *
 * @author Kandito Agung
 */
@WebServlet(name = "peminjamanupdatestatus", urlPatterns = {"/peminjaman/updatestatus"})
public class updatestatus extends HttpServlet {

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
        EntityManager em = DatabaseInfo.getEntityManager();
        int id = 0;
        try {
            String ids = request.getParameter("id_peminjaman");
            if (ids == null) {
                response.sendRedirect(request.getContextPath() + "/admin/peminjaman");
                return;
            } else {
                id = Integer.parseInt(ids);
            }

        } catch (Exception ex) {
            response.sendRedirect(request.getContextPath() + "/admin/peminjaman");
            return;
        }

        if (id == 0) {
            response.sendRedirect(request.getContextPath() + "/admin/peminjaman");
            return;
        }
        
        Peminjaman peminjaman = em.find(Peminjaman.class, id);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        int status = Integer.parseInt(request.getParameter("status"));
        peminjaman.setStatus(status);
        tx.commit();
        em.close();
        
        response.sendRedirect(request.getContextPath() + "/admin/peminjaman/detail.jsp?id=" + id);
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
