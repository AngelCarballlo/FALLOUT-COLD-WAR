package Eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ClasePadre.Jugador;
import Tipos.BoS;
import Tipos.Caesar;
import Tipos.Enclave;
import Tipos.NCR;
import Tipos.TheKings;
import Utils.Recursos;
import Utils.Sonidos;

public class EventoEquipos extends JPanel implements ActionListener {

	private JLabel background = new JLabel();
	private boolean contiene = false;
	private JLabel icono = new JLabel();
	private List<String> nombres = new ArrayList<>();
	private JLabel fondoEquipo;
	private JLabel fondoEquipo4;
	private JLabel fondoEquipo5;
	private JLabel equipo;
	private JTextField nombre;
	private JButton Ayuda = new JButton();
	private JButton Atras = new JButton();
	private JButton Jugar = new JButton();
	private JButton Anadir = new JButton();
	private JButton Eliminar = new JButton();
	private JComboBox<String> lista;
	private JLabel equipo2;
	private JTextField nombre2;
	private JComboBox<String> lista2;
	private JLabel icono2 = new JLabel();
	private JLabel equipo3;
	private JTextField nombre3;
	private JComboBox<String> lista3;
	private JLabel icono3 = new JLabel();
	private JLabel equipo4;
	private JTextField nombre4;
	private JComboBox<String> lista4;
	private JLabel icono4 = new JLabel();
	private JLabel equipo5;
	private JTextField nombre5;
	private JComboBox<String> lista5;
	private JLabel icono5 = new JLabel();
	private int num = 0;

