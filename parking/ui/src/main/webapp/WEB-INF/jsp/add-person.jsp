<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
    <h1>User details</h1>
    <form method="post" action="/ui/add-new-person.do">
    <div class="mb-3">
      <label for="name" class="form-label">First name</label>
      <input name="name" type="text" aria-label="First name" id="name" class="form-control"/>
    </div>
    <div class="mb-3">
      <label for="second_name" class="form-label">Last name</label>
      <input name="secondName" type="text" aria-label="Last name" id="second_name" class="form-control"/>
    </div>
    <div class="mb-3">
      <input name="command" value="new_user" type="hidden"/>
    </div>
    <div class="mb-3">
      <label for="login" class="form-label">User login</label>
      <input name="login" type="text" aria-label="User login" id="login" class="form-control"/>
    <div>
    <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <input name="password" type="password" aria-label="Password" id="password" class="form-control"/>
    <div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
<jsp:include page="_footer.jsp"/>