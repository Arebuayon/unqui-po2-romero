package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ConocimientoTest {
	
	private ConocimientoBasico concBasico;
	private ConocimientoExperto concExperto;
	private ConocimientoEspecialista concEspecialista;
	private Usuario user;
	private Usuario user2;
	private Muestra muestra1;
	private Opinion opinion1;
	private Opinion opinion2;	
	private Verificacion verificacion;
	private VerificacionParcialBasico verBasico;
	private VerificadoParcialExperto verExperto;
	
//	private VerificacionExperto verificacionExperto;
//	private VerificacionBasica verificacionBasica;
//	private VerificacionBasica verificacionBasicaMock;
	
	@BeforeEach
	public void setUp() {
		
		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		muestra1 = mock(Muestra.class);
		opinion1 = mock(Opinion.class);
		opinion2 = mock(Opinion.class);
		concBasico = new ConocimientoBasico();
		concExperto = new ConocimientoExperto();
		concEspecialista = new ConocimientoEspecialista();
		verificacion = new Verificacion();
		verBasico = new VerificacionParcialBasico();
		verExperto = new VerificadoParcialExperto();
	}
	
	@Test
	public void seLePuedePedirElTipoDeConocimientoAlConocimiento() {
		concBasico.getTipoDeConocimiento();
		assertEquals("Basico", concBasico.getTipoDeConocimiento());
	}
	
	
	
	
	@Test
	public void muestrasAptasParaValorar(){
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		
		when(muestra1.getUser()).thenReturn(user);
		
		assertFalse(concBasico.muestraActaParaValorar(user, muestra1));
		assertTrue(concBasico.muestraActaParaValorar(user2, muestra1));
		
		assertFalse(concExperto.muestraActaParaValorar(user, muestra1));
		assertTrue(concExperto.muestraActaParaValorar(user2, muestra1));
		
		assertFalse(concEspecialista.muestraActaParaValorar(user, muestra1));
		assertTrue(concEspecialista.muestraActaParaValorar(user2, muestra1));
		
	}
	
	
	
	@Test
	public void valoracionDeMuestraBasica() {
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(user.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion1.getUser()).thenReturn(user);
		when(opinion2.getUser()).thenReturn(user2);
		
		user.setConocimiento(concBasico);
		muestra1 = new Muestra(user, null, null, opinion1);
		
		verificacion.setVerificado(verBasico);
		muestra1.setVerificado(verificacion);
		muestra1.setVerificado(verificacion );
		
		assertEquals(1 ,muestra1.getOpiniones().size());
		
		concBasico.valorarMuestra(user2, muestra1, opinion2);
		assertEquals(2 ,muestra1.getOpiniones().size());
		
	}
	
	@Test
	public void valoracionDeMuestraExperto() {
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		
		when(user.getConocimiento()).thenReturn(concExperto);
		when(user2.getConocimiento()).thenReturn(concBasico);
		
		when(opinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		when(opinion2.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
		
		when(user.tipoDeConocimiento()).thenReturn("Experto");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		
		when(opinion1.getUser()).thenReturn(user);
		when(opinion2.getUser()).thenReturn(user2);
		
		muestra1 = new Muestra(user2, null, null, opinion2);
		verificacion.setVerificado(verExperto);
		muestra1.setVerificado(verificacion);
		concExperto.valorarMuestra(user, muestra1, opinion1);
		assertEquals(2 ,muestra1.getOpiniones().size());
		
	}
	
	@Test
	public void valoracionDeMuestraEspecialista() {
		
		when(user.getConocimiento()).thenReturn(concEspecialista);
		when(user2.getConocimiento()).thenReturn(concBasico);
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		
		when(opinion1.getUser()).thenReturn(user);
		when(opinion2.getUser()).thenReturn(user2);
		
		muestra1 = new Muestra(user2, null, null, opinion1);
		verificacion.setVerificado(verExperto);
		muestra1.setVerificado(verificacion);
		concEspecialista.valorarMuestra(user, muestra1, opinion2);
		assertEquals(2 ,muestra1.getOpiniones().size());
		
	}
	
	@Test
	public void testConocimientoBasicoValoraMuestra() {
	//	verificacionBasicaMock = mock(VerificacionBasica.class);
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(123);
		when(muestra1.getUser()).thenReturn(user2);
		muestra1 = new Muestra(user2, null, null, opinion2);
	//	when(muestra1.getVerificado()).thenReturn(verificacionBasicaMock);
	//	when(verificacionBasicaMock.puedeOpinarSobreLa(user, muestra1)).thenReturn(true);
		concBasico.muestraActaParaValorar(user, muestra1);
		concBasico.valorarMuestra(user, muestra1, opinion1);
		assertEquals(2 ,muestra1.getOpiniones().size());
		
	//	verify(muestra1).getOpiniones();
		
	}
	
}