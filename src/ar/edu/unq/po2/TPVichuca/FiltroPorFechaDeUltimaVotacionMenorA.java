package ar.edu.unq.po2.TPVichuca;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorFechaDeUltimaVotacionMenorA extends FiltroDeMuestra {
	LocalDate fecha;

	public FiltroPorFechaDeUltimaVotacionMenorA (LocalDate fecha) {
		this.fecha = fecha;
		
	}
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(muestra -> muestra.getFechaDeUltimaVotacion().isBefore(this.fecha))
				.collect(Collectors.toList());
	}

}
