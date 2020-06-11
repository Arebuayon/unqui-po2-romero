package ar.edu.unq.po2.TPVichuca;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorTipoDeInsecto extends FiltroDeMuestra {
	
	String tipoABuscar;
	
	public FiltroPorTipoDeInsecto(String tipoABuscar) {
		this.tipoABuscar = tipoABuscar;
		
	}
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(muestra -> muestra.opinionActual().nombreDelInsecto() == tipoABuscar).collect(Collectors.toList());
	}

}
