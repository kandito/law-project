/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Admin;
import models.DatabaseInfo;
import models.User;

/**
 *
 * @author Kandito Agung
 */
@WebServlet(name = "registeruser", urlPatterns = {"/user/register"})
public class register extends HttpServlet {

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
        String password = request.getParameter("password");
        String repeat_password = request.getParameter("repeat-password");
        String username = request.getParameter("username");
       
        Query quser = em.createNamedQuery("User.findByUsername").setParameter("username", username);
        Query qadmin = em.createNamedQuery("Admin.findByUsername").setParameter("username", username);
        
        Collection<User> listUser = quser.getResultList();
        Collection<Admin> listAdmin = qadmin.getResultList();
        
        if (!listUser.isEmpty() || !listAdmin.isEmpty()) {
            request.getSession().setAttribute("message", "Username sudah terdaftar");
            response.sendRedirect(request.getContextPath());
        } else {
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setNamaLengkap(request.getParameter("nama_lengkap"));
            user.setNomorTelepon(request.getParameter("nomor_telepon"));
            user.setEmail(request.getParameter("email"));
            user.setOrganisasi(request.getParameter("organisasi"));
            if (!password.equals(repeat_password)) {
                request.getSession().setAttribute("message", "Password tidak sama");
                response.sendRedirect(request.getContextPath());
                return;
            }
            user.setPassword(request.getParameter("password"));
            user.setAlamat(request.getParameter("alamat"));
            
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(user);
            tx.commit();
            em.close();
            request.getSession().setAttribute("message", "Pendaftaran berhasil, silahkan login");
            response.sendRedirect(request.getContextPath());
        }
        
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
