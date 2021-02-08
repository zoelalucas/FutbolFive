package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.canchasDAO;
import dao.reservasDAO;
import modelo.canchasMODELO;
import modelo.complejosMODELO;
import modelo.reservasMODELO;
import dao.EmailUtility;
/**
 * Servlet implementation class reservasCONTROLADOR
 */
public class reservasCONTROLADOR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservasCONTROLADOR() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reservasDAO reservas = reservasDAO.getInstace();
    	canchasDAO canchas = canchasDAO.getInstace();
    	String action = request.getParameter("action");
    	HttpSession sesion = request.getSession(true);
    	String idusestr = (String) sesion.getAttribute("ID_Usu");
    	String idstr = request.getParameter("id");
    	String idcanc = request.getParameter("idcan"); 
    	
    	String idcancancha = (String) request.getParameter("idcan"); 

    	String iddia = request.getParameter("iddia"); 
    	String idhorario = request.getParameter("idhorario"); 
    	String nomcanc = request.getParameter("nomcan");
    	String preanc = request.getParameter("precan");
    	String horarioshora = request.getParameter("horarioshor");

    	String nombcan   = (String)request.getParameter("nombrecan");
    	String nombcomp   = (String)request.getParameter("nombrecomp");
    	String horares   = (String)request.getParameter("hora");
    	String diares   = (String)request.getParameter("dia");
    	String preciores   = (String)request.getParameter("precio");
    	String obsres   = (String)request.getParameter("observacion");
    	String ciudadcomp   = (String)request.getParameter("ciudadcomp");
    	String Direccion_Comp   = (String)request.getParameter("Direccion_Comp");
    	String tamañocan   = (String)request.getParameter("tamañocan");
    	String DiaHoy   = (String)request.getParameter("DiaHoy");
    	
    	
    	if ("listar".equals(action)) {
			int ID_Usu = Integer.parseInt(idusestr);
			ArrayList<complejosMODELO> complejosmodelos = reservas.findAll(ID_Usu);
			request.setAttribute("complejosmodelos", complejosmodelos);
			String nextJSP = "/reservasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }	
		
    	if ("ListCanPorComp".equals(action)) {
    		int idcomplejo = reservas.BuscarIdComplejo();//espero el id complejo
			ArrayList<canchasMODELO> canchasmodelos = reservas.ListCanPorComp(idcomplejo);
			request.setAttribute("canchasmodelos", canchasmodelos);
			String nextJSP = "/reservasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }


    	if ("ListadoCanchas".equals(action)) {
			int ID_Usu = Integer.parseInt(idusestr);
			ArrayList<reservasMODELO> reservasmodelos1 = reservas.ListadoComplejos(ID_Usu);
			request.setAttribute("reservasmodelos1", reservasmodelos1);
			String nextJSP = "/reservasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }
    	
    	
   	 if ("select".equals(action)) {
			if (idstr != null) {
				int id = Integer.parseInt(idstr);
				sesion.setAttribute("idcan",idcanc);
				sesion.setAttribute("nomcan",nomcanc);
				sesion.setAttribute("precan",preanc);
				ArrayList<complejosMODELO> complejosmodelos1 = reservas.findById2(id);
				request.setAttribute("complejosmodelos1", complejosmodelos1);
				String nextJSP = "/reservasAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
			}
  	}
    	
    	
    	
    	 if ("selectdia".equals(action)) {
			if (idstr != null) {
				int id = Integer.parseInt(idstr);
				sesion.setAttribute("idhorario",idhorario);
				sesion.setAttribute("horarioshor",horarioshora);
				ArrayList<complejosMODELO> complejosmodelos = reservas.findById(id);
				request.setAttribute("complejosmodelos", complejosmodelos);
				String nextJSP = "/reservasAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
			}
    	}
			
    	   	if ("ListadoReservas".equals(action)) {
    			int ID_Usu = Integer.parseInt(idusestr);
    			ArrayList<reservasMODELO> reservasmodelos = reservas.ListadoReservas(ID_Usu);
    			request.setAttribute("reservasmodelos", reservasmodelos);
    			String nextJSP = "/reservasListado.jsp";
    			RequestDispatcher dispatcher = getServletContext()
    					.getRequestDispatcher(nextJSP);
    			dispatcher.forward(request, response);
        }
    	   	
    	   	if ("HistorialReservas".equals(action)) {
    	   		int ID_Usu = Integer.parseInt(idusestr);
    			ArrayList<reservasMODELO> reservasmodelos = reservas.HistorialReservas(ID_Usu);
    			request.setAttribute("reservasmodelos", reservasmodelos);
    			
				if ("1".equals(idusestr)){
					
					String nextJSP = "/reportesResAdmin.jsp";
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
					
					}
				else{
					
    			String nextJSP = "/reservasHistorial.jsp";
    			RequestDispatcher dispatcher = getServletContext()
    					.getRequestDispatcher(nextJSP);
    			dispatcher.forward(request, response);
					}
    	   	}

    	   	
    	   	if ("ListadoReservaUsuario".equals(action)) {
    			int ID_Usu = Integer.parseInt(idusestr);
    			ArrayList<reservasMODELO> reservasmodelos = reservas.ListadoReservaUsuario(ID_Usu);
    			request.setAttribute("reservasmodelos", reservasmodelos);
    			String nextJSP = "/reservasJugListado.jsp";
    			RequestDispatcher dispatcher = getServletContext()
    					.getRequestDispatcher(nextJSP);
    			dispatcher.forward(request, response);
        }
    	   	if ("HistorialReservaUsuario".equals(action)) {
    			int ID_Usu = Integer.parseInt(idusestr);
    			ArrayList<reservasMODELO> reservasmodelos = reservas.HistorialReservaUsuario(ID_Usu);
    			request.setAttribute("reservasmodelos", reservasmodelos);
    			String nextJSP = "/reservasJugHistorial.jsp";
    			RequestDispatcher dispatcher = getServletContext()
    					.getRequestDispatcher(nextJSP);
    			dispatcher.forward(request, response);
        }	
    	   	
    	   	if ("CalificarReservaUsuario".equals(action)) {
    			int ID_Usu = Integer.parseInt(idusestr);
    			ArrayList<reservasMODELO> reservasmodelos = reservas.ReservaFinalizadaUsuario(ID_Usu);
    			request.setAttribute("reservasmodelos", reservasmodelos);
    			String nextJSP = "/reservasJugCalif.jsp";
    			RequestDispatcher dispatcher = getServletContext()
    					.getRequestDispatcher(nextJSP);
    			dispatcher.forward(request, response);
        }	
    	   	
    	   	
    		
    	   	if ("eliminar".equals(action)) {
    	   		if (idstr != null) {
    	   			int idr = Integer.parseInt(idstr);
    	   			Object result=reservas.EliminarReserva(idr);
    	   			
    	   			if(result==null){
    	   			//inicio correo al jugador
    					String correojug = reservas.BuscarCorreoUsuRes(idr);//Envio el ID_Usu para que me busque el correo y lo traiga.

    					
    					String recipient = (correojug);
    					String subject = ("Atencion! El complejo dio de baja su reserva");
    					String content = ("Informacion de la reserva: ");
    					String estadores = "Suspendio";

    					String host = "smtp.gmail.com";
    					String port = "587";
    					String user = "futbolfiverosario@gmail.com";
    					String pass = "proyecto2020";
    					
    					String cuerpo = new String(content+"\n"
    													  +"\nComplejo: "+nombcomp
    													  +"\nDireccion: "+ciudadcomp+", "+Direccion_Comp
    													  +"\nCancha: "+nombcan
    													  +"\nTamaño: "+tamañocan
    													  +"\nPrecio: "+"$"+preciores+".00"
    													  +"\nReservo el dia: "+DiaHoy
    													  +"\nDia del partido: "+diares
    													  +"\nHorario del partido: "+horares+"HS"
    													  +"\nObservaciones: "+obsres
    													  +"\nEstado: "+estadores
    												);
    					

    						try {
    							EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
    									cuerpo);
    						} catch (AddressException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						} catch (MessagingException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    			//Fin correo jugador
    	   				sesion.setAttribute("msg", "1");
    	   			}else{
    	   				sesion.setAttribute("msg", "0");
    	   			}
    	   			String nextJSP = "/reservasListado.jsp";
    	   			RequestDispatcher dispatcher = getServletContext()
    	   			.getRequestDispatcher(nextJSP);
    	   			dispatcher.forward(request, response);
    	   		}


    	   		}
    	   	
    	   	if ("eliminarJugRes".equals(action)) {
    	   		if (idstr != null) {
    	   			int idr = Integer.parseInt(idstr);
    	   			Object result=reservas.EliminarReserva(idr);
    	   			int idcancha = Integer.parseInt(idcancancha);
    	   			if(result==null){
        	   			//inicio correo al complejo
    					String correojug = reservas.BuscarCorreoDueRes(idcancha);//Envio el ID_Usu para que me busque el correo y lo traiga.

    					
    					String recipient = (correojug);
    					String subject = ("Atencion! El Usuario dio de baja su reserva");
    					String content = ("Informacion de la reserva: ");
    					String estadores = "Suspendio";

    					String host = "smtp.gmail.com";
    					String port = "587";
    					String user = "futbolfiverosario@gmail.com";
    					String pass = "proyecto2020";
    					
    					

    			    	
    					String cuerpo = new String(content+"\n"
    													  +"\nComplejo: "+nombcomp
    													  +"\nDireccion: "+ciudadcomp+", "+Direccion_Comp
    													  +"\nCancha: "+nombcan
    													  +"\nTamaño: "+tamañocan
    													  +"\nPrecio: "+"$"+preciores+".00"
    													  +"\nReservo el dia: "+DiaHoy
    													  +"\nDia del partido: "+diares
    													  +"\nHorario del partido: "+horares+"HS"
    													  +"\nObservaciones: "+obsres
    													  +"\nEstado: "+estadores
    												);
    					

    						try {
    							EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
    									cuerpo);
    						} catch (AddressException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						} catch (MessagingException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    			//Fin correo complejo
    	   				sesion.setAttribute("msg", "1");
    	   			}else{
    	   				sesion.setAttribute("msg", "0");
    	   			}
    	   			String nextJSP = "/reservasJugListado.jsp";
    	   			RequestDispatcher dispatcher = getServletContext()
    	   			.getRequestDispatcher(nextJSP);
    	   			dispatcher.forward(request, response);
    	   		}


    }
    	   	 	
       
    	   	
    	   	if ("RecordatorioReservasPorJugar".equals(action)) {
    	   		if (idusestr != null) {
    	   			ArrayList<reservasMODELO> reservasmodelos = reservas.BuscarReservasPorJugar1();
        			request.setAttribute("reservasmodelos", reservasmodelos);
        			
    	   				for (int i=0; i<reservasmodelos.size(); i++){
    	   					reservasMODELO reservasmodelo = reservasmodelos.get(i);
    	   					
        	   			//inicio correo al complejo
    					
    					String recipient = (reservasmodelo.getCorreo_Usu());
    					String subject = ("Hola "+reservasmodelo.getUsuario_Usu()+ "!"+ " Te recordamos que tenes una reserva mañana");
    					String content = ("Informacion de la reserva: ");

    					String host = "smtp.gmail.com";
    					String port = "587";
    					String user = "futbolfiverosario@gmail.com";
    					String pass = "proyecto2020";
    					
    					

    			    	
    					String cuerpo = new String(content+"\n"
    													  +"\nComplejo: "+(reservasmodelo.getNombre_Comp())
    													  +"\nDireccion: "+reservasmodelo.getCiudad_Comp()+", "+reservasmodelo.getDireccion_Comp()
    													  +"\nCancha: "+reservasmodelo.getNombre_Can()
    													  +"\nTamaño: "+reservasmodelo.getTamaño_Can()
    													  +"\nPrecio: "+"$"+reservasmodelo.getPrecio_Res()+".00"
    													  +"\nReservo el dia: "+reservasmodelo.getDia_Res()
    													  +"\nDia del partido: "+reservasmodelo.getDiaPartido_Res()
    													  +"\nHorario del partido: "+reservasmodelo.getHorarios_Hor()+"HS"
    													  +"\nObservaciones: "+reservasmodelo.getObservaciones_Can()
    													  +"\nEstado: "+reservasmodelo.getEstado_Res()
    												);
    					
    	   				
    						try {
    							EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
    									cuerpo);
    						} catch (AddressException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						} catch (MessagingException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    	   				}
    			//Fin correo complejo
    	   				sesion.setAttribute("msg", "2");
    	   				}else{
    	   				sesion.setAttribute("msg", "0");
    	   			}
    	   			String nextJSP = "/menuAdmin.jsp";
    	   			RequestDispatcher dispatcher = getServletContext()
    	   			.getRequestDispatcher(nextJSP);
    	   			dispatcher.forward(request, response);
    	   		}
    	   		

    	   		
 
}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);		
		reservasDAO reserva = reservasDAO.getInstace();
		
		String id        = (String)sesion.getAttribute("ID_Usu"); 
		String idRes     = (String)request.getParameter ("ID_Res");
		String estrella  = (String)request.getParameter ("Calificacion_Res");
		String nomUsu        = (String)sesion.getAttribute("Usuario_Usu"); 
		String nivelUsu        = (String)sesion.getAttribute("Nivel_Usu");
		String iddia     = (String)request.getParameter("ID_Dia");
		String idhor     = (String)request.getParameter("ID_Hor");
		String idcan     = (String)request.getParameter("ID_Can");
		String idcomp     = (String)request.getParameter("ID_Comp");
		String diares    = (String)request.getParameter("Dia_Res");
		String diapart   = (String)request.getParameter("DiaPartido_Res");
		String preciores = (String)request.getParameter("Precio_Can");
		String preciores1 = (String)request.getParameter("Precio_Res");
		String obsres    = (String)request.getParameter("Observaciones_Res");
		
		String tamañocan    = (String)request.getParameter("Tamaño_Can");
		String ciudadcomp    = (String)request.getParameter("Ciudad_Comp");
		String horarioshor    = (String)request.getParameter("Horarios_Hor");
		String diacomp   = (String)request.getParameter("Dia_Dia");

		
		String nomcomp   = (String)request.getParameter("Nombre_Comp");
		String nomcan   = (String)request.getParameter("Nombre_Can");
		String dircomp  = (String)request.getParameter("Direccion_Comp");
		
		
		String action = request.getParameter("action");
		reservasMODELO reservasmodelo = null;
	
		//este no lo estoy usando actualmente.
if ("create".equals(action)) {


	if ("null".equals(idcan) || ("null".equals(idhor)) || ("Selecciona el Dia".equals(diapart)))  {
		sesion.setAttribute("msg", "2");
	
String nextJSP = "/reservasAlta.jsp";
RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(nextJSP);
dispatcher.forward(request, response);

} else{
	
				if (id != null) {
				int ID_Usu = Integer.parseInt(id);
				int ID_Hor = Integer.parseInt(idhor);
				int ID_Can = Integer.parseInt(idcan);
				int Precio_Res = Integer.parseInt(preciores);
				String Estado_Res = "Reservado";
				reservasmodelo = new reservasMODELO(ID_Usu, ID_Hor, ID_Can, diares, diapart, Precio_Res, obsres, Estado_Res);
				Object result=reserva.CreateReserva(reservasmodelo);
				if(result.equals("OK")){
					sesion.setAttribute("msg", "1");
				}else{
					sesion.setAttribute("msg", "0");
				}
				sesion.removeAttribute("nomcan");
				sesion.removeAttribute("precan");
				sesion.removeAttribute("horarioshor");
				
				String nextJSP = "/reservasAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				
			}else{
					sesion.setAttribute("msg", "0");
				}
			String nextJSP = "/reservasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}
}

if ("createDueño".equals(action)) {
	
	
				if (id != null) {
				int ID_Usu = Integer.parseInt(id);
				int ID_Hor = Integer.parseInt(idhor);
				int ID_Can = Integer.parseInt(idcan);
				int Precio_Res = Integer.parseInt(preciores);
				String Estado_Res = "Reservado";
				reservasmodelo = new reservasMODELO(ID_Usu, ID_Hor, ID_Can, diares, diapart, Precio_Res, obsres, Estado_Res);
				Object result=reserva.CreateReserva(reservasmodelo);
				if(result.equals("OK")){
					sesion.setAttribute("msg", "1");
				}else{
					sesion.setAttribute("msg", "0");
				}
				
				String nextJSP = "/reservasAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				
			}else{
					sesion.setAttribute("msg", "0");
				}
			String nextJSP = "/reservasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}



if ("createjg".equals(action)) { //creamos la reserva del jugador y enviamos el correo de aviso al mismo.
	
				if (id != null) {
				int ID_Usu = Integer.parseInt(id);
				int ID_Hor = Integer.parseInt(idhor);
				int ID_Can = Integer.parseInt(idcan);
				int Precio_Res = Integer.parseInt(preciores);
				int ID_Comp = Integer.parseInt(idcomp);
				
				String Usuario_Usu = (nomUsu);
				String Horarios_Hor = (horarioshor);
				String Nombre_Comp = (nomcomp);
				String Nombre_Can = (nomcan);
				String Direccion_Comp = (dircomp);
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				String DiaHoy = df.format(new Date());
				
				String Estado_Res = "Reservado";
				String Observaciones_Ress = "Sin Observaciones";
				reservasmodelo = new reservasMODELO(ID_Usu, ID_Hor, ID_Can, diares, diapart, Precio_Res, Observaciones_Ress, Estado_Res);
				Object result=reserva.CreateReserva(reservasmodelo);
				if(result.equals("OK")){
					
					//inicio correo al jugador
					String correojug = reserva.BuscarCorreoUsu(ID_Usu);//Envio el ID_Usu para que me busque el correo y lo traiga.

					
					String recipient = (correojug);
					String subject = ("EnHoraBuena! Mira los datos de tu Reserva");
					String content = ("Informacion de tu reserva: ");


					String host = "smtp.gmail.com";
					String port = "587";
					String user = "futbolfiverosario@gmail.com";
					String pass = "proyecto2020";
					
					String cuerpo = new String(content+"\n"
													  +"\nComplejo: "+Nombre_Comp
													  +"\nDireccion: "+ciudadcomp+", "+Direccion_Comp
													  +"\nCancha: "+Nombre_Can
													  +"\nTamaño: "+tamañocan
													  +"\nPrecio: "+"$"+preciores+".00"
													  +"\nReservo el dia: "+DiaHoy
													  +"\nDia del partido: "+diapart
													  +"\nHorario del partido: "+Horarios_Hor+"HS"
												);
					

						try {
							EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
									cuerpo);
						} catch (AddressException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			//Fin correo jugador
						
			//inicio correo al dueño
				
					String correodueño = reserva.BuscarCorreoDueño(ID_Comp);//Envio el ID_Comp para que me busque por INNER JOIN el correo del dueño.
					String recipient1 = (correodueño);
					String subject1 = ("EnHoraBuena! Reservaron en tu Complejo!");
					String content2 = ("Informacion del cliente: ");
					
					String cuerpo1 = new String(	  
													  content2+"\n"
													  +"\nReserva a nombre de: "+Usuario_Usu
													  +"\nCorreo: "+correojug
													  +"\n"
													  +"\n"+content+"\n"
													  +"\nComplejo: "+Nombre_Comp
													  +"\nDireccion: "+ciudadcomp+", "+Direccion_Comp
													  +"\nCancha: "+Nombre_Can
													  +"\nTamaño: "+tamañocan
													  +"\nPrecio: "+"$"+preciores+".00"
													  +"\nReservo el dia: "+DiaHoy
													  +"\nDia del partido: "+diapart
													  +"\nHorario del partido: "+Horarios_Hor+"HS"
												);
					

						try {
							EmailUtility.sendEmail(host, port, user, pass, recipient1, subject1,
									cuerpo1);
						} catch (AddressException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			//fin correo dueño
						
					sesion.setAttribute("msg", "1");
				}else{
					sesion.setAttribute("msg", "0");
				}
				String nextJSP = "/reservasJugAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				
			}else{
					sesion.setAttribute("msg", "0");
				}
			String nextJSP = "/reservasJugAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}


			
		
if ("BuscarParaReservar".equals(action)) {
	

	if ("".equals(horarioshor)&&(nivelUsu == "Jugador_Role"))  {
				
		sesion.setAttribute("msg", "2");
		String nextJSP = "/reservasJugAlta.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		}
	
	if ("".equals(horarioshor)&&("Dueño_Role".equals(nivelUsu)))  {
		
		sesion.setAttribute("msg", "2");
		String nextJSP = "/reservasAlta.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		}
	
	else{

	if (id != null) {
		
		int Tamaño_Can = Integer.parseInt(tamañocan);
		String Ciudad_Comp = (ciudadcomp);
		String Horarios_Hor = (horarioshor);
		String DiaPartido_Res = (diapart);
		String Nombre_Comp = (nomcomp);
		ArrayList<reservasMODELO> reservasmodelos = reserva.BuscarReservasUsuario(Tamaño_Can, Ciudad_Comp, Horarios_Hor, DiaPartido_Res, Nombre_Comp, nivelUsu );
		request.setAttribute("reservasmodelos", reservasmodelos);
		if ("Jugador_Role".equals(nivelUsu))  {
		String nextJSP = "/reservasJugAlta.jsp";
		RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		}
		if ("Dueño_Role".equals(nivelUsu))  {
			String nextJSP = "/reservasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
			.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}
				}
				
				if ("Jugador_Role".equals(nivelUsu))  {
				
				sesion.setAttribute("msg", "2");
				String nextJSP = "/reservasJugAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				
				}else{
					sesion.setAttribute("msg", "2");
					String nextJSP = "/reservasAlta.jsp";
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
				}
	

			} 
	
		}

if ("CalificarReserva".equals(action)) {
	if (idRes != null) {
		int ID_Comp = Integer.parseInt(idcomp);
		int idres = Integer.parseInt(idRes);
		int cestrella = Integer.parseInt(estrella);
		Object result=reserva.CalificarReserva(idres,cestrella);
		
		if(result==null){
		
		Object result1=reserva.SumatoriaComplejo(ID_Comp);
		
		if(result1==null){
			
		Object result2=reserva.ContadorComplejo(ID_Comp);
		
		if(result2==null){
			
			sesion.setAttribute("msg", "1");
		}}}else{
			sesion.setAttribute("msg", "0");
		}
		String nextJSP = "/reservasJugHistorial.jsp";
		RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

}

if ("DenunciarReserva".equals(action)) {
	if (idRes != null) {
		int idres = Integer.parseInt(idRes);
		Object result=reserva.DenunciarReserva(idres);
		
		if(result==null){
			//inicio correo al admin
			int ID_Usu = Integer.parseInt(id);	
			String Usuario_Usu = (nomUsu);
			String Horarios_Hor = (horarioshor);
			String Nombre_Comp = (nomcomp);
			String Nombre_Can = (nomcan);
			String Direccion_Comp = (dircomp);
			String DiaReserva = (diares);
			int Precio_Res = Integer.parseInt(preciores1);
		//	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		//	String DiaHoy = df.format(new Date());
			
			int ID_Comp = Integer.parseInt(idcomp);
			String correodueño = reserva.BuscarCorreoDueño(ID_Comp);//Envio el ID_Comp para que me busque por INNER JOIN el correo del dueño.
			String correodueño1 = (correodueño);
			
			String correojug = reserva.BuscarCorreoUsu(ID_Usu);//Envio el ID_Usu para que me busque el correo y lo traiga.
			String correojugador = (correojug);
			String recipient = "futbolfiverosario@gmail.com";
				String subject = ("Atencion! Denunciaron un Complejo");
				String content = ("Informacion de la reserva: ");


				String host = "smtp.gmail.com";
				String port = "587";
				String user = "futbolfiverosario@gmail.com";
				String pass = "proyecto2020";
				
				String cuerpo = new String(content+"\n"
												  +"\nReserva a nombre de: "+Usuario_Usu
												  +"\nCorreo Jugador: "+correojugador
												  +"\nComplejo Denunciado: "+Nombre_Comp
												  +"\nCorreo Del Complejo: "+correodueño1
												  +"\nDireccion: "+ciudadcomp+", "+Direccion_Comp
												  +"\nCancha: "+Nombre_Can
												  +"\nTamaño: "+tamañocan
												  +"\nPrecio: "+"$"+Precio_Res+".00"
												  +"\nReservo el dia: "+DiaReserva
												  +"\nDia del partido: "+diapart
												  +"\nHorario del partido: "+Horarios_Hor+"HS"
											);
				

					try {
						EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
								cuerpo);
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//fin correo admin
			
			sesion.setAttribute("msg", "2");
		}else{
			sesion.setAttribute("msg", "0");
		}
		String nextJSP = "/reservasJugHistorial.jsp";
		RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

}



	}
	
}


