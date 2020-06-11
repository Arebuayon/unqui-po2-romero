package ar.edu.unq.po2.TPVinchuca;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.IFuncionalidadExterna;
import ar.edu.unq.po2.TPVichuca.Muestra;
import ar.edu.unq.po2.TPVichuca.Organizacion;
import ar.edu.unq.po2.TPVichuca.Ubicacion;
import ar.edu.unq.po2.TPVichuca.ZonaDeCobertura;

class ZonaDeCoberturaTest {
	Ubicacion epicentro1;
	ZonaDeCobertura zonaDeCobertura1;
	Organizacion organizacion1;
	Organizacion organizacion2;
	IFuncionalidadExterna funcionalidadNuevaMuestra1;
	IFuncionalidadExterna funcionalidadNuevaValidacion1;
	Muestra muestra1;
	
	@BeforeEach
	void setUp() throws Exception {
		epicentro1 = mock(Ubicacion.class);
		zonaDeCobertura1 = new ZonaDeCobertura("Quilmes", epicentro1 , 1500);
		organizacion1 = mock(Organizacion.class);
		organizacion2 = mock(Organizacion.class);
		muestra1 = mock(Muestra.class);
		funcionalidadNuevaMuestra1 = mock(IFuncionalidadExterna.class);
		funcionalidadNuevaValidacion1 = mock(IFuncionalidadExterna.class);
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
	void testLaZonaSuscribeOrganizaciones() {
		assertEquals(0, zonaDeCobertura1.getOrganizacionesSuscribidas().size());
		zonaDeCobertura1.suscribirOrganizacion(organizacion1);
		assertEquals(1, zonaDeCobertura1.getOrganizacionesSuscribidas().size());
		
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
		
		assertFalse(zonaDeCobertura2.esZonaSolapada(zonaDeCobertura1));
		
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
	
	@Test
	void testLaZonaNotificaALasOrganizaciones() {
		organizacion1.setFuncionalidadExternaParaNuevaMuestra(funcionalidadNuevaMuestra1);
		organizacion1.setFuncionalidadExternaParaValidacion(funcionalidadNuevaValidacion1);
		zonaDeCobertura1.suscribirOrganizacion(organizacion1);
		zonaDeCobertura1.suscribirOrganizacion(organizacion2);
		zonaDeCobertura1.notificarOrganizacionesPorNuevaMuestra(muestra1);
		zonaDeCobertura1.notificarOrganizacionesPorNuevaValidacion(muestra1);
		
		verify(organizacion1).ejecutarFuncionalidadDeNuevaMuestra(muestra1, zonaDeCobertura1);;
	}
	
}
