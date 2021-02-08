package modelo;

public class usuariosMODELO {
	
	int ID_Usu;
	String Usuario_Usu;
	String Contraseña_Usu;
	String Correo_Usu;
	String Nivel_Usu;
	int Estado_Usu;
	
	public usuariosMODELO(int ID_Usu, String Usuario_Usu, String Nivel_Usu) {
		super();
		this.ID_Usu = ID_Usu;
		this.Usuario_Usu = Usuario_Usu;
		this.Nivel_Usu = Nivel_Usu;
	}

	public usuariosMODELO(int ID_Usu, String Usuario_Usu, String Contraseña_Usu, String Nivel_Usu) {
		super();
		this.ID_Usu = ID_Usu;
		this.Usuario_Usu = Usuario_Usu;
		this.Contraseña_Usu = Contraseña_Usu;
		this.Nivel_Usu = Nivel_Usu;
	}

	public usuariosMODELO(String Usuario_Usu, String Contraseña_Usu) {
		super();
		this.Usuario_Usu = Usuario_Usu;
		this.Contraseña_Usu = Contraseña_Usu;
	}

	public usuariosMODELO(String Usuario_Usu, String Contraseña_Usu, String Nivel_Usu, int Estado_Usu) {
		super();
		this.Usuario_Usu = Usuario_Usu;
		this.Contraseña_Usu = Contraseña_Usu;
		this.Nivel_Usu = Nivel_Usu;
		this.Estado_Usu = Estado_Usu;
	}
	
	public usuariosMODELO(int ID_Usu, String Usuario_Usu, String Contraseña_Usu, String Correo_Usu,String Nivel_Usu
			, int Estado_Usu) {
		super();
		this.ID_Usu = ID_Usu;
		this.Usuario_Usu = Usuario_Usu;
		this.Contraseña_Usu = Contraseña_Usu;
		this.Correo_Usu = Correo_Usu;
		this.Nivel_Usu = Nivel_Usu;
		this.Estado_Usu = Estado_Usu;
	}
	public usuariosMODELO(String Usuario_Usu, String Contraseña_Usu, String Nivel_Usu, String Correo_Usu,
			int Estado_Usu) {
		super();
		this.Usuario_Usu = Usuario_Usu;
		this.Contraseña_Usu = Contraseña_Usu;
		this.Nivel_Usu = Nivel_Usu;
		this.Correo_Usu = Correo_Usu;
		this.Estado_Usu = Estado_Usu;
	}


	public int getID_Usu() {
		return ID_Usu;
	}
	public void setID_Usu(int ID_Usu) {
		this.ID_Usu = ID_Usu;
	}
	public String getUsuario_Usu() {
		return Usuario_Usu;
	}
	public void setusuario(String Usuario_Usu) {
		this.Usuario_Usu = Usuario_Usu;
	}
	public String getContraseña_Usu() {
		return Contraseña_Usu;
	}
	public void setContraseña_Usu(String Contraseña_Usu) {
		this.Contraseña_Usu = Contraseña_Usu;
	}
	public String getCorreo_Usu() {
		return Correo_Usu;
	}
	public void setcorreo(String Correo_Usu) {
		this.Correo_Usu = Correo_Usu;
	}
	public String getNivel_Usu() {
		return Nivel_Usu;
	}
	public void setnivel(String Nivel_Usu) {
		this.Nivel_Usu = Nivel_Usu;
	}

	public int getEstado_Usu() {
		return Estado_Usu;
	}
	public void setEstado_Usu(int Estado_Usu) {
		this.Estado_Usu = Estado_Usu;
	}

}
