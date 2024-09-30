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

public class EventoEmpate extends JPanel implements ActionListener {

	private JLabel background = new JLabel();
	private JButton atras;
	
	public EventoEmpate(){
		
		setLayout(null);
		
		//boton para volver al menu
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
		
		//fondo
		background.setIcon( new ImageIcon("src/fondos/empate.png"));
		background.setBounds(0,0,1920,1080);
		add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Sonidos.playEnter();
		JFrame evento = (JFrame)SwingUtilities.getWindowAncestor(this);
		evento.remove(this);
		evento.add(new Evento());
		
		evento.setVisible(true);
	}
}
