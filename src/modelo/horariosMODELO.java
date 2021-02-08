package modelo;

public class horariosMODELO {

	int ID_Hor;
	int ID_Comp;
	String Horarios_Hor;
	String Estado_Hor;
	
	
	public horariosMODELO(int iDHor, int iDComp, String horariosHor,
			String estadoHor) {
		super();
		ID_Hor = iDHor;
		ID_Comp = iDComp;
		Horarios_Hor = horariosHor;
		Estado_Hor = estadoHor;
	}


	public horariosMODELO(int iDComp, String horariosHor, String estadoHor) {
		super();
		ID_Comp = iDComp;
		Horarios_Hor = horariosHor;
		Estado_Hor = estadoHor;
	}


	public int getID_Hor() {
		return ID_Hor;
	}


	public void setID_Hor(int iDHor) {
		ID_Hor = iDHor;
	}


	public int getID_Comp() {
		return ID_Comp;
	}


	public void setID_Comp(int iDComp) {
		ID_Comp = iDComp;
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

}