<%-- 
    Document   : detail
    Created on : 26-Apr-2015, 21:47:11
    Author     : Kandito Agung
--%>

<%@page import="models.User"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="javax.persistence.EntityManager"%>
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
                response.sendRedirect(request.getContextPath() + "/admin/user");
                return;
            } else {
                id = Integer.parseInt(ids);
            }

        } catch (Exception ex) {
            response.sendRedirect(request.getContextPath() + "/admin/user");
            return;
        }

        if (id == 0) {
            response.sendRedirect(request.getContextPath() + "/admin/user");
            return;
        }
        User user = em.find(User.class, id);
        em.close();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Pengguna</title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
        <div class="main_bg">
        <div class="wrap">	
            <div class="main">
            <h2 class="style top">Ubah Pengguna</h2>
            <hr>
                <div class="form-item">
                    <div class="form-label">
                        <label>Username</label>
                    </div>
                    <div class="form-input">
                        <label class="label-value"><%= user.getUsername()%></label>
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Nama</label>
                    </div>
                    <div class="form-input">
                        <label class="label-value"><%= user.getNamaLengkap() %></label>
                    </div>
                </div>
                         
                <div class="form-item">
                    <div class="form-label">
                        <label>Email</label>
                    </div>
                    <div class="form-input">
                        <label class="label-value"><%= user.getEmail()%></label>
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>No. Telepon</label>
                    </div>
                    <div class="form-input">
                        <label class="label-value"><%= user.getNomorTelepon() %></label>
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Organisasi</label>
                    </div>
                    <div class="form-input">
                        <label class="label-value"><%= user.getOrganisasi() %></label>
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Alamat</label>
                    </div>
                    <div class="form-input">
                        <label class="label-value"><%= user.getAlamat() %></label>
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label></label>
                    </div>
                    <div class="form-input">
                        <a href="<%= request.getContextPath() %>/user/delete?id=<%= user.getIdUser() %>" onclick="return confirm('Anda yakin ingin menghapus?')">Hapus</a> |
                        <a href="<%= request.getContextPath() %>/admin/user/update.jsp?id=<%= user.getIdUser() %>">Ubah</a> |
                        <a href="index.jsp">Kembali</a>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
