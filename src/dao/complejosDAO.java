package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.conexionDAO;
import modelo.complejosMODELO;


public class complejosDAO {

	private static String InsertComlejos = "insert into complejos (ID_Usu,Nombre_Comp,Ciudad_Comp,Direccion_Comp,Foto_Comp,Observaciones_Comp,Estado_Comp)"
		+ " values (?, ?, ?, ?,?,?,'Activo')";
	private static String InsertHorarios = "insert into horarios (ID_Comp,Horarios_Hor,Estado_Hor)"
		+ " values (?, ?, 'Activo')";
	private static String InsertDias = "insert into dias (ID_Comp,Dia_Dia,Estado_Dia)"
		+ " values (?, ?, 'Activo')";
	
	private static String Update = "Update complejos set ID_Usu=?,Nombre_Comp=?,Ciudad_Comp=?,Direccion_Comp=?,Foto_Comp=?,Observaciones_Comp=?,Estado_Comp=? where ID_Comp=?";
	
	private static String Delete = "Update complejos set Estado_Comp=? where ID_Comp=?";

	private static String FindById = "Select * from complejos where ID_Comp=?";
	private static String findAll = "Select * from complejos where ID_Usu=? and Estado_Comp='Activo' order by ID_Comp asc";
	private static String findHistorial = "Select usuarios.Usuario_Usu, complejos.* , (complejos.AcumCalf_Comp / complejos.ContCalf_Comp) AS Promedio_Comp from complejos INNER JOIN usuarios ON complejos.ID_Usu = usuarios.ID_Usu and  usuarios.ID_Usu=? order by ID_Comp asc ";
	private static String findHistorialAdmin = "Select usuarios.Usuario_Usu, complejos.* , (complejos.AcumCalf_Comp / complejos.ContCalf_Comp) AS Promedio_Comp from complejos INNER JOIN usuarios ON complejos.ID_Usu = usuarios.ID_Usu order by ID_Comp asc";
	private static String FindIdComp = "SELECT * FROM complejos order by ID_Comp desc";
	private static String FindIdHor = "SELECT * FROM horarios order by ID_Hor desc";
	
	
	
	Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	
	
