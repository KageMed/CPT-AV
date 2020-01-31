<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= new Date() %>

Hello !

<jsp:useBean id="personne" scope="request"  class="Produit.Personne" />

<br>
<br>
	
Name = <%= personne.name %>

<br>
<br>

 <%= personne.name = "Amine" %>

<br>
<br>

New Name = <%= personne.name %>

</body>
</html>