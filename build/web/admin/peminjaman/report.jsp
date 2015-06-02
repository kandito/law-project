<%-- 
    Document   : index
    Created on : 26-Apr-2015, 21:26:19
    Author     : Kandito Agung
--%>

<%@page import="java.util.List"%>
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
                    <h2 class="style top">Laporan Keuangan</h2>
                    <hr>
                    <table class="table-content table-center">
                        <thead>
                            <tr style="background:#ffbf00">
                                <th style="width:5%">No</th>
                                <th style="width:35%">Deskripsi</th>
                                <th style="width:10%">Mata uang</th>
                                <th style="width:20%">Jumlah biaya</th>
                                <th style="width:20%">Tanggal pembayaran</th>
                                <th style="width:10%">ID Peminjaman</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%-- start web service invocation --%>
                            <%
                                List<exes.ws.Transaction> transactions = null;

                                try {
                                    exes.ws.Service_Service service = new exes.ws.Service_Service();
                                    exes.ws.Service port = service.getServicePort();
                                    // TODO initialize WS operation arguments here
                                    java.lang.String token = "e5f2a0f34f1662b3";
                                    // TODO process result here
                                    exes.ws.TransactionWrapper result = port.getTransaction(token);
                                    transactions = result.getAll();
                                } catch (Exception ex) {
                                    // TODO handle custom exceptions here
                                }
                            %>
                            <%-- end web service invocation --%>



                            <%
                                int i = 1;
                                for (exes.ws.Transaction t : transactions) {
                            %>
                            <tr>
                                <td><%= i%></td>
                                <td><%= t.getDeskripsi()%></td>
                                <td><%= t.getMataUang()%></td>
                                <td><%= t.getAmount()%></td>
                                <td><%= t.getTglTransaksi()%></td>
                                <%
                                    int idx = t.getDeskripsi().indexOf("#");
                                    String id_peminjaman = "";
                                    if (idx > 0) {
                                        id_peminjaman = t.getDeskripsi().substring(idx + 1, t.getDeskripsi().length());
                                    }

                                    if (!id_peminjaman.equals("")) {
                                %>
                                <td><a href="<%= request.getContextPath()%>/admin/peminjaman/detail.jsp?id=<%= id_peminjaman%>">#<%= id_peminjaman%></a></td>
                                <%
                                } else {
                                %>
                                <td></td>
                                <%
                                    }
                                %>

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
