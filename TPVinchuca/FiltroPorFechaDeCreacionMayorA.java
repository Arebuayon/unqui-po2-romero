package ar.edu.unq.po2.TPVinchuca;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorFechaDeCreacionMayorA extends FiltroDeMuestra {
	
	LocalDate fecha;
	
	public FiltroPorFechaDeCreacionMayorA(LocalDate unaFecha) {
		this.fecha = unaFecha;
		
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(muestra -> muestra.getFechaCreada().isAfter(this.fecha)).collect(Collectors.toList());
	}

}

