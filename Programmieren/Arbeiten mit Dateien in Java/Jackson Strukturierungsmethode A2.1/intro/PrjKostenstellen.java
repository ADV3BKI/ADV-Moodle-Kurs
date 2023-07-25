/**
 * PrjArtikelbestand_alt.java
 * 13.05.2019
 */
package dateienDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author stk
 *
 *
 *         Kurzbeschreibung:
 */
public class PrjKostenstellen
{
	private final int iSpalte1 = 10;  // Spaltenbreiten zentral festgelegt
	private final int iSpalte2 = 11;
	private final int iSpalte3 = 12;

	private int iKstAlt = -1;
	private int iKst;
	private int iPnr;
	private double dGehalt;
	private double dGesamtSumme = 0;
	private double dKstSumme = 0;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;

	private void schreibeKopf() throws IOException
	{
		String sZeile = null;
		String sFormat;
		sFormat = String.format("%%-%ds%%-%ds%%-%ds", iSpalte1, iSpalte2, iSpalte3);
		// sFormat = "%-10s%-15s%-10s"  --> wenn die Spaltenbreiten geändert werden
		//                                 ändert sich automatisch der Formatstring
		// Das '-' in %-10s bewirkt, dass String linksbündig ausgegeben wird
		sZeile = String.format(sFormat, "Kosten-", "Pers.-", "Gehalt");
		writer.write(sZeile);
		writer.newLine();
		sZeile = String.format(sFormat, "stelle", "Nr.", "");
		writer.write(sZeile);
		writer.newLine();
		writer.newLine();
	}

	private boolean leseZeile() throws IOException
	{
		boolean status = true; // Datensatz erfolgreich gelesen
		String sZeile;
		String sZeilenTeile[];

		sZeile = reader.readLine();

		if (sZeile != null)
		{
			sZeilenTeile = sZeile.split("[ \t]+");
			// Das '+' in "[ \t]+" bewirkt, dass auch eine Folge von
			// Leerzeichen oder <Tab> als Trennzeichen gelten

			this.iKst = Integer.parseInt(sZeilenTeile[0]);
			this.iPnr = Integer.parseInt(sZeilenTeile[1]);
			this.dGehalt = Double.parseDouble(sZeilenTeile[2]);
		}
		else
		{
			status = false;
		}
		return status;
	}
	
	private void gruppenAnfang() throws IOException
	{
		this.iKstAlt = this.iKst;
		this.dKstSumme = 0;
		// this.writer.write("Kostenstelle: " + this.iKst);
		this.writer.newLine();
	}

	private void gruppenEnde() throws IOException
	{
		String sZeile = null;
		String sFormat;
		String sZeilenkopf = "Summe Kst: ";

		sFormat = String.format(sZeilenkopf + "%%%d.2f", iSpalte1 + iSpalte2 + iSpalte3 - sZeilenkopf.length());
		sZeile = String.format(sFormat, this.dKstSumme);
		this.writer.write(sZeile);
		this.writer.newLine();
		this.writer.newLine();
	}
	
	private void dateiEnde() throws IOException
	{
		String sZeile = null;
		String sFormat;
		String sZeilenkopf = "Gesamtsumme: ";

		sFormat = String.format(sZeilenkopf + "%%%d.2f", iSpalte1 + iSpalte2 + iSpalte3 - sZeilenkopf.length());
		sZeile = String.format(sFormat, this.dGesamtSumme);
		this.writer.write(sZeile);
	}


	private void verarbeiteZeile() throws IOException
	{
		String sZeile = null;
		String sFormat;

		this.dKstSumme = this.dKstSumme + this.dGehalt;
		sFormat = String.format("%%-%dd%%-%dd%%%d.2f", iSpalte1, iSpalte2, iSpalte3);
		sZeile = String.format(sFormat, this.iKst, this.iPnr, this.dGehalt);
		this.writer.write(sZeile);
		this.writer.newLine();

		this.dGesamtSumme = dGesamtSumme + dGehalt;
	}

	public void kstAbrechnung()
	{
		Path dateiPfadIn = null;
		Path dateiPfadOut = null;
		boolean gelesen;

		dateiPfadIn = Paths.get("./Dateien/ePers.txt");
		dateiPfadOut = Paths.get("./Dateien/prjKosten.txt");

		try (BufferedReader reader = Files.newBufferedReader(dateiPfadIn, StandardCharsets.UTF_8);
				BufferedWriter writer = Files.newBufferedWriter(dateiPfadOut, StandardCharsets.UTF_8,
						StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING))
		{
			this.reader = reader;
			this.writer = writer;

			this.schreibeKopf();
			this.dGesamtSumme = 0;

			gelesen = this.leseZeile();

			while (gelesen)
			{
				gruppenAnfang();
				
				do
				{
					this.verarbeiteZeile();
					gelesen = this.leseZeile();
				} while (gelesen && this.iKst == this.iKstAlt);
				
				this.gruppenEnde();
			}
			
			this.dateiEnde();
		}
		catch (IOException oe)
		{
			System.out.println("Fehler beim Öffnen der Datei: " + oe.getMessage());
		}
	}

	/**
	 * @param args
	 *            Kurzbeschreibung:
	 */
	public static void main(String[] args)
	{
		PrjKostenstellen eineListe = new PrjKostenstellen();

		eineListe.kstAbrechnung();

	}

}
