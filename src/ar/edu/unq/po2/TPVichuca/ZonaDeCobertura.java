package ar.edu.unq.po2.TPVichuca;

import java.util.ArrayList;

public class ZonaDeCobertura {
	private String nombre;
	private Ubicacion epicentro;
	private Integer radio;
		

public String getNombre(){
	return nombre;
}

public Ubicacion getEpicentro(){
	return epicentro;
		}

public Integer getRadio() {
	return radio;
	}

public boolean esZonaSolapada(ZonaDeCobertura otraZonaDeCobertura) {
	Ubicacion ubicacion1 = this.getEpicentro();
	Ubicacion ubicacion2 = otraZonaDeCobertura.getEpicentro();
	
	return(sumarRadios(this , otraZonaDeCobertura ) > (ubicacion1.distanciaEntreUbicaciones(ubicacion2)));		
	}


public Integer sumarRadios(ZonaDeCobertura zonaDeCobertura, ZonaDeCobertura otraZonaDeCobertura) {
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
}