<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
</head>
<body>
	<form action="<c:url value="/login" />" method="post">
		<label for="username">Username :</label>
		<input type="text" id="username" name="username" value="abc" />
		<label for="password">Password :</label>
		<input type="password" id="password" name="password" value="123" />
		<input type="submit" id="submit" value="Submit" />
	</form>
</body>
</html>