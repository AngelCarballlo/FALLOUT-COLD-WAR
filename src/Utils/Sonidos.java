package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonidos {
	private final static File sonidoHover = new File(
			FileSystems.getDefault().getPath("").toAbsolutePath() + "/src/sonidos/SonidoMenu.wav");

	private final static File sonidoEnter = new File(
			FileSystems.getDefault().getPath("").toAbsolutePath() + "/src/sonidos/SonidoEnter.wav");

	private final static File musicaFallout1 = new File(
			FileSystems.getDefault().getPath("").toAbsolutePath() + "/src/sonidos/musicaFallout1.wav");
	
	private final static File musicaFallout2 = new File(
			FileSystems.getDefault().getPath("").toAbsolutePath() + "/src/sonidos/musicaFallout2.wav");

	public static Clip clip;
	
	public static Clip musica;

	private static AudioInputStream audioInputStream;

	public static void play() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(sonidoHover);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void playEnter() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(sonidoEnter);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void playMusica1() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(musicaFallout1);
			musica = AudioSystem.getClip();
			musica.open(audioInputStream);
			musica.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void playMusica2() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(musicaFallout2);
			musica = AudioSystem.getClip();
			musica.open(audioInputStream);
			musica.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void pararMusica() {
		try {
		musica.stop();
		} catch (NullPointerException e) {
			System.out.println("no hay musica puesta");
		}
	}

}
