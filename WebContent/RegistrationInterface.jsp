<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.mvc.controller.RegisterControllerPerson"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>Registrazione | Becuba</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="styleHome.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>

  <div class="header">
  <div class="cta">
      <a href="Home.jsp" class="button"> Home</a>
    </div>
  	<div class="nome">
		<h1> Clinica Becuba</h1>
		</div>
    </div>
    
<div class="registration">
  <h1>Registrazione:</h1>
			<form action="RegisterControllerPerson" method="post"> 	    	
			<p> Nome: </p>
 	    	<input type="text" name="firstname">
 	    	<p> Cognome: </p>
 	    	<input type="text" name="lastname">
 	    	<p> Età: </p>
 	    	<input type="text" name="age">
 	    	<p> Sesso: </p>
 	    	<input type="text" name="gender">
 	    	<p> Città: </p>
 	    	<input type="text" name="city">
 	    	<p> Codice Fiscale: </p>
 	    	<input type="text" name="fc">
 	    	<p> Password: </p>
 	    	<input type="text" name="password">
			<div class="cta">
        <input type="submit" name = "btn_register" value="Reegistrati">
      </div>
	</form>
	</div>
</body>
</html>

