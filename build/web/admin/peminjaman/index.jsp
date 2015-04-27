<%-- 
    Document   : index
    Created on : 26-Apr-2015, 21:26:19
    Author     : Kandito Agung
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Peminjaman"%>
<%@page import="models.Peminjaman"%>
<%@page import="java.util.Collection"%>
<%@page import="models.User"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/partial/sessionCheckAdmin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Peminjaman</title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
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
                                <th style="width:10%">Status</th>
                                <th style="width:10%">Total Biaya</th>
                                <th style="width:10%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                EntityManager em = DatabaseInfo.getEntityManager();
                                Query q = em.createNamedQuery("Peminjaman.findAll");
                                Collection<Peminjaman> listPeminjaman = q.getResultList();
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
                                <td><a href="<%= request.getContextPath()%>/admin/user/detail.jsp?id=<%= peminjaman.getIdUser().getIdUser()%>"><%= peminjaman.getIdUser().getUsername()%></a></td>
                                <td><%= peminjaman.getIdUser().getNamaLengkap()%></td>
                                <td><%= peminjaman.getTanggalPinjam()%></td>
                                <td><%= peminjaman.getTanggalBalik()%></td>
                                <td><%= detailStatus.get(peminjaman.getStatus())%></td>
                                <td><%= peminjaman.getTotalBiaya()%></td>
                                <td>
                                    <a href="<%= request.getContextPath()%>/peminjaman/delete?id=<%= peminjaman.getIdPeminjaman()%>" onclick="return confirm('Anda yakin ingin menghapus?')">Hapus</a> |
                                    <a href="<%= request.getContextPath()%>/admin/peminjaman/detail.jsp?id=<%= peminjaman.getIdPeminjaman()%>">Detail</a>
                                </td>
                            </tr>
                            <%
                                    i++;
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
