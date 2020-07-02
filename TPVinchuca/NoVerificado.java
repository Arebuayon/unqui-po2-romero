package ar.edu.unq.po2.TPVinchuca;

public class NoVerificado extends EstadoDeVerificacion {

	public Opinion opinionActual(Muestra muestra) {
		int contadorDeRespuestas = 1;
		RespuestaNoDefinida respuesta = new RespuestaNoDefinida();
		Opinion opinionActual = new Opinion(muestra.getUser(),respuesta);
			for(Opinion opinion : muestra.getOpiniones()){
				if(contadorDeRespuestas < muestra.cantidadDeVecesQueApareceLa(opinion)) {
					contadorDeRespuestas = muestra.cantidadDeVecesQueApareceLa(opinion);
					opinionActual = opinion;
				}
			}
	return opinionActual;
	}
	
	public void verificar(Muestra muestra) {
		if(muestra.opinaronTodosBasicos()) {
			EstadoDeVerificacion estado = new VerificacionParcialBasico();
			muestra.setVerificado(estado);
		}else{
			if(muestra.opinaronExpertos()) {
				EstadoDeVerificacion estado2 = new VerificadoParcialExperto();
				muestra.setVerificado(estado2);
			}
		}
	}


	@Override
	public boolean puedeOpinarSobreLa(Usuario user, Muestra muestra) {
		return muestra.cantidadDeVecesApareceEl(user) == 0;
	}

	@Override
	public boolean yaEstaVerifacado() {
		return false;
	}

	@Override
	public String getNivelDeVerificacion() {
		return "Bajo";
	}

	
}