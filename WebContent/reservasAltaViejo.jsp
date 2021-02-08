<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*,modelo.*,java.util.*, java.text.*"%>
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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/bootstrap.min.js" ></script>



      
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Reservas</title>

</head>
<body>
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
		
   <!-- mensaje error-->
<%if (session.getAttribute("msg")=="2"){%>
		<script>
		 swal("Ups!","Faltan completar datos, volve a intentarlo","error","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>	

<%
String nomcan="";
String precan="";
String horarioshor="";



	 nomcan = (String) session.getAttribute("nomcan");
	 precan = (String) session.getAttribute("precan");
	 horarioshor = (String) session.getAttribute("horarioshor");




	if (nomcan == null){ 
		
		nomcan = "Seleccionar Cancha";		
		precan = "Precio";
	}
	if(horarioshor == null){
		horarioshor= "Seleccionar Horario";
	}
 
  %>
		
		
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
            <a class="nav-link js-scroll-trigger" href="reservasCONTROLADOR?action=ListadoCanchas">Crear Reserva</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="reservasCONTROLADOR?action=ListadoReservas">Listar/Modificar Reservas</a>	
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="reservasCONTROLADOR?action=HistorialReservas">Historial Reservas</a>
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
	
<div class="container">
<div class="row">
<div class="col-xs-6">
<div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne" >
          Seleccionar Cancha
        </button>
      </h5>
    </div>

    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">

			 <!--/ Listado de canchas por complejo /-->
			      
				<%
				ArrayList<canchasMODELO> canchasmodelos = (ArrayList<canchasMODELO>)request.getAttribute("canchasmodelos");
			
				if (canchasmodelos != null)
				{%>
				  <div class="container">
			  <table class="table table-dark table-striped table-bordered">
			    <thead>
			      <tr>
			        <th>Complejo </th>
					<th>Cancha </th>
					<th>Tamaño		   </th>
					<th>Precio      </th>
					<th>Observaciones  </th>
					<th>Estado		   </th>
					<th>Opcion 1       </th>
			      </tr>
			    </thead>
			 <tbody>
				
					<% for (int i=0; i<canchasmodelos.size(); i++){
						canchasMODELO canchasmodelo = canchasmodelos.get(i);
						%>
				    <tr>	
				    <td  ><%= canchasmodelo.getNombre_Comp() %></td>
					<td  ><%= canchasmodelo.getNombre_Can() %></td>
					<td  ><%= canchasmodelo.getTamaño_Can() %></td>
					<td  ><%= canchasmodelo.getPrecio_Can() %></td>		
					<td  ><%= canchasmodelo.getObservaciones_Can() %></td>
					<td  ><%= canchasmodelo.getEstado_Can() %></td>   
					<th><a  href = "reservasCONTROLADOR?action=select&id=<%=canchasmodelo.getID_Comp()%>&idcan=<%=canchasmodelo.getID_Can()%>&nomcan=<%=canchasmodelo.getNombre_Can()%>&precan=<%=canchasmodelo.getPrecio_Can()%>"> Elegir Cancha </a></th> 
				<%}%>
			    </tbody>
			  </table>
			</div>
								    
			 <%} %>
			 

      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h5 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Seleccionar Horario
        </button>
      </h5>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
					 <!--/ Listado de horarios por complejo /-->
				<%
				ArrayList<complejosMODELO> complejosmodelos1 = (ArrayList<complejosMODELO>)request.getAttribute("complejosmodelos1");
				if (complejosmodelos1 != null){
				%>
			  <div class="container">
			  <table class="table table-dark table-striped table-bordered">
			    <thead>
			      <tr>
					<th>Horarios </th>
					<th>Opcion   </th>
			      </tr>
			    </thead>
			 <tbody>
			      
				<%
			
					for (int i=0; i<complejosmodelos1.size(); i++){
						complejosMODELO complejosmodelo = complejosmodelos1.get(i);
						%>
				    <tr>
				    
				   <td  ><%= complejosmodelo.getHorarios_Hor() %></td> 
				   <th> <a href = "reservasCONTROLADOR?action=selectdia&id=<%=complejosmodelo.getID_Comp()%>&idhorario=<%=complejosmodelo.getID_Hor()%>&horarioshor=<%=complejosmodelo.getHorarios_Hor()%>"> Elegir Horario</a></th> 
				   
				<%}%>
			    </tbody>
			  </table>
			</div>
				<%}%>
			 
    </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingThree">
      <h5 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Seleccionar Dia
        </button>
      </h5>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
      <div class="card-body">
				<!--/ Listado de dias por complejo /-->
				
				     	<%
					ArrayList<complejosMODELO> complejosmodelos = (ArrayList<complejosMODELO>)request.getAttribute("complejosmodelos");
					if (complejosmodelos != null)
				{
						//Inicializo VARS
						String Lunes="1";
						String Martes="2";
						String Miercoles="3";
						String Jueves="4";
						String Viernes="5";
						String Sabado="6";
						String Domingo="0";
						
						//Recorro Array de dias a bloquear	
						for (int i=0; i<complejosmodelos.size(); i++){
							complejosMODELO complejosmodelo = complejosmodelos.get(i);
							String dia=complejosmodelo.getHorarios_Hor();
							//Verifico q dias tengo q bloquear
							if (dia.equals("1")){
								Lunes="";
							}
							if (dia.equals("2")){
								Martes="";
							}
							if (dia.equals("3")){
								Miercoles="";
							}
							if (dia.equals("4")){
								Jueves="";
							}
							if (dia.equals("5")){
								Viernes="";
							}
							if (dia.equals("6")){
								Sabado="";
							}
							if (dia.equals("0")){
								Domingo="";
							}
				
						}%>
				            <input class="input100" type="hidden" name="Lunes" id="Lunes" value="<%=Lunes%>">
				            <input class="input100" type="hidden" name="Martes" id="Martes" value="<%=Martes%>">
				            <input class="input100" type="hidden" name="Miercoles" id="Miercoles" value="<%=Miercoles%>">
				            <input class="input100" type="hidden" name="Jueves" id="Jueves" value="<%=Jueves%>">
				            <input class="input100" type="hidden" name="Viernes" id="Viernes" value="<%=Viernes%>">
				            <input class="input100" type="hidden" name="Sabado" id="Sabado" value="<%=Sabado%>">
				            <input class="input100" type="hidden" name="Domingo" id="Domingo" value="<%=Domingo%>">
				
			  
				    
				    
				   
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>				    

				<main class="container">
				    <div class="row" style="padding-top: 100px">
				        <div class="col">Fecha: 
				            <input data-date-format="yyyy/mm/dd"  id="datepicker" onchange="myFunction(this.value);" >
				        </div>
				    </div>
				</main>

				
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
				<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
				<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
				<script type="text/javascript">
				
				var lun = document.getElementsByName('Lunes')[0].value;
				var mar = document.getElementsByName('Martes')[0].value;
				var mie = document.getElementsByName('Miercoles')[0].value;
				var jue = document.getElementsByName('Jueves')[0].value;
				var vie = document.getElementsByName('Viernes')[0].value;
				var sab = document.getElementsByName('Sabado')[0].value;
				var dom = document.getElementsByName('Domingo')[0].value;
				
				    $('#datepicker').datepicker({
				
				        weekStart: 1,
				        autoclose: true,
				        todayHighlight: true,
				        startDate: new Date(),
				   	    endDate: '+7d'  ,
				 		daysOfWeekDisabled: [lun,mar,mie,jue,vie,sab,dom]	 	
				    });
				
				    $('#datepicker').datepicker("setDate", new Date());
				    
				</script>            
				<%}%>
      </div>
    </div>
  </div>
</div>
    </div>
    
    
    <div class="col" >
    	<div class="float-right">
    	
    	

    
    
	<form id="login-form" action="reservasCONTROLADOR" method="POST" role="form" style="display: block;">
	<center>
	<input class="input100" type="hidden" placeholder="id de la Cancha" name="ID_Can" id="ID_Can" value="<%=(String)session.getAttribute("idcan")%>" >
	<input class="input100" type="hidden" placeholder="id de la dia" name="ID_Dia" id="ID_Dia" value="<%=(String)session.getAttribute("iddia")%>" >
	<input class="input100" type="hidden" placeholder="id de horario" name="ID_Hor" id="ID_Hor" value="<%=(String)session.getAttribute("idhorario")%>" >
	
		
	<h5 class="card-title"><u>Informacion De Reserva</u></h5>

	
	<input class="input100" type="text" placeholder="Cancha" name="Nombre_Can" id="Nombre_Can" readonly  value="<%=nomcan%>" >
	<input class="input100" type="text" placeholder="Precio" name="Precio_Can" id="Precio_Can" readonly value="<%=precan%>">
	<input class="input100" type="text" placeholder="Horario" name="Horarios_Hor" id="Horarios_Hor" readonly value="<%=horarioshor%>">
	<input class="input100" type="text" placeholder="Dia" name="DiaPartido_Res" id="myText" readonly value="Selecciona el Dia">
	<input class="input100" type="text" placeholder="Ingresar Observaciones" name="Observaciones_Res" id="Observaciones_Res">


<!-- script para hacer el efecto onechange: al elegir la fecha de la reserva en el datepicker me agrega la misma fecha al text con id= "myText" -->
<script type="text/javascript">
function myFunction(element) {
  document.getElementById("myText").value = element;
}
</script>
<!-- fin script -->	
	
	</center>
		<div class="wrap-login100-form-btn">
		<div class="login100-form-bgbtn"></div>
		<button class="login100-form-btn" value="create" name="action">
			Reservar
		</button>
		</div>
	</form>
    </div>
    </div>
  </div>
</div>

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