<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*,modelo.*,java.util.*, java.text.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

	  <!-- SweetAlert -->
  <script src='js/sweetalert.min.js'></script>
  <link rel='stylesheet' type='text/css' href='css/sweetalert.css'>
  
    <!-- Esto es para las ESTRELLAS -->
		<link rel="stylesheet" href="css/styles.css">
		<link rel="stylesheet" href="start/dist/star-rating.css">
		<link rel="stylesheet" href="start/dist/star-rating.min.css">
		  <script src='start/dist/star-rating.min.js'></script>
		  <script src='start/src/star-rating.js'></script>
  
   
    <title>Reserva Jugador</title>
 
</head>



<body id="page-top">
   
<%if (session.getAttribute("Usuario_Usu")== null){ 
		response.sendRedirect("index.jsp");} %><!-- verifica la existencia de inicio de session-->

<!-- mensaje ok-->

<%if (session.getAttribute("msg")=="1"){%>
		<script>
			swal("Listo!","Ya Creaste Tu Reserva!","success","ok");
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

   <!-- mensaje campos vacios-->
<%if (session.getAttribute("msg")=="2"){%>
		<script>
		 swal("Ups!","Hubo un error, Completa el Campo Horario","error","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>	


<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style="background-color: #000000;">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="menuJugador.jsp"><%=(String)session.getAttribute("Usuario_Usu")%></a></p>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="reservasJugAlta.jsp">Realizar Reserva</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="reservasCONTROLADOR?action=ListadoReservaUsuario">Mis Reservas</a>
          </li>
           <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="reservasCONTROLADOR?action=HistorialReservaUsuario">Historial</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="reservasCONTROLADOR?action=CalificarReservaUsuario">Calificar</a>
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
  <br>
 <form class="login100-form validate-form" id="altaEve-form" action="reservasCONTROLADOR" method="POST" role="form" style="display: block;">
<div class="container">
<div class="row">
<div class="col-xs-6">

<div class="card">	
	<center>
	<h5 class="card-title"><u>Busca tu cancha aca ! </u></h5>


						<!-- List Box Zona -->
					
						<div class="form-group form-group-lg">
					        <label class="col-sm-8 control-label" for="lg" for="cboCategoriaProducto">Zona</label>
					        <div class="col-sm-8">   
					            
					        <select class="form-control" id="Zona" name="Ciudad_Comp">
					        <option> Rosario </option>
					        <option> Funes </option>
					        <option> Roldan </option>
					        <option> Fisherton </option>
					        <option> Ibarlucea </option>
					        
					        </select>
					        
					        </div>
					    </div>
					    
					<!-- finish List Box Zona -->
					
						<!-- List Box tamaño -->
					
						<div class="form-group form-group-lg">
					        <label class="col-sm-8 control-label" for="lg" for="cboCategoriaProducto">Tamaño</label>
					        <div class="col-sm-8">   
					            
					        <select class="form-control" id="Zona" name="Tamaño_Can">
					        
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
					
	
	<input type="text" name="Horarios_Hor" id="DesdeF1_Hor" width="200" placeholder="Horario"/>
		<script>
			 $('#DesdeF1_Hor').timepicker();
	 	</script>
	 	
	
		<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>				    
	
					<main class="container">
				    <div class="row" style="padding-top: 30px">
				        <div class="col">Fecha: 
				            <input data-date-format="yyyy/mm/dd"  id="datepicker" onchange="myFunction(this.value);" name="DiaPartido_Res" >
				        </div>
				    </div>
				</main>
				 	
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
				<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
				<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
				<script type="text/javascript">
			
			    $('#datepicker').datepicker({
					
			        weekStart: 1,
			        autoclose: true,
			        todayHighlight: true,
			        startDate: new Date(),
			   	    endDate: '+6d'  	 	
			    });
			
			    $('#datepicker').datepicker("setDate", new Date());
			    
			</script> 
	</center>
		
	<br>
	
		<div class="wrap-login100-form-btn"> 
			<div class="login100-form-bgbtn" ></div>
			<button class="login100-form-btn" value="BuscarParaReservar" name="action" type="submit">
				Buscar
			</button>
		</div>
	

 </div>
</div>




<br>
<br>
<br>

<div class="col" >
<div class="float-right">
<div class="card-group">
	<%
	
	ArrayList<reservasMODELO> reservasmodelos = (ArrayList<reservasMODELO>)request.getAttribute("reservasmodelos");
	if (reservasmodelos != null)
		
	{
		for (int i=0; i<reservasmodelos.size(); i++){
			reservasMODELO reservasmodelo = reservasmodelos.get(i);
			%>	    

 
<!-- Card -->

<div class="card">

  <!-- Card image -->
  <div class="card-body">
    <img src="<%= reservasmodelo.getFoto_Comp() %>" width="100%" height="100%">
  </div>

  <!-- Card content -->
  <div class="card-body">

    <!-- Title -->
    <h4 class="card-title font-weight-bold"><a><%= reservasmodelo.getNombre_Comp() %></a></h4>
    <!-- Data -->
   <%
 
int calificacion = reservasmodelo.getPromedio_Comp();
			switch (calificacion) {
			  case 1:
				%><td>
				<div>
					<select id="glsr-custom-options" class="star-rating" data-options='{"clearable":false, "showText":true}' disabled>
						<option name="Calificacion_Res" value="<%= calificacion %>"  selected>1</option>
					</select>
				</div>
				</td>
				<%
			    break;
			  case 2:
					%><td>
				<div>
					<select id="glsr-custom-options" class="star-rating" data-options='{"clearable":false, "showText":true}' disabled>
						<option value="5">5</option>
						<option value="4">4</option>
						<option value="3">3</option>
						<option name="Calificacion_Res" value="<%= calificacion %>"  selected>2</option>
						<option value="1">1</option>
					</select>
				</div>
					</td>
					<%
				    break;
			  case 3:
					%><td>
				<div>
					<select id="glsr-custom-options" class="star-rating" data-options='{"clearable":false, "showText":true}' disabled>
						<option value="5">5</option>
						<option value="4">4</option>
						<option name="Calificacion_Res" value="<%= calificacion %>"  selected>3</option>
						<option value="2">2</option>
						<option value="1">1</option>
					</select>
				</div>
					</td>
					<%
				    break;
			  case 4:
					%><td>
				<div>
					<select id="glsr-custom-options" class="star-rating" data-options='{"clearable":false, "showText":true}' disabled>
						<option value="5">5</option>
						<option name="Calificacion_Res" value="<%= calificacion %>"  selected>4</option>
						<option value="3">3</option>
						<option value="2">2</option>
						<option value="1">1</option>
					</select>
				</div>
					</td>
					<%
				    break;	
					
			  case 5:
					%>
					<td>
				<div>
					<select id="glsr-custom-options" class="star-rating" data-options='{"clearable":false, "showText":true}' disabled>
						<option name="Calificacion_Res" value="<%= calificacion %>"  selected>5</option>
						<option value="4">4</option>
						<option value="3">3</option>
						<option value="2">2</option>
						<option value="1">1</option>
					</select>
				</div>
					</td>
					<%
				    break;		
			}%>

    <p class="mb-2"><%= reservasmodelo.getNombre_Can() %></p>
    <!-- Text -->
    <p class="card-text">Direccion: <%= reservasmodelo.getCiudad_Comp()%>, <%= reservasmodelo.getDireccion_Comp() %></p>
    <p class="card-text">Tamaño: <%= reservasmodelo.getTamaño_Can() %></p>
    <p class="card-text">Precio: $<%= reservasmodelo.getPrecio_Can() %></p>
    <p class="card-text">Horario: <%= reservasmodelo.getHorarios_Hor() %></p>
    <p class="card-text">Observaciones: <%= reservasmodelo.getObservaciones_Can() %></p>
    
        <input class="input100" type="hidden" name="Nombre_Comp" id="Nombre_Comp" value="<%= reservasmodelo.getNombre_Comp() %>" >
        <input class="input100" type="hidden" name="Nombre_Can" id="Nombre_Can" value="<%= reservasmodelo.getNombre_Can() %>" >
        <input class="input100" type="hidden" name="Direccion_Comp" id="Direccion_Comp" value="<%= reservasmodelo.getDireccion_Comp() %>" >
        <input class="input100" type="hidden" name="Horarios_Hor" id="Horarios_Hor" value="<%= reservasmodelo.getHorarios_Hor() %>" >
        <input class="input100" type="hidden" name="ID_Comp" id="ID_Comp" value="<%= reservasmodelo.getID_Comp() %>" >
    
    
    
    <input class="input100" type="hidden" name="Precio_Can" id="Precio_Can" value="<%= reservasmodelo.getPrecio_Can() %>" >
    <input class="input100" type="hidden" name="ID_Can" id="ID_Can" value="<%= reservasmodelo.getID_Can() %>" >
    <input class="input100" type="hidden" name="ID_Hor" id="ID_Hor" value="<%= reservasmodelo.getID_Hor() %>" >
    <hr class="my-4"> 	
    <!-- Button -->
		<div class="wrap-login100-form-btn"> 
			<div class="login100-form-bgbtn" ></div>
			<button class="login100-form-btn" value="createjg" name="action" type="submit">
				Reservar
			</button>
		</div>
  </div>
</div>

<!-- Card -->
	<%}%>
  	</div>
<%}%>


</div>
</div>
</div>
</div>
</form>
  
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
	
	<!-- Para las estrellas -->
		<script src="src/star-rating.js?ver=3.2.0"></script>
	<script>
		var destroyed = false;
		var starratings = new StarRating( '.star-rating', {
			onClick: function( el ) {
				console.log( 'Selected: ' + el[el.selectedIndex].text );
			},
		});
		document.querySelector( '.toggle-star-rating' ).addEventListener( 'click', function() {
			if( !destroyed ) {
				starratings.destroy();
				destroyed = true;
			}
			else {
				starratings.rebuild();
				destroyed = false;
			}
		});
	</script>
	
</body>

</html>