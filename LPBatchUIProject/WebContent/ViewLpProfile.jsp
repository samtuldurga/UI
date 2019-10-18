<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>
<link href="css/style.css" rel="stylesheet"/>

</head>
<body>

<table>
<tr>
<th>LP Id</th><th>Full Name</th><th>Contact Details</th><th>Designation</th><th>Address</th>
</tr>
<c:forEach items="${lpModelList}" var="lpModel">

<tr>
<td><c:out value="${lpModel.id}"/></td>
<td><c:out value="${lpModel.fullName}"/></td>
<td><c:out value="${lpModel.contactDetails}"/></td>
<td><c:out value="${lpModel.role}"/></td>
<td><c:out value="${lpModel.address}"/></td>




</tr>

</c:forEach>

</table>
</form>
</body>
</html>