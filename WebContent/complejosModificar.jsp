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
<title>Insert title here</title>
</head>
<body>
<%if (session.getAttribute("Usuario_Usu")== null){ 
		response.sendRedirect("index.jsp");} %><!-- verifica la existencia de inicio de session-->

   <!-- mensaje ok-->

<%if (session.getAttribute("msg")=="1"){%>
		<script>
			swal("Listo!","Ya actualizamos los datos de tu evento!","success","ok");
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
<br>
<br>
<br>

<!--ingreso datos para el alta-->
 			 <center>
				<form class="login100-form validate-form" id="modComp-form" action="complejosCONTROLADOR" method="POST" role="form" style="display: block;">
								    
								    <% complejosMODELO complejosmodelo= (complejosMODELO)request.getAttribute("complejosmodelos");
								    String nombre= "";
								    String ciudad= "";
								    String direccion= "";
								    String foto= "";
								    String observaciones= "";
								    int id = -1;
								    
								    if (complejosmodelo != null) {
										id = complejosmodelo.getID_Comp();
										nombre = complejosmodelo.getNombre_Comp();
										ciudad = complejosmodelo.getCiudad_Comp();
										direccion = complejosmodelo.getDireccion_Comp();
										foto = complejosmodelo.getFoto_Comp();
										observaciones = complejosmodelo.getObservaciones_Comp();
								    }%>
					<br>
					<br>
						
					<span class="login100-form-title p-b-43">
						<strong><u>Actualizar los datos de tu Complejo	</u></strong>
					</span>
						<br>
						<br>
						<br>
						<br>
						<br>
									    
						<input  class="input100" type="hidden" name="id" id="id" value="<%=id %>">
					
					<div class="wrap-input100 validate-input" data-validate = "Por favor Ingrese el nombre">
					<span class="label-input100">Nombre del Complejo</span>
						<input class="input100" type="text" name="Nombre_Comp" id="Nombre_Comp" value="<%=nombre %>">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Por favor Ingrese el lugar">
					<span class="label-input100">Ciudad</span>
						<input class="input100" type="text" name="Ciudad_Comp" id="Ciudad_Comp" value="<%=ciudad %>">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Por favor Ingrese la direccion">
					<span class="label-input100">Direccion</span>
						<input class="input100" type="text" name="Direccion_Comp" id="Direccion_Comp" value="<%=direccion %>">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate="Por favor Ingrese una foto">
					<span class="label-input100">Foto</span>
						<input class="input100" type="text" name="Foto_Comp" id="Foto_Comp" value="<%=foto %>">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Por favor Ingrese una observacion">
					<span class="label-input100">Observaciones</span>
						<input class="input100" type="text" name="Observaciones_Comp" id="Observaciones_Comp" value="<%=observaciones %>">
						<span class="focus-input100"></span>
					</div>
					
					
					
					<br></br>
					
					<div class="container-login100-form-btn">
						<button type="submit" name="action" value="update" id="update-submit" tabindex="4" class="btn btn-outline-primary">Modificar</button>
						<button type="submit" name="action" value="eliminar" id="delete-submit" tabindex="4" class="btn btn-outline-primary">Eliminar</button>					</div>
					
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