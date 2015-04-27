<%-- 
    Document   : index
    Created on : 26-Apr-2015, 15:16:03
    Author     : Kandito Agung
--%>

<%@page import="java.util.Collection"%>
<%@page import="java.util.Collection"%>
<%@page import="models.Alat"%>
<%@page import="javax.persistence.Query"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistem Peminjaman Mapala UI</title>
        <%@include file="/partial/head.jsp" %>
        <style>
            .form-register input {
                width: 80% !important;
                text-transform: none !important;
            }

            .form-register textarea {
                font-family: 'Source Sans Pro', sans-serif;
                background: #FFFFFF;
                border: 1px solid #E7E7E7;
                color: rgba(85, 81, 81, 0.84);
                display: block;
                width: 80%;
                outline: none;
                -webkit-appearance: none;
                text-transform: none !important;
                height: 40px;
            }

        </style>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- body wrapper -->
        <div class="main_bg">
            <div class="wrap">
                <div class="main">
                    <%
                        String message = (String) session.getAttribute("message");
                        session.removeAttribute("message");
                        message = "Username terdaftar";
                        if (message != null) {
                    %>
                    <div class="alert"><%= message%></div>
                    <br>
                    <% } %>
                    
                    <% if (session.getAttribute("username") != null) {%>
                    <h2 style="font-size: 3em;">Selamat Datang, <%= session.getAttribute("username")%></h2>
                    <% } else {%>
                    <div class="login-wrap">
                        <h2 class="style top">Login</h2><br>
                        <form action="<%= request.getContextPath()%>/user/login" method="POST" class="form-login">
                            Username : <input type="text" name="username" required><br>
                            Password : <input type="password" name="password" required><br>
                            <input type="submit" name="" value="LOGIN" class="price">
                        </form>
                    </div>
                    <div class="atau-wrap" align="center">
                        <h2 class="style top"></h2>
                    </div>
                    <div class="register-wrap">
                        <h2 class="style top">Register</h2><br>				
                        <form action="<%= request.getContextPath()%>/user/register" method="POST" accept-charset="utf-8">
                            <table style="width:100%;" class="form-register">
                                <tr>
                                    <td>
                                        Username : <input type="text" name="username" required><br>
                                        Password : <input type="password" name="password" required><br>
                                        Repeat-Password : <input type="password" name="repeat-password" required><br>
                                        Email : <input type="text" name="email"><br>
                                    </td>
                                    <td>
                                        Nama : <input type="text" name="nama_lengkap" required><br>
                                        Nomor Telepon: <input type="text" name="nomor_telepon" required><br>
                                        Organisasi : <input type="text" name="organisasi"><br>
                                        Alamat: <br>
                                        <textarea name="alamat"></textarea>
                                    </td>
                                </tr>
                            </table>

                            <input type="submit" name="" value="REGISTER" class="price">
                        </form>
                    </div>

                    <div class="clear"></div>
                    <% }%>

                </div>
            </div>

            <!-- start main1 -->
            <div class="main_bg1">
                <div class="wrap">	
                    <div class="main1">
                        <h2>Daftar Alat </h2>
                    </div>
                </div>
            </div>
            <!-- List alat -->
            <div class="main_bg">
                <div class="wrap">	
                    <div class="main">
                        <!-- 3 grid -->

                        <%
                            EntityManager em = DatabaseInfo.getEntityManager();
                            Query q = em.createNamedQuery("Alat.findAll");
                            Collection<Alat> listAlat = q.getResultList();
                            em.close();
                            int i = 1;
                            for (Alat alat : listAlat) {
                        %>     

                        <% if (i % 3 == 1) { %>
                        <div class="grids_of_3">
                            <% }%>
                            <div class="grid1_of_3">
                                <a href="${pageContext.request.contextPath}/alat/detail.jsp?id=<%= alat.getIdAlat()%>">
                                    <img src="${pageContext.request.contextPath}/gambar/<%= alat.getGambar()%>" alt=""/>
                                    <h3><%= alat.getNama()%></h3>
                                    <div class="price" >
                                        <h4>Rp <%= alat.getBiaya()%>/hari<span style="background:red;">Tersedia</span></h4>
                                    </div>
                                    <span class="b_btm"></span>
                                </a>
                            </div>

                            <% if (i % 3 == 0) { %> 
                            <div class="clear"></div>
                        </div>
                        <% } %>    

                        <% i++;
                                if (i == 7) {
                                    break;
                                }
                            }%>

                        <div class="clear"></div>
                    </div>
                    <div class="price">
                        <a href="<%= request.getContextPath()%>/alat" title=""><h4><span>Selengkapnya</span></h4></a>
                    </div>
                </div><!-- END wrap class -->
            </div><!-- END main_bg-->
            <%@include file="/partial/footer.jsp" %>
    </body>
</html>
