package ar.edu.unq.po2.TPVinchuca;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Muestra {
	
	private Usuario user;
	private BufferedImage fotoDelInsecto;
	private Ubicacion ubicacion;
	private LocalDate fechaCreada;
	private Verificacion verificado = new Verificacion();
	private ArrayList<Opinion> listaDeOpiniones = new ArrayList<Opinion>();
//	private String nivelDeVerificacion; 
	
	
	
	public Muestra(Usuario user, BufferedImage fotoDelInsecto, Ubicacion ubicacion,Opinion opinion) {
		
		this.user = user;
		this.fotoDelInsecto = fotoDelInsecto;
		this.ubicacion = ubicacion;
		this.fechaCreada = LocalDate.now();
		this.listaDeOpiniones.add(opinion);
	}

	public void setFechaCreada(LocalDate fechaCreada) {
		this.fechaCreada = fechaCreada;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacionActual) {
		this.ubicacion = ubicacionActual;
	}
	
	public String getNivelDeVerificacion(){
		return this.getVerificado().getVerificado().getNivelDeVerificacion();
	}
	
	public BufferedImage getFotoDelInsecto() {
		return fotoDelInsecto;
	}

	public Usuario getUser() {
		return user;
	}
	
	public ArrayList<Opinion> getOpiniones(){
		return listaDeOpiniones;
	}
	
	public LocalDate getFechaCreada() {
		return fechaCreada;
	}

	public Verificacion getVerificado() {
		return verificado;
	}

	public void setVerificado(Verificacion verificado) {
		this.verificado = verificado;
		
	}
	
	public Opinion opinionActual() {
		return this.getVerificado().opinionActual(this);
	}
	
	public String respuestaDeLaOpnionActual() {
		return this.opinionActual().getRespuesta().nombreDelInsectoORespuesta();
	}

	public int cantidadDeVecesQueApareceLaDeExpertos(Opinion opinion) {
		int contador = 0;
			for(Opinion opinionActual : listaDeOpiniones) {
				if(opinionActual.nombreDelInsecto() == opinion.nombreDelInsecto()
					&& opinionActual.tipoDeConocimientoAlaHoraDeOpinar() == "Experto") {
					contador += 1;
				}
			}
		return contador;
	}
	
	
	public int cantidadDeVecesQueApareceLa(Opinion opinion) {
		int contador = 0;
			for(Opinion opinionActual : listaDeOpiniones) {
				if(opinionActual.nombreDelInsecto() == opinion.nombreDelInsecto()) {
					contador += 1;
				}
			}
		return contador;
	}
	
	public int cantidadDeVecesApareceEl(Usuario user) {
		int contador = 0;
			for(Opinion opinion : listaDeOpiniones) {
				if(user == opinion.getUser()) {
					contador += 1;
				}
			}
		return contador;
	}
	
	public ArrayList<Opinion> listaDeOpinionesDe(Usuario user){
		ArrayList<Opinion> OpinionesDe = new ArrayList<Opinion>();
		 	for(Opinion respueta : this.getOpiniones()){
		 		if(respueta.getUser() == user) {
		 			OpinionesDe.add(respueta);
		 		}
		 	}
		 return OpinionesDe ;
	}
	
	public Opinion OpinionDe(Usuario user){
		Opinion respuestaActual = null;
		 	for(Opinion respuesta : this.getOpiniones()){
		 		if(respuesta.getUser().getIdUser() == user.getIdUser()) {
					respuestaActual = respuesta;
	 				}
		 	}
		 return respuestaActual;
	}
		
	public int cantidadDeExpertosQueOpinaron(){
		int contador = 0;
		 	for(Opinion respueta : this.getOpiniones()){
		 		if(respueta.tipoDeConocimientoAlaHoraDeOpinar() == "Experto") {
		 			contador += 1;
		 		}
		 	}
		 return contador;
	}
	
	public int cantidadDeBasicosQueOpinaron(){
		int contador = 0;
		 	for(Opinion respueta : this.getOpiniones()){
		 		if(respueta.tipoDeConocimientoAlaHoraDeOpinar() == "Basico") {
		 			contador += 1;
		 		}
		 	}
		 return contador;
	}
	
	public boolean opinaronExpertos() {
		return  this.getOpiniones().stream().anyMatch
				(opinion -> opinion.tipoDeConocimientoAlaHoraDeOpinar() == "Experto");
	}
	
	public boolean opinaronTodosBasicos() {
		return  this.getOpiniones().stream().allMatch
				(opinion -> opinion.tipoDeConocimientoAlaHoraDeOpinar() == "Basico");
	}
	
	public void cambiarEstadoVerificacion() {
		this.getVerificado().verificar(this);
	}
	
	public boolean isMuestraVerificada() {
		return this.getVerificado().muestraYaVerificada();
	}
/*	
	public void opinarSobreLaMuestra(Opinion opinion) {
		if(this.getVerificado().getTipoDeEstado().puedeOpinarSobreLa(opinion.getUser,this)) {
			this.getOpiniones().add(opinion);
			this.cambiarEstadoVerificacion();
		}
	}
	
	
	public void opinarSobreLaMuestra(Opinion opinion) {
		if(this.getVerificado().puedeOpinarSobreLa(opinion.getUser(), this)) {
			this.getOpiniones().add(opinion);
			this.cambiarVerificacion();
		}
	}	
*/	
	public LocalDate getFechaDeUltimaVotacion() {
		LocalDate maxDate = this.fechasDeOpiniones().stream()
                .max( Comparator.comparing( LocalDate::toEpochDay ) )
                .get();
		return maxDate;
	}

	private List<LocalDate> fechasDeOpiniones() {
		return this.getOpiniones().stream().map(opinion -> opinion.getFechaEnviada()).collect(Collectors.toList());
	}
	 
}
