package ar.edu.unq.po2.TPVinchuca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisyuncionDeFiltros extends FiltroDeMuestra {

	FiltroDeMuestra filtro1;
	FiltroDeMuestra filtro2;
	
	
	public DisyuncionDeFiltros(FiltroDeMuestra filtroA,FiltroDeMuestra filtroB) {
		this.filtro1=filtroA;
		this.filtro2=filtroB;
	}
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		ArrayList<Muestra> listaResultado = new ArrayList<Muestra>();
		listaResultado.addAll(this.filtro1.filtrar(muestras));
		listaResultado.addAll(this.filtro2.filtrar(muestras));
		return listaResultado.stream().distinct().collect(Collectors.toList());
	}

}
