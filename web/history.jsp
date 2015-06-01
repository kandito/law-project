<%-- 
    Document   : index
    Created on : 26-Apr-2015, 15:16:03
    Author     : Kandito Agung
--%>

<%@page import="models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Peminjaman"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="helper.Cart"%>
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
        <%
            String username = (String) session.getAttribute("username");
            if (username == null) {
                response.sendRedirect(request.getContextPath());
            }
        %>
        <title>History - Sistem Peminjaman Mapala UI</title>
        <%@include file="/partial/head.jsp" %>
        <style>
            #cart {width:80%; border:1px; text-align: center;}
            #cart td {vertical-align: middle}

            form label {
                margin-right: 10px;
                width: 300px;
                display: block;
            }
            
            .table-content {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- body wrapper -->
        <div class="main_bg">
            <div class="wrap">
                <div class="main">
                    <h2 class="style top">Daftar Peminjaman</h2>
                    <hr>
                    <table class="table-content">
                        <thead>
                            <tr style="background:#ffbf00">
                                <th style="width:5%">No</th>
                                <th style="width:15%">Username</th>
                                <th style="width:15%">Nama</th>
                                <th style="width:15%">Tanggal Pinjam</th>
                                <th style="width:15%">Tanggal Kembali</th>
                                <th style="width:15%">Status</th>
                                <th style="width:15%">Total Biaya</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                EntityManager em = DatabaseInfo.getEntityManager();
                                int idUser = (Integer) session.getAttribute("id");
                                User user = em.find(User.class, idUser);
                                Query q = em.createNamedQuery("Peminjaman.findByIdUser");
                                Collection<Peminjaman> listPeminjaman = q.setParameter("idUser", user).getResultList();
                                ArrayList<String> detailStatus = new ArrayList<String>();
                                detailStatus.add("Belum disetujui");
                                detailStatus.add("Disetujui");
                                detailStatus.add("Alat dipinjam");
                                detailStatus.add("Alat dikembalikan");
                                em.close();
                                int i = 1;
                                for (Peminjaman peminjaman : listPeminjaman) {
                            %>
                            <tr>
                                <td><%= i%></td>
                                <td><%= peminjaman.getIdUser().getUsername()%></td>
                                <td><%= peminjaman.getIdUser().getNamaLengkap()%></td>
                                <td><%= peminjaman.getTanggalPinjam()%></td>
                                <td><%= peminjaman.getTanggalBalik()%></td>
                                <td><%= detailStatus.get(peminjaman.getStatus())%></td>
                                <td><%= peminjaman.getTotalBiaya()%></td>
                            </tr>
                            <%
                                    i++;
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- END wrap class -->
    </div><!-- END main_bg-->
    <%@include file="/partial/footer.jsp" %>
</body>
</html>
