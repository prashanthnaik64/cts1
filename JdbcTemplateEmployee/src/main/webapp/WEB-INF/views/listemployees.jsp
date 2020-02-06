<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: light blue">
<div align="center" >
${listemp }
 <table border="1px">
	   <tr>
	      <th>ID:</th>
	      <th>FNAME:</th>
	       <th>lNAME:</th>
	      <th>AGE:</th>
	      <th>Department id:</th>
	      <th>salary:</th>
	   </tr>
	   <c:forEach var="student" items="${listemp}">
	   <tr>
	     <td>${student.eid}</td>
	     <td>${student.fname}</td>
	      <td>${student.lname}</td>
	     <td>${student.age}</td>
	     <td>${student.did}</td>
	     <td>${student.salary}</td>
	   </tr>
	   </c:forEach>
	</table>
	</div>
</body>
</html>