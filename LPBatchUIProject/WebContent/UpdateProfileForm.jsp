<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form method="post" action="lpprofileviewservlet?action=updateProfile">
<table>


<tr>
<td><label for="firstName">First Name:</label></td>
<td><input type="text" name="firstName"  value="${lpModelList.firstName}" readonly="readonly"/>&nbsp;<label style="color:red"><c:out value="${firstnameerror}"/></label></td>
</tr>

<tr>
<td><label for="lastName">Last Name:</label></td>
<td><input type="text" name="lastName"/>&nbsp;<label style="color:red"><c:out value="${lastnameerror}"/></label></td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><input type="email" name="email" value="${lpModelList.email}"/>&nbsp;<label style="color:red"><c:out value="${emailerror}"/></label><label style="color:red"><c:out value="${emailexisterror}"/></label></td>
</tr>

<tr>
<td><label for="phoneNumber">Phone Number:</label></td>
<td><input type="text" name="phoneNumber"/>&nbsp;<label style="color:red"><c:out value="${phonenumbererror}"/></label></td>
</tr>

<tr>
<td><label for="role">Role:</label></td>
<td><input type="text" name="role"/></td>
</tr>

<tr>
<td><label for="city">City:</label></td>
<td><input type="text" name="city"/></td>
</tr>


<tr>
<td><label for="state">State:</label></td>
<td><input type="text" name="state"/></td>
</tr>

<tr>
<td><label for="country">Country:</label></td>
<td><input type="text" name="country"/></td>
</tr>


<tr>
<td><input type="submit" value="Update" class="button"></td>
<td><input type="reset" value="Cancel" class="button"/></td>
</tr>
</table>
</form>
</div>


</body>
</html>