<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Browse And Upload your File</h3>
	<c:url value="/upload?${_csrf.parameterName}=${_csrf.token}" var="postURL" />
    <form method="post" action="${postURL}" enctype="multipart/form-data">
        <input id="file-id" type="file" name="file" />
        <br/>
        <input type="submit" value="Upload"/>
    </form>
