package ar.edu.unq.po2.TPVichuca;

import java.util.List;
import java.util.stream.Collectors;

public class Ubicacion {

	private double latitud;
	private double longitud;
	
	public Ubicacion(float latitud, float longitud) {
		
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	
	public double getLongitud() {
		return longitud;
	}

	
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
        double radioTierra = 6371; 
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }  
	
	public double distanciaAOtraUbicacion(Ubicacion ubicacion2) {         
        double distanciaEntre2Ubicaciones = distanciaCoord(this.getLatitud(),this.getLongitud(),ubicacion2.getLatitud(),ubicacion2.getLongitud());
        return distanciaEntre2Ubicaciones;
    } 
	
	public List<Ubicacion> ubicacionesAMenosDeXKm(List<Ubicacion> ubicaciones  , double distanciaEnKm){
		return ubicaciones.stream().filter(ubicacion -> this.distanciaAOtraUbicacion(ubicacion) < distanciaEnKm).collect(Collectors.toList());
		
		
	}
	
}
