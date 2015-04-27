<%-- 
    Document   : index
    Created on : 26-Apr-2015, 15:16:03
    Author     : Kandito Agung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/partial/sessionCheckAdmin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Pengguna</title>
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
            <form action="${pageContext.request.contextPath}/user/create" method="POST">
                <div class="form-item">
                    <div class="form-label">
                        <label>Username</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="username">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Nama</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="nama_lengkap">
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
                        <input type="text" name="email">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>No. Telepon</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="nomor_telepon">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Organisasi</label>
                    </div>
                    <div class="form-input">
                        <input type="text" name="organisasi">
                    </div>
                </div>
                
                <div class="form-item">
                    <div class="form-label">
                        <label>Alamat</label>
                    </div>
                    <div class="form-input">
                        <textarea name="alamat"></textarea>
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