	//Insert tabla COMPLEJOS
	public String CreateComplejo(complejosMODELO complejosmodelo) {
		String result = "OK";

		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// query

			// Alta de complejo

			statement = conn.prepareStatement(InsertComlejos);
			statement.setInt(1, complejosmodelo.getID_Usu());
			statement.setString(2, complejosmodelo.getNombre_Comp());
			statement.setString(3, complejosmodelo.getCiudad_Comp());
			statement.setString(4, complejosmodelo.getDireccion_Comp());
			if (complejosmodelo.getFoto_Comp().isEmpty()) {
				statement.setString(5, "https://ventas.fa-sol-la.com.ar/iconos/sin_imagen.jpg");
			}	else { 		
			statement.setString(5, complejosmodelo.getFoto_Comp());}
			statement.setString(6, complejosmodelo.getObservaciones_Comp());
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();

			if (valres == 0) {
				result = "error";
			}
			
	} 		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print("Error Al conectar Con El Servidor");
		}

		return result;
	}

	
	// buscar id complejo
	public int BuscarIdComplejo() {
		int ID_Comp = 0;
		ArrayList<complejosMODELO> complejosmodelos = new ArrayList<complejosMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindIdComp);
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
			complejosMODELO complejosmodelo=complejosmodelos.get(0); 
			 ID_Comp= complejosmodelo.getID_Comp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return ID_Comp;
	}
	
	
	//////Insert tabla Horarios
	public String CreateHorarios(String partHoraI1,String partHoraF1,String partHoraI2,String partHoraF2, int idcomplejo) {
		String result = "OK";

		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// query
			
			int a= Integer.valueOf(partHoraI1); //(horario de inicio franja hor 1)
			int b= Integer.valueOf(partHoraF1); //(horario de fin franja hor 1)
			int c= Integer.valueOf(partHoraI2); //(horario de inicio franja hor 2)
			int d= Integer.valueOf(partHoraF2); //(horario de fin franja hor 2)
        
		for (int i=a; i<=b;i++){
			
			String HorarioNum = String.valueOf(i);
			String Horario = HorarioNum+":00";
			
	    		statement = conn.prepareStatement(InsertHorarios);
				statement.setInt(1, idcomplejo);
				statement.setString(2, Horario);
	            statement.executeUpdate();
	            statement.close();
	            }
		
		for (int i=c; i<=d;i++){
			
			String HorarioNum = String.valueOf(i);
			String Horario = HorarioNum+":00";
			
	    		statement = conn.prepareStatement(InsertHorarios);
				statement.setInt(1, idcomplejo);
				statement.setString(2, Horario);
	            statement.executeUpdate();
	            statement.close();
	            }
		
			
				conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print("Error Al conectar Con El Servidor");
		}

		return result;
	}
	
	//Insert tabla dias
	public String CreateDias(int idcomplejo,ArrayList<complejosMODELO> complejosmodelos) {
		String result = "OK";

		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// query
	
			for (int i=0; i<complejosmodelos.size(); i++){
	            complejosMODELO complejomodelo = complejosmodelos.get(i);
	    		statement = conn.prepareStatement(InsertDias);
				statement.setInt(1, idcomplejo);
	            statement.setString(2, complejomodelo.getDia_Dia());
	            statement.executeUpdate();
	            statement.close();
	            }
			
				conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print("Error Al conectar Con El Servidor");
		}

		return result;
	}
	

	public complejosDAO() {
	}

	public static complejosDAO getInstace() {
		if (instance == null) {
			instance = new complejosDAO();
		}
		return instance;
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
	
	
	// obtener historial de complejos por usuario
	
	public ArrayList<complejosMODELO> findHistorial(int ID_Usu) {
		ArrayList<complejosMODELO> complejosmodelos = new ArrayList<complejosMODELO>();
		try {
			conn = conexionDAO.conexion();
			if (ID_Usu == 1){
				statement = conn.prepareStatement(findHistorialAdmin);
				resultSet = statement.executeQuery();
			}
			else{
			statement = conn.prepareStatement(findHistorial);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			}

			while (resultSet.next()) {
				String nombreusuario = resultSet.getString("Usuario_Usu");
				int idcomplejo = resultSet.getInt("ID_Comp");
				int idusuario = resultSet.getInt("ID_Usu");
				String nombre = resultSet.getString("Nombre_Comp");
				String ciudad = resultSet.getString("Ciudad_Comp");
				String direccion = resultSet.getString("Direccion_Comp");
				String foto = resultSet.getString("Foto_Comp");
				String observaciones = resultSet.getString("Observaciones_Comp");
				String estado = resultSet.getString("Estado_Comp");
				int promedioComp = resultSet.getInt("Promedio_Comp");
				
				
				complejosMODELO complejosmodelo = new complejosMODELO(nombreusuario, idcomplejo, idusuario, nombre,
						ciudad, direccion, foto, observaciones, estado, promedioComp);
				
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
	
	
	
	
	//Modificar complejos
	public String ModificarComplejo(int ID_Comp, complejosMODELO complejomodelo) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(Update);
			statement.setInt(1, complejomodelo.getID_Usu());
			statement.setString(2, complejomodelo.getNombre_Comp());
			statement.setString(3, complejomodelo.getCiudad_Comp());
			statement.setString(4, complejomodelo.getDireccion_Comp());
			statement.setString(5, complejomodelo.getFoto_Comp());
			statement.setString(6, complejomodelo.getObservaciones_Comp());
			statement.setString(7, complejomodelo.getEstado_Comp());
			statement.setInt(8, complejomodelo.getID_Comp());
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
	
	//Buscar por id de complejo
	
	public complejosMODELO findById(int ID_Comp) {
		ArrayList<complejosMODELO> complejosmodelos = new ArrayList<complejosMODELO>();
		try {
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindById);
			statement.setInt(1, ID_Comp);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idComp = resultSet.getInt("ID_Comp");
				int idUsuario = resultSet.getInt("ID_Usu");
				String nombreComp = resultSet.getString("Nombre_Comp");
				String ciudadComp = resultSet.getString("Ciudad_Comp");
				String direccionComp = resultSet.getString("Direccion_Comp");
				String fotoComp = resultSet.getString("Foto_Comp");
				String observacionesComp = resultSet.getString("Observaciones_Comp");
				String estadoComp = resultSet.getString("Estado_Comp");
				complejosMODELO complejosmodelo = new complejosMODELO(idComp, idUsuario, nombreComp,
						ciudadComp, direccionComp, fotoComp, observacionesComp,estadoComp);
				complejosmodelos.add(complejosmodelo);

			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return complejosmodelos.get(0);
	}
	
//eliminar complejos de futbol
	
	public String EliminarComplejo(int ID_Comp) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// estado del complejo = Activo o Inactivo 
			String estado = "Inactivo";
			statement = conn.prepareStatement(Delete);
			statement.setString(1, estado);
			statement.setInt(2, ID_Comp);
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
	
	private static complejosDAO instance = null;
}
