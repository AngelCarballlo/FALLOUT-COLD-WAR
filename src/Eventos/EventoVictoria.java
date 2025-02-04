package Eventos;

import java.awt.Color;
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

import Utils.Recursos;
import Utils.Sonidos;

public class EventoVictoria extends JPanel implements ActionListener {

	private JLabel background = new JLabel();
	private JLabel texto;
	private JLabel icono = new JLabel();
	private JButton atras;
	
	public EventoVictoria() {
		
		setLayout(null);
		
		atras = new JButton();
		atras.setBounds(100, 150, 290, 57);
		atras.addActionListener(this);
		atras.setIcon(new ImageIcon("src/botones/Atras.png"));
		atras.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}
		});
		add(atras);
		
		texto = new JLabel(""+Recursos.ganador.get(0).getNombre());
		texto.setForeground(Color.BLACK);
		texto.setFont(Recursos.SoleSurvivor);
		texto.setBounds(910,650,200,200);
		add(texto);
		
		switch (Recursos.ganador.get(0).getTipo()) {
		case 1:
			icono.setIcon(new ImageIcon("src/iconos/Kings2.png"));
			break;
		case 2:
			icono.setIcon(new ImageIcon("src/iconos/BoS2.png"));
			break;
		case 3:
			icono.setIcon(new ImageIcon("src/iconos/Enclave2.png"));
			break;
		case 4:
			icono.setIcon(new ImageIcon("src/iconos/cesar2.png"));
			break;
		case 5:
			icono.setIcon(new ImageIcon("src/iconos/NCR2.png"));
			break;
		}
		
		icono.setBounds(860,300,194,194);
		add(icono);
		background.setIcon( new ImageIcon("src/fondos/VENCEDOR.png"));
		background.setBounds(0,0,1920,1080);
		add(background);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Recursos.ganador.clear();
		Sonidos.playEnter();
		JFrame evento = (JFrame)SwingUtilities.getWindowAncestor(this);
		evento.remove(this);
		evento.add(new Evento());
		evento.setVisible(true);
	}
	
}
