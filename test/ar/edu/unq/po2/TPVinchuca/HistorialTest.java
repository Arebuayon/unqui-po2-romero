package ar.edu.unq.po2.TPVinchuca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unq.po2.TPVichuca.Historial;
import ar.edu.unq.po2.TPVichuca.Muestra;
import ar.edu.unq.po2.TPVichuca.Usuario;


public class HistorialTest {

	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;	
	private Usuario user;
	private Usuario user2;
	private Usuario user3;
	
	@BeforeEach
	public void setUp() {
		Historial.getHistorial().cleanMuestras();
		muestra1 = new Muestra(user, null, null, null);
		muestra2 = new Muestra(user2, null, null, null);
	//	user2 = mock(Usuario.class);
		user3 = mock(Usuario.class);
		
			
	}
	
	@Test
	public void historial() {
		
		
		user = new Usuario(112, null);
	
		muestra1 = new Muestra(user, null, null, null);
		ArrayList<Muestra>muestras = new ArrayList<Muestra>();
		muestras.add(muestra1);
		Historial.getHistorial().setDeMuestras(muestras);
	
		assertEquals(1,Historial.getHistorial().getListaDeMuestras().size());
		
		}
	
	@Test
	public void historialPrimeraVezQueParticipa() {
		
		
		muestra1 = new Muestra(user, null, null, null);
		
		assertTrue(Historial.getHistorial().primeraVesQueParticipa(user));
		assertTrue(Historial.getHistorial().primeraVesQueParticipa(user2));
		assertTrue(Historial.getHistorial().primeraVesQueParticipa(user3));
		ArrayList<Muestra>muestras = new ArrayList<Muestra>();
		muestras.add(muestra1);
		
		
		Historial.getHistorial().setDeMuestras(muestras);
		assertFalse(Historial.getHistorial().primeraVesQueParticipa(user));
		
	}
	
	@Test
	public void muestraDeUser() {
		
		
		
		user = new Usuario(112, null);
		user2 = new Usuario(114, null);
		
		muestra1 = new Muestra(user, null, null, null);
		muestra2 = new Muestra(user2, null, null, null);
		muestra3 = new Muestra(user, null, null, null);
		ArrayList<Muestra>muestras = new ArrayList<Muestra>();
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		
		Historial.getHistorial().setDeMuestras(muestras);
		
		assertEquals(3,Historial.getHistorial().getListaDeMuestras().size());

		assertEquals(2,Historial.getHistorial().muestrasDe(user).size());
		
	}
	
	
}