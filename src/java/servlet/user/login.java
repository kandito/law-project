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
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.DatabaseInfo;
import models.User;

/**
 *
 * @author Kandito Agung
 */
@WebServlet(name = "userlogin", urlPatterns = {"/user/login"})
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
        HttpSession session = request.getSession();
        EntityManager em = DatabaseInfo.getEntityManager();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Query q = em.createNamedQuery("User.findByUsername").setParameter("username", username);
        Collection<User> list = q.getResultList();  
        em.close();
        if(list.isEmpty()) {
            session.setAttribute("message", "Username tidak terdaftar");
            response.sendRedirect(request.getContextPath());
            return;
        }
      
        for(User user : list) {
            if(user.getUsername().equals(username)) {
                if(user.getPassword().equals(password)) {
                    session.setAttribute("username", username);
                    session.setAttribute("role", "user");
                    response.sendRedirect(request.getContextPath());
                    return;
                } else {
                    session.setAttribute("message", "Kombinasi Username dan Password salah");
                    response.sendRedirect(request.getContextPath());
                    return;
                }
            } else {
                response.sendRedirect(request.getContextPath());
                return;
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
