<% 
    String username = (String) session.getAttribute("username");
    if(username == null) {
        response.sendRedirect(request.getContextPath());
        return;
    }
    
    String role = (String) session.getAttribute("role");
    if(!role.equals("user")) {
        response.sendRedirect(request.getContextPath());
        return;
    }
%>