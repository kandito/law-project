/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.alat;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Alat;
import models.DatabaseInfo;
import models.Kategori;

/**
 *
 * @author Kandito Agung
 */
@WebServlet(name = "alatupdate", urlPatterns = {"/alat/update"})
public class update extends HttpServlet {

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
            String ids = request.getParameter("id_alat");
            if (ids == null) {
                response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
                return;
            } else {
                id = Integer.parseInt(ids);
            }

        } catch (Exception ex) {
            response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
            return;
        }

        if (id == 0) {
            response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
            return;
        }
        
        EntityTransaction tx = em.getTransaction();
        Alat alat = em.find(Alat.class, id);
        tx.begin();
        alat.setKodeAlat(request.getParameter("kode_alat"));
        alat.setNama(request.getParameter("nama"));
        alat.setKeterangan(request.getParameter("keterangan"));
        alat.setSpesifikasi(request.getParameter("spesifikasi"));
        alat.setBiaya(Long.parseLong(request.getParameter("biaya")));
        alat.setGambar(request.getParameter("gambar"));
        alat.setJumlah(Integer.parseInt(request.getParameter("jumlah")));
        
        int id_kategori = Integer.parseInt(request.getParameter("id_kategori"));
        Kategori kategori = em.find(Kategori.class, id_kategori);
        alat.setIdKategori(kategori);
        
        tx.commit();
        em.close();
        response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
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
