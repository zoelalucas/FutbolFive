package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.conexionDAO;
import modelo.canchasMODELO;
import modelo.complejosMODELO;
import modelo.reservasMODELO;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class reservasDAO {
	
	private static String findAll = "Select * from complejos where ID_Usu=? and Estado_Comp='Activo' order by ID_Comp asc";
	private static String ListCanPorComp = "select * from canchas,usuarios,complejos  where canchas.ID_Comp = complejos.ID_Comp and complejos.ID_Usu = usuarios.ID_Usu and canchas.Estado_Can = 'Activo' and complejos.ID_Comp = ?";
	private static String FindIdComp = "SELECT * FROM complejos order by ID_Comp desc";
	private static String FindCorreo = "SELECT Correo_Usu FROM usuarios where ID_Usu = ? ";
	private static String FindCorreoUsuRes = "SELECT usuarios.Correo_Usu FROM reservas INNER JOIN  usuarios ON reservas.ID_Usu = usuarios.ID_Usu and reservas.ID_Res = ?";
	private static String FindCorreoDueRes = "SELECT usuarios.Correo_Usu FROM reservas  INNER JOIN  canchas ON canchas.ID_Can = reservas.ID_Can INNER JOIN  complejos ON complejos.ID_Comp = canchas.ID_Comp INNER JOIN  usuarios ON usuarios.ID_Usu = complejos.ID_Usu and reservas.ID_Can = ?";
	private static String FindCorreoDueño = "SELECT usuarios.Correo_Usu FROM usuarios INNER JOIN complejos ON complejos.ID_Usu = usuarios.ID_Usu  and complejos.ID_Comp = ?";
	private static String ListadoComplejos = "select DISTINCT complejos.Nombre_Comp from canchas,usuarios,complejos  where canchas.ID_Comp = complejos.ID_Comp and complejos.ID_Usu = usuarios.ID_Usu and canchas.Estado_Can = 'Activo' and usuarios.ID_Usu = ?";
	private static String FindById = "Select complejos.ID_Comp, dias.Dia_Dia, dias.ID_Dia from dias,complejos where complejos.id_comp = dias.ID_Comp and complejos.id_comp = ?";
	private static String FindById2 = "Select * from horarios,complejos where complejos.id_comp = horarios.ID_Comp and complejos.id_comp = ?";
	private static String InsertReserva = "insert into reservas (ID_Usu,ID_Hor,ID_Can,Dia_Res,DiaPartido_Res,Precio_Res,Observaciones_Res,Estado_Res,Calificacion_Res)"
		+ " values (?, ?, ?, CURRENT_DATE(), ?, ?, ?, 'Reservado','0')";
	
	private static String ListadoReservas ="select reservas.Precio_Res, canchas.Tamaño_Can, complejos.Ciudad_Comp, complejos.Direccion_Comp, complejos.Nombre_Comp, complejos.ID_Usu, usuarios.Usuario_Usu,horarios.Horarios_Hor,canchas.Nombre_Can,reservas.ID_Res,reservas.Dia_Res,reservas.DiaPartido_Res,reservas.Precio_Res,reservas.Precio_Res,reservas.Observaciones_Res,reservas.Estado_Res "
+ "from reservas INNER JOIN  horarios ON reservas.ID_Hor = horarios.ID_Hor "
+			 " INNER JOIN  canchas  ON reservas.ID_Can = canchas.ID_Can "
+			 " INNER JOIN  complejos ON canchas.ID_Comp = complejos.ID_Comp"
+         "    INNER JOIN  usuarios ON reservas.ID_Usu = usuarios.ID_Usu"
+		"  and reservas.Estado_Res = 'Reservado' and complejos.ID_Usu = ?;";
	
	private static String HistorialReservas ="select *, complejos.ID_Usu, usuarios.Usuario_Usu,horarios.Horarios_Hor,canchas.Nombre_Can,reservas.ID_Res,reservas.Dia_Res,reservas.DiaPartido_Res,reservas.Precio_Res,reservas.Precio_Res,reservas.Observaciones_Res,reservas.Estado_Res "
		+ "from reservas INNER JOIN  horarios ON reservas.ID_Hor = horarios.ID_Hor "
		+			 " INNER JOIN  canchas  ON reservas.ID_Can = canchas.ID_Can "
		+			 " INNER JOIN  complejos ON canchas.ID_Comp = complejos.ID_Comp"
		+         "    INNER JOIN  usuarios ON reservas.ID_Usu = usuarios.ID_Usu"
		+		"   and complejos.ID_Usu = ?;";
	
	private static String findHistorialAdmin ="select *, complejos.ID_Usu, usuarios.Usuario_Usu,horarios.Horarios_Hor,canchas.Nombre_Can,reservas.ID_Res,reservas.Dia_Res,reservas.DiaPartido_Res,reservas.Precio_Res,reservas.Observaciones_Res,reservas.Estado_Res "
		+ "from reservas INNER JOIN  horarios ON reservas.ID_Hor = horarios.ID_Hor "
		+			 " INNER JOIN  canchas  ON reservas.ID_Can = canchas.ID_Can "
		+			 " INNER JOIN  complejos ON canchas.ID_Comp = complejos.ID_Comp"
		+         "    INNER JOIN  usuarios ON reservas.ID_Usu = usuarios.ID_Usu order by reservas.ID_Res DESC";
	
	
	private static String Delete = "Update reservas set Estado_Res=? where ID_Res=?";	

	private static String BuscarReservaUsuario = "SELECT complejos.Id_Comp,complejos.Nombre_Comp,complejos.Ciudad_Comp,complejos.Direccion_Comp,complejos.Foto_Comp,complejos.Observaciones_Comp, canchas.ID_Can, canchas.Nombre_Can, canchas.Tamaño_Can, canchas.Precio_Can, canchas.Observaciones_Can, canchas.Estado_Can, horarios.Horarios_Hor, horarios.ID_Hor, (complejos.AcumCalf_Comp / complejos.ContCalf_Comp) as Promedio_Comp "
		+ "FROM canchas "
		+ "INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp "
		+ "INNER JOIN horarios ON complejos.ID_Comp = horarios.ID_Comp "
		+ "and complejos.Estado_Comp = 'Activo' and canchas.Estado_Can = 'Activo'  and canchas.Tamaño_Can = ? AND complejos.Ciudad_Comp = ? AND horarios.Horarios_Hor = ?"
		+ "and canchas.ID_Can not in (SELECT reservas.ID_Can from reservas INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can and reservas.Estado_Res = 'Reservado' and reservas.DiaPartido_Res = ?) ";
	
	private static String BuscarReservaUsuario1 = "SELECT complejos.Id_Comp,complejos.Nombre_Comp,complejos.Ciudad_Comp,complejos.Direccion_Comp,complejos.Foto_Comp,complejos.Observaciones_Comp, canchas.ID_Can, canchas.Nombre_Can, canchas.Tamaño_Can, canchas.Precio_Can, canchas.Observaciones_Can, canchas.Estado_Can, horarios.Horarios_Hor, horarios.ID_Hor, (complejos.AcumCalf_Comp / complejos.ContCalf_Comp) as Promedio_Comp "
		+ "FROM canchas "
		+ "INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp "
		+ "INNER JOIN horarios ON complejos.ID_Comp = horarios.ID_Comp "
		+ "and complejos.Estado_Comp = 'Activo' and canchas.Estado_Can = 'Activo'  and canchas.Tamaño_Can = ? AND complejos.Ciudad_Comp = ? AND horarios.Horarios_Hor = ? and complejos.Nombre_Comp = ?"
		+ "and canchas.ID_Can not in (SELECT reservas.ID_Can from reservas INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can and reservas.Estado_Res = 'Reservado' and reservas.DiaPartido_Res = ?) ";
	

	
	private static String ListadoReservaUsuario = "SELECT reservas.ID_Res,reservas.ID_Usu, reservas.ID_Hor, reservas.ID_Can, reservas.Dia_Res, reservas.DiaPartido_Res, reservas.Precio_Res, reservas.Estado_Res,complejos.Id_Comp,complejos.Nombre_Comp,complejos.Ciudad_Comp,complejos.Direccion_Comp,complejos.Foto_Comp,complejos.Observaciones_Comp, canchas.ID_Can, canchas.Nombre_Can, canchas.Tamaño_Can, canchas.Observaciones_Can, horarios.Horarios_Hor "
	+ "FROM reservas "
	+ "INNER JOIN usuarios ON reservas.ID_Usu = usuarios.ID_Usu "
	+ "INNER JOIN horarios ON reservas.ID_Hor = horarios.ID_Hor "
	+ "INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can "
	+ "INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp "
	+ "and reservas.ID_Usu = ? and reservas.Estado_Res='Reservado'";
	
	private static String HistorialReservaUsuario = "SELECT reservas.ID_Res,reservas.ID_Usu, reservas.ID_Hor, reservas.ID_Can, reservas.Dia_Res, reservas.DiaPartido_Res, reservas.Precio_Res, reservas.Estado_Res,reservas.Calificacion_Res,complejos.Id_Comp,complejos.Nombre_Comp,complejos.Ciudad_Comp,complejos.Direccion_Comp,complejos.Foto_Comp,complejos.Observaciones_Comp, canchas.ID_Can, canchas.Nombre_Can, canchas.Tamaño_Can, canchas.Observaciones_Can, horarios.Horarios_Hor "
		+ "FROM reservas "
		+ "INNER JOIN usuarios ON reservas.ID_Usu = usuarios.ID_Usu "
		+ "INNER JOIN horarios ON reservas.ID_Hor = horarios.ID_Hor "
		+ "INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can "
		+ "INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp "
		+ "and reservas.ID_Usu = ?";	
	
	private static String ReservaFinalizadaUsuario = "SELECT reservas.ID_Res,reservas.ID_Usu, reservas.ID_Hor, reservas.ID_Can, reservas.Dia_Res, reservas.DiaPartido_Res, reservas.Precio_Res, reservas.Estado_Res,complejos.Id_Comp,complejos.Nombre_Comp,complejos.Ciudad_Comp,complejos.Direccion_Comp,complejos.Foto_Comp,complejos.Observaciones_Comp, canchas.ID_Can, canchas.Nombre_Can, canchas.Tamaño_Can, canchas.Observaciones_Can, horarios.Horarios_Hor "
		+ "FROM reservas "
		+ "INNER JOIN usuarios ON reservas.ID_Usu = usuarios.ID_Usu "
		+ "INNER JOIN horarios ON reservas.ID_Hor = horarios.ID_Hor "
		+ "INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can "
		+ "INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp "
		+ "and reservas.estado_res = 'Finalizado' "
		+ "and reservas.calificacion_res = 0 "
		+ "and reservas.ID_Usu = ?";	
	
	private static String Calificar = "Update reservas set Calificacion_Res = ? where ID_Res=?";	
	
	private static String SumCalfComp = "UPDATE complejos SET AcumCalf_Comp =( SELECT SUM(Calificacion_Res) AS Sumatoria FROM reservas INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp AND complejos.ID_Comp = ? AND reservas.Calificacion_Res BETWEEN 1 AND 5 )WHERE complejos.ID_Comp = ?;";
	
	private static String SumContComp = "UPDATE complejos SET ContCalf_Comp=(SELECT COUNT(*) AS Cantidad FROM reservas INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp and complejos.ID_Comp = ? and reservas.Calificacion_Res BETWEEN 1 and 5) WHERE complejos.ID_Comp = ?;";

	private static String FindCalfPend = "SELECT * FROM reservas WHERE Calificacion_Res = 0 AND Estado_Res = 'Finalizado' AND ID_Usu = ? ";

	private static String FindResProx = "SELECT * FROM reservas WHERE DiaPartido_Res = CURRENT_DATE() + INTERVAL 1 DAY";

	private static String FindResProx1 = "SELECT usuarios.Usuario_Usu,usuarios.Correo_Usu,reservas.Dia_Res,reservas.DiaPartido_Res,reservas.Precio_Res,reservas.Estado_Res,complejos.Nombre_Comp,complejos.Ciudad_Comp,complejos.Direccion_Comp,complejos.Foto_Comp,complejos.Observaciones_Comp,canchas.Nombre_Can,canchas.Tamaño_Can,canchas.Observaciones_Can,horarios.Horarios_Hor "
		+ "FROM reservas "
		+ "INNER JOIN usuarios ON reservas.ID_Usu = usuarios.ID_Usu "
		+ "INNER JOIN horarios ON reservas.ID_Hor = horarios.ID_Hor "
		+ "INNER JOIN canchas ON reservas.ID_Can = canchas.ID_Can "
		+ "INNER JOIN complejos ON complejos.ID_Comp = canchas.ID_Comp  "
		+ "AND reservas.Estado_Res = 'Reservado' "
		+ "AND usuarios.Nivel_Usu = 'Jugador'  "
		+ "AND reservas.DiaPartido_Res in (SELECT DiaPartido_Res FROM reservas WHERE DiaPartido_Res = CURRENT_DATE() + INTERVAL 1 DAY) ";
	
	
	
	Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;	
	

	
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

	
// obtener lista de canchas activas por complejo
	
	public ArrayList<canchasMODELO> ListCanPorComp(int idcomplejo) {
		ArrayList<canchasMODELO> canchasmodelos = new ArrayList<canchasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(ListCanPorComp);
			statement.setInt(1, idcomplejo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idcancha = resultSet.getInt("ID_Can");
				int idcomlejo = resultSet.getInt("ID_Comp");
				String nombre = resultSet.getString("Nombre_Can");
				int tamaño = resultSet.getInt("Tamaño_Can");
				int precio = resultSet.getInt("Precio_Can");
				String observaciones = resultSet.getString("Observaciones_Can");
				String estado = resultSet.getString("Estado_Can");
				
				canchasMODELO canchasmodelo = new canchasMODELO(idcancha, idcomlejo, nombre,
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
	
// obtener listado de complejos que tienen canchas activas por usuario
	
	public ArrayList<reservasMODELO> ListadoComplejos(int ID_Usu) {
		ArrayList<reservasMODELO> reservasmodelos1 = new ArrayList<reservasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(ListadoComplejos);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String nombrecomp = resultSet.getString("Nombre_Comp");
				
				reservasMODELO reservasmodelo = new reservasMODELO(nombrecomp);
				
				reservasmodelos1.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return reservasmodelos1;
	}

	
	private static reservasDAO instance = null;

	public reservasDAO() {
	}

	public static reservasDAO getInstace() {
		if (instance == null) {
			instance = new reservasDAO();
		}
		return instance;
	}
	
//Buscar dias por id de complejo
	
	public ArrayList<complejosMODELO> findById(int ID_Comp) {
		ArrayList<complejosMODELO> complejosmodelos = new ArrayList<complejosMODELO>();
		try {
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindById);
			statement.setInt(1, ID_Comp);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idComp = resultSet.getInt("ID_Comp");
				int idDia = resultSet.getInt("ID_Dia");
				String dias = resultSet.getString("Dia_Dia");
				
				complejosMODELO complejosmodelo = new complejosMODELO(idComp,idDia, dias);
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
	
//Buscar Horarios por id de complejo
	
	public ArrayList<complejosMODELO> findById2(int ID_Comp) {
		ArrayList<complejosMODELO> complejosmodelos1 = new ArrayList<complejosMODELO>();
		try {
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindById2);
			statement.setInt(1, ID_Comp);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idComp = resultSet.getInt("ID_Comp");
				int iDHor = resultSet.getInt("ID_Hor");
				String horarios = resultSet.getString("Horarios_Hor");

				
				complejosMODELO complejosmodelo = new complejosMODELO(idComp, iDHor, horarios);
				complejosmodelos1.add(complejosmodelo);

			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return complejosmodelos1;
	}
	
	
	//Insert  Reserva
	public String CreateReserva(reservasMODELO reservasmodelo) {
		String result = "OK";

		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// query

			// Alta de complejo

			statement = conn.prepareStatement(InsertReserva);
			statement.setInt(1, reservasmodelo.getID_Usu());
			statement.setInt(2, reservasmodelo.getID_Hor());
			statement.setInt(3, reservasmodelo.getID_Can());
			statement.setString(4, reservasmodelo.getDiaPartido_Res());
			statement.setInt(5, reservasmodelo.getPrecio_Res());
			if (reservasmodelo.getObservaciones_Res().isEmpty()) {
				statement.setString(6, "Sin Observaciones");
			}	else { 		
			statement.setString(6, reservasmodelo.getObservaciones_Res());}

			int valres = statement.executeUpdate();
			statement.close();
			conn.close();

			if (valres == 0) {
				result = "error";
			}
			
	} 		catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println("Error Al conectar Con El Servidor");
		}

		return result;
	}


// obtener listado de reservas activas del usuario: Dueño y sus complejos.
	
	public ArrayList<reservasMODELO> ListadoReservas(int ID_Usu) {
		ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(ListadoReservas);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				int idreserva = resultSet.getInt("ID_Res");
				String diares = resultSet.getString("Dia_Res");
				String diapartres = resultSet.getString("DiaPartido_Res");
				int preciores = resultSet.getInt("Precio_Res");
				String observaciones = resultSet.getString("Observaciones_Res");
				String estado = resultSet.getString("Estado_Res");
				String usuario = resultSet.getString("Usuario_Usu");
				String horario = resultSet.getString("Horarios_Hor");
				String cancha = resultSet.getString("Nombre_Can");
				String complejo = resultSet.getString("Nombre_Comp");
				int precio = resultSet.getInt("Precio_Res");
				int tamaño = resultSet.getInt("Tamaño_Can");
				String ciudadcomp = resultSet.getString("Ciudad_Comp");
				String direccion = resultSet.getString("Direccion_Comp");
				
				reservasMODELO reservasmodelo = new reservasMODELO( idreserva, diares, diapartres,preciores, observaciones, estado,usuario, horario, cancha, complejo, precio, tamaño, ciudadcomp, direccion);
				
				reservasmodelos.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return reservasmodelos;
	}
	
	
// obtener Historial de reservas del usuario Dueño y sus complejos.
	
	public ArrayList<reservasMODELO> HistorialReservas(int ID_Usu) {
		ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
		try {	
			
			conn = conexionDAO.conexion();
			if (ID_Usu == 1){
				statement = conn.prepareStatement(findHistorialAdmin);
				resultSet = statement.executeQuery();
				
			}
			else{
			statement = conn.prepareStatement(HistorialReservas);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
		} 

			while (resultSet.next()) {
	
				int idreserva = resultSet.getInt("ID_Res");
				String diares = resultSet.getString("Dia_Res");
				String diapartres = resultSet.getString("DiaPartido_Res");
				int preciores = resultSet.getInt("Precio_Res");
				String observaciones = resultSet.getString("Observaciones_Res");
				String estado = resultSet.getString("Estado_Res");
				String usuario = resultSet.getString("Usuario_Usu");
				String horario = resultSet.getString("Horarios_Hor");
				String cancha = resultSet.getString("Nombre_Can");
				String complejo = resultSet.getString("Nombre_Comp");
				
				reservasMODELO reservasmodelo = new reservasMODELO( idreserva, diares, diapartres,preciores, observaciones, estado,usuario, horario, cancha, complejo);
				
				reservasmodelos.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return reservasmodelos;
	}
	
	
	

//Eliminar Reserva 

	public String EliminarReserva(int ID_Res) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			// estado de la reserva = Reservado o Suspendido 
			String estado = "Suspendido";
			statement = conn.prepareStatement(Delete);
			statement.setString(1, estado);
			statement.setInt(2, ID_Res);
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
	
// obtener listado de complejos/canchas activos para que el usuario Reserve.
	
	public ArrayList<reservasMODELO> BuscarReservasUsuario(int Tamaño_Can, String Ciudad_Comp, String Horarios_Hor, String DiaPartido_Res, String Nombre_Comp, String nivelUsu) {
		ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			if ("Jugador_Role".equals(nivelUsu))  {
			statement = conn.prepareStatement(BuscarReservaUsuario);
			statement.setInt(1, Tamaño_Can);
			statement.setString(2, Ciudad_Comp);
			statement.setString(3, Horarios_Hor);
			statement.setString(4, DiaPartido_Res);
			resultSet = statement.executeQuery();
			}
			if ("Dueño_Role".equals(nivelUsu))  {
				statement = conn.prepareStatement(BuscarReservaUsuario1);
				statement.setInt(1, Tamaño_Can);
				statement.setString(2, Ciudad_Comp);
				statement.setString(3, Horarios_Hor);
				statement.setString(4, Nombre_Comp);
				statement.setString(5, DiaPartido_Res);
				
				resultSet = statement.executeQuery();
				}
			while (resultSet.next()) {
				
				int idcomplejo = resultSet.getInt("ID_Comp");
				int idcancha = resultSet.getInt("ID_Can");
				String nombrecomplejo = resultSet.getString("Nombre_Comp");
				String ciudadcomplejo = resultSet.getString("Ciudad_Comp");
				String direccioncomplejo = resultSet.getString("Direccion_Comp");
				String fotocomplejo = resultSet.getString("Foto_Comp");
				String observaciones = resultSet.getString("Observaciones_Comp");
				String nombrecancha = resultSet.getString("Nombre_Can");
				int tamañocancha = resultSet.getInt("Tamaño_Can");
				int preciocancha = resultSet.getInt("Precio_Can");
				String observacionescancha = resultSet.getString("Observaciones_Can");
				String estadocancha = resultSet.getString("Estado_Can");
				String horario = resultSet.getString("Horarios_Hor");
				int idhorario = resultSet.getInt("ID_Hor");
				int promedioComp = resultSet.getInt("Promedio_Comp");
				
				reservasMODELO reservasmodelo = new reservasMODELO(idcancha, nombrecancha, idcomplejo,
						nombrecomplejo, ciudadcomplejo, direccioncomplejo, fotocomplejo, observaciones,
						tamañocancha, preciocancha, observacionescancha, estadocancha,horario,idhorario,promedioComp);
				
				reservasmodelos.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return reservasmodelos;
	}
	
// obtener listado de reservas por usuario
	
	public ArrayList<reservasMODELO> ListadoReservaUsuario(int ID_Usu) {
			ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
			try {
				
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(ListadoReservaUsuario);
				statement.setInt(1, ID_Usu);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					
					int iDRes = resultSet.getInt("ID_Res");
					int iDUsu = resultSet.getInt("ID_Usu");
					int iDHor = resultSet.getInt("ID_Hor");
					int iDCan = resultSet.getInt("ID_Can");
					String diaRes = resultSet.getString("Dia_Res");
					String diaPartidoRes = resultSet.getString("DiaPartido_Res");
					int precioRes = resultSet.getInt("Precio_Res");
					String horarioshor = resultSet.getString("Horarios_Hor");
					String estadoRes = resultSet.getString("Estado_Res");
					String nombreCan = resultSet.getString("Nombre_Can");
					int iDComp = resultSet.getInt("ID_Comp");
					String nombreComp = resultSet.getString("Nombre_Comp");
					String ciudadComp = resultSet.getString("Ciudad_Comp");
					String direccionComp = resultSet.getString("Direccion_Comp");
					String fotoComp = resultSet.getString("Foto_Comp");
					int tamañoCan = resultSet.getInt("Tamaño_Can");
					String observacionesCan = resultSet.getString("Observaciones_Can");
			
					reservasMODELO reservasmodelo = new reservasMODELO(iDRes, iDUsu, iDHor,
							iDCan, diaRes, diaPartidoRes, precioRes, horarioshor,
							estadoRes, nombreCan, iDComp, nombreComp,ciudadComp,direccionComp,
							fotoComp,tamañoCan,observacionesCan);
					
					reservasmodelos.add(reservasmodelo);
				}
				resultSet.close();
				statement.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return reservasmodelos;
		}
	
// obtener Historial de reservas por usuario
	
	public ArrayList<reservasMODELO> HistorialReservaUsuario(int ID_Usu) {
			ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
			try {
				
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(HistorialReservaUsuario);
				statement.setInt(1, ID_Usu);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					
					int iDRes = resultSet.getInt("ID_Res");
					int iDUsu = resultSet.getInt("ID_Usu");
					int iDHor = resultSet.getInt("ID_Hor");
					int iDCan = resultSet.getInt("ID_Can");
					String diaRes = resultSet.getString("Dia_Res");
					String diaPartidoRes = resultSet.getString("DiaPartido_Res");
					int precioRes = resultSet.getInt("Precio_Res");
					String horarioshor = resultSet.getString("Horarios_Hor");
					String estadoRes = resultSet.getString("Estado_Res");
					String nombreCan = resultSet.getString("Nombre_Can");
					int iDComp = resultSet.getInt("ID_Comp");
					String nombreComp = resultSet.getString("Nombre_Comp");
					String ciudadComp = resultSet.getString("Ciudad_Comp");
					String direccionComp = resultSet.getString("Direccion_Comp");
					String fotoComp = resultSet.getString("Foto_Comp");
					int tamañoCan = resultSet.getInt("Tamaño_Can");
					String observacionesCan = resultSet.getString("Observaciones_Can");
					int calificacionRes = resultSet.getInt("Calificacion_Res");
			
					reservasMODELO reservasmodelo = new reservasMODELO(iDRes, iDUsu, iDHor,
							iDCan, diaRes, diaPartidoRes, precioRes, horarioshor,
							estadoRes, nombreCan, iDComp, nombreComp,ciudadComp,direccionComp,
							fotoComp,tamañoCan,observacionesCan,calificacionRes);
					
					reservasmodelos.add(reservasmodelo);
				}
				resultSet.close();
				statement.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return reservasmodelos;
		}

// obtener reservas finalizadas por usuario
	
	public ArrayList<reservasMODELO> ReservaFinalizadaUsuario(int ID_Usu) {
			ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
			try {
				
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(ReservaFinalizadaUsuario);
				statement.setInt(1, ID_Usu);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					
					int iDRes = resultSet.getInt("ID_Res");
					int iDUsu = resultSet.getInt("ID_Usu");
					int iDHor = resultSet.getInt("ID_Hor");
					int iDCan = resultSet.getInt("ID_Can");
					String diaRes = resultSet.getString("Dia_Res");
					String diaPartidoRes = resultSet.getString("DiaPartido_Res");
					int precioRes = resultSet.getInt("Precio_Res");
					String horarioshor = resultSet.getString("Horarios_Hor");
					String estadoRes = resultSet.getString("Estado_Res");
					String nombreCan = resultSet.getString("Nombre_Can");
					int iDComp = resultSet.getInt("ID_Comp");
					String nombreComp = resultSet.getString("Nombre_Comp");
					String ciudadComp = resultSet.getString("Ciudad_Comp");
					String direccionComp = resultSet.getString("Direccion_Comp");
					String fotoComp = resultSet.getString("Foto_Comp");
					int tamañoCan = resultSet.getInt("Tamaño_Can");
					String observacionesCan = resultSet.getString("Observaciones_Can");
			
					reservasMODELO reservasmodelo = new reservasMODELO(iDRes, iDUsu, iDHor,
							iDCan, diaRes, diaPartidoRes, precioRes, horarioshor,
							estadoRes, nombreCan, iDComp, nombreComp,ciudadComp,direccionComp,
							fotoComp,tamañoCan,observacionesCan);
					
					reservasmodelos.add(reservasmodelo);
				}
				resultSet.close();
				statement.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return reservasmodelos;
		}

	
	// buscar correo usuario
	
	
	public String BuscarCorreoUsu(int ID_Usu) {
		String Correo_Usu = "";
		ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindCorreo);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String correo = resultSet.getString("Correo_Usu");
				
				reservasMODELO reservasmodelo = new reservasMODELO(correo);
				
				reservasmodelos.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
			reservasMODELO reservasmodelo=reservasmodelos.get(0); 
			Correo_Usu= reservasmodelo.getCorreo_Usu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return Correo_Usu;
	}
	

// buscar el correo del usuario cuando elimina la reserva
	
	public String BuscarCorreoUsuRes(int ID_Usu) {
		String Correo_Usu = "";
		ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindCorreoUsuRes);
			statement.setInt(1, ID_Usu);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String correo = resultSet.getString("Correo_Usu");
				
				reservasMODELO reservasmodelo = new reservasMODELO(correo);
				
				reservasmodelos.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
			reservasMODELO reservasmodelo=reservasmodelos.get(0); 
			Correo_Usu= reservasmodelo.getCorreo_Usu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return Correo_Usu;
	}

// buscar el correo del Dueño cuando elimina la reserva
	
	public String BuscarCorreoDueRes(int idcancha) {
		String Correo_Usu = "";
		ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindCorreoDueRes);
			statement.setInt(1, idcancha);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String correo = resultSet.getString("Correo_Usu");
				
				reservasMODELO reservasmodelo = new reservasMODELO(correo);
				
				reservasmodelos.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
			reservasMODELO reservasmodelo=reservasmodelos.get(0); 
			Correo_Usu= reservasmodelo.getCorreo_Usu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return Correo_Usu;
	}
	
	// buscar correo dueño
	public String BuscarCorreoDueño(int ID_Comp) {
		String Correo_Usu = "";
		ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
		try {
			
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(FindCorreoDueño);
			statement.setInt(1, ID_Comp);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String correo = resultSet.getString("Correo_Usu");
				
				reservasMODELO reservasmodelo = new reservasMODELO(correo);
				
				reservasmodelos.add(reservasmodelo);
			}
			resultSet.close();
			statement.close();
			conn.close();
			reservasMODELO reservasmodelo=reservasmodelos.get(0); 
			Correo_Usu= reservasmodelo.getCorreo_Usu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return Correo_Usu;
	}
	
	

	//Calificar Reserva Finalizada
	public Object CalificarReserva(int ID_Res, int Calificacion_Res) {

			String result = null;
			try {
				// conexion
				Connection conn = null;
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(Calificar);
				statement.setInt(1, Calificacion_Res);
				statement.setInt(2, ID_Res);
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
	
	
	//Actualiza el campo que acumula la calificacion del complejo
	public Object SumatoriaComplejo(int ID_Comp) {

			String result1 = null;
			try {
				// conexion
				Connection conn = null;
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(SumCalfComp);
				statement.setInt(1, ID_Comp);
				statement.setInt(2, ID_Comp);
				int valres = statement.executeUpdate();
				statement.close();
				conn.close();
			
				if (valres == 0) {
					result1 = "error";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return result1;
	}

	//Actualiza el campo que acumula el contador de las calificaciones del complejo
	public Object ContadorComplejo(int ID_Comp) {

			String result2 = null;
			try {
				// conexion
				Connection conn = null;
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(SumContComp);
				statement.setInt(1, ID_Comp);
				statement.setInt(2, ID_Comp);
				int valres = statement.executeUpdate();
				statement.close();
				conn.close();
			
				if (valres == 0) {
					result2 = "error";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return result2;
	}
	
	public Object DenunciarReserva(int ID_Res) {
		int Calificacion = 9; //le seteamos un numero que no sea dentro del 1 a 5 para saber que esta denunciado
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = conexionDAO.conexion();
			statement = conn.prepareStatement(Calificar);
			statement.setInt(1, Calificacion);
			statement.setInt(2, ID_Res);
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


	// buscar si el usuario tiene reservas pendientes de calificar
	
	public int BuscarCalfPendientes(String partIDUsu) {

			int Calificaciones_Res = 1;
			ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
			try {
				
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(FindCalfPend);
				statement.setString(1, partIDUsu);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {

					int calificar = resultSet.getInt("ID_Res");

					reservasMODELO reservasmodelo = new reservasMODELO(calificar);
					
					reservasmodelos.add(reservasmodelo);
				}
				resultSet.close();
				statement.close();
				conn.close();
				reservasMODELO reservasmodelo=reservasmodelos.get(0);
				Calificaciones_Res = reservasmodelo.getID_Res();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return Calificaciones_Res;


}

	// buscar si hay reservas proximas a vencer

	public int BuscarReservasPorJugar() {
		
			int ID_Res = 0;
			ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
			try {
				
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(FindResProx);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int reservasporjugar = resultSet.getInt("ID_Res");

					reservasMODELO reservasmodelo = new reservasMODELO(reservasporjugar);
					
					reservasmodelos.add(reservasmodelo);
				}
				resultSet.close();
				statement.close();
				conn.close();
				reservasMODELO reservasmodelo=reservasmodelos.get(0);
				 ID_Res= reservasmodelo.getID_Res();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return ID_Res;
		}


	// ARRAY DE RESERVAR POR JUGAR
	public ArrayList<reservasMODELO> BuscarReservasPorJugar1() {
		
			ArrayList<reservasMODELO> reservasmodelos = new ArrayList<reservasMODELO>();
			try {
				
				conn = conexionDAO.conexion();
				statement = conn.prepareStatement(FindResProx1);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					
					String diaRes = resultSet.getString("Dia_Res");
					String diaPartidoRes = resultSet.getString("DiaPartido_Res");
					int precioRes = resultSet.getInt("Precio_Res");
					String horarioshor = resultSet.getString("Horarios_Hor");
					String estadoRes = resultSet.getString("Estado_Res");
					String nombreCan = resultSet.getString("Nombre_Can");
					String nombreComp = resultSet.getString("Nombre_Comp");
					String ciudadComp = resultSet.getString("Ciudad_Comp");
					String direccionComp = resultSet.getString("Direccion_Comp");
					int tamañoCan = resultSet.getInt("Tamaño_Can");
					String observacionesCan = resultSet.getString("Observaciones_Can");			
					String correoUsu = resultSet.getString("Correo_Usu");			
					String usuarioUsu = resultSet.getString("Usuario_Usu");							    
				    
					reservasMODELO reservasmodelo = new reservasMODELO(diaRes, diaPartidoRes, precioRes, horarioshor,
							estadoRes, nombreCan, nombreComp,ciudadComp,direccionComp,
							tamañoCan,observacionesCan, correoUsu, usuarioUsu);
					
					reservasmodelos.add(reservasmodelo);
				}
				resultSet.close();
				statement.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			return reservasmodelos;
		}
	
}
	

