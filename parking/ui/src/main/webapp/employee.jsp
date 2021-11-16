<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add new employee</h1>


<form method="post" action="/ui/employee">
  <div class="mb-3">
    <label for="firstName" class="form-label">Email address</label>
    <input name="firstName" type="text" class="form-control" id="firstName" aria-describedby="firstNameHelp">
    <div id="firstNameHelp" class="form-text">Enter employee first name</div>
  </div>
  <div class="mb-3">
      <label for="secondName" class="form-label">Email address</label>
      <input name="secondName" type="text" class="form-control" id="secondName" aria-describedby="secondNameHelp">
      <div id="secondNameHelp" class="form-text">Enter employee second name</div>
  </div>
  <div class="mb-3">
        <label for="phoneNumber" class="form-label">Email address</label>
        <input name="phoneNumber" type="text" class="form-control" id="phoneNumber" aria-describedby="phoneNumberHelp">
        <div id="phoneNumberHelp" class="form-text">Enter employee phone number</div>
  </div>
  <input type="hidden" name="command" value="add-new-employee">
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>