<%-- 
    Document   : detail
    Created on : 26-Apr-2015, 21:46:30
    Author     : Kandito Agung
--%>

<%@page import="models.PeminjamanItem"%>
<%@page import="models.Alat"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Peminjaman"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/partial/sessionCheckAdmin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            EntityManager em = DatabaseInfo.getEntityManager();
            int id = 0;
            try {
                String ids = request.getParameter("id");
                if (ids == null) {
                    response.sendRedirect(request.getContextPath() + "/admin/peminjaman");
                    return;
                } else {
                    id = Integer.parseInt(ids);
                }

            } catch (Exception ex) {
                response.sendRedirect(request.getContextPath() + "/admin/peminjaman");
                return;
            }

            if (id == 0) {
                response.sendRedirect(request.getContextPath() + "/admin/peminjaman");
                return;
            }
            
            Peminjaman peminjaman = em.find(Peminjaman.class, id);
            em.close();
        %>
        <title>Detail Peminjaman</title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
        <div class="main_bg">
            <div class="wrap">	
                <div class="main">
                    <h2 class="style top">Detail Peminjaman</h2>
                    <hr>
                    <div class="form-item">
                        <div class="form-label">
                            <label>Username</label>
                        </div>
                        <div class="form-input">
                            <label class="label-value"><a href="<%= request.getContextPath()%>/admin/user/detail.jsp?id=<%= peminjaman.getIdUser().getIdUser()%>"><%= peminjaman.getIdUser().getUsername()%></a></label>
                        </div>
                    </div>

                    <div class="form-item">
                        <div class="form-label">
                            <label>Nama</label>
                        </div>
                        <div class="form-input">
                            <label class="label-value"><%= peminjaman.getIdUser().getNamaLengkap()%></label>
                        </div>
                    </div>    

                    <div class="form-item">
                        <div class="form-label">
                            <label>Tanggal Pinjam</label>
                        </div>
                        <div class="form-input">
                            <label class="label-value"><%= peminjaman.getTanggalPinjam()%></label>
                        </div>
                    </div> 

                    <div class="form-item">
                        <div class="form-label">
                            <label>Tanggal Kembali</label>
                        </div>
                        <div class="form-input">
                            <label class="label-value"><%= peminjaman.getTanggalBalik()%></label>
                        </div>
                    </div> 

                    <div class="form-item">
                        <div class="form-label">
                            <label>Total Biaya</label>
                        </div>
                        <div class="form-input">
                            <label class="label-value"><%= peminjaman.getTotalBiaya()%></label>
                        </div>
                    </div> 

                    <div class="form-item">
                        <div class="form-label">
                            <label>Keterangan</label>
                        </div>
                        <div class="form-input">
                            <label class="label-value"><%= peminjaman.getKeterangan()%></label>
                        </div>
                    </div> 

                    <form method="POST" action="<%= request.getContextPath()%>/peminjaman/updatestatus">
                        <input type="hidden" name="id_peminjaman" value="<%= peminjaman.getIdPeminjaman() %>">
                        <div class="form-item">
                            <div class="form-label">
                                <label>Status</label>
                            </div>
                            <div class="form-input">
                                <select name="status">
                                    <%
                                        ArrayList<String> list = new ArrayList<String>();
                                        list.add("Belum disetujui");
                                        list.add("Disetujui");
                                        list.add("Alat dipinjam");
                                        list.add("Alat dikembalikan");
                                        int i = 0;
                                        for (String kategori : list) {
                                    %>

                                    <% if (peminjaman.getStatus() == i) {%>
                                    <option value="<%= i%>" selected><%= kategori%></option>
                                    <% } else {%>
                                    <option value="<%= i%>"><%= kategori%></option>
                                    <% } %>

                                    <% i++;
                                        }%>
                                </select>
                                <input type="submit" value="Ubah status">
                            </div>
                        </div> 
                    </form>
                    <a href="<%= request.getContextPath()%>/admin/peminjaman">Kembali</a>
                    <h2 class="style top">Daftar alat dipinjam</h2>
                    <table class="table-content" style="width:60% !important">
                        <thead>
                            <tr style="background:#ffbf00">
                                <th style="width:10%">No</th>
                                <th style="width:30%">Nama Alat</th>
                                <th style="width:20%">Jumlah</th>
                                <th style="width:40%">Keterangan</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int j = 1;
                                for (PeminjamanItem item : peminjaman.getPeminjamanItemCollection()) {
                            %>
                            <tr>
                                <td><%= j%></td>
                                <td><a href="<%= request.getContextPath()%>/admin/alat/detail.jsp?id=<%= item.getIdAlat().getIdAlat()%>"><%= item.getIdAlat().getNama()%></a></td>
                                <td style="text-align: center;"><%= item.getJumlah()%></td>
                                <td><%= item.getKeterangan()%></td>
                            </tr>
                            <%
                                    j++;
                                }
                            %>
                        </tbody>
                    </table>
                    <hr>
                </div>
            </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
