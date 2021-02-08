package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import modelo.usuariosMODELO;
import dao.loginDAO;
import dao.reservasDAO;

/**
 * Servlet implementation class loginCONTROLADOR
 */
public class loginCONTROLADOR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCONTROLADOR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("usuario");
		String password = request.getParameter("contraseña");
		reservasDAO reservas = reservasDAO.getInstace();
    	HttpSession sesion = request.getSession(true);

		usuariosMODELO usuariosmodelo = new usuariosMODELO(userName, password);

		loginDAO login = new loginDAO();

		try {

			String userValidate = login.LoginUser(usuariosmodelo);
			if (userValidate.equals("null")) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10 * 60);
				session.setAttribute("msg", "0");
				request.getRequestDispatcher("login.jsp").forward(
						request, response);
				
			} else {
				String[] parts = userValidate.split("-");
				String partNivel_Usu = parts[0];
				String partID_Usu = parts[1];
				if (partNivel_Usu.equals("Admin_Role")) {

					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10 * 60);
					session.setAttribute("Usuario_Usu", userName);
					session.setAttribute("ID_Usu", partID_Usu);
					session.setAttribute("Nivel_Usu", partNivel_Usu);
					
					int reservasporjugar = reservas.BuscarReservasPorJugar();//verifico si existen reservas por jugar al siguiente dia
					
					if (reservasporjugar!=0){
						sesion.setAttribute("msg", "1");
	    	   			String nextJSP = "/menuAdmin.jsp";
	    	   			RequestDispatcher dispatcher = getServletContext()
	    	   			.getRequestDispatcher(nextJSP);
	    	   			dispatcher.forward(request, response);
	    	   			
    	   			}else{
    					request.getRequestDispatcher("menuAdmin.jsp").forward(
    							request, response);
    					}
				
					
				} else if (partNivel_Usu.equals("Dueño_Role")) {

					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10 * 60);
					session.setAttribute("Usuario_Usu", userName);
					session.setAttribute("ID_Usu", partID_Usu);
					session.setAttribute("Nivel_Usu", partNivel_Usu);

					request.getRequestDispatcher("menuDueño.jsp").forward(
							request, response);
					
				} else if (partNivel_Usu.equals("Jugador_Role")) {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10 * 60);
					session.setAttribute("Usuario_Usu", userName);
					session.setAttribute("ID_Usu", partID_Usu);
					session.setAttribute("Nivel_Usu", partNivel_Usu);
					
					int calificar = reservas.BuscarCalfPendientes(partID_Usu);//Envio el ID_Usu para que me busque sus calif pendientes.
					
					if (calificar != 1){
						sesion.setAttribute("msg", "1");
	    	   			String nextJSP = "/menuJugador.jsp";
	    	   			RequestDispatcher dispatcher = getServletContext()
	    	   			.getRequestDispatcher(nextJSP);
	    	   			dispatcher.forward(request, response);
	    	   			
    	   			}else{
    					request.getRequestDispatcher("menuJugador.jsp").forward(
    							request, response);}
				}
			}
		} catch (IOException e) {
			System.err.print(e);
		}
	}

}