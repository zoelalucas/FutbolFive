package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import modelo.complejosMODELO;
import modelo.usuariosMODELO;

public class registrarseDAO {

	private static String ByUser = "Select * from usuarios where Usuario_Usu=?";
	private static String Insert = "insert into usuarios (Usuario_Usu,Contraseña_Usu,Correo_Usu,Nivel_Usu,Estado_Usu)"
			+ " values (?,?,?,?,1)";
	private static String FindAll = "SELECT * FROM usuarios where Estado_Usu = 1 order by ID_Usu desc";
	private static String FindSusp = "SELECT * FROM usuarios where Estado_Usu = 2 order by ID_Usu desc";
	private static String FindAllHist = "SELECT * FROM usuarios order by ID_Usu desc";
	private static String Delete = "Update usuarios set Estado_Usu=? where ID_Usu=?";	

	Connection conn = null;	
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	
	public String CreateUser(usuariosMODELO usuariosmodelo) {
		String result = "";
		int result2 = 1;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// query
			String username = usuariosmodelo.getUsuario_Usu();
			statement = conn.prepareStatement(ByUser);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String userbd = resultSet.getString("Usuario_Usu");

				if (userbd.equals(username)) {
					result2 = 0;
				}
			}
			if (result2 == 1) {

				// alta

				statement = conn.prepareStatement(Insert);
				statement.setString(1, username);
				statement.setString(2, usuariosmodelo.getContraseña_Usu());
				statement.setString(3, usuariosmodelo.getCorreo_Usu());
				statement.setString(4, usuariosmodelo.getNivel_Usu());
				statement.executeUpdate();
				statement.close();
				conn.close();
			} else {
				result = "error";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return result;
	}
	
	private static registrarseDAO instance = null;

	private registrarseDAO() {
	}

	public static registrarseDAO getInstace() {
		if (instance == null) {
			instance = new registrarseDAO();
		}
		return instance;
	}

	public static void main(String[] args) {
		registrarseDAO users = registrarseDAO.getInstace();
	}

// buscar los Usuarios activos
	public ArrayList<usuariosMODELO> BuscarUsuarios() {
		ArrayList<usuariosMODELO> usuariosmodelos = new ArrayList<usuariosMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindAll);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idusu = resultSet.getInt("ID_Usu");
				String nombreusu = resultSet.getString("Usuario_Usu");
				String contraseñausu = resultSet.getString("Contraseña_Usu");
				String correousu = resultSet.getString("Correo_Usu");
				String nivelusu = resultSet.getString("Nivel_Usu");
				int estadousu = resultSet.getInt("Estado_Usu");				
				
				usuariosMODELO usuariosmodelo = new usuariosMODELO(idusu, nombreusu, contraseñausu,
						correousu, nivelusu, estadousu);
				
				usuariosmodelos.add(usuariosmodelo);
			}
				resultSet.close();
				statement.close();
				conn.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		System.err.print(e);
	}
	return usuariosmodelos;
}
	
	// buscar los Usuarios inactivos
	public ArrayList<usuariosMODELO> BuscarSuspendidos() {
		ArrayList<usuariosMODELO> usuariosmodelos = new ArrayList<usuariosMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindSusp);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idusu = resultSet.getInt("ID_Usu");
				String nombreusu = resultSet.getString("Usuario_Usu");
				String contraseñausu = resultSet.getString("Contraseña_Usu");
				String correousu = resultSet.getString("Correo_Usu");
				String nivelusu = resultSet.getString("Nivel_Usu");
				int estadousu = resultSet.getInt("Estado_Usu");				
				
				usuariosMODELO usuariosmodelo = new usuariosMODELO(idusu, nombreusu, contraseñausu,
						correousu, nivelusu, estadousu);
				
				usuariosmodelos.add(usuariosmodelo);
			}
				resultSet.close();
				statement.close();
				conn.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		System.err.print(e);
	}
	return usuariosmodelos;
}
	
// buscar todos los Usuarios act/inac
	public ArrayList<usuariosMODELO> HistorialUsuarios() {
		ArrayList<usuariosMODELO> usuariosmodelos = new ArrayList<usuariosMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindAllHist);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idusu = resultSet.getInt("ID_Usu");
				String nombreusu = resultSet.getString("Usuario_Usu");
				String contraseñausu = resultSet.getString("Contraseña_Usu");
				String correousu = resultSet.getString("Correo_Usu");
				String nivelusu = resultSet.getString("Nivel_Usu");
				int estadousu = resultSet.getInt("Estado_Usu");				
				
				usuariosMODELO usuariosmodelo = new usuariosMODELO(idusu, nombreusu, contraseñausu,
						correousu, nivelusu, estadousu);
				
				usuariosmodelos.add(usuariosmodelo);
			}
				resultSet.close();
				statement.close();
				conn.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		System.err.print(e);
	}
	return usuariosmodelos;
}
	

//Eliminar Usuario 

	public String EliminarUsuario(int ID_Usu) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// estado del usuario = Activo=1 o Suspendido=2
			String estado = "2";
			statement = conn.prepareStatement(Delete);
			statement.setString(1, estado);
			statement.setInt(2, ID_Usu);
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();
		
			if (valres == 0) {
				result = "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return result;
	}
	
//Activar Usuario 

public String ActivarUsuario(int ID_Usu) {
	String result = null;
	try {
		// conexion
		Connection conn = null;
		conn = conexionDAO.conexion();
		// estado del usuario = Activo=1 o Suspendido=2
		String estado = "1";
		statement = conn.prepareStatement(Delete);
		statement.setString(1, estado);
		statement.setInt(2, ID_Usu);
		int valres = statement.executeUpdate();
		statement.close();
		conn.close();
	
		if (valres == 0) {
			result = "error";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.err.print(e);
	}
	return result;
}

}
