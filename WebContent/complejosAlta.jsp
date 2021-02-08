<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dao.*,modelo.*,java.util.ArrayList"%>

<html>
<head>
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
  
  <title>Crear Complejos</title>
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

<!--Data picker--> 
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    
    
</head>

<body id="page-top">

   <!-- mensaje ok-->

<%if (session.getAttribute("msg")=="1"){%>
		<script>
			swal("Listo!","Ya creaste tu complejo!","success","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>


   <!-- mensaje error-->
<%if (session.getAttribute("msg")=="0"){%>
		<script>
		 swal("Ups!","Hubo un error, volve a intentarlo","error","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>

   <!-- mensaje error-->
<%if (session.getAttribute("msg")=="2"){%>
		<script>
		 swal("Ups!","Faltan completar datos, volve a intentarlo","error","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>					


<%if (session.getAttribute("Usuario_Usu")== null){ 
		response.sendRedirect("index.jsp");} %><!-- verifica la existencia de inicio de session-->
		
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style="background-color: #000000;">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="menuDueño.jsp"><%=(String)session.getAttribute("Usuario_Usu")%></a></p>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
           <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="complejosAlta.jsp">Crear Complejos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="complejosCONTROLADOR?action=listar">Listar/Modificar Complejos</a>	
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="complejosCONTROLADOR?action=historial">Historial Complejos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="logoutDAO">Cerrar Sesion</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
  <br>
  <br>
          		
  <!--/ Nav End /-->
  
  <!--ingreso datos para el alta-->
 			 <center>
 	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" id="altaEve-form" action="complejosCONTROLADOR" method="POST" role="form" style="display: block;">
					<span class="login100-form-title p-b-49">
						Registra tu Complejo
					</span>
					    
	
								    
								

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Ingresa el nombre del complejo">
						<span class="label-input100"></span>
						<input class="input100" type="text" placeholder="Nombre del complejo" name="Nombre_Comp" id="Nombre_Comp">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate="Ingresa la direccion del complejo">
						<span class="label-input100"></span>
						<input class="input100" type="text" placeholder="Direccion del complejo" name="Direccion_Comp" id="Direccion_Comp" >
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div > <br>
					</div>
					<div class="wrap-input100">
						<span class="label-input100"></span>
						<input class="input100" type="text" placeholder="Ingresa URL del logo (Opcional)" name="Foto_Comp" id="Foto_Comp" >
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
								
			
					<div class="wrap-input100 validate-input">
						<span class="label-input100"></span>
						<input class="input100" type="text"  placeholder="Observaciones del complejo" name="Observaciones_Comp" id="Observaciones_Comp"  >
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>		
					<br>
					<br>
					
										<!-- List Box Zona -->
					
						<div class="form-group form-group-lg">
					        <label class="col-sm-8 control-label" for="lg" for="cboCategoriaProducto"><strong>Ciudad</strong></label>
					        <div class="col-sm-8">   
					            
					        <select class="form-control" name="Ciudad_Comp" id="Ciudad_Comp" >
					        
					        <option> Rosario </option>
					        <option> Funes </option>
					        <option> Roldan </option>
					        <option> Fisherton </option>
					        <option> Ibarlucea </option>
					        
					        </select>
					        
					        </div>
					    </div>
					    
					<!-- finish List Box Zona -->
					<br>
					<!--DIAS Y HORARIOS INICIO-->
					
					<tr>
 						 <td><strong>Selección de Horarios</strong></td>
 						 
					</tr>
					<br><br>
					   		<input type="text" name="DesdeF1_Hor" id="DesdeF1_Hor" width="200" placeholder="Horario de Apertura F1"/>
					    <script>
					        $('#DesdeF1_Hor').timepicker();
					    </script>
					    
					    <br>
					    <br>
					        <input type="text" name="HastaF1_Hor" id="HastaF1_Hor" width="200" placeholder="Horario de Cierre F1" />
					    <script>
					        $('#HastaF1_Hor').timepicker();
					    </script>
					    
					    <br>
					    <br>
					        <input type="text" name="DesdeF2_Hor" id="DesdeF2_Hor" width="200" placeholder="Horario de Apertura F2"/>
					    <script>
					        $('#DesdeF2_Hor').timepicker();
					    </script>
					    
					    <br>
					    <br>
					        <input type="text" name="HastaF2_Hor" id="HastaF2_Hor" width="200" placeholder="Horario de Cierre F2"/>
					    <script>
					        $('#HastaF2_Hor').timepicker();
					    </script>
					    <br><br>
<table>
<tr>
  <td><strong>Selección de días</strong></td>
</tr>

<tr>
  <td>
  <br>
  	<div class="form-check form-check-inline">
                          <input name="Dias" class="form-check-input" type="checkbox" id="inlineCheckbox1" value="1">
                          <label class="form-check-label" for="inlineCheckbox1">Lunes</label>
    </div>
  </td>
</tr>

<tr>
  <td><div class="form-check form-check-inline">
          <input name="Dias" class="form-check-input" type="checkbox" id="inlineCheckbox2" value="2">
          <label class="form-check-label" for="inlineCheckbox2">Martes</label>
        </div>
  </td>
</tr>

<tr>
  <td>    <div class="form-check form-check-inline">
          <input name="Dias" class="form-check-input" type="checkbox" id="inlineCheckbox3" value="3">
          <label class="form-check-label" for="inlineCheckbox3">Miercoles</label>
        </div>
    </td>
</tr>

<tr>
  <td>    <div class="form-check form-check-inline">
          <input name="Dias" class="form-check-input" type="checkbox" id="inlineCheckbox4" value="4">
          <label class="form-check-label" for="inlineCheckbox4">Jueves</label>
        </div>
  </td>
</tr>

<tr>
  <td><div class="form-check form-check-inline">
      <input name="Dias" class="form-check-input" type="checkbox" id="inlineCheckbox5" value="5">
      <label class="form-check-label" for="inlineCheckbox5">Viernes</label>
    </div>
  </td>
</tr>

<tr>
  <td> <div class="form-check form-check-inline">
      <input name="Dias" class="form-check-input" type="checkbox" id="inlineCheckbox6" value="6">
      <label class="form-check-label" for="inlineCheckbox6">Sabado</label>
        </div>
 </td>
</tr>
<tr>
  <td><div class="form-check form-check-inline">
      <input name="Dias" class="form-check-input" type="checkbox" id="inlineCheckbox7" value="0">
      <label class="form-check-label" for="inlineCheckbox7">Domingo</label>
        </div>
  </td>
</tr>

</table>
				<!--DIAS Y HORARIOS FIN-->	
					
					
					<div class="text-right p-t-8 p-b-31">
					</div>
								
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" value="create" name="action">
								Dar de alta Complejo
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</center>
	

  <!-- Footer -->
  <footer class="footer" style="background-color:#D9D9D9; " >
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-4">

           <span class="copyright" text-align="center" >    <br >  Copyright © </br>Todos los derechos reservados<br> </span>
        </div>
        <div class="col-md-4">
          <img src="img/pie/futbolfive2.png" > 
        </div>
        <div class="col-md-4">

        </div>
      </div>
    </div>
  </footer>
	
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
</body>
</html>