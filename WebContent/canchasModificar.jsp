<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dao.*,modelo.*,java.util.ArrayList"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/agency.min.css" rel="stylesheet">
  
		  <!-- SweetAlert -->
  <script src='js/sweetalert.min.js'></script>
  <link rel='stylesheet' type='text/css' href='css/sweetalert.css'>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar/Eliminar Canchas</title>
</head>
<body>
<%if (session.getAttribute("Usuario_Usu")== null){ 
		response.sendRedirect("index.jsp");} %><!-- verifica la existencia de inicio de session-->

   <!-- mensaje ok-->

<%if (session.getAttribute("msg")=="1"){%>
		<script>
			swal("Listo!","Ya actualizamos los datos de tu complejo!","success","ok");
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

<!--ingreso datos para el alta-->
 			 <center>
				<form class="login100-form validate-form" id="altaEve-form" action="canchasCONTROLADOR" method="POST" role="form" style="display: block;">
					
								    
								    <% canchasMODELO canchasmodelo= (canchasMODELO)request.getAttribute("canchasmodelos");
								    String name = "";
								    int place = -1;
								    int type = -1;
								    String dateF = "";
								    int id = -1;
								    int ID_Comp= -1;
								    
								    if (canchasmodelo != null) {
										id = canchasmodelo.getID_Can();
										ID_Comp = canchasmodelo.getID_Comp();
								    	name = canchasmodelo.getNombre_Can();
								    	place = canchasmodelo.getTamaño_Can();
								    	type = canchasmodelo.getPrecio_Can();
								    	dateF = canchasmodelo.getObservaciones_Can();
								    }%>
								    
						<input  class="input100" type="hidden" name="id" id="id" value="<%=id %>">
						<input  class="input100" type="hidden" name="ID_Comp" id="ID_Comp" value="<%=ID_Comp %>">
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
	<br>
	<br>
	<br>
	<br>
								<span>
				<strong><u>Actualizar los datos de tu Cancha</u></strong>	
					</span>
	<br>
	<br>
	<br>
	<br>
	<br>
					<div class="wrap-input100 validate-input" data-validate = "Por favor Ingrese el nombre">
						<span class="label-input100">Nombre de la Cancha</span>
						<input class="input100" type="text" name="Nombre_Can" id="Nombre_Can" value="<%=name %>">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Por favor Ingrese el tamaño">
						<span class="label-input100">Tamaño</span>
						<input class="input100" type="text" name="Tamaño_Can" id="Tamaño_Can" value="<%=place %>">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Por favor Ingrese la precio">
					<span class="label-input100">Precio</span>
					<input class="input100" type="text" name="Precio_Can" id="Precio_Can" value="<%=type %>">
					<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Por favor Ingrese una observacion">
						<span class="label-input100">Observaciones</span>
						<input class="input100" type="text" name="Observaciones_Can" id="Observaciones_Can" value="<%=dateF %>">
						<span class="focus-input100"></span>
					</div>
					
					<br></br>
					
					
					<div class="container-login100-form-btn">
						<button type="submit" name="action" value="update" id="update-submit" tabindex="4" class="btn btn-outline-primary">Modificar</button>
						<button type="submit" name="action" value="eliminar" id="delete-submit" tabindex="4" class="btn btn-outline-primary">Eliminar</button>
					</div>
					
				</form>
	</center>
	
	<!--Fin-->

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
</body>
</html>