package servlet.admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Admin;
import models.DatabaseInfo;

/**
 *
 * @author Kandito Agung
 */
@WebServlet(name = "adminlogin", urlPatterns = {"/admin/login"})
public class login extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Query q = em.createNamedQuery("Admin.findByUsername").setParameter("username", username);
        Collection<Admin> list = q.getResultList();  
        em.close();
        if(list.isEmpty()) {
            request.getSession().setAttribute("messages", "Username tidak terdaftar");
            response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
        }
      
        for(Admin admin : list) {
            if(admin.getUsername().equals(username)) {
                if(admin.getPassword().equals(password)) {
                    response.sendRedirect(request.getContextPath() + "/admin/alat");
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("role", "admin");
                } else {
                    request.getSession().setAttribute("messages", "Kombinasi Username dan Password salah");
                    response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
            }
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
