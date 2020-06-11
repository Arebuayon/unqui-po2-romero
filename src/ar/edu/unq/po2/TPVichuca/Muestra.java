package ar.edu.unq.po2.TPVichuca;

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
	private Verificacion verificado;
	private ArrayList<Opinion> listaDeOpiniones = new ArrayList<Opinion>();
	private String nivelDeVerificacion; 
	
	
	
	public Muestra(Usuario user, BufferedImage fotoDelInsecto, Ubicacion ubicacion,Opinion opinion) {
		
		this.user = user;
		this.fotoDelInsecto = fotoDelInsecto;
		this.ubicacion = ubicacion;
		this.fechaCreada = LocalDate.now();
		this.listaDeOpiniones.add(opinion);
		this.verificado = new VerificacionBasica();
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void setNivelDeVerificacion(String nivel){
		this.nivelDeVerificacion = nivel;
		
	}
	
	public String getNivelDeVerificacion(){
		return this.nivelDeVerificacion;
	}
	public BufferedImage getFotoDelInsecto() {
		return fotoDelInsecto;
	}

	public void setFotoDelInsecto(BufferedImage fotoDelInsecto) {
		this.fotoDelInsecto = fotoDelInsecto;
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

	public void setFechaCreada(LocalDate fechaCreada) {
		this.fechaCreada = fechaCreada;
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
	

	public Integer cantidadDeVecesQueApareceLa(Opinion opinion) {
		Integer contador = 0;
			for(Opinion opinionActual : listaDeOpiniones) {
				if(opinionActual.nombreDelInsecto() == opinion.nombreDelInsecto()) {
					contador += 1;
				}
			}
		return contador;
	}
	
	public Integer cantidadDeVecesApareceEl(Usuario user) {
		Integer contador = 0;
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
		
	public Integer cantidadDeExpertosQueOpinaron(){
		Integer contador = 0;
		 	for(Opinion respueta : this.getOpiniones()){
		 		if(respueta.getUser().getConocimiento().getTipoDeConocimiento() == "Experto") {
		 			contador += 1;
		 		}
		 	}
		 return contador;
	}
	
	public void cambiarVerificacion() {
		this.getVerificado().cambiarTipoDeVerificacion(this);
	}
	
	public boolean isMuestraVerificada() {
		return this.getVerificado().isVerificado();
	}
	
	public void opinarSobreLaMuestra(Opinion opinion) {
		if(this.getVerificado().puedeOpinarSobreLa(opinion.getUser(), this)) {
			this.getOpiniones().add(opinion);
			this.cambiarVerificacion();
		}
	}
	
	public void verificarMuestra() {
		this.getVerificado().verificar(this);
	}

		
	
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
