package ar.edu.unq.po2.TPVichuca;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorFechaDeCreacionMenorA extends FiltroDeMuestra {
	
	LocalDate fecha;
	
	public FiltroPorFechaDeCreacionMenorA(LocalDate unaFecha) {
		this.fecha = unaFecha;
		
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(muestra -> muestra.getFechaCreada().isBefore(this.fecha)).collect(Collectors.toList());
	}

}
