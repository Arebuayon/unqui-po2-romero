package ar.edu.unq.po2.TPVinchuca;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPVichuca.FiltroPorFechaDeCreacionMayorA;
import ar.edu.unq.po2.TPVichuca.FiltroPorFechaDeCreacionMenorA;
import ar.edu.unq.po2.TPVichuca.FiltroPorFechaDeUltimaVotacionMayorA;
import ar.edu.unq.po2.TPVichuca.FiltroPorFechaDeUltimaVotacionMenorA;
import ar.edu.unq.po2.TPVichuca.FiltroPorNivelDeVerificacion;
import ar.edu.unq.po2.TPVichuca.Muestra;



class FiltroTest {
	FiltroPorFechaDeCreacionMayorA filtroFechaMayorA1;
	FiltroPorFechaDeCreacionMenorA filtroFechaMenorA1;
	FiltroPorFechaDeUltimaVotacionMenorA filtroFechaVotacionMenorA1;
	FiltroPorFechaDeUltimaVotacionMayorA filtroFechaVotacionMayorA1;
	FiltroPorNivelDeVerificacion filtroPorNivelDeVerificacion1;
	ArrayList<Muestra>muestras=new ArrayList<Muestra>();
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	
	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
	}

	@Test
	void testSePuedeFiltrarPorNivelDeVerificacion() {
		when(muestra1.getNivelDeVerificacion()).thenReturn("verificada");
		when(muestra2.getNivelDeVerificacion()).thenReturn("verificada");
		when(muestra3.getNivelDeVerificacion()).thenReturn("votada");
		
		
		
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra1);
		listaDeRespuesta.add(muestra2);
		filtroPorNivelDeVerificacion1 = new FiltroPorNivelDeVerificacion("verificada");
		
		assertEquals(listaDeRespuesta, filtroPorNivelDeVerificacion1.filtrar(muestras));
	}
	
	@Test
	void testSePuedeFiltrarPorFechaMayorA() {
		when(muestra1.getFechaCreada()).thenReturn(LocalDate.of(2020, 3, 17));
		when(muestra2.getFechaCreada()).thenReturn(LocalDate.of(2020, 1, 19));
		when(muestra3.getFechaCreada()).thenReturn(LocalDate.of(2020, 3, 2));
		
		
		
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra1);
		listaDeRespuesta.add(muestra3);
		filtroFechaMayorA1 = new FiltroPorFechaDeCreacionMayorA(LocalDate.of(2020, 3, 1));
		
		assertEquals(listaDeRespuesta, filtroFechaMayorA1.filtrar(muestras));
	}
	
	@Test
	void testSePuedeFiltrarPorFechaMenorA() {
		when(muestra1.getFechaCreada()).thenReturn(LocalDate.of(2020, 3, 17));
		when(muestra2.getFechaCreada()).thenReturn(LocalDate.of(2020, 1, 19));
		when(muestra3.getFechaCreada()).thenReturn(LocalDate.of(2020, 3, 2));
		
		
		
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra2);
		filtroFechaMenorA1 = new FiltroPorFechaDeCreacionMenorA(LocalDate.of(2020, 3, 1));
		
		assertEquals(listaDeRespuesta, filtroFechaMenorA1.filtrar(muestras));
	}
	
	@Test
	void testSePuedeFiltrarPorFechaDeUltimaVotacionMayorA() {
		when(muestra1.getFechaDeUltimaVotacion()).thenReturn(LocalDate.of(2020, 6, 13));
		when(muestra2.getFechaDeUltimaVotacion()).thenReturn(LocalDate.of(2020, 8, 19));
		when(muestra3.getFechaDeUltimaVotacion()).thenReturn(LocalDate.of(2020, 10, 20));
		
		
		
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra3);
		filtroFechaVotacionMayorA1 = new FiltroPorFechaDeUltimaVotacionMayorA(LocalDate.of(2020, 9, 1));
		
		assertEquals(listaDeRespuesta,  filtroFechaVotacionMayorA1.filtrar(muestras));
	}
	
	@Test
	void testSePuedeFiltrarPorFechaDeUltimaVotacionMenorA() {
		when(muestra1.getFechaDeUltimaVotacion()).thenReturn(LocalDate.of(2020, 6, 13));
		when(muestra2.getFechaDeUltimaVotacion()).thenReturn(LocalDate.of(2020, 8, 19));
		when(muestra3.getFechaDeUltimaVotacion()).thenReturn(LocalDate.of(2020, 10, 20));
		
		
		
		ArrayList<Muestra> listaDeRespuesta = new ArrayList<Muestra>();
		listaDeRespuesta.add(muestra1);
		listaDeRespuesta.add(muestra2);
		filtroFechaVotacionMenorA1 = new FiltroPorFechaDeUltimaVotacionMenorA(LocalDate.of(2020, 9, 1));
		
		assertEquals(listaDeRespuesta,  filtroFechaVotacionMenorA1.filtrar(muestras));
	}

}