	public EventoEquipos() {
		setLayout(null);

		crearBoton(Atras, "src/botones/Atras.png", 100, 900);
		crearBoton(Ayuda, "src/botones/Ayuda2.png", 360, 760);
		crearBoton(Jugar, "src/botones/Jugar.png", 620, 900);
		crearBoton(Eliminar, "src/botones/Eliminar.png", 360, 680);
		crearBoton(Anadir, "src/botones/Añadir.png", 360, 600);

		// lista Facciones1
		lista = new JComboBox<String>();
		lista.setBounds(1360, 100, 280, 50);
		lista.setFont(Recursos.SoleSurvivor);
		lista.setBackground(new Color(0,34,5));
		lista.setForeground(new Color(153, 255, 153));
		add(lista);
		lista.addActionListener(this);
		lista.addItem("Brotherhood of Steel");
		lista.addItem("The Kings");
		lista.addItem("New California Republic");
		lista.addItem("Caesar's Legion");
		lista.addItem("The Enclave");

		// icono Faccion1
		icono.setBounds(1650, 30, 194, 194);
		add(icono);

		// Jlabel Jugador1
		equipo = new JLabel("Jugador 1:");
		equipo.setFont(Recursos.SoleSurvivor);
		equipo.setForeground(new Color(153, 255, 153));
		equipo.setBounds(1020, 100, 120, 50);
		add(equipo);

		// textfield 1
		nombre = new JTextField();
		nombre.setFont(Recursos.SoleSurvivor);
		nombre.setBounds(1150, 100, 194, 50);
		nombre.setForeground(new Color(153, 255, 153));
		nombre.setBackground(new Color(0,34,5));
		add(nombre);

		// marco 1
		fondoEquipo = new JLabel();
		fondoEquipo.setIcon(new ImageIcon("src/fondos/FONDOPARAEQUIPO.png"));
		fondoEquipo.setBounds(1010, 25, 850, 200);
		add(fondoEquipo);

		// lista Facciones2
		lista2 = new JComboBox<String>();
		lista2.setBounds(1360, 300, 280, 50);
		lista2.setFont(Recursos.SoleSurvivor);
		lista2.setBackground(new Color(0,34,5));
		lista2.setForeground(new Color(153, 255, 153));
		add(lista2);
		lista2.addActionListener(this);
		lista2.addItem("Brotherhood of Steel");
		lista2.addItem("The Kings");
		lista2.addItem("New California Republic");
		lista2.addItem("Caesar's Legion");
		lista2.addItem("The Enclave");

		// icono Faccion2
		icono2.setBounds(1650, 230, 194, 194);
		add(icono2);

		// Jlabel Jugador2
		equipo2 = new JLabel("Jugador 2:");
		equipo2.setFont(Recursos.SoleSurvivor);
		equipo2.setForeground(new Color(153, 255, 153));
		equipo2.setBounds(1020, 300, 120, 50);
		add(equipo2);

		// textfield 2
		nombre2 = new JTextField();
		nombre2.setFont(Recursos.SoleSurvivor);
		nombre2.setBounds(1150, 300, 194, 50);
		nombre2.setForeground(new Color(153, 255, 153));
		nombre2.setBackground(new Color(0,34,5));
		add(nombre2);

		// marco 2
		fondoEquipo = new JLabel();
		fondoEquipo.setIcon(new ImageIcon("src/fondos/FONDOPARAEQUIPO.png"));
		fondoEquipo.setBounds(1010, 225, 850, 200);
		add(fondoEquipo);

		// lista Facciones3
		lista3 = new JComboBox<String>();
		lista3.setBounds(1360, 500, 280, 50);
		lista3.setFont(Recursos.SoleSurvivor);
		lista3.setBackground(new Color(0,34,5));
		lista3.setForeground(new Color(153, 255, 153));
		add(lista3);
		lista3.addActionListener(this);
		lista3.addItem("Brotherhood of Steel");
		lista3.addItem("The Kings");
		lista3.addItem("New California Republic");
		lista3.addItem("Caesar's Legion");
		lista3.addItem("The Enclave");

		// icono Faccion3
		icono3.setBounds(1650, 430, 194, 194);
		add(icono3);

		// Jlabel Jugador3
		equipo3 = new JLabel("Jugador 3:");
		equipo3.setFont(Recursos.SoleSurvivor);
		equipo3.setForeground(new Color(153, 255, 153));
		equipo3.setBounds(1020, 500, 120, 50);
		add(equipo3);

		// TextField 3
		nombre3 = new JTextField();
		nombre3.setFont(Recursos.SoleSurvivor);
		nombre3.setBounds(1150, 500, 194, 50);
		nombre3.setForeground(new Color(153, 255, 153));
		nombre3.setBackground(new Color(0,34,5));
		add(nombre3);

		// marco 3
		fondoEquipo = new JLabel();
		fondoEquipo.setIcon(new ImageIcon("src/fondos/FONDOPARAEQUIPO.png"));
		fondoEquipo.setBounds(1010, 425, 850, 200);
		add(fondoEquipo);

		// lista Facciones4
		lista4 = new JComboBox<String>();
		lista4.setFont(Recursos.SoleSurvivor);
		lista4.setBackground(new Color(0,34,5));
		lista4.setForeground(new Color(153, 255, 153));
		add(lista4);
		lista4.addActionListener(this);
		lista4.addItem("Brotherhood of Steel");
		lista4.addItem("The Kings");
		lista4.addItem("New California Republic");
		lista4.addItem("Caesar's Legion");
		lista4.addItem("The Enclave");

		// icono Faccion4
		add(icono4);

		// Jlabel Jugador4
		equipo4 = new JLabel("Jugador 4:");
		equipo4.setFont(Recursos.SoleSurvivor);
		equipo4.setForeground(new Color(153, 255, 153));
		add(equipo4);

		nombre4 = new JTextField();
		nombre4.setFont(Recursos.SoleSurvivor);
		nombre4.setForeground(new Color(153, 255, 153));
		nombre4.setBackground(new Color(0,34,5));
		add(nombre4);

		fondoEquipo4 = new JLabel();
		fondoEquipo4.setIcon(new ImageIcon("src/fondos/FONDOPARAEQUIPO.png"));
		add(fondoEquipo4);

		// lista Facciones5
		lista5 = new JComboBox<String>();
		lista5.setFont(Recursos.SoleSurvivor);
		lista5.setBackground(new Color(0,34,5));
		lista5.setForeground(new Color(153, 255, 153));
		add(lista5);
		lista5.addActionListener(this);
		lista5.addItem("Brotherhood of Steel");
		lista5.addItem("The Kings");
		lista5.addItem("New California Republic");
		lista5.addItem("Caesar's Legion");
		lista5.addItem("The Enclave");

		// icono Faccion5
		add(icono5);

		// Jlabel Jugador5
		equipo5 = new JLabel("Jugador 5:");
		equipo5.setFont(Recursos.SoleSurvivor);
		equipo5.setForeground(new Color(153, 255, 153));
		
		add(equipo5);

		nombre5 = new JTextField();
		nombre5.setFont(Recursos.SoleSurvivor);
		nombre5.setForeground(new Color(153, 255, 153));
		nombre5.setBackground(new Color(0,34,5));
		add(nombre5);

		fondoEquipo5 = new JLabel();
		fondoEquipo5.setIcon(new ImageIcon("src/fondos/FONDOPARAEQUIPO.png"));
		add(fondoEquipo5);

		background.setIcon(new ImageIcon("src/fondos/FONDOEQUIPOS2.png"));
		background.setBounds(0, 0, 1920, 1080);
		add(background);
	}

