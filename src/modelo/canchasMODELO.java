package modelo;

public class canchasMODELO {
	int ID_Can;
	int ID_Comp;
	String Nombre_Comp;
	String Nombre_Can;
	int Tamaño_Can;
	int Precio_Can;
	String Observaciones_Can;
	String Estado_Can;
	


	public canchasMODELO(int iDCan, int iDComp, String nombreComp,
			String nombreCan, int tamañoCan, int precioCan,
			String observacionesCan, String estadoCan) {
		super();
		ID_Can = iDCan;
		ID_Comp = iDComp;
		Nombre_Comp = nombreComp;
		Nombre_Can = nombreCan;
		Tamaño_Can = tamañoCan;
		Precio_Can = precioCan;
		Observaciones_Can = observacionesCan;
		Estado_Can = estadoCan;
	}


	public canchasMODELO(int iDCan, int iDComp, String nombreCan,
			int tamañoCan, int precioCan, String observacionesCan,
			String estadoCan) {
		super();
		ID_Can = iDCan;
		ID_Comp = iDComp;
		Nombre_Can = nombreCan;
		Tamaño_Can = tamañoCan;
		Precio_Can = precioCan;
		Observaciones_Can = observacionesCan;
		Estado_Can = estadoCan;
		
	}
	
	
	public canchasMODELO(int iDComp, String nombreCan, int tamañoCan,
			int precioCan, String observacionesCan, String estadoCan) {
		super();
		ID_Comp = iDComp;
		Nombre_Can = nombreCan;
		Tamaño_Can = tamañoCan;
		Precio_Can = precioCan;
		Observaciones_Can = observacionesCan;
		Estado_Can = estadoCan;
	}





	public canchasMODELO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getID_Can() {
		return ID_Can;
	}
	public void setID_Can(int iDCan) {
		ID_Can = iDCan;
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

	public String getNombre_Can() {
		return Nombre_Can;
	}
	public void setNombre_Can(String nombreCan) {
		Nombre_Can = nombreCan;
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
	
	

}
