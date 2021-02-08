<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registrarse</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
	  <!-- SweetAlert -->
  <script src='js/sweetalert.min.js'></script>
  <link rel='stylesheet' type='text/css' href='css/sweetalert.css'>
 <!--===============================================================================================--> 
 
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/agency.min.css" rel="stylesheet">

</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style="background-color: #000000;">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">Futbol Five</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="index.jsp">Inicio</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="login.jsp">Ingresar</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <br>	
  <br>	
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="registrarseCONTROLADOR" method="post" role="form" style="display: block;">
					<span class="login100-form-title p-b-49">
						Registrarse
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Usuario Requerido">
						<span class="label-input100"></span>
						<input class="input100" type="text" name="username" placeholder="Usuario">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Correo Requerido">
						<span class="label-input100"></span>
						<input class="input100" type="email" name="email" placeholder="Correo">
						<span class="focus-input100" data-symbol="&#9993;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Contraseña Requerida">
						<span class="label-input100"></span>
						<input class="input100" type="password" name="pass" placeholder="Contraseña">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Contraseña Requerida">
						<span class="label-input100"></span>
						<input class="input100" type="password" name="reppass" placeholder="Repetir Contraseña">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<br></br>
					<div class="form-check">
  						<input class="form-check-input" type="radio" name="role" id="exampleRadios2" value="Jugador" checked>
  						<label class="form-check-label" for="exampleRadios2">
  					  	Jugador
  						</label>
					</div>
					<div class="form-check">
 						 <input class="form-check-input" type="radio" name="role" id="exampleRadios1" value="Dueño" >
 						 <label class="form-check-label" for="exampleRadios1">
  						 Dueño
  						</label>
					</div>
					
					
					<div class="text-right p-t-8 p-b-31">
					</div>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" value="create" name="action">
								Registrarse
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
  <!-- mensaje error-->
<%if (session.getAttribute("msg")=="0"){%>
		<script>
		 swal("Ups!","Ese usuario ya esta registrado","error","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>

<%if (session.getAttribute("msg")=="2"){%>
		<script>
		 swal("Ups!","Las contraseñas no son iguales","error","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

<!-- Footer Elements -->
  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    <a href="http://localhost:8084/FutbolFive/index.jsp"> FutbolFive.com</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->

</body>
</html>