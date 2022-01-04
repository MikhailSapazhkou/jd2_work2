<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add user photo</h1>
<form method="post" action="/ui/add-person-photo.do" enctype="multipart/form-data">
<div class="form-group">
  <label for="personPhoto">Person photo</label>
  <input type="file" name="image" class="form-control-file" id="personPhoto"/>
</div>
<button type="submit" class="btn btn-primary">Submit</button>
<jsp:include page="_footer.jsp"/>