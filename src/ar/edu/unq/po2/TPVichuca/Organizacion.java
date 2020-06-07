package ar.edu.unq.po2.TPVichuca;


public  class Organizacion {
	
	private TipoDeOrganizacion tipoDeOrganizacion;
	private Ubicacion ubicacion;
	private Integer cantidadePersonas;	
	private IFuncionalidadExterna funcionalidadExternaParaValidacion;
	private IFuncionalidadExterna funcionalidadExternaParaNuevaMuestra;
	
	
	public Organizacion(Ubicacion ubicacion, Integer cantidadePersonas, TipoDeOrganizacion tipoDeOrganizacion) {
		super();
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.ubicacion = ubicacion;
		this.cantidadePersonas = cantidadePersonas;
	
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCantidadePersonas() {
		return cantidadePersonas;
	}

	public void setCantidadePersonas(Integer cantidadePersonas) {
		this.cantidadePersonas = cantidadePersonas;
	}

	public void ejecutarFuncionalidadDeNuevaMuestra(Muestra muestra, ZonaDeCobertura zona) {
		this.funcionalidadExternaParaNuevaMuestra.nuevoEvento(this, zona, muestra);
	}
	
	
}
