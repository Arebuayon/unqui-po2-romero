package ar.edu.unq.po2.TPVinchuca;


public class ConocimientoBasico extends Conocimiento {
	
	public ConocimientoBasico() {
		super();
	}

	@Override
	public String getTipoDeConocimiento() {
		return "Basico";
	}
	
	public void valorarMuestra(Usuario user,Muestra muestra,Opinion opinion) {
		if(muestra.getVerificado().puedeOpinarSobreLa(user,muestra)
			&& this.muestraActaParaValorar(user, muestra)) {
				muestra.getOpiniones().add(opinion);
				muestra.cambiarEstadoVerificacion();
		}
	}



	
	
}