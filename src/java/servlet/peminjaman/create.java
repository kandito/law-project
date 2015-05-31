/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.peminjaman;

import helper.Cart;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Alat;
import models.DatabaseInfo;
import models.Peminjaman;
import models.PeminjamanItem;
import models.User;

/**
 *
 * @author Kandito Agung
 */
@WebServlet(name = "peminjamancreate", urlPatterns = {"/peminjaman/create"})
public class create extends HttpServlet {

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
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Peminjaman peminjaman = new Peminjaman();
        int id_user = (Integer) session.getAttribute("id");
        peminjaman.setIdUser(em.find(User.class, id_user));

        String inputStr = "11-11-2012";
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String tanggal_balik = request.getParameter("tanggal_balik");
        String tanggal_pinjam = request.getParameter("tanggal_pinjam");
        try {
            peminjaman.setTanggalBalik(dateFormat.parse(tanggal_balik));
            peminjaman.setTanggalPinjam(dateFormat.parse(tanggal_pinjam));
        } catch (ParseException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        }
        peminjaman.setKeterangan(request.getParameter("keterangan"));
        peminjaman.setTotalBiaya(cart.getTotalBiaya());
        
        em.persist(peminjaman);
        
        HashMap<Integer, Integer> items = cart.getCartItem();
        
        long total_biaya = 0;
        for (int key : items.keySet()) {
            Alat alat = em.find(Alat.class, key);
            PeminjamanItem pi = new PeminjamanItem();
            pi.setIdAlat(alat);
            pi.setJumlah(items.get(key));
            pi.setKeterangan("");
            pi.setIdPeminjaman(peminjaman);
            em.persist(pi);
        }
        
        tx.commit();
        em.close();
        
        session.setAttribute("cart", null);
        response.sendRedirect(request.getContextPath() + "/history.jsp");
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
