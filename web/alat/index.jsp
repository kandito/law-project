<%-- 
    Document   : index
    Created on : 27-Apr-2015, 13:17:56
    Author     : Kandito Agung
--%>
<%@page import="java.util.Collection"%>
<%@page import="models.Alat"%>
<%@page import="javax.persistence.Query"%>
<%@page import="models.DatabaseInfo"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Alat</title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div class="main">
	<h2 class="style top">Daftar Alat</h2>
        <hr>
		<!-- start grids_of_3 -->
		
                    <%
                        EntityManager em = DatabaseInfo.getEntityManager();
                        Query q = em.createNamedQuery("Alat.findAll");
                        Collection<Alat> listAlat = q.getResultList();
                        em.close();
                        int i = 1;
                        for(Alat alat : listAlat) {
                    %>     
                    
                        <% if(i % 3 == 1) { %>
                        <div class="grids_of_3">
                        <% } %>
                            <div class="grid1_of_3">
                                <a href="${pageContext.request.contextPath}/alat/detail.jsp?id=<%= alat.getIdAlat() %>">
                                    <img src="${pageContext.request.contextPath}/gambar/<%= alat.getGambar() %>" alt=""/>
                                    <h3><%= alat.getNama() %></h3>
                                    <div class="price" >
                                        <h4>Rp <%= alat.getBiaya() %>/hari
                                        <% if(alat.getJumlahTersedia() > 0) { %>
                                            <span style="background:green;">Tersedia</span>
                                        <% } else { %>
                                            <span style="background:red;">Tidak Tersedia</span>
                                        <% } %>
                                        </h4>
                                    </div>
                                    <span class="b_btm"></span>
				</a>
                            </div>
                        
                        <% if(i % 3 == 0) { %> 
                        <div class="clear"></div>
                        </div>
                        <% } %>    
                        
                    <% i++; } %>
                    
                    <div class="clear"></div>

			
            
	</div>
</div>
</div>	
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
