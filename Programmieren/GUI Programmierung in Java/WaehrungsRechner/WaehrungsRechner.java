/**
 * WaehrungsRechner.java
 * 07.03.2019
 */
package guiApps;
/**
 * @author stk
 *
 *
 * Kurzbeschreibung:
 */
public class WaehrungsRechner
{
	private double dKurs;
	private double dEuroBetrag;
	
	public WaehrungsRechner(double dKurs, double dEuroBetrag)
	{
		super();
		this.dKurs = dKurs;
		this.dEuroBetrag = dEuroBetrag;
	}
	
	public double berechneZielBetrag(double dEuroBetrag, double dKurs)
	{
		this.dEuroBetrag = dEuroBetrag;
		this.dKurs = dKurs;
		return dEuroBetrag * dKurs;
	}

	public double getdKurs()
	{
		return this.dKurs;
	}

	public double getdEuroBetrag()
	{
		return this.dEuroBetrag;
	}
}
