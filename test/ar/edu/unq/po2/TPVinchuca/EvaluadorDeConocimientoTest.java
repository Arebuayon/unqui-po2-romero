package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.EvaluadorDeConocimiento;
import ar.edu.unq.po2.TPVichuca.Historial;
import ar.edu.unq.po2.TPVichuca.Usuario;

class EvaluadorDeConocimientoTest {
	EvaluadorDeConocimiento evaluador1;
	Usuario user1;
	
	@BeforeEach
	void setUp() throws Exception {
		evaluador1 = new EvaluadorDeConocimiento();
	}

	@Test
	void testElEvaluadorSeFijaSiElUserEsExperto() {
		fail("Not yet implemented");
	}

}
