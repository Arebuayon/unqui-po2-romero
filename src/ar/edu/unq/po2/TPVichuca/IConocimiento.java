package ar.edu.unq.po2.TPVichuca;
//Termino por no usarse, pero se creo por si pudiese existir un tipo de conocimiento que no herede de los otros.
public interface IConocimiento {
	
	public String getTipoDeConocimiento();
	public abstract void valorarMuestra(Usuario user,Muestra muestra,Opinion opinion);
	
	

}
