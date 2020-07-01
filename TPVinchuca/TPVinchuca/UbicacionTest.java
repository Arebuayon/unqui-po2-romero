package ar.edu.unq.po2.TPVinchuca;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





class UbicacionTest {
	Ubicacion ubicacion1;
	
	@BeforeEach
	void setUp() throws Exception {
		ubicacion1 = new Ubicacion(1500, 2000);
	}
		
	@Test
	void testSeLePuedePedirLaLatitudALaUbicacion() {
		assertEquals(1500, this.ubicacion1.getLatitud());
	}
	
	@Test
	void testSeLePuedePedirLaLongitudALaUbicacion() {
		assertEquals(2000, this.ubicacion1.getLongitud());
	}
	
	@Test
	void testSePuedeCalcularLaDistanciaEntre2Ubicaciones() {
		Ubicacion ubicacion2 = new Ubicacion(1000 , 3000);
		
		assertEquals(16335.386108858054 , ubicacion1.distanciaAOtraUbicacion(ubicacion2));
		
	}
	
	@Test
	void testSePuedenSaberLasUbicacionesAMenosDeXKm() {
		Ubicacion ubicacion2 = new Ubicacion(1000 , 3000);
		Ubicacion ubicacion3 = new Ubicacion(2000 ,3000);
		Ubicacion ubicacion4 = new Ubicacion(1000 , 8000);
		Ubicacion ubicacion5 = new Ubicacion(3000 , 5000);
		ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		ArrayList<Ubicacion> listaDeRespuesta = new ArrayList<Ubicacion>();
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		ubicaciones.add(ubicacion4);
		ubicaciones.add(ubicacion5);
		listaDeRespuesta.add(ubicacion3);
		listaDeRespuesta.add(ubicacion5);
		
		
		assertEquals(listaDeRespuesta , ubicacion1.ubicacionesAMenosDeXKm(ubicaciones, 15000));
	}
}