package ar.edu.unq.po2.TPVinchuca;

import java.util.ArrayList;

public class VerificadoParcialExperto extends EstadoDeVerificacion {

	public boolean masDe2votoPorUnaOpinion(Muestra muestra) {
		Opinion opinionActual = this.opinionActual(muestra);
		int contador = 0;
			for(Opinion opinion : this.opinionesDeUsuariosExpertos(muestra)) {
				if(opinionActual.nombreDelInsecto() == opinion.nombreDelInsecto()) {
					contador += 1;
				}
			}
		return contador > 1;
	}
	
	@Override
	public void verificar(Muestra muestra) {
		EstadoDeVerificacion estado = new Verificado();
		if(this.masDe2votoPorUnaOpinion(muestra)) {
			muestra.setVerificado(estado);
		}
	}

	@Override
	public boolean puedeOpinarSobreLa(Usuario user, Muestra muestra) {
		return muestra.cantidadDeVecesApareceEl(user) == 0  &&
				user.tipoDeConocimiento() == "Experto";
	}

	public ArrayList<Opinion> opinionesDeUsuariosExpertos(Muestra muestra) {
		 ArrayList<Opinion> opiniones = new  ArrayList<Opinion>();
		 	for(Opinion respueta : muestra.getOpiniones()){
		 		if(respueta.tipoDeConocimientoAlaHoraDeOpinar() == "Experto") {
		 			opiniones.add(respueta);
		 		}
		 	}
		 return opiniones;
	}
	
	public Opinion opinionActual(Muestra muestra) {
		int contadorDeRespuestas = 1;
		RespuestaNoDefinida respuesta = new RespuestaNoDefinida();
		Opinion opinionActual = new Opinion(muestra.getUser(),respuesta);
			for(Opinion opinion : this.opinionesDeUsuariosExpertos(muestra) ){
				if(contadorDeRespuestas < muestra.cantidadDeVecesQueApareceLaDeExpertos(opinion)) {
					contadorDeRespuestas = muestra.cantidadDeVecesQueApareceLaDeExpertos(opinion);
					opinionActual = opinion;
				}
			}
		return opinionActual;
	}
	
	
	@Override
	public boolean yaEstaVerifacado() {
		return false;
	}

	@Override
	public String getNivelDeVerificacion() {
		return "Medio";
	}

}