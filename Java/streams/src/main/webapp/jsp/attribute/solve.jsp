<%
int m1 = Integer.parseInt(request.getParameter("m1"));
int m2 = Integer.parseInt(request.getParameter("m2"));
String saveIn = request.getParameter("save-in");

switch(saveIn){
    case "session" :
        session.setAttribute("rslt", m1+m2);
        break;
    case "request" :
        request.setAttribute("rslt", m1+m2);
        break;
    default:
        response.sendError(400);
}

//request.getRequestDispatcher("./rslt.jsp").forward(request, response);
response.sendRedirect("./rslt.jsp");
%>