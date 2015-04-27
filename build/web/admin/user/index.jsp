<%-- 
    Document   : index.jsp
    Created on : 26-Apr-2015, 20:28:35
    Author     : Kandito Agung
--%>

<%@page import="models.User"%>
<%@page import="java.util.Collection"%>
<%@page import="javax.persistence.Query"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/partial/sessionCheckAdmin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pengguna</title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
        <div class="main_bg">
        <div class="wrap">	
            <div class="main">
            <h2 class="style top">Daftar Pengguna</h2>
            <hr>
            <a href="create.jsp">Tambah Pengguna</a>
            <table class="table-content">
                <thead>
                    <tr style="background:#ffbf00">
                        <th style="width:5%">No</th>
                        <th style="width:15%">Username</th>
                        <th style="width:15%">Nama</th>
                        <th style="width:15%">Email</th>
                        <th style="width:10%">No. Telepon</th>
                        <th style="width:20%">Alamat</th>
                        <th style="width:10%">Organisasi</th>
                        <th style="width:10%"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        EntityManager em = DatabaseInfo.getEntityManager();
                        Query q = em.createNamedQuery("User.findAll");
                        Collection<User> listUser = q.getResultList();
                        int i = 1;
                        for(User user : listUser) {
                    %>
                    <tr>
                        <td><%= i %></td>
                        <td><a href="<%= request.getContextPath() %>/admin/user/detail.jsp?id=<%= user.getIdUser() %>"><%= user.getUsername() %></a></td>
                        <td><%= user.getNamaLengkap()%></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getNomorTelepon() %></td>
                        <td><%= user.getAlamat()%></td>
                        <td><%= user.getOrganisasi()%></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/user/delete?id=<%= user.getIdUser() %>" onclick="return confirm('Anda yakin ingin menghapus?')">Hapus</a> ||
                            <a href="<%= request.getContextPath() %>/admin/user/update.jsp?id=<%= user.getIdUser() %>">Ubah</a>
                        </td>
                    </tr>
                    <%
                    i++;} em.close();
                    %>
                </tbody>
            </table>
            </div>
        </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
