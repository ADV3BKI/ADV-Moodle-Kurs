/**
 * ArrayTools.java
 * 09.01.2019
 */
package oopArrayAufg;

/**
 * @author stk
 *
 *
 *         Kurzbeschreibung:
 */
public class ArrayTools
{
	public static int sucheSequenziell(int[] aiListe, int iVonInd, int iBisInd, int iSuchwert)
	{
		int iInd = -1;

		if (iVonInd >= 0 && iVonInd <= iBisInd && iBisInd <= aiListe.length - 1)
		{
			iInd = iVonInd;
			while (iInd <= iBisInd && aiListe[iInd] != iSuchwert)
			{
				iInd++;
			}
		}

		if (iInd > iBisInd)
			iInd = -1;

		return iInd;
	}

	public static int sucheBinaer(int[] aiListe, int iVonInd, int iBisInd, int iSuchwert)
	{
		int iInd = -1;  // -1 bedeutet iSuchwert noch nicht gefunden
		int iMitte;

		if (iVonInd >= 0 && iBisInd <= aiListe.length - 1)
		{
			while (iVonInd <= iBisInd && iInd == -1)
			{
				iMitte = (iVonInd + iBisInd) / 2;
				if (iSuchwert < aiListe[iMitte]) // links weitersuchen
				{
					iBisInd = iMitte - 1;
				}
				else
					if (iSuchwert > aiListe[iMitte]) // rechts weitersuchen
					{
						iVonInd = iMitte + 1;
					}
					else
					{
						iInd = iMitte; // gefunden
					}
			} 
		}
		return iInd;
	}

	public static int bestimmeMaxWert(int[] aiListe, int iVonInd, int iBisInd)
	{
		int iMax = 0;

		if (iVonInd >= 0 && iVonInd <= iBisInd && iBisInd <= aiListe.length - 1)
		{
			iMax = aiListe[iVonInd];
			for (int i = iVonInd + 1; i <= iBisInd; i++)
			{
				if (aiListe[i] > iMax)
				{
					iMax = aiListe[i];
				}
			}
		}
		return iMax;
	}

	public static int bestimmeMinWert(int[] aiListe, int iVonInd, int iBisInd)
	{
		int iMin = 0;

		if (iVonInd >= 0 && iVonInd <= iBisInd && iBisInd <= aiListe.length - 1)
		{
			iMin = aiListe[iVonInd];
			for (int i = iVonInd + 1; i <= iBisInd; i++)
			{
				if (aiListe[i] < iMin)
				{
					iMin = aiListe[i];
				}
			}
		}
		return iMin;
	}

	public static void sortiereZahlen(int[] aiListe, int iVonInd, int iBisInd)
	{
		int k, iHilf;
		boolean bMerker;

		do
		{
			bMerker = false;
			for (k = iVonInd; k <= iBisInd - 1; k++)
			{
				if (aiListe[k] > aiListe[k + 1])
				{
					iHilf = aiListe[k];
					aiListe[k] = aiListe[k + 1];
					aiListe[k + 1] = iHilf;
					bMerker = true;
				}
			}
			iBisInd--;

		} while (bMerker);
	}

}
