<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Bonjour <%= request.getParameter("name")  %> !

<br>

<%=Integer.parseInt(request.getParameter("id")) + 2  %>

<br>

<% for (int i = 1 ; i <= 10 ;i++){
	
	%>
	<div  class="content" style="display:inline-block;width:16%;margin-bottom:20px;border:2px solid red;padding:10px" >
	<%
	
	for (int j = 1 ; j <= 10 ;j++){
	%>
	
	<div style="text-align:center;" >	 <%= i + " * " + j + " = " + i*j %> 	</div>
	
	<%
} %> </div>   <% } %>
	

</body>
</html>