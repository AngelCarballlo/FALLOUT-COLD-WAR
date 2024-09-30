package ClasePadre;

import java.util.List;

public abstract class Jugador {

	// variables

	protected String identif;
	protected String nombre;
	protected int vida;
	protected int misiles_ronda;
	protected int tipo;
	protected boolean vivo;
	// atributo estatico
	public static int numeroEquipos = 0;

	// constructor
	public Jugador(String nombre, int tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		switch (tipo) {
		case 1, 5:
			vida = 200;
			if (tipo == 5) {
				misiles_ronda = 75;
			} else {
				misiles_ronda = 50;
			}
			break;
		case 4:
			vida = 200;
			misiles_ronda=25;
			break;
		default:
			vida = 400;
			if (tipo == 2) {
				misiles_ronda = 10;
			} else {
				misiles_ronda = 50;
			}
		}
		this.vivo = true;

	}

	// setters

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	public void setVida(int vida) {

		this.vida = vida;

	}

	public void setMisiles(int misiles_ronda) {

		this.misiles_ronda = misiles_ronda;

	}

	public void setTipo(int tipo) {

		this.tipo = tipo;
	}

	public void setIdentif(String identif) {

		this.identif = identif;

	}

	// getters
	public String getNombre() {

		return nombre;

	}

	public int getVida() {

		return vida;

	}

	public int getMisiles() {

		return misiles_ronda;

	}

	public int getTipo() {

		return tipo;

	}

	public String getIdentif() {

		return identif;

	}

	public boolean getVivo() {

		return vivo;

	}

	// METODO DE ATAQUE ABSTRACTO QUE SE IMPLEMENTA EN CADA CLASE HIJA
	public abstract String Atacar(int misiles, Jugador j, int ronda);

	public String Defenderse(int misiles) {

		this.misiles_ronda = this.misiles_ronda - misiles;
		if (this.tipo == 5) {
			this.vida += misiles;
		} else {
			this.vida += misiles / 2;
		}
		String resultado = nombre + " se ha defendido con " + misiles + " misiles. \n";
		return resultado;

	}

	// COMPROBACIONES FINAL DE RONDA
	public static void Comprobaciones(List<Jugador> listaJugador, int ronda) {
		for (int x = 0; x < listaJugador.size(); x++) {

			// Comprobamos el tipo del jugador para establecer su vida y misiles.
			switch (listaJugador.get(x).getTipo()) {
			case 2, 3:
				if (listaJugador.get(x).getVida() > 400) {
					listaJugador.get(x).setVida(400);
				}
				if (listaJugador.get(x).getTipo() == 2) {
					listaJugador.get(x).setMisiles(10 + (10 * (ronda)));
				} else {
					listaJugador.get(x).setMisiles(50);
				}
				break;
			default:
				if (listaJugador.get(x).getVida() > 200) {
					listaJugador.get(x).setVida(200);
				}
				if (listaJugador.get(x).getTipo() == 5) {
					listaJugador.get(x).setMisiles(75);
				} else if (listaJugador.get(x).getTipo() == 4) {
					listaJugador.get(x).setMisiles(25);
				}else  {
					listaJugador.get(x).setMisiles(50);
				}
			}
		}
	}
}
