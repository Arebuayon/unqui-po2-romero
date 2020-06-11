package ar.edu.unq.po2.TPVinchuca;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.ConfiguracionHistorial;
import ar.edu.unq.po2.TPVichuca.Historial;

class ConfiguracionHistorialTest {
	Historial historial1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		historial1 = mock(Historial.class);
		ConfiguracionHistorial.getConfiguracion().setHistorial(historial1);
	}

	@Test
	void testLaConfiguracionRetornaElHistorial() {
		ConfiguracionHistorial.getConfiguracion().setHistorial(historial1);
		assertEquals(historial1 , ConfiguracionHistorial.getConfiguracion().getHistorial());
	}

}
