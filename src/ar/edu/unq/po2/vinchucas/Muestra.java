package ar.edu.unq.po2.vinchucas;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Muestra {
	
	private Usuario user;
	private Ubicacion ubicacion;
	private Foto fotoDelInsecto;
	private String tipoDeVinchuca;
	private Verificacion nivelDeVerificacion;
	private ArrayList<Opinion> listaDeOpiniones;
	
	public Muestra (Usuario user, Ubicacion ubicacion, String tipoDeVinchuca){
		this.user=user;
		this.ubicacion=ubicacion;
		this.tipoDeVinchuca=tipoDeVinchuca;
		this.listaDeOpiniones= new ArrayList<Opinion>();
	}
	
	
	public Usuario getUser() {
		return user;
	}
	
	public ArrayList<Opinion> getOpiniones(){
		return listaDeOpiniones;
	}
/*	
	public Respuesta resultadoActual() {
		Integer contadorDeRespuestas = 0;
		Respuesta respuestaActual;
			for(Respuesta respueta : respuestas){
				if(contadorDeRespuestas < this.cantidadDeVecesQueApareceLa(respuesta)) {
					contadorDeRespuestas = this.cantidadDeVecesQueApareceLa(respuesta);
					respuestaActual = respueta;
				}
			}
		return respuestaActual;
	}
*/	
	public Integer cantidadDeVecesQueApareceLa(Opinion opinion) {
		Integer contador = 0;
			for(Opinion opinionActual : listaDeOpiniones) {
				if(opinionActual.nombreDelInsecto() == opinion.nombreDelInsecto()) {
					contador += 1;
				}
			}
		return contador;
	}
	
	public Integer cantidadDeVecesEL(Usuario user) {
		Integer contador = 0;
			for(Opinion opinion : listaDeOpiniones) {
				if(user == opinion.getUser()) {
					contador += 1;
				}
			}
		return contador;
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
	public String getTipoDeVinchuca(){
		return tipoDeVinchuca;
}
	}