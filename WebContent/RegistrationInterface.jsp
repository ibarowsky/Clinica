<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.mvc.controller.RegisterControllerPerson"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>Medico | Becuba</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="styleHome.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;700;900&display=swap" rel="stylesheet">
</head>
<body>

<form action="RegisterControllerPerson" method="post">
  <div class="register">
    <ul class="register__title">
      <h3 class="big-text">Registrazione:</h3>
    </ul>
    <ul class="register_menu">

      <div class="register_content">
        <div class="register_field">
          <p class="small-text">Nome</p>
        </div>
        <div class="register_text-field">
          <input type="text" style="height: 20px" name="firstname" />
        </div>
      </div>

      <div class="register_content">
        <div class="register_field">
          <p class="small-text">Cognome</p>
        </div>
        <div class="register_text-field">
          <input type="text" style="height: 20px"  name="lastname" />
        </div>
      </div>

      <div class="register_content">
        <div class="register_field">
          <p class="small-text">Età</p>
        </div>
        <div class="register_text-field">
          <input type="text" style="height: 20px"  name="age" />
        </div>
      </div>
      
 <div class="register_content">
        <div class="register_field">
          <p class="small-text">Codice Fiscale</p>
        </div>
        <div class="register_text-field">
          <input type="text" style="height: 20px"  name="fc" />
        </div>
      </div>
      
        <div class="register_content">
        <div class="register_field">
          <p class="small-text">Città</p>
        </div>
        <div class="register_text-field">
          <input type="text" style="height: 20px"  name="city" />
        </div>
      </div>
      
	<div class="register_content">
        <div class="register_field">
          <p class="small-text">Sesso</p>
        </div>
        <div class="register_text-field">
          <input type="text" style="height: 20px"  name="gender" />
        </div>
      </div>
      <div class="register_content">
        <div class="register_field">
          <p class="small-text">Password</p>
        </div>
        <div class="register_text-field">
          <input type="text" style="height: 20px"  name="password" />
        </div>
      </div>
    <div class="register_button">
      <input type="submit" name = "btn_register" value="Invia">
    </div>
</div>
</body>
</html>

