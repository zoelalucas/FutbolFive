package modelo;

public class reservasMODELO {

int ID_Res;
int ID_Usu;
int ID_Hor;
int ID_Can;
String Dia_Res;
String DiaPartido_Res;
int Precio_Res;
String Observaciones_Res;
String Estado_Res;
String Usuario_Usu;
String Horarios_Hor;
String Nombre_Can;
//estos los agrego para el jugador cuando busca reservar
int ID_Comp;
String Nombre_Comp;
String Ciudad_Comp;
String Direccion_Comp;
String Foto_Comp;
String Observaciones_Comp;
int Tamaño_Can;
int Precio_Can;
String Observaciones_Can;
String Estado_Can;
String Dia_Dia;
//para buscar el correo del usuario y poder enviar mensaje.
String Correo_Usu;
//para las calificaciones
int Calificaciones_Res;
int Promedio_Comp;





public reservasMODELO(String diaRes, String diaPartidoRes, int precioRes,String horariosHor,
		String estadoRes, String nombreCan, String nombreComp, String ciudadComp,
		String direccionComp, int tamañoCan, String observacionesCan,
		String correoUsu,  String usuarioUsu) {
	super();
	Dia_Res = diaRes;
	DiaPartido_Res = diaPartidoRes;
	Precio_Res = precioRes;
	Horarios_Hor = horariosHor;
	Estado_Res = estadoRes;
	Nombre_Can = nombreCan;
	Nombre_Comp = nombreComp;
	Ciudad_Comp = ciudadComp;
	Direccion_Comp = direccionComp;
	Tamaño_Can = tamañoCan;
	Observaciones_Can = observacionesCan;
	Correo_Usu = correoUsu;
	Usuario_Usu = usuarioUsu;
}

public reservasMODELO(int iDCan, String nombreCan, int iDComp,
		String nombreComp, String ciudadComp, String direccionComp,
		String fotoComp, String observacionesComp, int tamañoCan,
		int precioCan, String observacionesCan, String estadoCan, String horariosRes, int iDHor, int promedioComp) {
	super();
	ID_Can = iDCan;
	Nombre_Can = nombreCan;
	ID_Comp = iDComp;
	Nombre_Comp = nombreComp;
	Ciudad_Comp = ciudadComp;
	Direccion_Comp = direccionComp;
	Foto_Comp = fotoComp;
	Observaciones_Comp = observacionesComp;
	Tamaño_Can = tamañoCan;
	Precio_Can = precioCan;
	Observaciones_Can = observacionesCan;
	Estado_Can = estadoCan;
	Horarios_Hor = horariosRes;
	ID_Hor = iDHor;
	Promedio_Comp = promedioComp;

}

public reservasMODELO(int iDRes, String diaRes, String diaPartidoRes,
		int precioRes, String observacionesRes, String estadoRes,
		String usuarioUsu, String horariosHor, String nombreCan,
		String nombreComp) {
	super();
	ID_Res = iDRes;
	Dia_Res = diaRes;
	DiaPartido_Res = diaPartidoRes;
	Precio_Res = precioRes;
	Observaciones_Res = observacionesRes;
	Estado_Res = estadoRes;
	Usuario_Usu = usuarioUsu;
	Horarios_Hor = horariosHor;
	Nombre_Can = nombreCan;
	Nombre_Comp = nombreComp;
}

public reservasMODELO(int iDRes) {
	super();
	ID_Res = iDRes;
}

public reservasMODELO(String correoUsu) {
	super();
	Correo_Usu = correoUsu;
}


public reservasMODELO(int iDRes, int iDUsu, int iDHor, int iDCan,
		String diaRes, String diaPartidoRes, int precioRes,
		 String horarioshor, String estadoRes, String nombreCan,
		int iDComp, String nombreComp, String ciudadComp, String direccionComp,
		String fotoComp, int tamañoCan, String observacionesCan) {
	super();
	ID_Res = iDRes;
	ID_Usu = iDUsu;
	ID_Hor = iDHor;
	ID_Can = iDCan;
	Dia_Res = diaRes;
	DiaPartido_Res = diaPartidoRes;
	Precio_Res = precioRes;
	Horarios_Hor = horarioshor;
	Estado_Res = estadoRes;
	Nombre_Can = nombreCan;
	ID_Comp = iDComp;
	Nombre_Comp = nombreComp;
	Ciudad_Comp = ciudadComp;
	Direccion_Comp = direccionComp;
	Foto_Comp = fotoComp;
	Tamaño_Can = tamañoCan;
	Observaciones_Can = observacionesCan;
}
//para la calificacion
public reservasMODELO(int iDRes, int iDUsu, int iDHor, int iDCan,
		String diaRes, String diaPartidoRes, int precioRes,
		 String horarioshor, String estadoRes, String nombreCan,
		int iDComp, String nombreComp, String ciudadComp, String direccionComp,
		String fotoComp, int tamañoCan, String observacionesCan, int calificacionesRes) {
	super();
	ID_Res = iDRes;
	ID_Usu = iDUsu;
	ID_Hor = iDHor;
	ID_Can = iDCan;
	Dia_Res = diaRes;
	DiaPartido_Res = diaPartidoRes;
	Precio_Res = precioRes;
	Horarios_Hor = horarioshor;
	Estado_Res = estadoRes;
	Nombre_Can = nombreCan;
	ID_Comp = iDComp;
	Nombre_Comp = nombreComp;
	Ciudad_Comp = ciudadComp;
	Direccion_Comp = direccionComp;
	Foto_Comp = fotoComp;
	Tamaño_Can = tamañoCan;
	Observaciones_Can = observacionesCan;
	Calificaciones_Res = calificacionesRes;
}

public reservasMODELO(int iDCan, String nombreCan, int iDComp,
		String nombreComp, String ciudadComp, String direccionComp,
		String fotoComp, String observacionesComp, int tamañoCan,
		int precioCan, String observacionesCan, String estadoCan, String horariosRes, int iDHor) {
	super();
	ID_Can = iDCan;
	Nombre_Can = nombreCan;
	ID_Comp = iDComp;
	Nombre_Comp = nombreComp;
	Ciudad_Comp = ciudadComp;
	Direccion_Comp = direccionComp;
	Foto_Comp = fotoComp;
	Observaciones_Comp = observacionesComp;
	Tamaño_Can = tamañoCan;
	Precio_Can = precioCan;
	Observaciones_Can = observacionesCan;
	Estado_Can = estadoCan;
	Horarios_Hor = horariosRes;
	ID_Hor = iDHor;
}




public reservasMODELO(int iDRes, String diaRes, String diaPartidoRes, int precioRes,
		String observacionesRes, String estadoRes, String usuarioRes,
		String horariosRes, String nombreCan, String nombreComp, int precio, int tamaño, String ciudad, String direccion) {
	super();
	ID_Res = iDRes;
	Dia_Res = diaRes;
	DiaPartido_Res = diaPartidoRes;
	Precio_Res = precioRes;
	Observaciones_Res = observacionesRes;
	Estado_Res = estadoRes;
	Usuario_Usu = usuarioRes;
	Horarios_Hor = horariosRes;
	Nombre_Can = nombreCan;
	Nombre_Comp = nombreComp;
	Precio_Res = precio;
	Tamaño_Can = tamaño;
	Ciudad_Comp = ciudad;
	Direccion_Comp= direccion;
}


public reservasMODELO(int iDRes, int iDUsu, int iDHor, int iDCan,
		String diaRes, String diaPartidoRes, int precioRes,
		String observacionesRes, String estadoRes) {
	super();
	ID_Res = iDRes;
	ID_Usu = iDUsu;
	ID_Hor = iDHor;
	ID_Can = iDCan;
	Dia_Res = diaRes;
	DiaPartido_Res = diaPartidoRes;
	Precio_Res = precioRes;
	Observaciones_Res = observacionesRes;
	Estado_Res = estadoRes;
}


public reservasMODELO(int iDUsu, int iDHor, int iDCan, String diaRes,
		String diaPartidoRes, int precioRes, String observacionesRes,
		String estadoRes) {
	super();
	ID_Usu = iDUsu;
	ID_Hor = iDHor;
	ID_Can = iDCan;
	Dia_Res = diaRes;
	DiaPartido_Res = diaPartidoRes;
	Precio_Res = precioRes;
	Observaciones_Res = observacionesRes;
	Estado_Res = estadoRes;
}


public reservasMODELO(int tamañoCan, String ciudadComp,
		String horariosHor, String diaPartidoRes) {
	// TODO Auto-generated constructor stub
	

	Tamaño_Can = tamañoCan;
	Ciudad_Comp = ciudadComp;
	Horarios_Hor = horariosHor ;
	DiaPartido_Res = diaPartidoRes;
}

public reservasMODELO(int tamañoCan, String ciudadComp,
		String horariosHor, String diaPartidoRes, String nombreComp) {
	// TODO Auto-generated constructor stub
	

	Tamaño_Can = tamañoCan;
	Ciudad_Comp = ciudadComp;
	Horarios_Hor = horariosHor ;
	DiaPartido_Res = diaPartidoRes;
	Nombre_Comp = nombreComp;
}


public int getID_Res() {
	return ID_Res;
}


public void setID_Res(int iDRes) {
	ID_Res = iDRes;
}


public int getID_Usu() {
	return ID_Usu;
}


public void setID_Usu(int iDUsu) {
	ID_Usu = iDUsu;
}


public int getID_Hor() {
	return ID_Hor;
}


public void setID_Hor(int iDHor) {
	ID_Hor = iDHor;
}


public int getID_Can() {
	return ID_Can;
}


public void setID_Can(int iDCan) {
	ID_Can = iDCan;
}


public String getDia_Res() {
	return Dia_Res;
}


public void setDia_Res(String diaRes) {
	Dia_Res = diaRes;
}

 
public String getDiaPartido_Res() {
	return DiaPartido_Res;
}


public void setDiaPartido_Res(String diaPartidoRes) {
	DiaPartido_Res = diaPartidoRes;
}


public int getPrecio_Res() {
	return Precio_Res;
}


public void setPrecio_Res(int precioRes) {
	Precio_Res = precioRes;
}


public String getObservaciones_Res() {
	return Observaciones_Res;
}


public void setObservaciones_Res(String observacionesRes) {
	Observaciones_Res = observacionesRes;
}


public String getEstado_Res() {
	return Estado_Res;
}


public void setEstado_Res(String estadoRes) {
	Estado_Res = estadoRes;
}

public String getUsuario_Usu() {
	return Usuario_Usu;
}


public void setUsuario_Usu(String usuarioRes) {
	Usuario_Usu = usuarioRes;
}


public String getHorarios_Hor() {
	return Horarios_Hor;
}


public void setHorarios_Hor(String horariosRes) {
	Horarios_Hor = horariosRes;
}


public String getNombre_Can() {
	return Nombre_Can;
}


public void setNombre_Can(String nombreCan) {
	Nombre_Can = nombreCan;
}



public int getID_Comp() {
	return ID_Comp;
}



public void setID_Comp(int iDComp) {
	ID_Comp = iDComp;
}



public String getNombre_Comp() {
	return Nombre_Comp;
}



public void setNombre_Comp(String nombreComp) {
	Nombre_Comp = nombreComp;
}



public String getCiudad_Comp() {
	return Ciudad_Comp;
}



public void setCiudad_Comp(String ciudadComp) {
	Ciudad_Comp = ciudadComp;
}



public String getDireccion_Comp() {
	return Direccion_Comp;
}



public void setDireccion_Comp(String direccionComp) {
	Direccion_Comp = direccionComp;
}



public String getFoto_Comp() {
	return Foto_Comp;
}



public void setFoto_Comp(String fotoComp) {
	Foto_Comp = fotoComp;
}



public String getObservaciones_Comp() {
	return Observaciones_Comp;
}



public void setObservaciones_Comp(String observacionesComp) {
	Observaciones_Comp = observacionesComp;
}



public int getTamaño_Can() {
	return Tamaño_Can;
}



public void setTamaño_Can(int tamañoCan) {
	Tamaño_Can = tamañoCan;
}



public int getPrecio_Can() {
	return Precio_Can;
}



public void setPrecio_Can(int precioCan) {
	Precio_Can = precioCan;
}



public String getObservaciones_Can() {
	return Observaciones_Can;
}



public void setObservaciones_Can(String observacionesCan) {
	Observaciones_Can = observacionesCan;
}



public String getEstado_Can() {
	return Estado_Can;
}



public void setEstado_Can(String estadoCan) {
	Estado_Can = estadoCan;
}



public String getDia_Dia() {
	// TODO Auto-generated method stub
	return null;
}


public String getCorreo_Usu() {
	return Correo_Usu;
}



public void setCorreo_Usu(String correoUsu) {
	Correo_Usu = correoUsu;
}


public int getCalificaciones_Res() {
	return Calificaciones_Res;
}


public void setCalificaciones_Res(int calificacionesRes) {
	Calificaciones_Res = calificacionesRes;
}

public int getPromedio_Comp() {
	return Promedio_Comp;
}

public void setPromedio_Comp(int promedioComp) {
	Promedio_Comp = promedioComp;
}
}


