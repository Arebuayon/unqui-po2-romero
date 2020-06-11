package ar.edu.unq.po2.TPVinchuca;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.Conocimiento;
import ar.edu.unq.po2.TPVichuca.EvaluadorDeConocimiento;
import ar.edu.unq.po2.TPVichuca.Historial;
import ar.edu.unq.po2.TPVichuca.IConocimiento;
import ar.edu.unq.po2.TPVichuca.Muestra;
import ar.edu.unq.po2.TPVichuca.Opinion;
import ar.edu.unq.po2.TPVichuca.Ubicacion;
import ar.edu.unq.po2.TPVichuca.Usuario;

class UsuarioTest {
	Usuario usuario1;
	Muestra muestra1;
	Historial historial1;
	Conocimiento conocimiento1;
	Ubicacion ubicacion1;
	Opinion opinion1;
	EvaluadorDeConocimiento evaluador1;
	
	@BeforeEach
	void setUp() throws Exception {
		
		ubicacion1 = mock(Ubicacion.class);
		conocimiento1 = mock(Conocimiento.class);
		muestra1 = mock(Muestra.class);
		historial1 = mock (Historial.class);
		opinion1 = mock(Opinion.class);
		evaluador1 = mock(EvaluadorDeConocimiento.class);
		usuario1 = new Usuario(123 , ubicacion1);
	
		
	}

	@Test
	void testAlUsuarioSeLePuedePedirLaUbicacion() {
		assertEquals(ubicacion1 , usuario1.getUbicacion());
	}

	@Test
	void testAlUsuarioSeLePuedePedirElConocimiento() {
		usuario1.setConocimiento(conocimiento1);
		assertEquals(conocimiento1 , usuario1.getConocimiento());
	}
	
	@Test
	void testAlUsuarioSeLePuedePedirSuId() {
		assertEquals(123 , usuario1.getIdUser());
	}
	
	@Test
	void testAlUsuarioSeLePuedeSuTipoDeConocimiento() {
		usuario1.setConocimiento(conocimiento1);
		when(conocimiento1.getTipoDeConocimiento()).thenReturn("Basico");
		assertEquals("Basico" , usuario1.tipoDeConocimiento());
	}
	
	@Test
	void testElUsuarioEnviaMuestra() {
		usuario1.enviarMuestra(historial1, muestra1);
		
		verify(historial1).agregarMuestra(muestra1);
		
	}
	
	@Test
	void testElUsuarioOpinaSobreLaMuestra() {
		usuario1.setConocimiento(conocimiento1);
		usuario1.opinarSobreLaMuestra(usuario1, muestra1, opinion1);
		
		verify(conocimiento1).valorarMuestra(usuario1, muestra1, opinion1);
		
	}
	
	@Test
	void testElUsuarioEjecutaSuReclasificacion() {
		when(historial1.getEvaluador()).thenReturn(evaluador1);
		usuario1.recibirEvaluacionDeConocimiento(historial1, usuario1);
		
		verify(evaluador1).reClasificarUsuario(usuario1, historial1);
	}
}
