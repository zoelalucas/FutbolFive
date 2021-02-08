<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*,modelo.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  
  
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link href="css/checkbox.css" rel="stylesheet">
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


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Canchas</title>
</head>
<body id="page-top">

   <!-- mensaje ok-->

<%if (session.getAttribute("msg")=="1"){%>
		<script>
			swal("Listo!","Ya creaste tu Cancha!","success","ok");
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
            <a class="nav-link js-scroll-trigger" href="canchasCONTROLADOR?action=listar">Crear Canchas</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="canchasCONTROLADOR?action=ListadoCanchas">Listar/Modificar Canchas</a>	
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="canchasCONTROLADOR?action=HistorialCanchas">Historial Canchas</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="logoutDAO">Cerrar Sesion</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!--/ Nav End /-->
  
    <br>
	<br>
	<br>
	<br>	
				
<form class="login100-form validate-form" id="login-form" action="canchasCONTROLADOR" method="POST">
	
 					<div class="limiter">
						<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
						<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
						<form class="login100-form validate-form" id="altaEve-form" action="canchasCONTROLADOR" method="POST" role="form" style="display: block;">
					<span class="login100-form-title p-b-49">
						Registra tu Cancha
					</span>
					
					
				
					
					<!-- Example single danger button -->
						<div class="form-group form-group-lg">
					        <label class="col-sm-8 control-label" for="lg" for="cboCategoriaProducto">Selecciona El Complejo</label>
					        <div class="col-sm-8">   
					            
					        <select class="form-control" id="cboCategoriaProducto" name="ID_Comp" value=ID_Comp>
					        <% ArrayList<complejosMODELO> complejosmodelos=(ArrayList<complejosMODELO>)request.getAttribute("complejosmodelos");
					        if(complejosmodelos!=null)//ESTO TMBN ES IMPORTANTE 
					        for(complejosMODELO complejosmodelo:complejosmodelos){%>
					        <option value="<%=complejosmodelo.getID_Comp()%>"><%=complejosmodelo.getNombre_Comp()%></option>
					        <%} %>
					        </select>
					        
					        </div>
					    </div>
					    
					<!-- finish Example single danger button -->
										<!-- List Box tamaño -->
					
						<div class="form-group form-group-lg">
					        <label class="col-sm-8 control-label" for="lg" for="cboCategoriaProducto">Tamaño De Cancha</label>
					        <div class="col-sm-8">   
					            
					        <select class="form-control" name="Tamaño_Can" id="Tamaño_Can">
					        
					        <option> 5 </option>
					        <option> 6 </option>
					        <option> 7 </option>
					        <option> 8 </option>
					        <option> 9 </option>
					        <option> 10 </option>
					        <option> 11 </option>
					        </select>
					        
					        </div>
					    </div>
					    
					<!-- finish List Box tamaño -->
					
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Ingresa el nombre de la Cancha">
						<span class="label-input100"></span>
						<input class="input100" type="text" placeholder="Nombre de la Cancha" name="Nombre_Can" id="Nombre_Can">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>				
					
					
					<div class="wrap-input100 validate-input" data-validate="Ingresa el precio de la Cancha">
						<span class="label-input100"></span>
						<input class="input100" type="text" placeholder="Precio de la Cancha" name="Precio_Can" id="Precio_Can">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>		
			
					<div class="wrap-input100">
						<span class="label-input100"></span>
						<input class="input100" type="text"  placeholder="Observaciones de la Cancha" name="Observaciones_Can" id="Observaciones_Can">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>		

					<br>
					<br>
					<br>
					<br>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" value="create" name="action" type="submit">
								Dar de alta la Cancha
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</center>
</form>	

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