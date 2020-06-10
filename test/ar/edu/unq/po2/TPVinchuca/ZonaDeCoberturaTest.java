package ar.edu.unq.po2.TPVinchuca;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.Ubicacion;
import ar.edu.unq.po2.TPVichuca.ZonaDeCobertura;

class ZonaDeCoberturaTest {
	Ubicacion epicentro1;
	ZonaDeCobertura zonaDeCobertura1;
	
	@BeforeEach
	void setUp() throws Exception {
		epicentro1 = mock(Ubicacion.class);
		zonaDeCobertura1 = new ZonaDeCobertura("Quilmes", epicentro1 , 1500);
	}

	@Test
	void testSeLePuedePedirElEpicentroALaZonaDeCobertura() {
		assertEquals(epicentro1 , zonaDeCobertura1.getEpicentro());
	}
	
	@Test
	void testSeLePuedePedirElRadioALaZonaDeCobertura() {
		assertEquals(1500 , zonaDeCobertura1.getRadio());
		}
	@Test
	void testSeLePuedePedirElNombreALaZonaDeCobertura() {
		assertEquals("Quilmes" , zonaDeCobertura1.getNombre());
		}
	
	@Test
	void testDosZonasSeSolapan() {
		ZonaDeCobertura zonaDeCobertura2 = mock(ZonaDeCobertura.class);
		when(zonaDeCobertura2.esZonaSolapada(zonaDeCobertura1)).thenReturn(true);
		
		assertTrue(zonaDeCobertura1.esZonaSolapada(zonaDeCobertura2));
		
	}
	@Test
	void testDosZonasNoSeSolapan() {
		ZonaDeCobertura zonaDeCobertura2 = mock(ZonaDeCobertura.class);
		when(zonaDeCobertura2.esZonaSolapada(zonaDeCobertura1)).thenReturn(false);
		
		assertFalse(zonaDeCobertura1.esZonaSolapada(zonaDeCobertura2));
		
	}
	
	@Test
	void testSeLePuedenPedirLasZonasSolapadasALaZona() {
		ZonaDeCobertura zonaDeCobertura2 = mock(ZonaDeCobertura.class);
		ZonaDeCobertura zonaDeCobertura3 = mock(ZonaDeCobertura.class);
		ZonaDeCobertura zonaDeCobertura4 = mock(ZonaDeCobertura.class);
		ZonaDeCobertura zonaDeCobertura5 = mock(ZonaDeCobertura.class);
		ArrayList<ZonaDeCobertura> listaDeZonas = new ArrayList<ZonaDeCobertura>();
		listaDeZonas.add(zonaDeCobertura2);
		listaDeZonas.add(zonaDeCobertura3);
		listaDeZonas.add(zonaDeCobertura4);
		listaDeZonas.add(zonaDeCobertura5);
		ArrayList<ZonaDeCobertura> listaDeRespuesta= new ArrayList<ZonaDeCobertura>();
		listaDeRespuesta.add(zonaDeCobertura2);
		listaDeRespuesta.add(zonaDeCobertura5);
		
		
		when(zonaDeCobertura2.esZonaSolapada(zonaDeCobertura1)).thenReturn(true);
		when(zonaDeCobertura3.esZonaSolapada(zonaDeCobertura1)).thenReturn(false);
		when(zonaDeCobertura4.esZonaSolapada(zonaDeCobertura1)).thenReturn(false);
		when(zonaDeCobertura5.esZonaSolapada(zonaDeCobertura1)).thenReturn(true);
		
		assertEquals(listaDeRespuesta , zonaDeCobertura1.zonasSolapadas(listaDeZonas));
		
	}
	
}
