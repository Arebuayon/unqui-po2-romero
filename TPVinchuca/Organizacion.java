package ar.edu.unq.po2.TPVinchuca;


public  class Organizacion {
	
	private TipoDeOrganizacion tipoDeOrganizacion;
	private Ubicacion ubicacion;
	private Integer cantidadePersonas;	
	private IFuncionalidadExterna funcionalidadExternaParaValidacion;
	private IFuncionalidadExterna funcionalidadExternaParaNuevaMuestra;
	
	
	public Organizacion(Ubicacion ubicacion, Integer cantidadePersonas, TipoDeOrganizacion tipoDeOrganizacion) {
		
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.ubicacion = ubicacion;
		this.cantidadePersonas = cantidadePersonas;
	
	}
	
	public void setFuncionalidadExternaParaValidacion(IFuncionalidadExterna funcionalidad) {
		
		this.funcionalidadExternaParaValidacion = funcionalidad;
	}
	
	public void setFuncionalidadExternaParaNuevaMuestra(IFuncionalidadExterna funcionalidad) {
		
		this.funcionalidadExternaParaNuevaMuestra = funcionalidad;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
			
	public TipoDeOrganizacion getTipoDeOrganizacion(){
		return this.tipoDeOrganizacion;
	}
	public int getCantidadePersonas() {
		return cantidadePersonas;
	}

	public void setCantidadePersonas(Integer cantidadePersonas) {
		this.cantidadePersonas = cantidadePersonas;
	}

	public void ejecutarFuncionalidadDeNuevaMuestra(Muestra muestra, ZonaDeCobertura zona) {
		this.funcionalidadExternaParaNuevaMuestra.nuevoEvento(this, zona, muestra);
	}

	public void ejecutarFuncionalidadDeNuevaValidacion(Muestra muestra, ZonaDeCobertura zonaDeCobertura) {
		
		this.funcionalidadExternaParaValidacion.nuevoEvento(this, zonaDeCobertura, muestra); ;
	}
	
	
}