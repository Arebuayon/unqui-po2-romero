package ar.edu.unq.po2.TPVinchuca;

public class Verificacion {
	
	private EstadoDeVerificacion verificado = new NoVerificado();//NoVerificado
	

	public Verificacion() {
		super();
	}
	
	public String nivelDeVerificacion() {
		return this.getVerificado().getNivelDeVerificacion();
	}
	
	public EstadoDeVerificacion getVerificado() {
		return verificado;
	}


	public void setVerificado(EstadoDeVerificacion verificado) {
		this.verificado = verificado;
	}
	
	public void verificar(Muestra muestra) {
		this.getVerificado().verificar(muestra);
		ConfiguracionHistorial.getConfiguracion().getHistorial().notificarZonasPorNuevaValidacion(muestra);
		
	}
	
	public Opinion opinionActual(Muestra muestra) {
		return this.getVerificado().opinionActual(muestra);
	}

	public boolean muestraYaVerificada() {
		return this.getVerificado().yaEstaVerifacado();
	}
	
}