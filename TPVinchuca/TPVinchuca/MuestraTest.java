package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





class MuestraTest {

	private Muestra muestra1;
	private Usuario user;
	private Usuario user2;
	private Ubicacion lugar;
	private Opinion opinionUser;
	private BufferedImage foto;
	private IClasificacion respuesta1;
	private IClasificacion respuesta2;
	private Opinion otraOpinion1;
	private Opinion otraOpinion2;

	@BeforeEach
	public void setUp() {
		
		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		lugar = mock(Ubicacion.class);
		opinionUser = mock(Opinion.class);
		foto = mock(BufferedImage.class);
		respuesta1 = mock(IClasificacion.class); 
		otraOpinion1 = mock(Opinion.class);
		otraOpinion2 = mock(Opinion.class);
		respuesta2 = mock(IClasificacion.class);
		muestra1 = new Muestra(user, foto, lugar , opinionUser);
	}
	
	@Test
	public void testMuestra() {
		
		assertFalse(muestra1.getOpiniones().isEmpty());
		
		when(respuesta1.nombreDelInsectoORespuesta()).thenReturn("Chince Foliada");
		when(respuesta2.nombreDelInsectoORespuesta()).thenReturn("no se distinge");
		when(opinionUser.getRespuesta()).thenReturn(respuesta1);
		when(opinionUser.getUser()).thenReturn(user);
		
		assertEquals("Chince Foliada",respuesta1.nombreDelInsectoORespuesta());
		assertEquals("Chince Foliada",opinionUser.getRespuesta().nombreDelInsectoORespuesta());	
	}
	@Test
	public void testSeLePuedenPedirLaUbicacionYLaFotoALaMuestra() {
		
		assertEquals(foto, muestra1.getFotoDelInsecto());
		assertEquals(lugar, muestra1.getUbicacion());
	}
	
	@Test
	public void testCantidadDeOpinionesExpertos() {
		
		when(opinionUser.getUser()).thenReturn(user);
		
		assertEquals(muestra1.cantidadDeVecesQueApareceLa(opinionUser),1);
		assertEquals(muestra1.cantidadDeVecesApareceEl(user),1);
		
		when(otraOpinion1.getRespuesta()).thenReturn(respuesta1);
		when(otraOpinion2.getRespuesta()).thenReturn(respuesta2);
		
		muestra1.getOpiniones().add(otraOpinion1);
		
		assertEquals(muestra1.cantidadDeExpertosQueOpinaron(),0); // 0/2

		when(otraOpinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
		muestra1.getOpiniones().add(otraOpinion2);
		
		assertEquals(muestra1.cantidadDeExpertosQueOpinaron(),1); // 1/3
		
	}
		
		@Test
		public void testCantidadDevecesQueApareceElUser() {
			
			when(user.getIdUser()).thenReturn(111);
			when(user2.getIdUser()).thenReturn(222);
			when(opinionUser.getUser()).thenReturn(user);
			
			muestra1 = new Muestra(user, foto, lugar , opinionUser);
			
			assertEquals(1 , muestra1.cantidadDeVecesApareceEl(user));
			assertEquals(0 , muestra1.cantidadDeVecesApareceEl(user2));
				
		}
		
		@Test
		public void testOpinionDeUser() {
			
			when(user.getIdUser()).thenReturn(111);
			when(user2.getIdUser()).thenReturn(222);
			when(otraOpinion1.getUser()).thenReturn(user2);
			when(otraOpinion1.nombreDelInsecto()).thenReturn("Vichuca");
			
			muestra1 = new Muestra(user2, foto, lugar , otraOpinion1);
			
			assertEquals(otraOpinion1,muestra1.OpinionDe(user2));
			assertEquals(null,muestra1.OpinionDe(user));
			
		}
		
		@Test
		public void testExpertoOpinaron() {
			
			when(otraOpinion1.getUser()).thenReturn(user2);
			when(otraOpinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
			when(opinionUser.getUser()).thenReturn(user);
			when(opinionUser.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Experto");
			
			muestra1 = new Muestra(user2, null, null, otraOpinion1);
			
			muestra1.getOpiniones().add(opinionUser);
			assertEquals("Bajo",muestra1.getNivelDeVerificacion());
			
			assertEquals(2,muestra1.getOpiniones().size());
			assertEquals(true,muestra1.opinaronExpertos());
			
			muestra1.cambiarEstadoVerificacion();
			assertEquals("Medio",muestra1.getNivelDeVerificacion());
			
		}
		
		@Test
		public void testTodosBasicosOpinaron() {
			
			when(otraOpinion1.getUser()).thenReturn(user2);
			when(otraOpinion1.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
			when(opinionUser.getUser()).thenReturn(user);
			when(opinionUser.tipoDeConocimientoAlaHoraDeOpinar()).thenReturn("Basico");
			
			muestra1 = new Muestra(user2, null, null, otraOpinion1);
			
			muestra1.getOpiniones().add(opinionUser);
			assertEquals(2,muestra1.getOpiniones().size());
			assertEquals(true,muestra1.opinaronTodosBasicos());
			
			muestra1.cambiarEstadoVerificacion();
			
			assertEquals("Medio",muestra1.getNivelDeVerificacion());
			
		}
		
		@Test
		public void testUltimoEmviado() {
			
			LocalDate fechaDeCreacion2 = LocalDate.of(2020,2,10);
			
			user = mock(Usuario.class);
			user2 = mock(Usuario.class);
			
			when(user.getConocimiento()).thenReturn(new ConocimientoBasico());
			when(user2.getConocimiento()).thenReturn(new ConocimientoBasico());
			
			when(user.getIdUser()).thenReturn(111);
			when(user2.getIdUser()).thenReturn(222);
			
			Opinion opinionDeUser1 = new Opinion(user, null);
			Opinion opinionDeUser2 = new Opinion(user2, null);
			
			Muestra muestra1 = new Muestra(user, null, null, opinionDeUser1 );
			muestra1.getOpiniones().add(opinionDeUser2);
			opinionDeUser2.setFechaEnviada(fechaDeCreacion2);
			
			assertEquals(LocalDate.now() ,muestra1.getFechaDeUltimaVotacion());
			
		}
			
}