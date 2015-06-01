<%-- 
    Document   : index
    Created on : 26-Apr-2015, 15:16:03
    Author     : Kandito Agung
--%>

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
            if(username == null) {
                response.sendRedirect(request.getContextPath());
            }
        %>
        <title>Cart - Sistem Peminjaman Mapala UI</title>
        <%@include file="/partial/head.jsp" %>
        <style>
            #cart {width:80%; border:1px; text-align: center;}
            #cart td {vertical-align: middle}

            form label {
                margin-right: 10px;
                width: 300px;
                display: block;
            }
        </style>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- body wrapper -->
        <div class="main_bg">
            <div class="wrap">
                <div class="main">
                    <h2 style="font-size: 3em;">Keranjang Peminjaman</h2>
                    <%
                        Cart cart = (Cart) session.getAttribute("cart");
                        EntityManager em = DatabaseInfo.getEntityManager();
                        if (cart == null) {
                    %>
                    <h3>Keranjang peminjaman kosong</h3>
                    <%
                    } else {
                    %>
                    <table id="cart">
                        <thead style="background: #ffbf00">
                            <tr>
                                <th width="10%">No</th>
                                <th width="30%">Gambar</th>
                                <th width="30%">Nama alat</th>
                                <th width="20%">Jumlah</th><th></th>
                                <th width="10%"></th>
                            </tr>
                        </thead>
                        <%
                            HashMap<Integer, Integer> items = cart.getCartItem();
                            int i = 1;
                            for (int key : items.keySet()) {
                                Alat alat = em.find(Alat.class, key);
                        %>
                        <tr>
                            <td><%= i%></td>
                            <td><img src="${pageContext.request.contextPath}/gambar/<%= alat.getGambar()%>" alt="<%= alat.getNama()%>" title="" height="50%"/></td>
                            <td><%= alat.getNama()%></td>
                            <td><%= items.get(key)%></td>
                            <td><a href="${pageContext.request.contextPath}/removeCart?id=<%= alat.getIdAlat()%>">Hapus</a></td>
                        </tr>
                        <%
                                    i++;
                                }
                            }
                        %>
                    </table>
                    <hr>
                    <%
                    if (cart != null) {
                    %>
                    <div class="">
                        <h3 style="font-size: 1.5em;">Info peminjam</h3>
                        <form action="<%= request.getContextPath()%>/peminjaman/create" method="POST" accept-charset="utf-8">
                            <%
                                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
                                Date now = new Date();
                                String strDate = sdfDate.format(now);
                            %>
                            <label>Tanggal Kembali :</label><input type="text" name="tanggal_pinjam" value="<%= strDate%>"><br>
                            <label>Tanggal Kembali :</label><input type="text" name="tanggal_balik"><br>
                            <label>Keterangan:</label>
                            <textarea name="keterangan"></textarea>
                            <input type="submit" name="" value="CHECKOUT" class="price">
                        </form>
                    </div>
                    <% } %>
                </div>
            </div>
        </div><!-- END wrap class -->
    </div><!-- END main_bg-->
    <%@include file="/partial/footer.jsp" %>
</body>
</html>
