package ar.edu.unq.po2.TPVinchuca;

public class Verificado extends VerificadoParcialExperto {

	public void verificar(Muestra muestra) {
	}

	public boolean puedeOpinarSobreLa(Usuario user, Muestra muestra) {
		return false;
	}
/*	
	public ArrayList<Opinion> OpinionesDeUsuarios(Muestra muestra) {
		 ArrayList<Opinion> opiniones = new  ArrayList<Opinion>();
		 	for(Opinion respueta : muestra.getOpiniones()){
		 		if(respueta.getUser().tipoDeConocimiento() == "Experto") {
		 			opiniones.add(respueta);
		 		}
		 	}
		 return opiniones;
	}
	public Opinion opinionActual(Muestra muestra) {
		int contadorDeRespuestas = 0;
		RespuestaNoDefinida respuesta = new RespuestaNoDefinida();
		Opinion opinionActual = new Opinion(muestra.getUser(),respuesta);
			for(Opinion opinion : this.OpinionesDeUsuarios(muestra) ){
				if(contadorDeRespuestas < muestra.cantidadDeVecesQueApareceLa(opinion)) {
					contadorDeRespuestas = muestra.cantidadDeVecesQueApareceLa(opinion);
					opinionActual = opinion;
				}
			}
		return opinionActual;
	}
*/
	@Override
	public boolean yaEstaVerifacado() {
		return true;
	}
	
	public String getNivelDeVerificacion() {
		return "Alto";
	}
	
}
