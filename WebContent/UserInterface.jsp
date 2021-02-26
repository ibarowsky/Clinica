<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="createInterfaces.UserInterface"%>
<!DOCTYPE html>
<html>
<head>
<% if(session.getAttribute("login") == null || session.getAttribute("login") == "") 
	response.sendRedirect("Home.html");
%>
<meta charset="ISO-8859-1">
<title>User | Becuba</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="styleHome.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
	<%
		String doc = UserInterface.BuildUserInterface((String) session.getAttribute("login"));
		out.print(doc);
	%>
</body>
</html>