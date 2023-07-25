/**
 * Artikel.java
 * 01.01.2019
 */
package oopAuftragsVerwV1;

/**
 * @author stk Kurzbeschreibung: Verwaltet die Daten eines Artikels
 */
public class Artikel
{
	// Anfang Attribute
	private int iArtikelNr;
	private String sBezeichnung;
	private String sArtikelgruppe;
	private double dVerkaufsPreis;
	private double dLagerbestand;
	private double dMindestbestand;
	private double dMittlEinstPreis;
	// Ende Attribute

	// Konstruktoren
	public Artikel()
	{
		this.sBezeichnung = "-leer-";
		this.iArtikelNr = 0;
		this.dLagerbestand = 0;
		this.dMindestbestand = 0;
		this.dMittlEinstPreis = 0.0;
		this.dVerkaufsPreis = 0.0;
	}

	public Artikel(int iArtikelNr, String sBez, double dVerkaufsPreis)
	{
		this.iArtikelNr = iArtikelNr;
		this.sBezeichnung = sBez;
		this.dVerkaufsPreis = dVerkaufsPreis;
	}

	// Anfang Methoden
	public int getINr()
	{
		return this.iArtikelNr;
	}

	public void setINr(int iNr)
	{
		this.iArtikelNr = iNr;
	}

	public String getSBezeichnung()
	{
		return this.sBezeichnung;
	}

	public void setSBezeichnung(String sBezeichnung)
	{
		this.sBezeichnung = sBezeichnung;
	}

	public double getDVerkaufsPreis()
	{
		return this.dVerkaufsPreis;
	}

	public void setDVerkaufsPreis(double dVerkaufsPreis)
	{
		this.dVerkaufsPreis = dVerkaufsPreis;
	}

	public double getDLagerbestand()
	{
		return this.dLagerbestand;
	}

	public void setDLagerbestand(double dLagerbestand)
	{
		this.dLagerbestand = dLagerbestand;
	}

	public double getDMindestbestand()
	{
		return this.dMindestbestand;
	}

	public void setDMindestbestand(double dMindestbestand)
	{
		this.dMindestbestand = dMindestbestand;
	}

	public String getSArtikelgruppe()
	{
		return this.sArtikelgruppe;
	}

	public void setSArtikelgruppe(String sArtikelgruppe)
	{
		this.sArtikelgruppe = sArtikelgruppe;
	}

	public double getDMittlEinstPreis()
	{
		return this.dMittlEinstPreis;
	}

	public void setDMittlEinstPreis(double dMittlEinstPreis)
	{
		this.dMittlEinstPreis = dMittlEinstPreis;
	}

	public String toString()
	{
		return (iArtikelNr + "; " + sBezeichnung + "; " + sArtikelgruppe + "; " 
	            + dVerkaufsPreis +"; " + dMittlEinstPreis + "; " 
				+ dLagerbestand + "; " + dMindestbestand);
	}

	public void erhöhePreis(double dBetrag)
	{
		this.dVerkaufsPreis = this.dVerkaufsPreis + dBetrag;
	}

	public double ermittleGesamtLagerwert()
	{
		return ((int) ((this.dLagerbestand 
				       * this.dMittlEinstPreis) * 100)) / 100.0;
	}

	public boolean bestellen()
	{
		boolean bErgebnis;
		if (dLagerbestand < dMindestbestand) 
			bErgebnis = true;
		else
			bErgebnis = false;
		return bErgebnis;
	}

	// Ende Methoden
}
