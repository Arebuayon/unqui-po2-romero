package ar.edu.unq.po2.TPVinchuca;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ar.edu.unq.po2.TPVichuca.EvaluadorDeConocimiento;
import ar.edu.unq.po2.TPVichuca.Historial;
import ar.edu.unq.po2.TPVichuca.Usuario;

class EvaluadorDeConocimientoTest {
	EvaluadorDeConocimiento evaluador1;
	Usuario user1;
	Historial historial1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		evaluador1 = new EvaluadorDeConocimiento();
		historial1= mock(Historial.class);
		user1 = mock(Usuario.class);
		
	}

	@Test
	void testElEvaluadorSeFijaSiElUserEsExperto() {
		when(historial1.cantidadDeMuestrasHace30DiasDe(user1)).thenReturn(20);
		when(historial1.cantidadDeOpinionesHace30DiasDe(user1)).thenReturn(35);
		
		assertTrue(evaluador1.esExperto(historial1, user1));
	}
	@Test
	void testElEvaluadorSeFijaSiElUserEsExpertoYNoLoEs() {
		when(historial1.cantidadDeMuestrasHace30DiasDe(user1)).thenReturn(70);
		when(historial1.cantidadDeOpinionesHace30DiasDe(user1)).thenReturn(5);
		
		assertFalse(evaluador1.esExperto(historial1, user1));
	}

	@Test
	void testElEvaluadorReClasificaUsuario() {
		
		when(historial1.cantidadDeMuestrasHace30DiasDe(user1)).thenReturn(20);
		when(historial1.cantidadDeOpinionesHace30DiasDe(user1)).thenReturn(35);
		evaluador1.reClasificarUsuario(user1, historial1);
		
		verify(user1).setConocimiento(any());
	}
	
	@Test
	void testElEvaluadorReClasificaUsuarioQueNoEsExperto() {
		
		when(historial1.cantidadDeMuestrasHace30DiasDe(user1)).thenReturn(5);
		when(historial1.cantidadDeOpinionesHace30DiasDe(user1)).thenReturn(15);
		evaluador1.reClasificarUsuario(user1, historial1);
		
		verify(user1 ,  never()).setConocimiento(any());

	}
	
}
