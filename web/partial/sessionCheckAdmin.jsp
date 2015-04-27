<% 
    String username = (String) session.getAttribute("username");
    if(username == null) {
        response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
        return;
    }
    
    String role = (String) session.getAttribute("role");
    if(!role.equals("admin")) {
        response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
        return;
    }
%>