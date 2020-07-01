package ar.edu.unq.po2.TPVinchuca;

import java.util.List;

public class ConjuncionDeFiltros extends FiltroDeMuestra{

	FiltroDeMuestra filtro1;
	FiltroDeMuestra filtro2;
	
	
	public ConjuncionDeFiltros(FiltroDeMuestra filtroA,FiltroDeMuestra filtroB) {
		this.filtro1=filtroA;
		this.filtro2=filtroB;
	}
	
	
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return filtro2.filtrar(filtro1.filtrar(muestras));
	}
	
}
