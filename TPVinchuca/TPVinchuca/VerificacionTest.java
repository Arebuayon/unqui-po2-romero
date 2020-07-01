package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/*
class VerificacionTest {
	
	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Opinion opinion1;
	private Opinion opinion2;
	private Opinion opinion3;
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private VerificacionBasica verBasica;
	private VerificacionExperto verExperto;
	private Muestra muestraMock;
	private Usuario usuarioMock;
	@BeforeEach
	public void setUp() {
		
		user1 = mock(Usuario.class);
		user2 = mock(Usuario.class);
		user3 = mock(Usuario.class);
		opinion1 = mock(Opinion.class);
		opinion2 = mock(Opinion.class);
		opinion3 = mock(Opinion.class);
		muestra1 = new Muestra(null, null, null, null);
		muestra2 = new Muestra(null, null, null, null);
		muestra3 = new Muestra(null, null, null, null);
		verBasica = new VerificacionBasica();
		verExperto = new VerificacionExperto();
		
	}
	
	@Test
	void testVerificacion() {
		
		assertFalse(muestra1.isMuestraVerificada());
		assertFalse(muestra2.isMuestraVerificada());
		assertFalse(muestra3.isMuestraVerificada());
		
	}
	
	@Test
	void testOpinionesDeUsuariosBasicos() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(null, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals(2,verBasica.OpinionesDeUsuarios(muestra1).size());
		
	}
	
	@Test
	void testOpinionesDeUsuariosExpertos() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(null, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals(1,verExperto.OpinionesDeUsuarios(muestra1).size());
		
	}
	
	@Test
	void testOpinionActualEnBasico() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("Vichuca");
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		verBasica = new VerificacionBasica();
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals(3,muestra1.getOpiniones().size());
		assertEquals("Vichuca",verBasica.opinionActual(muestra1).nombreDelInsecto());
		
	}
	
	@Test
	void testOpinionActualEnExperto() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("NoVichuca");
		muestra1 = new Muestra(null, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals("NoVichuca",verBasica.opinionActual(muestra1).nombreDelInsecto());
		
	}
	
	@Test
	void testOpinionActualEnBasicoSinDecicion() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("QueEsUnaVichuca");
		muestra1 = new Muestra(null, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals("No definido",verBasica.opinionActual(muestra1).nombreDelInsecto());
		
	}
	
	@Test
	void testOpinionActualEnExpertoSinDecicion() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("QueEsUnaVichuca");
		muestra1 = new Muestra(null, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals("No definido",verExperto.opinionActual(muestra1).nombreDelInsecto());
		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraBasico() {
		
		when(user1.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(user3.getIdUser()).thenReturn(333);
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion3);
		
		assertTrue(verBasica.puedeOpinarSobreLa(user2, muestra1));
		
		assertFalse(verBasica.puedeOpinarSobreLa(user1, muestra1));
		assertFalse(verBasica.puedeOpinarSobreLa(user3, muestra1));
		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraBasicoV2() {
		
		muestraMock = mock(Muestra.class);
		usuarioMock = mock(Usuario.class);
		when(muestraMock.cantidadDeExpertosQueOpinaron()).thenReturn(1);
		when(muestraMock.isMuestraVerificada()).thenReturn(false);
		when(muestraMock.cantidadDeVecesApareceEl(user2)).thenReturn(0);
		when(muestraMock.cantidadDeVecesApareceEl(user1)).thenReturn(6);
		when(muestraMock.cantidadDeVecesApareceEl(user3)).thenReturn(3);
		
		assertTrue(verBasica.puedeOpinarSobreLa(user2, muestraMock));
		
		assertFalse(verBasica.puedeOpinarSobreLa(user1, muestraMock));
		assertFalse(verBasica.puedeOpinarSobreLa(user3, muestraMock));
		
	}
	
	@Test
	void testNoPuedeOpinarSobreLaMuestraBasico() {
		
		muestraMock = mock(Muestra.class);
		usuarioMock = mock(Usuario.class);
		when(muestraMock.cantidadDeExpertosQueOpinaron()).thenReturn(2);
		when(muestraMock.isMuestraVerificada()).thenReturn(true);
		when(muestraMock.cantidadDeVecesApareceEl(user2)).thenReturn(0);
		when(muestraMock.cantidadDeVecesApareceEl(user1)).thenReturn(0);
		when(muestraMock.cantidadDeVecesApareceEl(user3)).thenReturn(0);
		
		assertFalse(verBasica.puedeOpinarSobreLa(user2, muestraMock));
		
		assertFalse(verBasica.puedeOpinarSobreLa(user1, muestraMock));
		assertFalse(verBasica.puedeOpinarSobreLa(user3, muestraMock));
		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraExperto() {
		
		when(user1.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(user3.getIdUser()).thenReturn(333);
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion3);
		
		assertTrue(verExperto.puedeOpinarSobreLa(user2, muestra1));
		
		assertFalse(verExperto.puedeOpinarSobreLa(user1, muestra1));
		assertFalse(verExperto.puedeOpinarSobreLa(user3, muestra1));
		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraBasicoConMuestraVerificada() {
		
		muestraMock = mock(Muestra.class);
		usuarioMock = mock(Usuario.class);
		when(muestraMock.cantidadDeExpertosQueOpinaron()).thenReturn(1);
		when(muestraMock.isMuestraVerificada()).thenReturn(true);
		when(muestraMock.cantidadDeVecesApareceEl(user2)).thenReturn(0);
		when(muestraMock.cantidadDeVecesApareceEl(user1)).thenReturn(0);
		when(muestraMock.cantidadDeVecesApareceEl(user3)).thenReturn(0);
		
		
		assertFalse(verBasica.puedeOpinarSobreLa(user2, muestraMock));
		
		assertFalse(verBasica.puedeOpinarSobreLa(user1, muestraMock));
		assertFalse(verBasica.puedeOpinarSobreLa(user3, muestraMock));
		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraExperoCon2ExpertosYaOpinaron() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Experto");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		when(user3.tipoDeConocimiento()).thenReturn("Experto");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion3);
		
		assertFalse(verExperto.puedeOpinarSobreLa(user2, muestra1));
		
		assertFalse(verExperto.puedeOpinarSobreLa(user1, muestra1));
		assertFalse(verExperto.puedeOpinarSobreLa(user3, muestra1));
		
	}
	
	@Test
	void verificarMuestra() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Experto");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		when(user3.tipoDeConocimiento()).thenReturn("Experto");
		
		/*when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("Vichuca");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals(2,muestra1.cantidadDeExpertosQueOpinaron());
		assertFalse(muestra1.isMuestraVerificada());
		
		assertEquals("Vichuca",verExperto.opinionActual(muestra1).nombreDelInsecto());
		assertTrue(verExperto.masDe2votoPorUnaOpinion(muestra1));
		
		verExperto.verificar(muestra1);
		assertTrue(muestra1.isMuestraVerificada());
	}
	
*/
	class VerificacionTest {
	
	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Opinion opinion1;
	private Opinion opinion2;
	private Opinion opinion3;
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private ConocimientoBasico basico;
	private ConocimientoExperto experto;
	private ConocimientoEspecialista especialista;
	private Historial historial1;
	private EvaluadorDeConocimiento evaluador1;

	
	@BeforeEach
	public void setUp() {
		
		user1 = mock(Usuario.class);
		user2 = mock(Usuario.class);
		user3 = mock(Usuario.class);
		opinion1 = mock(Opinion.class);
		opinion2 = mock(Opinion.class);
		opinion3 = mock(Opinion.class);
		muestra1 = new Muestra(null, null, null, null);
		muestra2 = new Muestra(null, null, null, null);
		muestra3 = new Muestra(null, null, null, null);
		basico = new ConocimientoBasico();
		experto = new ConocimientoExperto();
		especialista = new ConocimientoEspecialista();
		historial1 = mock(Historial.class);
		evaluador1 = mock(EvaluadorDeConocimiento.class);
		ConfiguracionHistorial.getConfiguracion().setHistorial(historial1);
		when(historial1.getEvaluador()).thenReturn(evaluador1);

	}
	
	@Test
	void testVerificacion() {
		
		assertFalse(muestra1.isMuestraVerificada());
		assertFalse(muestra2.isMuestraVerificada());
		assertFalse(muestra3.isMuestraVerificada());
		
	}
	
	@Test
	void testOpinionesDeUsuariosBasicos() {
		
		when(user1.getConocimiento()).thenReturn(basico);
		when(user2.getConocimiento()).thenReturn(experto);
		when(user3.getConocimiento()).thenReturn(basico);
		
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.cambiarEstadoVerificacion();
		muestra1.getOpiniones().add(opinion2);
		muestra1.cambiarEstadoVerificacion();
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		assertEquals(2,muestra1.cantidadDeBasicosQueOpinaron());
		
	}
	
	@Test
	void testOpinionesDeUsuariosExpertos() {
		
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(null, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals(1,muestra1.cantidadDeExpertosQueOpinaron());
		
	}
	
	@Test
	void testOpinionActualEnBasico() {
		
		when(user1.getConocimiento()).thenReturn(basico);
		when(user2.getConocimiento()).thenReturn(experto);
		when(user3.getConocimiento()).thenReturn(basico);
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("Vichuca");
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals(3,muestra1.getOpiniones().size());
		assertEquals("Vichuca",muestra1.opinionActual().nombreDelInsecto());
		
	}
	
	@Test
	void testOpinionActualEnExperto() {
		
		when(user1.getConocimiento()).thenReturn(basico);
		when(user2.getConocimiento()).thenReturn(experto);
		when(user3.getConocimiento()).thenReturn(basico);
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("NoVichuca");

		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		assertEquals("NoVichuca",muestra1.opinionActual().nombreDelInsecto());
		
	}
	
	@Test
	void testOpinionActualTodosBasicos() {
		
		when(user1.getConocimiento()).thenReturn(basico);
		when(user2.getConocimiento()).thenReturn(basico);
		when(user3.getConocimiento()).thenReturn(basico);
		
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
	
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("NoVichuca");

		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		assertEquals(3,muestra1.cantidadDeBasicosQueOpinaron());
		assertEquals(2,muestra1.cantidadDeVecesQueApareceLa(opinion2));
		assertEquals(1,muestra1.cantidadDeVecesQueApareceLa(opinion1));
		
		assertTrue(muestra1.opinaronTodosBasicos());
		
		assertEquals("NoVichuca",muestra1.opinionActual().nombreDelInsecto());
		
	}
	
	@Test
	void testOpinionActualEnBasicoSinDecicion() {
		
		when(user1.getConocimiento()).thenReturn(basico);
		when(user2.getConocimiento()).thenReturn(experto);
		when(user3.getConocimiento()).thenReturn(basico);
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("QueEsUnaVichuca");

		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		assertEquals("No definido",muestra1.opinionActual().nombreDelInsecto());
		
	}
	
	@Test
	void testOpinionActualEnExpertoSinDecicion() {
		
		
		when(user1.getConocimiento()).thenReturn(basico);
		when(user2.getConocimiento()).thenReturn(experto);
		when(user3.getConocimiento()).thenReturn(basico);
		
		when(user1.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("QueEsUnaVichuca");

		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		assertEquals("No definido",muestra1.opinionActual().nombreDelInsecto());
		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraBasico() {
		
		when(user1.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(user3.getIdUser()).thenReturn(333);
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		assertTrue(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user2, muestra1));
		
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user1, muestra1));
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user3, muestra1));
	
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraExperto() {
		
		when(user1.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(user3.getIdUser()).thenReturn(333);
		when(user1.tipoDeConocimiento()).thenReturn("Experto");
		when(user2.tipoDeConocimiento()).thenReturn("Experto");
		when(user3.tipoDeConocimiento()).thenReturn("Experto");
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		assertEquals(2,muestra1.cantidadDeExpertosQueOpinaron());
		assertTrue(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user2, muestra1));
		
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user1, muestra1));
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user3, muestra1));

		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraBasicoCon2ExpertosYaOpinaron() {
		
		when(user1.tipoDeConocimiento()).thenReturn("Experto");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		when(user3.tipoDeConocimiento()).thenReturn("Experto");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user2, muestra1));
		
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user1, muestra1));
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user3, muestra1));
		
	}
	
	@Test
	void testPuedeOpinarSobreLaMuestraExperoCon2ExpertosYaOpinaron() {
		
		when(user1.getConocimiento()).thenReturn(experto);
		when(user2.getConocimiento()).thenReturn(basico);
		when(user3.getConocimiento()).thenReturn(experto);
		when(user1.tipoDeConocimiento()).thenReturn("Experto");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		when(user3.tipoDeConocimiento()).thenReturn("Experto");
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		muestra1.cambiarEstadoVerificacion();
		muestra1.getOpiniones().add(opinion3);
		muestra1.cambiarEstadoVerificacion();
		
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user2, muestra1));
		
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user1, muestra1));
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user3, muestra1));

	}
	
	@Test
	void verificarMuestraYNivelDeVerificacion() {
		
	//	when(user1.tipoDeConocimiento()).thenReturn("Experto");
	//	when(user2.tipoDeConocimiento()).thenReturn("Basico");
	//	when(user3.tipoDeConocimiento()).thenReturn("Experto");
		
		when(user1.getConocimiento()).thenReturn(experto);
		when(user2.getConocimiento()).thenReturn(basico);
		when(user3.getConocimiento()).thenReturn(experto);
		
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		when(opinion3.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		
		when(opinion1.nombreDelInsecto()).thenReturn("Vichuca");
		when(opinion2.nombreDelInsecto()).thenReturn("NoVichuca");
		when(opinion3.nombreDelInsecto()).thenReturn("Vichuca");
		
		when(opinion1.getUser()).thenReturn(user1);
		when(opinion2.getUser()).thenReturn(user2);
		when(opinion3.getUser()).thenReturn(user3);
		
		muestra1 = new Muestra(user1, null, null, opinion1);
		
		assertEquals("Bajo",muestra1.getNivelDeVerificacion());
		
		assertEquals("No definido",muestra1.opinionActual().nombreDelInsecto());
		muestra1.getOpiniones().add(opinion2);
		muestra1.getOpiniones().add(opinion3);
		
		muestra1.cambiarEstadoVerificacion();
		
		assertEquals(2,muestra1.cantidadDeExpertosQueOpinaron());
		assertFalse(muestra1.isMuestraVerificada());
		
		assertEquals("Medio",muestra1.getNivelDeVerificacion());
		
		assertEquals("Vichuca",muestra1.opinionActual().nombreDelInsecto());
		assertEquals(2,muestra1.cantidadDeExpertosQueOpinaron());
		
		muestra1.cambiarEstadoVerificacion();
		assertTrue(muestra1.isMuestraVerificada());
		
		assertEquals("Vichuca",muestra1.opinionActual().nombreDelInsecto());
		assertFalse(muestra1.getVerificado().getVerificado().puedeOpinarSobreLa(user2, muestra1));
		
		muestra1.cambiarEstadoVerificacion();
		assertEquals("Vichuca",muestra1.opinionActual().nombreDelInsecto());
		
		assertEquals("Alto",muestra1.getNivelDeVerificacion());
		
		//verifico una muestra ya verificada
		muestra1.cambiarEstadoVerificacion();
		assertEquals("Alto",muestra1.getNivelDeVerificacion());
		
	}
	
	@Test
	public void testVerificacionBasicoBasicoExperto(){
		
		RespuestaImagenPocoClara pocoClara = new RespuestaImagenPocoClara();
		ChincheFoliada foliada = new ChincheFoliada();
		
		Usuario usuarioA = new Usuario(111, null);
		usuarioA.setConocimiento(basico);
	
		Usuario usuarioB = new Usuario(222, null);
		usuarioB.setConocimiento(basico);
		
		Usuario usuarioC = new Usuario(333, null);
		usuarioC.setConocimiento(experto);
		
		Opinion opinionA = new Opinion(usuarioA,pocoClara);
		Opinion opinionB = new Opinion(usuarioB,pocoClara);
		Opinion opinionC = new Opinion(usuarioC,foliada);
		
		muestra1 = new Muestra(usuarioA, null, null, opinionA);
		
		assertEquals("Bajo",muestra1.getNivelDeVerificacion());
		
		usuarioB.opinarSobreLaMuestra(muestra1, opinionB);
		
		assertEquals("Medio",muestra1.getNivelDeVerificacion());
		assertFalse(muestra1.isMuestraVerificada());
		
		usuarioC.opinarSobreLaMuestra(muestra1, opinionC);
		
		assertEquals("Medio",muestra1.getNivelDeVerificacion()); 
		assertFalse(muestra1.isMuestraVerificada());
		
	}
	
	@Test
	public void testVerificacionExpertoBasicoExpero(){
		
		RespuestaImagenPocoClara pocoClara = new RespuestaImagenPocoClara();
		ChincheFoliada foliada = new ChincheFoliada();
		
		Usuario usuarioA = new Usuario(111, null);
		usuarioA.setConocimiento(experto);
	
		Usuario usuarioB = new Usuario(222, null);
		usuarioB.setConocimiento(basico);
		
		Usuario usuarioC = new Usuario(333, null);
		usuarioC.setConocimiento(experto);
		
		Opinion opinionA = new Opinion(usuarioA,pocoClara);
		Opinion opinionB = new Opinion(usuarioB,pocoClara);
		Opinion opinionC = new Opinion(usuarioC,foliada);
		
		muestra1 = new Muestra(usuarioA, null, null, opinionA);
		
		assertEquals("Bajo",muestra1.getNivelDeVerificacion());
		
		usuarioB.opinarSobreLaMuestra(muestra1, opinionB);
		
		assertEquals("Medio",muestra1.getNivelDeVerificacion());
		assertFalse(muestra1.isMuestraVerificada());
		
		usuarioC.opinarSobreLaMuestra(muestra1, opinionC);
		
		assertEquals("Medio",muestra1.getNivelDeVerificacion());
		assertFalse(muestra1.isMuestraVerificada());
		
		assertEquals("No definido",muestra1.respuestaDeLaOpnionActual());
		
		//no hay coinsidensia con las opiniones de Expertos por eso no se verifica 
		//y tampoco da una opinion clara por lo tanto es un opinion :"No definido"
	}
	@Test
	public void testVerificacionEspecialistaBasicoExperto(){
		
		RespuestaImagenPocoClara pocoClara = new RespuestaImagenPocoClara();
		ChincheFoliada foliada = new ChincheFoliada();
		
		Usuario usuarioA = new Usuario(111, null);
		usuarioA.setConocimiento(especialista);
	
		Usuario usuarioB = new Usuario(222, null);
		usuarioB.setConocimiento(basico);
		
		Usuario usuarioC = new Usuario(333, null);
		usuarioC.setConocimiento(experto);
		
		Opinion opinionA = new Opinion(usuarioA,foliada);
		Opinion opinionB = new Opinion(usuarioB,pocoClara);
		Opinion opinionC = new Opinion(usuarioC,foliada);
		
		muestra1 = new Muestra(usuarioA, null, null, opinionA);
		
		assertEquals("Bajo",muestra1.getNivelDeVerificacion());
		
		usuarioB.opinarSobreLaMuestra(muestra1, opinionB);
		
		assertEquals("Medio",muestra1.getNivelDeVerificacion());
		assertFalse(muestra1.isMuestraVerificada());
		
		usuarioC.opinarSobreLaMuestra(muestra1, opinionC);
		
		assertEquals("Alto",muestra1.getNivelDeVerificacion());
		assertTrue(muestra1.isMuestraVerificada());
		
		assertEquals("Chince Foliada",muestra1.respuestaDeLaOpnionActual());
		
	}
}