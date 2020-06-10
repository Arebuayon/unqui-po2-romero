package ar.edu.unq.po2.TPVichuca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

	public class ZonaDeCobertura {
		private String nombre;
		private Ubicacion epicentro;
		private Integer radio;
		private ArrayList<Organizacion> organizacionesSuscribidas;	

	public ZonaDeCobertura(String nombre , Ubicacion ubicacion , Integer radio) {
		this.nombre = nombre;
		this.epicentro = ubicacion;
		this.radio = radio;
		this.organizacionesSuscribidas = new ArrayList<Organizacion>();
		
	}
		
		
	public String getNombre(){
		return nombre;
	}

	public Ubicacion getEpicentro(){
		return this.epicentro;
	}

	public Integer getRadio() {
		return radio;
	}
	public ArrayList<Organizacion> getOrganizacionesSuscribidas(){
		return this.organizacionesSuscribidas;
		
	}
	public boolean esZonaSolapada(ZonaDeCobertura otraZonaDeCobertura) {
		Ubicacion ubicacion1 = this.getEpicentro();
		Ubicacion ubicacion2 = otraZonaDeCobertura.getEpicentro();
	
		return(sumarRadios(this , otraZonaDeCobertura ) > (ubicacion1.distanciaAOtraUbicacion(ubicacion2)));		
		
	}


	private Integer sumarRadios(ZonaDeCobertura zonaDeCobertura, ZonaDeCobertura otraZonaDeCobertura) {
		return (zonaDeCobertura.getRadio() + otraZonaDeCobertura.getRadio());
	}


	public List<ZonaDeCobertura> zonasSolapadas(ArrayList<ZonaDeCobertura> zonas){
		return zonas.stream().filter(zona -> zona.esZonaSolapada(this)).collect(Collectors.toList());
	}

	public void suscribirOrganizacion(Organizacion organizacion) {
		this.organizacionesSuscribidas.add(organizacion);
	}

	public void notificarOrganizacionesPorNuevaMuestra(Muestra muestra) {
		
		this.organizacionesSuscribidas.forEach(organizacion -> organizacion.ejecutarFuncionalidadDeNuevaMuestra(muestra, this));
	}

	public void notificarOrganizacionesPorNuevaValidacion(Muestra muestra) {
		
		this.organizacionesSuscribidas.forEach(organizacion -> organizacion.ejecutarFuncionalidadDeNuevaValidacion(muestra, this));
	}



}