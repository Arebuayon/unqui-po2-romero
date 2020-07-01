package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDate;
import java.util.ArrayList;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;





public class HistorialTest {

	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Historial historial1;
	private Usuario user;
	private Usuario user2;
	private Usuario user3;
	//private Opinion opinion1;
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
		//opinion1 = mock(Opinion.class);
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
	
		historial1 = new Historial();
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra3);
	//	muestra1.setUbicacion(ubicacion1);
	//	muestra2.setUbicacion(ubicacion2);
	//	muestra3.setUbicacion(ubicacion3);
		historial1.getListaDeMuestras().add(muestra1);
		historial1.getListaDeMuestras().add(muestra2);
		historial1.getListaDeMuestras().add(muestra3);
		
		when(muestra1.getUbicacion().distanciaAOtraUbicacion(muestra2.getUbicacion())).thenReturn(50.00);
		when(muestra1.getUbicacion().distanciaAOtraUbicacion(muestra3.getUbicacion())).thenReturn(150.00);
		
		assertEquals(listaDeRespuesta , historial1.muestrasAMenosDeXKmDeMuestra(muestra1, 100));
	}
	
	@Test
	public void testMuestraDeUsuario() {
		
		user3 = mock(Usuario.class);
		user2 = mock(Usuario.class);
		
		when(user3.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		
		when(user3.getConocimiento()).thenReturn(new ConocimientoBasico());
		
		Opinion opinionDeUser3 = new Opinion(user3, null);
		
		Muestra muestra4 = new Muestra(user3, null, ubicacion3, opinionDeUser3 );
		historial1 = new Historial();
		
		historial1.agregarMuestra(muestra4);
		assertTrue(historial1.opinionesDe(user2).isEmpty());
		
		assertEquals(1,historial1.opinionesDe(user3).size());
		
	}
	
	@Test
	public void testFechaDeEnviadoMuestraYOpinion() {
		
		LocalDate fechaDeCreacion2 = LocalDate.of(2020,2,10);
		
		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		
		when(user.getConocimiento()).thenReturn(new ConocimientoBasico());
		when(user2.getConocimiento()).thenReturn(new ConocimientoBasico());
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		
		Opinion opinionDeUser1 = new Opinion(user, null);
		Opinion opinionDeUser2 = new Opinion(user2, null);
		
		Muestra muestraUser1 = new Muestra(user, null, null, opinionDeUser1 );
		Muestra muestraUser2 = new Muestra(user2, null, null, opinionDeUser2 );
	
		muestraUser2.setFechaCreada(fechaDeCreacion2);
		opinionDeUser2.setFechaEnviada(fechaDeCreacion2);
		
		historial1 = new Historial();
		historial1.agregarMuestra(muestraUser1);
		historial1.agregarMuestra(muestraUser2);
		
		assertEquals(1,historial1.cantidadDeMuestrasHace30DiasDe(user));
	
		assertEquals(0,historial1.cantidadDeMuestrasHace30DiasDe(user2)); // revisar
		
		
		assertEquals(1,historial1.cantidadDeOpinionesHace30DiasDe(user));
		assertEquals(0,historial1.cantidadDeMuestrasHace30DiasDe(user2)); //revisar
	}
	
	@Test
	public void testElHistorialNotificaNuevaMuestra() {}
	
	@Test
	public void testElHistorialNotificaNuevaValidacion() {}
	
	@Test
	public void testElHistorialDevuelveMuestrasDeUnaZona() {}
}