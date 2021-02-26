<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>Home | Becuba</title>

  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="styleHome.css">

</head>
<body>

  <div class="header">
  <div class="cta">
      <a href="Home.html" class="button"> Home</a>
    </div>
  	<div class="nome">
		<h1> Clinica Becuba</h1>
		</div>
    </div>
    <form action="LoginController" method="post" >
  <div class="login">
 	     <h1 class="med-text">Effettua il login:</h1><br>
      <p class="small-text">Codice Fiscale</p><br>
      <input type="text" name="fc"/>
      <p class="small-text">Password</p>
 	
      <input type="text" name="password"/>
    	<div class = "loginType">
			<select name="status" >
				<option value="User" selected="selected">Utente </option>
				<option value="Med">Medico </option>
				<option value="Admin">Amministratore </option>
			</select>

        <input type="submit" name = "btn_login" value="Invia">

	</div>
  </div>
</form>

</body>
</html>