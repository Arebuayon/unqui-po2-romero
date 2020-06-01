package ar.edu.unq.po2.vinchucasTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.vinchucas.Muestra;
import ar.edu.unq.po2.vinchucas.Ubicacion;
import ar.edu.unq.po2.vinchucas.Usuario;

class MuestraTest {
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testConstructor() {
		Usuario usuario1 = mock(Usuario.class);
		Ubicacion ubicacion1 = mock(Ubicacion.class);
		Muestra muestra1 = new Muestra(usuario1,ubicacion1, "Infestans");
		
		
		assertEquals("Infestans", muestra1.getTipoDeVinchuca());
	}

}