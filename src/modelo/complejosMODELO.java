package modelo;

public class complejosMODELO {
	String Usuario_Usu;
	int Promedio_Comp;
	int ID_Comp;
	int ID_Usu;
	String Nombre_Comp;
	String Ciudad_Comp;
	String Direccion_Comp;
	String Foto_Comp;
	String Observaciones_Comp;
	String Estado_Comp;
	//horarios
	int ID_Hor;
	String Horarios_Hor;
	String Estado_Hor;
	//dias
	int ID_Dia;
	String Dia_Dia;
	String Estado_Dia;
	


	public complejosMODELO(int iDComp, int iDHor, String horariosHor) {
		super();
		ID_Comp = iDComp;
		ID_Hor = iDHor;
		Horarios_Hor = horariosHor;
	}


	public complejosMODELO(int iDComp, String diaDia) {
		super();
		ID_Comp = iDComp;
		Dia_Dia = diaDia;
	}


	public complejosMODELO(String diaDia) {
		super();
		Dia_Dia = diaDia;
	}

	public complejosMODELO(int iDUsu, String nombreComp, String ciudadComp,
			String direccionComp, String fotoComp, String observacionesComp,
			String estadoComp, String horariosHor, String estadoHor)
	{
		super();
		ID_Usu = iDUsu;
		Nombre_Comp = nombreComp;
		Ciudad_Comp = ciudadComp;
		Direccion_Comp = direccionComp;
		Foto_Comp = fotoComp;
		Observaciones_Comp = observacionesComp;
		Estado_Comp = estadoComp;
		Horarios_Hor = horariosHor;
		Estado_Hor = estadoHor;

	}
	
	public complejosMODELO (String Usuario_Usu, int ID_Comp, int ID_Usu, String Nombre_Comp,
			String Ciudad_Comp, String Direccion_Comp, String Foto_Comp,
			String Observaciones_Comp, String Estado_Comp, int Promedio_Comp) {
		super();
		this.Usuario_Usu = Usuario_Usu;
		this.ID_Comp = ID_Comp;
		this.ID_Usu = ID_Usu;
		this.Nombre_Comp = Nombre_Comp;
		this.Ciudad_Comp = Ciudad_Comp;
		this.Direccion_Comp = Direccion_Comp;
		this.Foto_Comp = Foto_Comp;
		this.Observaciones_Comp = Observaciones_Comp;
		this.Estado_Comp = Estado_Comp;
		this.Promedio_Comp = Promedio_Comp;

	}
	

	public complejosMODELO (int ID_Comp, int ID_Usu, String Nombre_Comp,
			String Ciudad_Comp, String Direccion_Comp, String Foto_Comp,
			String Observaciones_Comp, String Estado_Comp) {
		super();
		this.ID_Comp = ID_Comp;
		this.ID_Usu = ID_Usu;
		this.Nombre_Comp = Nombre_Comp;
		this.Ciudad_Comp = Ciudad_Comp;
		this.Direccion_Comp = Direccion_Comp;
		this.Foto_Comp = Foto_Comp;
		this.Observaciones_Comp = Observaciones_Comp;
		this.Estado_Comp = Estado_Comp;
	}
	
	public complejosMODELO (int ID_Usu, String Nombre_Comp,
			String Ciudad_Comp, String Direccion_Comp, String Foto_Comp,
			String Observaciones_Comp, String Estado_Comp) {
		super();
		this.ID_Usu = ID_Usu;
		this.Nombre_Comp = Nombre_Comp;
		this.Ciudad_Comp = Ciudad_Comp;
		this.Direccion_Comp = Direccion_Comp;
		this.Foto_Comp = Foto_Comp;
		this.Observaciones_Comp = Observaciones_Comp;
		this.Estado_Comp = Estado_Comp;
	}


	public int getID_Comp() {
		return ID_Comp;
	}
	public void setID_Comp(int ID_Comp) {
		this.ID_Comp = ID_Comp;
	}
	public int getID_Usu() {
		return ID_Usu;
	}
	public void setID_Usu(int ID_Usu) {
		this.ID_Usu = ID_Usu;
	}
	public String getNombre_Comp() {
		return Nombre_Comp;
	}
	public void setNombre_Comp(String Nombre_Comp) {
		this.Nombre_Comp = Nombre_Comp;
	}
	public String getCiudad_Comp() {
		return Ciudad_Comp;
	}
	public void setCiudad_Comp(String Ciudad_Comp) {
		this.Ciudad_Comp = Ciudad_Comp;
	}
	public String getDireccion_Comp() {
		return Direccion_Comp;
	}
	public void setDireccion_Comp(String Direccion_Comp) {
		this.Direccion_Comp = Direccion_Comp;
	}
	public String getFoto_Comp() {
		return Foto_Comp;
	}
	public void setFoto_Comp(String Foto_Comp) {
		this.Foto_Comp = Foto_Comp;
	}
	public String getObservaciones_Comp() {
		return Observaciones_Comp;
	}
	public void setObservaciones_Comp(String Observaciones_Comp) {
		this.Observaciones_Comp = Observaciones_Comp;
	}
	
	public String getEstado_Comp() {
		return Estado_Comp;
	}

	public void setEstado_Comp(String estadoComp) {
		Estado_Comp = estadoComp;
	}

	public int getID_Hor() {
		return ID_Hor;
	}

	public void setID_Hor(int iDHor) {
		ID_Hor = iDHor;
	}

	

	public String getHorarios_Hor() {
		return Horarios_Hor;
	}


	public void setHorarios_Hor(String horariosHor) {
		Horarios_Hor = horariosHor;
	}


	public String getEstado_Hor() {
		return Estado_Hor;
	}


	public void setEstado_Hor(String estadoHor) {
		Estado_Hor = estadoHor;
	}


	public int getID_Dia() {
		return ID_Dia;
	}

	public void setID_Dia(int iDDia) {
		ID_Dia = iDDia;
	}

	public String getDia_Dia() {
		return Dia_Dia;
	}

	public void setDia_Dia(String diaDia) {
		Dia_Dia = diaDia;
	}

	public String getEstado_Dia() {
		return Estado_Dia;
	}

	public void setEstado_Dia(String estadoDia) {
		Estado_Dia = estadoDia;
	}
	
	public String getUsuario_Usu() {
		return Usuario_Usu;
	}
	public void setUsuario_Usu(String usuarioUsu) {
		Usuario_Usu = usuarioUsu;
	}
	
	public int getPromedio_Comp() {
		return Promedio_Comp;
	}
	public void setPromedio_Comp(int promedioComp) {
		Promedio_Comp = promedioComp;
	}
}