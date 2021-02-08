package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class indexCONTROLADOR
 */
public class indexCONTROLADOR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexCONTROLADOR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
	 * Aca asigno dependiendo del NIVEL(1==admin, 2==dueño, 3==jugador) que tenga el usuario a que .jsp debe ir.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String role = (String) sesion.getAttribute("Nivel_Usu");
		if (role!=null){
		if (role.equals("Admin_Role")){

			request.getRequestDispatcher("menuAdmin.jsp").forward(request,
					response);
		}else if (role.equals("Dueño_Role")){

			request.getRequestDispatcher("menuDueño.jsp").forward(request,
					response);

		}else if (role.equals("Jugador_Role")){

			request.getRequestDispatcher("menuJugador.jsp").forward(request,
					response);

		}
		} else{request.getRequestDispatcher("index.jsp").forward(request,
				response);
}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
