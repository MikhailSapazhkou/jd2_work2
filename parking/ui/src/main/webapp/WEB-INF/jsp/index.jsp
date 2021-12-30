<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
    <h1>Home</h1>
    <h2>
    <c:out value="${sessionScope.currentPerson.name}"/><br/>
    <c:out value="${sessionScope.currentPerson.secondName}"/>
    </h2>
<jsp:include page="_footer.jsp"/>