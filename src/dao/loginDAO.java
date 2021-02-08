package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.usuariosMODELO;


public class loginDAO {

	private static String FindAll = "Select * from usuarios";

	public String LoginUser(usuariosMODELO usuariomodelo) {

		String userName = usuariomodelo.getUsuario_Usu();
		String password = usuariomodelo.getContraseña_Usu();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";

		try {
			con = conexionDAO.conexion();
			statement = con.createStatement();
			resultSet = statement.executeQuery(FindAll);

			while (resultSet.next()) {
				userNameDB = resultSet.getString("Usuario_Usu");
				passwordDB = resultSet.getString("Contraseña_Usu");
				roleDB = resultSet.getString("Nivel_Usu");
			    int Estado_Usu = resultSet.getInt("Estado_Usu");
				int	ID_Usu = resultSet.getInt("ID_Usu");

				if (userName.equals(userNameDB) && password.equals(passwordDB)
						&& roleDB.equals("Admin")&& Estado_Usu==1)
					return "Admin_Role-"+ID_Usu;
				
				else if (userName.equals(userNameDB)
						&& password.equals(passwordDB)
						&& roleDB.equals("Dueño") && Estado_Usu==1)
					return "Dueño_Role-"+ID_Usu;
				
				else if (userName.equals(userNameDB)
						&& password.equals(passwordDB) && roleDB.equals("Jugador") && Estado_Usu==1)
					return "Jugador_Role-"+ID_Usu;
			} 
		} catch (SQLException e) {
			System.err.print(e);
		}
		return "null";
	}

	private static loginDAO instance = null;

	public loginDAO() {
	}

	public static loginDAO getInstace() {
		if (instance == null) {
			instance = new loginDAO();
		}
		return instance;
	}

	public static void main(String[] args) {

	}
}
