package ar.edu.unq.po2.TPVichuca;


public class EvaluadorDeConocimiento {
	
		
	public boolean esExperto(Historial historial, Usuario user) { 
		
		return historial.muestrasHace30DiasDe(user).size() > 10 
				&& historial.opinionesHace30DiasDe(user).size() >20;
	}	
	
	public void reClasificarUsuario(Usuario user , Historial historial){ 
		if(this.esExperto(historial, user)) {
			user.setConocimiento(new ConocimientoExperto());
		
		}	
	}
	
}
