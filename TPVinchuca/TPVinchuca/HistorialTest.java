package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDate;
import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;







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
	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	
	
	
	@BeforeEach
	public void setUp() {
		historial1 = new Historial();
		
		ubicacion1 = new Ubicacion(1000, 500);
		ubicacion2 = new Ubicacion(3000, 500);
		ubicacion3 = new Ubicacion(6000, 500);
		
		zona1 = mock(ZonaDeCobertura.class);
		zona2 = mock(ZonaDeCobertura.class);

		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		user3 = mock(Usuario.class);
		
		muestra1 = new Muestra(user, null,	ubicacion1, null);
		muestra2 = new Muestra(user2, null, ubicacion2, null);
		muestra3 = new Muestra(user3, null, ubicacion3, null);
		
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
	public void testElHistorialDevuelveSuInformacion() {
		EvaluadorDeConocimiento evaluadorDeConocimiento1 = new EvaluadorDeConocimiento();
		historial1.setEvaluadorDeConocimiento(evaluadorDeConocimiento1);
		historial1.getListaDeZonas().add(zona1);
		historial1.getListaDeZonas().add(zona2);
		assertEquals(2 , historial1.getListaDeZonas().size());
		assertEquals(evaluadorDeConocimiento1 , historial1.getEvaluador());
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
		
		
		historial1.getListaDeMuestras().add(muestra1);
		historial1.getListaDeMuestras().add(muestra2);
		historial1.getListaDeMuestras().add(muestra3);
		

		
		
		assertEquals(listaDeRespuesta , historial1.muestrasAMenosDeXKmDeMuestra(muestra1, 10000.00));
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
	public void testElHistorialDevuelveMuestrasDeUnaZona() {
		
		
		historial1.getListaDeMuestras().add(muestra1);
		historial1.getListaDeMuestras().add(muestra2);
		historial1.getListaDeMuestras().add(muestra3);
		
		
		when(zona1.getEpicentro()).thenReturn(ubicacion1);
		when(zona1.getRadio()).thenReturn(100);
		
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra1);
		
		assertEquals(listaDeRespuesta , historial1.muestrasDeZona(zona1));
		
	}
}