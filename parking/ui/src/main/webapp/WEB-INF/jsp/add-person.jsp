<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="_header.jsp"/>
    <h1>User details</h1>
    <f:form method="post" action="/ui/add-new-person.do" modelAttribute="addNewUserCommand">
    <div class="mb-3">
      <label for="name" class="form-label">First name</label>
      <f:input path="name" name="name" type="text" aria-label="First name" id="name" class="form-control"/>
    </div>
    <div class="mb-3">
      <label for="second_name" class="form-label">Last name</label>
      <f:input path="secondName" name="secondName" type="text" aria-label="Last name" id="second_name" class="form-control"/>
    </div>
    <div class="mb-3">
      <f:input path="command" name="command" value="new_user" type="hidden"/>
    </div>
    <div class="mb-3">
      <label for="login" class="form-label">User login</label>
      <f:input path="login" name="login" type="text" aria-label="User login" id="login" class="form-control"/>
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <f:input path="password" name="password" type="password" aria-label="Password" id="password" class="form-control"/>
    </div>
    <div class="mb-3">
      <f:button type="submit" class="btn btn-primary">Submit</f:button>
    </div>
    <div class="mb-3">
      <f:errors path="*"/>
    </div>
    </f:form>
<jsp:include page="_footer.jsp"/>