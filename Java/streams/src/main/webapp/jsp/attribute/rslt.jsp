<%@ include file="/WEB-INF/jsp/head.jsp"%>

<h1>Résultat : </h1>

<p>Résultat dans la session: <%=session.getAttribute("rslt") %></p>
<p>Résultat dans la requête: <%=request.getAttribute("rslt") %></p>

<%@ include file="/WEB-INF/jsp/foot.jsp"%>