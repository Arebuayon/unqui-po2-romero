package ar.edu.unq.po2.TPVinchuca;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorNivelDeVerificacion extends FiltroDeMuestra {
	String nivelBuscado;
	
	public FiltroPorNivelDeVerificacion(String unNivel) {
		this.nivelBuscado = unNivel;
		
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(muestra -> muestra.getNivelDeVerificacion() == this.nivelBuscado).collect(Collectors.toList());
	}
}