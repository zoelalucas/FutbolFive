<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Prode 2020</title>

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

 		  <!-- SweetAlert -->
  <script src='js/sweetalert.min.js'></script>
  <link rel='stylesheet' type='text/css' href='css/sweetalert.css'>
  
    <!-- Load font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  
</head>

<body id="page-top">
<!-- mensaje-->
<input type="hidden"name="Mensaje" id="Mensaje" value="<%=(String)request.getAttribute("Message")%>" >
<script type="text/javascript">
var mens = document.getElementById("Mensaje").value;
</script>

<!-- mensaje OK-->
<%if (session.getAttribute("msg")=="1"){%>
		<script>
			swal("Listo!",mens,"success","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>

<!-- mensaje Error-->

<%if (session.getAttribute("msg")=="2"){%>
		<script>
			swal("Ups!",mens,"error","ok");
		</script>
	<%session.setAttribute("msg", "null");%>	 
<%}%>
<!-- Fin mensaje-->
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">Futbol Five</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#services">Presentación</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#about">Proyecto</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#portfolio">Canchas</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#Sponsor">Sponsor</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#contact">Contacto</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="login.jsp">Ingresar</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Header -->
  <header class="masthead">
    <div class="container">
      <div class="intro-text">
        <div class="intro-lead-in">Una forma distinta de vivir el fútbol</div>
        <div class="intro-heading text-uppercase">Futbol Five</div>
      </div>
    </div>
  </header>

  <!-- Services -->
  <section class="bg-light page-section" id="services" style="back style="background-color:#D9D9D9" >
      <div align=center class="container">		
		<div class="embed-responsive embed-responsive-16by9">
			<video class="embed-responsive-item" allowfullscreen controls> //autoplay//
    			<source src="img/Futbol1.mp4" type="video/mp4">
			</video>
		</div>
    </div>
  </section>

<!-- About -->
  <section class="page-section" id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Futbol Five</h2>
          <h3 class="section-subheading text-muted">Los inicios de un proyecto</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <ul class="timeline">
            <li>
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="img/about/1.png" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>Complejos</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">En nuestra página muchos complejos se han registrado a fin de poder brindar un servicio mas eficiente a todos los jugadores</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="img/about/2.png" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>Jugadores</h4>
                 </div>
                <div class="timeline-body">
                  <p class="text-muted">Nuestros usuarios siempre tienen una inmediata respuesta de los complejos y así organizar sus eventos de manera rápida y eficiente</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
                <h4>Registrate
                  <br>Anotate
                  <br>Juga!</h4>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>


  <!-- Portfolio Grid -->
  <section class="bg-light page-section" id="portfolio">
    <div class="container">
      <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Canchas</h2>
          <h3 class="section-subheading text-muted">Podés encontrar la cancha que estabas buscando</h3>
        </div>
      </div>
      <div class="row text-center">
        <div class="col-md-4">
          <img src="img/Servicios/map.png"> 
          <h4 class="service-heading">Por zona</h4>
          <p class="text-muted">Nuestro sistema de búsqueda te permite buscar canchas de fútbol tanto en rosario como en las ciudades del alrededor</p>
        </div>
        <div class="col-md-4">
          <img src="img/Servicios/hora.png">
          <h4 class="service-heading">Por horario</h4>
          <p class="text-muted">Podés limitar la búsqueda por los horarios deseados para tus partidos</p>
        </div>
        <div class="col-md-4">
          <img src="img/Servicios/online.png">
          <h4 class="service-heading">Reserva on-line</h4>
          <p class="text-muted">Luego de elegir la cancha deseada podrás reservarla inmediatamente sin necesidad de ir hasta la cancha ni realizar llamadas teléfonicas</p>
        </div>
    </div>
  </section>

  
	<!-- Publicidades -->
  <section class="py-5" id="Sponsor">
    <div class="container">
      <div class="row">
        <div class="col-md-3 col-sm-6">
          <a href="http://www.rosario.gob.ar/">
            <img class="img-fluid d-block mx-auto" src="img/logos/envato.jpeg" alt="">
          </a>
        </div>
        <div class="col-md-3 col-sm-6">
          <a href="http://www.coca-cola.com.ar/">
            <img class="img-fluid d-block mx-auto" src="img/logos/designmodo.jpeg" alt="">
          </a>
        </div>
        <div class="col-md-3 col-sm-6">
          <a href="http://www.ucel.edu.ar/">
            <img class="img-fluid d-block mx-auto" src="img/logos/themeforest.jpeg" alt="">
          </a>
        </div>
        <div class="col-md-3 col-sm-6">
          <a href="http://www.mcdonalds.com.ar/">
            <img class="img-fluid d-block mx-auto" src="img/logos/creative-market.jpeg" alt="">
          </a>
        </div>
      </div>
    </div>
  </section>
  
  <form action="EmailSendingServlet" method="POST">
  
  <td><input type="hidden" value="futbolfiverosario@gmail.com" name="recipient" size="50"/></td>
  
<!-- Contact -->
  <section class="page-section" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Contactanos</h2>
          <h3 class="section-subheading text-muted">Escribinos tus consultas y te contactaremos a la brevedad</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <form id="contactForm" name="sentMessage" novalidate="novalidate">
            <div class="row">	
              <div class="col-md-6">
                <div class="form-group">
                  <input class="form-control" id="name" type="text"  name="nombreapeliido" placeholder="Nombre y Apellido *" required="required" data-validation-required-message="Ingresa tu Nombre y Apellido.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="email" type="email" name="remitente" placeholder="Direccion de Correo *" required="required" data-validation-required-message="Ingresa tu Correo Electronico.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="phone" type="tel"   name="telefono" placeholder="Telefono *" required="required" data-validation-required-message="Ingresa tu Numero de Telefono.">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <input class="form-control" id="name" type="hidden" name="subject" value="Consulta Desde El Index" placeholder="Asunto *" required="required" data-validation-required-message="Ingresa el Asunto.">
                  <textarea class="form-control" id="message" name="content"placeholder="Mensaje *" required="required" data-validation-required-message="Ingresa tu Mensaje."></textarea>
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="clearfix"></div>
              <div class="col-lg-12 text-center">
                <div id="success"></div>
              <input type="submit" value="Enviar"  name="action" class="btn btn-primary btn-xl text-uppercase"/>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</form>
  
  

<!-- The social media icon bar -->
<div class="icon-bar">
  <a href="http://www.fb.com/" class="facebook"><i class="fa fa-facebook"></i></a>
  <a href="http://www.twitter.com/" class="twitter"><i class="fa fa-twitter"></i></a>
  <a href="http://www.google.com/" class="google"><i class="fa fa-google"></i></a>
   <a href="http://www.youtube.com.ar/" class="youtube"><i class="fa fa-youtube"></i></a>
</div>

<!-- Footer -->
<footer class="page-footer font-small special-color-dark pt-4">

  <!-- Footer Elements -->
  <div class="container">

    <!-- Social buttons -->
    <ul class="list-unstyled list-inline text-center">
      <li class="list-inline-item">
        <a class="btn-floating btn-fb mx-1">
          <i class="fab fa-facebook-f"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-tw mx-1">
          <i class="fab fa-twitter"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-gplus mx-1">
          <i class="fab fa-google-plus-g"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-li mx-1">
          <i class="fab fa-linkedin-in"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-dribbble mx-1">
          <i class="fab fa-dribbble"> </i>
        </a>
      </li>
    </ul>
    <!-- Social buttons -->

  </div>
  
<!-- Footer Elements -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    <a href="http://localhost:8084/FutbolFive/index.jsp"> FutbolFive.com</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
    
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact form JavaScript -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/agency.min.js"></script>

</body>

</html>
