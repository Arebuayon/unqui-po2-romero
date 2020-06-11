package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unq.po2.TPVichuca.ConfiguracionHistorial;
import ar.edu.unq.po2.TPVichuca.Historial;
import ar.edu.unq.po2.TPVichuca.Muestra;
import ar.edu.unq.po2.TPVichuca.Ubicacion;
import ar.edu.unq.po2.TPVichuca.Usuario;


public class HistorialTest {

	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Historial historial1;
	private Usuario user;
	private Usuario user2;
	private Usuario user3;
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	
	@BeforeEach
	public void setUp() {
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		ubicacion3 = mock(Ubicacion.class);
		muestra1 = new Muestra(user, null,	ubicacion1, null);
		muestra2 = new Muestra(user2, null, ubicacion2, null);
		muestra3 = new Muestra(user3, null, ubicacion3, null);
		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		user3 = mock(Usuario.class);
		historial1 = new Historial();	
	}
	
	@Test
	public void historial() {
		
		historial1 = new Historial();
		user = new Usuario(112, null);
	
		muestra1 = new Muestra(user, null, null, null);

		historial1.agregarMuestra(muestra1);
	
		assertEquals(1,historial1.getListaDeMuestras().size());
		
	}
	
	@Test
	public void historialPrimeraVezQueParticipa() {
		
		historial1 = new Historial();
		muestra1 = new Muestra(user, null, null, null);
		
		assertTrue(historial1.primeraVesQueParticipa(user));
		assertTrue(historial1.primeraVesQueParticipa(user2));
		assertTrue(historial1.primeraVesQueParticipa(user3));
		
		historial1.getListaDeMuestras().add(muestra1);
		assertFalse(historial1.primeraVesQueParticipa(user));
		
	}
	
	@Test
	public void muestraDeUser() {
		
		historial1 = new Historial();
		
		user = new Usuario(112, null);
		user2 = new Usuario(114, null);
		
		muestra1 = new Muestra(user, null, null, null);
		muestra2 = new Muestra(user2, null, null, null);
		muestra3 = new Muestra(user, null, null, null);
		
		
		historial1.getListaDeMuestras().add(muestra1);
		historial1.getListaDeMuestras().add(muestra2);
		historial1.getListaDeMuestras().add(muestra3);
		
		assertEquals(3,historial1.getListaDeMuestras().size());

		assertEquals(2,historial1.muestrasDe(user).size());
		
	}
	
	
	
	@Test
	public void testSePuedenPedirLasMuestrasAMenosDeXKmDeMuestra() {
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra3);
		muestra1.setUbicacion(ubicacion1);
		muestra2.setUbicacion(ubicacion2);
		muestra3.setUbicacion(ubicacion3);
		historial1.getListaDeMuestras().add(muestra1);
		historial1.getListaDeMuestras().add(muestra2);
		historial1.getListaDeMuestras().add(muestra3);
		when(muestra1.getUbicacion().distanciaAOtraUbicacion(muestra2.getUbicacion())).thenReturn(50.00);
		when(muestra1.getUbicacion().distanciaAOtraUbicacion(muestra3.getUbicacion())).thenReturn(150.00);
		
		
		assertEquals(listaDeRespuesta , historial1.muestrasAMenosDeXKmDeMuestra(muestra1, 100));
	}
	
}