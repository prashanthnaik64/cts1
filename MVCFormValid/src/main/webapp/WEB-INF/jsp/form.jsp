<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>   
  .error{
      color:red;
  }
</style>
</head>
<body>
	<form:form action="registerNewUser" method="post" modelAttribute="user">
	   <table>	      
	      <tr>
	        <td><form:label path="Uid">ID</form:label></td>
	        <td><form:input path="Uid"/></td>
	        <td><form:errors path="Uid" cssClass="error"></form:errors></td>
	      </tr>
	      <tr>
	        <td><form:label path="Name">NAME</form:label></td>
	        <td><form:input path="Name"/></td>
	        <td><form:errors path="Name" cssClass="error"></form:errors></td>
	      </tr>
	      <tr>
	        <td><form:label path="Email">EMAIL</form:label></td>
	        <td><form:input path="Email"/></td>
	        <td><form:errors path="Email" cssClass="error"></form:errors></td>
	      </tr>
	      <tr>
	        <td><input type="submit" value="SUBMIT"/></td>
	      </tr>
	   </table>
	</form:form>
</body>
</html>