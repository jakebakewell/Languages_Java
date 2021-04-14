<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<a href="/languages/${language.id}/delete">Delete</a>
	<a href="/languages" class="text-right">Home</a>
	<h1>Edit Language</h1>
	<form action="/languages/${language.id}/edit" method="post" class="d-flex flex-column">
		<input type="hidden" name="id" value="${language.id}">
	    <label for="name">Name</label>
	    <input type="text" id="name" name="name" value="${language.name}">
	    <label for="creator">Creator</label>
	    <input type="text" id="creator" name="creator" value="${language.creator}">
	    <label for="version">Version</label>
	    <input type="text" id="version" name="version" value="${language.version}">
	    <input type="submit" value="Submit"/>
	</form>
</body>
</html>