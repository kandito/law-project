<!-- bagian header putih -->
<div class="header_bg">
    <div class="wrap">
        <div class="header">
            <div class="logo">
                <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/img/logo.png" alt=""/> </a>
            </div>
            <div class="h_icon">
                <ul class="icon1 sub-icon1">
                    <li><a href="${pageContext.request.contextPath}/history.jsp"><img src="${pageContext.request.contextPath}/img/user32.png" alt="" height="60px" width="60px" class="active-icon"></a></li>
                    <li>&nbsp;&nbsp;</li>
                    <li>&nbsp;&nbsp;</li>
                    <li><a href="${pageContext.request.contextPath}/cart.jsp"><img src="${pageContext.request.contextPath}/img/shopping-cart-insert-icon.png" alt="" height="60px" width="60px" class="active-icon"></a></li> 
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div><!-- END header putih -->

<!-- bagian header kuning dengan menu-->
<div class="header_btm">
    <div class="wrap">
        <div class="header_sub">
            <div class="h_menu">
                <ul>
                    <% if (session.getAttribute("username") != null && session.getAttribute("role").equals("admin")) {%>
                    <li><a href="${pageContext.request.contextPath}">Beranda</a></li> |
                    <li><a href="${pageContext.request.contextPath}/admin/alat">Daftar Alat</a></li> |
                    <li><a href="${pageContext.request.contextPath}/admin/user">Pengguna</a></li> |
                    <li><a href="${pageContext.request.contextPath}/admin/peminjaman">Peminjaman</a></li> |
                    <li><a href="${pageContext.request.contextPath}/admin/peminjaman/report.jsp">Laporan Keuangan</a></li> |
                    <li><a href="${pageContext.request.contextPath}/admin/logout">Logout (<%= session.getAttribute("username")%>)</a></li>
                        <% } else if (session.getAttribute("username") != null && session.getAttribute("role").equals("user")) {%>
                    <li><a href="${pageContext.request.contextPath}">Beranda</a></li> |
                    <li><a href="${pageContext.request.contextPath}/alat">Daftar Alat</a></li> |
                    <li><a href="${pageContext.request.contextPath}/user/logout">Logout (<%= session.getAttribute("username")%>)</a></li>
                        <% } else { %>
                    <li><a href="${pageContext.request.contextPath}">Beranda</a></li> |
                    <li><a href="${pageContext.request.contextPath}/alat">Daftar Alat</a></li> |
                    <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                        <% }%>

                </ul>
            </div>
            <!-- menu untuk mobile -->
            <div class="top-nav">
                <nav class="nav">	        	
                    <a href="#" id="w3-menu-trigger"> </a>
                    <ul class="nav-list" style="">
                        <% if (session.getAttribute("username") != null && session.getAttribute("role").equals("admin")) {%>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}">Beranda</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/admin/alat">Daftar Alat</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/admin/user">Pengguna</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/admin/peminjaman">Peminjaman</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/admin/peminjaman/report.jsp">Laporan Keuangan</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/admin/logout">Logout (<%= session.getAttribute("username")%>)</a></li>
                            <% } else if (session.getAttribute("username") != null && session.getAttribute("role").equals("user")) {%>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}">Beranda</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/alat">Daftar Alat</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/user/logout">Logout (<%= session.getAttribute("username")%>)</a></li>
                            <% } else { %>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}">Beranda</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/alat">Daftar Alat</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                            <% }%>
                    </ul>
                </nav>
                <div class="clear"> </div>
                <script src="js/responsive.menu.js"></script>
            </div>		  <!-- END menu mobile -->
            <div class="clear"></div>
        </div>
    </div>
</div><!-- END header kuning -->