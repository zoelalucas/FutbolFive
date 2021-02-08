<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*,modelo.*,java.util.*, java.text.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  


   <!-- Esto es para la tabla dinamica  Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- CSS personalizado --> 
    <link rel="stylesheet" href="main.css">  
      
      
    <!--datables CSS básico-->
    <link rel="stylesheet" type="text/css" href="datatables/datatables.min.css"/>
    <!--datables estilo bootstrap 4 CSS-->  
    <link rel="stylesheet"  type="text/css" href="datatables/DataTables-1.10.18/css/dataTables.bootstrap4.min.css">

 <!-- Fin Esto es para la tabla dinamica  Required meta tags -->

  		  <!-- SweetAlert -->
  <script src='js/sweetalert.min.js'></script>
  <link rel='stylesheet' type='text/css' href='css/sweetalert.css'>
  
  <!--  extension responsive  -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css">
    
  <title>Listar Reservas Jugador</title>

</head>
<body>
	  <!-- mensaje ok-->

<%if (session.getAttribute("msg")=="1"){%>
		<script>
			swal("Listo!","La reserva paso a Estado: Suspendido","success","ok");
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

  <!--/ Nav End /-->
  
    <br>
	<br>
	<br>
	<br>	
	<br>
	<br>	
	
    <!--Ejemplo tabla con DataTables-->
    <div class="container">
        <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">        
                        <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
		<th>Complejo</th>
		<th>Cancha</th>
		<th>Horario</th>
		<th>Dia de reserva</th>
		<th>Dia de partido</th>
		<th>Precio</th>
		<th>Tamaño</th>
		<th>Ciudad</th>
		<th>Direccion</th>
		<th>Observaciones</th>
		<th>Estado</th>
		<th>Opcion</th>
	
                            </tr>
                        </thead>
                        <tbody>
	<%
	
	ArrayList<reservasMODELO> reservasmodelos = (ArrayList<reservasMODELO>)request.getAttribute("reservasmodelos");

	if (reservasmodelos != null)
		
	{
		for (int i=0; i<reservasmodelos.size(); i++){
			reservasMODELO reservasmodelo = reservasmodelos.get(i);
			%>
	    <tr>
	    <td  ><%= reservasmodelo.getNombre_Comp() %></td>
		<td  ><%= reservasmodelo.getNombre_Can() %></td>
		<td  ><%= reservasmodelo.getHorarios_Hor() %></td>
		<td  ><%= reservasmodelo.getDia_Res() %></td>
		<td  ><%= reservasmodelo.getDiaPartido_Res() %></td>
		<td  >$ <%= reservasmodelo.getPrecio_Res() %>.00</td>
		<td  ><%= reservasmodelo.getTamaño_Can() %></td>
		<td  ><%= reservasmodelo.getCiudad_Comp() %></td>
		<td  ><%= reservasmodelo.getDireccion_Comp() %></td>
		<td  ><%= reservasmodelo.getObservaciones_Can() %></td>
		<td  ><%= reservasmodelo.getEstado_Res() %></td>
		<th><a href = "reservasCONTROLADOR?action=eliminarJugRes&id=<%=reservasmodelo.getID_Res()%>
						&idcan=<%=reservasmodelo.getID_Can()%>
						&nombrecomp=<%=reservasmodelo.getNombre_Comp()%>
						&nombrecan=<%=reservasmodelo.getNombre_Can()%>
						&hora=<%=reservasmodelo.getHorarios_Hor()%>
						&dia=<%=reservasmodelo.getDiaPartido_Res()%>
						&precio=<%=reservasmodelo.getPrecio_Res()%>
						&observacion=<%=reservasmodelo.getObservaciones_Can()%>
						&estado=<%=reservasmodelo.getEstado_Res()%>
						&Direccion_Comp=<%=reservasmodelo.getDireccion_Comp()%>
						&tamañocan=<%=reservasmodelo.getTamaño_Can()%>
						&DiaHoy=<%=reservasmodelo.getDia_Res()%>
						&ciudadcomp=<%=reservasmodelo.getCiudad_Comp()%>">Suspender</a></th> 													
	<%}%>
                        </tbody>        
                       </table>                  
                    </div>
                    	<%}%>
                </div>
        </div>  
    </div>    
      
    <!-- jQuery, Popper.js, Bootstrap JS -->
    <script src="jquery/jquery-3.3.1.min.js"></script>
    <script src="popper/popper.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
      
    <!-- datatables JS -->
    <script type="text/javascript" src="datatables/datatables.min.js"></script>    
     
    <script type="text/javascript" src="js/main1.js"></script>  

    <!-- para usar botones en datatables JS -->  
    <script src="datatables/Buttons-1.5.6/js/dataTables.buttons.min.js"></script>  
    <script src="datatables/JSZip-2.5.0/jszip.min.js"></script>    
    <script src="datatables/pdfmake-0.1.36/pdfmake.min.js"></script>    
    <script src="datatables/pdfmake-0.1.36/vfs_fonts.js"></script>
    <script src="datatables/Buttons-1.5.6/js/buttons.html5.min.js"></script>
    <!-- extension responsive -->
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>

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