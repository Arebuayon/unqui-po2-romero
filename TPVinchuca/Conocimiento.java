package ar.edu.unq.po2.TPVinchuca;

public abstract class Conocimiento  {
	
	public Conocimiento() {
		super();
	}

	public abstract String getTipoDeConocimiento();

	public boolean muestraActaParaValorar(Usuario user,Muestra muestra) {
		return muestra.getUser().getIdUser() != user.getIdUser();
	}	

	
	public abstract void valorarMuestra(Usuario user,Muestra muestra,Opinion opinion); 
	
	
}

