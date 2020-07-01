package ar.edu.unq.po2.TPVinchuca;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class OpinionTest {

	private Usuario user;
	private Usuario user2;
	private Usuario user3;
	private Opinion opinion1;
	private Opinion opinion2;
	private Opinion opinion3;
	private RespuestaNoDefinida noRespuesta;
	private RespuestaImagenPocoClara ImagenPocoClara;
	private ConocimientoBasico conocBasico;
	private ConocimientoExperto conocExperto;
	
	@BeforeEach
	public void setUp() {
		
		
		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		user3 = mock(Usuario.class);
		noRespuesta = new RespuestaNoDefinida();
		ImagenPocoClara = new RespuestaImagenPocoClara();
		conocBasico = new ConocimientoBasico();
		conocExperto = new ConocimientoExperto();
		when(user.getConocimiento()).thenReturn(conocBasico);
		when(user2.getConocimiento()).thenReturn(conocBasico);
		when(user3.getConocimiento()).thenReturn(conocExperto);
		opinion1 = new Opinion(user, ImagenPocoClara);
		opinion2 = new Opinion(user2, noRespuesta);
		opinion3 = new Opinion(user3,null);
		
	
	}
	
	@Test
	public void opinionRespuesta(){
		
		assertEquals("ImagenPocaClara",opinion1.nombreDelInsecto());
		assertEquals("No definido",opinion2.nombreDelInsecto());
		
	}
	
	@Test
	public void seLePuedePedirLaFechaEnviadaALaOpinion() {
		assertEquals(LocalDate.now() , opinion1.getFechaEnviada());
	}
	@Test
	public void seLePuedePedirElUserALaOpinion() {
		assertEquals(user2 , opinion2.getUser());
	}
	
	@Test
	public void tipoDeConocimientoDeLaOpinion() {
		
		assertEquals("Basico",opinion1.tipoDeConocimientoAlaHoraDeOpinar());
		assertEquals("Basico",opinion2.tipoDeConocimientoAlaHoraDeOpinar());
		assertEquals("Experto",opinion3.tipoDeConocimientoAlaHoraDeOpinar());
		
	}
}
