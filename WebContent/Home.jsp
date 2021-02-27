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
      <a href="Home.jsp" class="button"> Home</a>
    </div>
  	<div class="nome">
		<h1> Clinica Becuba</h1>
		</div>
    </div>
    

  <div class="login">
  <h1>Login:</h1>
 	    <form action="LoginController" method="post">
 	    	<p> Codice Fiscale: </p>
 	    	<input type="text" name="fc">
 	    	<p> Password: </p>
 	    	<input type="text" name="password">
    	<div class = "loginType">
			<select name="status" >
				<option selected disabled> Seleziona: </option>
				<option value="User"> Utente </option>
				<option value="Med">Medico </option>
				<option value="Admin">Amministratore </option>
			</select>
			</div>

         <input type="submit" name = "btn_login" value="Login">
      <p> Non sei ancora registrato? Registrati qui:</p>
   	<div class="cta">
        <a href="RegistrationInterface.jsp" class="button">Registrati</a>
      </div>
	</form>
	</div>
</body>
</html>