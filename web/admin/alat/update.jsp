<%-- 
    Document   : index
    Created on : 26-Apr-2015, 15:16:03
    Author     : Kandito Agung
--%>

<%@page import="models.Alat"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="models.Kategori"%>
<%@page import="java.util.Collection"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/partial/sessionCheckAdmin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%
            EntityManager em = DatabaseInfo.getEntityManager();
            int id = 0;
            try {
                String ids = request.getParameter("id");
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

            Alat alat = em.find(Alat.class, id);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubah Alat - <%= alat.getNama()%></title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
        <div class="main_bg">
            <div class="wrap">	
                <div class="main">
                    <h2 class="style top">Buat Alat</h2>
                    <hr>
                    <form action="${pageContext.request.contextPath}/alat/update" method="POST">
                        <input type="hidden" name="id_alat" value="<%= alat.getIdAlat()%>">
                        <div class="form-item">
                            <div class="form-label">
                                <label>Kode</label>
                            </div>
                            <div class="form-input">
                                <input type="text" name="kode_alat" value="<%= alat.getKodeAlat()%>">
                            </div>
                        </div>

                        <div class="form-item">
                            <div class="form-label">
                                <label>Nama</label>
                            </div>
                            <div class="form-input">
                                <input type="text" name="nama" value="<%= alat.getNama()%>">
                            </div>
                        </div>
                        <div class="form-item">
                            <div class="form-label">
                                <label>Jumlah</label>
                            </div>
                            <div class="form-input">
                                <input type="text" name="jumlah" value="<%= alat.getJumlah()%>">
                            </div>
                        </div>

                        <div class="form-item">
                            <div class="form-label">
                                <label>Biaya</label>
                            </div>
                            <div class="form-input">
                                <input type="text" name="biaya" value="<%= alat.getBiaya()%>">
                            </div>
                        </div>

                        <div class="form-item">
                            <div class="form-label">
                                <label>Spesifikasi</label>
                            </div>
                            <div class="form-input">
                                <textarea name="spesifikasi"><%= alat.getSpesifikasi()%></textarea>
                            </div>
                        </div>

                        <div class="form-item">
                            <div class="form-label">
                                <label>Keterangan</label>
                            </div>
                            <div class="form-input">
                                <textarea name="keterangan"><%= alat.getKeterangan()%></textarea>
                            </div>
                        </div>        

                        <div class="form-item">
                            <div class="form-label">
                                <label>Kategori</label>
                            </div>
                            <div class="form-input">
                                <select name="id_kategori">
                                    <%
                                        Query q = em.createNamedQuery("Kategori.findAll");
                                        Collection<Kategori> list = q.getResultList();
                                        for (Kategori kategori : list) {
                                    %>

                                    <% if (alat.getIdKategori().equals(kategori)) {%>
                                    <option value="<%= kategori.getIdKategori()%>" selected><%= kategori.getNama()%></option>
                                    <% } else {%>
                                    <option value="<%= kategori.getIdKategori()%>"><%= kategori.getNama()%></option>
                                    <% } %>

                                    <% } %>

                                    <% em.close();%>
                                </select>
                            </div>
                        </div>        
                        <div class="form-item">
                            <div class="form-label">
                                <label></label>
                            </div>
                            <div class="form-input">
                                <input type="submit" value="Ubah"> <a href="detail.jsp?id=<%= alat.getIdAlat()%>">Kembali</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
