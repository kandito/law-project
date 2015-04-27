<%-- 
    Document   : login
    Created on : 26-Apr-2015, 22:53:29
    Author     : Kandito Agung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Admin</title>
        <%@include file="/partial/head.jsp" %>
    </head>
    <body>
        <%@include file="/partial/header.jsp" %>
        <!-- start main -->
        <div class="main_bg">
            <div class="wrap">	
                <div class="main">
                    <div class="login-wrap">
                        <h2 class="style top">Login Admin</h2><br>				
                        <form action="<%= request.getContextPath() %>/admin/login" method="POST">
                            Username : <input type="text" name="username"><br>
                            Password : <input type="password" name="password"><br>
                            <input type="submit" name="" value="LOGIN" class="price">
                        </form>
                    </div>
                    <div class="atau-wrap" align="center">
                        <h2 class="style top"></h2>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <%@include file="/partial/footer.jsp" %>
    </body>
</html>
