<%-- 
    Document   : detail
    Created on : 26-Apr-2015, 18:31:12
    Author     : Kandito Agung
--%>

<%@page import="models.Alat"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="models.DatabaseInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
                    return;
                } else {
                    id = Integer.parseInt(ids);
                }

            } catch (Exception ex) {
                response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
                return;
            }

            if (id == 0) {
                response.sendRedirect(request.getContextPath() + "/admin/alat/index.jsp");
                return;
            }
            Alat alat = em.find(Alat.class, id);
            em.close();
        %>
        <title>Detil - <%= alat.getNama()%></title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
        <div class="main_bg">
            <div class="wrap">	
                <div class="main">
                    <div class="single">
                        <!-- start span1_of_1 -->
                        <div class="left_content">
                            <div class="span1_of_1">
                                <!-- start product_slider -->
                                <div class="product-view">
                                    <div class="product-essential">
                                        <img src="${pageContext.request.contextPath}/gambar/<%= alat.getGambar()%>" alt="<%= alat.getNama()%>" title="" width="90%" height="90%" />
                                    </div>
                                </div>
                                <!-- end product_slider -->
                            </div>
                            <!-- start span1_of_1 -->
                            <div class="span1_of_1_des">
                                <div class="desc1">
                                    <h3><%= alat.getNama()%>(<%= alat.getKodeAlat()%>) </h3>
                                    <p><%= alat.getKeterangan()%></p>
                                    <h5>Rp. <%= alat.getBiaya()%> /hari</h5>
                                    <h5>Jumlah : <%= alat.getJumlah()%></h5>
                                    <hr>
                                    <a href="index.jsp">Kembali</a>
                                    <hr>
                                    <div class="available">
                                        <h4>Available Options :</h4>
                                        <% if (session.getAttribute("username") != null && session.getAttribute("role").equals("user")) {%>
                                        <ul>
                                            <li>Jumlah:
                                                <select>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </li>
                                        </ul>
                                        <div class="btn_form">
                                            <!-- <form method="GET"> -->
                                                <input type="submit" value="ADD TO CART" title="" />
                                            <!-- </form> -->
                                        </div>
                                        <div class="clear"></div><br>
                                        <h2 style="color: red;">STATUS TERSEDIA </h2>
                                        <p>Barang akan ditambahkan ke keranjang belanja. Bila sudah checkout maka barang akan dilihat untuk disetujui oleh admin terlebih dahulu</p>


                                        <% } else { %>
                                        <ul>
                                            <li>Silahkan login untuk meminjam
                                            </li>
                                        </ul>
                                        <div class="clear"></div><br>
                                        <h2 style="color: red;">STATUS TERSEDIA </h2>
                                        <p>Barang akan ditambahkan ke keranjang belanja. Bila sudah checkout maka barang akan dilihat untuk disetujui oleh admin terlebih dahulu</p>

                                        <% }%>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <div class="clear"></div>
                            <!-- start tabs -->
                            <section class="tabs">
                                <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked">
                                <label for="tab-1" class="tab-label-1">Spesifikasi</label>

                                <div class="clear-shadow"></div>

                                <div class="content">
                                    <div class="content-1">
                                        <p class="para top"><%= alat.getSpesifikasi()%></p>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                            </section>
                            <!-- end tabs -->
                        </div>
                        <!-- start sidebar -->
                        <div class="left_sidebar">

                        </div>
                        <!-- end sidebar -->
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <%@include file="/partial/footer.jsp" %>
    </body>
</html>
