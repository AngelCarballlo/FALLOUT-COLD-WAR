package Eventos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Utils.Recursos;
import Utils.Sonidos;

public class Evento_2 extends JPanel implements ActionListener{


	private JTextArea jLInfo;
	private JButton jbAtras;
	private JLabel background = new JLabel();
	
	
	public Evento_2() {
		
		setLayout(null);
		
		jLInfo = new JTextArea(10,30);
		jLInfo.setText("Creado por Angel Carballo Gonzalez \nInspirado en la saga FALLOUT \nangel.carballo.gonzalez@gmail.com\nVersion 1.6 SWING");
		jLInfo.setBounds(680, 300, 700, 500);
		jLInfo.setFont(Recursos.SoleSurvivor2);
		jLInfo.setForeground(Color.black);
		jLInfo.setOpaque(false);
		add(jLInfo);
		
		
		jbAtras = new JButton();
		jbAtras.setBounds(100, 150, 290, 57);
		jbAtras.addActionListener(this);
		jbAtras.setIcon(new ImageIcon("src/botones/Atras.png"));
		jbAtras.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}
		});
		add(jbAtras);
		
		//fondo
		background.setIcon(new ImageIcon("src/fondos/FONDO2.png"));
		background.setBounds(0,0,1920,1080);
		add(background);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		Sonidos.playEnter();
		JFrame evento = (JFrame)SwingUtilities.getWindowAncestor(this);
		evento.remove(this);
		evento.add(new Evento());
		
		evento.setVisible(true);
		
	}
	
	
}
