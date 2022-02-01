<%@ include file="/WEB-INF/jsp/head.jsp"%>
<form action="<%=request.getContextPath() %>/jsp/attribute/solve.jsp"  method="post">
    <input type="number" name="m1" placeholder="member 1"><br>
    <input type="number" name="m2" placeholder="member 2"><br>
    <select name="save-in">
        <option value="session">session</option>
        <option value="request">request</option>
    </select>
    <button type="submit">Additionner</button>
</form>
<%@ include file="/WEB-INF/jsp/foot.jsp"%>
