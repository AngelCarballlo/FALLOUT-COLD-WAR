package Eventos;

import javax.swing.*;

import ClasePadre.Jugador;
import Utils.Ganadores;
import Utils.Recursos;
import Utils.Sonidos;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class EventoPartida extends JPanel implements ActionListener {

	private JButton musica;
	private boolean on = true;
	private JLabel background = new JLabel();
	public static String resumen = "";
	private JLabel[] nombre = new JLabel[Recursos.listaJugador.size()];
	private JLabel[] vida = new JLabel[Recursos.listaJugador.size()];
	private JLabel numRonda = new JLabel();
	private JButton atacar = new JButton();
	private JComboBox<String> objetivos = new JComboBox<>();
	private JButton defenderse = new JButton();
	private JButton mas = new JButton();
	private JButton menos = new JButton();
	private JLabel jmisiles = new JLabel("0");
	private JLabel jmisilesRest = new JLabel("0");
	private JLabel[] icono = new JLabel[Recursos.listaJugador.size()];
	private JLabel[] fondo = new JLabel[Recursos.listaJugador.size()];
	private int misiles = 0;
	private List<Jugador> listaAtacar = new ArrayList<>();
	private int turno = 0;
	private Jugador jugadorActual;

	public EventoPartida() {
		setLayout(null);
		
		//si la partida acaba de empezar paramos musica anterior
		if (Recursos.ronda == 0) {
			Sonidos.pararMusica();
		}

		atacar.setEnabled(misiles > 0);
		menos.setEnabled(misiles > 0);

		// creamos los iconos y los label de nombre y vida
		for (int x = 0; x < Recursos.listaJugador.size(); x++) {
			icono[x] = new JLabel();
			nombre[x] = new JLabel();
			vida[x] = new JLabel();
			fondo[x] = new JLabel();
			if (x == (Recursos.listaJugador.size() - 1)) {
				icono[x].setBounds(100, 820, 194, 194);
				nombre[x].setBounds(160, 700, 194, 194);
				nombre[x].setForeground(new Color(122, 209, 130));
				vida[x].setBounds(496, 746, 194, 194);
				vida[x].setForeground(new Color(122, 209, 130));
				fondo[x].setBounds(0,0,0,0);
			} else {
				icono[x].setBounds(1600, 70 + (215 * x), 194, 194);
				nombre[x].setBounds(1500, 50 + (215 * x), 194, 194);
				vida[x].setBounds(1350, 50 + (215 * x), 194, 194);
				fondo[x].setBounds(1280, 43 + (215 * x), 636, 248);
				nombre[x].setForeground(Color.white);
				vida[x].setForeground(Color.white);
			}
			vida[x].setFont(Recursos.SoleSurvivor3);
			nombre[x].setFont(Recursos.SoleSurvivor3);
			add(icono[x]);
			add(nombre[x]);
			add(vida[x]);
			add(fondo[x]);
		}
		// añadimos los elementos

		
		musica = new JButton();

		musica.setBounds(1800, 920, 50, 50);

		musica.setIcon(new ImageIcon("src/fondos/musicaON.png"));

		musica.addActionListener(this);

		add(musica);

		atacar.setBounds(900, 820, 290, 57);
		atacar.setIcon(new ImageIcon("src/botones/Atacar.png"));
		atacar.setOpaque(false);
		atacar.setContentAreaFilled(false);
		add(atacar);

		numRonda.setBounds(300, 77, 50, 50);
		numRonda.setFont(Recursos.SoleSurvivor4);
		numRonda.setForeground(new Color(122, 209, 130));
		add(numRonda);

		defenderse.setBounds(900, 940, 290, 57);
		defenderse.setIcon(new ImageIcon("src/botones/Defenderse.png"));
		defenderse.setOpaque(false);
		defenderse.setContentAreaFilled(false);
		add(defenderse);

		mas.setIcon(new ImageIcon("src/botones/+.png"));
		mas.setBounds(750, 820, 60, 60);
		mas.setOpaque(false);
		mas.setContentAreaFilled(false);
		add(mas);

		menos.setIcon(new ImageIcon("src/botones/-.png"));
		menos.setBounds(750, 940, 60, 60);
		menos.setOpaque(false);
		menos.setContentAreaFilled(false);
		add(menos);

		jmisiles.setBounds(763, 877, 50, 50);
		jmisiles.setFont(Recursos.SoleSurvivor3);
		jmisiles.setForeground(new Color(122, 209, 130));
		add(jmisiles);

		jmisilesRest.setBounds(496, 877, 50, 50);
		jmisilesRest.setFont(Recursos.SoleSurvivor3);
		jmisilesRest.setForeground(new Color(122, 209, 130));
		add(jmisilesRest);

		objetivos.setBounds(320, 940, 290, 57);
		objetivos.setFont(Recursos.SoleSurvivor);
		objetivos.setForeground(new Color(122, 209, 130));
		objetivos.setOpaque(false);
		objetivos.setBackground(new Color(0, 17, 2));
		add(objetivos);

//		resumenRonda.setEditable(false);
//		resumenRonda.setFont(Recursos.SoleSurvivor);
//		resumenRonda.setForeground(Color.WHITE);
//		resumenRonda.setBackground(Color.BLACK);
//		Panel.setBounds(100, 300, 500, 350);
//		add(Panel);

		atacar.addActionListener(this);
		defenderse.addActionListener(this);
		mas.addActionListener(this);
		menos.addActionListener(this);

		background.setIcon(new ImageIcon("src/fondos/FONDOPARAPARTIDA2.png"));
		background.setBounds(0, 0, 1920, 1080);
		add(background);
		// enseñamos ronda. Llamamos al metodo que inicia la partida

		// si la partida acaba de enseñar ponemos musica
		if (Recursos.ronda == 0) {
			Sonidos.playMusica2();
		}
		
		Recursos.ronda++;
		empezar();

	}

	private void empezar() {
		if (turno >= Recursos.listaJugador.size()) {
			comprobar();
//			anadirResumen(resumen);
//			resumen = "";
			turno = 0;
			Jugador.Comprobaciones(Recursos.listaJugador, Recursos.ronda);
			JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
			evento.remove(this);
			evento.add(new EventoResumen());
			evento.setVisible(true);
//			Recursos.ronda++;

		}

		numRonda.setText("" + Recursos.ronda);

		jugadorActual = Recursos.listaJugador.get(turno);

		if (!jugadorActual.getVivo()) {
			turno++;
			empezar();
			// si esta muerto vuelvo a empezar
			return;
		}

		switch (jugadorActual.getTipo()) {
		case 1:
			icono[Recursos.listaJugador.size() - 1].setIcon(new ImageIcon("src/iconos/Kings2.png"));
			break;
		case 2:
			icono[Recursos.listaJugador.size() - 1].setIcon(new ImageIcon("src/iconos/BoS2.png"));
			break;
		case 3:
			icono[Recursos.listaJugador.size() - 1].setIcon(new ImageIcon("src/iconos/Enclave2.png"));
			break;
		case 4:
			icono[Recursos.listaJugador.size() - 1].setIcon(new ImageIcon("src/iconos/cesar2.png"));
			break;
		case 5:
			icono[Recursos.listaJugador.size() - 1].setIcon(new ImageIcon("src/iconos/NCR3.png"));
			break;
		}

		misiles = 0;
		jmisiles.setText("" + misiles);
		jmisilesRest.setText("" + jugadorActual.getMisiles());
		vida[Recursos.listaJugador.size() - 1].setText("" + jugadorActual.getVida());
		nombre[Recursos.listaJugador.size() - 1].setText("" + jugadorActual.getNombre());

		// apagamos los botones
		atacar.setEnabled(false);
		menos.setEnabled(false);
		defenderse.setEnabled(false);

		// mostramos los turnos en el textArea
//		anadirResumen("Turno de: " + jugadorActual.getNombre());

		listaAtacar.clear();
		objetivos.removeAllItems();

		// rellenamos lista de ataque con los jugadores que no sean el que ataca
		for (Jugador otro : Recursos.listaJugador) {
			if (!jugadorActual.getNombre().equals(otro.getNombre()) && otro.getVivo()) {
				listaAtacar.add(otro);
			}
		}

		// mostramos el icono de cada jugador con su nombre y vida
		for (int x = 0; x < listaAtacar.size(); x++) {
			
			fondo[x].setIcon(new ImageIcon("src/fondos/fondoPartida2.png"));
			
			switch (listaAtacar.get(x).getTipo()) {
			case 1:
				icono[x].setIcon(new ImageIcon("src/iconos/Kings2.png"));
				break;
			case 2:
				icono[x].setIcon(new ImageIcon("src/iconos/BoS2.png"));
				break;
			case 3:
				icono[x].setIcon(new ImageIcon("src/iconos/Enclave2.png"));
				break;
			case 4:
				icono[x].setIcon(new ImageIcon("src/iconos/cesar2.png"));
				break;
			case 5:
				icono[x].setIcon(new ImageIcon("src/iconos/NCR2.png"));
				break;
			}
			nombre[x].setText("" + listaAtacar.get(x).getNombre());
			vida[x].setText("" + listaAtacar.get(x).getVida());
		}

		for (Jugador objetivo : listaAtacar) {
			objetivos.addItem(objetivo.getNombre());
		}
	}

	// funcion para añadir elementos al textarea
//	private void anadirResumen(String s) {
//		resumenRonda.append(s + "\n");
//		resumenRonda.setCaretPosition(resumenRonda.getDocument().getLength());
//	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(musica)) {

			if (!on) {
				on = true;
				Sonidos.playMusica2();
				musica.setIcon(new ImageIcon("src/fondos/musicaON.png"));
			} else {
				on = false;
				musica.setIcon(new ImageIcon("src/fondos/musicaOFF.png"));
				Sonidos.pararMusica();
			}

		}

		if (e.getSource() == atacar) {
			Sonidos.playEnter();
			if (objetivos.getSelectedIndex() >= 0) {
				resumen += (jugadorActual.Atacar(misiles, listaAtacar.get(objetivos.getSelectedIndex()),
						Recursos.ronda));
				jmisilesRest.setText("" + jugadorActual.getMisiles());

			}
			if (jugadorActual.getMisiles() == 0) {
				turno++;
				empezar();
			}
		} else if (e.getSource() == defenderse) {
			Sonidos.playEnter();

			resumen += (jugadorActual.Defenderse(misiles));
			jmisilesRest.setText("" + jugadorActual.getMisiles());

			if (jugadorActual.getMisiles() == 0) {
				turno++;
				empezar();
			}

		} else if (e.getSource() == mas) {

			misiles++;
			jmisiles.setText("" + misiles);

		} else if (e.getSource() == menos) {

			misiles--;
			jmisiles.setText("" + misiles);
		}

		menos.setEnabled(misiles > 0);
		mas.setEnabled(misiles < jugadorActual.getMisiles());
		if (misiles <= jugadorActual.getMisiles() && misiles != 0) {
			atacar.setEnabled(true);
		} else {
			atacar.setEnabled(false);
		}
		if (misiles <= jugadorActual.getMisiles() && misiles != 0) {
			defenderse.setEnabled(true);
		} else {
			defenderse.setEnabled(false);
		}
	}

	private void comprobar() {
		// Update game state after an action
		for (Jugador jugador : Recursos.listaJugador) {
			if (jugador.getVida() <= 0 && jugador.getVivo()) {
				jugador.setVivo(false);
				Recursos.jugadoresMuertos++;
				resumen += (jugador.getNombre() + " ha sido eliminado");
				icono[(Recursos.listaJugador.size() - (Recursos.jugadoresMuertos + 1))].setBounds(0, 0, 0, 0);
				fondo[(Recursos.listaJugador.size() - (Recursos.jugadoresMuertos + 1))].setBounds(0, 0, 0, 0);
				nombre[(Recursos.listaJugador.size() - (Recursos.jugadoresMuertos + 1))].setBounds(0, 0, 0, 0);
				vida[(Recursos.listaJugador.size() - (Recursos.jugadoresMuertos + 1))].setBounds(0, 0, 0, 0);
			}
		}
		// si es empate mostramos y termina
		if (Recursos.jugadoresMuertos == Recursos.listaJugador.size()) {
			terminarJuego();
			JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
			evento.remove(this);
			evento.add(new EventoEmpate());
			evento.setVisible(true);
			// si queda uno vivo mostramos y termina
		} else if (Recursos.jugadoresMuertos == Recursos.listaJugador.size() - 1) {
			for (Jugador jugador : Recursos.listaJugador) {
				if (jugador.getVivo()) {
					Recursos.ganador.add(jugador);
					Ganadores.agregarGanador(jugador.getNombre());
					terminarJuego();
					JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
					evento.remove(this);
					evento.add(new EventoVictoria());
					evento.setVisible(true);
				}
			}
		}
	}

	private void terminarJuego() {
		// End the game and reset state
		Recursos.listaJugador.clear();
		Recursos.jugadoresMuertos = 0;
		Recursos.ronda = 0;
		misiles = 0;
	}
}
