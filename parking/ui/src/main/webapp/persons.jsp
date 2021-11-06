<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>List of persons</h1>
<table class="table">
<tbody>
<c:forEach items="${persons}" var="person">
    <tr>
        <td scope="row"><a href="/ui/person?id=${person.id}">Open</a></td>
        <td>${person.name}</td>
        <td>${person.secondName}</td>
    </tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="_footer.jsp"/>