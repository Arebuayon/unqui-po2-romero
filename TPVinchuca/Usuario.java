package ar.edu.unq.po2.TPVinchuca;

public class Usuario {
	
	private int idUser;
	private Ubicacion ubicacion;
	private Conocimiento conocimiento;
	
	public Usuario(int idUser, Ubicacion ubicacion) {
		
		this.idUser = idUser;
		this.ubicacion = ubicacion;
	}

	public int getIdUser() {
		return idUser;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Conocimiento getConocimiento() {
		return conocimiento;
	}
	
	public String tipoDeConocimiento() {
		return conocimiento.getTipoDeConocimiento();
	}

	public void setConocimiento(Conocimiento conocimiento) {
		this.conocimiento = conocimiento;
	}
	
	public void enviarMuestra(Muestra muestra) {
		ConfiguracionHistorial.getConfiguracion().getHistorial().agregarMuestra(muestra);
		this.recibirEvaluacionDeConocimiento(ConfiguracionHistorial.getConfiguracion().getHistorial(), this);
	}
	
	public void opinarSobreLaMuestra(Muestra muestra,Opinion opinion) {
		this.getConocimiento().valorarMuestra(this, muestra, opinion);
		this.recibirEvaluacionDeConocimiento(ConfiguracionHistorial.getConfiguracion().getHistorial(), this);
		
	}
	
	public void recibirEvaluacionDeConocimiento(Historial historial,Usuario user) {
		historial.getEvaluador().reClasificarUsuario(this, historial);
	}

}