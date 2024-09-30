import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Eventos.Evento;

public class Ventana extends JFrame{

	public Ventana() {
		
		setTitle("Fallout Coldwar");
		setBounds(0, 0, 1920, 1080);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Image icon = new ImageIcon("src/iconos/kings2.png").getImage();
		
		this.setIconImage(icon); 
		
		add(new Evento());

		setVisible(true);
	}
	
	
}
