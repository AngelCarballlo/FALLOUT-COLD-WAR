package Utils;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ClasePadre.Jugador;

public class Recursos {

	public static Font SoleSurvivor = loadFont("src/SoleSurvivor.ttf", 36);
	public static Font SoleSurvivor2 = loadFont("src/SoleSurvivor.ttf", 50);
	public static Font SoleSurvivor3 = loadFont("src/SoleSurvivor.ttf", 44);
	public static Font SoleSurvivor4 = loadFont("src/SoleSurvivor.ttf", 60);
	public static int ronda = 0;
	public static int jugadoresMuertos = 0;
	public static List<Jugador> ganador = new ArrayList<>();
	public static List<Jugador> listaJugador = new ArrayList<>();
	
	private static Font loadFont(String path, float size) {
		try {
			// Cargar el archivo de fuente
			File file = new File(path);
			Font font = Font.createFont(Font.TRUETYPE_FONT, file);

			// Escalar la fuente al tamaño especificado
			font = font.deriveFont(size);
			return font;
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}
}
