package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.EmailUtility;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// reads form fields
		String recipient = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String remitente = request.getParameter ("remitente");
		String nombreapellido = request.getParameter ("nombreapeliido");
		String telefono = request.getParameter ("telefono");

		HttpSession sesion = request.getSession(true);		
		String action = request.getParameter("action");

		if ("Enviar".equals(action)) {
		
		String cuerpo = new String(content+"\n"
										  +"\nNombre: "+nombreapellido
										  +"\nTelefono: "+telefono
										  +"\nCorreo: "+remitente
									);
		

		String resultMessage = "";

		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					cuerpo);
			resultMessage = "Tu correo fue Enviado";
			sesion.setAttribute("msg", "1");
			
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "Hubo un Error: " + ex.getMessage();
			sesion.setAttribute("msg", "2");
			
		} finally {
			request.setAttribute("Message", resultMessage);
			String nextJSP = "/index.jsp";
			RequestDispatcher dispatcher = getServletContext()
			.getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
			}
		}
		
	}
}