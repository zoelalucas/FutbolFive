package modelo;

public class diasMODELO {

	int ID_Dia;
	int ID_Comp;
	int ID_Hor;
	String Dia_Dia;
	String Estado_Dia;
	
	public diasMODELO(int iDDia, int iDComp, int iDHor, String diaDia,
			String estadoDia) {
		super();
		ID_Dia = iDDia;
		ID_Comp = iDComp;
		ID_Hor = iDHor;
		Dia_Dia = diaDia;
		Estado_Dia = estadoDia;
	}

	public int getID_Dia() {
		return ID_Dia;
	}

	public void setID_Dia(int iDDia) {
		ID_Dia = iDDia;
	}

	public int getID_Comp() {
		return ID_Comp;
	}

	public void setID_Comp(int iDComp) {
		ID_Comp = iDComp;
	}

	public int getID_Hor() {
		return ID_Hor;
	}

	public void setID_Hor(int iDHor) {
		ID_Hor = iDHor;
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
	
}
