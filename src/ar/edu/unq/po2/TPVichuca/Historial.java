package ar.edu.unq.po2.TPVichuca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Historial {
	
	private ArrayList<Muestra> listaDeMuestras;
	private EvaluadorDeConocimiento evaluador;
	private ArrayList<ZonaDeCobertura> listaDeZonas;
	

	public Historial() {
		this.listaDeMuestras = new ArrayList<Muestra>();
		this.evaluador = new EvaluadorDeConocimiento();
		this.listaDeZonas = new ArrayList<ZonaDeCobertura>();
	}
	
	public EvaluadorDeConocimiento getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(EvaluadorDeConocimiento evalu) {
		evaluador = evalu;
	}
	public ArrayList<Muestra> getListaDeMuestras() {
		return listaDeMuestras;
	}

	public void agregarMuestra(Muestra muestra) {
		agregarConocimientoAParticipanteNuevo(muestra.getUser());
		listaDeMuestras.add(muestra);
		this.notificarZonasPorNuevaMuestra(muestra);
		
	}
	
	private void notificarZonasPorNuevaMuestra(Muestra muestra) {
		List<ZonaDeCobertura> zonasDeLaMuestra = this.listaDeZonas.stream().filter(zona -> perteneceMuestraAZona(zona , muestra)).collect(Collectors.toList());
		zonasDeLaMuestra.forEach(zona -> zona.notificarOrganizacionesPorNuevaMuestra(muestra));
		
	}

	public List<Muestra> muestrasDeZona(ZonaDeCobertura zona){
		return this.listaDeMuestras.stream()
				.filter(muestra -> perteneceMuestraAZona(zona , muestra)).collect(Collectors.toList());
		}

	private boolean perteneceMuestraAZona(ZonaDeCobertura zona, Muestra muestra) {
		
		return zona.getEpicentro().distanciaAOtraUbicacion(muestra.getUbicacion()) < zona.getRadio();
	}

	public void agregarConocimientoAParticipanteNuevo(Usuario user) {
		ConocimientoBasico basico = new ConocimientoBasico();
			if(this.primeraVesQueParticipa(user)) {
				user.setConocimiento(basico);
			}
	}
	
	public boolean primeraVesQueParticipa(Usuario user) {
		boolean participo = true;
			for(Muestra muestraActual : this.listaDeMuestras) {
				if(muestraActual.getUser() == user || muestraActual.cantidadDeVecesApareceEl(user) > 0 ) {
					participo = false;
				}
			}
		return participo;
	}
	
	public ArrayList<Muestra> muestrasDe(Usuario user){
		ArrayList<Muestra> listaDeMuestrasDe = new ArrayList<Muestra>();
			for(Muestra muestraActual : this.listaDeMuestras) {
				if(muestraActual.getUser() == user) {
					listaDeMuestrasDe.add(muestraActual);
				}
			}
		return listaDeMuestrasDe;
	}
	
	public ArrayList<Opinion> opinionesDe(Usuario user){
		ArrayList<Opinion> listaDeOpinionesDe = new ArrayList<Opinion>();
			for(Muestra muestraActual : this.listaDeMuestras) {
				listaDeOpinionesDe.addAll(muestraActual.listaDeOpinionesDe(user));
			}
		return listaDeOpinionesDe;
	}


	public List<Opinion> opinionesHace30DiasDe(Usuario user) {		
		LocalDate fechaActual = LocalDate.now();
		return this.opinionesDe(user).stream()
			.filter(opinion -> pasaronMenosDe30DiasEntre(fechaActual , opinion.getFechaEnviada()))
			.collect(Collectors.toList());
		}
		
	

	private boolean pasaronMenosDe30DiasEntre(LocalDate fechaActual, LocalDate fechaEnviada) {
		
		return DiferenciaEntreDias(fechaActual , fechaEnviada) <= 30;
	}

	private long DiferenciaEntreDias(LocalDate fechaActual, LocalDate fechaEnviada) {
		
		return ChronoUnit.DAYS.between(fechaActual, fechaEnviada);
	}

	public List<Muestra> muestrasHace30DiasDe(Usuario user) {
		LocalDate fechaActual = LocalDate.now();
		return this.muestrasDe(user).stream()
				.filter(muestra -> pasaronMenosDe30DiasEntre(fechaActual, muestra.getFechaCreada()))
				.collect(Collectors.toList());
		
	}

	

}
