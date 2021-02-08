package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;


import dao.conexionDAO;
import modelo.canchasMODELO;
import modelo.complejosMODELO;


public class canchasDAO {
	private static String ListadoCanchas = "select * from canchas,usuarios,complejos  where canchas.ID_Comp = complejos.ID_Comp and complejos.ID_Usu = usuarios.ID_Usu and canchas.Estado_Can = 'Activo' and usuarios.ID_Usu = ?";
	private static String FindById = "Select * from canchas where ID_Can=?";
	private static String Insert = "insert into canchas (ID_Comp,Nombre_Can,Tamaño_Can,Precio_Can,Observaciones_Can,Estado_Can)" + " values (?, ?, ?, ?,?,'Activo')" ;
	private static String findAll = "Select * from complejos where ID_Usu=? and Estado_Comp='Activo' order by ID_Comp asc";
	private static String Update = "Update canchas set ID_Comp=?,Nombre_Can=?,Tamaño_Can=?,Precio_Can=?,Observaciones_Can=?,Estado_Can=? where ID_Can=?";
	private static String Delete = "Update canchas set Estado_Can=? where ID_Can=?";
	private static String HistorialCanchas = "select * from canchas,usuarios,complejos  where canchas.ID_Comp = complejos.ID_Comp and complejos.ID_Usu = usuarios.ID_Usu and usuarios.ID_Usu = ?";
	private static String findHistorialAdmin = "select * from canchas,usuarios,complejos  where canchas.ID_Comp = complejos.ID_Comp and complejos.ID_Usu = usuarios.ID_Usu ";
	

	Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;	
	
	
	//Buscar por id de cancha
	
	public canchasMODELO findById(int ID_Can) {
		ArrayList<canchasMODELO> canchasmodelos = new ArrayList<canchasMODELO>();
		try {
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindById);
			statement.setInt(1, ID_Can);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idCan = resultSet.getInt("ID_Can");
				int idComp = resultSet.getInt("ID_Comp");
				String nombreCan = resultSet.getString("Nombre_Can");
				int tamañoCan = resultSet.getInt("Tamaño_Can");
				int precioCan = resultSet.getInt("Precio_Can");
				String observacionesCan = resultSet.getString("Observaciones_Can");
				String estadoCan = resultSet.getString("Estado_Can");
				canchasMODELO canchasmodelo = new canchasMODELO(idCan, idComp, nombreCan,
						tamañoCan, precioCan, observacionesCan, estadoCan);
				canchasmodelos.add(canchasmodelo);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return canchasmodelos.get(0);
	}
	
	public ArrayList<canchasMODELO> HistorialCanchas(int ID_Usu) {
		ArrayList<canchasMODELO> canchasmodelos = new ArrayList<canchasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			if (ID_Usu == 1){
				statement = conn.prepareStatement(findHistorialAdmin);
				resultSet = statement.executeQuery();
			}
			else{
			statement = conn.prepareStatement(HistorialCanchas);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			}
			while (resultSet.next()) {
				int idcancha = resultSet.getInt("ID_Can");
				int idcomlejo = resultSet.getInt("ID_Comp");
				String nombrecomlejo = resultSet.getString("Nombre_Comp");
				String nombre = resultSet.getString("Nombre_Can");
				int tamaño = resultSet.getInt("Tamaño_Can");
				int precio = resultSet.getInt("Precio_Can");
				String observaciones = resultSet.getString("Observaciones_Can");
				String estado = resultSet.getString("Estado_Can");
			
				
				canchasMODELO canchasmodelo = new canchasMODELO(idcancha, idcomlejo, nombrecomlejo, nombre,
						tamaño, precio, observaciones, estado);
				
				canchasmodelos.add(canchasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return canchasmodelos;
	}
	
	//INSERT CANCHA
	
	
	public String CreateCancha(canchasMODELO canchasmodelo) {
		String result = "OK";

		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// query

			// Alta de cancha

			statement = conn.prepareStatement(Insert);
			statement.setInt(1, canchasmodelo.getID_Comp());
			statement.setString(2, canchasmodelo.getNombre_Can());
			statement.setInt(3, canchasmodelo.getTamaño_Can());
			statement.setInt(4, canchasmodelo.getPrecio_Can());
			statement.setString(5, canchasmodelo.getObservaciones_Can());
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();

			if (valres == 0) {
				result = "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print("Error Al conectar Con El Servidor");
		}

		return result;
	}
	
// obtener lista de complejos activos por usuario
	
	public ArrayList<complejosMODELO> findAll(int ID_Usu) {
		ArrayList<complejosMODELO> complejosmodelos = new ArrayList<complejosMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(findAll);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idcomplejo = resultSet.getInt("ID_Comp");
				int idusuario = resultSet.getInt("ID_Usu");
				String nombre = resultSet.getString("Nombre_Comp");
				String ciudad = resultSet.getString("Ciudad_Comp");
				String direccion = resultSet.getString("Direccion_Comp");
				String foto = resultSet.getString("Foto_Comp");
				String observaciones = resultSet.getString("Observaciones_Comp");
				String estado = resultSet.getString("Estado_Comp");
				
				complejosMODELO complejosmodelo = new complejosMODELO(idcomplejo, idusuario, nombre,
						ciudad, direccion, foto, observaciones, estado);
				
				complejosmodelos.add(complejosmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return complejosmodelos;
	}
	
	
// obtener lista de canchas activas por usuario
	
	public ArrayList<canchasMODELO> ListadoCanchas(int ID_Usu) {
		ArrayList<canchasMODELO> canchasmodelos = new ArrayList<canchasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(ListadoCanchas);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idcancha = resultSet.getInt("ID_Can");
				int idcomlejo = resultSet.getInt("ID_Comp");
				String nombrecomp = resultSet.getString("Nombre_Comp");
				String nombre = resultSet.getString("Nombre_Can");
				int tamaño = resultSet.getInt("Tamaño_Can");
				int precio = resultSet.getInt("Precio_Can");
				String observaciones = resultSet.getString("Observaciones_Can");
				String estado = resultSet.getString("Estado_Can");
				
				canchasMODELO canchasmodelo = new canchasMODELO(idcancha, idcomlejo,nombrecomp, nombre,
						tamaño, precio, observaciones, estado);
				
				canchasmodelos.add(canchasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return canchasmodelos;
	}
	
	
	//Modificar canchas
	public String ModificarCancha(int ID_Can, canchasMODELO canchamodelo) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(Update);
			statement.setInt(1, canchamodelo.getID_Comp());
			statement.setString(2, canchamodelo.getNombre_Can());
			statement.setInt(3, canchamodelo.getTamaño_Can());
			statement.setInt(4, canchamodelo.getPrecio_Can());
			statement.setString(5, canchamodelo.getObservaciones_Can());
			statement.setString(6, canchamodelo.getEstado_Can());
			statement.setInt(7, canchamodelo.getID_Can());
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
	

	
	private static canchasDAO instance = null;

	public canchasDAO() {
	}

	public static canchasDAO getInstace() {
		if (instance == null) {
			instance = new canchasDAO();
		}
		return instance;
	}
	
//eliminar Cancha de futbol
	
	public String EliminarCancha(int ID_Can) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// estado del complejo = Activo o Inactivo 
			String estado = "Inactivo";
			statement = conn.prepareStatement(Delete);
			statement.setString(1, estado);
			statement.setInt(2, ID_Can);
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