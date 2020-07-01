package ar.edu.unq.po2.TPVinchuca;

import java.time.LocalDate;
//import java.util.Calendar;

public class Opinion {

	private Usuario user;
	private LocalDate fechaEnviada;
	private IClasificacion respuesta;
	private String hechoPorUn;

	public Opinion(Usuario user, IClasificacion respuesta) {
		this.user = user;
		this.setRespuesta(respuesta);
		this.fechaEnviada = LocalDate.now();
		this.hechoPorUn = user.getConocimiento().getTipoDeConocimiento();
	}
	public LocalDate getFechaEnviada() {
		return fechaEnviada;
	}

	public void setFechaEnviada(LocalDate fechaEnviada) {
		this.fechaEnviada = fechaEnviada;
	}
	
	public Usuario getUser() {
		return user;
	}

	public IClasificacion getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(IClasificacion respuesta) {
		this.respuesta = respuesta;
	}
	
	public String tipoDeConocimientoAlaHoraDeOpinar() {
		return hechoPorUn;
	}
//	 public void settipoDeConocimientoAlaHoraDeOpinar(String tipoDeConocimiento) {
//		this.hechoPorUn = tipoDeConocimiento;
//	}
	
	public String nombreDelInsecto(){ 
		return this.getRespuesta().nombreDelInsectoORespuesta();
	}

}