	private void crearBoton(JButton boton, String s, int a, int b) {
		// TODO Auto-generated method stub
		boton.setBounds(a, b, 290, 57);
		boton.addActionListener(this);
		boton.setIcon(new ImageIcon(s));
		boton.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				if (boton.isEnabled()) {
					Sonidos.play();
				}
			}
		});
		add(boton);
	}

	public void actionPerformed(ActionEvent e) {

		// mostramos al lado de cada lista su icono correspondiente

		if (e.getSource().equals(lista)) {
			String s = (String) lista.getSelectedItem();
			switch (s) {
			case "The Kings":
				icono.setIcon(new ImageIcon("src/iconos/Kings2.png"));
				break;
			case "Brotherhood of Steel":
				icono.setIcon(new ImageIcon("src/iconos/BoS2.png"));
				break;
			case "The Enclave":
				icono.setIcon(new ImageIcon("src/iconos/Enclave2.png"));
				break;
			case "Caesar's Legion":
				icono.setIcon(new ImageIcon("src/iconos/cesar2.png"));
				break;
			case "New California Republic":
				icono.setIcon(new ImageIcon("src/iconos/NCR2.png"));
				break;
			}
		}
		if (e.getSource().equals(lista2)) {
			String s2 = (String) lista2.getSelectedItem();

			switch (s2) {
			case "The Kings":
				icono2.setIcon(new ImageIcon("src/iconos/Kings2.png"));
				break;
			case "Brotherhood of Steel":
				icono2.setIcon(new ImageIcon("src/iconos/BoS2.png"));
				break;
			case "The Enclave":
				icono2.setIcon(new ImageIcon("src/iconos/Enclave2.png"));
				break;
			case "Caesar's Legion":
				icono2.setIcon(new ImageIcon("src/iconos/cesar2.png"));
				break;
			case "New California Republic":
				icono2.setIcon(new ImageIcon("src/iconos/NCR2.png"));
				break;
			}
		}

		if (e.getSource().equals(lista3)) {
			String s3 = (String) lista3.getSelectedItem();

			switch (s3) {
			case "The Kings":
				icono3.setIcon(new ImageIcon("src/iconos/Kings2.png"));
				break;
			case "Brotherhood of Steel":
				icono3.setIcon(new ImageIcon("src/iconos/BoS2.png"));
				break;
			case "The Enclave":
				icono3.setIcon(new ImageIcon("src/iconos/Enclave2.png"));
				break;
			case "Caesar's Legion":
				icono3.setIcon(new ImageIcon("src/iconos/cesar2.png"));
				break;
			case "New California Republic":
				icono3.setIcon(new ImageIcon("src/iconos/NCR2.png"));
				break;
			}
		}

		if (e.getSource().equals(lista4)) {
			String s4 = (String) lista4.getSelectedItem();

			switch (s4) {
			case "The Kings":
				icono4.setIcon(new ImageIcon("src/iconos/Kings2.png"));
				break;
			case "Brotherhood of Steel":
				icono4.setIcon(new ImageIcon("src/iconos/BoS2.png"));
				break;
			case "The Enclave":
				icono4.setIcon(new ImageIcon("src/iconos/Enclave2.png"));
				break;
			case "Caesar's Legion":
				icono4.setIcon(new ImageIcon("src/iconos/cesar2.png"));
				break;
			case "New California Republic":
				icono4.setIcon(new ImageIcon("src/iconos/NCR2.png"));
				break;
			}
		}

		if (e.getSource().equals(lista5)) {
			String s5 = (String) lista5.getSelectedItem();

			switch (s5) {
			case "The Kings":
				icono5.setIcon(new ImageIcon("src/iconos/Kings2.png"));
				break;
			case "Brotherhood of Steel":
				icono5.setIcon(new ImageIcon("src/iconos/BoS2.png"));
				break;
			case "The Enclave":
				icono5.setIcon(new ImageIcon("src/iconos/Enclave2.png"));
				break;
			case "Caesar's Legion":
				icono5.setIcon(new ImageIcon("src/iconos/cesar2.png"));
				break;
			case "New California Republic":
				icono5.setIcon(new ImageIcon("src/iconos/NCR2.png"));
				break;
			}
		}

		// boton para volver al inicio
		if (e.getSource().equals(Atras)) {
			Sonidos.playEnter();
			JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
			evento.remove(this);
			evento.add(new Evento());
			evento.setVisible(true);

		}

		// boton para añadir equipos
		if (e.getSource().equals(Anadir)) {
			Sonidos.playEnter();
			if (num >= 0 && num < 2) {
				num++;
			}
			if (num == 1) {
				equipo4.setBounds(1020, 700, 120, 50);
				nombre4.setBounds(1150, 700, 194, 50);
				lista4.setBounds(1360, 700, 280, 50);
				icono4.setBounds(1650, 630, 194, 194);
				fondoEquipo4.setBounds(1010, 625, 850, 200);
			} else if (num == 2) {
				equipo5.setBounds(1020, 900, 120, 50);
				nombre5.setBounds(1150, 900, 194, 50);
				lista5.setBounds(1360, 900, 280, 50);
				icono5.setBounds(1650, 830, 194, 194);
				fondoEquipo5.setBounds(1010, 825, 850, 200);

			}

		}

		// boton para eliminar equipos
		if (e.getSource().equals(Eliminar)) {
			Sonidos.playEnter();
			if (num == 1 || num == 2) {
				num -= 1;
			}
			if (num == 0) {
				equipo4.setBounds(0, 0, 0, 0);
				nombre4.setBounds(0, 0, 0, 0);
				lista4.setBounds(0, 0, 0, 0);
				icono4.setBounds(0, 0, 0, 0);
				fondoEquipo4.setBounds(0, 0, 0, 0);

			} else if (num == 1) {
				equipo5.setBounds(0, 0, 0, 0);
				nombre5.setBounds(0, 0, 0, 0);
				lista5.setBounds(0, 0, 0, 0);
				icono5.setBounds(0, 0, 0, 0);
				fondoEquipo5.setBounds(0, 0, 0, 0);
			}

		}

		// breve explicacion del menu de creacion de equipos
		if (e.getSource().equals(Ayuda)) {
			Sonidos.playEnter();
			JOptionPane.showMessageDialog(this,
					"Crea de 3 a 5 equipos con un nombre y una facción. \nPara empezar pulsa 'Jugar'", "Ayuda",
					JOptionPane.QUESTION_MESSAGE);
		}

		// boton de jugar, guardamos en una lista cada equipo y si el campo nombre esta
		// vacio pedimos que lo rellenen
		if (e.getSource().equals(Jugar)) {
			Sonidos.playEnter();

			if (nombre.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Existen campo(s) vacio(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
				contiene = true;
			} else if (nombre2.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Existen campo(s) vacio(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
				contiene = true;
			} else if (nombre3.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Existen campo(s) vacio(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
				contiene = true;
			} else if (nombre4.getText().equals("") && nombre4.getHeight() != 0) {
				JOptionPane.showMessageDialog(this, "Existen campo(s) vacio(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
				contiene = true;
			} else if (nombre5.getText().equals("") && nombre5.getHeight() != 0) {
				JOptionPane.showMessageDialog(this, "Existen campo(s) vacio(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
				contiene = true;
			} else {

				// comprobamos que no se repitan nombres
				if (!nombres.contains(nombre.getText())) {

					nombres.add(nombre.getText());
				} else {
					contiene = true;
				}
				if (!nombres.contains(nombre2.getText())) {

					nombres.add(nombre2.getText());
				} else {
					contiene = true;
				}
				if (!nombres.contains(nombre3.getText())) {

					nombres.add(nombre3.getText());
				} else {
					contiene = true;
				}

				if (nombre4.getHeight() != 0) {

					if (!nombres.contains(nombre4.getText())) {

						nombres.add(nombre4.getText());
					} else {
						contiene = true;
					}
				}

				if (nombre5.getHeight() != 0) {
					if (!nombres.contains(nombre5.getText())) {

						nombres.add(nombre5.getText());
					} else {
						contiene = true;
					}
				}
			}
			if (!contiene) {
				String s1 = (String) lista.getSelectedItem();

				switch (s1) {
				case "The Kings":
					TheKings n = new TheKings(nombre.getText(), 1);
					Recursos.listaJugador.add(n);
					break;
				case "Brotherhood of Steel":
					BoS r = new BoS(nombre.getText(), 2);
					Recursos.listaJugador.add(r);
					break;
				case "The Enclave":
					Enclave a = new Enclave(nombre.getText(), 3);
					Recursos.listaJugador.add(a);
					break;
				case "Caesar's Legion":
					Caesar g = new Caesar(nombre.getText(), 4);
					Recursos.listaJugador.add(g);
					break;
				case "New California Republic":
					NCR p = new NCR(nombre.getText(), 5);
					Recursos.listaJugador.add(p);
					break;
				}

				String s2 = (String) lista2.getSelectedItem();

				switch (s2) {
				case "The Kings":
					TheKings n = new TheKings(nombre2.getText(), 1);
					Recursos.listaJugador.add(n);
					break;
				case "Brotherhood of Steel":
					BoS r = new BoS(nombre2.getText(), 2);
					Recursos.listaJugador.add(r);
					break;
				case "The Enclave":
					Enclave a = new Enclave(nombre2.getText(), 3);
					Recursos.listaJugador.add(a);
					break;
				case "Caesar's Legion":
					Caesar g = new Caesar(nombre2.getText(), 4);
					Recursos.listaJugador.add(g);
					break;
				case "New California Republic":
					NCR p = new NCR(nombre2.getText(), 5);
					Recursos.listaJugador.add(p);
					break;
				}

				String s3 = (String) lista3.getSelectedItem();

				switch (s3) {
				case "The Kings":
					TheKings n = new TheKings(nombre3.getText(), 1);
					Recursos.listaJugador.add(n);
					break;
				case "Brotherhood of Steel":
					BoS r = new BoS(nombre3.getText(), 2);
					Recursos.listaJugador.add(r);
					break;
				case "The Enclave":
					Enclave a = new Enclave(nombre3.getText(), 3);
					Recursos.listaJugador.add(a);
					break;
				case "Caesar's Legion":
					Caesar g = new Caesar(nombre3.getText(), 4);
					Recursos.listaJugador.add(g);
					break;
				case "New California Republic":
					NCR p = new NCR(nombre3.getText(), 5);
					Recursos.listaJugador.add(p);
					break;
				}

				if (lista4.getHeight() != 0) {
					String s4 = (String) lista4.getSelectedItem();

					switch (s4) {
					case "The Kings":
						TheKings n = new TheKings(nombre4.getText(), 1);
						Recursos.listaJugador.add(n);
						break;
					case "Brotherhood of Steel":
						BoS r = new BoS(nombre4.getText(), 2);
						Recursos.listaJugador.add(r);
						break;
					case "The Enclave":
						Enclave a = new Enclave(nombre4.getText(), 3);
						Recursos.listaJugador.add(a);
						break;
					case "Caesar's Legion":
						Caesar g = new Caesar(nombre4.getText(), 4);
						Recursos.listaJugador.add(g);
						break;
					case "New California Republic":
						NCR p = new NCR(nombre4.getText(), 5);
						Recursos.listaJugador.add(p);
						break;
					}
				}
				if (lista5.getHeight() != 0) {
					String s5 = (String) lista5.getSelectedItem();

					switch (s5) {
					case "The Kings":
						TheKings n = new TheKings(nombre5.getText(), 1);
						Recursos.listaJugador.add(n);
						break;
					case "Brotherhood of Steel":
						BoS r = new BoS(nombre5.getText(), 2);
						Recursos.listaJugador.add(r);
						break;
					case "The Enclave":
						Enclave a = new Enclave(nombre5.getText(), 3);
						Recursos.listaJugador.add(a);
						break;
					case "Caesar's Legion":
						Caesar g = new Caesar(nombre5.getText(), 4);
						Recursos.listaJugador.add(g);
						break;
					case "New California Republic":
						NCR p = new NCR(nombre5.getText(), 5);
						Recursos.listaJugador.add(p);
						break;
					}
				}

				JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);
				evento.remove(this);
				evento.add(new EventoPartida());
				evento.setVisible(true);

			} else {
				// printamos error y limpiamos lista
				JOptionPane.showMessageDialog(this, "Error nombre(s) repetido(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
				contiene = false;
			}
			nombres.clear();
		}
		Anadir.setEnabled(num < 2);
		Eliminar.setEnabled(num > 0);
	}
}
