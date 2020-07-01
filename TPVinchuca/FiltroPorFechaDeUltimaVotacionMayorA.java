package ar.edu.unq.po2.TPVinchuca;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorFechaDeUltimaVotacionMayorA extends FiltroDeMuestra {
	LocalDate fecha;

	public FiltroPorFechaDeUltimaVotacionMayorA (LocalDate fecha) {
		this.fecha = fecha;
		
	}
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(muestra -> muestra.getFechaDeUltimaVotacion().isAfter(this.fecha))
				.collect(Collectors.toList());
	}
}