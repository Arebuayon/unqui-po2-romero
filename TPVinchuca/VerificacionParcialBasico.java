package ar.edu.unq.po2.TPVinchuca;

public class VerificacionParcialBasico extends EstadoDeVerificacion {
	
	private static String nivel = "Medio";

	public Opinion opinionActual(Muestra muestra) {
		int contadorDeRespuestas = 0;
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
		EstadoDeVerificacion estado = new VerificadoParcialExperto();
			if(!muestra.opinaronTodosBasicos()) {
				muestra.getVerificado().setVerificado(estado);
			}else {
				if(muestra.cantidadDeBasicosQueOpinaron() > 3) {
					this.setNivelDeVerificacion("Alto");
				}
			}
	}


	@Override
	public boolean puedeOpinarSobreLa(Usuario user, Muestra muestra) {
		return /*!muestra.opinaronExpertos() && */!muestra.isMuestraVerificada() &&
				muestra.cantidadDeVecesApareceEl(user) == 0;
	}

	@Override
	public boolean yaEstaVerifacado() {
		return false;
	}


	@Override
	public String getNivelDeVerificacion() {
		return nivel;
	}
	
	public void setNivelDeVerificacion(String nuevoNivel) {
		nivel = nuevoNivel;
	}
	
}