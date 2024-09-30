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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Utils.Recursos;
import Utils.Sonidos;

public class EventoResumen extends JPanel implements ActionListener {

	private JLabel background = new JLabel();
	private JButton atras;
	private JTextArea resumenRonda = new JTextArea(10, 30);
	private JScrollPane Panel = new JScrollPane(resumenRonda);
	
	public EventoResumen() {
		
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
		
		resumenRonda.setEditable(false);
		resumenRonda.setFont(Recursos.SoleSurvivor);
		resumenRonda.setForeground(Color.WHITE);
		resumenRonda.setBackground(new Color(0,31,2));
		Panel.setBounds(700, 350, 500, 350);
		add(Panel);
		
		resumenRonda.append(EventoPartida.resumen);
		resumenRonda.setCaretPosition(resumenRonda.getDocument().getLength());
		
		background.setIcon( new ImageIcon("src/fondos/fondoRESUMEN.png"));
		background.setBounds(0,0,1920,1080);
		add(background);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EventoPartida.resumen = "";
		Sonidos.playEnter();
		JFrame evento = (JFrame)SwingUtilities.getWindowAncestor(this);
		evento.remove(this);
		evento.add(new EventoPartida());
		evento.setVisible(true);
	}
	
}

