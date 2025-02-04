package Tipos;
import ClasePadre.Jugador;

public class NCR extends Jugador{

	public NCR(String nombre, int tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}

	public String Atacar(int misiles, Jugador j, int ronda) {
		String resultado = "";
		int esquivados = 0;

		this.misiles_ronda -= misiles;

		// si el tipo es 6 comprobamos si esquiva

		if (j.getTipo() == 1) {
			for (int x = 0; x < misiles; x++) {

				if (2 == (int) (Math.floor(Math.random() * (2 - 1 + 1)) + 1)) {
					esquivados++;
				}
			}
		}
		j.setVida(j.getVida() - (misiles - esquivados));
		resultado = nombre + " ha atacado a " + j.getNombre() + " con " + misiles + " misiles.\n";
		
		if (esquivados > 0) {
			resultado = resultado + "Esquiva: " + esquivados + "\n";
		}
		return resultado;
	}
}
