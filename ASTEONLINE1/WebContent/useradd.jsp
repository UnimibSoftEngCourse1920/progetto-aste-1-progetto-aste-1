<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="ISO-8859-1">
<title>New User Created</title>
</head>
<body>
 <body>
    	<div class="log_reg-page">
		<div class="form">
        
          		Nome:
			<%
				String nome = request.getParameter("nome");
				out.print(nome);
			%>
			<br /> Cognome:
			<%
				String cognome = request.getParameter("cognome");
				out.print(cognome);
			%>
			<br /> Email:
			<%
				String email = request.getParameter("email");
				out.print(email);
			%>
			<br /> Username:
			
			<%
				String username = request.getParameter("username");
				out.print(username);
			%>
			<br /> Password:
			<%
				String password = request.getParameter("password");
				out.print(password);
			%>
			<br /> Indirizzo:
			<%
				String indirizzo = request.getParameter("indirizzo");
				out.print(indirizzo);
			%>
			<br /> Città:
			<%
				String città = request.getParameter("città");
				out.print(città);
			%>
			<br /> Ruolo:
			<%
				String  ruolo= request.getParameter("ruolo");
				out.print(ruolo);
			%>
			<br /> <br />
<button onclick="location.href='./Login.html'">Accedi</button>
		</div>
		<div id="push"></div>
	</div>
	<div class="footer">
	</div>
</body>
</html>