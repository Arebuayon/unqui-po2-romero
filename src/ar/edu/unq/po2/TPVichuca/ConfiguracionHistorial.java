package ar.edu.unq.po2.TPVichuca;

public class ConfiguracionHistorial {
	 private Historial historial;
	 private static ConfiguracionHistorial miconfiguracion;
	 
	 public  static ConfiguracionHistorial getConfiguracion() {
	 
	 if (miconfiguracion==null) {
	 
	 miconfiguracion=new ConfiguracionHistorial();
	 }
	 return miconfiguracion;
	 }
	 
	 private ConfiguracionHistorial(){
	 
	 }

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}
}
