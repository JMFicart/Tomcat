
<%@ include file="/WEB-INF/jsp/head.jsp" %>

    <h1>Les tags JSP</h1>

    <h2> La tag d'expression </h2>
    <p>Placé dans un out.print(...) de la méthode service</p>

    <p> valeur de l'expression 1+1 = <%= 1+1 %> </p>

    <h2> La tag de scriplet </h2>
    <p>Placé dans la méthode service</p>

    <% for(int i = 0; i<5 ; i++){ %>
        <p>salut - <%= a+i %> </p>
    <%}%>
    <% salut(); %>

    <h2>Les tags de declaration</h2>
    <p>Placé au niveau de la classe</p>

    <%! 

        int a = 5;
        Produit p = new Produit(1, "nom_prod", "marque_prod", 5);

        private void salut(){
            a = 10;
        }
    %>

    <h2>Les tags de directives</h2>

    <h3>page</h3>
    <p>permet un certain nombre de config de la jsp</p>

    <%@ page import="exo.models.Produit" %>
    <%@ page buffer="8kb" autoFlush="true" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%-- <%@ page extends="javax.servlet.http.HttpServlet" %> --%>
    <%@ page errorPage="./error.jsp" %>

    <h3>include</h3>
    <p>Prend le contenu d'un fichier pour l'inclure dans le fichier</p>

    <h2>Les données accessibles</h2>

    <%
        request
        response
        out
        session
    %>

<%@ include file="/WEB-INF/jsp/foot.jsp" %>
