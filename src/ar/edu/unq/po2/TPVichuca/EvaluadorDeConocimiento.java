package ar.edu.unq.po2.TPVichuca;


public class EvaluadorDeConocimiento {
	
		
	public boolean esExperto(Historial historial, Usuario user) { 
		
		return historial.cantidadDeMuestrasHace30DiasDe(user) > 10 
				&& historial.cantidadDeOpinionesHace30DiasDe(user) >20;
	}	
	
	public void reClasificarUsuario(Usuario user , Historial historial){ 
		if(this.esExperto(historial, user)) {
			user.setConocimiento(new ConocimientoExperto());
		
		}	
	}
	
}
