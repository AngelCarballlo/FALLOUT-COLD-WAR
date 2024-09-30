package Utils;


public class Datos {

	private String nombre;
	private int victorias;
	
	public Datos(String nombre, int victorias) {
		// TODO Auto-generated constructor stub
		
		this.nombre=nombre;
		this.victorias=victorias;
		
	}
	//getter y setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
}
