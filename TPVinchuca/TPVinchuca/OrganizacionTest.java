package ar.edu.unq.po2.TPVinchuca;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





class OrganizacionTest {
	Organizacion oms;
	Ubicacion ubicacion1;
	
	@BeforeEach
	void setUp() throws Exception {
		ubicacion1 = mock(Ubicacion.class);
		oms = new Organizacion(ubicacion1, 500, TipoDeOrganizacion.SALUD);
	}

	@Test
	void testSeLePuedePedirLaUbicacionALaOrganizacion() {
		assertEquals(ubicacion1 , oms.getUbicacion());
	}
	
	@Test
	void testLaOrganizacionPuedeAumentarSuGente() {
		oms.setCantidadePersonas(oms.getCantidadePersonas() + 20);
		assertEquals(520 , oms.getCantidadePersonas());
	}
	
	@Test
	void testSeLePuedePedirLaCantidadDePersonasALaOrganizacion() {
		assertEquals(500 , oms.getCantidadePersonas());
	}
	
	@Test
	void testSeLePuedePedirElTipoALaOrganizacion() {
		assertEquals("SALUD" , oms.getTipoDeOrganizacion().toString());
	}
	
	@Test
	void testLaOrganizacionEjecutaSuFuncionalidadExternaParaNuevaMuestra() {
		IFuncionalidadExterna funcionalidad = mock(IFuncionalidadExterna.class);
		ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
		Muestra muestra = mock(Muestra.class);
		oms.setFuncionalidadExternaParaNuevaMuestra(funcionalidad);
		oms.ejecutarFuncionalidadDeNuevaMuestra(muestra, zona);
		
		verify(funcionalidad).nuevoEvento(oms, zona, muestra);
	}
	
	@Test
	void testLaOrganizacionEjecutaSuFuncionalidadExternaParaValidacion() {
		IFuncionalidadExterna funcionalidad = mock(IFuncionalidadExterna.class);
		ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
		Muestra muestra = mock(Muestra.class);
		oms.setFuncionalidadExternaParaValidacion(funcionalidad);
		oms.ejecutarFuncionalidadDeNuevaValidacion(muestra, zona);
		
		verify(funcionalidad).nuevoEvento(oms, zona, muestra);
	}
}