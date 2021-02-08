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
import dao.registrarseDAO;
import modelo.complejosMODELO;
import modelo.usuariosMODELO;

/**
 * Servlet implementation class registrarseCONTROLADOR
 */
public class registrarseCONTROLADOR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrarseCONTROLADOR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
    	registrarseDAO usuario = registrarseDAO.getInstace();
    	String action = request.getParameter("action");
    	String idstr = request.getParameter("id");
    	HttpSession sesion = request.getSession(true);

    	
    	if ("listar".equals(action)) {
			ArrayList<usuariosMODELO> usuariosmodelos = usuario.BuscarUsuarios();
			request.setAttribute("usuariosmodelos", usuariosmodelos);
			String nextJSP = "/usuariosListado.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }
    	
    	if ("historial".equals(action)) {
			ArrayList<usuariosMODELO> usuariosmodelos = usuario.HistorialUsuarios();
			request.setAttribute("usuariosmodelos", usuariosmodelos);
			String nextJSP = "/usuariosHistorial.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }
    	if ("suspendidos".equals(action)) {
			ArrayList<usuariosMODELO> usuariosmodelos = usuario.BuscarSuspendidos();
			request.setAttribute("usuariosmodelos", usuariosmodelos);
			String nextJSP = "/usuariosSuspendidos.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
    }
    
    	
	   	if ("eliminar".equals(action)) {
	   		if (idstr != null) {
	   			int idr = Integer.parseInt(idstr);
	   			Object result=usuario.EliminarUsuario(idr);
	   			
	   			if(result==null){
	   				sesion.setAttribute("msg", "1");
	   			}else{
	   				sesion.setAttribute("msg", "0");
	   			}
	   			String nextJSP = "/usuariosListado.jsp";
	   			RequestDispatcher dispatcher = getServletContext()
	   			.getRequestDispatcher(nextJSP);
	   			dispatcher.forward(request, response);
	   		}


	   		}
	 	if ("activar".equals(action)) {
	   		if (idstr != null) {
	   			int idr = Integer.parseInt(idstr);
	   			Object result=usuario.ActivarUsuario(idr);
	   			
	   			if(result==null){
	   				sesion.setAttribute("msg", "1");
	   			}else{
	   				sesion.setAttribute("msg", "0");
	   			}
	   			String nextJSP = "/usuariosSuspendidos.jsp";
	   			RequestDispatcher dispatcher = getServletContext()
	   			.getRequestDispatcher(nextJSP);
	   			dispatcher.forward(request, response);
	   		}


	   		}
	   	
	   	
 }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		registrarseDAO user = registrarseDAO.getInstace();
		String usuario = request.getParameter("username");
		String role = request.getParameter("role");
		String clave = request.getParameter("pass");
		String confPass = request.getParameter("reppass");
		String email = request.getParameter("email");
		String action = request.getParameter("action");
		usuariosMODELO usuariosmodelo = null;

if ("create".equals(action)) {
			if (clave.equals(confPass)) {
				int estadousuario = 1;
				usuariosmodelo = new usuariosMODELO(usuario, clave, role, email, estadousuario);
				String result = user.CreateUser(usuariosmodelo);
				if (result.equals("")) {
					sesion.setAttribute("msg", "1");
					String nextJSP = "/login.jsp";
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
				} else {
					sesion.setAttribute("msg", "0");
				}

				String nextJSP = "/registrarse.jsp";
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);

			}
			else {
				sesion.setAttribute("msg", "2");
			
			String nextJSP = "/registrarse.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);}
		}
	}
}

