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
import models.Alat;
import models.DatabaseInfo;
import models.Peminjaman;
import models.PeminjamanItem;

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
        
        for(PeminjamanItem pi : peminjaman.getPeminjamanItemCollection()) {
            Alat alat = em.find(Alat.class, pi.getIdAlat().getIdAlat());
            if(status == 2) {
                int newStock = alat.getJumlah() - pi.getJumlah();
                alat.setJumlahTersedia(newStock);
                
                //add transaction
                String token = "e5f2a0f34f1662b3";
                String deskripsi = "Peminjaman " + peminjaman.getIdUser().getNamaLengkap() + " #" + peminjaman.getIdPeminjaman();
                double nominal = (double) peminjaman.getTotalBiaya();
                int idJenis = 0;
                int idCategory = 13;
                String matauang = "IDR";
                
                int result = addTransaction(token, nominal, deskripsi, idJenis, idCategory, matauang);
                System.out.println("result " + result);
            }
            
            if(status == 3) {
                int newStock = alat.getJumlah() + pi.getJumlah();
                alat.setJumlahTersedia(newStock);
            }
        }
        
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

    private static int addTransaction(java.lang.String token, double nominal, java.lang.String deskripsi, int idJenis, int idCategory, java.lang.String matauang) {
        exes.ws.Service_Service service = new exes.ws.Service_Service();
        exes.ws.Service port = service.getServicePort();
        return port.addTransaction(token, nominal, deskripsi, idJenis, idCategory, matauang);
    }

}
