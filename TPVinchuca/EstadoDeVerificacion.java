package ar.edu.unq.po2.TPVinchuca;

public abstract class EstadoDeVerificacion {
	
	public abstract void verificar(Muestra muestra);
	public abstract boolean puedeOpinarSobreLa(Usuario user ,Muestra muestra);
	public abstract Opinion opinionActual(Muestra muestra);
	public abstract boolean yaEstaVerifacado();
	public abstract String getNivelDeVerificacion();


}
