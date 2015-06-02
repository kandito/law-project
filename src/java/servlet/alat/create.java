/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.alat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.Alat;
import models.DatabaseInfo;
import models.Kategori;

/**
 *
 * @author Kandito Agung
 */
@WebServlet(name = "alatcreate", urlPatterns = {"/alat/create"})
@MultipartConfig
public class create extends HttpServlet {

    private static final long serialVersionUID = 2857847752169838915L;
    int BUFFER_LENGTH = 4096;

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

        OutputStream out = null;
        final String dest = "/gambar";
        final String path = getServletContext().getRealPath(dest);
        Part filePart = request.getPart("gambar");
        final String fileName = getFileName(filePart);

        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            Alat alat = new Alat();
            alat.setKodeAlat(request.getParameter("kode_alat"));
            alat.setNama(request.getParameter("nama"));
            alat.setKeterangan(request.getParameter("keterangan"));
            alat.setSpesifikasi(request.getParameter("spesifikasi"));
            alat.setBiaya(Long.parseLong(request.getParameter("biaya")));
            if (fileName != null) {
                alat.setGambar(fileName);
            } else {
                alat.setGambar("");
            }
            alat.setJumlah(Integer.parseInt(request.getParameter("jumlah")));
            alat.setJumlahTersedia(Integer.parseInt(request.getParameter("jumlah")));

            int id_kategori = Integer.parseInt(request.getParameter("id_kategori"));
            Kategori kategori = em.find(Kategori.class, id_kategori);
            alat.setIdKategori(kategori);

            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(alat);
            tx.commit();

            em.close();
            System.out.println("response to index");
            response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }

        }

    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
