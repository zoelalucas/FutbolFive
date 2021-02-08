package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.complejosDAO;
import modelo.complejosMODELO;

/**
 * Servlet implementation class complejosCONTROLADOR
 */
public class complejosCONTROLADOR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public complejosCONTROLADOR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
    	complejosDAO complejo = complejosDAO.getInstace();
    	String action = request.getParameter("action");
    	String idstr = request.getParameter("id");
		HttpSession sesion = request.getSession(true);
    	String idusestr = (String) sesion.getAttribute("ID_Usu");
    	complejosMODELO complejosmodelo = null;

    	
    	if ("listar".equals(action)) {
			int ID_Usu = Integer.parseInt(idusestr);
			ArrayList<complejosMODELO> complejosmodelos = complejo.findAll(ID_Usu);
			request.setAttribute("complejosmodelos", complejosmodelos);
			String nextJSP = "/complejosListado.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }
    	
    	if ("historial".equals(action)) {
			int ID_Usu = Integer.parseInt(idusestr);
			ArrayList<complejosMODELO> complejosmodelos = complejo.findHistorial(ID_Usu);
			request.setAttribute("complejosmodelos", complejosmodelos);
			
			if ("1".equals(idusestr)){
				
				String nextJSP = "/reportesCompAdmin.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				
			}
			else{
			String nextJSP = "/complejosHistorial.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}
		}
    	
 	
    	else if ("select".equals(action)) {
			if (idstr != null) {
				int id = Integer.parseInt(idstr);
				complejosmodelo = complejo.findById(id);
				request.setAttribute("complejosmodelos", complejosmodelo);
				String nextJSP = "/complejosModificar.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
			}
    	}
}
    
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		complejosDAO complejo = complejosDAO.getInstace();
		String Nombre_Comp = request.getParameter("Nombre_Comp");
		String Ciudad_Comp = request.getParameter("Ciudad_Comp");
		String Direccion_Comp = request.getParameter("Direccion_Comp");
		String Foto_Comp = request.getParameter("Foto_Comp");
		String Observaciones_Comp = request.getParameter("Observaciones_Comp");
		String id = (String) sesion.getAttribute("ID_Usu");
		String idcompsrt = (String) request.getParameter("id");
		String f1horariaIni = (String) request.getParameter("DesdeF1_Hor");
		String f1horariaFin = (String) request.getParameter("HastaF1_Hor");
		String f2horariaIni = (String) request.getParameter("DesdeF2_Hor");
		String f2horariaFin = (String) request.getParameter("HastaF2_Hor");
		
		
		String action = request.getParameter("action");
		
		complejosMODELO complejosmodelo = null;		
		
		
		if ("create".equals(action)) {
			
			if ("".equals(Nombre_Comp) || "".equals(Direccion_Comp)
			|| "".equals(f1horariaIni) || "".equals(f1horariaFin))  {
				
		sesion.setAttribute("msg", "2");
		String nextJSP = "/complejosAlta.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		} else{
			
			String[] dias = request.getParameterValues("Dias");
			ArrayList<complejosMODELO> complejosmodelos = new ArrayList<complejosMODELO>();
			for (int i = 0; i < dias.length; i++) {
	            complejosMODELO complejomodelo = new complejosMODELO(dias[i]);
	            complejosmodelos.add(complejomodelo);
	        }

			
			if (id != null) {
				int ID_Usu = Integer.parseInt(id);
				String Estado_Comp = "Activo";
				complejosmodelo = new complejosMODELO(ID_Usu, Nombre_Comp, Ciudad_Comp, Direccion_Comp,
				Foto_Comp, Observaciones_Comp, Estado_Comp);
				String result=complejo.CreateComplejo(complejosmodelo);
				
				if(result.equals("OK")){

					int idcomplejo = complejo.BuscarIdComplejo();//no pasas parametros solo esperas el id
			
					if (idcomplejo!=0){
						
						//Franja horaria 1
						String[] partsI1 = f1horariaIni.split(":");
						String partHoraI1 = partsI1[0];
						
						String[] partsF1 = f1horariaFin.split(":");
						String partHoraF1 = partsF1[0];
					
					if ("".equals(f2horariaIni) || "".equals(f2horariaFin)){
						
						String partHoraI2 = "25"; //Se pone 25 equivalente a null, cuando no eligen la 2da franja horaria.
						
						String partHoraF2 = "25"; //Se pone 25 equivalente a null, cuando no eligen la 2da franja horaria. 
						
					result = complejo.CreateHorarios(partHoraI1,partHoraF1,partHoraI2,partHoraF2,idcomplejo);//haces el insert con  id comp + el array de horarios
					result = complejo.CreateDias(idcomplejo,complejosmodelos);//haces el insert con  id comp  + el array de dias
					
					
					}else{
							
						//Franja horaria 2
						String[] partsI2 = f2horariaIni.split(":");
						String partHoraI2 = partsI2[0];
						
						String[] partsF2 = f2horariaFin.split(":");
						String partHoraF2 = partsF2[0];
						
						
						
						result = complejo.CreateHorarios(partHoraI1,partHoraF1,partHoraI2,partHoraF2,idcomplejo);//haces el insert con  id comp + el array de horarios
						result = complejo.CreateDias(idcomplejo,complejosmodelos);//haces el insert con  id comp  + el array de dias
					}
					
							sesion.setAttribute("msg", "1");
							String nextJSP = "/complejosAlta.jsp";
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(nextJSP);
							dispatcher.forward(request, response);
							
					}else {
						sesion.setAttribute("msg", "0");//msg error
						String nextJSP = "/complejosAlta.jsp";
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(nextJSP);
						dispatcher.forward(request, response);
						}	
				}else {
					sesion.setAttribute("msg", "0");//msg error
					String nextJSP = "/complejosAlta.jsp";
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
					}
			}else {
				sesion.setAttribute("msg", "0");//msg error
				String nextJSP = "/complejosAlta.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				}
		}
	}
		
	
if ("update".equals(action)) {
		if (idcompsrt != null) {
			int idusu = Integer.parseInt(id);
			int idcomp = Integer.parseInt(idcompsrt);
			String Estado_Comp = "Activo";
			complejosmodelo = new complejosMODELO(idcomp, idusu, Nombre_Comp,
					Ciudad_Comp, Direccion_Comp, Foto_Comp, Observaciones_Comp,
					Estado_Comp);
			Object result = complejo.ModificarComplejo(idcomp, complejosmodelo);
			if(result==null){
				sesion.setAttribute("msg", "1");
			}else{
				sesion.setAttribute("msg", "0");
			}
			String nextJSP = "/complejosModificar.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);				
		}	
	}

if ("eliminar".equals(action)) {
	if (idcompsrt != null) {
		int ida = Integer.parseInt(idcompsrt);
		Object result=complejo.EliminarComplejo(ida);
		
		if(result==null){
			sesion.setAttribute("msg", "1");
		}else{
			sesion.setAttribute("msg", "0");
		}
		String nextJSP = "/complejosListado.jsp";
		RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

}
	
	
	}
	
}
	
