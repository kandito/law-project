<%-- 
    Document   : index
    Created on : 26-Apr-2015, 15:16:03
    Author     : Kandito Agung
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Alat</title>
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
            <form action="${pageContext.request.contextPath}/alat/create" method="POST" enctype="multipart/form-data">
                <div class="form-item">
                    <div class="form-label">
                        <label>Kode</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="kode_alat">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Nama</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="nama">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Gambar</label>
                    </div>
                    <div class="form-input">
                        <input type="file" name="gambar">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Jumlah</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="jumlah">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Biaya</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="biaya">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Spesifikasi</label>
                    </div>
                    <div class="form-input">
                        <textarea name="spesifikasi"></textarea>
                    </div>
                </div>
                    
                <div class="form-item">
                    <div class="form-label">
                        <label>Keterangan</label>
                    </div>
                    <div class="form-input">
                        <textarea name="keterangan"></textarea>
                    </div>
                </div>        
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Kategori</label>
                    </div>
                    <div class="form-input">
                        <select name="id_kategori">
                            <%
                                EntityManager em = DatabaseInfo.getEntityManager();
                                Query q = em.createNamedQuery("Kategori.findAll");
                                Collection<Kategori> list = q.getResultList();
                                em.close();
                                for(Kategori kategori : list) {
                            %>
                            <option value="<%= kategori.getIdKategori() %>"><%= kategori.getNama() %></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>        
                <div class="form-item">
                    <div class="form-label">
                        <label></label>
                    </div>
                    <div class="form-input">
                        <input type="submit" value="Tambah">  <a href="index.jsp">Kembali</a>
                    </div>
                </div>
            </form>
            </div>
        </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
