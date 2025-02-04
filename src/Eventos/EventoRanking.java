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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Utils.Ganadores;
import Utils.Recursos;
import Utils.Sonidos;

public class EventoRanking extends JPanel implements ActionListener {

	JButton jbAtras;
	JLabel background = new JLabel();
	JTextArea Ranking = new JTextArea(10,30);
	
	public EventoRanking() {
		setLayout(null);

		jbAtras = new JButton();
		jbAtras.setBounds(100, 100, 290, 57);
		jbAtras.addActionListener(this);
		jbAtras.setIcon(new ImageIcon("src/botones/Atras.png"));
		add(jbAtras);
		jbAtras.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				Sonidos.play();
			}
		});
		
		Ranking.setText(Ganadores.leerGanadores());
		Ranking.setBounds(860,400,200,700);
		Ranking.setFont(Recursos.SoleSurvivor2);
		Ranking.setForeground(Color.WHITE);
		Ranking.setOpaque(false);
		Ranking.setEditable(false);
		add(Ranking);
		
		background.setIcon(new ImageIcon("src/fondos/ranking.png"));
		background.setBounds(0,0,1920,1080);
		add(background);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Sonidos.playEnter();
		// TODO Auto-generated method stub
		JFrame evento = (JFrame)SwingUtilities.getWindowAncestor(this);
		evento.remove(this);
		evento.add(new Evento());
		evento.setVisible(true);
	}

}
