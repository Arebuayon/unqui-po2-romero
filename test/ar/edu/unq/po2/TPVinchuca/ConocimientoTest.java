package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.ConocimientoBasico;
import ar.edu.unq.po2.TPVichuca.ConocimientoEspecialista;
import ar.edu.unq.po2.TPVichuca.ConocimientoExperto;
import ar.edu.unq.po2.TPVichuca.Muestra;
import ar.edu.unq.po2.TPVichuca.Opinion;
import ar.edu.unq.po2.TPVichuca.Usuario;
import ar.edu.unq.po2.TPVichuca.VerificacionBasica;
import ar.edu.unq.po2.TPVichuca.VerificacionExperto;

public class ConocimientoTest {
	
	private ConocimientoBasico concBasico;
	private ConocimientoExperto concExperto;
	private ConocimientoEspecialista concEspecialista;
	private Usuario user;
	private Usuario user2;
	private Muestra muestra1;
	private Opinion opinion1;
	private Opinion opinion2;
	private VerificacionExperto verificacionExperto;
	
	
	
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
		verificacionExperto = new VerificacionExperto();
	}
	
/*	@Test
	public void muestraNoValoradas(){
		
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(user.tipoDeConocimiento()).thenReturn("Basico");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion1.getUser()).thenReturn(user);
		when(opinion1.getUser()).thenReturn(user2);
		
		muestra1 = new Muestra(user, null, null, opinion1);
		
		assertTrue(concBasico.muestraNoValoradaPor(user, muestra1));
		assertFalse(concBasico.muestraNoValoradaPor(user2, muestra1));
		
		assertTrue(concExperto.muestraNoValoradaPor(user, muestra1));
		assertFalse(concExperto.muestraNoValoradaPor(user2, muestra1));
		
		assertTrue(concEspecialista.muestraNoValoradaPor(user, muestra1));
		assertFalse(concEspecialista.muestraNoValoradaPor(user2, muestra1));
		
		
	}
*/	
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
	public void tipoDeVerificacionVerificados() {
/*		
		assertFalse(concBasico.getTipoDeVerificacion().isVerificado());
		assertFalse(concExperto.getTipoDeVerificacion().isVerificado());
		assertFalse(concEspecialista.getTipoDeVerificacion().isVerificado());
*/				
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
		muestra1.setVerificado(new VerificacionBasica() );
		
		assertEquals(1 ,muestra1.getOpiniones().size());
		
		concBasico.valorarMuestra(user2, muestra1, opinion2);
		assertEquals(2 ,muestra1.getOpiniones().size());
		
	}
	
	@Test
	public void valoracionDeMuestraExperto() {
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(user.tipoDeConocimiento()).thenReturn("Experto");
		when(user2.tipoDeConocimiento()).thenReturn("Basico");
		when(opinion2.getUser()).thenReturn(user);
		when(opinion1.getUser()).thenReturn(user2);
		
		user.setConocimiento(concBasico);
		muestra1 = new Muestra(user2, null, null, opinion1);
		muestra1.setVerificado(verificacionExperto);
		concExperto.valorarMuestra(user, muestra1, opinion2);
		assertEquals(2 ,muestra1.getOpiniones().size());
		
	}
	
	@Test
	public void valoracionDeMuestraEspecialista() {
		
		when(user.getIdUser()).thenReturn(111);
		when(user2.getIdUser()).thenReturn(222);
		when(opinion1.getUser()).thenReturn(user2);
		when(opinion2.getUser()).thenReturn(user);
		
		user.setConocimiento(concBasico);
		muestra1 = new Muestra(user2, null, null, opinion1);
		muestra1.setVerificado(verificacionExperto);
		concEspecialista.valorarMuestra(user, muestra1, opinion2);
		assertEquals(2 ,muestra1.getOpiniones().size());
		
	}
	
	
}