/**
 * WaehrungsGUI_Gb.java
 * 08.03.2019
 */
package guiApps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author stk
 *
 *
 * Kurzbeschreibung:
 */
public class WaehrungsGUI_Gb
{

	private JFrame frmMeineErsteApp;
	private JFormattedTextField txtEuro;
	private JTextField txtDollar;
	private WaehrungsRechner meinRechner = new WaehrungsRechner(1.12, 100);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					WaehrungsGUI_Gb window = new WaehrungsGUI_Gb();
					window.frmMeineErsteApp.pack();
					window.frmMeineErsteApp.setVisible(true);
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
	public WaehrungsGUI_Gb()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmMeineErsteApp = new JFrame();
		frmMeineErsteApp.setTitle("Meine erste App");
		frmMeineErsteApp.setBounds(100, 100, 450, 300);
		frmMeineErsteApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlTitel = new JPanel();
		frmMeineErsteApp.getContentPane().add(pnlTitel, BorderLayout.NORTH);
		
		JLabel lblWhrungsrechner = new JLabel("Währungsrechner");
		pnlTitel.add(lblWhrungsrechner);
		
		JPanel pnlEinAusgabe = new JPanel();
		frmMeineErsteApp.getContentPane().add(pnlEinAusgabe, BorderLayout.CENTER);
		pnlEinAusgabe.setLayout(new GridLayout(0, 3, 0, 20));
		
		JLabel lblEuro = new JLabel("Euro");
		lblEuro.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEinAusgabe.add(lblEuro);
		
		//txtEuro = new JTextField();
		txtEuro = new JFormattedTextField(NumberFormat.getNumberInstance());
		pnlEinAusgabe.add(txtEuro);
		txtEuro.setValue(new Double(100));
		txtEuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				berechne();
			}
		});
		txtEuro.setColumns(10);
		
		JLabel lblWEuro = new JLabel(" €");
		pnlEinAusgabe.add(lblWEuro);
		
		JLabel lblDollar = new JLabel("Dollar");
		lblDollar.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEinAusgabe.add(lblDollar);
		
		txtDollar = new JTextField();
		txtDollar.setEditable(false);
		pnlEinAusgabe.add(txtDollar);
		txtDollar.setColumns(10);
		
		JLabel lblWDollar = new JLabel(" $");
		pnlEinAusgabe.add(lblWDollar);
		
		JPanel pnlButtons = new JPanel();
		frmMeineErsteApp.getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				berechne();
			}
		});
		pnlButtons.add(btnBerechnen);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		pnlButtons.add(btnBeenden);
		
	}
	
	private void berechne()
	{
		double dEuro = ((Number)txtEuro.getValue()).doubleValue();
		//double dEuro = Double.parseDouble(txtEuro.getText());
		
		double dDollar;
		
		dDollar = meinRechner.berechneZielBetrag(dEuro, 1.12);
		
		txtDollar.setText(String.format("%7.2f", dDollar));
		
	}


}
