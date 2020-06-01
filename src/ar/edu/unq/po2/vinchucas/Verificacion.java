package ar.edu.unq.po2.vinchucas;

import java.util.ArrayList;

public abstract class Verificacion {

	

	public abstract Opinion verificar();
	public abstract ArrayList<Opinion> OpinionesDeUsuarios(Muestra muestra);
	public abstract Opinion opinionActual(Muestra muestra);
	
}