<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Search results</h1>
<table class="table">
<tbody>
<c:forEach items="${results}" var="result">
    <tr>
        <td scope="row"><a href="/ui/search?uuid=${result.uuid}">${result.uuid}</a></td>
        <td>${result.type}</td>
        <td>${result.title}</td>
    </tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="_footer.jsp"/>