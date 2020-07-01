package ar.edu.unq.po2.TPVinchuca;



public class ConocimientoExperto extends Conocimiento{

	public ConocimientoExperto() {
		super();
	}
	
	@Override
	public String getTipoDeConocimiento() {
		return "Experto";
	}
	
	public void valorarMuestra(Usuario user,Muestra muestra,Opinion opinion) {
		if(muestra.getVerificado().getVerificado().puedeOpinarSobreLa(user,muestra) 
				&& this.muestraActaParaValorar(user, muestra)) {
					muestra.getOpiniones().add(opinion);
					muestra.cambiarEstadoVerificacion();
		}
	}





}
