package ar.edu.unq.po2.TPVinchuca;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.Opinion;
import ar.edu.unq.po2.TPVichuca.RespuestaImagenPocoClara;
import ar.edu.unq.po2.TPVichuca.RespuestaNoDefinida;
import ar.edu.unq.po2.TPVichuca.Usuario;

public class OpinionTest {

	private Usuario user;
	private Usuario user2;
	private Opinion opinion1;
	private Opinion opinion2;
	private RespuestaNoDefinida noRespuesta;
	private RespuestaImagenPocoClara ImagenPocoClara;
	
	@BeforeEach
	public void setUp() {
		
		
		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		noRespuesta = new RespuestaNoDefinida();
		ImagenPocoClara = new RespuestaImagenPocoClara();
		opinion1 = new Opinion(user, noRespuesta);
		opinion2 = new Opinion(user2, ImagenPocoClara);
		
	
	}
	
	@Test
	public void opinionRespuesta(){
		
		assertEquals("No definido",opinion1.nombreDelInsecto());
		assertEquals("ImagenPocaClara",opinion2.nombreDelInsecto());
		
	}
	
	@Test
	public void seLePuedePedirLaFechaEnviadaALaOpinion() {
		assertEquals(LocalDate.now() , opinion1.getFechaEnviada());
	}
	@Test
	public void seLePuedePedirElUserALaOpinion() {
		assertEquals(user2 , opinion2.getUser());
	}
}
	
