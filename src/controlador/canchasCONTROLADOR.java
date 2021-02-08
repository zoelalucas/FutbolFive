package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.canchasMODELO;
import modelo.complejosMODELO;
import dao.canchasDAO;

/**
 * Servlet implementation class canchasCONTROLADOR
 */
public class canchasCONTROLADOR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public canchasCONTROLADOR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
    	canchasDAO canchas = canchasDAO.getInstace();
    	String action = request.getParameter("action");
    	HttpSession sesion = request.getSession(true);
    	String idusestr = (String) sesion.getAttribute("ID_Usu");
    	String idstr = request.getParameter("id");
    	canchasMODELO canchasmodelo = null;
		
		if ("select".equals(action)) {
			if (idstr != null) {
				int id = Integer.parseInt(idstr);
				canchasmodelo = canchas.findById(id);
				request.setAttribute("canchasmodelos", canchasmodelo);
				request.setAttribute("ID_Can", idstr);
				String nextJSP = "/canchasModificar.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
			}
    	}
		
    	if ("listar".equals(action)) {
			int ID_Usu = Integer.parseInt(idusestr);
			ArrayList<complejosMODELO> complejosmodelos = canchas.findAll(ID_Usu);
			request.setAttribute("complejosmodelos", complejosmodelos);
			String nextJSP = "/canchasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }
    	
    	if ("ListadoCanchas".equals(action)) {
			int ID_Usu = Integer.parseInt(idusestr);
			ArrayList<canchasMODELO> canchasmodelos = canchas.ListadoCanchas(ID_Usu);
			request.setAttribute("canchasmodelos", canchasmodelos);
			String nextJSP = "/canchasListado.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }
    	
    	if ("HistorialCanchas".equals(action)) {
			int ID_Usu = Integer.parseInt(idusestr);
			ArrayList<canchasMODELO> canchasmodelos = canchas.HistorialCanchas(ID_Usu);
			request.setAttribute("canchasmodelos", canchasmodelos);
			
				if ("1".equals(idusestr)){
				
				String nextJSP = "/reportesCancAdmin.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				
				}
			else{
			String nextJSP = "/canchasHistorial.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}
    	}
    	
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);		
		canchasDAO cancha = canchasDAO.getInstace();
		String idcompsrt = (String) request.getParameter("id");
		String Nombre_Can = request.getParameter("Nombre_Can");
		String Tamaño_Can = request.getParameter("Tamaño_Can");
		String Precio_Can = request.getParameter("Precio_Can");
		String Observaciones_Can = request.getParameter("Observaciones_Can");
		String id = (String) request.getParameter("ID_Comp");
		String action = request.getParameter("action");
		canchasMODELO canchasmodelo = null;

    	
    	

if ("create".equals(action)) {
	
	if ("".equals(Nombre_Can) || ("".equals(Precio_Can)))  {
		sesion.setAttribute("msg", "2");
	
String nextJSP = "/canchasAlta.jsp";
RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(nextJSP);
dispatcher.forward(request, response);

} else{
	

			if (id != null) {
				int ID_Comp = Integer.parseInt(id);
				int Tamaño_Cana = Integer.parseInt(Tamaño_Can);
				int  Precio_Cana = Integer.parseInt(Precio_Can);
				String Estado_Can = "Activo";
				canchasmodelo = new canchasMODELO(ID_Comp, Nombre_Can, Tamaño_Cana, Precio_Cana,
						Observaciones_Can, Estado_Can);
				Object result=cancha.CreateCancha(canchasmodelo);
				if(result.equals("OK")){
					sesion.setAttribute("msg", "1");
				}else{
					sesion.setAttribute("msg", "0");
				}
				String nextJSP = "/canchasAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				
			}else{
					sesion.setAttribute("msg", "2");
				}
			String nextJSP = "/canchasAlta.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}	}
		
if ("update".equals(action)) {
	if (idcompsrt != null) {
		int idcan = Integer.parseInt(idcompsrt);
		int idcom = Integer.parseInt(id);
		int Tamaño_Cana = Integer.parseInt(Tamaño_Can);
		int  Precio_Cana = Integer.parseInt(Precio_Can);
		String Estado_Can = "Activo";
		canchasmodelo = new canchasMODELO(idcan,idcom,Nombre_Can,
				Tamaño_Cana, Precio_Cana, Observaciones_Can,
				Estado_Can);
		Object result = cancha.ModificarCancha(idcan, canchasmodelo);
		if(result==null){
			sesion.setAttribute("msg", "1");
		}else{
			sesion.setAttribute("msg", "0");
		}
		String nextJSP = "/canchasModificar.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);				
	}	
}

if ("eliminar".equals(action)) {
	if (idcompsrt != null) {
		int ida = Integer.parseInt(idcompsrt);
		Object result=cancha.EliminarCancha(ida);
		
		if(result==null){
			sesion.setAttribute("msg", "1");
		}else{
			sesion.setAttribute("msg", "0");
		}
		String nextJSP = "/canchasHistorial.jsp";
		RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}


	}
}
}