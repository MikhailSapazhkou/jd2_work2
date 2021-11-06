<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
    <h1>Hello, world!</h1>
    <form method="post" action="/ui/person">
    <div class="input-group">
      <span class="input-group-text">First and last name</span>
      <input name="name" type="text" aria-label="First name" class="form-control"/>
      <input name="second_name" type="text" aria-label="Last name" class="form-control"/>
      <input name="command" value="new" type="hidden"/>
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
    </form>
<jsp:include page="_footer.jsp"/>