package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ganadores {

	static List<Datos> listaDatos = new ArrayList<>();
	static boolean nombreIgual = false;

	// Método para agregar un ganador al archivo Ganadores.txt
	public static void agregarGanador(String nombre) {

		try {

			// vaciamos la lista
			listaDatos.clear();

			// probamos si existe el documento y si no existe lo creamos
			try {
				FileReader fr = new FileReader("src/Ganadores.txt");
			} catch (IOException e) {
				FileWriter fw = new FileWriter("src/Ganadores.txt", false);
			}
			// leemos el documento
			FileReader fr = new FileReader("src/Ganadores.txt");
			BufferedReader br = new BufferedReader(fr);

			String linea = "";

			do {

				// registramos cada linea
				linea = br.readLine();

				// verificar que la linea no esta vacia
				if (linea != null) {

					// la partimos en dos
					String[] partes = linea.split(" ");

					// si tiene dos partes (No es el titulo) guardamos en la lista

					// si nombre ya existe lo añado a la lista y a la segunda parte le sumo 1
					if (partes[0].equals(nombre)) {
						listaDatos.add(new Datos(nombre, (Integer.parseInt(partes[1]) + 1)));

						// guardo que ya existe
						nombreIgual = true;

						// si no existe lo añado la linea sin modificar a la lista
					} else {
						listaDatos.add(new Datos(partes[0], Integer.parseInt(partes[1])));

					}

				}
			} while (linea != null);

			// si el nombre no existe despues de leer todo el documento lo añado a la lista
			// con un 1
			if (nombreIgual == false) {
				listaDatos.add(new Datos(nombre, 1));
			}

			// reescribo el documento con lo almacenado en la lista
			FileWriter fw = new FileWriter("src/Ganadores.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);

			// printo la lista
			for (Datos d : listaDatos) {

				bw.write(d.getNombre() + " " + d.getVictorias() + "\n");

			}

			bw.close();
			br.close();
		} catch (

		IOException e) {
			System.out.println("ERROR E/R " + e);
		}
	}

	public static String leerGanadores() {

		String s = "";
		String ganadores = "";
		try {
			// Abrir el fichero indicado en la variable nombreFichero
			FileReader fr = new FileReader("src/Ganadores.txt");
			BufferedReader br = new BufferedReader(fr);

			do {
				s = br.readLine();

				if (s != null) {
					ganadores += s + "\n";
				}

			} while (s != null);

			return ganadores;
		} catch (IOException e) {
			return "Error";
		}

	}

}