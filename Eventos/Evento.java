package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ClasePadre.Jugador;
import Tipos.Enclave;
import Utils.Sonidos;

public class Evento extends JPanel implements ActionListener {

	private JLabel background = new JLabel();

	private JButton Ranking;

	private JButton Jugar;

	private JButton Creditos;

	private JButton Ajustes;

	private JButton Salir;

	private JButton musica;

	private boolean on = true;

	public Evento() {

		setLayout(null);
		
		Sonidos.pararMusica();
		
		// jbutton Jugar
		Jugar = new JButton();

		Jugar.setBounds(770, 620, 290, 57);

		Jugar.setIcon(new ImageIcon("src/botones/Jugar.png"));

		Jugar.addActionListener(this);

		Jugar.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}
		});

		add(Jugar);

		//boton para encender y apagar musica
		musica = new JButton();

		musica.setBounds(1800, 920, 50, 50);
		
		musica.setIcon(new ImageIcon("src/fondos/musicaON.png"));

		musica.addActionListener(this);

		add(musica);

		// boton creditos
		Creditos = new JButton();

		Creditos.setBounds(770, 700, 290, 57);

		Creditos.setIcon(new ImageIcon("src/botones/creditos.png"));

		Creditos.addActionListener(this);

		Creditos.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}

		});

		add(Creditos);

		// boton reglas
		Ajustes = new JButton();

		Ajustes.setBounds(770, 780, 290, 57);

		Ajustes.setIcon(new ImageIcon("src/botones/Ajustes.png"));

		Ajustes.addActionListener(this);

		Ajustes.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}
		});

		add(Ajustes);

		// boton ranking
		Ranking = new JButton();

		Ranking.setBounds(770, 860, 290, 57);

		Ranking.setIcon(new ImageIcon("src/botones/Ranking.png"));

		Ranking.addActionListener(this);

		Ranking.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}
		});

		add(Ranking);

		// boton para salir
		Salir = new JButton();

		Salir.setBounds(770, 940, 290, 57);

		Salir.setIcon(new ImageIcon("src/botones/Salir.png"));

		Salir.addActionListener(this);

		Salir.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}

		});

		add(Salir);

		Sonidos.playMusica1();
		// fondo
		background.setIcon(new ImageIcon("src/fondos/FONDOYBOTONES.png"));
		background.setBounds(0, 0, 1920, 1080);
		add(background);
	}

	public void actionPerformed(ActionEvent e) {

		Sonidos.playEnter();

		if (e.getSource().equals(Jugar)) {

			JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);

			evento.remove(this);
			evento.add(new EventoEquipos());

			evento.setVisible(true);
		}

		if (e.getSource().equals(Creditos)) {

			JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);

			evento.remove(this);
			evento.add(new Evento_2());

			evento.setVisible(true);
		}

		if (e.getSource().equals(Ajustes)) {

			JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);

			evento.remove(this);
			evento.add(new Evento_3());

			evento.setVisible(true);
		}

		if (e.getSource().equals(Ranking)) {
			JFrame evento = (JFrame) SwingUtilities.getWindowAncestor(this);

			evento.remove(this);
			evento.add(new EventoRanking());

			evento.setVisible(true);
		}

		if (e.getSource().equals(Salir)) {

			System.exit(0);
		}

		if (e.getSource().equals(musica)) {

			if (!on) {
				on=true;
				Sonidos.playMusica1();
				musica.setIcon(new ImageIcon("src/fondos/musicaON.png"));
			} else {
				on=false;
				musica.setIcon(new ImageIcon("src/fondos/musicaOFF.png"));
				Sonidos.pararMusica();
			}
			
		}

	}
}
