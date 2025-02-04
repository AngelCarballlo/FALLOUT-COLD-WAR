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

import Utils.Sonidos;

public class Evento_3 extends JPanel implements ActionListener{

	private JButton jbAtras;
	private JLabel background = new JLabel();
	
	
	public Evento_3() {
		
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
		
		//fondo
		background.setIcon(new ImageIcon("src/fondos/PantallaAyuda.png"));
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
