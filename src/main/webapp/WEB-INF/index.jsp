<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center mb-5">All Languages</h1>
		<table class="table table-bordered table-active">
	    	<thead class="thead-dark">
	        	<tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Actions</th>
	        	</tr>
	    	</thead>
	    	<tbody>
		        <c:forEach items="${languages}" var="language">
		        <tr class="table-info">
		            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.version}"/></td>
		            <td><a href="/languages/${language.id}/delete">Delete</a> <a href="/languages/${language.id}/edit">Edit</a></td>
		        </tr>
		        </c:forEach>
	    	</tbody>
	  </table>
	  </div>
	  <div class="container mt-5">
	  		<form:form action="/languages" method="post" modelAttribute="language" class="d-flex flex-column">
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:input path="creator"/>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>
		        <form:input path="version"/>
			    <input type="submit" value="Submit"/>
		    </form:form>
	  </div>
</body>
</html>