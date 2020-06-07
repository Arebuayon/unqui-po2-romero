package ar.edu.unq.po2.TPVichuca;

import java.util.ArrayList;

	public class ZonaDeCobertura {
		private String nombre;
		private Ubicacion epicentro;
		private Integer radio;
		private ArrayList<Organizacion> organizacionesSuscribidas;	

	public String getNombre(){
		return nombre;
	}

	public Ubicacion getEpicentro(){
		return epicentro;
	}

	public Integer getRadio() {
		return radio;
	}

	private boolean esZonaSolapada(ZonaDeCobertura otraZonaDeCobertura) {
		Ubicacion ubicacion1 = this.getEpicentro();
		Ubicacion ubicacion2 = otraZonaDeCobertura.getEpicentro();
	
		return(sumarRadios(this , otraZonaDeCobertura ) > (ubicacion1.distanciaAOtraUbicacion(ubicacion2)));		
	}


	private Integer sumarRadios(ZonaDeCobertura zonaDeCobertura, ZonaDeCobertura otraZonaDeCobertura) {
		return (zonaDeCobertura.getRadio() + otraZonaDeCobertura.getRadio());
	}


	public ArrayList<ZonaDeCobertura> zonasSolapadas(ArrayList<ZonaDeCobertura> zonas){
		ArrayList<ZonaDeCobertura> zonasSolapadas = new ArrayList<ZonaDeCobertura>();
		for (ZonaDeCobertura zona : zonas) {
			if (this.esZonaSolapada(zona)){
				zonasSolapadas.add(zona);
			}
		}	
		
		return zonasSolapadas;
	
	}

	public void suscribirOrganizacion(Organizacion organizacion) {
		this.organizacionesSuscribidas.add(organizacion);
	}

	public void notificarOrganizacionesPorNuevaMuestra(Muestra muestra) {
		
		this.organizacionesSuscribidas.forEach(organizacion -> organizacion.ejecutarFuncionalidadDeNuevaMuestra(muestra, this));
	}



}