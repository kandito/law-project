<%-- 
    Document   : update
    Created on : 26-Apr-2015, 21:06:37
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
        <title>Ubah Pengguna</title>
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
            <form action="${pageContext.request.contextPath}/user/update" method="POST">
                <input type="hidden" name="id_user" value="<%= user.getIdUser() %>">
                <div class="form-item">
                    <div class="form-label">
                        <label>Username</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="username" value="<%= user.getUsername()%>">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Nama</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="nama_lengkap" value="<%= user.getNamaLengkap() %>">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Password</label>
                    </div>
                    <div class="form-input">
                        <input type="password" name="password" style="width:130px;">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Email</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="email" value="<%= user.getEmail()%>">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>No. Telepon</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="nomor_telepon" value="<%= user.getNomorTelepon() %>">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Organisasi</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="organisasi" value="<%= user.getOrganisasi() %>">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Alamat</label>
                    </div>
                    <div class="form-input">
                        <textarea name="alamat"><%= user.getAlamat() %></textarea>
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label></label>
                    </div>
                    <div class="form-input">
                        <input type="submit" value="Ubah">  <a href="index.jsp">Kembali</a>
                    </div>
                </div>
            </form>
            </div>
        </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
