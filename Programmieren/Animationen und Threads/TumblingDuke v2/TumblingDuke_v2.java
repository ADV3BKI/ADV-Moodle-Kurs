/**
 * TumblingDuke_v2.java
 * 16.06.2020
 */
package guiAnimation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author kds
 *
 *
 * Kurzbeschreibung:
 */
public class TumblingDuke_v2
{

	private JFrame frame;
	private MyPanel pnlGraphik;
	// array vom Typ Image zur Speicherung der Adressen der 17 Einzelbilder
	private Image bilder[] = new Image[17];


	/**
	 * Launch the application.
	 * main Method created by Window Builder
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TumblingDuke_v2 window = new TumblingDuke_v2();
					window.frame.setSize(200,200);
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TumblingDuke_v2()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pnlGraphik = new MyPanel();
		this.frame.getContentPane().add(pnlGraphik);
		
		for (int i = 1; i <= 17; i++)
		{
			// Bilder im Ordner 'TumblingDuke', der sich im gleichen Verzeichnis
			// wie die .class-Datei befindet, also im bin-Ordner des Projekts (Windows-Explorer)
			// Dateinamen: T1.gif, T2.gif, ..., T17.gif
			// in Tabelle speichern: Adresse von T1.gif ==> bilder[0],... usw.
			
			try	// die Methode 'read' von 'ImageIO' verlangt eine sog. "Ausnahmebehandlung" (try-catch)
			{
				bilder[i - 1] = ImageIO.read(getClass().getResource("./TumblingDuke/T" + i + ".gif"));
				// getClass() liefert das Verzeichnis, wo die .class-Dateien des Projekt gespeichert
				// sind, also den bin-Ordner. Dort gibt es als Unterverzeichnis "TumblingDuke", worin
				// sich die Bild-Dateien befinden
			}
			catch (IOException e)
			{
				e.getMessage();		// ==> Fehlernachricht wird im Konsolenfenster angezeigt
			}
		}

		
	}
	
	private class MyPanel extends JPanel
	{
		private boolean bGestartet = false;
		
		public void paint(Graphics g)
		{
			super.paint(g);  // löschen der Zeicheneben
			setBackground(Color.white);
			// Da die paint Methode mehrfach gestartet wird 
			// (z.B. nachdem das Fenster verdeckt war und wieder erscheint)
			// muss verhindert werden, dass jedesmal ein neuer Thread gestartet wird
			if (!this.bGestartet)  
			{
				// Die Animation wird in eigenem Thread ausgeführt
				MeinThread meinTread = new MeinThread();
				meinTread.start();
				this.bGestartet = true;
			}
		}
		
		class MeinThread extends Thread
		{
			public void run()
			{
				int pos = 0; 						// Indexzähler für array
				int pauseNachAnimation = 2000; 		// Pause von 2000 Milli-Sekunden, d.h. 2 Sek.
				int pauseNachBild = 100; 			// Pause von 0,1 Sek. nach Einzelbild
				Graphics g = getGraphics();         // Da Animation nicht direkt in paint() läuft
				                                    // muss das Graphics Objekt ermittelt werden

				for (int i = 0;; i++) // Endlosschleife
				{
					// falls Sequenz fertig angezeigt wurde => Wdh.!
					if (pos > 16) pos = 0;
					g.drawImage(bilder[pos], 50, 50, pnlGraphik); 
					// this: Verweis auf Container, in dem die Animation abläuft

					// der Aufruf der folgenden Methode 'Thread.sleep' löst eine Unterbrechung aus, sonst
					// würden die Bilder viel zu schnell hintereinander ablaufen, das Auge könnte die 
					// Animation in dieser Geschwindigkeit überhaupt nicht wahrnehmen.
					// Diese Unterbrechung braucht auch eine sog. "Ausnahmebehandlung" die aber hier - 
					// der Einfachheit halber - keinen Fehler anzeigen soll, deshalb {} in catch.
					if (pos == 16) pause(pauseNachBild + pauseNachAnimation);
					else pause(pauseNachBild);
					pos++;
				}
			}
			
			// Methode, um mehrmalige Codierung von try/catch zu vermeiden
			public void pause(int zeit)
			{
				try
				{
					Thread.sleep(zeit);
				}
				catch (InterruptedException e)
				{
				}
			}

		}
		
	}

}
